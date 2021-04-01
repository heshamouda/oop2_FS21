import java.util.Observable;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: 
//Vorname:

public class Model extends Observable implements SignalListener {
	// 21
	private Delay verzoegerung;
	private LMSFilter adaptivesFilter;
	private SignalQuelle signalQuelle;
	private double[] fehler = new double[1024];
	private int index;
	private double schritt;

	/**
	 * Baut ein Model zur Visualisierung der Pr�diktion ...
	 * 
	 * <pre>
	 * - Instanziiert den Delay mit einer Verz�gerung von 128.
	 * - Instanziiert das LMSFilter der L�nge 32.
	 * - Instanziiert die Signalquelle mit den Parametern (100, 5, this).
	 * </pre>
	 */
	public Model() {
		// 3
	}

	@Override
	/**
	 * F�hrt die Verarbeitung der Signalwerte aus der Signalquelle durch ...
	 * 
	 * <pre>
	 * - F�r alle Signalwerte, beginnend mit dem 0-ten:
	 *   - Signalwert durch die Verz�gerung schicken.
	 *   - Verz�gertes Signal mittels adaptivem filter filtern.
	 *   - Fehler zwischen Signalwert und gefiltertem Signal berechnen und 
	 *     in fehler an der Stelle index ablegen.
	 *   - Filter mittels Methode lms() adaptieren.
	 *   - Den pre-inkrementierten index Modulo fehler.length in index ablegen.
	 * - Beobachter benachrichtigen.
	 * </pre>
	 */
	public void processSignal(double[] signal) {
		// ~ 7
	}

	/**
	 * Gibt den Fehler beginnend mit dem Element an der Stelle index zur�ck ...
	 * 
	 * <pre>
	 * - Neuen double - Array mit gleicher L�nge wie fehler erzeugen.
	 * - F�r k gleich Null bis kleiner der L�nge von fehler:
	 *   - kten Wert von neuem Array gleich fehler an der Stelle ((index + k) % fehler.length) setzen.
	 * - Neuen double Array zur�ckgeben.
	 * </pre>
	 * 
	 * @return Fehlerverlauf
	 */
	public double[] getFehler() {
		// ~ 4
		return null;
	}

	/**
	 * Setzt die Parameter ...
	 * 
	 * <pre>
	 * - Setzt das entsprechende Attribut und ruft entsprechende Methoden der Signalquelle auf.
	 * </pre>
	 * 
	 * @param stoerPegel
	 *            Pegel der St�rung
	 * @param signalPegel
	 *            Pegel des Signals
	 * @param schrittt
	 *            Schrittweite f�r Adaption
	 */
	public void setParameter(double stoerPegel, double signalPegel, double schrittt) {
		// 3
	}

	/**
	 * Setzt das Filter zur�ck ...
	 * 
	 * <pre>
	 * - Neues adaptives LMSFilter der L�nge 32 erzeugen.
	 * </pre>
	 */
	public void resetFilter() {
		// 1
	}

	/**
	 * <pre>
	 * - Gibt die Koeffizienten des adaptiven Filters zur�ck.
	 * </pre>
	 * 
	 * @return Koeffizienten des adaptiven Filters.
	 */
	public double[] getLMSFilterCoeffs() {
		// 1
		return null;
	}

	/**
	 * Ruft entsprechende Methode der Signalquelle auf.
	 * 
	 * @param b
	 *            true: on, false: off.
	 */
	public void setSignalOn(boolean b) {
		// 1
	}

	/**
	 * Ruft entsprechende Methode der Signalquelle auf.
	 * 
	 * @param b
	 *            true: on, false: off.
	 */
	public void setStoererOn(boolean b) {
		// 1
	}

	@Override
	public void notifyObservers() {
		setChanged();
		super.notifyObservers();
	}

}