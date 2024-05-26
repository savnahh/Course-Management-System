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

public class DeleteCourse extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField Coursename;
    private JButton btnDelete1;
    private JComboBox<String> comboBox;

    public static void main(String[] args) {
        new AddCourse().setVisible(true);
    }
    Database e = new Database();
    private JTextField Years;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    
    public DeleteCourse() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/image/top.png")));
        setBounds(600, 200, 530, 431);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel.setBounds(0, 67, 516, 327);
        contentPane.add(panel);
        panel.setBackground(new Color(217, 217, 217));
        panel.setLayout(null);
        
        JLabel courseName = new JLabel("Course Name:");
        courseName.setBounds(89, 48, 110, 22);
        panel.add(courseName);
        courseName.setForeground(new Color(0, 0, 0));
        courseName.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        Coursename = new JTextField();
        Coursename.setBounds(223, 50, 198, 20);
        panel.add(Coursename);
        Coursename.setForeground(new Color(0, 0, 0));
        Coursename.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        Coursename.setColumns(10);
        
        JLabel years = new JLabel("Years:");
        years.setBounds(89, 113, 110, 22);
        panel.add(years);
        years.setForeground(new Color(0, 0, 0));
        years.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        Years = new JTextField();
        Years.setForeground(Color.BLACK);
        Years.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        Years.setColumns(10);
        Years.setBounds(223, 115, 198, 20);
        panel.add(Years);
        
        JLabel lblCourseStatus = new JLabel("Course Status:");
        lblCourseStatus.setForeground(Color.BLACK);
        lblCourseStatus.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCourseStatus.setBounds(89, 181, 110, 22);
        panel.add(lblCourseStatus);
        contentPane.setBackground(new Color(66, 66, 66));
        
        comboBox = new JComboBox<>();
        comboBox.setBounds(223, 183, 198, 20);
        panel.add(comboBox);
        comboBox.setModel(new DefaultComboBoxModel<>(new String[] { "--Select--", "Active", "Cancelled"}));
        comboBox.setForeground(new Color(0, 0, 0));
        comboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
                                
        btnDelete1 = new JButton("Delete");
        btnDelete1.setBounds(182, 248, 111, 33);
        panel.add(btnDelete1);
        btnDelete1.addActionListener(this);
        btnDelete1.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        btnDelete1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        btnDelete1.setBackground(new Color(116, 192, 68));
        btnDelete1.setForeground(new Color(45, 45, 45));
        
        lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(AddCourse.class.getResource("/image/frontP.png")));
        lblNewLabel.setBounds(0, 6, 68, 55);
        contentPane.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("DELETE COURSE");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(148, 15, 224, 27);
        contentPane.add(lblNewLabel_1);
                                                
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btnDelete1){
        	addCourse();
        }
    }
    public void addCourse() {
    	String Name = Coursename.getText();
    	String yea = Years.getText();
    	String sta = comboBox.getSelectedItem().toString();
    	if (Name.isEmpty() && yea.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill in all fields.");
		}else if(sta.equals("--Select--")) {
			JOptionPane.showMessageDialog(this, "Please select a status.");
		}else {
			try {
					db_connect con = new db_connect();
	                String sql = "DELETE FROM courses where course_name=?";
	                PreparedStatement s = con.c.prepareStatement(sql);
	                s.setString(1, Name);
	               
	                int rs = s.executeUpdate();
	                if (rs > 0) {
	                    JOptionPane.showMessageDialog(null, "Course '"+Name+"' Deleted!");
    	                Coursename.setText("");
    	                Years.setText("");
	                }else {
	                    JOptionPane.showMessageDialog(null, "Error in Deleting");
	                }
                  s.close();
				}
			catch(Exception ex) {
				ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
			}
		}
    }
    
}
