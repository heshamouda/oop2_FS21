package dsv;

public class IIRFilter extends Filter {
	protected double[] state_B, state_A;
	protected int nB, nA, indexB = 0, indexA = 0;

	public IIRFilter(double[] B, double[] A) {
		super(B, A);
		this.nB = B.length;
		this.nA = A.length;
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

	public double[] filter(double[] input) {
		double[] output = new double[input.length];
		for (int i = 0; i < output.length; i++) {
			output[i] = filter(input[i]);
		}
		return output;
	}
}
