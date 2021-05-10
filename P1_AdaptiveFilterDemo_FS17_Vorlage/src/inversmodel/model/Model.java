package inversmodel.model;

import java.util.Observable;

import org.apache.commons.math3.complex.Complex;

import dsv.Delay;
import dsv.IIRFilter;
import dsv.LMSFilter;
import dsv.Matlab;
import dsv.PicoMatlab;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: 
//Vorname:

public class Model extends Observable implements SignalListener {
	// 27
	private Delay verzoegerung;
	private LMSFilter equalizerFilter;
	private IIRFilter streckenFilter;
	private SignalQuelle signalQuelle;
	private double schrittWeite;
	private double[] impulsStrecke;
	private boolean schrittOn = true;
	private double[] fAxis = new double[512];
	private double[] tAxis = new double[128];

	/**
	 * Baut ein Model zur Visualisierung der inversen Systemmodellierung ...
	 * 
	 * <pre>
	 * - Instanziiert den Delay mit einer Verzögerung  der Länge von tAxis dividiert durch 2.
	 * - Instanziiert das Equalizer - Filter als LMSFilter der Länge von tAxis.
	 * - Instanziiert das Strecken-Filter als IIRFilter mit den Parametern Strecke.B, Strecke.A.
	 * - Instanziiert die Signalquelle mit den Parametern (40000, 8192, this).
	 * - Berechnet mittels Matlab.impz() die Impulsantwort der Strecke
	 * - Erzeugt mittel linspace() der Klasse Matlab die Frequenzachse fAxis mit Bereich 0.0 bis 20e3.
	 * - Erzeugt mittel linspace() der Klasse Matlab die Zeitachse tAxis mit Bereich 0.0 bis tAxis.length * 1000.0/40e3.
	 * </pre>
	 */
	public Model() {
		// 7
	}

	/**
	 * <pre>
	 * - Berechnet mittels freqz() von PicoMatlab, aufgrund der Koeffizienten des Equalizer-Filter 
	 *   und einem Array der Länge 1 mit dem Datum 1.0, den komplexwertigen Frequenzgang H der 
	 *   Länge von fAxis mit fs gleich 1.0;
	 * - Berechnet mittels abs() von Matlab den Betrag über alle Elemente in H, darauf basierend 
	 *   mittels log10() von Matlab den Logarithmus und mittels multiply von Matlab das 20 fache davon.
	 * - Gibt das so berechnete Resultat zurück.
	 * </pre>
	 * 
	 * @return
	 */
	public double[] getAmplitudengangEqualizer() {
		// 2
		return null;
	}

	/**
	 * <pre>
	 * - Berechnet mittels freqz() von PicoMatlab den Amplitudengang H_irr aufgrund von B und A der Strecke.
	 * - Berechnet mittels freqz() von PicoMatlab den Amplitudengang H_fir aufgrund der Koeffizienten des Equalizer-Filter 
	 *   und einem Array der Länge 1 mit dem Datum 1.0.
	 * - Berechnet mittels elementWise() von Matlab die elementweise Multiplikation von H_iir mit H_fir und damit den 
	 *   Frequenzgang H der Gesamtstrecke.   
	 * - Berechnet mittels abs() von Matlab den Betrag über alle Elemente in H, darauf basierend 
	 *   mittels log10() von Matlab den Logarithmus und mittels multiply() von Matlab das 20 fache davon.
	 * - Gibt das so berechnete Resultat zurück.
	 * </pre>
	 * 
	 * @return
	 */
	public double[] getAmplitudengangGesamtStrecke() {
		// 4
		return null;
	}

	/**
	 * <pre>
	 * - Berechnet mittels freqz() von PicoMatlab den Amplitudengang H_irr aufgrund von B und A der Strecke.
	 * - Berechnet mittels abs() von Matlab den Betrag über alle Elemente in H_irr, darauf basierend 
	 *   mittels log10() von Matlab den Logarithmus und mittels multiply() von Matlab das 20 fache davon.
	 * - Gibt das so berechnete Resultat zurück.
	 * </pre>
	 * 
	 * @return
	 */
	public double[] getAmplitudengangStrecke() {
		// 2
		return null;
	}

	@Override
	/**
	 * Führt die Verarbeitung der Signalwerte aus der Signalquelle durch ...
	 * 
	 * <pre>
	 * - Für alle Signalwerte, beginnend mit dem 0-ten:
	 *   - Werte gemäss Blockdiagramm in der Aufgabenstellung verarbeiten. 
	 *   - Falls schrittOn
	 *       - Equalizer - Filter mittels Methode lms() adaptieren.
	 * - Beobachter benachrichtigen.
	 * </pre>
	 */
	public void processSignal(double[] signal) {
		// 8
	}

	/**
	 * Setzt das Filter zurück ...
	 * 
	 * <pre>
	 * - Neues adaptives LMSFilter der Länge von tAxis erzeugen.
	 * </pre>
	 */
	public void resetFilter() {
		// 1
	}

	/**
	 * Setzt die Parameter ...
	 * 
	 * <pre>
	 * - Setzt das entsprechende Attribut und ruft entsprechende Methoden der Signalquelle auf.
	 * </pre>
	 * 
	 * @param rechteckPegel
	 * @param rauschPegel
	 * @param schritttWeite
	 */
	public void setParameter(double rechteckPegel, double rauschPegel, double schritttWeite) {
		// 3
	}

	public double[] getfAxis() {
		return fAxis;
	}

	public double[] getImpulsEqualizer() {
		return equalizerFilter.getCoeffs();
	}

	public double[] getImpulsGesamtStrecke() {
		return Matlab.conv(impulsStrecke, equalizerFilter.B);
	}

	public double[] getImpulsStrecke() {
		return impulsStrecke;
	}

	public double[] gettAxis() {
		return tAxis;
	}

	public void setSchrittOn(boolean schrittOn) {
		this.schrittOn = schrittOn;
	}

	public void startSignalQuelle() {
		signalQuelle.start();
	}

	@Override
	public void notifyObservers() {
		setChanged();
		super.notifyObservers();
	}

}