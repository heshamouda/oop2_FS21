// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
//

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

class View extends JPanel implements Observer {
	// 11
	private PNEingabe pnEingabe;
	private PNAusgabe pnAusgabe;
	private PNSEbene pnSEbene;
	private PNAmplitude pnAmplitude;

	/**
	 * <pre>
	 * - Erzeugt die Panel.
	 * - Baut das GUI gemaess Layout-Angaben in der Aufgabenstellung. 
	 * </pre>
	 * 
	 * @param controller
	 */
	public View(Controller controller) {

	}

	/**
	 * <pre>
	 * - Ruft update() der entsprechenden Panel auf.
	 * </pre>
	 */
	@Override
	public void update(Observable obs, Object obj) {

	}
}

