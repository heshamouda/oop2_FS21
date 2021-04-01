package inversmodel.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;

import javax.swing.JPanel;

import inversmodel.model.Model;
import resources.MyBorderFactory;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: Muster
//Vorname:

public class ViewZeitBereich extends JPanel {
	// 11
	private static final long serialVersionUID = -2021646150805080829L;
	private XYPlotPanel eqImpulsPanel = new XYPlotPanel("", "", "V", new double[] { 0, 3.25, -1.0, 1.0 },
			new boolean[] { false, false }, new boolean[] { false, true }, Color.blue);
	private XYPlotPanel stImpulsPanel = new XYPlotPanel("", "", "V", new double[] { 0, 3.25, -1.0, 1.0 },
			new boolean[] { false, false }, new boolean[] { false, true }, Color.red);
	private XYPlotPanel gStImpulsPanel = new XYPlotPanel("", "ms", "V", new double[] { 0, 3.25, -1.0, 1.0 },
			new boolean[] { false, false }, new boolean[] { true, true }, Color.green);

	/**
	 * Baut die View des Panels mit den XYPlots im Zeitbereich ...
	 * 
	 * <pre>
	 * - Baut das GUI gemäss Aufgabenstellung.
	 * </pre>
	 */
	public ViewZeitBereich() {
		// 7
		super(new GridBagLayout());

		stImpulsPanel.setBorder(MyBorderFactory.createMyBorder(" Impulsantwort der Strecke "));
		add(stImpulsPanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		eqImpulsPanel.setBorder(MyBorderFactory.createMyBorder(" Impulsantwort des Equlizers "));
		add(eqImpulsPanel, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		gStImpulsPanel.setBorder(MyBorderFactory.createMyBorder(" Impulsantwort der Gesamtstrecke "));
		add(gStImpulsPanel, new GridBagConstraints(0, 2, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	}

	/**
	 * Plotdaten in entsprechendes Panel setzen ...
	 * 
	 * <pre>
	 * - Methode setData() mit Zeitachse tAxis und entsprechendem Impuls des Models für alle
	 *   drei Panel aufrufen:
	 *   stImpulsPanel -> ImpulsStrecke,
	 *   eqImpulsPanel -> ImpulsEqualizer,
	 *   gStImpulsPanel -> ImpulsGesamtStrecke.
	 * </pre>
	 */
	public void update(Observable obs, Object obj) {
		// 4
		Model model = (Model) obs;
		stImpulsPanel.setData(model.gettAxis(), model.getImpulsStrecke());
		eqImpulsPanel.setData(model.gettAxis(), model.getImpulsEqualizer());
		gStImpulsPanel.setData(model.gettAxis(), model.getImpulsGesamtStrecke());
	}

}
