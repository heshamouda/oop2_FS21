import javax.swing.JTextField;

public class MusikBox {
	// K�nnte noch einige andere Logik, Features und drumherum Implementieren...
	// Dient als Sammelstelle f�r alle Aktivit�ten rund ums Abspielen
	//
	public MusikBox() {

	}

	// �berladene Methoden
	/**
	 * <pre>
	 * - ruft passende Methode der jeweiligen Instrumenten Klasse auf
	 * </pre>
	 */
	 public void spieleMusik (MusikInstrument instr, JTextField tField,BildPanel bildPanel) {
		 instr.spielen(tField, bildPanel);
	 }
}
