package gui;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Caret;

import da.BrandDA;
import da.CategoryDA;
import da.ProductDA;
import da.UnitOfMeasureDA;
import da.UserDA;
//import da.WarehouseDA;
import dataobject.Brand;
import dataobject.Category;
import dataobject.UnitOfMeasure;
import gui.UserList;;

public class AddUser extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;
	
	private ProductDA productDA;
	private CategoryDA catDA;
	private BrandDA brandDA;
	private UnitOfMeasureDA unitDA;
//	private WarehouseDA warehousrDA;
	private UserDA userDA;
	
	private JButton btnAdd;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser frame = new AddUser();
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
	public AddUser() {
		productDA = new ProductDA();
		catDA = new CategoryDA();
		brandDA = new BrandDA();
		unitDA = new UnitOfMeasureDA();
//		warehousrDA = new WarehouseDA();
		userDA = new UserDA();
		
		initGUI();
	}

	private void initGUI() {
		setResizable(false);
		setTitle("Add User - Thanh Phuc");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 339, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("User Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(22, 86, 103, 23);
		contentPane.add(lblName);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(135, 89, 173, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lbDescription = new JLabel("Password");
		lbDescription.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbDescription.setBounds(22, 139, 74, 14);
		contentPane.add(lbDescription);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(134, 136, 173, 20);
		contentPane.add(txtPassword);
		
		JLabel lblAddProduct = new JLabel("Add user");
		lblAddProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddProduct.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddProduct.setBounds(60, 30, 229, 33);
		contentPane.add(lblAddProduct);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(60, 243, 89, 23);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(179, 243, 89, 23);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(this);
		//Vector<Category> catList = catDA.getAllCategories();
		//Vector<UnitOfMeasure>unitList = unitDA.getUnitOfMeasure();
		//Vector<Brand> brandList = brandDA.getBrands();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdd){
			addUser();
			userDA.getAllUsers();
			JOptionPane.showMessageDialog(this,"add completed");
			
			userDA = new UserDA();
			DefaultTableModel model = userDA.getUser1();
			gui.UserList.tableUser.setModel(model);
			
		}else if(e.getSource() == btnCancel){
			AddUser.this.dispose();
		}
		
	}

	private void addUser() {
		String Username = txtUsername.getText();
		
		String Password = txtPassword.getText();
		
		userDA.insert(Username, Password);
	}
}
