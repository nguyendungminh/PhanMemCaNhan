package D2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CreatAccount extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_6;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreatAccount frame = new CreatAccount();
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
	public CreatAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 688);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		// Panel 1 chứa thông tin
		JPanel addAccountPane = new JPanel();
		addAccountPane.setBackground(Color.LIGHT_GRAY);
		contentPane.add(addAccountPane, "name_10955706764635");
		addAccountPane.setLayout(new BorderLayout(0, 0));
		
		//Panel chứa thông tin tài khoản và nút Text
		JPanel accountInfoPane = new JPanel();
		accountInfoPane.setBackground(SystemColor.activeCaption);
		addAccountPane.add(accountInfoPane, BorderLayout.CENTER);
		accountInfoPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CREAT YOUR ACCOUNT");
		lblNewLabel.setFont(new Font("VnClarendon2", Font.PLAIN, 25));
		lblNewLabel.setBounds(33, 11, 404, 68);
		accountInfoPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setBounds(37, 111, 151, 14);
		accountInfoPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name");
		lblNewLabel_2.setBounds(230, 111, 100, 14);
		accountInfoPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(33, 136, 172, 20);
		accountInfoPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(230, 136, 169, 20);
		accountInfoPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Chose your username");
		lblNewLabel_3.setBounds(33, 167, 212, 14);
		accountInfoPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(33, 192, 366, 20);
		accountInfoPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Craete a password");
		lblNewLabel_4.setBounds(33, 223, 212, 14);
		accountInfoPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Confirm your password");
		lblNewLabel_5.setBounds(33, 279, 212, 14);
		accountInfoPane.add(lblNewLabel_5);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setBounds(33, 335, 107, 14);
		accountInfoPane.add(lblBirthday);
		
		JLabel lblNewLabel_6 = new JLabel("Gender");
		lblNewLabel_6.setBounds(33, 391, 46, 14);
		accountInfoPane.add(lblNewLabel_6);
		
		textField_5 = new JTextField();
		textField_5.setBounds(33, 360, 86, 20);
		accountInfoPane.add(textField_5);
		textField_5.setColumns(10);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBounds(33, 412, 76, 23);
		rdbtnNewRadioButton.setOpaque(false);
		accountInfoPane.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Remale");
		rdbtnNewRadioButton_1.setBounds(111, 412, 86, 23);
		rdbtnNewRadioButton_1.setOpaque(false);
		accountInfoPane.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnOther = new JRadioButton("Other");
		rdbtnOther.setBounds(199, 412, 79, 23);
		rdbtnOther.setOpaque(false);
		accountInfoPane.add(rdbtnOther);
		
		JLabel lblMobilePhone = new JLabel("Mobile Phone");
		lblMobilePhone.setBounds(33, 442, 76, 14);
		accountInfoPane.add(lblMobilePhone);
		
		textField_6 = new JTextField();
		textField_6.setBounds(33, 467, 366, 20);
		accountInfoPane.add(textField_6);
		textField_6.setColumns(10);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("I agree to the Terms of Service");
		chckbxNewCheckBox.setBounds(33, 494, 212, 23);
		chckbxNewCheckBox.setOpaque(false);
		accountInfoPane.add(chckbxNewCheckBox);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(33, 248, 366, 20);
		accountInfoPane.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(33, 304, 366, 20);
		accountInfoPane.add(passwordField_1);
		
		textField_3 = new JTextField();
		textField_3.setBounds(227, 360, 172, 20);
		accountInfoPane.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox<?> comboBox = new JComboBox<Object>();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		comboBox.setBounds(129, 360, 88, 20);
		accountInfoPane.add(comboBox);
		
		JComboBox<?> comboBox_1 = new JComboBox<Object>();
		comboBox_1.setBounds(189, 360, 28, 20);
		accountInfoPane.add(comboBox_1);
		// Panle chứa nút Text
		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(UIManager.getColor("ProgressBar.shadow"));
		buttonPane.setPreferredSize(new Dimension(0,70));
		buttonPane.setSize(100,100);
		addAccountPane.add(buttonPane,BorderLayout.SOUTH);
		buttonPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Next");
		
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnNewButton.setBounds(138, 11, 120, 35);
		buttonPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "name_11545537692919");
		panel.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setFont(new Font("VnSerpentine2", Font.PLAIN, 29));
		lblWelcome.setBounds(125, 64, 289, 73);
		panel.add(lblWelcome);
		
		JLabel lblNewLabel_7 = new JLabel("Thanks for creating an account");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_7.setBounds(33, 475, 404, 53);
		panel.add(lblNewLabel_7);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Minh\\user.png"));
		label.setBounds(71, 148, 343, 289);
		panel.add(label);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO: kiểm tra thông tin hợp lệ
				
				// TODO: lưu vào cơ sở dữ liệu
				
				// TODO: chuyển đến màng hình thông báo thành công
				CardLayout cards = (CardLayout)contentPane.getLayout();
				
				cards.next(contentPane);//qua trang tiep theo
				
			}
		});
		
	}
}
