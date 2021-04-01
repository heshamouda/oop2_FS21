package impulsdemo.test;

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

	/**
	 * <pre>
	 * - Setzt entsprechendes Attribut.
	 * </pre>
	 * 
	 * @param model
	 * 
	 */
	public Controller() {
		// 1
		tr.methodeCall();
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
		System.out.println("setSystemType()");
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
		System.out.println("setParameter()");
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
		System.out.println("btReset()");
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
		System.out.println("btStart()");
	}

}
