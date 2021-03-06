package model;
import util.Observable;
import util.TraceV3;

public class Model extends Observable {
	private TraceV3 trace = new TraceV3(this);
	private double note = 4.0;

	public Model() {
		trace.constructorCall();
	}

	/**
	 * <pre>
	 * - gibt Note zur?ck
	 * </pre>
	 */
	public double getData() {
		trace.methodeCall();
		return note;
	}

	/**
	 * <pre>
	 * - berechnet Note nach vorgegebener Kurve 
	 * - informiert Observer ?ber neue Daten
	 * </pre>
	 */
	public void berechneNote(double anzahlPunkte, double maxPunkte) {
		trace.methodeCall();

		note =  anzahlPunkte * 5.0 / maxPunkte + 1.0;
		if (note > 6.0) {
			note = 6.0;
		}
		notifyObservers();

	}

	public void notifyObservers() {
		trace.methodeCall();
		setChanged();
		super.notifyObservers();
	}
}