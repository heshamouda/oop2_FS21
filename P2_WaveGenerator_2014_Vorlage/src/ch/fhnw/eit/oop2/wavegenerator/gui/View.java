package ch.fhnw.eit.oop2.wavegenerator.gui;
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

import ch.fhnw.eit.oop2.wavegenerator.model.Model;

public class View extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	public DisplayPanel displayPanel;
	private InputPanel inputPanel;
	private ModePanel modePanel;

	/**
	 * <pre>
	 * - Baut User - Interface gemäss Beschreibung in Aufgabenstellung.
	 * </pre>
	 * 
	 * @param controller
	 * @param model
	 */
	public View(Controller controller, Model model) {
		setLayout(new GridBagLayout());

		displayPanel = new DisplayPanel(model);
		modePanel = new ModePanel(controller);
		inputPanel = new InputPanel(controller, model);
		add(displayPanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
		add(modePanel, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(inputPanel, new GridBagConstraints(1, 0, 1, 2, 0.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.VERTICAL, new Insets(5, 5, 5, 5), 0, 0));
	}

	/**
	 * <pre>
	 *  - Löst update von displayPanel aus.
	 * </pre>
	 */
	public void update(Observable obs, Object obj) {
		displayPanel.update(obs, obj);
	}
}
