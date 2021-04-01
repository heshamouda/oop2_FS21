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
	 * - Baut das GUI gem�ss Aufgabenstellung.
	 * </pre>
	 */
	public ViewFrequenzBereich() {
		// 7
		super(new GridBagLayout());

		stAmplitudenPanel.setBorder(MyBorderFactory.createMyBorder(" Amplitudengang der Strecke "));
		add(stAmplitudenPanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		eqAmplitudenPanel.setBorder(MyBorderFactory.createMyBorder(" Amplitudengang des Equlizers "));
		add(eqAmplitudenPanel, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		gStAmplitudenPanel.setBorder(MyBorderFactory.createMyBorder(" Amplitudengang der Gesamtstrecke "));
		add(gStAmplitudenPanel, new GridBagConstraints(0, 2, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	}

	/**
	 * Plotdaten in entsprechendes Panel setzen ...
	 * 
	 * <pre>
	 * - Methode setData() mit Frequenzachse fAxis und entsprechendem Amplitudengang des Models f�r alle
	 *   drei Panel aufrufen:
	 *   stAmplitudenPanel -> AmplitudengangStrecke,
	 *   eqAmplitudenPanel -> AmplitudengangEqualizer,
	 *   gStAmplitudenPanel -> AmplitudengangGesamtStrecke.
	 * </pre>
	 */
	public void update(Observable obs, Object obj) {
		// 4
		Model model = (Model) obs;
		stAmplitudenPanel.setData(model.getfAxis(), model.getAmplitudengangStrecke());
		eqAmplitudenPanel.setData(model.getfAxis(), model.getAmplitudengangEqualizer());
		gStAmplitudenPanel.setData(model.getfAxis(), model.getAmplitudengangGesamtStrecke());
	}

}
