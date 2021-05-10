package dsv;

public class CircularBuffer {
	protected double[] buffer;
	protected int index = 0;

	/**
	 * Baut einen Zirkulären Buffer entsprechender Länge ...
	 * 
	 * <pre>
	 * - Erzeugt einen double - Array entsprechender Länge.
	 * </pre>
	 * 
	 * @param bufferLength Länge des Buffers
	 */
	public CircularBuffer(int bufferLength) {
		buffer = new double[bufferLength];
	}

	/**
	 * Setzt den Wert in den Buffer ...
	 * 
	 * <pre>
	 * - Falls pre-dekremtierter index kleiner Null
	 *   - index gleich Länge des Buffers minus 1 setzen.
	 * - Wert an der Stelle index in den Buffer schreiben.
	 * </pre>
	 * 
	 * @param value Wert
	 */
	public void setValue(double value) {
		if (--index < 0)
			index = buffer.length - 1;
		buffer[index] = value;
	}

	/**
	 * Gibt den entsprechenden Wert des Buffers zurück ...
	 * 
	 * <pre>
	 * - Falls der Betrag von k grösser als die Länge des Buffers:
	 *   - IndexOutOfBoundsException werfen.
	 * - buffer an der Stelle ((index + k + buffer.length) % buffer.length) zurückgeben.
	 * </pre>
	 * 
	 * @param k Position relativ zu index
	 * @return Wert an entsprechender Stelle
	 * @throws IndexOutOfBoundsException Falls der Betrag von k grösser als die
	 *                                   Länge des Buffers.
	 */
	public double getValue(int k) throws IndexOutOfBoundsException {
		if (Math.abs(k) > buffer.length)
			throw new IndexOutOfBoundsException();
		return buffer[(index + k + buffer.length) % buffer.length];
	}

}
