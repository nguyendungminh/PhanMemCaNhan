package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import da.BrandDA;
import da.CategoryDA;
import da.ProductDA;
import da.SQLiteDB;
import da.UnitofmeasureDA;
import dataobject.Brand;
import dataobject.Category;
import dataobject.Uniofmeasure;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.util.Vector;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddProduct extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textFieldName;
	private SQLiteDB foc2warehouseDb;
	private JTextField textFieldPrice;
	private JTextField textFieldProductCode;
	private ProductDA productDA;
	private BrandDA brandDA;
	private CategoryDA catDA;
	private UnitofmeasureDA unitDA;
	private JButton btnOk;
	private JButton btnCancel;
	private JComboBox comboBox_Ca;
	private JComboBox comboBox_Measure;
	private JComboBox comboBox_Brand;

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
		productDA = new ProductDA();
		catDA = new CategoryDA();
		brandDA = new BrandDA();
		unitDA = new UnitofmeasureDA();
		
		
		setType(Type.UTILITY);
		
		foc2warehouseDb = new SQLiteDB();
		foc2warehouseDb.getAllCategories();
		
		//foc2warehouse = new SQLiteDB();
		//foc2warehouse.getAllCategories();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 316, 332);
		contentPane = new JPanel();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddProduct = new JLabel("Add Product");
		lblAddProduct.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblAddProduct.setBounds(97, 11, 118, 32);
		contentPane.add(lblAddProduct);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(25, 81, 46, 14);
		contentPane.add(lblNewLabel);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(128, 82, 152, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Categoryid");
		lblNewLabel_1.setBounds(25, 112, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		comboBox_Ca = new JComboBox();
		comboBox_Ca.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				//System.out.println(comboBox.getSelectedItem());
				Category cat = (Category)comboBox_Ca.getSelectedItem();
				
			}
		});
		
		
		Vector<Category> catList = foc2warehouseDb.getAllCategories();
		comboBox_Ca.setModel(new DefaultComboBoxModel(catList));
		
		comboBox_Ca.setBounds(128, 113, 152, 20);
		contentPane.add(comboBox_Ca);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(25, 209, 46, 14);
		contentPane.add(lblPrice);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setBounds(128, 206, 152, 20);
		contentPane.add(textFieldPrice);
		textFieldPrice.setColumns(10);
		
		JLabel lblInstock = new JLabel("Product Code");
		lblInstock.setBounds(25, 53, 86, 14);
		contentPane.add(lblInstock);
		
		textFieldProductCode = new JTextField();
		textFieldProductCode.setBounds(128, 54, 152, 20);
		contentPane.add(textFieldProductCode);
		textFieldProductCode.setColumns(10);
		btnOk = new JButton("Ok");
		btnOk.setBounds(35, 245, 89, 23);
		btnOk.addActionListener(this);
		contentPane.add(btnOk);
	
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(171, 245, 89, 23);
		btnCancel.addActionListener(this);
		contentPane.add(btnCancel);
		
		JLabel lblUnitOfMeasure = new JLabel("Unit of Measure");
		lblUnitOfMeasure.setBounds(25, 143, 93, 14);
		contentPane.add(lblUnitOfMeasure);
		
		comboBox_Measure = new JComboBox();
		comboBox_Measure.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				Uniofmeasure uom = (Uniofmeasure)comboBox_Measure.getSelectedItem();
			}
		});
		
		Vector<Uniofmeasure> unitOfMeasuresList = foc2warehouseDb.getAllUnitOfMeasure();
		comboBox_Measure.setModel(new DefaultComboBoxModel(unitOfMeasuresList));
		
		comboBox_Measure.setBounds(128, 144, 152, 20);
		contentPane.add(comboBox_Measure);
		
		JLabel lblBrand = new JLabel("Brand");
		lblBrand.setBounds(25, 174, 86, 14);
		contentPane.add(lblBrand);
		
		comboBox_Brand = new JComboBox();
		comboBox_Brand.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				Brand bra = (Brand)comboBox_Brand.getSelectedItem();
			}
		});
		
		Vector<Brand> BrandList = foc2warehouseDb.getAllBrands();
		comboBox_Brand.setModel(new DefaultComboBoxModel(BrandList));
		comboBox_Brand.setBounds(128, 175, 152, 20);
		contentPane.add(comboBox_Brand);
		
		
	}
		
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnOk){
			AddProduct();
			foc2warehouseDb.getAllProducts();
		}else if (e.getSource()==btnCancel){
			AddProduct.this.dispose();// dispose de thoat
		}
		
	}

	private void AddProduct() {
		String productname = textFieldName.getText();
		String productcode = textFieldProductCode.getText();
		double unitUnitprice = Double.parseDouble(textFieldPrice.getText());
		int unitStock = Integer.parseInt(textFieldProductCode.getText());
		Category selectedCat = (Category) comboBox_Ca.getSelectedItem();
		Brand selectedBra = (Brand) comboBox_Brand.getSelectedItem();
		Uniofmeasure selectUnit= (Uniofmeasure) comboBox_Measure.getSelectedItem();
		String BraId = selectedBra.getBrandName();
		String MeaId = selectUnit.getName();
		int catId = selectedCat.getCategoryId();
	}
}
