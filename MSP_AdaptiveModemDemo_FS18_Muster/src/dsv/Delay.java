package dsv;

public class Delay {
	public int length = 0;
	protected double[] delayLine;
	protected int index = 0;

	/**
	 * Baut einen Verzögerungsblock entsprechender Länge ...
	 * 
	 * <pre>
	 * - double-Array der Länge delay plus 1 erzeugen.
	 * </pre>
	 * 
	 * @param delay Gewünschte Verzögerung.
	 */
	public Delay(int delay) {
		delayLine = new double[delay + 1];
		length = delay;
	}

	/**
	 * Setzt der neuen Wert in den Array und gibt verzögerten Wert zurück ...
	 * 
	 * <pre>
	 * - delayLine an der Stelle index gleich sample setzen.
	 * - index gleich pre-inkrementiertem index Modulo Länge der delayLine setzen.
	 * - delayLine an der Stelle index zurückgeben.
	 * </pre>
	 * 
	 * @param sample Neuer Wert
	 * @return Verzögerter Wert.
	 */

	public double delay(double sample) {
		delayLine[index] = sample;
		index = (++index) % delayLine.length;
		return delayLine[index];
	}
}
