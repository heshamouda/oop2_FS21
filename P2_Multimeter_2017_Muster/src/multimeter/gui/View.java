package multimeter.gui;
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

public class View extends JPanel implements Observer {
	// 8
	private static final long serialVersionUID = 1L;
	public DisplayPanel displayPanel;
	public SignalPanel signalPanel;
	private ModePanel modePanel;

	/**
	 * <pre>
	 * - Baut GUI gemäss Aufgabenstellung.
	 * </pre>
	 * 
	 * @param controller
	 * @param model
	 */
	public View(Controller controller) {
		// 7
		super(new GridBagLayout());

		displayPanel = new DisplayPanel();
		modePanel = new ModePanel(controller);
		signalPanel = new SignalPanel(controller);

		add(signalPanel, new GridBagConstraints(0, 0, 1, 2, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		add(displayPanel, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 10, 10));
		add(modePanel, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
	}

	/**
	 * - Datiert entsprechende Panel auf.
	 */
	public void update(Observable obs, Object obj) {
		// 1
		displayPanel.update(obs, obj);
	}
}
