import javax.swing.JTextField;

public class MusikBox {
	// Könnte noch einige andere Logik, Features und drumherum Implementieren...
	// Dient als Sammelstelle für alle Aktivitäten rund ums Abspielen
	//
	public MusikBox() {

	}

	// Überladene Methoden
	/**
	 * <pre>
	 * - ruft passende Methode der jeweiligen Instrumenten Klasse auf
	 * </pre>
	 */
	 public void spieleMusik (MusikInstrument instr, JTextField tField,BildPanel bildPanel) {
		 instr.spielen(tField, bildPanel);
	 }
}
