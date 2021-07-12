// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
// Modulanlass:

package mailapp.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import util.Observable;
import util.Observer;
import util.TraceV7;

public class View extends JPanel implements Observer {
	// 6
	private TraceV7 trace = new TraceV7(this);
	private static final long serialVersionUID = 1L;

	/**
	 * <pre>
	 * - Baut das GUI gemäss Aufgabenstellung (Layout / Klassendiagramm).
	 * </pre>
	 * 
	 * @param controller
	 */
	public View(Controller controller) {
		super(new GridBagLayout());
		trace.constructorCall();
	}

	/**
	 * - Ruft update() der entsprechenden Komponenten auf.
	 */
	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		// 2
	}
}
