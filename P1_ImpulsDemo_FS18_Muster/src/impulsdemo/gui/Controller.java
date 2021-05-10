package impulsdemo.gui;

import impulsdemo.TraceV2;
import impulsdemo.model.Model;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: Muster
//Vorname:

public class Controller {
	// 5
	private TraceV2 tr = new TraceV2(this);
	private Model model;

	/**
	 * <pre>
	 * - Setzt entsprechendes Attribut.
	 * </pre>
	 * 
	 * @param model
	 * 
	 */
	public Controller(Model model) {
		// 1
		tr.methodeCall();
		this.model = model;
	}

	/**
	 * <pre>
	 * - Ruft entsprechende Methode des Models auf.
	 * </pre>
	 * 
	 * @param systemType
	 */
	public void setSystemType(String systemType) {
		// 1
		tr.methodeCall();
		model.setSystemType(systemType);
	}

	/**
	 * <pre>
	 * - Ruft entsprechende Methode des Models mit zugehörigen Arrays auf.
	 * </pre>
	 * 
	 * @param stZaehler
	 * @param stNenner
	 */
	public void setParameter(String stZaehler, String stNenner) {
		// 1
		tr.methodeCall();
		model.setUTF(stringToCoeff(stZaehler), stringToCoeff(stNenner));
	}

	/**
	 * <pre>
	 * - Ruft entsprechende Methode des Models auf.
	 * </pre>
	 * 
	 */
	public void btReset() {
		// 1
		tr.methodeCall();
		model.reset();
	}

	/**
	 * <pre>
	 * - Ruft entsprechende Methode des Models auf.
	 * </pre>
	 * 
	 */
	public void btStart() {
		// 1
		tr.methodeCall();
		model.start();
	}

	private double[] stringToCoeff(String s) {
		tr.methodeCall();
		String[] tokens = s.split("[, ]+");
		double[] z = new double[tokens.length];
		for (int i = 0; i < z.length; i++) {
			z[i] = Double.parseDouble(tokens[i]);
		}
		return z;
	}
}
