package ch.fhnw.eit.oop2.wavegenerator.model;
public class RampWave extends WaveForm {

	/**
	 * <pre>
	 * - Ruft Konstruktor der Super - Klasse mit entsprechenden Argumenten auf.
	 * - Erzeugt Sinus- Form entsprechend Angaben in Aufgabenstellung.
	 * </pre>
	 * 
	 * @param frequency
	 * @param amplitude
	 */
	public RampWave(int frequency, int amplitude) {
		// 5
		super(frequency, amplitude);
		int length = waveTable.length;
		for (int i = 0; i < length; i++) {
			if (i < length / 4)
				waveTable[i] = i * 1.0 / (length / 4);
			else if (i < 3 * length / 4)
				waveTable[i] = 1.0 - (i - (length / 4)) * 1.0 / (length / 4);
			else if (i > 3 * length / 4)
				waveTable[i] = -1.0 + (i - (3 * length / 4)) * 1.0
						/ (length / 4);
			else
				waveTable[i] = -1.0;
		}
	}
}
