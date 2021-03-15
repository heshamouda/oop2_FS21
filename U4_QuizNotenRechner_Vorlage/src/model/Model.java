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
	 * - gibt Note zurück
	 * </pre>
	 */
	public double getData() {
		trace.methodeCall();
		return 0;
	}

	/**
	 * <pre>
	 * - berechnet Note nach vorgegebener Kurve 
	 * - informiert Observer über neue Daten
	 * </pre>
	 */
	public void berechneNote(double anzahlPunkte, double maxPunkte) {
		trace.methodeCall();

		
	}

	public void notifyObservers() {
		trace.methodeCall();
		setChanged();
		super.notifyObservers();
	}
}