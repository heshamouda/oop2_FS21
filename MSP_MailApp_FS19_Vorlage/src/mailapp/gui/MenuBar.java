// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
// Modulanlass:

package mailapp.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import mailapp.model.Mailer;
import util.TraceV7;

public class MenuBar extends JMenuBar implements ActionListener {
	private static final long serialVersionUID = 1L;
	private TraceV7 trace = new TraceV7(this);
	// 13
	private JMenuItem menuItemAccount = new JMenuItem("Mail-Account"), menuItemExit = new JMenuItem("Exit");

	/**
	 * <pre>
	 * - Baut das Menu gemäss Aufgabenstellung und Klassendiagramm.
	 * </pre>
	 * 
	 * @param frame
	 */
	public MenuBar(JFrame frame) {
		trace.constructorCall();
		// 7
	}

	/**
	 * <pre>
	 * - Falls Quelle gleich dem Account-Item:
	 *   - Account-Dialog mittels showDialog() zeigen und 
	 *   - Falls der Rückgabewert gleich APPROVE_OPTION des Dialogs:
	 *     - MailServer, Password etc. mittels entsprechender
	 *       Setter-Methode der Klasse Mailer entsprechend dem 
	 *       Wert im Account-Dialog setzen. 
	 * 		 Tipp: Schauen Sie sich das Klassendiagramm an.
	 * -Sonst
	 *   - Programm mittels System.exit() beenden.
	 * </pre>
	 */
	public void actionPerformed(ActionEvent e) {
		trace.eventCall();
		// 8
	}
}
