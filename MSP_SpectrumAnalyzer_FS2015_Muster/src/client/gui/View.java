package client.gui;

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

import client.gui.goodies.PNDisplay;
import client.gui.goodies.PNStatus;

public class View extends JPanel implements Observer {
	// 11
	private static final long serialVersionUID = 1L;
	private PNDisplay pnDisplay;
	private PNStatus pnStatus;
	private PNSettings pnSettings;
	private PNMarker pnMarker;

	/**
	 * <pre>
	 * - Baut Benutzerschnittstelle gemäss Aufgabenstellung.
	 * </pre>
	 * @param ctrl
	 */
	public View(Controller ctrl) {
		// 9
		super(new GridBagLayout());

		pnDisplay = new PNDisplay(ctrl);
		add(pnDisplay, new GridBagConstraints(0, 0, 1, 2, 1.0, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						0, 0, 0, 0), 5, 5));

		pnSettings = new PNSettings(ctrl);
		add(pnSettings, new GridBagConstraints(1, 0, 1, 1, 0.0, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						0, 0, 0, 0), 5, 5));

		pnMarker = new PNMarker();
		add(pnMarker, new GridBagConstraints(1, 1, 1, 1, 0.0, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						0, 0, 0, 0), 5, 5));

		pnStatus = new PNStatus();
		add(pnStatus, new GridBagConstraints(0, 2, 2, 1, 1.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(0, 0, 0, 0), 5, 5));
	}

	/**
	 * Ruft allfällige update() Methoden der beheimateten Panels auf.
	 */
	@Override
	public void update(Observable obs, Object obj) {
		// 2
		pnDisplay.update(obs, obj);
		pnMarker.update(obs, obj);
	}
}
