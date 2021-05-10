//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: 
//Vorname:

public class FIRFilter {
	// 10
	protected double[] coeffs;
	protected CircularBuffer circularBuffer;

	public FIRFilter() {
	}

	/**
	 * Baut ein FIR-Filter mit den gegebene Koeffizienten ...
	 * 
	 * <pre>
	 * - Erzeugt den CircularBuffer mit gleich vielen Elementen wie coeffs.
	 * - Setzt das Attribut coeffs.
	 * </pre>
	 * 
	 * @param coeffs
	 *            Array mit den Filter-Koeffizienten.
	 */
	public FIRFilter(double[] coeffs) {
		// 2
	}

	/**
	 * Baut ein FIR-Filter mit Zustands- und Koeffizienten-Array der L�nge nTaps
	 * ...
	 * 
	 * <pre>
	 * - Erzeugt den CircularBuffer und Koeffizienten-Array entsprechender L�nge.
	 * </pre>
	 * 
	 * @param nTaps
	 *            Anzahl Koeffizienten des Filters
	 */
	public FIRFilter(int nTaps) {
		// 2
	}

	/**
	 * Legt den Signalwert sample im Zustandsarray state ab und filtert das
	 * Signals mittels linearer Faltung ...
	 * 
	 * <pre>
	 * - sample in den CircularBuffer setzen.
	 * - Faltung gem�ss Aufgabenstellung berechnen.
	 * - Resultat zur�ckgeben.
	 * </pre>
	 * 
	 * @param sample
	 *            Signalwert
	 * @return gefilterter Wert
	 */
	public double filter(double sample) {
		// 5 + 2
		return 0.0;
	}

	/**
	 * Gibt zum Filter zugeh�rigen Koeffizienten-Array zur�ck ...
	 * 
	 * <pre>
	 * - coeffs zur�ckgeben.
	 * </pre>
	 * 
	 * @return Koeffizienten-Array
	 */
	public double[] getCoeffs() {
		// 1
		return null;
	}

}
