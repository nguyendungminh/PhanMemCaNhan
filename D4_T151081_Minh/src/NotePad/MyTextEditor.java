/**
 * 
 */
package NotePad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Minh Nguyen
 *
 */
public class MyTextEditor extends JFrame {
	/**
	 * 
	 */

	JMenuBar mnbar;
	JMenu mnuFile, mnuFormat, mnuTool;
	JMenuItem mniOpen, mniExit, mniChangeBgColor, mniChangeFontColor, mniAnalyze;

	JTextArea txaContent;
	JScrollPane scrPane;

	/**
	 * @param args
	 */
	public MyTextEditor() {
		setTitle("Text Edition");
		setPreferredSize(new Dimension(600, 500));
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		initializeMenu();

		txaContent = new JTextArea();
		scrPane = new JScrollPane(txaContent);
		getContentPane().add(scrPane);
		ActionListener action = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource() == mniOpen) {
					openFile();
				} else if (e.getSource() == mniExit) {
					closeApplication();
				} else if (e.getSource() == mniChangeBgColor) {
					changeBGColor();
				} else if (e.getSource() == mniChangeFontColor) {
					changeFontColor();
				} else if (e.getSource() == mniAnalyze) {
					// cach1
					// for (String line : txaContent.getText().split("\r\n")) {
					// System.out.print(line);
					// }
					int CountSv = 0;
					int diemtu7trolen = 0;
					int diemtu45troxuong = 0;
					double Min = 10;
					double Max = 0;
					double focmax =0;
					String tenmin = null;
					String tenmax = null;
					String diemfoc = null;
					String[] lines = txaContent.getText().split("\r\n");
					
					for (int i = 1; i < lines.length; i++) {
						// System.out.print(lines[i]);
						String[] fields = lines[i].split(",");
						if (fields.length == 7) {
							String stt = fields[0];
							String sid = fields[1];
							String lastName = fields[2];
							String firstName = fields[3];
							int foc = Integer.parseInt(fields[4]);
							int introNW = Integer.parseInt(fields[5]);
							int adp = Integer.parseInt(fields[6]);
							// diem trung binh
							CountSv++;
							double average = (foc + introNW + adp) * 1.0 / 3;
							DecimalFormat scoreFormat = new DecimalFormat("#0.00");
							System.out.println(scoreFormat.format(average));
							if (average >= 7) {
								diemtu7trolen++;
							}
							if (average < 4.5) {
								diemtu45troxuong++;
							}
							if (average < Min) {
								Min = average;
								tenmin = lastName + firstName;
							}
							if (average > Max) {
								
								Max = average;
								tenmax = lastName + firstName;
								
							}
							
							if(foc>focmax){
								focmax = foc;
								diemfoc = lastName + firstName;
								
							}
						}

					}
					String mess = "so luong sinh vien : " + CountSv+ "\n";
					mess +="so luong sinh vien tren 7 :" + diemtu7trolen+"\n";
					mess+="so luong sinh vien duoi 4.5 :" + diemtu45troxuong+"\n";
					mess+="ten sinh vien co dtb nho nhat : " + tenmin+"\n";
					mess+="diem trung binh la : " + Min+"\n";
					mess+="ten sinh vien co dtb lon nhat : " + tenmax+"\n";
					mess+="diem trung binh la : " + Max+"\n";
					mess+="ten sinh vien co dtb FOC2 lon nhat : " + diemfoc+"\n";
					mess+="diem trung binh la : " + focmax+"\n";
					JOptionPane.showConfirmDialog(MyTextEditor.this, mess);
//					System.out.println("so luong sinh vien : " + CountSv);
//					System.out.println("so luong sinh vien tren 7 :" + diemtu7trolen);
//					System.out.println("so luong sinh vien duoi 4.5 :" + diemtu45troxuong);
//					System.out.println("ten sinh vien co dtb nho nhat : " + tenmin);
//					System.out.println("diem trung binh la : " + Min);
//					System.out.println("ten sinh vien co dtb lon nhat : " + tenmax );
//					System.out.println("diem trung binh la : " + Max);
//					System.out.println("ten sinh vien co dtb FOC2 lon nhat : " + diemfoc );
//					System.out.println("diem trung binh la : " + focmax);
				}
			}
		};
		mniOpen.addActionListener(action);
		mniExit.addActionListener(action);
		mniChangeBgColor.addActionListener(action);
		mniChangeFontColor.addActionListener(action);
		mniAnalyze.addActionListener(action);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				closeApplication();
			}
		});
	}

	public void initializeMenu() {
		mnbar = new JMenuBar();
		mnuFile = new JMenu("File");
		mnuFormat = new JMenu("Format");
		mnuTool = new JMenu("Tool");
		mniOpen = new JMenuItem("Open");
		mniExit = new JMenuItem("Exit");
		mniAnalyze = new JMenuItem("Analyze");
		mniChangeBgColor = new JMenuItem("ChangeBgColor");
		mniChangeFontColor = new JMenuItem("ChangeFontColor");

		mnuFile.add(mniOpen);
		mnuFile.addSeparator();
		mnuFile.add(mniExit);
		mnuTool.add(mniAnalyze);
		mnuFormat.add(mniChangeBgColor);
		mnuFormat.add(mniChangeFontColor);

		mnbar.add(mnuFile);
		mnbar.add(mnuFormat);
		mnbar.add(mnuTool);

		setJMenuBar(mnbar);
	}

	public void openFile() {
		JFileChooser fchOChooser = new JFileChooser();

		int result = fchOChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			try {
				Scanner scn = new Scanner(fchOChooser.getSelectedFile());
				while (scn.hasNextLine()) {
					txaContent.append(scn.nextLine() + "\r\n");

				}
				scn.close();
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Selected file is not found");
			}
		}
	}

	public void changeBGColor() {
		Color newcolor = JColorChooser.showDialog(this, "Choose new backround color", txaContent.getBackground());
		txaContent.setBackground(newcolor);
	}

	public void changeFontColor() {
		Color newcolor = JColorChooser.showDialog(this, "Choose new backround color", txaContent.getBackground());
		txaContent.setForeground(newcolor);
	}

	public void closeApplication() {
		int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the program?", "Confirm",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTextEditor f = new MyTextEditor();
		f.setVisible(true);
	}

}