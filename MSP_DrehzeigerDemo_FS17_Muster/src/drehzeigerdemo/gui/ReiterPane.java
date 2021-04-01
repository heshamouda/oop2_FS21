package drehzeigerdemo.gui;

import java.awt.Dimension;
import java.util.Observable;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import drehzeigerdemo.DrehzeigerDemoApplikation;
import drehzeigerdemo.gui.goodies.BildPanel;
import resources.MyBorderFactory;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: Muster
//Vorname:

public class ReiterPane extends JTabbedPane {
	// 7
	private static final long serialVersionUID = 1L;
	private ZeigerPanel zeigerPanel = new ZeigerPanel();
	private SummePanel summePanel = new SummePanel();
	private BildPanel glgPanel = new BildPanel("FourierGleichungen.png");
	private JScrollPane scrollPane = new JScrollPane(zeigerPanel);

	/**
	 * <pre>
	 * - Setzt bevorzugte Grösse auf (75% von DrehzeigerDemoApplikation.appWidth, 100% von DrehzeigerDemoApplikation.appHeight).
	 * - Baut das GUI gemäss Aufgabenstellung.
	 * </pre>
	 * 
	 */
	public ReiterPane() {
		// 5
		setPreferredSize(new Dimension((int) (0.75 * DrehzeigerDemoApplikation.appWidth),
				(int) (DrehzeigerDemoApplikation.appHeight)));
		setBorder(MyBorderFactory.createMyBorder(" ReiterPane: Zeiger "));

		addTab("Beziehungen", glgPanel);
		addTab("Drehzeiger", scrollPane);
		addTab("Summe", summePanel);
	}

	/**
	 * <pre>
	 * - Datiert entsprechende Komponenten auf.
	 * </pre>
	 * 
	 * @param obs
	 * @param obj
	 */
	public void update(Observable obs, Object obj) {
		// 2
		zeigerPanel.update(obs, obj);
		summePanel.update(obs, obj);
	}

}
