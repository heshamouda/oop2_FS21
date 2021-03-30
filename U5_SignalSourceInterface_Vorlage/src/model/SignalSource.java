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
		this.dataListener = dataListener;		

	}

	/**
	 * <pre>
	 * - erzeugt Random Objekt r
	 * - berechnet für alle buffer[i] mit r.nextGaussian * Math.sqrt(varianz) das Zufallssignal
	 * - ruft process-Methode des übergeben Datenlisteners auf
	 * </pre>
	 */
	public void generateSignal(double varianz) {
		Random r = new Random();
		
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = r.nextGaussian() * Math.sqrt(varianz);		
			
		}
		
		dataListener.process(buffer);		
	}
}
