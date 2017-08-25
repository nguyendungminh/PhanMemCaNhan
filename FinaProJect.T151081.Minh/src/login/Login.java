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
   

	// ham dung _ Constructor
	public Login() {
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
			// nut login
			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});
		btnLogin.setBounds(64, 202, 89, 23);
		getContentPane().add(btnLogin);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("VnAachen", Font.PLAIN, 15));
		lblLogin.setBackground(Color.BLUE);
		lblLogin.setBounds(71, 21, 109, 25);
		getContentPane().add(lblLogin);
		setLocationRelativeTo(null);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(30, 136, 150, 25);
		// su kien enter de dang nhap
		txtPassword.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					login();
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		getContentPane().add(txtPassword);
	}

	public static void main(String[] args) {
		Login gui = new Login();
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(215,300);
		gui.setTitle("Login");
		
		


	}

	private void login() {
		String userName = txtUsername.getText();
		char[] passArray = txtPassword.getPassword();
		String password = new String(passArray);
		if (userName.equals("admin") && password.equals("root")) {
			Management mainGUI = new Management();
			mainGUI.setVisible(true);
			Login.this.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(Login.this, ("sai password" + password));
		}
	}
}