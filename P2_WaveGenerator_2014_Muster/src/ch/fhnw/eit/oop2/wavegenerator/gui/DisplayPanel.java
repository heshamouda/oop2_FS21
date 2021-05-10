package ch.fhnw.eit.oop2.wavegenerator.gui;
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
//

import java.awt.BorderLayout;
import java.util.Observable;

import javax.swing.JPanel;

import ch.fhnw.eit.oop2.wavegenerator.model.Model;
import ch.fhnw.eit.oop2.wavegenerator.tools.MyBorderFactory;

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
		super(new BorderLayout());
		this.model = model;
		setBorder(MyBorderFactory.createMyBorder("  Display  "));
		add(digitDisplay, BorderLayout.CENTER);
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
		digitDisplay.setUnit(unit);
		updateUnits();
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
		updateUnits();
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
		if (digitDisplay.getUnit() == DigitDisplay.VPP)
			digitDisplay.setValue(model.getAmplitude());
		else
			digitDisplay.setValue(model.getFrequency());
		repaint();
	}

}
