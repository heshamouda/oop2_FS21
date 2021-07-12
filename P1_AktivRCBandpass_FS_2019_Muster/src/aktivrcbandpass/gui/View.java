// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
// Modulanlass:

package aktivrcbandpass.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import util.Observable;
import util.Observer;
import util.TraceV7;

public class View extends JPanel implements Observer {
	// 5 + 1
	private TraceV7 trace = new TraceV7(this);
	private static final long serialVersionUID = 1L;
	private ReiterPane reiterPane = new ReiterPane();
	public InputPanel inputPanel;

	/**
	 * <pre>
	 * - Baut das User-Interface gemäss Angaben in der Aufgabenstellung.  
	 * 	 *
	 * </pre>
	 * 
	 * @param controller
	 */
	public View(Controller controller) {
		super(new GridBagLayout());
		trace.constructorCall();
		// 3
		inputPanel = new InputPanel(controller);

		add(inputPanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(reiterPane, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));
	}

	/**
	 * - Ruft update() der entsprechenden Panel auf.
	 */
	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		// 2
		inputPanel.update(obs, obj);
		reiterPane.update(obs, obj);
	}
}
