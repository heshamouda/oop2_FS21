package soundeditor.gui;

// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
// Klasse:
//

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import soundeditor.gui.goodies.Slider;

public class EchoPanel extends JPanel {
	// 8
	private static final long serialVersionUID = 1L;
	protected Slider jsEchoAmplitude = new Slider(0, 1000, 500, 500, 50);
	protected Slider jsEchoDelay = new Slider(0, 1000, 500, 500, 50);

	/**
	 * - Baut das User-Interface gemäss Aufgabenstellung.
	 * 
	 * <pre>
	 * -  Die Label "Amplitude" und "Delay" befinden sich je im Nord-Westen und wachsen nicht.
	 * -  Die Label "milli" und "ms" befinden sich je im Nord-Osten und wachsen nicht.
	 * -  Die Slider zwischen den Label wachsen in horizontaler Richtung. 
	 * -  Zuunterst in der Mitte befindet sich ein leeres Label, das in beide Richtungen wächst.
	 * </pre>
	 */
	public EchoPanel() {
		super(new GridBagLayout());
		// 8
	}

}
