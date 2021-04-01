package inversmodel.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import inversmodel.model.Model;
import resources.MyBorderFactory;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: 
//Vorname:

public class View extends JPanel implements Observer {
	// 14
	private static final long serialVersionUID = 1L;
	private BDGPanel bdgPanel;
	public ParameterPanel parameterPanel;
	private ReiterPanel reiterPanel;
	private Model model = new Model();
	private Controller controller = new Controller(model);

	/**
	 * Baut die View des GUIs ...
	 * 
	 * <pre>
	 * - Baut das GUI gemäss Aufgabenstellung.
	 * - Ruft setView() des Controllers auf.
	 * - Registriert sich beim Model als Observer.
	 * - Ruft setParameter des Controllers auf. 
	 * </pre>
	 * 
	 * @param controller
	 *            Referenz des Controllers.
	 */
	public View() {
		// 12
	}

	/**
	 * Entsprechende Panel zu Aufdatieren aufrufen ...
	 * 
	 * <pre>
	 * - Entsprechendes update() des ReiterPanels aufrufen.
	 * </pre>
	 */
	public void update(Observable obs, Object obj) {
		// 1
	}

	/**
	 * SignalQuelle des Models starten
	 */
	public void startSignalQuelle() {
		// 1
	}
}
