package courseManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLayeredPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class Admin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLayeredPane layeredPane = new JLayeredPane();
	private JPanel Dashboard;
	private JPanel Courses;
	private JPanel Modules;
	private JPanel Student;
	private JPanel Teacher;
	private JTable table1;
	private JTable table2;
	private JButton btnAddcourse, btnEditcourse, btnDelcourse;
	private JButton btnAddmod, btnEditmod, btnDelmod;
	private JButton btnAddstudent, btnEditstudent, btnDelstudent;
	private JButton btnAddteacher, btnEditteacher, btnDelteacher;
	private JMenuItem mntmNewMenuItem;
	private JTable table3;
	private JTable table4;
	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/image/top.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 674);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(66, 66, 66));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		layeredPane.setBounds(0, 75, 786, 562);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		//DASHBOARD PANEL
		Dashboard = new JPanel();
		Dashboard.setBackground(new Color(192, 192, 192));
		layeredPane.add(Dashboard, "name_65763243142199");
		Dashboard.setLayout(null);
		
		JPanel panel_dashboard = new JPanel();
		panel_dashboard.setBounds(0, 0, 205, 570);
		panel_dashboard.setLayout(null);
		panel_dashboard.setBackground(Color.GRAY);
		Dashboard.add(panel_dashboard);
		
		JButton btncourses1 = new JButton("Courses");
		btncourses1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Courses);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btncourses1.setIcon(new ImageIcon(Admin.class.getResource("/image/courses.png")));
		btncourses1.setBackground(new Color(116, 192, 68));
		btncourses1.setBounds(24, 33, 155, 63);
		panel_dashboard.add(btncourses1);
		
		JButton btnmodule1 = new JButton("Modules");
		btnmodule1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Modules);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnmodule1.setIcon(new ImageIcon(Admin.class.getResource("/image/modules.png")));
		btnmodule1.setBackground(new Color(116, 192, 68));
		btnmodule1.setBounds(24, 165, 155, 63);
		panel_dashboard.add(btnmodule1);
		
		JButton btnstudent1 = new JButton("Student");
		btnstudent1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Student);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnstudent1.setIcon(new ImageIcon(Admin.class.getResource("/image/student.png")));
		btnstudent1.setBackground(new Color(116, 192, 68));
		btnstudent1.setBounds(24, 309, 155, 63);
		panel_dashboard.add(btnstudent1);
		
		JButton btnteacher1 = new JButton("Teacher");
		btnteacher1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Teacher);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnteacher1.setIcon(new ImageIcon(Admin.class.getResource("/image/teacher.png")));
		btnteacher1.setBackground(new Color(116, 192, 68));
		btnteacher1.setBounds(24, 442, 155, 63);
		panel_dashboard.add(btnteacher1);
		
		JLabel mainDash = new JLabel("New label");
		mainDash.setBounds(283, 10, 48, 38);
		mainDash.setIcon(new ImageIcon(Admin.class.getResource("/image/dashboardB.png")));
		Dashboard.add(mainDash);
		
		JLabel topic1 = new JLabel("DASHBOARD");
		topic1.setBounds(342, 18, 174, 30);
		topic1.setForeground(new Color(66, 66, 66));
		topic1.setFont(new Font("Arial", Font.BOLD, 26));
		Dashboard.add(topic1);
		
		Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, MMMMM dd'th' yyyy");
        JLabel Date = new JLabel(sdf.format(cal.getTime()));
        Date.setBounds(566, 47, 186, 13);
		Date.setForeground(Color.BLACK);
		Date.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		Dashboard.add(Date);
		
		JLabel Footer1 = new JLabel("@2024 Course Management System");
		Footer1.setBounds(389, 538, 186, 14);
		Footer1.setForeground(Color.GRAY);
		Footer1.setFont(new Font("Dialog", Font.PLAIN, 11));
		Dashboard.add(Footer1);
		
		JPanel panel = new JPanel();
		panel.setBounds(234, 81, 248, 439);
		Dashboard.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Admin.class.getResource("/image/notifications_icon.png")));
		lblNewLabel_2.setBounds(176, -3, 33, 42);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Notifications");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblNewLabel_4.setBounds(37, 1, 146, 38);
		panel.add(lblNewLabel_4);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 43, 199, 14);
		panel.add(separator);
		
		JTextArea txtrNewUserCurrently = new JTextArea();
		txtrNewUserCurrently.setBackground(new Color(116, 192, 68));
		txtrNewUserCurrently.setFont(new Font("Arial", Font.PLAIN, 13));
		txtrNewUserCurrently.setBounds(21, 59, 199, 38);
		panel.add(txtrNewUserCurrently);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(66, 66, 66));
		textArea_1.setBounds(21, 119, 199, 38);
		panel.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBackground(new Color(116, 192, 68));
		textArea_2.setBounds(21, 185, 199, 38);
		panel.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBackground(new Color(66, 66, 66));
		textArea_3.setBounds(21, 251, 199, 38);
		panel.add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBackground(new Color(116, 192, 68));
		textArea_4.setBounds(21, 317, 199, 38);
		panel.add(textArea_4);
		
		JTextArea textArea_4_7 = new JTextArea();
		textArea_4_7.setBackground(new Color(66, 66, 66));
		textArea_4_7.setBounds(21, 380, 199, 38);
		panel.add(textArea_4_7);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(504, 81, 248, 439);
		Dashboard.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Admin.class.getResource("/image/todolist.png")));
		lblNewLabel_3.setBounds(162, 2, 38, 43);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel("To Do List");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		lblNewLabel_5.setBounds(34, 2, 132, 41);
		panel_1.add(lblNewLabel_5);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(29, 41, 196, 35);
		panel_1.add(separator_1);
		
		JTextArea textArea_4_1 = new JTextArea();
		textArea_4_1.setBackground(new Color(66, 66, 66));
		textArea_4_1.setBounds(26, 61, 199, 38);
		panel_1.add(textArea_4_1);
		
		JTextArea textArea_4_2 = new JTextArea();
		textArea_4_2.setBackground(new Color(116, 192, 68));
		textArea_4_2.setBounds(26, 121, 199, 38);
		panel_1.add(textArea_4_2);
		
		JTextArea textArea_4_3 = new JTextArea();
		textArea_4_3.setBackground(new Color(66, 66, 66));
		textArea_4_3.setBounds(26, 186, 199, 38);
		panel_1.add(textArea_4_3);
		
		JTextArea textArea_4_4 = new JTextArea();
		textArea_4_4.setBackground(new Color(116, 192, 68));
		textArea_4_4.setBounds(26, 252, 199, 38);
		panel_1.add(textArea_4_4);
		
		JTextArea textArea_4_5 = new JTextArea();
		textArea_4_5.setBackground(new Color(66, 66, 66));
		textArea_4_5.setBounds(26, 316, 199, 38);
		panel_1.add(textArea_4_5);
		
		JTextArea textArea_4_6 = new JTextArea();
		textArea_4_6.setBackground(new Color(116, 192, 68));
		textArea_4_6.setBounds(26, 379, 199, 38);
		panel_1.add(textArea_4_6);
		
		
		//COURSE PANEL
		Courses = new JPanel();
		Courses.setBackground(new Color(192, 192, 192));
		layeredPane.add(Courses, "name_66818561504600");
		Courses.setLayout(null);
		
		JPanel panel_courses = new JPanel();
		panel_courses.setBounds(0, 0, 205, 570);
		panel_courses.setLayout(null);
		panel_courses.setBackground(Color.GRAY);
		Courses.add(panel_courses);
		
		JButton btndashboard1 = new JButton("Dashboard");
		btndashboard1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Dashboard);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btndashboard1.setIcon(new ImageIcon(Admin.class.getResource("/image/dashboard.png")));
		btndashboard1.setBackground(new Color(116, 192, 68));
		btndashboard1.setBounds(24, 33, 155, 63);
		panel_courses.add(btndashboard1);
		
		JButton btnmodule2 = new JButton("Modules");
		btnmodule2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Modules);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnmodule2.setIcon(new ImageIcon(Admin.class.getResource("/image/modules.png")));
		btnmodule2.setBackground(new Color(116, 192, 68));
		btnmodule2.setBounds(24, 165, 155, 63);
		panel_courses.add(btnmodule2);
		
		JButton btnstudent2 = new JButton("Student");
		btnstudent2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Student);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnstudent2.setIcon(new ImageIcon(Admin.class.getResource("/image/student.png")));
		btnstudent2.setBackground(new Color(116, 192, 68));
		btnstudent2.setBounds(24, 309, 155, 63);
		panel_courses.add(btnstudent2);
		
		JButton btnteacher2 = new JButton("Teacher");
		btnteacher2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Teacher);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnteacher2.setIcon(new ImageIcon(Admin.class.getResource("/image/teacher.png")));
		btnteacher2.setBackground(new Color(116, 192, 68));
		btnteacher2.setBounds(24, 442, 155, 63);
		panel_courses.add(btnteacher2);
		
		db_connect conn = new db_connect();

        try {
            Statement s = conn.c.createStatement();
            ResultSet rs = s.executeQuery("SELECT course_id, course_name, years, status FROM courses");
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Course ID");
            model.addColumn("Course Name");
            model.addColumn("Years");
            model.addColumn("Status");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("course_id"), rs.getString("course_name"), rs.getString("years"), rs.getString("status")});
            }
            JScrollPane scrollPane2 = new JScrollPane(table1);
            scrollPane2.setBounds(212, 111, 564, 422);
            scrollPane2.setEnabled(false);
            Courses.add(scrollPane2);
            
            table1 = new JTable(model);
            table1.setEnabled(false);
            scrollPane2.setViewportView(table1);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        
		JLabel mainCou = new JLabel("New label");
		mainCou.setBounds(401, 0, 55, 48);
		mainCou.setIcon(new ImageIcon(Admin.class.getResource("/image/courseB.png")));
		Courses.add(mainCou);
		
		JLabel topic2 = new JLabel("COURSES");
		topic2.setBounds(459, 12, 153, 30);
		topic2.setForeground(new Color(66, 66, 66));
		topic2.setFont(new Font("Arial", Font.BOLD, 26));
		Courses.add(topic2);
		
		JLabel Footer2 = new JLabel("@2024 Course Management System");
		Footer2.setBounds(403, 538, 186, 14);
		Footer2.setForeground(Color.GRAY);
		Footer2.setFont(new Font("Dialog", Font.PLAIN, 11));
		Courses.add(Footer2);
		
		btnAddcourse = new JButton("Add Course");
		btnAddcourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCourse c = new AddCourse();
	            c.setVisible(true);
			}
		});
		btnAddcourse.setBounds(286, 71, 104, 21);
		Courses.add(btnAddcourse);
		
		btnEditcourse = new JButton("Edit Course\r\n");
		btnEditcourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditCourse c = new EditCourse();
	            c.setVisible(true);
			}
		});
		btnEditcourse.setBounds(435, 71, 104, 21);
		Courses.add(btnEditcourse);
		
		btnDelcourse = new JButton("Delete Course\r\n");
		btnDelcourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteCourse c = new DeleteCourse();
	            c.setVisible(true);
			}
		});
		btnDelcourse.setBounds(583, 71, 116, 21);
		Courses.add(btnDelcourse);
		
		
		//MODULES PANEL
		Modules = new JPanel();
		Modules.setBackground(new Color(192, 192, 192));
		layeredPane.add(Modules, "name_74502242121300");
		Modules.setLayout(null);
		
		JPanel panel_modules = new JPanel();
		panel_modules.setBounds(0, 0, 205, 570);
		panel_modules.setLayout(null);
		panel_modules.setBackground(Color.GRAY);
		Modules.add(panel_modules);
		
		JButton btndashboard2 = new JButton("Dashboard");
		btndashboard2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Dashboard);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btndashboard2.setIcon(new ImageIcon(Admin.class.getResource("/image/dashboard.png")));
		btndashboard2.setBackground(new Color(116, 192, 68));
		btndashboard2.setBounds(24, 33, 155, 63);
		panel_modules.add(btndashboard2);
		
		JButton btncourses2 = new JButton("Courses");
		btncourses2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Courses);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btncourses2.setIcon(new ImageIcon(Admin.class.getResource("/image/courses.png")));
		btncourses2.setBackground(new Color(116, 192, 68));
		btncourses2.setBounds(24, 165, 155, 63);
		panel_modules.add(btncourses2);
		
		JButton btnstudent3 = new JButton("Student");
		btnstudent3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Student);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnstudent3.setIcon(new ImageIcon(Admin.class.getResource("/image/student.png")));
		btnstudent3.setBackground(new Color(116, 192, 68));
		btnstudent3.setBounds(24, 309, 155, 63);
		panel_modules.add(btnstudent3);
		
		JButton btnteacher3 = new JButton("Teacher");
		btnteacher3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Teacher);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnteacher3.setIcon(new ImageIcon(Admin.class.getResource("/image/teacher.png")));
		btnteacher3.setBackground(new Color(116, 192, 68));
		btnteacher3.setBounds(24, 442, 155, 63);
		panel_modules.add(btnteacher3);
		
		try {
            Statement s = conn.c.createStatement();
            ResultSet rs = s.executeQuery("SELECT module_id, module_name, module_type, course_name, level FROM modules");
            DefaultTableModel mode2 = new DefaultTableModel();
            mode2.addColumn("Module ID");
            mode2.addColumn("Module Name");
            mode2.addColumn("Module Type");
            mode2.addColumn("Course Name");
            mode2.addColumn("Level");
            while (rs.next()) {
                mode2.addRow(new Object[]{rs.getString("module_id"), rs.getString("module_name"), rs.getString("module_type"), rs.getString("course_name"), rs.getString("level") });
            }
            JScrollPane scrollPane3 = new JScrollPane(table2);
            scrollPane3.setBounds(212, 111, 564, 422);
            scrollPane3.setEnabled(false);
            Modules.add(scrollPane3);
            
            table2 = new JTable(mode2);
            table2.setEnabled(false);
            scrollPane3.setViewportView(table2);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
		
		JLabel main_Mod = new JLabel("New label");
		main_Mod.setBounds(401, 0, 55, 48);
		main_Mod.setIcon(new ImageIcon(Admin.class.getResource("/image/moduleB.png")));
		Modules.add(main_Mod);
		
		JLabel topic3 = new JLabel("MODULES");
		topic3.setBounds(459, 12, 153, 30);
		topic3.setForeground(new Color(66, 66, 66));
		topic3.setFont(new Font("Arial", Font.BOLD, 26));
		Modules.add(topic3);
		
		JLabel Footer2_1 = new JLabel("@2024 Course Management System");
		Footer2_1.setBounds(413, 538, 186, 14);
		Footer2_1.setForeground(Color.GRAY);
		Footer2_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		Modules.add(Footer2_1);
		
		btnAddmod = new JButton("Add Module");
		btnAddmod.setBounds(280, 71, 104, 21);
		btnAddmod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddModule m = new AddModule();
				m.setVisible(true);
			}
		});
		Modules.add(btnAddmod);
		
		btnEditmod = new JButton("Edit Module");
		btnEditmod.setBounds(425, 71, 115, 21);
		btnEditmod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditModule m = new EditModule();
				m.setVisible(true);
			}
		});
		Modules.add(btnEditmod);
		
		btnDelmod = new JButton("Delete Module");
		btnDelmod.setBounds(583, 71, 124, 21);
		btnDelmod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteModule m = new DeleteModule();
				m.setVisible(true);
			}
		});
		Modules.add(btnDelmod);
		
		
		//STUDENT PANEL
		Student = new JPanel();
		Student.setBackground(new Color(192, 192, 192));
		Student.setLayout(null);
		layeredPane.add(Student, "name_74972886072400");
		
		JPanel panel_student = new JPanel();
		panel_student.setLayout(null);
		panel_student.setBackground(Color.GRAY);
		panel_student.setBounds(0, 0, 205, 570);
		Student.add(panel_student);
		
		JButton btndashboard3 = new JButton("Dashboard");
		btndashboard3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Dashboard);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btndashboard3.setIcon(new ImageIcon(Admin.class.getResource("/image/dashboard.png")));
		btndashboard3.setBackground(new Color(116, 192, 68));
		btndashboard3.setBounds(24, 33, 155, 63);
		panel_student.add(btndashboard3);
		
		JButton btncourses3 = new JButton("Courses");
		btncourses3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Courses);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btncourses3.setIcon(new ImageIcon(Admin.class.getResource("/image/courses.png")));
		btncourses3.setBackground(new Color(116, 192, 68));
		btncourses3.setBounds(24, 165, 155, 63);
		panel_student.add(btncourses3);
		
		JButton btnmodules3 = new JButton("Modules");
		btnmodules3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Modules);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnmodules3.setIcon(new ImageIcon(Admin.class.getResource("/image/modules.png")));
		btnmodules3.setBackground(new Color(116, 192, 68));
		btnmodules3.setBounds(24, 309, 155, 63);
		panel_student.add(btnmodules3);
		
		JButton btnteacher4 = new JButton("Teacher");
		btnteacher4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Teacher);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnteacher4.setIcon(new ImageIcon(Admin.class.getResource("/image/teacher.png")));
		btnteacher4.setBackground(new Color(116, 192, 68));
		btnteacher4.setBounds(24, 442, 155, 63);
		panel_student.add(btnteacher4);
		
		
		try {
            Statement s = conn.c.createStatement();
            ResultSet rs = s.executeQuery("SELECT student_id, full_name, course, level, semester FROM student");
            DefaultTableModel mode3 = new DefaultTableModel();
            mode3.addColumn("Student ID");
            mode3.addColumn("Student Name");
            mode3.addColumn("Course");
            mode3.addColumn("Level");
            mode3.addColumn("Semester");
            while (rs.next()) {
                mode3.addRow(new Object[]{rs.getString("student_id"), rs.getString("full_name"), rs.getString("course"), rs.getString("level"), rs.getString("semester") });
            }
            JScrollPane scrollPane4 = new JScrollPane(table3);
            scrollPane4.setBounds(212, 111, 564, 422);
            scrollPane4.setEnabled(false);
            Student.add(scrollPane4);
            
            table3 = new JTable(mode3);
            table3.setEnabled(false);
            scrollPane4.setViewportView(table3);

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
		
		JLabel main_Stu = new JLabel("New label");
		main_Stu.setIcon(new ImageIcon(Admin.class.getResource("/image/studentB.png")));
		main_Stu.setBounds(401, 0, 55, 48);
		Student.add(main_Stu);
		
		JLabel topic4 = new JLabel("STUDENT");
		topic4.setForeground(new Color(66, 66, 66));
		topic4.setFont(new Font("Arial", Font.BOLD, 26));
		topic4.setBounds(459, 12, 153, 30);
		Student.add(topic4);
		
		JLabel Footer2_2 = new JLabel("@2024 Course Management System");
		Footer2_2.setForeground(Color.GRAY);
		Footer2_2.setFont(new Font("Dialog", Font.PLAIN, 11));
		Footer2_2.setBounds(401, 538, 186, 14);
		Student.add(Footer2_2);
		
		btnAddstudent = new JButton("Add Student\r\n");
		btnAddstudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStudent s = new AddStudent();
				s.setVisible(true);
			}
		});
		btnAddstudent.setBounds(289, 71, 104, 21);
		Student.add(btnAddstudent);
		
		btnEditstudent = new JButton("Edit Student");
		btnEditstudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditStudent s = new EditStudent();
				s.setVisible(true);
			}
		});
		btnEditstudent.setBounds(427, 71, 115, 21);
		Student.add(btnEditstudent);
		
		btnDelstudent = new JButton("Delete Student\r\n");
		btnDelstudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteStudent s = new DeleteStudent();
				s.setVisible(true);
			}
		});
		btnDelstudent.setBounds(578, 71, 126, 21);
		Student.add(btnDelstudent);
		
		//INSTRUCTOR PANEL
		Teacher = new JPanel();
		Teacher.setBackground(new Color(192, 192, 192));
		Teacher.setLayout(null);
		layeredPane.add(Teacher, "name_75131374230200");
		
		JPanel panel_teacher = new JPanel();
		panel_teacher.setLayout(null);
		panel_teacher.setBackground(Color.GRAY);
		panel_teacher.setBounds(0, 0, 205, 570);
		Teacher.add(panel_teacher);
		
		JButton btndashboard4 = new JButton("Dashboard");
		btndashboard4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Dashboard);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btndashboard4.setIcon(new ImageIcon(Admin.class.getResource("/image/dashboard.png")));
		btndashboard4.setBackground(new Color(116, 192, 68));
		btndashboard4.setBounds(24, 33, 155, 63);
		panel_teacher.add(btndashboard4);
		
		JButton btncourse4 = new JButton("Courses");
		btncourse4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Courses);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btncourse4.setIcon(new ImageIcon(Admin.class.getResource("/image/courses.png")));
		btncourse4.setBackground(new Color(116, 192, 68));
		btncourse4.setBounds(24, 165, 155, 63);
		panel_teacher.add(btncourse4);
		
		JButton btnmodules4 = new JButton("Modules");
		btnmodules4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Modules);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnmodules4.setIcon(new ImageIcon(Admin.class.getResource("/image/modules.png")));
		btnmodules4.setBackground(new Color(116, 192, 68));
		btnmodules4.setBounds(24, 309, 155, 63);
		panel_teacher.add(btnmodules4);
		
		JButton btnstudent4 = new JButton("Student");
		btnstudent4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll();
				layeredPane.add(Student);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnstudent4.setIcon(new ImageIcon(Admin.class.getResource("/image/student.png")));
		btnstudent4.setBackground(new Color(116, 192, 68));
		btnstudent4.setBounds(24, 442, 155, 63);
		panel_teacher.add(btnstudent4);
		
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
            JScrollPane scrollPane5 = new JScrollPane(table4);
            scrollPane5.setBounds(212, 111, 564, 422);
            scrollPane5.setEnabled(false);
            Teacher.add(scrollPane5);
            
            table4 = new JTable(mode4);
            table4.setEnabled(false);
            scrollPane5.setViewportView(table4);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
		
		JLabel main_Teac = new JLabel("New label");
		main_Teac.setIcon(new ImageIcon(Admin.class.getResource("/image/teacherB.png")));
		main_Teac.setBounds(336, 0, 55, 48);
		Teacher.add(main_Teac);
		
		JLabel topic5 = new JLabel("TEACHER");
		topic5.setForeground(new Color(66, 66, 66));
		topic5.setFont(new Font("Arial", Font.BOLD, 26));
		topic5.setBounds(401, 12, 251, 30);
		Teacher.add(topic5);
		
		JLabel Footer2_3 = new JLabel("@2024 Course Management System");
		Footer2_3.setForeground(Color.GRAY);
		Footer2_3.setFont(new Font("Dialog", Font.PLAIN, 11));
		Footer2_3.setBounds(402, 538, 186, 14);
		Teacher.add(Footer2_3);
		
		btnAddteacher = new JButton("Add Teacher\r\n");
		btnAddteacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddInstructor i = new AddInstructor();
				i.setVisible(true);
			}
		});
		btnAddteacher.setBounds(286, 71, 116, 21);
		Teacher.add(btnAddteacher);
		
		btnEditteacher = new JButton("Edit Teacher\r\n");
		btnEditteacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditInstructor i = new EditInstructor();
				i.setVisible(true);
			}
		});
		btnEditteacher.setBounds(430, 71, 116, 21);
		Teacher.add(btnEditteacher);
		
		btnDelteacher = new JButton("Delete Teacher\r\n");
		btnDelteacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteInstructor i = new DeleteInstructor();
				i.setVisible(true);
			}
		});
		btnDelteacher.setBounds(578, 71, 125, 21);
		Teacher.add(btnDelteacher);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(46, 9, 69, 55);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Admin.class.getResource("/image/frontP.png")));
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel_1.setBounds(325, 14, 104, 35);
		contentPane.add(lblNewLabel_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(null);
		menuBar.setBackground(new Color(66, 66, 66));
		menuBar.setBounds(738, 18, 594, 35);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu_1 = new JMenu("");
		mnNewMenu_1.setIcon(new ImageIcon(Admin.class.getResource("/image/menuicon.png")));
		mnNewMenu_1.setBackground(new Color(66, 66, 66));
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem = new JMenuItem("Logout");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main c = new Main();
	            c.setVisible(true);
	            dispose();
			}
		});
		mntmNewMenuItem.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem.setFont(new Font("Arial", Font.BOLD, 12));
		mntmNewMenuItem.setBackground(new Color(66, 66, 66));
		mnNewMenu_1.add(mntmNewMenuItem);
	
	}
}


