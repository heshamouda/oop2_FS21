package model;

import util.Observable;

public class Model extends Observable implements DataListener {

	private SignalSource signalSource;
	private double maxValue = 0.0;
	private double minValue = 0.0;
	private double meanPower = 0.0;
	private double filtConst = 0.6;
	private double[] signal;
	private double[] filteredSignal;

	/**
	 * <pre>
	 * - erzeugt eine SignalSource mit dem Model als DatenlListener
	 * </pre>
	 */
	public Model() {

		
	}

	public double getMaxValue() {

		return maxValue;
	}

	public double getMinValue() {

		return minValue;
	}

	public double getMeanPower() {

		return meanPower;
	}

	public double[] getSignal() {

		return signal;
	}

	public double[] getFiltSignal() {

		return filteredSignal;
	}

	/**
	 * <pre>
	 * - triggert die Signalgenerierung innerhalb signalSource
	 * </pre>
	 */
	public void triggerSignalGenerator(double varianz) {
		
	}

	/**
	 * <pre>
	 * - berechnet die Filterkonstante aufsteigend mit dem slValue zu 0.3, 0.6 und 0.8
	 * </pre>
	 */
	public void calcFilterConstant(int slValue) {

		

	}

	/**
	 * <pre>
	 * - setzt signal
	 * - erzeugt filteredSignal mit Laenge von data
	 * - berechnet und setzt minValue, maxValue und meanPower des Signals
	 * - berechnet das gefilterte Signal
	 * </pre>
	 */
	@Override
	public void process(double[] data) {
		
	}

	/**
	 * <pre>
	 * - fuehrt die noetigen Schritte zum Benachrichtigen der Observer aus
	 * </pre>
	 */
	public void notifyObservers() {

		
	}

}