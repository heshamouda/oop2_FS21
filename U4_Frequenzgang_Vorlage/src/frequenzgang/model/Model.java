package frequenzgang.model;

import util.Observable;
import util.TraceV8;

public class Model extends Observable {
	private TraceV8 trace = new TraceV8(this);
	private Complex[] H = new Complex[0];
	private double[] faxis = new double[0];

	/**
	 * Konstruiert Model mit Frequenzgang und Frequenzachse.
	 * 
	 * @param fStart Startfrequenz des Frequenzganges
	 * @param fStop  Stoppfrequenz des Frequenzganges
	 * @param n      Anzahl Datenpunkte
	 */
	public Model(double fStart, double fStop, int n) {
		trace.constructorCall();

	}

	/**
	 * Setzt Übertragungsfunktion, gegeben durch Zähler- und Nennerpolynom.
	 * Berechnet direkt den zugehörigen Frequenzgang mittels PicoMatlab.freqs() und
	 * der Frequenzachse faxis des Models. Benachrichtigt Observers.
	 * 
	 * @param zaehler Zaehlerpolynom
	 * @param nenner  Nennerpolynom
	 */
	public void setUTF(double[] zaehler, double[] nenner) {
		trace.methodeCall();

		notifyObservers();
	}

	/**
	 * Holt Frequenzachse.
	 * 
	 * @return
	 */
	public double[] getFaxis() {
		trace.methodeCall();
		return faxis;
	}

	/**
	 * Holt Amplitude von H.
	 * 
	 * @return
	 */
	public double[] getAmplitude() {
		trace.methodeCall();
		
		return null;
	}

	/**
	 * Holt Phase von H.
	 * 
	 * @return
	 */
	public double[] getPhase() {
		trace.methodeCall();
		
		return null;
	}

	public int getLength() {
		trace.methodeCall();
		if (H == null)
			return 0;
		else
			return H.length;
	}

	/**
	 * Benachrichtigt Observers.
	 */
	public void notifyObservers() {
		trace.methodeCall();
		setChanged();
		super.notifyObservers();
	}
}
