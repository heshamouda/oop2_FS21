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
			filtConst =0.6;
			break;
		case 3:
			filtConst = 0.8;
			break;

		default:
			filtConst = 0.8;
			break;
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
		meanPower = 0.0;
		
		signal = data;
		filteredSignal = new double[data.length];
		
		for (int i = 0; i < data.length; i++) {
			if (data [i] > max) {
				max = data[i];
				}
			if (data[i] < min) {
				min = data[i];
			}
			
			meanPower +=1.0/data.length * Math.pow(data[i], 2.0);
		}
		
		maxValue = max;
		minValue = min;		
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