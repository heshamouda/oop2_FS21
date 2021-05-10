package modem.gui;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import modem.gui.goodies.StatusBar;
import modem.model.Model;
import modem.model.Parameter;

// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiderhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:

public class Controller implements Runnable {
	// 13
	private Model model;
	private View view;
	private ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

	/**
	 * <pre>
	 * - Setzt entsprechendes Attribut.
	 * - Bewirkt mittels service.scheduleAtFixedRate(Runnable runnable, long initialDelay, 
	 *   long periode, TimeUnit TimeUnit.MILLISECONDS), dass die Methode run() nach einer 
	 *   Anfangsverzögerung von 1500 ms alle 100 ms ausgeführt wird.
	 * </pre>
	 * 
	 * @param model
	 */
	public Controller(Model model) {
		// 2
		this.model = model;
		service.scheduleAtFixedRate(this, 1500, 100, TimeUnit.MILLISECONDS);
	}

	/**
	 * <pre>
	 * - Erzeugt ein Wrapper-Objekt parameter der Klasse Parameter.
	 * - Holt den Text aus den Textfeldern des ParameterPanel der View und Wandelt sie in double - Zahlen.
	 * - Setzt die entsprechenden Attribute im Objekt parameter.
	 * - Holt den SelectedIndex der ComboBox cbKanalLaenge des ParameterPanels der View und 
	 *   setzt das entsprechende Attribute im Objekt parameter.
	 * - Ruft entsprechende Methode des Models auf.
	 * </pre>
	 * 
	 */
	public void setParameter() {
		// 8
		try {
			Parameter parameter = new Parameter();
			parameter.awgnAmplitude = Double.parseDouble(view.parameterPanel.tfAWGNAmplitude.getText());
			parameter.kanalIndex = view.parameterPanel.cbKanalLaenge.getSelectedIndex();
			parameter.tonAmplitude = Double.parseDouble(view.parameterPanel.tfTonAmplitude.getText());
			parameter.tonFrequenz = Double.parseDouble(view.parameterPanel.tfTonFrequenz.getText());
			parameter.schrittFF = Double.parseDouble(view.parameterPanel.tfSchrittFF.getText());
			parameter.schrittFB = Double.parseDouble(view.parameterPanel.tfSchrittFB.getText());
			model.setParameter(parameter);

		} catch (Exception e) {
			StatusBar.showStatus("Fehleingabe!");
		}

	}

	/**
	 * <pre>
	 * - Setzt entsprechendes Attribut ;-).
	 * </pre>
	 * 
	 */
	public void resetFilter() {
		// 1
		model.resetFilter();
	}

	/**
	 * <pre>
	 * - Setzt entsprechendes Attribut ;-).
	 * </pre>
	 * 
	 * @param view
	 */
	public void setView(View view) {
		// 1
		this.view = view;
	}

	@Override
	/**
	 * <pre>
	 * - Ruf die Methode notifyObservers() des Models auf ;-).
	 * </pre>
	 */
	public void run() {
		// 1
		model.notifyObservers();
	}

}
