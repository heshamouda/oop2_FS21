package soundeditor.model;

import tools.dsp.Equalizer;

// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
// Klasse:
//

import wavpackage.SoundTrack;

public class SoundEffects {
	// 21

	private static Equalizer EQUALIZER = new Equalizer();

	/**
	 * Diese Methode erlaubt das Signal mit Echo zu versetzen. Dazu steht die Klasse
	 * Delay zur Verf�gung.
	 * 
	 * <pre>
	 * - Signal aus soundTrack holen und in lokaler Variable signal ablegen. signal[SoundTrack.LEFT][i] 
	 *   bezeichnet in der Folge den i-ten Signalwert des linken Kanals, signal[SoundTrack.RIGHT][i] den 
	 *   i-ten Signalwert des rechten Kanals.
	 * - Lokale Delays delayLeft und delayRight f�r linken und rechten Kanal gem�ss Aufgabenstellung erzeugen.
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
	}

	/**
	 * Das Package dsp beinhaltet einen sogenannten Oktav - Equalizer, der in der
	 * Form von EQUALIZER zur Verf�gung steht. Mit dieser Methode kann das Signal
	 * entsprechend gefiltert werden.
	 * 
	 * <pre>
	 * - Signal aus soundTrack holen und in lokaler Variable signal ablegen. signal[SoundTrack.LEFT] 
	 *   bezeichnet in der Folge den linken Kanal, signal[SoundTrack.RIGHT] den rechten Kanal.
	 * - Gain des Equalizer setzen.
	 * - Equalizer gem�ss Aufgabenstellung auf linken und rechten Kanal anwenden.
	 * - Mittels normalize() den soundTrack auf Maximalwert 1.0 normieren.
	 * </pre>
	 * 
	 * @param soundTrack
	 * @param gain
	 */
	public static void equalize(SoundTrack soundTrack, double[] gain) {
		// 5
	}

	/**
	 * Diese Methode normiert den maximalen Betrag des Signales des linken wie auch
	 * des rechten Kanals den Wert value.
	 * 
	 * <pre>
	 * - Signal aus soundTrack holen und in lokaler Variable signal ablegen. signal[SoundTrack.LEFT][i] 
	 *   bezeichnet in der Folge den i-ten Signalwert des linken Kanals, signal[SoundTrack.RIGHT][i] den 
	 *   i-ten Signalwert des rechten Kanals.
	 * - Signal gem�ss Aufgabenstellung normieren.
	 * </pre>
	 * 
	 * @param soundTrack
	 * @param value
	 */
	public static void normalize(SoundTrack soundTrack, double value) {
		// 7
	}
}
