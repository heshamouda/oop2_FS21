package gui;

import model.Model;

public class Controller {

	private Model model;
	private View view;

	public Controller(Model model) {
		this.model = model;

	}

	public void setView(View view) {
		this.view = view;

	}

	/**
	 * <pre>
	 * - triggert die Signalberechnung mit entsprechendem Parameter
	 * </pre>
	 */
	public void btRefresh() {
		model.triggerSignalGenerator(Double.parseDouble(view.parameterPanel.tfVarianz.getText()));
	}

	/**
	 * <pre>
	 * - triggert Berechnung der FilterKonstanten
	 * </pre>
	 */
	public void slValue() {
		model.calcFilterConstant(view.parameterPanel.slFilter.getValue());
	}

}
