package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import da.SQLiteDB;
import dataobject.Brand;
import dataobject.Category;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddProduct extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private SQLiteDB salesDB;
	private AbstractButton comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProduct frame = new AddProduct();
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
	public AddProduct() {
		salesDB = new SQLiteDB();
		salesDB.getCategories();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(10, 47, 96, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Category");
		lblNewLabel_1.setBounds(10, 72, 96, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Unit Price");
		lblNewLabel_2.setBounds(10, 96, 96, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Unit In Tock");
		lblNewLabel_3.setBounds(10, 121, 96, 14);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(116, 44, 196, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(116, 93, 196, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(116, 118, 196, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("THEM");
		
		btnNewButton.setBounds(48, 159, 86, 36);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
//				System.out.println(comboBox.getSelectedItem());
				Category cat = (Category)comboBox.getSelectedItem();
				System.out.println(cat.getCategoryId()+"-"+cat.getCategoryName());
			}
		});
		Vector<Category>catList = salesDB.getCategories();
		comboBox.setModel(new DefaultComboBoxModel(catList));
		comboBox.setBounds(116, 69, 196, 20);
		
		contentPane.add(comboBox);
		
		JLabel lblAddProduct = new JLabel("Add Product");
		lblAddProduct.setBounds(82, 11, 108, 14);
		contentPane.add(lblAddProduct);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String productName = textField.getText();
				double unitPrice= Double.parseDouble(textField_1.getText());
				int unitinStock = Integer.parseInt(textField_2.getText());
				Category selectedCat = (Category)comboBox.getSelectedItem();
				int catId= selectedCat.getCategoryId();
		 salesDB.insert(pCode, PName, categoryid, brandid, unitofmeasure, uniprice, description);
				salesDB.getAllProducts();
				
			}
		});
	}
}
