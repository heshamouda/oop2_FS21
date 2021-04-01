package soundeditor.gui;

// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
// Klasse:
//

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar implements ActionListener {
	// 20
	private static final long serialVersionUID = 1L;
	private JMenu menu;
	private JMenuItem menuItemOpen, menuItemSave;
	private JFileChooser jfChooser = new JFileChooser("./");
	private Controller controller;

	/**
	 * Baut die MenuBar gemäss Bild in der Aufgabenstellung.
	 * 
	 * @param controller
	 */
	public MenuBar(Controller controller) {
		// 10
	}

	/**
	 * 
	 * <pre>
	 * - Falls Quelle des Ereignis gleich menuItemOpen:
	 * 	   - Open-Dialog des JFileChooser zeigen
	 * 	   - Falls der Rückgabewert von öffnen gleich APPROVE_OPTION
	 * 	     - Mittels Methode loadSoundTrack() des controllers selektionierte 
	 *         WAV-Datei laden.
	 * - Falls Quelle des Ereigniss gleich menuItemSave:
	 * 	   - Save-Dialog des JFileChooser zeigen
	 * 	   - Falls der Rückgabewert von speicher gleich APPROVE_OPTION
	 * 	     - Mittels Methode saveSoundTrack() des controllers  
	 *         WAV-Datei speichern.
	 * </pre>
	 */
	public void actionPerformed(ActionEvent e) {
		// 10
	}
}
