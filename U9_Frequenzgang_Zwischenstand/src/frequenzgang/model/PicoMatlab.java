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
		

		return val;
	}

	public static void main(String[] args) {
		double[] f = { 0.0, 1.0, 2.0 };
		double[] b = { 3.0, 2.0, 1.0 };
		double[] a = { 1.0, 2.0, 3.0 };
		
	}
	
}
