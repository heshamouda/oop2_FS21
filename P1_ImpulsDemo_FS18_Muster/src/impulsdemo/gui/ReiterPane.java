package impulsdemo.gui;

import java.awt.Dimension;
import java.util.Observable;

import javax.swing.JTabbedPane;

import impulsdemo.ImpulsDemoApplikation;
import impulsdemo.TraceV2;
import impulsdemo.gui.goodies.BildPanel;
import impulsdemo.gui.goodies.SummePanel;
import impulsdemo.gui.goodies.ZeigerPanel;
import resources.MyBorderFactory;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: Muster
//Vorname:

public class ReiterPane extends JTabbedPane {
	// 7
	private TraceV2 tr = new TraceV2(this);
	private static final long serialVersionUID = 1L;
	private ZeigerPanel zeigerPanel = new ZeigerPanel();
	private SummePanel summePanel = new SummePanel();
	private BildPanel glgPanel = new BildPanel("Beziehungen.png");

	/**
	 * <pre>
	 * - Setzt bevorzugte Grösse auf (65% von DrehzeigerDemoApplikation.appWidth, 100% von DrehzeigerDemoApplikation.appHeight).
	 * - Setzt die Border mit entsprechendes Beschriftung.
	 * - Baut das GUI mit den drei Reitern gemäss Aufgabenstellung.
	 *   Hinweis: Komponenten werden mittels der Methode addTab(String title, Component component) hinzugefügt.
	 * </pre>
	 * 
	 */
	public ReiterPane() {
		// 5
		tr.constructorCall();
		setPreferredSize(
				new Dimension((int) (0.65 * ImpulsDemoApplikation.appWidth), (int) (ImpulsDemoApplikation.appHeight)));
		setBorder(MyBorderFactory.createMyBorder(" ReiterPane: Zeiger "));

		addTab("Beziehungen", glgPanel);
		addTab("Drehzeiger", zeigerPanel);
		addTab("Summe", summePanel);
	}

	/**
	 * <pre>
	 * - Ruft passendes update() der entsprechenden Komponenten auf.
	 * </pre>
	 * 
	 * @param obs
	 * @param obj
	 */
	public void update(Observable obs, Object obj) {
		// 2
		tr.methodeCall();
		zeigerPanel.update(obs, obj);
		summePanel.update(obs, obj);
	}
}
