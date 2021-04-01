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

public class EqualizerPanel extends JPanel {
	// 7
	private static final long serialVersionUID = 1L;
	protected Slider[] sliders = new Slider[8];
	private String[] stLabel = { "6k - 12k", "3k - 6k", "1.5k - 3k", "750 - 1.5k", "375 - 750", "188 - 375", "94 - 188",
			"94 - 47" };

	/**
	 * - Baut das User-Interface gemäss Aufgabenstellung.
	 * 
	 * <pre>
	 * Die acht Slider werden mittels einer Schleife erzeugt:
	 * - Für k gleich Null bis kleiner der Länge von sliders:
	 *   - Label mit dem Text gegeben durch stLabel an der Stelle k, an entsprechender Position im Nord-Westen 
	 *     auf der k-ten Zeile hinzufügen. Das Label wächst nicht.
	 *   - Neuen Slider mit den Parametern (-24, 24, 0, 12, 1) erzeugen und in sliders an der Stelle k ablegen.
	 *   - Neuen Slider an entsprechender Position auf der k-ten Zeile hinzufügen. Der Slider wächst in beide 
	 *     Richtungen. 
	 *   - Label mit dem Text " dB ", an entsprechender Position im Nord-Osten auf der k-ten Zeile hinzufügen. 
	 *     Das Label wächst nicht.
	 * -  Zuunterst in der Mitte befindet sich ein leeres Label, das in beide Richtungen wächst.
	 * </pre>
	 * 
	 */
	public EqualizerPanel() {
		super(new GridBagLayout());
		// 7
		setBorder(tools.MyBorderFactory.createMyBorder(" EqualizerPanel "));

		for (int k = 0; k < sliders.length; k++) {
			add(new JLabel(stLabel[k], JLabel.CENTER), new GridBagConstraints(0, k, 1, 1, 0.0, 0.0,
					GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

			sliders[k] = new Slider(-24, 24, 0, 12, 1);

			add(sliders[k], new GridBagConstraints(1, k, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

			add(new JLabel(" dB "), new GridBagConstraints(2, k, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHEAST,
					GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		}

		add(new JLabel(""), new GridBagConstraints(1, 8, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	}
}
