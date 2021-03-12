import util.Observable;
import util.TraceV4;

public class Model extends Observable {
	private TraceV4 trace = new TraceV4(this);
	private double[] signal;
	private double peak;
	private double rms;

	public Model() {
		trace.constructorCall();
	}

	/**
	 * <pre>
	 * -berechnet je nach Signlform das entsprechende Signal und charakteristischen Groessen 
	 * - meldet update dem Observer
	 * </pre>
	 * 
	 * @param amp
	 * @param freq
	 * @param nHarm
	 * @param form
	 * @param N
	 */
	public void berechne(double amp, double freq, int nHarm, String form, int N) {
		trace.methodeCall();

	}

	/**
	 * <pre>
	 * 	-Berechnet aufgrund der Parameter Rechtecksignal
	 * </pre>
	 * 
	 * @param amp
	 * @param freq
	 * @param nHarm
	 * @return
	 */
	private double[] berechneRechteck(double amp, double freq, int nHarm, int N) {
		trace.methodeCall();
		double[] y = new double[N];

		return y;
	}

	/**
	 * <pre>
	 * 	-Berechnet aufgrund der Parameter Dreiecksignal
	 * </pre>
	 * 
	 * @param amp
	 * @param freq
	 * @param nHarm
	 * @return
	 */
	private double[] berechneDreieck(double amp, double freq, int nHarm, int N) {
		trace.methodeCall();
		double[] y = new double[N];

		return y;
	}

	/**
	 * <pre>
	 * 	-Berechnet aufgrund der Parameter Saegezahnsignal
	 * </pre>
	 * 
	 * @param amp
	 * @param freq
	 * @param nHarm
	 * @return
	 */
	private double[] berechneSaegezahn(double amp, double freq, int nHarm, int N) {
		trace.methodeCall();
		double[] y = new double[N];

		return y;

	}

	/**
	 * -gibt betragsmässig grösste Signalamplitude zurück
	 * 
	 * @param signal
	 * @return
	 */
	private double berechnePeak(double[] signal) {
		double max = 0.0;

		return max;

	}

	/**
	 * - berechnet Effektivwert des Signals (RMS)
	 * 
	 * @param signal
	 * @return
	 */
	private double berechneRms(double[] signal) {
		double rms = 0.0;

		return rms;

	}

	/**
	 * - holt private attribut peak
	 */
	public double getPeak() {
		trace.methodeCall();
		return peak;
	}

	/**
	 * - holt private attribut rms
	 */
	public double getRms() {
		trace.methodeCall();
		return rms;
	}

	/**
	 * - holt private attribut signal
	 */
	public double[] getSignal() {
		trace.methodeCall();
		return signal;
	}

	
	public void notifyObservers() {
		trace.methodeCall();
		setChanged();
		super.notifyObservers();
	}
}