import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: Muster
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
		// 13
		super(new GridBagLayout());

		parameterPanel = new ParameterPanel(controller);
		parameterPanel.setBorder(MyBorderFactory.createMyBorder(" Einstellungen "));
		add(parameterPanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		bildPanel = new BildPanel(controller, "BDGPred.png");
		bildPanel.setBorder(MyBorderFactory.createMyBorder(" Blockdiagramm "));
		add(bildPanel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 0, 0));

		impulsPlot = new ImpulsPlotPanel();
		impulsPlot.setBorder(MyBorderFactory.createMyBorder(" Impulsantwort "));
		add(impulsPlot, new GridBagConstraints(0, 1, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));

		fehlerPlot = new FehlerPlotPanel();
		fehlerPlot.setBorder(MyBorderFactory.createMyBorder(" Fehlersignal "));
		add(fehlerPlot, new GridBagConstraints(0, 2, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));
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
		fehlerPlot.update(obs, obj);
		impulsPlot.update(obs, obj);
	}
}
