package soundeditor.model;
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.

// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: MUSTER
// Vorname:
// Klasse:
//

import tools.dsp.Delay;
import tools.dsp.Equalizer;
import wavpackage.SoundTrack;

public class SoundEffects {
	// 21

	private static Equalizer EQUALIZER = new Equalizer();

	/**
	 * Diese Methode erlaubt das Signal mit Echo zu versetzen. Dazu steht die Klasse
	 * Delay zur Verfügung.
	 * 
	 * <pre>
	 * - Signal aus soundTrack holen und in lokaler Variable signal ablegen. signal[SoundTrack.LEFT][i] 
	 *   bezeichnet in der Folge den i-ten Signalwert des linken Kanals, signal[SoundTrack.RIGHT][i] den 
	 *   i-ten Signalwert des rechten Kanals.
	 * - Lokale Delays delayLeft und delayRight für linken und rechten Kanal gemäss Aufgabenstellung erzeugen.
	 * - Blockdiagramm aus Aufgabenstellung implementieren.
	 * - Mittels normalize() den soundTrack auf Maximalwert 1.0 normieren.
	 * </pre>
	 * 
	 * @param soundTrack
	 * @param delay
	 * @param alpha
	 */
	public static void echo(SoundTrack soundTrack, double delay, double alpha) {
		// 9
		double[][] signal = soundTrack.getSignal();

		Delay delayLeft = new Delay((int) (delay * soundTrack.getSampleRate()));
		Delay delayRight = new Delay((int) (delay * soundTrack.getSampleRate()));

		for (int i = 0; i < signal[SoundTrack.LEFT].length; i++) {
			signal[SoundTrack.LEFT][i] = signal[SoundTrack.LEFT][i] + delayLeft.getValue();
			delayLeft.setValue(alpha * signal[SoundTrack.LEFT][i]);
			signal[SoundTrack.RIGHT][i] = signal[SoundTrack.RIGHT][i] + delayRight.getValue();
			delayRight.setValue(alpha * signal[SoundTrack.RIGHT][i]);
		}

		normalize(soundTrack, 1.0);
	}

	/**
	 * Das Package dsp beinhaltet einen sogenannten Oktav - Equalizer, der in der
	 * Form von EQUALIZER zur Verfügung steht. Mit dieser Methode kann das Signal
	 * entsprechend gefiltert werden.
	 * 
	 * <pre>
	 * - Signal aus soundTrack holen und in lokaler Variable signal ablegen. signal[SoundTrack.LEFT] 
	 *   bezeichnet in der Folge den linken Kanal, signal[SoundTrack.RIGHT] den rechten Kanal.
	 * - Gain des Equalizer setzen.
	 * - Equalizer gemäss Aufgabenstellung auf linken und rechten Kanal anwenden.
	 * - Mittels normalize() den soundTrack auf Maximalwert 1.0 normieren.
	 * </pre>
	 * 
	 * @param soundTrack
	 * @param gain
	 */
	public static void equalize(SoundTrack soundTrack, double[] gain) {
		// 5
		double[][] signal = soundTrack.getSignal();

		EQUALIZER.setGain(gain);
		signal[SoundTrack.LEFT] = EQUALIZER.equalizer(signal[SoundTrack.LEFT]);
		signal[SoundTrack.RIGHT] = EQUALIZER.equalizer(signal[SoundTrack.RIGHT]);

		normalize(soundTrack, 1.0);
	}

	/**
	 * Diese Methode normiert den maximalen Betrag des Signales des linken wie auch
	 * des rechten Kanals den Wert value.
	 * 
	 * <pre>
	 * - Signal aus soundTrack holen und in lokaler Variable signal ablegen. signal[SoundTrack.LEFT][i] 
	 *   bezeichnet in der Folge den i-ten Signalwert des linken Kanals, signal[SoundTrack.RIGHT][i] den 
	 *   i-ten Signalwert des rechten Kanals.
	 * - Signal gemäss Aufgabenstellung normieren.
	 * </pre>
	 * 
	 * @param soundTrack
	 * @param value
	 */
	public static void normalize(SoundTrack soundTrack, double value) {
		// 7
		double[][] signal = soundTrack.getSignal();
		double max = 0.0;

		for (int i = 0; i < signal[SoundTrack.LEFT].length; i++) {
			max = Math.max(Math.max(Math.abs(signal[SoundTrack.LEFT][i]), Math.abs(signal[SoundTrack.RIGHT][i])), max);
		}

		for (int i = 0; i < signal[0].length; i++) {
			signal[0][i] = value * signal[SoundTrack.LEFT][i] / max;
			signal[1][i] = value * signal[SoundTrack.RIGHT][i] / max;
		}
	}
}
