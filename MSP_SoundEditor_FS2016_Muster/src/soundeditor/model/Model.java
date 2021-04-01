package soundeditor.model;
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.

// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: MUSTER
// Vorname:
// Klasse:
//

import java.util.Observable;
import java.util.Vector;

import wavpackage.SoundTrack;

public class Model extends Observable {
	// 31
	private SoundTrack soundTrack;
	private Vector<SoundTrack> soundTracks = new Vector<SoundTrack>();

	/**
	 * 
	 * <pre>
	 * - delay und alpha in lokale final double Variablen ablegen.
	 * - clone() von soundTrack in soundTrack ablegen.
	 * - soundTrack als Element zu Vector soundTracks hinzufügen.
	 * - Neuen Thread mit anonymem Runnable() erzeugen.
	 *   - Der Methode run() kommt dabei folgende Aufgabe zu:
	 *     - Entsprechende statische Methode von SoundEffects aufrufen.
	 *     - Beobachter benachrichtigen.
	 * - Thread starten.
	 * </pre>
	 * 
	 * @param delay
	 * @param alpha
	 */
	public void echoSoundTrack(double delay, double alpha) {
		// 9
		final double d = delay;
		final double a = alpha;
		soundTrack = soundTrack.clone();
		soundTracks.addElement(soundTrack);
		Thread thread = new Thread(new Runnable() {
			public void run() {
				SoundEffects.echo(soundTrack, d, a);
				notifyObservers();
			}
		});
		thread.start();
	}

	/**
	 * 
	 * <pre>
	 * - gain in lokale final double Variable ablegen.
	 * - clone() von soundTrack in soundTrack ablegen.
	 * - soundTrack als Element zu Vector soundTracks hinzufügen.
	 * - Neuen Thread mit anonymem Runnable() erzeugen.
	 *   - Der Methode run() kommt dabei folgende Aufgabe zu:
	 *     - Entsprechende statische Methode von SoundEffects aufrufen.
	 *     - Beobachter benachrichtigen.
	 * - Thread starten.
	 * </pre>
	 * 
	 * @param gain
	 */
	public void equalizeSoundTrack(double[] gain) {
		// 8
		final double[] g = gain;
		soundTrack = soundTrack.clone();
		soundTracks.addElement(soundTrack);
		Thread thread = new Thread(new Runnable() {
			public void run() {
				SoundEffects.equalize(soundTrack, g);
				notifyObservers();
			}
		});
		thread.start();
	}

	public double getDuration() {
		return soundTrack.getDuration();
	}

	public double getSampleRate() {
		return soundTrack.getSampleRate();
	}

	public double[][] getSignal() {
		return soundTrack.getSignal();
	}

	public SoundTrack getSoundTrack() {
		return soundTrack;
	}

	public double[] getTimeAxis() {
		return soundTrack.getTimeAxis();
	}

	/**
	 * <pre>
	 * - soundTrack und soundTracks null setzen.
	 * - Mit entsprechender Datei neuen SoundTrack erzeugen und in soundTrack ablegen.
	 * - soundTrack als Element zu Vector soundTracks hinzufügen.
	 * - Beobachter benachrichtigen.
	 * </pre>
	 * 
	 * @param wavDatei
	 */
	public void loadSoundTrack(String wavDatei) {
		// 6
		soundTrack = null;
		soundTracks = null;
		soundTrack = new SoundTrack(wavDatei);
		soundTracks = new Vector<SoundTrack>();
		soundTracks.add(soundTrack);
		notifyObservers();
	}

	/**
	 * <pre>
	 * - Falls size() von Vector soundTracks grösser 1:
	 *   - Letztes Element aus Vector soundTracks entfernen.
	 *   - soundTrack gleich dem nun letzten Element in Vector soundTracks setzen.
	 *   - Beobachter benachrichtigen.
	 * </pre>
	 */
	public void revert() {
		// 4
		if (soundTracks.size() > 1) {
			soundTracks.remove(soundTracks.lastElement());
			soundTrack = soundTracks.lastElement();
			notifyObservers();
		}
	}

	/**
	 * 
	 * <pre>
	 * - Falls Signal von soundTrack NICHT gleich null:
	 *   - WAV-Datei mit entsprechender Methode von soundTrack schreiben.
	 *   - Neuen Vector<SoundTrack> soundTracks erzeugen.
	 * - soundTrack als Element zu Vector soundTracks hinzufügen.
	 * </pre>
	 * 
	 * @param wavDatei
	 */
	public void saveSoundTrack(String wavDatei) {
		// 4
		if (soundTrack.getSignal() != null) {
			soundTrack.writeWav(wavDatei);
			soundTracks = new Vector<SoundTrack>();
			soundTracks.add(soundTrack);
		}
	}

	public void notifyObservers() {
		setChanged();
		super.notifyObservers();
	}
}
