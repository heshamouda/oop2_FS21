package frequenzgang.model;

import util.Observable;
import util.TraceV5;

public class Model extends Observable {
	private TraceV5 trace = new TraceV5(this);
	private Complex[] H = {};
	private double[] faxis = {};

	/**
	 * Konstruiert Frequenzachse des Models.
	 * 
	 * @param fStart Startfrequenz des Frequenzganges
	 * @param fStop  Stoppfrequenz des Frequenzganges
	 * @param n      Anzahl Datenpunkte
	 */
	public Model(double fStart, double fStop, int n) {
		trace.constructorCall();
		faxis = new double [n];
		for (int i = 0; i < faxis.length; i++) {
			faxis[i] = fStart + (fStop - fStart) / (n-1) * i;
		}

	}

	/**
	 * Setzt Übertragungsfunktion, gegeben durch Zaehler- und Nennerpolynom:
	 * Berechnet direkt den zugehoerigen Frequenzgang mittels PicoMatlab.freqs() und
	 * der Frequenzachse faxis des Models. Benachrichtigt Observers.
	 * 
	 * @param zaehler Zaehlerpolynom
	 * @param nenner  Nennerpolynom
	 */
	public void setUTF(double[] zaehler, double[] nenner) {
		trace.methodeCall();
		
	}

	/**
	 * Holt Frequenzachse.
	 * 
	 * @return
	 */
	public double[] getFaxis() {
		trace.methodeCall();
		return null;//damit Compiler happy
	}

	/**
	 * Holt Amplitude von H.
	 * 
	 * @return
	 */
	public double[] getAmplitude() {
		trace.methodeCall();

		return null;//damit Compiler happy
	}

	/**
	 * Holt Phase von H.
	 * 
	 * @return
	 */
	public double[] getPhase() {
		trace.methodeCall();

		return null;//damit Compiler happy
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
