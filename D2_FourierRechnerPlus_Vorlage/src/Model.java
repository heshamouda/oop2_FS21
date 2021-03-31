import util.Observable;
import util.TraceV8;

public class Model extends Observable {
	private TraceV8 trace = new TraceV8(this);
	private double[] signal;
	private double rms;
	private double peak;

	public Model() {
		trace.constructorCall();
	}

	private double[] berechnePulse(double amp, double freq, int nHarm, int N) {
		trace.methodeCall();
		double[] x = new double[N];
		double alpha = Math.PI / 3.0;

		for (int n = 0; n < N; n++) {
			for (int k = 1; k < nHarm + 2; k++) {
				x[n] += ((4 * amp) / Math.PI) * Math.cos(alpha * (2 * k - 1))
						* Math.sin(2.0 * Math.PI * (2 * k - 1) * freq * n / N) / (2 * k - 1);
			}
		}
		return x;
	}

	private double[] berechneTrapez(double amp, double freq, int nHarm, int N) {
		trace.methodeCall();
		double[] x = new double[N];
		double alpha = Math.PI / 3.0;

		for (int n = 0; n < N; n++) {
			for (int k = 1; k < nHarm + 2; k++) {
				x[n] += ((4 * amp) / Math.PI) * Math.sin(alpha * (2 * k - 1))
						* Math.sin(2.0 * Math.PI * (2 * k - 1) * freq * n / N) / Math.pow((2 * k - 1), 2.0);
			}
		}
		return x;
	}

	private double[] berechneRechteck(double amp, double freq, int nHarm, int N) {
		trace.methodeCall();
		double[] x = new double[N];

		for (int n = 0; n < x.length; n++) {
			for (int k = 1; k < nHarm + 1; k++) {
				x[n] += (4 * amp / Math.PI) * Math.sin(2 * Math.PI * freq * (2 * k - 1) * n / (N - 1)) / (2 * k - 1);
			}
		}
		return x;
	}

	private double[] berechneDreieck(double amp, double freq, int nHarm, int N) {
		trace.methodeCall();
		double[] x = new double[N];

		for (int n = 0; n < x.length; n++) {
			for (int k = 1; k < nHarm + 1; k++) {
				int m = 0;
				if (k % 2 == 0) {
					m = 1;
				} else {
					m = -1;
				}
				x[n] += m * ((8 * Math.PI) / Math.pow(Math.PI, 2.0) * amp / Math.PI)
						* Math.sin(2 * Math.PI * freq * (2 * k - 1) * n / N) / Math.pow((2 * k - 1), 2.0);
			}
		}

		return x;
	}

	private double[] berechneSaegezahn(double amp, double freq, int nHarm, int N) {
		trace.methodeCall();
		double[] x = new double[N];

		for (int n = 0; n < x.length; n++) {
			for (int k = 1; k < nHarm + 1; k++) {
				x[n] += (2 * amp / Math.PI) * Math.sin(2 * Math.PI * freq * k * n / N) / k * Math.pow(-1, k + 1);
			}
		}

		return x;
	}

	public void berechne(double amp, double freq, int nHarm, String form, int N) {
		trace.methodeCall();
		switch (form) {
		case "Rechteck":
			signal = berechneRechteck(amp, freq, nHarm, N);
			break;
		case "Dreiecke":
			signal = berechneDreieck(amp, freq, nHarm, N);
			break;
		case "Sägezahn":
			signal = berechneSaegezahn(amp, freq, nHarm, N);
			break;
		case "Trapez":
			signal = berechneTrapez(amp, freq, nHarm, N);
			break;
		case "Puls":
			signal = berechnePulse(amp, freq, nHarm, N);
			break;
		default:
			break;
		}
		peak = peak(signal);
		rms = rms(signal);
		notifyObservers();
	}

	private double rms(double[] signal) {
		trace.methodeCall();
		double ms = 0.0;

		for (int i = 0; i < signal.length; i++) {
			ms += Math.pow(signal[i], 2.0);
		}
		return Math.sqrt(ms / signal.length);
	}

	private double peak(double[] signal) {
		trace.methodeCall();
		double max = 0.0;

		for (int i = 0; i < signal.length; i++) {
			if (Math.abs(signal[i]) > max)
				max = Math.abs(signal[i]);
		}
		return max;
	}

	public double[] getSignal() {
		trace.methodeCall();
		return signal;
	}

	public void notifyObservers() {
		trace.methodeCall();
		setChanged();
		super.notifyObservers();
	}

	public double getPeak() {
		trace.methodeCall();
		return peak;
	}

	public double getRMS() {
		trace.methodeCall();
		return rms;
	}
}
