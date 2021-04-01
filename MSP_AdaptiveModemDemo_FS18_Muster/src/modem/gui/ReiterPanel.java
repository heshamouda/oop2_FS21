package modem.gui;

import java.awt.Dimension;
import java.util.Observable;

import javax.swing.JTabbedPane;

import modem.AdaptiveModemDemo;
import modem.gui.goodies.ViewFrequenzBereich;
import modem.gui.goodies.ViewZeitBereich;

// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiderhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:

public class ReiterPanel extends JTabbedPane {
	// 5
	private static final long serialVersionUID = -7176405344277868872L;
	private ViewFrequenzBereich vFrequenzBereich = new ViewFrequenzBereich();
	private ViewZeitBereich vZeitBereich = new ViewZeitBereich();

	/**
	 * <pre>
	 * - Setzt die bevorzugte Dimension auf (100%, 60%) von 
	 *   AdaptiveModemDemo.appWidth resp. AdaptiveModemDemo.appHeight.
	 * - Baut das GUI gem‰ﬂ Aufgabenstellung.
	 * </pre>
	 */
	public ReiterPanel() {
		// 3
		setPreferredSize(
				new Dimension((int) (AdaptiveModemDemo.appWidth * 1.0), (int) (AdaptiveModemDemo.appHeight * 0.6)));

		addTab("Freuenzbereich", vFrequenzBereich);
		addTab("Zeitbereich", vZeitBereich);
	}

	/**
	 * <pre>
	 * - Ruft entsprechende Methode update() der beheimateten Panel auf.
	 * </pre>
	 * 
	 * @param obs
	 * @param obj
	 */
	public void update(Observable obs, Object obj) {
		// 2
		vFrequenzBereich.update(obs, obj);
		vZeitBereich.update(obs, obj);
	}
}
