package courseManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class sTudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField stdID;
	private JTextField studName;
	private JComboBox<String> comboBox_1_1,comboBox2_1, comboBox3_1 ;
	private JButton btnEnroll; 
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sTudent frame = new sTudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	Database e = new Database();
	public sTudent() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/image/top.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 674);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(66, 66, 66));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 159, 786, 317);
		panel.setBackground(new Color(128, 128, 128));
		contentPane.add(panel);
		db_connect conn = new db_connect();
		try {
            Statement s = conn.c.createStatement();
            ResultSet rs = s.executeQuery("SELECT instructor_id, full_name, course, level, module FROM instructor");
            DefaultTableModel mode4 = new DefaultTableModel();
            mode4.addColumn("Teacher ID");
            mode4.addColumn("Teacher Name");
            mode4.addColumn("Course");
            mode4.addColumn("Level");
            mode4.addColumn("Module");
            while (rs.next()) {
                mode4.addRow(new Object[]{rs.getString("instructor_id"), rs.getString("full_name"), rs.getString("course"), rs.getString("level"), rs.getString("module") });
            }
            panel.setLayout(null);
            JScrollPane scrollPane_1 = new JScrollPane(table);
            scrollPane_1.setBounds(38, 42, 316, 239);
            scrollPane_1.setEnabled(false);
            panel.add(scrollPane_1);
            
            table = new JTable(mode4);
            table.setEnabled(false);
            scrollPane_1.setViewportView(table);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
		
		JTextArea txtrInstructors = new JTextArea();
		txtrInstructors.setBounds(128, 9, 127, 22);
		txtrInstructors.setText("INSTRUCTORS");
		txtrInstructors.setFont(new Font("Arial", Font.BOLD, 17));
		txtrInstructors.setBackground(new Color(116, 192, 68));
		panel.add(txtrInstructors);
		
		JTextArea txtrEnroll = new JTextArea();
		txtrEnroll.setBounds(544, 9, 80, 22);
		txtrEnroll.setText("ENROLL");
		txtrEnroll.setFont(new Font("Arial", Font.BOLD, 17));
		txtrEnroll.setBackground(new Color(116, 192, 68));
		panel.add(txtrEnroll);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(427, 42, 316, 239);
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(null);
		panel_2_1.setBackground(new Color(217, 217, 217));
		panel.add(panel_2_1);
		
		JLabel StudentID_1 = new JLabel("Student ID:");
		StudentID_1.setForeground(Color.BLACK);
		StudentID_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		StudentID_1.setBounds(24, 22, 110, 22);
		panel_2_1.add(StudentID_1);
		
		stdID = new JTextField();
		stdID.setForeground(Color.BLACK);
		stdID.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		stdID.setColumns(10);
		stdID.setBounds(125, 24, 165, 20);
		panel_2_1.add(stdID);
		
		JLabel Studname_1 = new JLabel("Name:");
		Studname_1.setForeground(Color.BLACK);
		Studname_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		Studname_1.setBounds(24, 54, 110, 22);
		panel_2_1.add(Studname_1);
		
		studName = new JTextField();
		studName.setForeground(Color.BLACK);
		studName.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		studName.setColumns(10);
		studName.setBounds(125, 54, 165, 20);
		panel_2_1.add(studName);
		
		JLabel lblCourse_1 = new JLabel("Course:");
		lblCourse_1.setForeground(Color.BLACK);
		lblCourse_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCourse_1.setBounds(24, 84, 110, 22);
		panel_2_1.add(lblCourse_1);
		
		comboBox_1_1 = new JComboBox<String>();
		comboBox_1_1.setForeground(Color.BLACK);
		comboBox_1_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		comboBox_1_1.setBounds(125, 86, 165, 20);
		panel_2_1.add(comboBox_1_1);
		comboBox_1_1.setModel(new DefaultComboBoxModel<>(new String[] { "--Select--", "BIT", "BIBM"}));
		
		JLabel lev_1 = new JLabel("Level:");
		lev_1.setForeground(Color.BLACK);
		lev_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lev_1.setBounds(24, 116, 110, 22);
		panel_2_1.add(lev_1);
		
		comboBox2_1 = new JComboBox<String>();
		comboBox2_1.setForeground(Color.BLACK);
		comboBox2_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		comboBox2_1.setBounds(125, 116, 165, 20);
		panel_2_1.add(comboBox2_1);
		comboBox2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modules();
			}
		});
		
		JLabel lblmodule_1 = new JLabel("Semester");
		lblmodule_1.setForeground(Color.BLACK);
		lblmodule_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblmodule_1.setBounds(24, 150, 110, 22);
		panel_2_1.add(lblmodule_1);
		
		comboBox3_1 = new JComboBox<String>();
		comboBox3_1.setForeground(Color.BLACK);
		comboBox3_1.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		comboBox3_1.setBounds(125, 152, 165, 20);
		panel_2_1.add(comboBox3_1);
		
		btnEnroll = new JButton("Enroll ");
		btnEnroll.setForeground(new Color(255, 255, 255));
		btnEnroll.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnEnroll.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), null));
		btnEnroll.setBackground(new Color(66, 66, 66));
		btnEnroll.setBounds(112, 182, 111, 33);
		panel_2_1.add(btnEnroll);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 10, 61, 52);
		lblNewLabel.setIcon(new ImageIcon(sTudent.class.getResource("/image/frontP.png")));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("STUDENT DASHBOARD");
		lblNewLabel_1.setBounds(230, 25, 311, 35);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		contentPane.add(lblNewLabel_1);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(733, 20, 198, 35);
		menuBar.setForeground(new Color(66, 66, 66));
		menuBar.setBorder(null);
		menuBar.setBackground(new Color(66, 66, 66));
		contentPane.add(menuBar);
		
		mnNewMenu = new JMenu("");
		mnNewMenu.setIcon(new ImageIcon(sTudent.class.getResource("/image/menuicon.png")));
		mnNewMenu.setBackground(new Color(66, 66, 66));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Logout");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main c = new Main();
	            c.setVisible(true);
	            dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
	}
	public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btnEnroll){
        	addCourse();
        }
    }
    public void addCourse() {
    	String ID = stdID.getText();
    	String name = studName.getText();
    	String cour= comboBox_1_1.getSelectedItem().toString();
    	String leve = comboBox2_1.getSelectedItem().toString();
    	String sem = comboBox3_1.getSelectedItem().toString();
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
	                String sql = "insert into student(student_id, full_name, course, level, semester) values(?, ?, ?, ?, ?)";
	                PreparedStatement s = con.c.prepareStatement(sql);
	                s.setString(1, ID);
	                s.setString(2, name);
	                s.setString(3, cour);
	                s.setString(4, leve);
	                s.setString(5, sem);
	                int rs = s.executeUpdate();
	                if (rs > 0) {
	                    JOptionPane.showMessageDialog(null, "New Student Successfully Added");
    	                stdID.setText("");
    	                studName.setText("");
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
    public void Modules() {
    	String selectedCourse = (String)comboBox_1_1.getSelectedItem();
        String selectedLevel = (String)comboBox2_1.getSelectedItem();
        
        if ("BIT".equals(selectedCourse) && "4".equals(selectedLevel)) {
            comboBox3_1.setModel(new DefaultComboBoxModel<>(new String[] {"--Select", "First", "Second"}));
        }else if("BIT".equals(selectedCourse) && "5".equals(selectedLevel)) {
        	comboBox3_1.setModel(new DefaultComboBoxModel<>(new String[] {"--Select--", "Third", "Fourth"}));
        }else if("BIT".equals(selectedCourse) && "6".equals(selectedLevel)) {
        	comboBox3_1.setModel(new DefaultComboBoxModel<>(new String[] {"--Select--", "Fifth", "Sixth"}));
        }
        
        if ("BIBM".equals(selectedCourse) && "3".equals(selectedLevel)) {
            comboBox3_1.setModel(new DefaultComboBoxModel<>(new String[] {"--Select--", "First", "Second"}));
        }else if("BIBM".equals(selectedCourse) && "4".equals(selectedLevel)) {
        	comboBox3_1.setModel(new DefaultComboBoxModel<>(new String[] {"--Select--", "Third", "Fourth"}));
        }else if("BIBM".equals(selectedCourse) && "5".equals(selectedLevel)) {
        	comboBox3_1.setModel(new DefaultComboBoxModel<>(new String[] {"--Select--", "Fifth", "Sixth"}));
        }else if("BIBM".equals(selectedCourse) && "6".equals(selectedLevel)) {
        	comboBox3_1.setModel(new DefaultComboBoxModel<>(new String[] {"--Select--", "Seventh", "Eigth"}));
        }
    }
    
 }

