package model;

import java.util.Random;

public class SignalSource {

	private double[] buffer = new double[100];
	private DataListener dataListener;

	/**
	 * <pre>
	 * - setzt Attribut der Klasse
	 * </pre>
	 */
	public SignalSource(DataListener dataListener) {
		

	}

	/**
	 * <pre>
	 * - erzeugt Random Objekt r
	 * - berechnet f�r alle buffer[i] mit r.nextGaussian * Math.sqrt(varianz) das Zufallssignal
	 * - ruft process-Methode des �bergeben Datenlisteners auf
	 * </pre>
	 */
	public void generateSignal(double varianz) {

		
	}
}
