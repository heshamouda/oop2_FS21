package ch.fhnw.eit.oop2.wavegenerator.model;
public class SquareWave extends WaveForm {

	/**
	 * <pre>
	 * - Ruft Konstruktor der Super - Klasse mit entsprechenden Argumenten auf.
	 * - Erzeugt Sinus- Form entsprechend Angaben in Aufgabenstellung.
	 * </pre>
	 * 
	 * @param frequency
	 * @param amplitude
	 */
	public SquareWave(int frequency, int amplitude) {
		// 6
		super(frequency, amplitude);
		for (int i = 1; i < waveTable.length; i++) {
			if (i < waveTable.length / 2)
				waveTable[i] = 1.0;
			else
				waveTable[i] = -1.0;
		}
	}
}
