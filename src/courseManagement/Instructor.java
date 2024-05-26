package courseManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JMenuBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;


public class Instructor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel label;
	private JLabel lblNewLabel;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JPanel View;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTable table;
	private JTable table_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Instructor frame = new Instructor();
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
	public Instructor() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/image/top.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 674);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(66, 66, 66));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		label = new JLabel("New label");
		label.setBounds(20, 10, 67, 59);
		label.setIcon(new ImageIcon(Instructor.class.getResource("/image/frontP.png")));
		contentPane.add(label);
		
		lblNewLabel = new JLabel("INSTRUCTOR DASHBOARD");
		lblNewLabel.setBounds(226, 16, 371, 36);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		contentPane.add(lblNewLabel);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(739, 20, 763, 35);
		menuBar.setBorder(null);
		menuBar.setBackground(new Color(66, 66, 66));
		contentPane.add(menuBar);
		
		mnNewMenu = new JMenu("");
		mnNewMenu.setBackground(new Color(66, 66, 66));
		mnNewMenu.setIcon(new ImageIcon(Instructor.class.getResource("/image/menuicon.png")));
		menuBar.add(mnNewMenu);
		
		mntmNewMenuItem = new JMenuItem("Logout\r\n");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main c = new Main();
	            c.setVisible(true);
	            dispose();
			}
		});
		mntmNewMenuItem.setForeground(new Color(255, 255, 255));
		mntmNewMenuItem.setBackground(new Color(66, 66, 66));
		mnNewMenu.add(mntmNewMenuItem);
		
		View = new JPanel();
		View.setBounds(0, 79, 786, 558);
		View.setBackground(Color.GRAY);
		contentPane.add(View);
		View.setLayout(null);
		
		db_connect conn = new db_connect();
		try {
            Statement s = conn.c.createStatement();
            ResultSet rs = s.executeQuery("SELECT module_id, module_name, module_type, course_name, level FROM modules");
            DefaultTableModel mode = new DefaultTableModel();
            mode.addColumn("Module ID");
            mode.addColumn("Module Name");
            mode.addColumn("Module Type");
            mode.addColumn("Course Name");
            mode.addColumn("Level");
            while (rs.next()) {
                mode.addRow(new Object[]{rs.getString("module_id"), rs.getString("module_name"), rs.getString("module_type"), rs.getString("course_name"), rs.getString("level") });
            }
            scrollPane = new JScrollPane(table);
    		scrollPane.setBounds(10, 65, 766, 217);
    		scrollPane.setEnabled(false);
    		View.add(scrollPane);
    		
    		table = new JTable(mode);
    		table.setEnabled(false);
    		scrollPane.setViewportView(table);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
		

		try {
            Statement s = conn.c.createStatement();
            ResultSet rs = s.executeQuery("SELECT student_id, full_name, course, level, semester FROM student");
            DefaultTableModel mode2 = new DefaultTableModel();
            mode2.addColumn("Student ID");
            mode2.addColumn("Student Name");
            mode2.addColumn("Course");
            mode2.addColumn("Level");
            mode2.addColumn("Semester");
            while (rs.next()) {
                mode2.addRow(new Object[]{rs.getString("student_id"), rs.getString("full_name"), rs.getString("course"), rs.getString("level"), rs.getString("semester") });
            }
            scrollPane_1 = new JScrollPane(table_1);
    		scrollPane_1.setBounds(10, 331, 766, 217);
    		scrollPane_1.setEnabled(false);
    		View.add(scrollPane_1);
    		
    		table_1 = new JTable(mode2);
    		table_1.setEnabled(false);
    		scrollPane_1.setViewportView(table_1);
    		
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
		
		lblNewLabel_1 = new JLabel(" MODULES");
		lblNewLabel_1.setBounds(347, 24, 91, 31);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 16));
		View.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("STUDENTS");
		lblNewLabel_2.setBounds(347, 292, 91, 31);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 16));
		View.add(lblNewLabel_2);
	}
}
