// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
// Modulanlass:

package aktivrcbandpass.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import util.TraceV7;

public class SchemaPanel extends JPanel {
	TraceV7 trace = new TraceV7(this);
	private static final long serialVersionUID = 1L;
	// 2 + 2
	private BildPanel formel = new BildPanel("Formel.png");
	private BildPanel schema = new BildPanel("Schema.png");

	/**
	 * Konstruktor der Klasse SchemaPanel.
	 * 
	 * <pre>
	 * - Baut das User-Interface gemäss Angaben in der Aufgabenstellung.
	 * </pre>
	 * 
	 */
	public SchemaPanel() {
		super(new GridBagLayout());
		trace.constructorCall();
		// 2

		add(schema, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));
		add(formel, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));
	}
}
