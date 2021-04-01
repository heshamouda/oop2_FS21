package impulsdemo.model.goodies;

import java.text.DecimalFormat;

import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math3.analysis.solvers.LaguerreSolver;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.transform.DftNormalization;
import org.apache.commons.math3.transform.FastFourierTransformer;
import org.apache.commons.math3.transform.TransformType;

//DIESE DATEI MUSS NICHT BEARBEITET WERDEN! SIE WIRD NICHT BEWERTET!

public class Matlab {
	static final FastFourierTransformer transformer = new FastFourierTransformer(DftNormalization.STANDARD);
	static final SplineInterpolator interpolator = new SplineInterpolator();

	public static final double[] colon(double[] a, int begin, int end) {
		double[] res = new double[end - begin + 1];

		for (int i = 0; i <= end - begin; i++) {
			res[i] = a[begin + i];
		}

		return res;
	}

	public static final Complex[] colon(Complex[] a, int begin, int end) {
		Complex[] res = new Complex[end - begin + 1];

		for (int i = 0; i <= end - begin; i++) {
			res[i] = new Complex(a[begin + i].getReal(), a[begin + i].getImaginary());
		}

		return res;
	}

	public static final Complex[] colonColon(Complex[] a, int begin, int step, int end) {
		Complex[] res = new Complex[Math.abs((end - begin) / step) + 1];

		for (int i = 0; i <= Math.abs((end - begin) / step); i++) {
			res[i] = new Complex(a[begin + i * step].getReal(), a[begin + i * step].getImaginary());
		}

		return res;
	}

	public static final double[] colonColon(double[] a, int begin, int step, int end) {
		double[] res = new double[Math.abs((end - begin) / step) + 1];

		for (int i = 0; i <= Math.abs((end - begin) / step); i++) {
			res[i] = a[begin + i * step];
		}

		return res;
	}

	public static final double[] c2d(Complex[] c) {
		double[] d = new double[c.length];

		for (int i = 0; i < d.length; i++) {
			d[i] = c[i].getReal();
		}

		return d;
	}

	public static final Complex[] concat(Complex[] a, Complex b) {
		Complex[] res = new Complex[a.length + 1];
		int k = 0;

		for (int i = 0; i < a.length; i++) {
			res[k++] = new Complex(a[i].getReal(), a[i].getImaginary());
		}
		res[k++] = new Complex(b.getReal(), b.getImaginary());

		return res;
	}

	public static final Complex[] concat(Complex[] a, Complex b, Complex[] c) {
		Complex[] res = new Complex[a.length + 1 + c.length];
		int k = 0;

		for (int i = 0; i < a.length; i++) {
			res[k++] = new Complex(a[i].getReal(), a[i].getImaginary());
		}
		res[k++] = new Complex(b.getReal(), b.getImaginary());
		for (int i = 0; i < c.length; i++) {
			res[k++] = new Complex(c[i].getReal(), c[i].getImaginary());
		}

		return res;
	}

	public static final Complex[] concat(Complex[] a, Complex[] b) {
		Complex[] res = new Complex[a.length + b.length];
		int k = 0;

		for (int i = 0; i < a.length; i++) {
			res[k++] = new Complex(a[i].getReal(), a[i].getImaginary());
		}
		for (int i = 0; i < b.length; i++) {
			res[k++] = new Complex(b[i].getReal(), b[i].getImaginary());
		}

		return res;
	}

	public static final double[] concat(double[] a, double b) {
		double[] res = new double[a.length + 1];
		int k = 0;

		for (int i = 0; i < a.length; i++) {
			res[k++] = a[i];
		}
		res[k++] = b;

		return res;
	}

	public static final double[] concat(double[] a, double b, double[] c) {
		double[] res = new double[a.length + 1 + c.length];
		int k = 0;

		for (int i = 0; i < a.length; i++) {
			res[k++] = a[i];
		}
		res[k++] = b;
		for (int i = 0; i < c.length; i++) {
			res[k++] = c[i];
		}

		return res;
	}

	public static final double[] concat(double[] a, double[] b) {
		double[] res = new double[a.length + b.length];
		int k = 0;

		for (int i = 0; i < a.length; i++) {
			res[k++] = a[i];
		}
		for (int i = 0; i < b.length; i++) {
			res[k++] = b[i];
		}

		return res;
	}

	public static final Complex[] conj(Complex[] a) {
		Complex[] res = new Complex[a.length];

		for (int i = 0; i < res.length; i++) {
			res[i] = new Complex(a[i].getReal(), -a[i].getImaginary());
		}

		return res;
	}

	public static final Complex[] conv(Complex[] a, Complex[] b) {
		Complex[] res = new Complex[a.length + b.length - 1];

		for (int n = 0; n < res.length; n++) {
			res[n] = new Complex(0, 0);
			for (int i = Math.max(0, n - a.length + 1); i <= Math.min(b.length - 1, n); i++) {
				res[n] = res[n].add(b[i].multiply(a[n - i]));
			}

		}
		return res;
	}

	public static final double[] conv(double[] a, double[] b) {
		double[] res = new double[a.length + b.length - 1];

		for (int n = 0; n < res.length; n++) {
			for (int i = Math.max(0, n - a.length + 1); i <= Math.min(b.length - 1, n); i++) {
				res[n] += b[i] * a[n - i];
			}
		}

		return res;
	}

	public static final String conv(String s1, String s2) {
		String[] a = s1.split("[, ]+");
		String[] b = s2.split("[, ]+");
		String[] res = new String[a.length + b.length - 1];
		String s = "";

		for (int n = 0; n < a.length + b.length - 1; n++) {
			res[n] = "";
			for (int i = Math.max(0, n - a.length + 1); i <= Math.min(b.length - 1, n); i++) {

				if (!a[n - i].equals("0") && !b[i].equals("0")) {
					if (res[n].length() == 0) {
						res[n] += b[i] + "*" + "(" + a[n - i] + ")";
					} else {
						res[n] += "+" + b[i] + "*" + "(" + a[n - i] + ")";
					}
				}
			}
			if (res[n].length() == 0)
				res[n] = " 0 ";
			else
				res[n] += " ";
			s += res[n];
		}

		return s;
	}

	public static final Complex[] fft(Complex[] x) {
		Complex[] X = transformer.transform(x, TransformType.FORWARD);
		return X;
	}

	public static final Complex[] fft(double[] x) {
		Complex[] X = transformer.transform(x, TransformType.FORWARD);
		return X;
	}

	public static final Complex[] ifft(Complex[] X) {
		Complex[] x = transformer.transform(X, TransformType.INVERSE);
		return x;
	}

	public static final double[] linspace(double begin, double end, int cnt) {
		double[] res = new double[cnt];
		double delta = (end - begin) / (cnt - 1);

		res[0] = begin;
		for (int i = 1; i < res.length - 1; i++) {
			res[i] = begin + i * delta;
		}
		res[res.length - 1] = end;

		return res;
	}

	public static final double[] multiply(double[] a, double b) {

		for (int i = 0; i < a.length; i++) {
			a[i] *= b;
		}

		return a;
	}

	public static final double[] ones(int i) {
		double[] p = new double[i];
		for (int j = 0; j < p.length; j++) {
			p[j] = 1.0;
		}

		return p;
	}

	public static final Complex[] poly(Complex[] v) {
		Complex[] c = { new Complex(1.0, 0.0), v[0].negate() };

		for (int i = 1; i < v.length; i++) {
			c = conv(c, new Complex[] { new Complex(1.0, 0.0), v[i].negate() });
		}

		return c;
	}

	public static final double[] poly(double[] v) {
		double[] res = { 1.0, -v[0] };

		for (int i = 1; i < v.length; i++) {
			res = conv(res, new double[] { 1.0, -v[i] });
		}

		return res;
	}

	public static final double[] polyReal(Complex[] v) {
		Complex[] c = { new Complex(1.0, 0.0), v[0].negate() };

		for (int i = 1; i < v.length; i++) {
			c = Matlab.conv(c, new Complex[] { new Complex(1.0, 0.0), v[i].negate() });
		}

		double[] res = new double[c.length];
		for (int i = 0; i < c.length; i++) {
			res[i] = c[i].getReal();
		}

		return res;
	}

	public static final Complex polyval(Complex[] p, Complex x) {
		// if (Complex.equals(x, Complex.ZERO)) {
		// x = new Complex(1e-12, 0.0);
		// }
		Complex res = new Complex(0, 0);
		for (int i = 0; i < p.length; i++) {
			res = res.add(x.pow(p.length - i - 1).multiply(p[i]));
		}

		return res;
	}

	public static final Complex polyval(double[] p, Complex x) {
		Complex res = new Complex(0, 0);
		for (int i = 0; i < p.length; i++) {
			res = res.add(x.pow(p.length - i - 1).multiply(p[i]));
		}
		return res;
	}

	public static final Object[] residue(double[] b, double[] a) {
		double K = 0;
		Polynom B = new Polynom(b);
		B.trim();
		Polynom A = new Polynom(a);
		A.trim();

		int N = B.length() - 1;
		int M = A.length() - 1;

		if (N == M) {
			K = B.p[0] / A.p[0];
			B = B.subtract(A.multiply(K));
		}

		Complex[] P = A.roots();

		Complex[] R = new Complex[P.length];

		for (int m = 0; m < R.length; m++) {
			int k = 0;
			Complex[] p = new Complex[R.length - 1];
			for (int j = 0; j < R.length; j++) {
				if (m != j) {
					p[k++] = P[j];
				}
			}
			Complex[] pa = poly(p);

			Complex pvB = B.polyval(P[m]);
			Complex pvA = polyval(pa, P[m]);
			Complex pvD = pvB.divide(pvA);
			R[m] = pvD.divide(A.p[0]);

			// R[m] = B.polyval(P[m]).divide(polyval(pa, P[m])).divide(A.p[0]);
		}

		return new Object[] { R, P, K };
	}

	public static final Complex[] roots(double[] poly) {
		final LaguerreSolver solver = new LaguerreSolver(1e-16);
		double[] p = new double[poly.length];

		// Koeffizient der höchsten Potenz auf durch Multiplikation mit einer
		// Konstanten auf 1 normieren:
		double s = 1.0 / poly[0];
		for (int i = 0; i < poly.length; i++) {
			p[i] = poly[i] * s;
		}

		// Nullstellen bei Null zählen und entfernen
		int n = 0;
		while (p[p.length - 1 - n] <= 1e-15) {
			n++;
		}
		double[] pnz = new double[p.length - n];
		for (int k = 0; k < pnz.length; k++) {
			pnz[k] = p[k];
		}

		// Normierungskonstante berechnen:
		s = Math.pow(p[pnz.length - 1], 1.0 / (p.length - 1));

		// Durch [s^0 s^1 s^2 s^3 ... s^N] dividieren:
		for (int i = 0; i < pnz.length; i++)
			pnz[i] /= Math.pow(s, i);

		// Um mit Matlab konform zu sein flippen:
		double[] flip = new double[pnz.length];
		for (int i = 0; i < flip.length; i++)
			flip[pnz.length - i - 1] = pnz[i];

		// Wurzeln berechnen und durch Multiplikation mit s wieder entnormieren:
		Complex[] r = solver.solveAllComplex(flip, 0.0);
		for (int i = 0; i < r.length; i++) {
			r[i] = r[i].multiply(s);
		}

		Complex[] res = new Complex[r.length + n];

		// Um mit Matlab konform zu sein flippen:
		int i = 0;
		for (; i < r.length; i++)
			res[res.length - i - 1] = r[i];
		// Nullstellen bei Null hinzufügen:
		for (; i < res.length; i++) {
			res[res.length - i - 1] = new Complex(0.0, 0.0);
		}

		// Imaginärteil von NS, die nich konjugiert komplex vorkommen, auf Null
		// setzen.
		boolean[] cc = new boolean[res.length];
		for (int j = 0; j < res.length - 1; j++) {
			if (assertEq(res[j].getReal(), res[j + 1].getReal(), 12)
					&& assertEq(res[j].getImaginary(), -res[j + 1].getImaginary(), 12)) {
				cc[j] = cc[j + 1] = true;
			}
		}
		for (int j = 0; j < cc.length; j++) {
			if (!cc[j])
				res[j] = new Complex(res[j].getReal(), 0.0);
			else {
				res[j] = new Complex((res[j].getReal() + res[j + 1].getReal()) / 2.0,
						(res[j].getImaginary() - res[j + 1].getImaginary()) / 2.0);
				res[j + 1] = new Complex(res[j].getReal(), -res[j++].getImaginary());
			}
		}

		return res;
	}

	/**
	 * <pre>
	 * Prüft ob exp und act, auf n signifikante Stellen, übereinstimmen.
	 * </pre>
	 * 
	 * @param exp
	 * @param act
	 * @param n
	 * @return
	 */
	public static boolean assertEq(double exp, double act, int n) {
		String fmt = "0.";
		for (int j = 0; j < n - 1; j++) {
			fmt += "0";
		}
		fmt += "E000";

		DecimalFormat decimalFormat = new DecimalFormat(fmt);
		String stExp = decimalFormat.format(exp);
		String stAct = decimalFormat.format(act);
		return stExp.equals(stAct);
	}

	public static final double[] zeros(int i) {
		double[] p = new double[i];

		return p;
	}

	public static final Complex[] zerosC(int i) {
		Complex[] p = new Complex[i];
		for (int j = 0; j < p.length; j++) {
			p[j] = new Complex(0.0, 0.0);
		}

		return p;
	}

	static final double[] x = { 0.0000e+000, 16.0951e-003, 28.6662e-003, 39.6162e-003, 49.6393e-003, 59.1105e-003,
			68.2559e-003, 77.2244e-003, 86.1118e-003, 94.9806e-003, 103.8675e-003, 112.7897e-003, 121.7506e-003,
			130.7441e-003, 139.7565e-003, 148.7700e-003, 157.7632e-003, 166.7152e-003, 175.6002e-003, 184.3931e-003,
			193.0687e-003, 201.5991e-003, 209.9588e-003, 218.1189e-003, 226.0537e-003, 233.7387e-003, 241.1501e-003,
			248.2666e-003, 255.0706e-003, 261.5447e-003, 267.6778e-003, 273.4581e-003, 278.8782e-003, 283.9360e-003,
			288.6272e-003, 292.9543e-003, 296.9185e-003, 300.5242e-003, 303.7800e-003, 306.6918e-003, 309.2702e-003,
			311.5239e-003, 313.4659e-003, 315.1078e-003, 316.4603e-003, 317.5377e-003, 318.3535e-003, 318.9197e-003,
			319.2498e-003, 319.3567e-003 };

	static final double[] y = { 0.0000e+000, 20.4082e-003, 40.8163e-003, 61.2245e-003, 81.6327e-003, 102.0408e-003,
			122.4490e-003, 142.8571e-003, 163.2653e-003, 183.6735e-003, 204.0816e-003, 224.4898e-003, 244.8980e-003,
			265.3061e-003, 285.7143e-003, 306.1224e-003, 326.5306e-003, 346.9388e-003, 367.3469e-003, 387.7551e-003,
			408.1633e-003, 428.5714e-003, 448.9796e-003, 469.3878e-003, 489.7959e-003, 510.2041e-003, 530.6122e-003,
			551.0204e-003, 571.4286e-003, 591.8367e-003, 612.2449e-003, 632.6531e-003, 653.0612e-003, 673.4694e-003,
			693.8776e-003, 714.2857e-003, 734.6939e-003, 755.1020e-003, 775.5102e-003, 795.9184e-003, 816.3265e-003,
			836.7347e-003, 857.1429e-003, 877.5510e-003, 897.9592e-003, 918.3673e-003, 938.7755e-003, 959.1837e-003,
			979.5918e-003, 1.0000e+000 };

	public static double spline(double[] x, double[] y, double v) {
		PolynomialSplineFunction f = interpolator.interpolate(x, y);
		return f.value(v);
	}

	public static String add(String s1, String s2) {
		String[] a = s1.split("[, ]+");
		String[] b = s2.split("[, ]+");
		String res = "";

		if (a.length < b.length) {
			String[] tmp = a;
			a = b;
			b = tmp;
		}

		String[] bb = new String[a.length];

		for (int i = 0; i < bb.length; i++) {
			bb[i] = "";
		}
		for (int i = 0; i < b.length; i++) {
			bb[i + (a.length - b.length)] = b[i];
		}

		for (int n = 0; n < a.length; n++) {
			if (bb[n].length() == 0)
				res += "(" + a[n] + ") ";
			else
				res += "(" + a[n] + ")+" + "(" + bb[n] + ") ";
		}

		return res;
	}

	// public static void main(String[] args) {
	// }
}
