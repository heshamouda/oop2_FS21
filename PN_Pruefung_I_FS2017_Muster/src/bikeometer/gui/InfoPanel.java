package bikeometer.gui;

// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
// Klasse:
//

import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JPanel;

import bikeometer.model.Model;
import bikeometer.tools.MyBorderFactory;

public class InfoPanel extends JPanel {
	// 4 + 17 = 21
	private static final long serialVersionUID = 1L;
	private JLabel lbGeschwindigkeit = new JLabel();
	private JLabel lbDistanz = new JLabel();
	private JLabel lbHoehe = new JLabel();
	private JLabel lbDeltaHoehe = new JLabel();

	/**
	 * Das InfoPanel ist als GridLayout organisiert und erzeugt und platziert
	 * alle benötigten GUI - Elemente. Das Panel hat eine Border mit Text
	 * "InfoPanel - Information".
	 */
	public InfoPanel() {
		// 10
		super(new GridLayout(2, 4, 10, 10));
		setBorder(MyBorderFactory.createMyBorder("InfoPanel - Information"));
		add(new JLabel("Geschwindigkeit: "));
		add(lbGeschwindigkeit);
		add(new JLabel("Distanzdifferenz: "));
		add(lbDistanz);
		add(new JLabel("Höhe über Meer: "));
		add(lbHoehe);
		add(new JLabel("Höhendifferenz: "));
		add(lbDeltaHoehe);
	}

	/**
	 * <pre>
	 * - Wandelt obs in eine Model - Referenz.
	 * - Setzt die Texte der entsprechenden JLabel aufgrund von geschwindigkeit, distanz, hoehe und deltaHoehe im Model - Objekt.
	 * - Verwendet die private Methode round() um auf eine Stelle gerundete Werte darzustellen.
	 * </pre>
	 * 
	 * @param obs
	 * @param obj
	 */
	public void update(Observable obs, Object obj) {
		// 5
		Model model = (Model) obs;
		lbGeschwindigkeit.setText("" + round(model.geschwindigkeit, 1));
		lbDistanz.setText("" + round(model.distanz, 0));
		lbHoehe.setText("" + round(model.hoehe, 0));
		lbDeltaHoehe.setText("" + round(model.deltaHoehe, 0));
	}

	/**
	 * Rundet value auf n Stellen nach dem Komma.
	 * 
	 * @param value
	 * @param n
	 * @return
	 */
	private double round(double value, int n) {
		// 2
		double k = Math.pow(10.0, n);
		return Math.round(k * value) / k;
	}

}
