package soundeditor.gui;
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.

// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: MUSTER
// Vorname:
// Klasse:
//

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import soundeditor.gui.goodies.Slider;
import tools.MyBorderFactory;

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

		setBorder(MyBorderFactory.createMyBorder(" EchoPanel "));

		add(new JLabel("Amplitude:"), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(jsEchoAmplitude, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(new JLabel("milli"), new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHEAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel("Delay:"), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(jsEchoDelay, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(new JLabel("ms"), new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHEAST,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel(), new GridBagConstraints(1, 2, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	}

}
