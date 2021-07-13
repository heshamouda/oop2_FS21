package multimeter.gui;
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
//

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;

import javax.swing.JPanel;

import multimeter.MultimeterApplikation;
import multimeter.gui.goodies.DigitDisplay;
import multimeter.model.Model;
import multimeter.resources.MyBorderFactory;

public class DisplayPanel extends JPanel {
	// 11
	private static final long serialVersionUID = 1L;
	private DigitDisplay digitDisplay = new DigitDisplay();

	/**
	 * - Baut GUI gemäss Aufgabenstellung mit Hintergrundfarbe Color.gray.
	 * - Setzt bevorzugte Grösse auf 75% von MultimeterApplikation.appWidth und  65% von MultimeterApplikation.appHeight.
	 */
	public DisplayPanel() {
		// 5
		super(new BorderLayout());
		setBorder(MyBorderFactory.createMyBorder(" DisplayPanel "));
		setBackground(Color.gray);
		setPreferredSize(new Dimension((int) (0.75 * MultimeterApplikation.appWidth),
				(int) (0.65 * MultimeterApplikation.appHeight)));
		add(digitDisplay);
	}

	/**
	 * Wandelt obs in eine Model-Referenz und ruft setValue() von digitDisplay
	 * mit dem Value von model auf.
	 * 
	 * @param obs
	 * @param obj
	 */
	public void update(Observable obs, Object obj) {
		// 2
		Model model = (Model) obs;
		digitDisplay.setValue(model.getValue());
	}

	/**
	 * <pre>
	 * - Falls mode grösser gleich 0 UND mode kleiner 3: 
	 *   - Unit von digitDisplay auf DigitDisplay.V setzen. 
	 * - Falls mode gleich 3 ist: 
	 *   - Unit von digitDisplay auf DigitDisplay.KHZ setzen.
	 * </pre>
	 * 
	 * @param mode
	 */
	public void setUnit(int mode) {
		// 4
		if (mode >= 0 && mode < 3) {
			digitDisplay.setUnit(DigitDisplay.V);
		}
		if (mode == 3) {
			digitDisplay.setUnit(DigitDisplay.KHZ);
		}
	}

}
