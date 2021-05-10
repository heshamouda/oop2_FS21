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
	 * -berechnet je nach Signalform das entsprechende Signal und  charakteristischen Groessen
	 * - notifiziert den Observer 
	 * @param amp
	 * @param freq
	 * @param nHarm
	 * @param form
	 * @param N
	 * </pre>
	 */
	public void berechne(double amp, double freq, int nHarm, String form, int N) {
		trace.methodeCall();
		switch (form) {
		case "Rechteck":
			signal = berechneRechteck(amp, freq, nHarm, N);
			break;
		case "Dreieck":
			signal = berechneDreieck(amp, freq, nHarm, N);
			break;
		case "Sägezahn":
			signal = berechneSaegezahn(amp, freq, nHarm, N);
			break;
		default:
			break;

		}

		peak = berechnePeak(signal);
		rms = berechneRms(signal);

		notifyObservers();

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

		for (int n = 0; n < N; n++) {
			for (int k = 1; k <= nHarm; k++) {

				y[n] += 4 * amp / Math.PI * Math.sin(2 * Math.PI * freq * (2 * k - 1) * n / (N - 1)) / (2 * k - 1);

			}
		}

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

		for (int n = 0; n < N; n++) {
			for (int k = 1; k <= nHarm; k++) {

				y[n] += 4 * amp / Math.PI * Math.pow(-1, k + 1)
						* Math.sin(2 * Math.PI * freq * (2 * k - 1) * n / (N - 1)) / Math.pow(2 * k - 1, 2);

			}
		}

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

		for (int n = 0; n < N; n++) {
			for (int k = 1; k <= nHarm; k++) {

				y[n] += 2 * amp / Math.PI * Math.pow(-1, k + 1) * Math.sin(2 * Math.PI * freq * k * n / (N - 1)) / k;

			}
		}

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
		for (int n = 0; n < signal.length; n++) {
			if (Math.abs(signal[n]) > max) {
				max = Math.abs(signal[n]);
			}
		}

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
		for (int n = 0; n < signal.length; n++) {
			rms += Math.pow(signal[n], 2.0);
		}
		rms = Math.sqrt(rms / signal.length);

		return rms;

	}

	/**
	 * - holt private attribut peak
	 * @return
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