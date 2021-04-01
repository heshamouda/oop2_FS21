package modem.model;

import java.util.Observable;
import java.util.Random;

import dsv.Delay;
import dsv.FIRFilter;
import dsv.LMSFilter;
import dsv.Matlab;
import modem.model.communication.Kanal;
import modem.model.communication.TxFlt;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: 
//Vorname:

public class Model extends Observable implements SymbolListener {
	// 33
	public Delay delay;
	private FIRFilter transmitFilter;
	private FIRFilter kanalFilter;
	private LMSFilter ffFilter;
	private LMSFilter fbFilter;

	protected SymbolQuelle symbolSource = new SymbolQuelle(16 * 1024, this);
	private double[] fAxis = new double[1024];
	private double[] tAxis = new double[512];

	private Random random = new Random();

	private double schrittFF = 1e-5, schrittFB = 1e-4, fbOut = 0.0;
	private double tonFrequenz = 5e6;
	private double fb = 50e6, fs = 2 * fb, Ts = 1 / fs;
	private long n = 0;

	private double awgnAmplitude = 0.0;
	private double tonAmplitude = 0.0;

	/**
	 * <pre>
	 * - Erzeugt mit den Argumenten (16 * 1024, this) die SymbolQuelle.
	 * - Erzeugt die Verzögerungsleitung delay mit einer Verzögerung von 32.
	 * - Erzeugt das Transmit-Filter und das Kanal-Filter mit den Koeffizienten
	 *   TxFlt.TxFltBCoeffs und Kanal.BCoeffs[0].
	 * - Erzeugt die adaptiven LMS-Filter ffFilter und fbFilter mit den Längen 64 und 16. 
	 * - Erzeugt mittels linspace() von Matlab die fAxis und die tAxis entsprechender 
	 *   Längen und den Bereichen von Null bis fs/2 resp. von 0 bis Länge der tAxis minus 1.
	 * </pre>
	 */
	public Model() {
		// 8
	}

	public double[] getfAxis() {
		return fAxis;
	}

	public double[] getImpulsFBFilter() {
		return fbFilter.getCoeffs();
	}

	public double[] getImpulsFFFilter() {
		return ffFilter.getCoeffs();
	}

	public double[] getImpulsKanalFilter() {
		return kanalFilter.getCoeffs();
	}

	public double[] getImpulsTransmitFilter() {
		return transmitFilter.getCoeffs();
	}

	public double[] gettAxis() {
		return tAxis;
	}

	@Override
	/**
	 * <pre>
	 * - Für k gleich 0 bis kleiner der Länge von symbol:
	 *   - k-tes Symbol gemäß Aufgabenstellung verarbeiten.
	 * </pre>
	 */
	public void processSymbol(double[] symbol) {
		// 17
		double x1, x2, n1, n2, ffOut, dSym, error;

	}

	/**
	 * <pre>
	 * - Erzeugt ein neues ffFilter und fbFilter ursprünglicher Länge
	 * </pre>
	 */
	public void resetFilter() {
		// 2
	}

	/**
	 * <pre>
	 * - Erzeugt ein neues Kanal-Filter mit entsprechenden Kanal.BCoeffs[Index] Koeffizienten. 
	 * - Setzt die Attribute entsprechend den Werten im Objekt parameter.
	 * </pre>
	 * 
	 * @param parameter
	 */
	public void setParameter(Parameter parameter) {
		// 6
	}

	@Override
	public void notifyObservers() {
		setChanged();
		super.notifyObservers();
	}
}
