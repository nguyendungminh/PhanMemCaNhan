package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 358, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnProduct = new JButton("Product");
		btnProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnProduct){
					new ProductList().setVisible(true);
				}
			}
		});
		
			
		btnProduct.setBounds(10, 11, 155, 23);
		contentPane.add(btnProduct);
		
		btnCategory = new JButton("Category");
		btnCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnCategory){
					new CategoryList().setVisible(true);
				}
			}
		});
		btnCategory.setBounds(10, 45, 155, 23);
		contentPane.add(btnCategory);
		
		btnBrand = new JButton("Brand");
		btnBrand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnBrand){
					new BrandList().setVisible(true);
				}
			}
		});
		btnBrand.setBounds(10, 79, 155, 23);
		contentPane.add(btnBrand);
		
		btnUnitofMeasure = new JButton("UnitOfMeasure");
		btnUnitofMeasure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== btnUnitofMeasure){
					new UnitOfMeasureList().setVisible(true);
				}
			}
		});
		btnUnitofMeasure.setBounds(10, 113, 155, 23);
		contentPane.add(btnUnitofMeasure);
		
		JButton btnUser = new JButton("User");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()== btnUser) {
				new UserList().setVisible(true);
				}
			}
		});
		btnUser.setBounds(175, 113, 157, 23);
		contentPane.add(btnUser);
	}
}
