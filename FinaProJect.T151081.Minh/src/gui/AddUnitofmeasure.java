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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Caret;

import da.BrandDA;
import da.CategoryDA;
import da.ProductDA;
import da.UnitOfMeasureDA;
import dataobject.Brand;
import dataobject.Category;
import dataobject.UnitOfMeasure;
import gui.CategoryList;
import da.UnitOfMeasureDA;

public class AddUnitofmeasure extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JComboBox<UnitOfMeasure> cmbUnit;
	private ProductDA productDA;
	private CategoryDA catDA;
	private BrandDA brandDA;
	private UnitOfMeasureDA unitDA;
	
	private JButton btnAdd;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUnitofmeasure frame = new AddUnitofmeasure();
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
	public AddUnitofmeasure() {
		productDA = new ProductDA();
		catDA = new CategoryDA();
		brandDA = new BrandDA();
		unitDA = new UnitOfMeasureDA();
		
		initGUI();
	}

	private void initGUI() {
		setResizable(false);
		setTitle("Add UnitOfMeasure");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 339, 273);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("UnitOfMeasure Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(21, 99, 103, 23);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(134, 102, 173, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblAddProduct = new JLabel("AddBrand");
		lblAddProduct.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddProduct.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddProduct.setBounds(60, 30, 229, 33);
		contentPane.add(lblAddProduct);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(119, 177, 89, 23);
		contentPane.add(btnAdd);
		btnAdd.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(218, 177, 89, 23);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(this);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAdd){
			addUnit();
			unitDA.getUnitOfMeasure();
			JOptionPane.showMessageDialog(this,"add completed");
			
			unitDA = new UnitOfMeasureDA();
			DefaultTableModel model = unitDA.getUnitOfMeasure1();
			gui.UnitOfMeasureList.tableUnitOfMeasure.setModel(model);
			
		}else if(e.getSource() == btnCancel){
			AddUnitofmeasure.this.dispose();
		}
		
	}

	private void addUnit() {
		String Name = txtName.getText();
		unitDA.insert(Name);
	}
}
