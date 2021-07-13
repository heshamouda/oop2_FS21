package bikeometer.gui;

// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: MUSTER
// Vorname:
// Klasse:
//

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import bikeometer.model.Model;

public class TopView extends JPanel implements Observer {
	// 17
	private static final long serialVersionUID = 1L;
	private VPlot vPlot;
	private HPlot hPlot;
	private InfoPanel infoPanel;
	public XYPlot xyPlot;
	private InputPanel inPanel;

	/**
	 * Die TopView ist als GridBagLayout organisiert und erzeugt und platziert
	 * die Instanzen der Klassen VPlot, HPlot, XYPlot, InfoPanel und InputPanel.
	 * VPlot, HPlot und XYPlot wachsen in beide Richtungen, die beiden
	 * restlichen Panel in horizontaler Richtung.
	 * 
	 * @param model
	 * @param controller
	 */
	public TopView(Model model, Controller controller) {
		// 11
		super(new GridBagLayout());
		vPlot = new VPlot(controller);
		hPlot = new HPlot();
		xyPlot = new XYPlot();
		infoPanel = new InfoPanel();
		inPanel = new InputPanel(controller);

		add(vPlot, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		add(hPlot, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		add(xyPlot, new GridBagConstraints(1, 0, 1, 2, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
		add(infoPanel, new GridBagConstraints(0, 2, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		add(inPanel, new GridBagConstraints(0, 3, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

	}

	/**
	 * <pre>
	 * - Wandelt obs in eine Model - Referenz. 
	 * - Ruft entsprechendes update() aller Panel mit entsprechender Methode auf. 
	 * - Setzt newData im Model - Objekt auf false.
	 * </pre>
	 */
	public void update(Observable obs, Object obj) {
		// 6
		Model model = (Model) obs;
		vPlot.update(obs, obj);
		infoPanel.update(obs, obj);
		hPlot.update(obs, obj);
		xyPlot.update(obs, obj);
		model.newData = false;
	}
}
