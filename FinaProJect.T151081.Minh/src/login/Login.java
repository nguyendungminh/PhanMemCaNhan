package login;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import gui.Management;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Field
	JLabel lblUsername;
	JTextField txtUsername;
	private JPasswordField txtPassword;
	String url;

	Connection connection = null;

	// ham dung _ Constructor
	public Login() {
		connection = SQLiteConnection.dbConnection();
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.BLUE);
		getContentPane().setLayout(null);
		lblUsername = new JLabel("Username:");
		lblUsername.setLocation(30, 50);
		lblUsername.setSize(80, 25);
		txtUsername = new JTextField();

		txtUsername.setLocation(30, 80);
		txtUsername.setSize(150, 25);
		getContentPane().add(txtUsername);
		getContentPane().add(lblUsername);

		JLabel label = new JLabel("");
		label.setBounds(22, 128, 46, 14);
		getContentPane().add(label);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(30, 116, 80, 14);
		getContentPane().add(lblPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					String query = "select * from user where username=? and password=?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, txtUsername.getText());
					pst.setString(2, txtPassword.getText());
					ResultSet rs = pst.executeQuery();
					int count = 0;
					while (rs.next()) {
						count = count + 1;
					}
					if (count == 1) {
						new Management().setVisible(true);
						Login.this.setVisible(false);
					} else if (count > 1) {
						JOptionPane.showMessageDialog(null, "kthanhcong");
					} else {
						JOptionPane.showMessageDialog(null, "Tên đăng nhập không tồn tại");
					}
					rs.close();
					pst.close();
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, e);
				}

			}
		});
		// btnLogin.addActionListener(new ActionListener() {
		// // nut login
		// public void actionPerformed(ActionEvent arg0) {
		// login();
		// }
		// });
		btnLogin.setBounds(56, 188, 97, 37);
		getContentPane().add(btnLogin);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 30));
		lblLogin.setBackground(Color.BLUE);
		lblLogin.setBounds(71, 21, 109, 25);
		getContentPane().add(lblLogin);
		setLocationRelativeTo(null);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(30, 136, 150, 25);
		// su kien enter de dang nhap
		// txtPassword.addKeyListener(new KeyListener() {
		//
		// @Override
		// public void keyTyped(KeyEvent e) {
		// // TODO Auto-generated method stub
		//
		// }
		//
		// @Override
		// public void keyReleased(KeyEvent e) {
		// // TODO Auto-generated method stub
		// if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		// login();
		// }
		// }
		//
		// @Override
		// public void keyPressed(KeyEvent e) {
		// // TODO Auto-generated method stub
		//
		// }
		// });
		getContentPane().add(txtPassword);
	}

	public static void main(String[] args) {
		Login gui = new Login();
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(215, 300);
		gui.setTitle("Login");

	}

	// private void login() {
	//
	// String userName = txtUsername.getText();
	// char[] passArray = txtPassword.getPassword();
	// String password = new String(passArray);
	// if (userName.equals("admin") && password.equals("root")) {
	// Management mainGUI = new Management();
	// mainGUI.setVisible(true);
	// Login.this.setVisible(false);
	// } else {
	// JOptionPane.showMessageDialog(Login.this, ("sai password" + password));
	// }
	// }
	// }
}