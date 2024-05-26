package courseManagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class EditStudent extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField stdID;
    private JButton btnEdit3;
    private JComboBox<String> comboBox2;
    private JComboBox<String> comboBox;
    private JComboBox<String> comboBox3;
    private JTextField StudName;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    
    Database e = new Database();
    public EditStudent() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/image/top.png")));
        setBounds(600, 200, 530, 431);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(AddCourse.class.getResource("/image/frontP.png")));
        lblNewLabel.setBounds(0, 6, 68, 55);
        contentPane.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("EDIT STUDENT");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(159, 15, 240, 27);
        contentPane.add(lblNewLabel_1);

        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel.setBounds(0, 67, 516, 327);
        contentPane.add(panel);
        panel.setBackground(new Color(217, 217, 217));
        panel.setLayout(null);
        
        JLabel StudentID = new JLabel("Student ID:");
        StudentID.setBounds(89, 48, 110, 22);
        panel.add(StudentID);
        StudentID.setForeground(new Color(0, 0, 0));
        StudentID.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        stdID = new JTextField();
        stdID.setBounds(223, 50, 198, 20);
        panel.add(stdID);
        stdID.setForeground(new Color(0, 0, 0));
        stdID.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        stdID.setColumns(10);
        
        JLabel Studname = new JLabel("Name:");
        Studname.setBounds(89, 92, 110, 22);
        panel.add(Studname);
        Studname.setForeground(new Color(0, 0, 0));
        Studname.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        StudName = new JTextField();
        StudName.setForeground(Color.BLACK);
        StudName.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        StudName.setColumns(10);
        StudName.setBounds(223, 94, 198, 20);
        panel.add(StudName);
        
        JLabel lblCourse = new JLabel("Course:");
        lblCourse.setForeground(Color.BLACK);
        lblCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCourse.setBounds(89, 132, 110, 22);
        panel.add(lblCourse);
        
        comboBox = new JComboBox<String>();
        comboBox.setForeground(Color.BLACK);
        comboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox.setBounds(223, 134, 198, 20);
        panel.add(comboBox);
        comboBox.setModel(new DefaultComboBoxModel<>(new String[] { "--Select--", "BIT", "BIBM"}));
        comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectLevel();
			}
		});
        
        JLabel lev = new JLabel("Level:");
        lev.setForeground(Color.BLACK);
        lev.setFont(new Font("Tahoma", Font.BOLD, 14));
        lev.setBounds(89, 168, 110, 22);
        panel.add(lev);
        
        comboBox2 = new JComboBox<String>();
        comboBox2.setForeground(Color.BLACK);
        comboBox2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox2.setBounds(223, 170, 198, 20);
        panel.add(comboBox2);
        comboBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modules();
			}
		});
        
        JLabel lblmodule = new JLabel("Semester");
        lblmodule.setForeground(Color.BLACK);
        lblmodule.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblmodule.setBounds(89, 205, 110, 22);
        panel.add(lblmodule);
        contentPane.setBackground(new Color(66, 66, 66));
        
        comboBox3 = new JComboBox<String>();
        comboBox3.setBounds(223, 207, 198, 20);
        panel.add(comboBox3);
        comboBox3.setForeground(new Color(0, 0, 0));
        comboBox3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
                               
        btnEdit3 = new JButton("Edit");
        btnEdit3.setBounds(182, 257, 111, 33);
        panel.add(btnEdit3);
        btnEdit3.addActionListener(this);
        btnEdit3.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        btnEdit3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        btnEdit3.setBackground(new Color(116, 192, 68));
        btnEdit3.setForeground(new Color(45, 45, 45));
                                                
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btnEdit3){
        	addCourse();
        }
    }
    public void addCourse() {
    	String ID = stdID.getText();
    	String name = StudName.getText();
    	String cour= comboBox.getSelectedItem().toString();
    	String leve = comboBox2.getSelectedItem().toString();
    	String sem = comboBox3.getSelectedItem().toString();
    	if (ID.isEmpty() && name.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill in all fields.");
		}else if(cour.equals("--Select--")) {
			JOptionPane.showMessageDialog(this, "Please Select Course.");
		}else if(leve.equals("--Select--")) {
			JOptionPane.showMessageDialog(this, "Please Select Level.");
		}else if(sem.equals("--Select--")) {
			JOptionPane.showMessageDialog(this, "Please Select Module.");
		}
		else {
			try {
				if(e.isStudentExist(stdID.getText())){
					JOptionPane.showMessageDialog(this, "Student Exists Already");
				}else {
					db_connect con = new db_connect();
	                String sql = "UPDATE student SET full_name=?, course=?, level=?, semester=? WHERE student_id=?";
	                PreparedStatement s = con.c.prepareStatement(sql);
	                s.setString(1, name);
	                s.setString(2, cour);
	                s.setString(3, leve);
	                s.setString(4, sem);
	                s.setString(5, ID);
	                int rs = s.executeUpdate();
	                if (rs > 0) {
	                    JOptionPane.showMessageDialog(null, "Student Successfully Updated");
    	                stdID.setText("");
    	                StudName.setText("");
	                }else {
	                    JOptionPane.showMessageDialog(null, "Error in Editing");
	                }
                  s.close();
				}
			}catch(Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
			}
		}
    }
    public void selectLevel() {
    	if ("BIBM".equals(comboBox.getSelectedItem())) {
            comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {"--Select--", "3", "4", "5", "6"}));
        } else if ("BIT".equals(comboBox.getSelectedItem())) {
            comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {"--Select--", "4", "5", "6"}));
        }
    }
    public void Modules() {
    	String selectedCourse = (String)comboBox.getSelectedItem();
        String selectedLevel = (String)comboBox2.getSelectedItem();
        
        if ("BIT".equals(selectedCourse) && "4".equals(selectedLevel)) {
            comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {"--Select", "First", "Second"}));
        }else if("BIT".equals(selectedCourse) && "5".equals(selectedLevel)) {
        	comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {"--Select--", "Third", "Fourth"}));
        }else if("BIT".equals(selectedCourse) && "6".equals(selectedLevel)) {
        	comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {"--Select--", "Fifth", "Sixth"}));
        }
        
        if ("BIBM".equals(selectedCourse) && "3".equals(selectedLevel)) {
            comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {"--Select--", "First", "Second"}));
        }else if("BIBM".equals(selectedCourse) && "4".equals(selectedLevel)) {
        	comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {"--Select--", "Third", "Fourth"}));
        }else if("BIBM".equals(selectedCourse) && "5".equals(selectedLevel)) {
        	comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {"--Select--", "Fifth", "Sixth"}));
        }else if("BIBM".equals(selectedCourse) && "6".equals(selectedLevel)) {
        	comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {"--Select--", "Seventh", "Eigth"}));
        }
    }
 }