package frequenzgang.model;

import util.TraceV5;

public class PicoMatlab {
	private static TraceV5 trace = new TraceV5("PicoMatlab", 42);

	/**
	 * Berechnet den Frequenzgang aufgrund von Zähler- und Nennerpolynom b resp. a
	 * sowie der Frequenzachse f.
	 * 
	 * @param b Zählerpolynom
	 * @param a Nennerpolynom
	 * @param f Frequenzachse
	 * @return Komplexwertiger Frequenzgang.
	 */
	public static final Complex[] freqs(double[] b, double[] a, double[] f) {
		trace.methodeCall();
		Complex[] res = new Complex[f.length];
		for (int k = 0; k < res.length; k++) {
			Complex jw = new Complex(0, 2.0 * Math.PI * f[k]);
			Complex zaeler = polyval(b, jw);
			Complex nenner = polyval(a, jw);
			res[k] = zaeler.div(nenner);
		}
		return res;
	}

	/**
	 * Berechnet komplexen Polynomwert an Stelle jw
	 * 
	 * @param p  koeffizienten des Polynoms
	 * @param jw
	 * @return
	 */
	public static final Complex polyval(double[] p, Complex jw) {
		Complex val = new Complex(0, 0);
		Complex res1 = new Complex();
		Complex res2 = new Complex();

		for (int i = 0; i < p.length; i++) {
//			res1 = jw.power(p.length - 1 - i);
//			res2 = res1.mul(p[i]);
//			val = res2.add(val);	
			val = jw.power(p.length - 1 - i).mul(p[i]).add(val);
		}
		return val;
	}

	public static void main(String[] args) {
		double[] f = { 0.0, 1.0, 2.0 };
		double[] b = { 3.0, 2.0, 1.0 };
		double[] a = { 1.0, 2.0, 3.0 };

		Complex val = polyval(b, new Complex(0.0, -3));
		System.out.println(val);

		Complex[] H = freqs(b, a, f);
		for (int i = 0; i < H.length; i++) {
			System.out.println(H[i]);
		}
	}

}
