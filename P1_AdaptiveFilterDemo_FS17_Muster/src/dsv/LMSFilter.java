package dsv;

public class LMSFilter extends FIRFilter {

	/**
	 * Baut ein adaptives LMSFilter entsprechender Länge ...
	 * 
	 * <pre>
	 * - Ruft entsprechenden Konstruktor der Super-Klasse auf.
	 * </pre>
	 * 
	 * @param nTaps
	 *            Anzahl Koeffizienten des Filters.
	 */
	public LMSFilter(int nTaps) {
		super(nTaps);
	}

	/**
	 * Adaptiert die zum Filter zugehörigen Koeffizienten ...
	 * 
	 * <pre>
	 * - Alle Koeffizienten entsprechend der Update-Gleichung in der Aufgabenstellung aufdatieren.
	 * </pre>
	 * 
	 * @param error
	 *            Fehler.
	 * @param step
	 *            Schrittweite zur Adaption.
	 */
	public void lms(double error, double step) {
		for (int k = 0; k < B.length; k++)
			B[k] += error * step * circularBuffer.getValue(k);
	}
}
