// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: Muster
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
		// 8
		super(new GridBagLayout());

		pnEingabe = new PNEingabe(controller);
		pnAusgabe = new PNAusgabe();
		pnSEbene = new PNSEbene();
		pnAmplitude = new PNAmplitude();

		// x, y, x-span, y-span, x-weight, y-weight, anchor, fill, insets(int top, int left, int bottom, int right), internal padding x, internal padding y. 
		add(pnEingabe, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));

		add(pnAusgabe, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));

		add(pnSEbene, new GridBagConstraints(1, 0, 1, 2, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));

		add(pnAmplitude, new GridBagConstraints(0, 2, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));
	}

	/**
	 * <pre>
	 * - Ruft update() der entsprechenden Panel auf.
	 * </pre>
	 */
	@Override
	public void update(Observable obs, Object obj) {
		// 3
		pnAusgabe.update(obs, obj);
		pnSEbene.update(obs, obj);
		pnAmplitude.update(obs, obj);
	}
}
