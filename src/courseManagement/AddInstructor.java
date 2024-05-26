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

public class AddInstructor extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField instructorID;
    private JButton btnAdd1;
    private JComboBox<String> comboBox2;
    private JComboBox<String> comboBox;
    private JComboBox<String> comboBox3;

    public static void main(String[] args) {
        new AddInstructor().setVisible(true);
    }
    Database e = new Database();
    private JTextField InstruName;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    
    public AddInstructor() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/image/top.png")));
        setBounds(600, 200, 530, 431);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(AddCourse.class.getResource("/image/frontP.png")));
        lblNewLabel.setBounds(0, 6, 68, 55);
        contentPane.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("ADD INSTRUCTOR");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(141, 15, 240, 27);
        contentPane.add(lblNewLabel_1);

        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel.setBounds(0, 67, 516, 327);
        contentPane.add(panel);
        panel.setBackground(new Color(217, 217, 217));
        panel.setLayout(null);
        
        JLabel InstructorID = new JLabel("Instructor ID:");
        InstructorID.setBounds(89, 48, 110, 22);
        panel.add(InstructorID);
        InstructorID.setForeground(new Color(0, 0, 0));
        InstructorID.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        instructorID = new JTextField();
        instructorID.setBounds(223, 50, 198, 20);
        panel.add(instructorID);
        instructorID.setForeground(new Color(0, 0, 0));
        instructorID.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        instructorID.setColumns(10);
        
        JLabel Instruname = new JLabel("Name:");
        Instruname.setBounds(89, 92, 110, 22);
        panel.add(Instruname);
        Instruname.setForeground(new Color(0, 0, 0));
        Instruname.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        InstruName = new JTextField();
        InstruName.setForeground(Color.BLACK);
        InstruName.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        InstruName.setColumns(10);
        InstruName.setBounds(223, 94, 198, 20);
        panel.add(InstruName);
        
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
        
        JLabel lblmodule = new JLabel("Module:");
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
                               
        btnAdd1 = new JButton("Add");
        btnAdd1.setBounds(182, 257, 111, 33);
        panel.add(btnAdd1);
        btnAdd1.addActionListener(this);
        btnAdd1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        btnAdd1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        btnAdd1.setBackground(new Color(116, 192, 68));
        btnAdd1.setForeground(new Color(45, 45, 45));
                                                
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btnAdd1){
        	addCourse();
        }
    }
    public void addCourse() {
    	String ID = instructorID.getText();
    	String name = InstruName.getText();
    	String cour= comboBox.getSelectedItem().toString();
    	String leve = comboBox2.getSelectedItem().toString();
    	String modu = comboBox3.getSelectedItem().toString();
    	if (ID.isEmpty() && name.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill in all fields.");
		}else if(cour.equals("--Select--")) {
			JOptionPane.showMessageDialog(this, "Please Select Course.");
		}else if(leve.equals("--Select--")) {
			JOptionPane.showMessageDialog(this, "Please Select Level.");
		}else if(modu.equals("--Select--")) {
			JOptionPane.showMessageDialog(this, "Please Select Module.");
		}
		else {
			try {
				if(e.isInstructorExist(instructorID.getText())){
					JOptionPane.showMessageDialog(this, "Instructor Exists Already");
				}else {
					db_connect con = new db_connect();
	                String sql = "insert into instructor(instructor_id, full_name, course, level, module) values(?, ?, ?, ?, ?)";
	                PreparedStatement s = con.c.prepareStatement(sql);
	                s.setString(1, ID);
	                s.setString(2, name);
	                s.setString(3, cour);
	                s.setString(4, leve);
	                s.setString(5, modu);
	                int rs = s.executeUpdate();
	                if (rs > 0) {
	                    JOptionPane.showMessageDialog(null, "Successfully Added");
    	                instructorID.setText("");
    	                InstruName.setText("");
	                }else {
	                    JOptionPane.showMessageDialog(null, "Error in Adding");
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
            comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {"--Select--", "Introductory Programming and Problem Solving", "Fundamental of Computing", "Academic Skills and Team-Based Learning", "Internet Software and Architecture", "Embedded System Programming", "Computational Mathematics"}));
        }else if("BIT".equals(selectedCourse) && "5".equals(selectedLevel)) {
        	comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {"--Select--", "Concepts and Technologies of AI", "Object-Oriented Design and Programming", "Numerical Methods and Concurrency", "Collaborative Development", "Distributed and Cloud System Programming", "Human - Computer Interaction", "Distributed and Cloud System Programming"}));
        }else if("BIT".equals(selectedCourse) && "6".equals(selectedLevel)) {
        	comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {"Big Data", "High Performance Computing", "Project and Professionalism", "Artificial Intelligence and Machine Learning(OPT)", "Complex Systems(OPT)"}));
        }
        
        if ("BIBM".equals(selectedCourse) && "3".equals(selectedLevel)) {
            comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {"--Select--", "21st Century Management", "Preparing for Success at University", "Principle of Business", "Project Based Learning"}));
        }else if("BIBM".equals(selectedCourse) && "4".equals(selectedLevel)) {
        	comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {"--Select--", "The Digital Business", "The Innovative Business", "The Responsible Business"}));
        }else if("BIBM".equals(selectedCourse) && "5".equals(selectedLevel)) {
        	comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {"--Select--", "The Contemporary Issues in International Business", "Managing Finance and Accounts", "The International HR Professional"}));
        }else if("BIBM".equals(selectedCourse) && "6".equals(selectedLevel)) {
        	comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {"--Select--", "Global Context for Multinational Enterprises", "The Marketing Consultant", "The International HR Professional", "The Professional Project(OPT)", "The Strategic Business(OPT)"}));
        }
    }
 }


