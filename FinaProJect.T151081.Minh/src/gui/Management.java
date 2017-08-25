package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Management extends JFrame {

	private JPanel contentPane;
	private JButton btnProduct;
	private JButton btnCategory;
	private JButton btnBrand;
	private JButton btnUnitofMeasure;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Management frame = new Management();
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
	public Management() {
		setResizable(false);
		setTitle("Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnProduct = new JButton("Product");
		btnProduct.setFont(new Font("Vivaldi", Font.PLAIN, 30));
		btnProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnProduct){
					new ProductList().setVisible(true);
				}
			}
		});
		
			
		btnProduct.setBounds(10, 218, 467, 58);
		contentPane.add(btnProduct);
		
		btnCategory = new JButton("Category");
		btnCategory.setFont(new Font("Vivaldi", Font.PLAIN, 30));
		btnCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnCategory){
					new CategoryList().setVisible(true);
				}
			}
		});
		btnCategory.setBounds(10, 80, 229, 58);
		contentPane.add(btnCategory);
		
		btnBrand = new JButton("Brand");
		btnBrand.setFont(new Font("Vivaldi", Font.PLAIN, 30));
		btnBrand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnBrand){
					new BrandList().setVisible(true);
				}
			}
		});
		btnBrand.setBounds(10, 149, 229, 58);
		contentPane.add(btnBrand);
		
		btnUnitofMeasure = new JButton("UnitOfMeasure");
		btnUnitofMeasure.setFont(new Font("Vivaldi", Font.PLAIN, 30));
		btnUnitofMeasure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== btnUnitofMeasure){
					new UnitOfMeasureList().setVisible(true);
				}
			}
		});
		btnUnitofMeasure.setBounds(10, 11, 229, 58);
		contentPane.add(btnUnitofMeasure);
		
		JButton btnUser = new JButton("User");
		btnUser.setFont(new Font("Vivaldi", Font.PLAIN, 30));
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== btnUser) {
				new UserList().setVisible(true);
				}
			}
		});
		btnUser.setBounds(249, 149, 228, 58);
		contentPane.add(btnUser);
		
		JButton btnInventory = new JButton("Inventory");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DepartmentList().setVisible(true);
			}
		});
		btnInventory.setFont(new Font("Vivaldi", Font.PLAIN, 30));
		btnInventory.setBounds(248, 11, 229, 58);
		contentPane.add(btnInventory);
		
		JButton btnWarehouse = new JButton("Warehouse");
		btnWarehouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				new WarehouseList().setVisible(true);
			}
		});
		btnWarehouse.setFont(new Font("Vivaldi", Font.PLAIN, 30));
		btnWarehouse.setBounds(248, 80, 229, 58);
		contentPane.add(btnWarehouse);
	}
}
