// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
// Modulanlass:

package aktivrcbandpass.gui;

import javax.swing.JTabbedPane;

import util.MyBorderFactory;
import util.Observable;
import util.TraceV7;

public class ReiterPane extends JTabbedPane {
	// 6 + 3
	private TraceV7 trace = new TraceV7(this);
	private static final long serialVersionUID = 1L;
	private AmplitudenPlot amplitudenPlot = new AmplitudenPlot();
	private PhasenPlot phasenPlot = new PhasenPlot();
	private SchemaPanel schemaPanel = new SchemaPanel();

	/**
	 * <pre>
	 * - Baut das User-Interface gemäss Angaben in der Aufgabenstellung.
	 * </pre>
	 * 
	 */
	public ReiterPane() {
		trace.constructorCall();
		// 4
		setBorder(MyBorderFactory.createMyBorder(" ReiterPane "));

		addTab("Schema", schemaPanel);
		addTab("Amplitudengang", amplitudenPlot);
		addTab("Phasengang", phasenPlot);
	}

	/**
	 * - Ruft update() der entsprechenden Panel auf.
	 */
	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		// 2
		amplitudenPlot.update(obs, obj);
		phasenPlot.update(obs, obj);
	}
}
