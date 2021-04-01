package tools.dsp;

public class DSPFilter {
	public static final int FIR = 0, IIR = 1;
	protected double[] B, A, state_B, state_A;
	protected int nB, nA, indexB = 0, indexA = 0;
	private int filterType = -1;

	public DSPFilter(double[] B) {
		this.B = B;
		this.nB = B.length;
		filterType = FIR;
		state_B = new double[nB];
		for (int i = 0; i < nB; i++) {
			state_B[i] = 0.0f;
		}
	}

	public DSPFilter(double[] B, double[] A) {
		this.A = A;
		this.B = B;
		this.nB = B.length;
		this.nA = A.length;
		filterType = IIR;
		state_B = new double[nB];
		for (int i = 0; i < nB; i++) {
			state_B[i] = 0.0f;
		}
		state_A = new double[nA];
		for (int i = 0; i < nA; i++) {
			state_A[i] = 0.0f;
		}
	}

	public double filter(double input) {
		switch (filterType) {
		case FIR:
			return firFilter(input);
		case IIR:
			return iirFilter(input);
		default:
			return 0.0;
		}
	}

	public double[] filter(double[] input) {
		switch (filterType) {
		case FIR:
			return firFilter(input);
		case IIR:
			return iirFilter(input);
		default:
			return null;
		}
	}

	private double firFilter(double input) {
		state_B[indexB] = input;
		double sum = 0.0f;
		for (int i = 0; i < nB; i++) {
			sum += state_B[(indexB + i) % nB] * B[i];
		}
		indexB = (indexB + nB - 1) % nB;
		return sum;
	}

	private double[] firFilter(double[] input) {
		double[] output = new double[input.length];
		for (int i = 0; i < output.length; i++) {
			output[i] = firFilter(input[i]);
		}
		return output;
	}

	private double iirFilter(double input) {
		state_B[indexB] = input;
		double sum = 0.0f;
		for (int i = 0; i < nB; i++) {
			sum += state_B[(indexB + i) % nB] * B[i];
		}
		indexB = (indexB + nB - 1) % nB;
		indexA = (indexA + nA - 1) % nA;
		for (int i = 1; i < nA; i++) {
			sum -= state_A[(indexA + i) % nA] * A[i];
		}
		state_A[indexA] = sum;
		return sum;
	}

	private double[] iirFilter(double[] input) {
		double[] output = new double[input.length];
		for (int i = 0; i < output.length; i++) {
			output[i] = iirFilter(input[i]);
		}
		return output;
	}
}
