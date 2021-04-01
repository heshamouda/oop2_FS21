package ch.fhnw.eit.oop2.wavegenerator.gui;
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
//

import ch.fhnw.eit.oop2.wavegenerator.model.Model;

public class Controller {
	// 6
	private Model model;
	private View view;

	/**
	 * <pre>
	 * - Setzt entsprechendes Attribut.
	 * </pre>
	 * 
	 * @param model
	 */
	public Controller(Model model) {
		this.model = model;
	}

	/**
	 * <pre>
	 * - Delegiert Aufgabe an model.
	 * </pre>
	 * 
	 * @param amplitude
	 */
	public void setAmplitude(int amplitude) {
		model.setAmplitude(amplitude);
	}

	/**
	 * <pre>
	 * - Delegiert Aufgabe an model.
	 * </pre>
	 * 
	 * @param frequency
	 */
	public void setFrequency(int frequency) {
		model.setFrequency(frequency);
	}

	/**
	 * <pre>
	 * - Delegiert Aufgabe an displayPanel der view.
	 * </pre>
	 * 
	 * @param unit
	 */
	public void setUnit(int unit) {
		view.displayPanel.setUnit(unit);
	}

	/**
	 * <pre>
	 * - Setzt entsprechendes Attribut.
	 * </pre>
	 * 
	 * @param view
	 */
	public void setView(View view) {
		this.view = view;
	}

	/**
	 * <pre>
	 * - Delegiert Aufgabe an model.
	 * </pre>
	 * 
	 * @param form
	 */
	public void setWaveForm(int form) {
		model.setWaveForm(form);
	}

}
