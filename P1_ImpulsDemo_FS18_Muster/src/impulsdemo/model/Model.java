package impulsdemo.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.Timer;

import org.apache.commons.math3.complex.Complex;

import impulsdemo.TraceV2;
import impulsdemo.model.goodies.Matlab;
import impulsdemo.model.goodies.Residue;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: Muster
//Vorname:

public class Model extends Observable implements ActionListener {
	// 43
	private TraceV2 tr = new TraceV2(this);

	public static final String LHE = "LHE", JW = "JW", RHE = "RHE";

	private long n = 0;
	private double T = 0.25;
	private Timer timer;

	private Complex[] drehZeiger;
	private Complex[] R, P;

	private boolean angehalten = false;

	private double[] B = { 0, 0.102631578947368, 0 };
	private double[] A_LHE = { 1.0, 0.102631578947368, 1.0 };
	private double[] A_JW = { 1.0, 0, 0.997366689750692 };
	private double[] A_RHE = { 1.0, -0.102631578947368, 1.0 };

	/**
	 * <pre>
	 * - Baut einen Timer mit Intervall 40 ms und this als ActionListener.
	 * - Startet den Timer.
	 * </pre>
	 */
	public Model() {
		// 2
		tr.constructorCall();
		timer = new Timer(40, this);
		timer.start();
	}

	/**
	 * <pre>
	 * - Falls NICHT angehalten:
	 *   - processing() aufrufen.
	 *   - n inkrementieren.
	 * </pre>
	 */
	public void actionPerformed(ActionEvent e) {
		// 3
		if (!angehalten) {
			tr.eventCall();
			processing();
			n++;
		}
	}

	/**
	 * <pre>
	 * - Sortiert die komplexwertigen Pole im Attribut P in aufsteigender Reihenfolge so, 
	 *   dass an der Stelle [0] der kleinste Imaginärteil zu liegen kommt.
	 * - Werden P[i+1] und P[i] getauscht, so werden auch die zugehörigen Residuen im 
	 *   Attribut R[i+1] und R[i] getauscht!
	 * </pre>
	 */
	public void bubbleSort() {
		// 13
		tr.methodeCall();
		boolean getauscht;
		do {
			getauscht = false;
			for (int i = 0; i < P.length - 1; i++) {
				if (P[i + 1].getImaginary() < P[i].getImaginary()) {
					Complex tmp = P[i + 1];
					P[i + 1] = P[i];
					P[i] = tmp;
					tmp = R[i + 1];
					R[i + 1] = R[i];
					R[i] = tmp;
					getauscht = true;
				}
			}
		} while (getauscht);

	}

	public Complex[] getDrehZeiger() {
		tr.methodeCall();
		return drehZeiger;
	}

	public boolean isAngehalten() {
		tr.methodeCall();
		return angehalten;
	}

	@Override
	public void notifyObservers() {
		tr.methodeCall();
		setChanged();
		super.notifyObservers();
	}

	/**
	 * <pre>
	 * - Berechnet alle Drehzeiger gemäss Aufgabenstellung.
	 * - Notifiziert die Observer.
	 * </pre>
	 */
	public void processing() {
		// 3
		tr.methodeCall();
		for (int m = 0; m < R.length; m++) {
			drehZeiger[m] = P[m].multiply(n * T).exp().multiply(R[m]);
		}

		if (n == 250)
			n = 0;
		notifyObservers();
	}

	/**
	 * <pre>
	 * - Setzt n gleich Null.
	 * - Setzt das Attribut angehalten auf wahr.
	 * - Erzeugt einen neuen drehZeiger-Array mit der Länge von R.
	 * - Ruft die Methode processing auf.
	 * </pre>
	 */
	public void reset() {
		// 4
		tr.methodeCall();
		n = 0;
		angehalten = true;
		drehZeiger = new Complex[R.length];
		processing();
	}

	/**
	 * <pre>
	 * - switch (systemType)
	 *   - Fall LHE: 
	 *     - Methode setUTF() mit Argumenten B und A_LHE aufrufen.
	 *   - Fall JW und RHE sinngemäss.
	 * </pre>
	 * 
	 * @param systemType
	 */
	public void setSystemType(String systemType) {
		// 10
		tr.methodeCall();
		switch (systemType) {
		case LHE:
			setUTF(B, A_LHE);
			break;
		case JW:
			setUTF(B, A_JW);
			break;
		case RHE:
			setUTF(B, A_RHE);
			break;
		}
	}

	/**
	 * <pre>
	 * - Mit den Argumenten B,A ein neues Objekt der Klasse Residue erzeugen. 
	 *   Das Objekt enthält nun die komplexwertigen Residuen R, die zugehörigen Pole P 
	 *   sowie den konstanten Term K.
	 * - Falls die Länge von R gerade ist:
	 *   Mittels der Matlab-Methode concat(Complex[] a, Complex[] b) eine 
	 *   komplexe Null an residue.R und residue.P anhängen und in den Attributten
	 *   R und P ablegen. Hinweis: 'concationate' heisst 'zusammenfügen'!
	 * - Sonst:
	 *   - residue.R und residue.P direkt in den Attributten R und P ablegen.
	 * - bubbleSort() aufrufen.
	 * - reset() aufrufen.
	 * </pre>
	 * 
	 * @param B
	 * @param A
	 */
	public void setUTF(double[] B, double[] A) {
		// 9
		tr.methodeCall();
		Residue residue = new Residue(B, A);
		if (residue.R.length % 2 == 0) {
			R = Matlab.concat(residue.R, new Complex(0.0));
			P = Matlab.concat(residue.P, new Complex(0.0));
		} else {
			R = residue.R;
			P = residue.P;
		}
		bubbleSort();
		reset();
	}

	public void start() {
		tr.methodeCall();
		angehalten = false;
	}
}
