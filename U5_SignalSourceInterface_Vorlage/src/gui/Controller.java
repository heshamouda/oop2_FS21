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
	 * - triggert die Signalberechnung im Model mit entsprechendem Parameter
	 * </pre>
	 */
	public void btRefresh() {
		
	}

	/**
	 * <pre>
	 * - triggert Berechnung der FilterKonstanten
	 * </pre>
	 */
	public void slValue() {
		
	}

}
