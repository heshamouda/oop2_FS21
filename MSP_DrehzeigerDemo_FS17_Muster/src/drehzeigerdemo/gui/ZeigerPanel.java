package drehzeigerdemo.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.commons.math3.complex.Complex;

import drehzeigerdemo.DrehzeigerDemoApplikation;
import drehzeigerdemo.gui.goodies.ZeigerPlot;
import drehzeigerdemo.model.Model;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: Muster
//Vorname:

public class ZeigerPanel extends JPanel {
	// 28
	private static final long serialVersionUID = 1L;
	private ZeigerPlot[] drehZeigerPlot = new ZeigerPlot[33];
	private ZeigerPlot[] summenZeigerPlot = new ZeigerPlot[(drehZeigerPlot.length + 1) / 2];

	/**
	 * <pre>
	 * - Setzt bevorzugte Grösse auf (-1, (drehZeigerPlot.length - 1)/2 mal 15% von DrehzeigerDemoApplikation.appHeight)).
	 * 
	 * - Erzeugt den 0-ten drehZeigerPlot und den 0-ten summenZeigerPlot und fügt ihn gemäss Aufgabenstellung dem
	 *   Panel hinzu.
	 *   
	 * - Erzeugt für i = 1 bis kleiner der Länge der Summenzeiger-Plots den [2 * i - 1]-ten und 
	 *   den [2 * i]-ten drehZeigerPlot sowie den [i]-ten summenZeigerPlot und fügt sie mit den 
	 *   entsprechenden Label dem Panel hinzu.
	 * </pre>
	 */
	public ZeigerPanel() {
		// 15
		super(new GridBagLayout());
		setPreferredSize(new Dimension(-1,
				(int) ((drehZeigerPlot.length - 1) / 2 * 0.15 * DrehzeigerDemoApplikation.appHeight)));

		Insets insets = new Insets(4, 4, 4, 4);

		drehZeigerPlot[0] = new ZeigerPlot();
		summenZeigerPlot[0] = new ZeigerPlot();
		add(drehZeigerPlot[0], new GridBagConstraints(0, 0, 3, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, insets, 0, 0));
		add(summenZeigerPlot[0], new GridBagConstraints(4, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, insets, 0, 0));

		for (int i = 1; i < summenZeigerPlot.length; i++) {
			drehZeigerPlot[2 * i - 1] = new ZeigerPlot();
			drehZeigerPlot[2 * i] = new ZeigerPlot();
			summenZeigerPlot[i] = new ZeigerPlot();

			add(drehZeigerPlot[2 * i - 1], new GridBagConstraints(0, i + 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, insets, 0, 0));
			add(new JLabel("+"), new GridBagConstraints(1, i + 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.NONE, insets, 0, 0));
			add(drehZeigerPlot[2 * i], new GridBagConstraints(2, i + 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, insets, 0, 0));

			add(new JLabel("="), new GridBagConstraints(3, i + 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.NONE, insets, 0, 0));

			add(summenZeigerPlot[i], new GridBagConstraints(4, i + 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, insets, 0, 0));
		}
	}

	/**
	 * <pre>
	 * - Wandelt Observable obs in Model model.
	 * - Holt die Drehzeiger aus dem Model und speichert sie in lokale Var. drehZeiger.
	 * 
	 * - Setzt Data des 0-ten drehZeigerPlot und des 0-ten summenZeigerPlot gleich 
	 *   dem [(drehZeiger.length - 1)/2]-ten Element von drehZeiger.
	 * 
	 * - Für i gleich 1 bis kleiner Länge des summenZeigerPlot:
	 *   - Falls ((drehZeiger.length-1)/2 - i) grösser -1:
	 *     - Data des [2*i-1]-ten drehZeigerPlot gleich dem 
	 *       [(drehZeiger.length-1)/2-i]-ten Element von drehZeiger setzen.
	 *     - Data des [2*i]-ten drehZeigerPlot gleich dem 
	 *       [(drehZeiger.length-1)/2+i]-ten Element von drehZeiger setzen.
	 *     - Data des i-ten summenZeigerPlot gleich dem [(drehZeiger.length-1)/2-i]-ten 
	 *       und [(drehZeiger.length-1)/2+i]-ten Element von drehZeiger setzen (2 Werte!).
	 *   - Sonst:
	 *     - Data des [2*i-1]-ten drehZeigerPlot gleich neuer komplexen Zahl mit dem Wert Null setzen.
	 *     - Data des [2*i]-ten drehZeigerPlot gleich neuer komplexen Zahl mit dem Wert Null setzen.
	 *     - Data des i-ten summenZeigerPlot gleich neuer komplexen Zahl mit dem Wert Null setzen.
	 * </pre>
	 * 
	 * @param obs
	 * @param obj
	 */
	public void update(Observable obs, Object obj) {
		// 13
		Model model = (Model) obs;
		Complex[] drehZeiger = model.getDrehZeiger();

		drehZeigerPlot[0].setData(drehZeiger[(drehZeiger.length - 1) / 2]);
		summenZeigerPlot[0].setData(drehZeiger[(drehZeiger.length - 1) / 2]);

		for (int i = 1; i < summenZeigerPlot.length; i++) {
			if (((drehZeiger.length - 1) / 2 - i) > -1) {
				drehZeigerPlot[2 * i - 1].setData(drehZeiger[(drehZeiger.length - 1) / 2 - i]);
				drehZeigerPlot[2 * i].setData(drehZeiger[(drehZeiger.length - 1) / 2 + i]);
				summenZeigerPlot[i].setData(drehZeiger[(drehZeiger.length - 1) / 2 - i],
						drehZeiger[(drehZeiger.length - 1) / 2 + i]);
			} else {
				drehZeigerPlot[2 * i - 1].setData(new Complex(0, 0));
				drehZeigerPlot[2 * i].setData(new Complex(0, 0));
				summenZeigerPlot[i].setData(new Complex(0, 0));
			}
		}
	}
}
