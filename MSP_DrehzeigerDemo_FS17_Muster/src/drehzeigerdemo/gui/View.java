package drehzeigerdemo.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import drehzeigerdemo.model.Model;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: Muster
//Vorname:

public class View extends JPanel implements Observer {
	// 5
	private static final long serialVersionUID = 1L;
	private Model model = new Model();
	private Controller controller = new Controller(model);
	private ReiterPane reiterPane = new ReiterPane();
	private ParameterPanel parameterPanel = new ParameterPanel(controller);

	/**
	 * <pre>
	 * - Baut User-Interface gemäss Aufgabenstellung.
	 * - Registriert die View als Beobachter beim Model.
	 * </pre>
	 */
	public View() {
		// 4
		super(new GridBagLayout());

		add(parameterPanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.VERTICAL, new Insets(5, 5, 5, 5), 0, 0));
		add(reiterPane, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));

		model.addObserver(this);
	}

	/**
	 * <pre>
	 * - Datiert entsprechende Komponenten auf.
	 * </pre>
	 * 
	 * @param obs
	 * @param obj
	 */
	public void update(Observable obs, Object obj) {
		// 1
		reiterPane.update(obs, obj);
	}

}
