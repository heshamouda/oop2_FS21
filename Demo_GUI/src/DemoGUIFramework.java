import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class DemoGUIFramework extends JFrame implements ActionListener {

	JMenuBar wholeMenuBar = new JMenuBar();
	JMenu fileMenu, editMenu, sourceMenu;
	JMenuItem openItem, saveItem, copyItem, pasteItem, toggleItem;

	public DemoGUIFramework() {
		// Deklaration

		// Erzeugen, Anzeigen und Registrieren
		// der Ereignisbehandlung, Datei Menue mit Oeffnen, Speichern
		fileMenu = new JMenu("Datei");
		openItem = new JMenuItem("Oeffnen");
		fileMenu.add(openItem);
		openItem.addActionListener(this);
		saveItem = new JMenuItem("Speichern");
		fileMenu.add(saveItem);
		saveItem.addActionListener(this);
		wholeMenuBar.add(fileMenu);
		
		editMenu = new JMenu("Bearbeiten");
		copyItem = new JMenuItem("kopieren");
		editMenu.add(copyItem);
		wholeMenuBar.add(editMenu);
		

		// Menubar setzen
		setJMenuBar(wholeMenuBar);

	}

	public static void main(String[] args) {
		DemoGUIFramework frame = new DemoGUIFramework();

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});

		GUIPanel view = new GUIPanel();
		frame.add(view);
		frame.pack();
		frame.setMinimumSize(frame.getPreferredSize());

		frame.setTitle("|FHNW|EIT|OOP|Demo GUI Elemente|");
		frame.setSize(600, 300);
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
		if(e.getSource() == saveItem ) {
			System.out.println("Datei speichern");
		}
		
	}

}
