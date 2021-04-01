package impulsdemo.model.goodies;

import org.apache.commons.math3.complex.Complex;

//DIESE DATEI MUSS NICHT BEARBEITET WERDEN! SIE WIRD NICHT BEWERTET!

public class Polynom {

	public double[] p;

	public Polynom(Complex[] z) {
		p = Matlab.polyReal(z);
	}

	public Polynom(double[] p) {
		this.p = p;
	}

	public Polynom add(Polynom b) {
		double[] res;
		;
		double[] p1 = p, p2 = b.p;

		int d = p.length - b.p.length;

		if (d < 0) {
			p2 = p;
			p1 = b.p;
			d = -d;
		}

		res = p1.clone();

		for (int i = 0; i < p2.length; i++) {
			res[i + d] = p1[i + d] + p2[i];
		}

		return new Polynom(res);
	}

	public int length() {
		return p.length;
	}

	public Polynom multiply(double k) {
		double[] a = new double[p.length];

		for (int i = 0; i < p.length; i++) {
			a[i] = k * p[i];
		}

		return new Polynom(a);
	}

	public Polynom multiply(Polynom b) {
		return new Polynom(Matlab.conv(p, b.p));
	}

	public Complex polyval(Complex x) {
		return Matlab.polyval(p, x);
	}

	public Complex[] roots() {
		return Matlab.roots(p);
	}

	public Polynom subtract(Polynom b) {
		double[] res;
		double[] p1 = p, p2 = b.p;

		int d = p.length - b.p.length;

		if (d < 0) {
			p2 = p;
			p1 = b.p;
			d = -d;
		}

		res = p1.clone();

		for (int i = 0; i < p2.length; i++) {
			res[i + d] = p1[i + d] - p2[i];
		}

		return new Polynom(res);
	}

	public String toString() {
		String s = "";

		for (int i = 0; i < p.length; i++) {
			s += "" + p[i] + "\n";
		}

		return s;
	}

	public void trim() {
		int i = 0;
		while (p[i] == 0.0) {
			i++;
		}
		if (i != 0) {
			double[] res = new double[p.length - i];
			for (int j = 0; j < res.length; j++) {
				res[j] = p[j + i];
			}
			this.p = res;
		}
	}

	public static void main(String[] args) {
		// Test conv():
		// Complex[] a = { new Complex(1, 0), new Complex(2, 0)};
		// Complex[] b = { new Complex(4, 0), new Complex(5, 0), new Complex(6,
		// 0) };
		//
		// Complex[] c = conv(a, b);
		//
		// for (int i = 0; i < c.length; i++) {
		// System.out.println("Re[" + i + "] = " + c[i].getReal());
		// }

		// Test poly()
		// double[] a = {0.5, 1.0, 2.0};
		//
		// double[] b = poly(a);
		//
		// for (int i = 0; i < b.length; i++) {
		// System.out.println(""+b[i]);
		// }

		// Test roots() und poly;
		// Complex[] P = roots(new double[] { 1.0, 2.0, 3.0 });
		// for (int i = 0; i < P.length; i++) {
		// System.out.println("" + P[i].getReal() + " " + P[i].getImaginary());
		// }
		//
		// double[] a = poly(P);
		// for (int i = 0; i < a.length; i++) {
		// System.out.println(""+a[i]);
		// }

		// Test add()
		Polynom b = new Polynom(new double[] { 1, 2, 3, 4, 5, 6 });
		Polynom a = new Polynom(new double[] { 1, 2, 3 });
		Polynom c = b.add(a);
		System.out.println(c.toString());
		//
		// Test roots() and Polynom()
		// Polynom a = new Polynom(new double[] { 1, 2, 3 });
		// Complex[] P = a.roots();
		// for (int i = 0; i < P.length; i++) {
		// System.out.println("" + P[i].getReal() + " " + P[i].getImaginary());
		// }
		// Polynom d = new Polynom(P);
		// System.out.println(d.toString());
	}

}
