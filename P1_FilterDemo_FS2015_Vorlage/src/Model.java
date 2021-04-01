// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
//

import java.util.Observable;

import wavetableplayer.SineWave;
import wavetableplayer.WaveTablePlayer;

public class Model extends Observable {
	// 18
	private double[] fAxis, amplitudengang;
	private Filter filter;
	private WaveTablePlayer waveTablePlayer;

	/**
	 * <pre>
	 * - Erzeugt mittels linspace() von MicroMatlab die fAxis im Bereich von 0.0 bis 12e3 und mit 2000 Punkten.
	 * - Erzeugt einen waveTablePlayer mit der WaveForm (new SineWav(0.0, 0.0)).
	 * </pre>
	 * 
	 */
	public Model() {

	}

	/**
	 * <pre>
	 * - Gibt amplitudengang zurück.
	 * </pre>
	 * 
	 * @return
	 */
	public double[] getAmplitudengang() {

		return null; // Um Compiler glücklich zu halten ...
	}

	/**
	 * <pre>
	 * - Gibt fAxis zurück.
	 * </pre>
	 * 
	 * @return
	 */
	public double[] getFAxis() {

		return null; // Um Compiler glücklich zu halten ...
	}

	/**
	 * <pre>
	 * - Gibt filter zurück.
	 * </pre>
	 * 
	 * @return
	 */
	public Filter getFilter() {

		return null; // Um Compiler glücklich zu halten ...
	}

	/**
	 * <pre>
	 * - Holt Amplitude der waveForm des waveTablePlayer und gibt sie zurück.
	 * </pre>
	 * 
	 * @return
	 */
	public double getTestAmplitude() {

		return 0.0; // Um Compiler glücklich zu halten ...
	}

	/**
	 * <pre>
	 * - Holt Frequency der waveForm des waveTablePlayer und gibt sie zurück.
	 * </pre>
	 * 
	 * @return
	 */
	public double getTestFrequenz() {

		return 0.0; // Um Compiler glücklich zu halten ...
	}

	/**
	 * <pre>
	 * - Setzt das Attribut filter gleich filter.
	 * - Berechnet aufgrund von (filter.B, filter.A, fAxis), 
	 *   mittels Methode freqs() der Klasse MicroMatlab den Frequenzgang
	 *   und darauf basierend mittels Complex.abs() den Betrag, d.h den Array amplitudengang.
	 * - Setzt die Frequenz der waveForm des waveTablePlayer auf 0.0.
	 * - Setzt die Amplitude der waveForm des waveTablePlayer auf den 0-ten Wert des Arrays amplitudengang.
	 * - Notifiziert die Beobachter.
	 * </pre>
	 * 
	 * @param filter
	 */
	public void setFilter(Filter filter) {

	}

	/**
	 * <pre>
	 * - Setzt die Frequenz der waveForm des waveTablePlayer auf den Wert von frequenz.
	 * - Deklariert lokale Ganzzahl i mit Wert Null.
	 * - So lange fAxis[i] kleiner frequenz,
	 *     - Ganzzahl i um eins erhöhen.
	 * - Setzt die Amplitude der waveForm des waveTablePlayer auf den i-ten Wert des Arrays amplitudengang * 0.25.
	 * - Notifiziert die Beobachter.
	 * 
	 * </pre>
	 * 
	 * @param frequenz
	 */
	public void setTestFrequenz(double frequenz) {

	}

	@Override
	public void notifyObservers() {
		setChanged();
		super.notifyObservers();
	}

}

