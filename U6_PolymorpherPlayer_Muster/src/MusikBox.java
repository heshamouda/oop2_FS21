import javax.swing.JTextField;

public class MusikBox {
	// Könnte noch einige andere Logik, Features und drumherum Implementieren...
	public MusikBox() {

	}

	public void spieleMusik(MusikInstrument instr, JTextField tf, BildPanel bildPanel) {

		instr.spielen(tf, bildPanel);
	}

	// Überladene Methoden
//	public void spieleMusik(Klarinette cl, JTextField tf, BildPanel bildPanel) {
//		cl.spieltschoen(tf, bildPanel);
//	}
//
//	public void spieleMusik(Geige vl, JTextField tf, BildPanel bildPanel) {
//		vl.spieltleise(tf, bildPanel);
//	}

//	public void spieleMusik(Geige pn, JTextField tf, BildPanel bildPanel) {
//		vl.spieltmehrstimmig(tf, bildPanel);
//  }

}
