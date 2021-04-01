package dsv;

public class CircularBuffer {
	protected double[] buffer;
	protected int index = 0;

	/**
	 * Baut einen Zirkul�ren Buffer entsprechender L�nge ...
	 * 
	 * <pre>
	 * - Erzeugt einen double - Array entsprechender L�nge.
	 * </pre>
	 * 
	 * @param bufferLength L�nge des Buffers
	 */
	public CircularBuffer(int bufferLength) {
		buffer = new double[bufferLength];
	}

	/**
	 * Setzt den Wert in den Buffer ...
	 * 
	 * <pre>
	 * - Falls pre-dekremtierter index kleiner Null
	 *   - index gleich L�nge des Buffers minus 1 setzen.
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
	 * Gibt den entsprechenden Wert des Buffers zur�ck ...
	 * 
	 * <pre>
	 * - Falls der Betrag von k gr�sser als die L�nge des Buffers:
	 *   - IndexOutOfBoundsException werfen.
	 * - buffer an der Stelle ((index + k + buffer.length) % buffer.length) zur�ckgeben.
	 * </pre>
	 * 
	 * @param k Position relativ zu index
	 * @return Wert an entsprechender Stelle
	 * @throws IndexOutOfBoundsException Falls der Betrag von k gr�sser als die
	 *                                   L�nge des Buffers.
	 */
	public double getValue(int k) throws IndexOutOfBoundsException {
		if (Math.abs(k) > buffer.length)
			throw new IndexOutOfBoundsException();
		return buffer[(index + k + buffer.length) % buffer.length];
	}

}
