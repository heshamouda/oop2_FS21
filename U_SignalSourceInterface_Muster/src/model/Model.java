package model;

import util.Observable;
import util.TraceV5;

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

		signalSource = new SignalSource(this);
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
		signalSource.generateSignal(varianz);
	}

	/**
	 * <pre>
	 * - berechnet die Filterkonstante aufsteigend mit dem slValue zu 0.3, 0.6 und 0.8
	 * </pre>
	 */
	public void calcFilterConstant(int slValue) {

		switch (slValue) {
		case 1:
			filtConst = 0.3;
			break;
		case 2:
			filtConst = 0.6;
			break;
		case 3:
			filtConst = 0.8;
			break;
		default:
			filtConst = 0.8;
		}

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
		double max = 0.0;
		double min = 0.0;
		meanPower = 0;

		signal = data;
		filteredSignal = new double[data.length];

		for (int n = 0; n < data.length; n++) {
			if (data[n] > max) {
				max = data[n];
			}
			if (data[n] < min) {
				min = data[n];
			}

			meanPower += 1.0 / data.length * Math.pow(data[n], 2.0);
		}

		maxValue = max;
		minValue = min;

		filteredSignal[0] = data[0];
		for (int n = 1; n < data.length; n++) {
			filteredSignal[n] = filtConst * filteredSignal[n - 1] + (1 - filtConst) * data[n];

		}

		notifyObservers();

	}

	/**
	 * <pre>
	 * - fuehrt die noetigen Schritte zum Benachrichtigen der Observer aus
	 * </pre>
	 */
	public void notifyObservers() {

		setChanged();
		super.notifyObservers();
	}

}