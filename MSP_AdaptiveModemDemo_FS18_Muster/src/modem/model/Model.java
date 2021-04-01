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
	 * - Erzeugt mit den Argumenten (16 * 1024, this) die SymbolSource.
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
		symbolSource = new SymbolQuelle(16 * 1024, this);

		delay = new Delay(32);

		transmitFilter = new FIRFilter(TxFlt.TxFltBCoeffs);
		kanalFilter = new FIRFilter(Kanal.BCoeffs[0]);
		ffFilter = new LMSFilter(64);
		fbFilter = new LMSFilter(16);

		fAxis = Matlab.linspace(0.0, fs / 2.0, fAxis.length);
		tAxis = Matlab.linspace(0.0, tAxis.length - 1, tAxis.length);
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

		for (int k = 0; k < symbol.length; k++) {

			dSym = delay.delay(symbol[k]);

			// Upsampling:
			// Aus symbol[k] zwei Abtastwerte x1 gleich symbol[k] und x2 gleich 0.0
			// erzeugen.
			x1 = symbol[k];
			x2 = 0.0;

			// Transmit - Filter
			// Zuerst x1 mittels Methode filter() des transmitFilter filtern und Resultat
			// wiederum in x1 schreiben. In geicher Art x2 filtern.
			x1 = transmitFilter.filter(x1);
			x2 = transmitFilter.filter(x2);

			// Filter
			x1 = kanalFilter.filter(x1);
			x2 = kanalFilter.filter(x2);

			// Rauschen
			n1 = tonAmplitude * Math.sin(2 * Math.PI * tonFrequenz * n++ * Ts) + awgnAmplitude * random.nextGaussian();
			n2 = tonAmplitude * Math.sin(2 * Math.PI * tonFrequenz * n++ * Ts) + awgnAmplitude * random.nextGaussian();

			// Additionsknoten
			x1 += n1;
			x2 += n2;

			// Filter
			x1 = ffFilter.filter((x1));
			x2 = ffFilter.filter((x2));

			// Downsampling
			ffOut = x2;

			// Fehler berechnen
			error = dSym - (ffOut + fbOut);

			// LMS - Algorithmus aufrufen
			ffFilter.lms(error, schrittFF);
			fbFilter.lms(error, schrittFB);

			// delayedSymbol mittels fbFilter filtern.
			fbOut = fbFilter.filter(dSym);
		}
	}

	/**
	 * <pre>
	 * - Erzeugt ein neues ffFilter und fbFilter ursprünglicher Länge
	 * </pre>
	 */
	public void resetFilter() {
		// 2
		ffFilter = new LMSFilter(ffFilter.getCoeffs().length);
		fbFilter = new LMSFilter(fbFilter.getCoeffs().length);
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
		kanalFilter = new FIRFilter(Kanal.BCoeffs[parameter.kanalIndex]);

		this.awgnAmplitude = parameter.awgnAmplitude;
		this.tonAmplitude = parameter.tonAmplitude;
		this.tonFrequenz = parameter.tonFrequenz;
		this.schrittFF = parameter.schrittFF;
		this.schrittFB = parameter.schrittFB;
	}

	@Override
	public void notifyObservers() {
		setChanged();
		super.notifyObservers();
	}
}
