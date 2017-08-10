/**
 * 
 */
package NotePad;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
 * @author US
 *
 */
public class MyTextEditor extends JFrame {
	/**
	 * 
	 */

	JMenuBar mnbar;
	JMenu mnuFile, mnuFormat;
	JMenuItem mniOpen, mniExit, mniChangeBgColor, mniChangeFontColor;

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
				}
			}
		};
		mniOpen.addActionListener(action);
		mniExit.addActionListener(action);
		mniChangeBgColor.addActionListener(action);
		mniChangeFontColor.addActionListener(action);
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
		mniOpen = new JMenuItem("Open");
		mniExit = new JMenuItem("Exit");
		mniChangeBgColor = new JMenuItem("ChangeBgColor");
		mniChangeFontColor = new JMenuItem("ChangeFontColor");

		mnuFile.add(mniOpen);
		mnuFile.addSeparator();
		mnuFile.add(mniExit);

		mnuFormat.add(mniChangeBgColor);
		mnuFormat.add(mniChangeFontColor);

		mnbar.add(mnuFile);
		mnbar.add(mnuFormat);

		setJMenuBar(mnbar);
	}

	public void openFile() {
		JFileChooser fchOChooser = new JFileChooser();

		int result = fchOChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			try {
				Scanner scn = new Scanner(fchOChooser.getSelectedFile());
				while (scn.hasNextLine()) {
					txaContent.append(scn.nextLine() + "\n");

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
