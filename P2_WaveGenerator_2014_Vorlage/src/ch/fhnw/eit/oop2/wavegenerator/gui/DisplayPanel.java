package ch.fhnw.eit.oop2.wavegenerator.gui;
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.

import java.util.Observable;

import javax.swing.JPanel;

import ch.fhnw.eit.oop2.wavegenerator.gui.goodies.DigitDisplay;
import ch.fhnw.eit.oop2.wavegenerator.model.Model;

public class DisplayPanel extends JPanel {
	// 7
	private static final long serialVersionUID = 1L;
	private DigitDisplay digitDisplay = new DigitDisplay(50, 25, 300, 70);
	private Model model;

	/**
	 * <pre>
	 * - Setzt Attribut des Models.
	 * - Baut User-Interface gemäss Beschreibung in der Aufagbestellung.
	 * </pre>
	 * 
	 * @param model
	 */
	public DisplayPanel(Model model) {
		// 4
	}

	/**
	 * <pre>
	 * - Ruft entsprechende Methode von digitDispaly auf.
	 * - Ruft updateUnits() auf.
	 * </pre>
	 * 
	 * @param unit
	 */
	public void setUnit(int unit) {
		// 2
	}

	/**
	 * <pre>
	 * - Ruft updateUnits() auf.
	 * </pre>
	 * 
	 * @param obs
	 * @param obj
	 */
	public void update(Observable obs, Object obj) {
		// 1
	}

	/**
	 * <pre>
	 * - Falls Unit von digitDisplay gleich DigitDisplay.VPP:
	 *   - Value von digitDisplay gleich Amplitude in Model setzen.
	 *   - Sonst
	 *   - Value von digitDisplay gleich Frequency in Model setzen.
	 * - Neuzeichnen auslösen.
	 * </pre>
	 * 
	 */
	private void updateUnits() {
		// 5
	}

}
