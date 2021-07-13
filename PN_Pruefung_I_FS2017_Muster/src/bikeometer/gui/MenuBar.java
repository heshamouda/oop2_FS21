package bikeometer.gui;

// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
// Klasse:
//

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar implements ActionListener {
	// 1 + 17 = 18
	private static final long serialVersionUID = 1L;
	private JMenu menu;
	private JMenuItem menuItemLadeImage, menuItemExit;
	private JFileChooser fc = new JFileChooser("./");
	private Controller controller;

	/**
	 * <pre>
	 * - Erzeugt und platziert sämtliche Elemente des Menus.
	 * - Registriert ActionListener.
	 * - Setzt Attribut controller entsprechend controller.
	 * </pre>
	 * 
	 * @param controller
	 */
	public MenuBar(Controller controller) {
		// 10
		this.controller = controller;
		menu = new JMenu("Datei");
		add(menu);
		menuItemLadeImage = new JMenuItem("Lade Image", KeyEvent.VK_I);
		menuItemLadeImage.addActionListener(this);
		menu.add(menuItemLadeImage);
		menuItemExit = new JMenuItem("Exit", KeyEvent.VK_E);
		menuItemExit.addActionListener(this);
		menu.add(menuItemExit);
		add(menu);
	}

	/**
	 * <pre>
	 * - Falls Quelle des Ereigniss "Lade Image" - MenuItem
	 * 		- Open-Dialog des JFileChooser zeigen
	 * 		- Falls der Rückgabewert von öffnen gleich APPROVE_OPTION
	 * 			- Mittels Methode loadXYBackgroundImage() des controllers Bild laden.
	 * - Falls Quelle des Ereigniss "Exit" - MenuItem
	 * 		- Programm beenden.
	 * </pre>
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		// 7
		if (e.getSource() == menuItemLadeImage) {
			int returnVal = fc.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				controller.loadXYBackgroundImage(file.getPath());
			}
		}
		if (e.getSource() == menuItemExit) {
			System.exit(0);
		}
	}

}
