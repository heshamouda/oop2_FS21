import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: 
//Vorname:

public class View extends JPanel implements Observer {
	// 15
	private static final long serialVersionUID = 1L;
	private BildPanel bildPanel;
	public ParameterPanel parameterPanel;
	private ImpulsPlotPanel impulsPlot;
	private FehlerPlotPanel fehlerPlot;

	/**
	 * Baut die Top-View des GUIs ...
	 * 
	 * <pre>
	 * - Setzt entsprechendes Attribut.
	 * - Baut das GUI gemäss Aufgabenstellung.
	 * </pre>
	 * 
	 * @param controller
	 *            Referenz des Controllers.
	 */
	public View(Controller controller) {
		// ~ 13
	}

	/**
	 * Entsprechende Panel zu Aufdatieren aufrufen ...
	 * 
	 * <pre>
	 * - Entsprechendes update() der beiden Plots aufrufen.
	 * </pre>
	 */
	public void update(Observable obs, Object obj) {
		// 2
	}
}
