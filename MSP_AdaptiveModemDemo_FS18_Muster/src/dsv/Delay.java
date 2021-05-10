package dsv;

public class Delay {
	public int length = 0;
	protected double[] delayLine;
	protected int index = 0;

	/**
	 * Baut einen Verz�gerungsblock entsprechender L�nge ...
	 * 
	 * <pre>
	 * - double-Array der L�nge delay plus 1 erzeugen.
	 * </pre>
	 * 
	 * @param delay Gew�nschte Verz�gerung.
	 */
	public Delay(int delay) {
		delayLine = new double[delay + 1];
		length = delay;
	}

	/**
	 * Setzt der neuen Wert in den Array und gibt verz�gerten Wert zur�ck ...
	 * 
	 * <pre>
	 * - delayLine an der Stelle index gleich sample setzen.
	 * - index gleich pre-inkrementiertem index Modulo L�nge der delayLine setzen.
	 * - delayLine an der Stelle index zur�ckgeben.
	 * </pre>
	 * 
	 * @param sample Neuer Wert
	 * @return Verz�gerter Wert.
	 */

	public double delay(double sample) {
		delayLine[index] = sample;
		index = (++index) % delayLine.length;
		return delayLine[index];
	}
}
