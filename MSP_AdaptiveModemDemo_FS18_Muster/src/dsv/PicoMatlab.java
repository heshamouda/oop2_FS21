package dsv;

import org.apache.commons.math3.complex.Complex;

public class PicoMatlab {

	// [H,F] = FREQZ(B,A,N,Fs) and [H,F] = FREQZ(B,A,N,'whole',Fs) return
	// frequency vector F (in Hz), where Fs is the sampling frequency (in Hz).

	public static final Complex[] freqz(double[] b, double[] a, int n, double fs) {
		Complex[] res = new Complex[n];

		for (int k = 0; k < res.length; k++) {
			Complex jw = new Complex(0, 2.0 * Math.PI * k * fs / (2 * n));
			Complex zaehler = polyvalZ(b, jw.exp());
			Complex nenner = polyvalZ(a, jw.exp());
			res[k] = zaehler.divide(nenner);
		}
		return res;
	}

	public static final Complex polyvalZ(double[] p, Complex x) {
		Complex val = new Complex(0, 0);
		for (int i = 0; i < p.length; i++) {
			val = x.pow(i).multiply(p[i]).add(val);
		}
		return val;
	}

	public static void main(String[] args) {
//		double[] f = { 0.01, 1.0, 2.0 };
		double[] b = { 3.0, 2.0, 1.0 };
		double[] a = { 1.0, 2.0 };

		Complex[] H = freqz(b, a, 4, 1.0);

		for (int i = 0; i < H.length; i++) {
			System.out.println("Re: " + H[i].getReal() + " Im: " + H[i].getImaginary());
		}
	}
}
//
// Re: 1.9999999999868405 Im: -2.7561322726271032E-17
// Re: 1.7974301716318053 Im: -0.052912303650383276
// Re: 1.199997821827199 Im: -0.400001507966123
// Re: -0.03272642271200249 Im: -1.1117349962712744
