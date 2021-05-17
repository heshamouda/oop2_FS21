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
//		Complex jw = new Complex();
//		Complex zaehler = new Complex();
//		Complex nenner = new Complex();alternativ unten deklarieren
		
		for (int k = 0; k < res.length; k++) {
			Complex jw = new Complex(0, 2.0 * Math.PI * f[k]);
			Complex zaehler = polyval(b, jw);
			Complex nenner = polyval(a, jw);
			res[k] = zaehler.div(nenner);
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
		Complex res1 = new Complex();// Zwischenergebniss
		Complex res2 = new Complex();// Zwischenergebniss

		// ich
		for (int i = 0; i < p.length; i++) {
			// val = ((jw.power(p.length - 1 - i)).mul(p[i])).add(val);// Lösung mit einer
			// Zeile
			res1 = jw.power(p.length - 1 - i);
			res2 = res1.mul(p[i]);
			val = res2.add(val);
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
			//System.out.println("Re: " + H[i].re + " Im: " + H[i].im);
			System.out.println(H[i]); //geht auch so! 
		}
	}
}
