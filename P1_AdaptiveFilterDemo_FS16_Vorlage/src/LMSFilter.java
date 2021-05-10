//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: 
//Vorname:

public class LMSFilter extends FIRFilter {
	// 3

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
		// 1
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
		// 2 + 2
	}
}
