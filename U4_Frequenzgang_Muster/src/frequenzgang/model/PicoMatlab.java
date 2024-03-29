package frequenzgang.model;

import util.TraceV8;

public class PicoMatlab {
	private static TraceV8 trace = new TraceV8("PicoMatlab", 42);

	/**
	 * Berechnet den Frequenzgang aufgrund von Z�hler- und Nennerpolynom b resp. a
	 * sowie der Frequenzachse f.
	 * 
	 * @param b Z�hlerpolynom
	 * @param a Nennerpolynom
	 * @param f Frequenzachse
	 * @return Komplexwertiger Frequenzgang.
	 */
	public static final Complex[] freqs(double[] b, double[] a, double[] f) {
		trace.methodeCall();

		Complex[] res = new Complex[f.length];
		for (int k = 0; k < res.length; k++) {
			Complex jw = new Complex(0, 2.0 * Math.PI * f[k]);
			Complex zaehler = polyval(b, jw);
			Complex nenner = polyval(a, jw);
			res[k] = zaehler.div(nenner);
		}
		return res;
	}

	public static final Complex polyval(double[] p, Complex jw) {
//		trace.methodeCall();
		Complex val = new Complex(0, 0);
		for (int i = 0; i < p.length; i++) {
			val = jw.pow(p.length - i - 1).mul(p[i]).add(val);
		}
		return val;
	}

	public static void main(String[] args) {
		double[] f = { 0.0, 1.0, 2.0 };
		double[] b = { 3.0, 2.0, 1.0 };
		double[] a = { 1.0, 2.0, 3.0 };

		Complex val = polyval(b, new Complex(0.0, -3));

		System.out.println("" + val);

		Complex[] H = freqs(b, a, f);

		for (int i = 0; i < H.length; i++) {
			System.out.println("Re: " + H[i].re + " Im: " + H[i].im);
		}
	}
}
