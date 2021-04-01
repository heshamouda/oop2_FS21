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
//Name: 
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
	}

}
