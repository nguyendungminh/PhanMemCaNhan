package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import da.ProductDA;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ProductList extends JFrame implements ActionListener{

	private JPanel contentPane;
	public static JTable tableProduct;
	ProductDA productDA;
	private JPanel panelTop;
	private JButton btnUpdate;
	private JButton btnAdd;

	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductList frame = new ProductList();
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
	public ProductList() {
		setTitle("Product Management");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 685, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		tableProduct = new JTable();
		getProductList();
		scrollPane.setViewportView(tableProduct);
		
		panelTop = new JPanel();
		panelTop.setPreferredSize(new Dimension(200, 30));
		panelTop.setLayout(null);
		contentPane.add(panelTop, BorderLayout.NORTH);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(0, 0, 123, 23);
		btnAdd.addActionListener(this);
		panelTop.add(btnAdd);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(133, 0, 123, 23);
		btnUpdate.addActionListener(this);
		panelTop.add(btnUpdate);
	}

	public void getProductList() {
		productDA = new ProductDA();
		DefaultTableModel model = productDA.getProducts();
		tableProduct.setModel(model);
	} 
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdd){
			addProduct();
			
		}else if(e.getSource() == btnUpdate){
			updateProduct();
		
		}
	}
	
	
	

	private void updateProduct() {
		
		int selectedRowIndex = tableProduct.getSelectedRow();
		if(selectedRowIndex != -1){ 
			int selectedProductID = (int) tableProduct.getModel().getValueAt(selectedRowIndex, 0);
			
			UpdateProduct updateGUI = new UpdateProduct(selectedProductID);
			updateGUI.setVisible(true);
			
		}
				
	}

	private void addProduct() {
		AddProduct addGui = new AddProduct();
		addGui.setVisible(true);		
	}
	
}
