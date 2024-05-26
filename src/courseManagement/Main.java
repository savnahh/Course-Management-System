package courseManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.CardLayout;
import javax.swing.JPasswordField;
public class Main extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLayeredPane layeredPane = new JLayeredPane();
	private JPanel login;
	private JPanel signup;
	private JTextField textField_1;
	private JTextField Username;
	private JTextField Email;
	private JTextField fullName;
	private JTextField username;
	private JTextField email;
	private JTextField phoneNum;
	private JPasswordField passWord;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	private JButton btncreate, btnsign, btnLog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/image/top.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 674);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		layeredPane.setBounds(410, 0, 376, 637);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		login = new JPanel();
		login.setBackground(Color.WHITE);
		layeredPane.add(login, "name_2344443209900");
		login.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(0, 0, -7, -12);
		textField_1.setColumns(10);
		login.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("  WELCOME TO LOG IN PANEL");
		lblNewLabel_2.setBounds(0, 104, 385, 34);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		login.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(31, 163, 103, 34);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 15));
		login.add(lblNewLabel);
		
		Username = new JTextField();
		Username.setBounds(156, 163, 194, 28);
		Username.setFont(new Font("Arial", Font.PLAIN, 15));
		Username.setColumns(10);
		login.add(Username);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(31, 218, 103, 34);
		lblEmail.setFont(new Font("Arial", Font.BOLD, 15));
		login.add(lblEmail);
		
		Email = new JTextField();
		Email.setFont(new Font("Arial", Font.PLAIN, 15));
		Email.setColumns(10);
		Email.setBounds(156, 218, 194, 28);
		login.add(Email);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1.setBounds(31, 275, 103, 34);
		login.add(lblNewLabel_1);
		
		passWord = new JPasswordField();
		passWord.setBounds(156, 275, 194, 28);
		login.add(passWord);
		
		JLabel lblNewLabel_3_1 = new JLabel("Select Mode:");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(31, 331, 129, 34);
		login.add(lblNewLabel_3_1);
		
		comboBox = new JComboBox<>();
		comboBox.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBox.setBounds(156, 331, 194, 28);
		login.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Select", "Admin", "Instructor", "Student" }));
		
		btnLog = new JButton("Log In");
		btnLog.setForeground(Color.WHITE);
		btnLog.setFont(new Font("Arial", Font.BOLD, 17));
		btnLog.setBackground(new Color(25, 32, 66));
		btnLog.setBounds(104, 403, 162, 37);
		login.add(btnLog);
		btnLog.addActionListener(this);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 470, 330, 2);
		login.add(separator_1);
		
		JLabel lblNewLabel_4 = new JLabel("Don't have an account?");
		lblNewLabel_4.setForeground(new Color(40, 40, 255));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_4.setBounds(104, 482, 119, 13);
		login.add(lblNewLabel_4);
		
		JButton btnSignup = new JButton("Sign Up");
		btnSignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(signup);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnSignup.setForeground(Color.WHITE);
		btnSignup.setFont(new Font("Arial", Font.BOLD, 17));
		btnSignup.setBackground(new Color(25, 32, 66));
		btnSignup.setBounds(103, 509, 162, 37);
		login.add(btnSignup);
		
		JLabel lblCourseManagement = new JLabel("@2024 Course Management System By Savona Shrestha");
		lblCourseManagement.setForeground(Color.GRAY);
		lblCourseManagement.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblCourseManagement.setBounds(41, 613, 292, 14);
		login.add(lblCourseManagement);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(Main.class.getResource("/image/main1.png")));
		lblNewLabel_3.setBounds(138, 35, 85, 59);
		login.add(lblNewLabel_3);
		
		signup = new JPanel();
		signup.setLayout(null);
		signup.setBackground(Color.WHITE);
		layeredPane.add(signup, "name_2364097574000");
		
		JLabel lblCourseManagement_1 = new JLabel("@2024 Course Management System By Savona Shrestha");
		lblCourseManagement_1.setForeground(Color.GRAY);
		lblCourseManagement_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblCourseManagement_1.setBounds(50, 613, 296, 14);
		signup.add(lblCourseManagement_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("  WELCOME TO SIGN UP PANEL");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel_2_1.setBounds(0, 69, 388, 53);
		signup.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("New label");
		lblNewLabel_3_2.setIcon(new ImageIcon(Main.class.getResource("/image/main1.png")));
		lblNewLabel_3_2.setBounds(149, 10, 85, 59);
		signup.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_5 = new JLabel("Full Name:");
		lblNewLabel_5.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_5.setBounds(35, 135, 99, 21);
		signup.add(lblNewLabel_5);
		
		fullName = new JTextField();
		fullName.setFont(new Font("Arial", Font.PLAIN, 15));
		fullName.setColumns(10);
		fullName.setBounds(184, 134, 162, 22);
		signup.add(fullName);
		
		JLabel lblNewLabel_1_1 = new JLabel("Username:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(35, 181, 99, 21);
		signup.add(lblNewLabel_1_1);
		
		username = new JTextField();
		username.setFont(new Font("Arial", Font.PLAIN, 15));
		username.setColumns(10);
		username.setBounds(184, 180, 162, 22);
		signup.add(username);
		
		JLabel lblEmail_1 = new JLabel("Email:");
		lblEmail_1.setFont(new Font("Arial", Font.BOLD, 15));
		lblEmail_1.setBounds(35, 226, 99, 21);
		signup.add(lblEmail_1);
		
		email = new JTextField();
		email.setFont(new Font("Arial", Font.PLAIN, 15));
		email.setColumns(10);
		email.setBounds(184, 225, 162, 22);
		signup.add(email);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		lblPhoneNumber.setFont(new Font("Arial", Font.BOLD, 15));
		lblPhoneNumber.setBounds(35, 271, 133, 21);
		signup.add(lblPhoneNumber);
		
		phoneNum = new JTextField();
		phoneNum.setFont(new Font("Arial", Font.PLAIN, 15));
		phoneNum.setColumns(10);
		phoneNum.setBounds(184, 270, 162, 22);
		signup.add(phoneNum);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Arial", Font.BOLD, 15));
		lblPassword.setBounds(35, 316, 99, 21);
		signup.add(lblPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(184, 317, 162, 21);
		signup.add(passwordField_1);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Arial", Font.BOLD, 15));
		lblConfirmPassword.setBounds(35, 361, 143, 21);
		signup.add(lblConfirmPassword);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(184, 362, 162, 21);
		signup.add(passwordField_2);
		
		JLabel lblSelectMode = new JLabel("Select Mode:");
		lblSelectMode.setFont(new Font("Arial", Font.BOLD, 15));
		lblSelectMode.setBounds(35, 410, 104, 21);
		signup.add(lblSelectMode);
		
		comboBox_1 = new JComboBox<>();
		comboBox_1.setFont(new Font("Arial", Font.PLAIN, 15));
		comboBox_1.setBounds(184, 409, 162, 23);
		signup.add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel<>(new String[] { "Select", "Admin","Instructor", "Student" }));
		
		btncreate = new JButton("Create");
		btncreate.setForeground(Color.WHITE);
		btncreate.setFont(new Font("Arial", Font.BOLD, 17));
		btncreate.setBackground(new Color(25, 32, 66));
		btncreate.setBounds(101, 460, 162, 37);
		signup.add(btncreate);
		btncreate.addActionListener(this);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(35, 526, 311, 2);
		signup.add(separator);
		
		JLabel lblNewLabel_4_1 = new JLabel("Already have an account?");
		lblNewLabel_4_1.setForeground(new Color(40, 40, 255));
		lblNewLabel_4_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_4_1.setBounds(101, 538, 133, 13);
		signup.add(lblNewLabel_4_1);
		
		btnsign = new JButton("Sign In");
		btnsign.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				layeredPane.removeAll();
				layeredPane.add(login);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnsign.setForeground(Color.WHITE);
		btnsign.setFont(new Font("Arial", Font.BOLD, 17));
		btnsign.setBackground(new Color(25, 32, 66));
		btnsign.setBounds(101, 561, 162, 37);
		signup.add(btnsign);
		btnsign.addActionListener(this);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon(Main.class.getResource("/image/main2.jpg")));
		lblNewLabel_6.setBounds(0, 0, 410, 668);
		contentPane.add(lblNewLabel_6);
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == btncreate) {
            createAccount();
        } else if (ae.getSource() == btnsign) {
        	switchToLoginPanel();
        } else if (ae.getSource() == btnLog) {
        	loginUser();
        }
	}
	private boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        return m.matches();
    }
    private boolean isValidNum(String phone) {
        String regex = "\\d{10}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phone);
        return m.matches();
    }
	public void createAccount() {
		String fullname = fullName.getText();
		String User = username.getText();
		String Email = email.getText();
		String Number = phoneNum.getText();
		String Password = new String(passwordField_1.getPassword());
		String Confirmpass = new String(passwordField_2.getPassword());
		String mode = comboBox_1.getSelectedItem().toString();
		if (fullname.isEmpty() && User.isEmpty() && Email.isEmpty() && Number.isEmpty() && Password.isEmpty() && Confirmpass.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Please fill in all fields.");
		}
		else if (!Password.equals(Confirmpass)) {
			JOptionPane.showMessageDialog(this, "Passwords do not match.");
		}
		else if (!isValidEmail(Email)) {
			JOptionPane.showMessageDialog(this, "Wrong email format.");
		}
		else if(!isValidNum(Number)) {
			JOptionPane.showMessageDialog(this, "Invalid Number format.");
		}
		else if(mode.equals("Select")) {
			JOptionPane.showMessageDialog(this, "Please select a mode.");
		}
		else {
			try {
				if(e.isUserExist(username.getText())) {
	                JOptionPane.showMessageDialog(this, "Username Already Exists");
	             }else {
	        		db_connect conn = new db_connect();
	                String query = "INSERT INTO accounts(fullname, username, email, phoneNum, password, role) VALUES(?, ?, ?, ?, ?, ?)";
	    			PreparedStatement s = conn.c.prepareStatement(query);
	    			s.setString(1, fullname);
	    			s.setString(2, User);
	    			s.setString(3, Email);
	    			s.setString(4, Number);
	    			s.setString(5, Password);
	    			s.setString(6, mode);

	    			int i = s.executeUpdate();
	    			if (i > 0) {
	    				JOptionPane.showMessageDialog(this, "Account created successfully!!");
	    				fullName.setText("");
	    				username.setText("");
	    		        email.setText("");
	    		        phoneNum.setText("");
	    		        passwordField_1.setText("");
	    		        passwordField_2.setText("");
	    		        
	    			}else {
	    				JOptionPane.showMessageDialog(this, "Failed to create account.");
	    			}
	    			s.close();
	    		}
	        }catch(Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
			}
		}
	}
	 private void switchToLoginPanel() {
	        layeredPane.removeAll();
	        layeredPane.add(login);
	        layeredPane.repaint();
	        layeredPane.revalidate();
	 }
	 private boolean isEmail(String Email) {
	        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
	        Pattern p = Pattern.compile(regex);
	        Matcher m = p.matcher(Email);
	        return m.matches();
	    }
	 private void loginUser() {
	        String user = Username.getText(); 
	        String em = Email.getText();
	        String pass = new String(passWord.getPassword());
	        String mod = comboBox.getSelectedItem().toString();

	        if (user.isEmpty() || pass.isEmpty() || em.isEmpty()) { // Check if username or password is empty
	            JOptionPane.showMessageDialog(this, "Please Fill in all the fields!");
	        } else if (!isEmail(em)) {
				JOptionPane.showMessageDialog(this, "Wrong email format.");
			}else if(mod.equals("Select")) {
				JOptionPane.showMessageDialog(this, "Please select a mode.");
			}
	        else {
	            try {
	            	db_connect conn = new db_connect();
	            	String query = "SELECT * FROM accounts where username=? and email=? and password=? and role=?";
	            	PreparedStatement s = conn.c.prepareStatement(query);
	    			s.setString(1, user);
	    			s.setString(2, em);
	    			s.setString(3, pass);
	    			s.setString(4, mod);
	    			ResultSet rs = s.executeQuery();
	    			if(rs.next()) {
	    				if (mod == "Admin") {
							this.setVisible(false);
							Admin ah = new Admin();
							ah.setVisible(true);
						} else if (mod == "Student") {
							this.setVisible(false);
							sTudent sh = new sTudent();
							sh.setVisible(true);
						} else if (mod == "Instructor") {
							this.setVisible(false);
							Instructor ih = new Instructor();
							ih.setVisible(true);
						}
	    			}else {
	                    JOptionPane.showMessageDialog(this, "Login Failed");
	                }
	            } catch (Exception ex) {
	                ex.printStackTrace();
	                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
	            }
	        }
	    }
	
}