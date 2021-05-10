package soundeditor.gui;
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.

// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: MUSTER
// Vorname:
// Klasse:
//

import soundeditor.model.Model;
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
		this.model = model;
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
		if (model.getSoundTrack() != null) {
			double delay = view.echoPanel.jsEchoDelay.getValue();
			double alpha = view.echoPanel.jsEchoAmplitude.getValue();
			model.echoSoundTrack(delay / 1000.0, alpha / 1000.);
		}
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
		if (model.getSoundTrack() != null) {
			double[] gain = new double[8];
			for (int i = 0; i < gain.length; i++) {
				gain[i] = Math.pow(10.0, (view.equalizerPanel.sliders[i].getValue() / 20.0));
			}
			model.equalizeSoundTrack(gain);
		}
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
		stopPlayer();
		model.loadSoundTrack(wavDatei);
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
		if (model.getSoundTrack() != null)
			model.revert();
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
		if (model.getSoundTrack() != null)
			model.saveSoundTrack(wavDatei);
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
