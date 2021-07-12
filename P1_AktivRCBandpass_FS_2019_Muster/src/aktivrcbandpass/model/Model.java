// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
// Modulanlass:

package aktivrcbandpass.model;

import util.Observable;
import util.TraceV7;

public class Model extends Observable {
	private TraceV7 trace = new TraceV7(this);
	// 11

	public static int F = 0, Q = 1, R = 2, C = 3;
	private Complex[] H = new Complex[0];
	private double[] fAchse;
	// Default - Values
	private double q = 10.0;
	private double fr = 1e4;
	private double c = 1e-12;
	private double r = 1.591549431E7;

	/**
	 * Konstruktor der Klasse Model.
	 * 
	 * <pre>
	 * - Erzeugt mittels linspace() von PicoMatlab die Frequenzachse mit Bereich von 0 bis 20kHz und 1024 Punkten.
	 * </pre>
	 */
	public Model() {
		trace.constructorCall();
		// 1
		fAchse = PicoMatlab.linspace(0.0, 20e3, 1024);
	}

	/**
	 * <pre>
	 * - Setzt das entsprechende Attribut.
	 * - Berechnet die Resonanzfrequenz fr neu.
	 * </pre>
	 * 
	 * @param r
	 */
	public void setR(double r) {
		trace.methodeCall();
		// 2
		this.r = r;
		fr = 1.0 / (2.0 * Math.PI * c * r);
	}

	/**
	 * <pre>
	 * - Setzt das entsprechende Attribut.
	 * - Berechnet den Wert des Widerstandes r neu.
	 * </pre>
	 * 
	 * @param fr
	 */
	public void setFr(double fr) {
		trace.methodeCall();
		// 2
		this.fr = fr;
		r = 1.0 / (2.0 * Math.PI * fr * c);
	}

	/**
	 * <pre>
	 * - Setzt das entsprechende Attribut.
	 * - Berechnet den Wert des Widerstandes r neu.
	 * </pre>
	 * 
	 * @param c
	 */
	public void setC(double c) {
		trace.methodeCall();
		// 2
		this.c = c;
		r = 1.0 / (2.0 * Math.PI * fr * c);
	}

	/**
	 * <pre>
	 * - Berechnet und baut einen Array b mit den entsprechenden Werten.
	 * - Berechnet und baut einen Array a mit den entsprechenden Werten.
	 * - Berechnet mittels freqs() der Klasse PicoMatlab aufgrund von b, a und fAchse den Frequenzgang H.
	 * - Notifiziert die Beobachter.
	 * </pre>
	 * 
	 */
	public void berechne() {
		trace.methodeCall();
		// 4

		double[] b = { (r * c * (3 - 1 / q)), 0.0 };
		double[] a = { Math.pow(r * c, 2.0), r * c / q, 1 };
		H = PicoMatlab.freqs(b, a, fAchse);
		notifyObservers();
	}

	public void setQ(double q) {
		trace.methodeCall();
		this.q = q;
	}

	public double[] getFAchse() {
		trace.methodeCall();
		return fAchse;
	}

	public double[] getAmplitude() {
		trace.methodeCall();
		return Complex.abs(H);
	}

	public double[] getPhase() {
		trace.methodeCall();
		return Complex.angle(H);
	}

	public double[] getParameter() {
		trace.methodeCall();
		return new double[] { fr, q, r, c };
	}

	public void notifyObservers() {
		trace.methodeCall();
		setChanged();
		super.notifyObservers();
	}
}

//new SwingWorker() {
//	@Override
//	protected Object doInBackground() throws Exception {
//		while (true) {
//			try {
//				Thread.sleep(50);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			double rm = r * (1 + 2 * p * (Math.random() - .5));
//			double cm = c * (1 + 2 * p * (Math.random() - .5));
//			double qm = q * (1 + 2 * p * (Math.random() - .5));
//
//			double[] b = { (rm * cm * (3 - 1 / qm)), 0.0 };
//			double[] a = { Math.pow(rm * cm, 2.0), rm * cm / qm, 1 };
//			H = PicoMatlab.freqs(b, a, fAchse);
//			notifyObservers();
//		}
//	}
//}.execute();
