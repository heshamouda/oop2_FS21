package frequenzgang.gui;

import frequenzgang.model.Model;
import util.TraceV8;

public class Controller {
	private TraceV8 trace = new TraceV8(this);
	private Model model;
	private View view;

	public Controller(Model model) {
		trace.constructorCall();
		this.model = model;
	}

	public void btOkAction() {
		trace.methodeCall();
		model.setUTF(stringToCoeff(view.tfZaehler.getText()), stringToCoeff(view.tfNenner.getText()));
	}

	public void setView(View view) {
		trace.methodeCall();
		this.view = view;
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
		String[] tokens = s.split("[, ]+");
		double[] z = new double[tokens.length];
		for (int i = 0; i < z.length; i++) {
			z[i] = Double.parseDouble(tokens[i]);
		}
		return z;
	}
}
