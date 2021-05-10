import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: 
//Vorname:

public class BildPanel extends JPanel implements ActionListener {
	// 26
	private static final long serialVersionUID = 1L;
	private Image bild;
	private JButton btReset = new JButton("Reset");
	private JCheckBox cbSignal = new JCheckBox("Nutzsignal");
	private JCheckBox cbStoerer = new JCheckBox("Störton");
	private Controller controller;

	/**
	 * Baut das GUI gemäss Aufgabenstellung ...
	 * 
	 * <pre>
	 * - Null-Layout setzen.
	 * - Entsprechendes Attribut setzen.
	 * - Resource-Bild gegeben durch Zeichenkette stBildDatei mittels Utility-Klasse in bild laden.
	 * - Mittels setPreferredSize() die bevorzugte Grösse des Panels gleich der Grösse des Bildes plus je 20 setzen.
	 * - GUI bauen ...
	 * </pre>
	 * 
	 * @param controller
	 *            Referenz auf den Controller.
	 * @param stBildDatei
	 *            Bilddatei des Blockdiagramms.
	 */
	public BildPanel(Controller controller, String stBildDatei) {
		// ~ 12
	}

	@Override
	/**
	 * <pre>
	 * - Ruft paintComponent() der Super-Klasse auf.
	 * - Bild an der Stelle 10, 15 zeichnen.
	 * </pre>
	 */
	public void paintComponent(Graphics g) {
		// 2
	}

	@Override
	/**
	 * <pre>
	 * - Falls Quelle des Ereignisses gleich Reset - Button
	 *   - Entsprechende Methode des Controllers aufrufen.
	 * - Falls Quelle des Ereignisses gleich Checkbox Signal:
	 *   - Falls Checkbox isSelected():
	 *     - Entsprechende Methode des Controllers mit wahr aufrufen.
	 *   - Sonst:
	 *     - Entsprechende Methode des Controllers mit unwahr aufrufen.
	 * - Falls Quelle des Ereignisses gleich Checkbox Störerer:
	 *   - Falls Checkbox isSelected():
	 *     - Entsprechende Methode des Controllers mit wahr aufrufen.
	 *   - Sonst:
	 *     - Entsprechende Methode des Controllers mit unwahr aufrufen.
	 * </pre>
	 */
	public void actionPerformed(ActionEvent e) {
		// ~ 12
	}
}
