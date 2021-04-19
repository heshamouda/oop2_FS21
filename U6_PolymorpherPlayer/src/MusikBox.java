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
	public void spieleMusik(Klarinette cl, JTextField tf, BildPanel bildPanel) {
		cl.spieltschoen(tf, bildPanel);
	}

	/**
	 * <pre>
	 * - ruft passende Methode der jeweiligen Instrumenten Klasse auf
	 * </pre>
	 */
	public void spieleMusik(Geige vl, JTextField tf, BildPanel bildPanel) {
		vl.spieltleise(tf, bildPanel);
	}

	public void spieleMusik(Klavier pn, JTextField tf, BildPanel bildPanel) {
		pn.spieltmehrstimmig(tf, bildPanel);
	}
}
