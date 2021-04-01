package inversmodel.model;

import org.apache.commons.math3.complex.Complex;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.

//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: 
//Vorname:

public class PicoMatlab {

	public static final Complex[] freqz(double[] B, double[] A, int N, double fs) {
		// 7
		Complex[] H = new Complex[N];

		for (int k = 0; k < H.length; k++) {
			Complex jw = new Complex(0, 2.0 * Math.PI * k * fs / (2 * N));
			Complex zaehler = polyvalZ(B, jw.exp());
			Complex nenner = polyvalZ(A, jw.exp());
			H[k] = zaehler.divide(nenner);
		}
		return H;
	}

	public static final Complex polyvalZ(double[] p, Complex x) {
		// 4
		Complex val = new Complex(0, 0);
		for (int i = 0; i < p.length; i++) {
			val = x.pow(i).multiply(p[i]).add(val);
		}
		return val;
	}

}
