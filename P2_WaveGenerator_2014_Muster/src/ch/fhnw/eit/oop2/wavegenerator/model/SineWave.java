package ch.fhnw.eit.oop2.wavegenerator.model;
public class SineWave extends WaveForm {

	/**
	 * <pre>
	 * - Ruft Konstruktor der Super - Klasse mit entsprechenden Argumenten auf.
	 * - Erzeugt Sinus- Form entsprechend Angaben in Aufgabenstellung.
	 * </pre>
	 * 
	 * @param frequency
	 * @param amplitude
	 */
	public SineWave(int frequency, int amplitude) {
		// 3
		super(frequency, amplitude);
		for (int i = 0; i < waveTable.length; i++) {
			waveTable[i] = Math.sin(i * 2.0 * Math.PI / waveTable.length);
		}
	}
}
