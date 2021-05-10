package dsv;

public class FIRFilter extends Filter {
	protected CircularBuffer circularBuffer;

	/**
	 * Baut ein FIR-Filter mit den gegebene Koeffizienten ...
	 * 
	 * <pre>
	 * - Erzeugt den CircularBuffer mit gleich vielen Elementen wie coeffs.
	 * - Setzt das Attribut coeffs.
	 * </pre>
	 * 
	 * @param B
	 *            Array mit den Filter-Koeffizienten.
	 */
	public FIRFilter(double[] B) {
		super(B, new double[] { 1.0 });
		circularBuffer = new CircularBuffer(B.length);
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
		super(new double[nTaps], new double[] { 1.0 });
		// 2
		circularBuffer = new CircularBuffer(nTaps);
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
		circularBuffer.setValue(sample);

		double res = 0.0f;
		for (int k = 0; k < B.length; k++)
			res += circularBuffer.getValue(k) * B[k];

		return res;
	}

	public double[] filter(double[] input) {
		double[] output = new double[input.length];
		for (int i = 0; i < output.length; i++) {
			output[i] = filter(input[i]);
		}
		return output;
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
		return B;
	}

}
