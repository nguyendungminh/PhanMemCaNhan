import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
public class Ex1_T151081_Minh extends JFrame{
	//Field
	JLabel lblUsername;
	JTextField txtUsername;
	private JPasswordField txtPassword;
	//ham dung _ Constructor
	public Ex1_T151081_Minh(){
		setResizable(false);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.BLUE);
		getContentPane().setLayout(null);
		 lblUsername = new JLabel("Username:");
		 lblUsername.setLocation(30,50);
		 lblUsername.setSize(80,25);
		 txtUsername = new JTextField();
		 txtUsername.addFocusListener(new FocusAdapter() {
			//mau me do choi :3
			@Override
		 	public void focusLost(FocusEvent e) {
		 		txtPassword.setBackground(Color.BLUE);
		 	}

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				// mau cho text... chon text nao de thay doi mau
				super.focusGained(arg0);
			}
		 	
		 });
		 //su kien enter de dang nhap
		 
		 txtUsername.setLocation(30,80);
		 txtUsername.setSize(150,25);
		getContentPane().add(txtUsername);
		getContentPane().add(lblUsername);
		
		JLabel label = new JLabel("");
		label.setBounds(22, 128, 46, 14);
		getContentPane().add(label);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(30, 116, 46, 14);
		getContentPane().add(lblPassword);
		
		JCheckBox chckbxRememberMe = new JCheckBox("Remember Me");
		chckbxRememberMe.setBounds(30, 168, 97, 23);
		getContentPane().add(chckbxRememberMe);
		
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
txtPassword.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER){
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
	public static void main(String[] args){
		Ex1_T151081_Minh gui = new Ex1_T151081_Minh();
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(215,300);
		
	}
	private void login() {
		String userName = txtUsername.getText();
		char[] passArray = txtPassword.getPassword();
		String password = new String(passArray);
		if(userName.equals("admin")&& password.equals("root")){
		//JOptionPane.showMessageDialog(Ex1_T151081_Minh.this,"Hello"+userName);
			Mainwindow mainGUI = new Mainwindow();
			mainGUI.setVisible(true);
			Ex1_T151081_Minh.this.setVisible(false);
		}else{
			JOptionPane.showMessageDialog(Ex1_T151081_Minh.this,("hihi bien :3"+password));
		}
	}
}