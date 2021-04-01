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

public class ViewFrequenzBereich extends JPanel {
	// 11
	private static final long serialVersionUID = -3345524379780063531L;
	private XYPlotPanel stAmplitudenPanel = new XYPlotPanel("", "", "dB", new double[] { 0, 20e3, -80.0, 5.0 },
			new boolean[] { false, false }, new boolean[] { false, true }, Color.blue);
	private XYPlotPanel eqAmplitudenPanel = new XYPlotPanel("", "", "dB", new double[] { 0, 20e3, -80.0, 20.0 },
			new boolean[] { false, false }, new boolean[] { false, true }, Color.red);
	private XYPlotPanel gStAmplitudenPanel = new XYPlotPanel("", "Hz", "dB", new double[] { 0, 20e3, -5.0, 5.0 },
			new boolean[] { false, false }, new boolean[] { true, true }, Color.green);

	/**
	 * Baut die View des Panels mit den XYPlots im Frequenzbereich ...
	 * 
	 * <pre>
	 * - Baut das GUI gemäss Aufgabenstellung.
	 * </pre>
	 */
	public ViewFrequenzBereich() {
		// 7
	}

	/**
	 * Plotdaten in entsprechendes Panel setzen ...
	 * 
	 * <pre>
	 * - Methode setData() mit Frequenzachse fAxis und entsprechendem Amplitudengang des Models für alle
	 *   drei Panel aufrufen:
	 *   stAmplitudenPanel -> AmplitudengangStrecke,
	 *   eqAmplitudenPanel -> AmplitudengangEqualizer,
	 *   gStAmplitudenPanel -> AmplitudengangGesamtStrecke.
	 * </pre>
	 */
	public void update(Observable obs, Object obj) {
		// 4
	}

}
