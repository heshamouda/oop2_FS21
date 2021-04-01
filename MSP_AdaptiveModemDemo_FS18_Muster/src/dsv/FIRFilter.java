package dsv;
//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.

//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: 
//Vorname:

public class FIRFilter extends Filter {
	// 10
	protected CircularBuffer circularBuffer;

	/**
	 * Baut ein FIR-Filter mit den gegebene Koeffizienten ...
	 * 
	 * <pre>
	 * - Erzeugt den CircularBuffer mit gleich vielen Elementen wie coeffs.
	 * - Setzt das Attribut coeffs.
	 * </pre>
	 * 
	 * @param B Array mit den Filter-Koeffizienten.
	 */
	public FIRFilter(double[] B) {
		// 2
		super(B, new double[] { 1.0 });
		circularBuffer = new CircularBuffer(B.length);
	}

	/**
	 * Baut ein FIR-Filter mit Zustands- und Koeffizienten-Array der L�nge nTaps ...
	 * 
	 * <pre>
	 * - Erzeugt den CircularBuffer und Koeffizienten-Array entsprechender L�nge.
	 * </pre>
	 * 
	 * @param nTaps Anzahl Koeffizienten des Filters
	 */
	public FIRFilter(int nTaps) {
		super(new double[nTaps], new double[] { 1.0 });
		// 2
		circularBuffer = new CircularBuffer(nTaps);
	}

	/**
	 * Legt den Signalwert sample im Zustandsarray state ab und filtert das Signals
	 * mittels linearer Faltung ...
	 * 
	 * <pre>
	 * - sample in den CircularBuffer setzen.
	 * - Faltung gem�ss Aufgabenstellung berechnen.
	 * - Resultat zur�ckgeben.
	 * </pre>
	 * 
	 * @param sample Signalwert
	 * @return gefilterter Wert
	 */
	public double filter(double sample) {
		// 5
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
		return B;
	}

}
