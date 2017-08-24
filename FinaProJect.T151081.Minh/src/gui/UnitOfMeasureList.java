package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import da.BrandDA;
import da.CategoryDA;
import da.ProductDA;
import da.UnitOfMeasureDA;
import dataobject.Category;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class UnitOfMeasureList extends JFrame implements ActionListener {

	private JPanel contentPane;
	public static JTable tableUnitOfMeasure;
	

	CategoryDA categoryDA;
	UnitOfMeasureDA UnitDA;
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
					UnitOfMeasureList frame = new UnitOfMeasureList();
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
	public UnitOfMeasureList() {
		setTitle("UnitOfMeasure Management");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		tableUnitOfMeasure = new JTable();
		getUnitofMeasureList();
		scrollPane.setViewportView(tableUnitOfMeasure);

		panelTop = new JPanel();
		panelTop.setPreferredSize(new Dimension(200, 30));
		panelTop.setLayout(null);
		contentPane.add(panelTop, BorderLayout.NORTH);

		btnAdd = new JButton("Add");
		btnAdd.setBounds(0, 0, 93, 23);
		btnAdd.addActionListener(this);
		panelTop.add(btnAdd);

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(103, 0, 113, 23);
		btnUpdate.addActionListener(this);
		panelTop.add(btnUpdate);
	}

	private void getUnitofMeasureList() {
		UnitDA= new UnitOfMeasureDA();
		DefaultTableModel model = UnitDA.getUnitOfMeasure1();
		tableUnitOfMeasure.setModel(model);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdd) {
			AddUnit();
			
		} else if (e.getSource() == btnUpdate) {
			UpdateUnit();
		}

	}

	private void UpdateUnit() {

		int selectedRowIndex = tableUnitOfMeasure.getSelectedRow();
		if (selectedRowIndex != -1) {
			int selectedUnitID = (int) tableUnitOfMeasure.getModel().getValueAt(selectedRowIndex, 0);
			UpdateUnitOfMeasure unitGui= new UpdateUnitOfMeasure(selectedUnitID);
			unitGui.setVisible(true);

		}

	}

	private void AddUnit() {
		AddUnitofmeasure addGui = new AddUnitofmeasure();
		addGui.setVisible(true);

	}
}
