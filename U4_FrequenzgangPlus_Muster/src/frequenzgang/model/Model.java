package frequenzgang.model;

import util.Observable;
import util.TraceV8;

public class Model extends Observable {
	private TraceV8 trace = new TraceV8(this);
	private Complex[] H = new Complex[0];
	private double[] faxis = new double[0];
	private RationalFunction rationalFunction = new RationalFunction(new Polynom(), new Polynom());

	/**
	 * Konstruiert Model mit Frequenzgang und Frequenzachse.
	 * 
	 * @param fStart Startfrequenz des Frequenzganges
	 * @param fStop  Stoppfrequenz des Frequenzganges
	 * @param n      Anzahl Datenpunkte
	 */
	public Model(double fStart, double fStop, int n) {
		trace.constructorCall();
		faxis = new double[n];
		for (int i = 0; i < faxis.length; i++) {
			faxis[i] = fStart + i * (fStop - fStart) / (n - 1);
		}
	}

	/**
	 * Setzt ?bertragungsfunktion, gegeben durch Z?hler- und Nennerpolynom der rationalen Funktion.
	 * Berechnet direkt den zugeh?rigen Frequenzgang mittels freqs() der rationalen Funktion und
	 * der Frequenzachse faxis des Models. Benachrichtigt Observers.
	 * 
	 * @param zaehler Zaehlerpolynom
	 * @param nenner  Nennerpolynom
	 */
	public void setUTF(double[] zaehler, double[] nenner) {
		trace.methodeCall();

		rationalFunction.setPolynoms(new Polynom(zaehler), new Polynom(nenner));
		H = rationalFunction.freqs(faxis);
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
		return Complex.abs(H);
	}

	/**
	 * Holt Phase von H.
	 * 
	 * @return
	 */
	public double[] getPhase() {
		trace.methodeCall();
		return Complex.angle(H);
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
