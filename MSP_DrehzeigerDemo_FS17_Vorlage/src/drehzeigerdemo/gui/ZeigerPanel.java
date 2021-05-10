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
//Name: 
//Vorname:

public class ZeigerPanel extends JPanel {
	// 28
	private static final long serialVersionUID = 1L;
	private ZeigerPlot[] drehZeigerPlot = new ZeigerPlot[33];
	private ZeigerPlot[] summenZeigerPlot = new ZeigerPlot[(drehZeigerPlot.length + 1) / 2];

	/**
	 * <pre>
	 * - Setzt bevorzugte Grösse auf (-1, (drehZeigerPlot.length - 1)/2 mal 15% von DrehzeigerDemoApplikation.appWidth)).
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
	}
}
