package client.gui;

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
	}

	/**
	 * Ruft allfällige update() Methoden der beheimateten Panels auf.
	 */
	@Override
	public void update(Observable obs, Object obj) {
	}
}
