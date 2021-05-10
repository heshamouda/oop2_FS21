package ch.fhnw.eit.oop2.wavegenerator.gui;
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import ch.fhnw.eit.oop2.wavegenerator.model.Model;

public class InputPanel extends JPanel implements ActionListener {
	// 41
	private static final long serialVersionUID = 1L;
	private static final int AMPLITUDE = 0, FREQUENCY = 1;

	private JButton[] jbtInput = new JButton[12];
	private String[] stInput = { "7", "8", "9", "4", "5", "6", "1", "2", "3", "Clear", "0", "Enter" };
	private JTextField jtfNumber;
	private JPanel jpNumField;
	private JToggleButton jtbAmplitude;
	private JToggleButton jtbFrequency;
	private ButtonGroup btGroup;

	private int inputMode = AMPLITUDE;

	private Controller controller;

	/**
	 * <pre>
	 * - Setzt Attribut des Controllers.
	 * - Baut User-Interface gemäss Beschreibung in der Aufagbestellung.
	 * 
	 * </pre>
	 * 
	 * @param controller
	 * @param model
	 */
	public InputPanel(Controller controller, Model model) {
		// 19

	}

	/**
	 * <pre>
	 * - Falls Quelle jtbAmplitude: inputMode gleich AMPLITUDE, Text in Feld gleich 0, Einheit durch Aufruf der Methode im Controller auf DigitDisplay.VPP stellen, return.
	 * - Falls Quelle jtbFrequency: inputMode gleich FREQUENCY, Text in Feld gleich 0, Einheit durch Aufruf der Methode im Controller auf DigitDisplay.KHZ stellen, return.
	 * - Falls Quelle "Clear": Text in TextFeld gleich 0, return.
	 * - Falls Quelle "Enter":
	 *   - Falls inputMode gleich AMPLITUDE:
	 *     - Entsprechende Methode des Controllers mit Zahlen - Wert in TextFeld aufrufen.
	 *   - Sonst: 
	 *     - Entsprechende Methode des Controllers mit Zahlen - Wert in TextFeld aufrufen.
	 *   - Text in TextFeld gleich 0, return.
	 * - Zahl in TextFeld gleich 10 mal Zahl in TextFeld plus gedrückte Zahl setzen.
	 * </pre>
	 */
	public void actionPerformed(ActionEvent e) {
		// 22

	}
}
