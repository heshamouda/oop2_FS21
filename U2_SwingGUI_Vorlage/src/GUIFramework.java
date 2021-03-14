import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GUIFramework extends JFrame {

	private static final long serialVersionUID = 1L;
	private TopPanel view;
	JMenuBar wholeMenuBar = new JMenuBar();
	JMenu fileMenu, anzeigeMenu;
	JMenuItem openItem, saveItem, drehenItem, zoomItem;

	public GUIFramework() { //constructor
		// Deklaration
		view = new TopPanel();
		add(view);
		
		anzeigeMenu= new JMenu("File");
		openItem= new JMenuItem("Open");
		saveItem= new JMenuItem("Save");
		
		anzeigeMenu= new JMenu("View");
		drehenItem= new JMenuItem("Rotate");
		zoomItem= new JMenuItem("Zoom");

	}

	public static void main(String[] args) {
		GUIFramework frame = new GUIFramework();

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});

		frame.pack();
		frame.setMinimumSize(frame.getPreferredSize());

		frame.setTitle("|FHNW|EIT|OOP|Uebung GUI Elemente|");
//		frame.setSize(600, 300);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

	}

}
