package ch.fhnw.eit.oop2.wavegenerator.model;
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.

// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
//

import java.util.Observable;

import ch.fhnw.eit.oop2.wavegenerator.model.goodies.WaveForm;
import ch.fhnw.eit.oop2.wavegenerator.model.goodies.WaveTablePlayer;

public class Model extends Observable {
	// 28
	public static final int SINE = 0, SQUARE = 1, RAMP = 2;
	private WaveForm waveForm;
	private WaveTablePlayer waveTablePlayer;

	/**
	 * <pre>
	 * - Erzeugt die waveForm als SineWave() mit der Frequenz 1000 und der Amplitude 500.
	 * - Erzeugt den waveTablePlayer mit Argument waveForm.
	 * </pre>
	 */
	public Model() {
		// 2
	}

	/**
	 * <pre>
	 *  - Falls amplitude kleiner 0: amplitude gleich Null.
	 *  - Falls amplitude grösser 1000: amplitude gleich 1000.
	 *  - amplitude von waveForm setzen.
	 *  - Observer notifizieren.
	 * </pre>
	 * 
	 * @param amplitude
	 */
	public void setAmplitude(int amplitude) {
		// 6
	}

	/**
	 * <pre>
	 *  - Falls frequency kleiner 20: frequency gleich 20.
	 *  - Falls frequency grösser 20000: frequency gleich 20000.
	 *  - frequency von waveForm setzen.
	 *  - Observer notifizieren.
	 * </pre>
	 * 
	 * @param frequency
	 */
	public void setFrequency(int frequency) {
		// 6
	}

	/**
	 * <pre>
	 * - Frequenz und Amplitude aus momentaner waveForm auslesen und in lokale Var. ablegen.
	 * - Je nach form (SINE, SQUARE, RAMP) entsprechende waveForm mit gegebener Amplitude und Frequenz erzeugen.
	 * - WaveForm des waveTablePlayer neu setzen.
	 * - Beobachter notifizieren.
	 * </pre>
	 * 
	 * @param form
	 */
	public void setWaveForm(int form) {
		// 14
	}

	public int getAmplitude() {
		return waveForm.getAmplitude();
	}

	public int getFrequency() {
		return waveForm.getFrequency();
	}

	public void notifyObservers() {
		setChanged();
		super.notifyObservers();
	}

	public void stopPlayer() {
		waveTablePlayer.stop();
	}
}
