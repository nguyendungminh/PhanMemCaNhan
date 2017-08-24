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

public class UpdateUnitOfMeasure extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JComboBox<Brand> cmbBrand;
	private ProductDA productDA;
	private CategoryDA catDA;
	private BrandDA brandDA;
	private UnitOfMeasureDA unitDA;
	
	private JButton btnUpdate;
	private JButton btnCancel;
	public int UnitID = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBrand frame = new AddBrand();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param BID 
	 */
	public UpdateUnitOfMeasure(int UID) {
		productDA = new ProductDA();
		catDA = new CategoryDA();
		brandDA = new BrandDA();
		unitDA = new UnitOfMeasureDA();
		UnitID = UID;
		
		catDA = new CategoryDA();
		
		initGUI();
		UnitOfMeasure c = unitDA.getUnitOfMeasure(UnitID);
		txtName.setText(c.getName());
	}

	private void initGUI() {
		setResizable(false);
		setTitle("Add UnitOfMeasure");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 339, 290);
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
		
		btnUpdate = new JButton("Add");
		btnUpdate.setBounds(80, 188, 89, 23);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener(this);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(208, 188, 89, 23);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(this);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnUpdate){
			UpdateUnitOfMeasure();
			unitDA.getUnitOfMeasure();
			JOptionPane.showMessageDialog(this,"add completed");
			
			brandDA = new BrandDA();
			DefaultTableModel model = unitDA.getUnitOfMeasure1();
			gui.UnitOfMeasureList.tableUnitOfMeasure.setModel(model);
			
		}else if(e.getSource() == btnCancel){
			UpdateUnitOfMeasure.this.dispose();
		}
		
	}

	private void UpdateUnitOfMeasure() {
		String Name = txtName.getText();
		
//		brandDA.update(Name,UnitID);
	}
}
