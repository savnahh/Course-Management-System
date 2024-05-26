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

public class DeleteStudent extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField stdID;
    private JButton btnDel3;
    private JComboBox<String> comboBox;
    private JTextField StudName;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    
    Database e = new Database();
    public DeleteStudent() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/image/top.png")));
        setBounds(600, 200, 530, 431);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(AddCourse.class.getResource("/image/frontP.png")));
        lblNewLabel.setBounds(0, 6, 68, 55);
        contentPane.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("DELETE STUDENT\r\n");
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
        Studname.setBounds(89, 110, 110, 22);
        panel.add(Studname);
        Studname.setForeground(new Color(0, 0, 0));
        Studname.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        StudName = new JTextField();
        StudName.setForeground(Color.BLACK);
        StudName.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        StudName.setColumns(10);
        StudName.setBounds(223, 112, 198, 20);
        panel.add(StudName);
        
        JLabel lblCourse = new JLabel("Course:");
        lblCourse.setForeground(Color.BLACK);
        lblCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCourse.setBounds(89, 174, 110, 22);
        panel.add(lblCourse);
        
        comboBox = new JComboBox<String>();
        comboBox.setForeground(Color.BLACK);
        comboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox.setBounds(223, 176, 198, 20);
        panel.add(comboBox);
        comboBox.setModel(new DefaultComboBoxModel<>(new String[] { "--Select--", "BIT", "BIBM"}));
        contentPane.setBackground(new Color(66, 66, 66));
                               
        btnDel3 = new JButton("Delete");
        btnDel3.setBounds(182, 250, 111, 33);
        panel.add(btnDel3);
        btnDel3.addActionListener(this);
        btnDel3.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        btnDel3.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        btnDel3.setBackground(new Color(116, 192, 68));
        btnDel3.setForeground(new Color(45, 45, 45));
                                                
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btnDel3){
        	addCourse();
        }
    }
    public void addCourse() {
    	String ID = stdID.getText();
    	String name = StudName.getText();
    	String cour= comboBox.getSelectedItem().toString();
    	if (ID.isEmpty() && name.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill in all fields.");
		}else if(cour.equals("--Select--")) {
			JOptionPane.showMessageDialog(this, "Please Select Course.");
		}else {
			try {
				if(e.isStudentExist(stdID.getText())){
					JOptionPane.showMessageDialog(this, "Student Exists Already");
				}else {
					db_connect con = new db_connect();
	                String sql = "DELETE FROM student WHERE student_id=?";
	                PreparedStatement s = con.c.prepareStatement(sql);
	                s.setString(1, ID);
	                int rs = s.executeUpdate();
	                if (rs > 0) {
	                    JOptionPane.showMessageDialog(null, "Student Successfully Deleted");
    	                stdID.setText("");
    	                StudName.setText("");
	                }else {
	                    JOptionPane.showMessageDialog(null, "Error in Deleting");
	                }
                  s.close();
				}
			}catch(Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
			}
		}
    }
 }