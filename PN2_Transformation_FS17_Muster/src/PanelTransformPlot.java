//Name: Muster
//Vorname:
//Klasse:

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTransformPlot extends JPanel {
	// 15 Pte. = 15 Pte
	private PanelPlot[] funcPlots = new PanelPlot[8];
	private PanelPlot sumPlot = new PanelPlot();

	/**
	 * - Ist als GridBagLayout organisiert!
	 * - Setzt Border mit Titel " Transformation ".
	 * - Erzeugt in einer for-Schleife 8 PanelPlot und legt die zugehörigen Referenzen in funcPlots ab:
	 * - Fügt in der for - Schleife das erzeugte Panel mittls add() aufs Panel und fügt, so es nicht das 
	 *   letzte Panel ist, mittels add() ein JLabel mit "+" ein.
	 * - Fügt ein JLabel mit "=" mittels add() an entsprechender Stelle hinzu.
	 * - Fügt sumPlot mittels add() an entsprechender Stelle hinzu.     
	 */
	public PanelTransformPlot() {
		super(new GridBagLayout());
		// 8 Pte.
		setBorder(MyBorderFactory.createMyBorder(" Transformation "));

		for (int i = 0; i < funcPlots.length; i++) {
			funcPlots[i] = new PanelPlot();
			add(funcPlots[i], new GridBagConstraints(0, 2 * i, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			if (i < funcPlots.length - 1) {
				add(new JLabel("+"), new GridBagConstraints(0, 2 * i + 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
						GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			}
		}
		add(new JLabel("="), new GridBagConstraints(0, 16, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
		add(sumPlot, new GridBagConstraints(0, 17, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));
	}

	/**
	 * - Castet die Obeservable Referenz obs in eine Model - Referenz.
	 * - Ruft in einer for - Schleife von jedem funcPlots[i] setData() mit folgenden drei Parametern auf:
	 * 		- xAxis des Models, i-te Zeile der TransformMatrix, i-tes Element der Coeff.
	 * - Setzt die Daten von sumPlot mittels setData() mit den folgenden beiden Parametern:
	 * 		- xAxis und Signal des Models.
	 * 
	 * @param obs
	 * @param arg
	 */
	public void update(Observable obs, Object arg) {
		// 4 Pte.
		Model model = (Model) obs;
		for (int i = 0; i < funcPlots.length; i++) {
			funcPlots[i].setData(model.getXAxis(), model.getTransformMatrix(i), model.getCoeff(i));
		}
		sumPlot.setData(model.getXAxis(), model.getSignal());
	}

	/**
	 * - Setzt mittels for - Schleife die Farbe eines jeden funcPlots[].
	 * - Setzt die Farbe von sumPlot.
	 * 
	 * @param color
	 */
	public void setColor(Color color) {
		// 3 Pte
		for (int i = 0; i < funcPlots.length; i++) {
			funcPlots[i].setColor(color);
		}
		sumPlot.setColor(color);
	}

}
