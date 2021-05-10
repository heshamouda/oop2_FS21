package soundeditor.gui;

import soundeditor.model.Model;

// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
// Klasse:
//

import wavpackage.WavPlayer;

public class Controller {
	// 16
	private Model model;
	private WavPlayer wavPlayer;
	private View view;

	/**
	 * 
	 * <pre>
	 * - Entsprechendes Attribut setzen.
	 * </pre>
	 * 
	 * @param model
	 */
	public Controller(Model model) {
		// 1
	}

	/**
	 * 
	 * <pre>
	 *  - Falls soundTrack des Models nicht gleich null:
	 *    - Werte aus jsEchoDelay und aus jsEchoAmplitude des Echo-Panel auslesen und in lokale Variable ablegen.
	 *    - Entsprechende Methode des Models mit den durch 1000.0 dividierten Werten aufrufen.
	 * </pre>
	 * 
	 */
	public void echoSoundTrack() {
		// 4
	}

	/**
	 * 
	 * <pre>
	 *  - Falls soundTrack des Models nicht gleich null:
	 *    - Lokalen double-Array der Länge 8 erzeugen.
	 *    - Für i = Null bis kleiner 8:
	 *      - Wert des i-ten Sliders auf dem Equalizer-Panel auslesen und zugehörigen Gain-Wert gemäss 
	 *        Aufgabenstellung berechnen und in den Array an der i-ten Stelle ablegen.
	 *    - Entsprechende Methode des Models aufrufen.
	 * </pre>
	 */
	public void equalizeSoundTrack() {
		// 5
	}

	/**
	 * <pre>
	 * - stopPlayer() aufrufen.
	 * - Entsprechende Methode des Models aufrufen.
	 * </pre>
	 * 
	 * @param wavDatei
	 */
	public void loadSoundTrack(String wavDatei) {
		// 2
	}

	/**
	 * 
	 * <pre>
	 * - Falls soundTrack des Models nicht gleich null:
	 *   - Entsprechende Methode des Models aufrufen.
	 * </pre>
	 */
	public void revert() {
		// 2
	}

	/**
	 * 
	 * <pre>
	 * - Falls soundTrack des Models nicht gleich null:
	 *   - Entsprechende Methode des Models aufrufen.
	 * </pre>
	 */
	public void saveSoundTrack(String wavDatei) {
		// 2
	}

	public void setView(View view) {
		this.view = view;
	}

	public void startPlayer() {
		if (model != null && (wavPlayer == null || !wavPlayer.isPlaying) && model.getSoundTrack() != null) {
			wavPlayer = new WavPlayer(model.getSoundTrack());
		}
	}

	public void stopPlayer() {
		if (model == null || wavPlayer == null || !wavPlayer.isPlaying || model.getSoundTrack() == null)
			return;
		wavPlayer.stop();
		wavPlayer = null;
	}
}
