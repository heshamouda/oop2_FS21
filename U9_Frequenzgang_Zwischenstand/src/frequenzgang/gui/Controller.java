package frequenzgang.gui;

import frequenzgang.model.Model;
import util.TraceV5;

public class Controller {
	private TraceV5 trace = new TraceV5(this);
	private Model model;
	private View view;

	/**
	 * setzt Attribut
	 * @param model
	 */
	public Controller(Model model) {
		trace.constructorCall();
		
	}

	/**
	 * setzt Uebertragungsfunktion des Models
	 */
	public void btOkAction() {
		trace.methodeCall();
		
	}

	/**
	 * setzt Attribut
	 * @param view
	 */
	public void setView(View view) {
		trace.methodeCall();
		
	}

	/**
	 * Konvertiert Zeichenkette s mit Komma resp. Leerzeichen separierten Zahlen in
	 * einen Array mit den entsprechenden Zahlen.
	 * 
	 * @param s Zeichenkette mit Zahlen
	 * @return Array mit Zahlen
	 */
	private double[] stringToCoeff(String s) {
		trace.methodeCall();
		
		return null;
	}
}
