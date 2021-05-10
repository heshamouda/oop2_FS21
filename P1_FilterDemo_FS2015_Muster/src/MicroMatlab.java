// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
//

public class MicroMatlab {

	public static double acosh(double x) {
		return Math.log(x + Math.sqrt(x * x - 1.0));
	}

	public static double asinh(double x) {
		return Math.log(x + Math.sqrt(x * x + 1.0));
	}

	public static double atanh(double x) {
		return 0.5 * Math.log((x + 1.0) / (x - 1.0));
	}

	public static final Complex[] conv(Complex[] a, Complex[] b) {
		Complex[] res = new Complex[a.length + b.length - 1];

		for (int n = 0; n < res.length; n++) {
			res[n] = new Complex(0, 0);
			for (int i = Math.max(0, n - a.length + 1); i <= Math.min(b.length - 1, n); i++) {
				res[n] = res[n].add(b[i].mul(a[n - i]));
			}

		}
		return res;
	}

	/**
	 * Berechnet den Frequenzgang aufgrund von Zähler- und Nennerpolynom b resp.
	 * a sowie der Frequenzachse f.
	 * 
	 * @param b
	 *            Zählerpolynom
	 * @param a
	 *            Nennerpolynom
	 * @param f
	 *            Frequenzachse
	 * @return Komplexwertiger Frequenzgang.
	 */
	public static final Complex[] freqs(double[] b, double[] a, double[] f) {
		Complex[] res = new Complex[f.length];

		for (int k = 0; k < res.length; k++) {
			Complex jw = new Complex(0, 2.0 * Math.PI * f[k]);

			Complex zaehler = new Complex(0, 0);
			for (int i = 0; i < b.length; i++) {
				zaehler = zaehler.add(Complex.pow(jw, b.length - i - 1).mul(b[i]));
			}

			Complex nenner = new Complex(0, 0);
			for (int i = 0; i < a.length; i++) {
				nenner = nenner.add(Complex.pow(jw, a.length - i - 1).mul(a[i]));
			}
			res[k] = zaehler.div(nenner);
		}
		return res;
	}

	public static double[] linspace(double begin, double end, int n) {
		double step =  (int) Math.floor((end - begin)/ (n-1));
		double[] res = new double[n];
		for (int i = 0; i < res.length; i++) {
			res[i] = begin + i * step;
		}
		return res;
	}

	public static final Complex[] poly(Complex[] v) {
		Complex[] c = { new Complex(1.0, 0.0), v[0].negate() };

		for (int i = 1; i < v.length; i++) {
			c = conv(c, new Complex[] { new Complex(1.0, 0.0), v[i].negate() });
		}

		return c;
	}

	public static double[] real(Complex[] c) {
		double[] res = new double[c.length];

		for (int i = 0; i < res.length; i++) {
			res[i] = c[i].re;
		}

		return res;
	}

}
