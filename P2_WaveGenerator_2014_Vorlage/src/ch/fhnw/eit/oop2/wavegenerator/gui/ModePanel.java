package ch.fhnw.eit.oop2.wavegenerator.gui;
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class ModePanel extends JPanel implements ActionListener {
	// 19
	private static final long serialVersionUID = 1L;
	private JToggleButton jtbSine;
	private JToggleButton jtbSquare;
	private JToggleButton jtbRamp;
	private ButtonGroup group;
	private Controller controller;

	/**
	 * <pre>
	 * - Setzt Attribut des Controllers.
	 * - Baut User-Interface gemäss Beschreibung in der Aufagbestellung.
	 * </pre>
	 * 
	 * @param controller
	 */
	public ModePanel(Controller controller) {
		// 13
	}

	/**
	 * <pre>
	 * - Erlaubt die Wahl der WaveForm und ruft dazu je nach Ereignis die Methode, mit entsprechendem Argumt, in Controller auf.
	 * </pre>
	 */
	public void actionPerformed(ActionEvent e) {
		// 6
	}
}
