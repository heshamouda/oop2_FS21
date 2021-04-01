//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: Muster
//Vorname:

public class FIRFilter {
	// 10
	protected double[] coeffs;
	protected CircularBuffer circularBuffer;

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
		circularBuffer = new CircularBuffer(coeffs.length);
		this.coeffs = coeffs;
	}

	/**
	 * Baut ein FIR-Filter mit Zustands- und Koeffizienten-Array der Länge nTaps
	 * ...
	 * 
	 * <pre>
	 * - Erzeugt den CircularBuffer und Koeffizienten-Array entsprechender Länge.
	 * </pre>
	 * 
	 * @param nTaps
	 *            Anzahl Koeffizienten des Filters
	 */
	public FIRFilter(int nTaps) {
		// 2
		circularBuffer = new CircularBuffer(nTaps);
		coeffs = new double[nTaps];
	}

	/**
	 * Legt den Signalwert sample im Zustandsarray state ab und filtert das
	 * Signals mittels linearer Faltung ...
	 * 
	 * <pre>
	 * - sample in den CircularBuffer setzen.
	 * - Faltung gemäss Aufgabenstellung berechnen.
	 * - Resultat zurückgeben.
	 * </pre>
	 * 
	 * @param sample
	 *            Signalwert
	 * @return gefilterter Wert
	 */
	public double filter(double sample) {
		// 5
		circularBuffer.setValue(sample);

		double res = 0.0f;
		for (int k = 0; k < coeffs.length; k++)
			res += circularBuffer.getValue(k) * coeffs[k];

		return res;
	}

	/**
	 * Gibt zum Filter zugehörigen Koeffizienten-Array zurück ...
	 * 
	 * <pre>
	 * - coeffs zurückgeben.
	 * </pre>
	 * 
	 * @return Koeffizienten-Array
	 */
	public double[] getCoeffs() {
		// 1
		return coeffs;
	}

}
