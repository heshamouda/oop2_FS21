import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class GUIFramework extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private TopPanel view;
	JMenuBar wholeMenuBar = new JMenuBar();
	JMenu fileMenu, anzeigeMenu;
	JMenuItem openItem, saveItem, drehenItem, zoomItem;

	public GUIFramework() {
		// Deklaration
		view = new TopPanel();
		add(view);

		// Erzeugen, Anzeigen und Registrieren
		// der Ereignisbehandiung, Datei Menue mit Oeffnen, Speichern
		fileMenu = new JMenu("Datei");
		openItem = new JMenuItem("Oeffnen");
		fileMenu.add(openItem);
		openItem.addActionListener(this);
		saveItem = new JMenuItem("Speichern");
		fileMenu.add(saveItem);
		saveItem.addActionListener(this);
		wholeMenuBar.add(fileMenu);
		
		anzeigeMenu = new JMenu("Anzeigen");
		drehenItem = new JMenuItem("drehen");
		zoomItem = new JMenuItem("zoom");
		anzeigeMenu.add(drehenItem);
		//drehenItem.addActionListener(this);
		drehenItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Anzeige drehen");
				
			}
		} );
		anzeigeMenu.add(zoomItem);
		wholeMenuBar.add(anzeigeMenu);
		

		// Menubar setzen
		setJMenuBar(wholeMenuBar);

	}

	public static void main(String[] args) {
		GUIFramework frame = new GUIFramework();

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});

//		view = new TopPanel();
//		frame.add(view);
		frame.pack();
		frame.setMinimumSize(frame.getPreferredSize());

		frame.setTitle("|FHNW|EIT|OOP|Uebung GUI Elemente|");
//		frame.setSize(600, 300);
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
//		view.buttonPanel.btBerechne.doClick();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == openItem ) {
			System.out.println("Datei öffnen");
			
		}
//		if(e.getSource() == drehenItem ) {
//			System.out.println("Anzeige drehen");
//		}
		
	}

}
