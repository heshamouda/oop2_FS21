// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: Muster
// Vorname:
//

public class FilterFactory {
	// 21

	/**
	 * <pre>
	 * [filter] = BUTTER(N,Wn,'s'), design an Nth order lowpass analog Butterworth filters.
	 * 
	 * - Gemäss Algorithmus in der Aufgabenstellung.
	 *  
	 * </pre>
	 *
	 * @param 	N		Order
	 * @param 	Wg		Cut-off-frequency in rad/s
	 * @return 			Filter - Object
	 */
	public static Filter createButter(int N, double Wg) {
		// 7
		Complex[] p = new Complex[N];

		// n = 0:N-1;
		// p = exp(j*(n*pi/N + pi/2*(1+1/N)))*Wg;
		for (int n = 0; n < p.length; n++) {
			p[n] = new Complex(0.0, (n * Math.PI / N + Math.PI / 2.0 * (1.0 + 1.0 / N))).exp().mul(Wg);
		}

		// A = real(poly(p));
		double[] A = MicroMatlab.real(MicroMatlab.poly(p));
		// B = A(N+1);
		double[] B = new double[] { A[A.length - 1] };

		return new Filter(B, A, new Complex[] {}, p);
	}

	/**
	 * <pre>
	 * [filter] = CHEBY1(N,R,Wp,'s') designs an Nth order lowpass analog Chebyshev filter 
	 * with R decibels of peak-to-peak ripple in the passband.
	 * 
	 * - Gemäss Algorithmus in der Aufgabenstellung.
	 * 
	 * </pre>
	 * 
	 * @param N		Order
	 * @param R		Ripple in dB
	 * @param Wg	Cut-off-frequency in rad/s.
	 * @return		Filter - Object
	 */
	public static Filter createCheby1(int N, double R, double Wg) {
		// 14
		Complex[] p = new Complex[N];

		//	eps = sqrt(10^(R/10)-1.0);
		double eps = Math.sqrt(Math.pow(10.0, R / 10.0) - 1.0);
		//	sre = sinh((1.0/N)*asinh(1.0/eps));
		double sre = Math.sinh((1.0 / N) * MicroMatlab.asinh(1.0 / eps));
		//	sim = cosh((1.0/N)*asinh(1.0/eps));
		double sim = Math.cosh((1.0 / N) * MicroMatlab.asinh(1.0 / eps));

		//	n = 0:N-1;
		//	p = exp(j*(n*pi/N + pi/2*(1+1/N)))*Wg;
		//	p = (sre*real(p) + j*sim*imag(p));
		for (int n = 0; n < p.length; n++) {
			p[n] = new Complex(0.0, (n * Math.PI / N + Math.PI / 2.0 * (1.0 + 1.0 / N))).exp().mul(Wg);
			p[n] = new Complex(sre * p[n].re, sim * p[n].im);
		}

		// A = real(poly(p));
		double[] A = MicroMatlab.real(MicroMatlab.poly(p));
		// B = A(N+1);
		double[] B;
		if (N % 2 == 0)
			// B = A(N+1) * sqrt(10^(-R/10.0));
			B = new double[] { A[A.length - 1] * Math.sqrt(Math.pow(10.0, -R / 10.0)) };
		else
			// B = A(N+1);
			B = new double[] { A[A.length - 1] };

		return new Filter(B, A, new Complex[] {}, p);
	}
}
