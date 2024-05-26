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

public class AddModule extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField moduleId;
    private JButton btnAdd2;
    private JComboBox<String> comboBox;
    private JTextField moduleName;
    private JLabel lblNewLabel_1;
    private JLabel module;
    private JComboBox<String> comboBox2;
    private JLabel lblLev;
    private JComboBox<String> comboBox3;
    private JLabel lblNewLabel_2;
    
    public static void main(String[] args) {
        new AddModule().setVisible(true);
    }
    Database e = new Database();
    public AddModule() {
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
        
        lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.setIcon(new ImageIcon(AddModule.class.getResource("/image/frontP.png")));
        lblNewLabel_2.setBounds(0, 0, 65, 66);
        contentPane.add(lblNewLabel_2);
        
        lblNewLabel_1 = new JLabel("ADD MODULE");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
        lblNewLabel_1.setForeground(new Color(255, 255, 255));
        lblNewLabel_1.setBounds(173, 15, 191, 27);
        contentPane.add(lblNewLabel_1);
        
        module = new JLabel("Module ID:");
        module.setForeground(Color.BLACK);
        module.setFont(new Font("Tahoma", Font.BOLD, 14));
        module.setBounds(89, 35, 110, 22);
        panel.add(module);
        
        moduleId = new JTextField();
        moduleId.setBounds(223, 37, 198, 20);
        panel.add(moduleId);
        moduleId.setForeground(new Color(0, 0, 0));
        moduleId.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        moduleId.setColumns(10);
        
        JLabel courseName = new JLabel("Name:");
        courseName.setBounds(89, 80, 110, 22);
        panel.add(courseName);
        courseName.setForeground(new Color(0, 0, 0));
        courseName.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        moduleName = new JTextField();
        moduleName.setForeground(Color.BLACK);
        moduleName.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        moduleName.setColumns(10);
        moduleName.setBounds(223, 82, 198, 20);
        panel.add(moduleName);
        
        JLabel type = new JLabel("Type:");
        type.setBounds(89, 120, 110, 22);
        panel.add(type);
        type.setForeground(new Color(0, 0, 0));
        type.setFont(new Font("Tahoma", Font.BOLD, 14));
        
        comboBox = new JComboBox<String>();
        comboBox.setBounds(223, 122, 198, 20);
        panel.add(comboBox);
        comboBox.setModel(new DefaultComboBoxModel<>(new String[] { "--Select--", "core", "optional"}));
        comboBox.setForeground(new Color(0, 0, 0));
        comboBox.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        
        JLabel lblCourseLev = new JLabel("Course:");
        lblCourseLev.setForeground(Color.BLACK);
        lblCourseLev.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblCourseLev.setBounds(89, 162, 110, 22);
        panel.add(lblCourseLev);
        contentPane.setBackground(new Color(66, 66, 66));
        
        comboBox2 = new JComboBox<String>();
        comboBox2.setForeground(Color.BLACK);
        comboBox2.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox2.setBounds(223, 164, 198, 20);
        panel.add(comboBox2);
        comboBox2.setModel(new DefaultComboBoxModel<>(new String[] { "--Select--", "BIT", "BIBM"}));
        comboBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectLevel();
			}
		});
                                
        lblLev = new JLabel("Level");
        lblLev.setForeground(Color.BLACK);
        lblLev.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblLev.setBounds(89, 199, 110, 22);
        panel.add(lblLev);
        
        comboBox3 = new JComboBox<String>();
        comboBox3.setForeground(Color.BLACK);
        comboBox3.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
        comboBox3.setBounds(223, 201, 198, 20);
        panel.add(comboBox3);
        
        btnAdd2 = new JButton("Add");
        btnAdd2.setBounds(182, 248, 111, 33);
        panel.add(btnAdd2);
        btnAdd2.addActionListener(this);
        btnAdd2.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
        btnAdd2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
        btnAdd2.setBackground(new Color(116, 192, 68));
        btnAdd2.setForeground(new Color(45, 45, 45));
        
      
                                                
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btnAdd2){
        	addModule();
        }
    }
    public void addModule() {
    	String ID = moduleId.getText();
    	String name = moduleName.getText();
    	String type = comboBox.getSelectedItem().toString();
    	String cours = comboBox2.getSelectedItem().toString();
    	String levl = comboBox3.getSelectedItem().toString();
    	if (ID.isEmpty() && name.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill in all fields.");
		}else if(type.equals("--Select--")) {
			JOptionPane.showMessageDialog(this, "Please Select Module Type.");
		}else if(cours.equals("--Select--")) {
			JOptionPane.showMessageDialog(this, "Please Select Module Course.");
		}else if(levl.equals("--Select--")) {
			JOptionPane.showMessageDialog(this, "Please Select Level.");
		}else {
			try {
				if(e.isModuleExist(moduleId.getText())){
					JOptionPane.showMessageDialog(this, "Module Already Exists");
				}else {
					db_connect con = new db_connect();
	                String sql = "insert into modules(module_id, module_name, module_type, course_name, level) values(?, ?, ?, ?, ?)";
	                PreparedStatement s = con.c.prepareStatement(sql);
	                s.setString(1, ID);
	                s.setString(2, name);
	                s.setString(3, type);
	                s.setString(4, cours);
	                s.setString(5, levl);
	                int rs = s.executeUpdate();
	                if (rs > 0) {
	                    JOptionPane.showMessageDialog(null, "New Module Successfully Added");
    	                moduleId.setText("");
    	                moduleName.setText("");
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
    	if ("BIBM".equals(comboBox2.getSelectedItem())) {
            comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {"--Select--", "3", "4", "5", "6"}));
        } else if ("BIT".equals(comboBox2.getSelectedItem())) {
            comboBox3.setModel(new DefaultComboBoxModel<>(new String[] {"--Select--", "4", "5", "6"}));
        }
    }
    
}