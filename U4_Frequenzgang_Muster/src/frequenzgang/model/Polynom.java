package frequenzgang.model;

public class Polynom {

	public double[] p;

	public Polynom(double[] p) {
		this.p = p;
	}

	public Polynom(String poly) {
		this.p = stringToCoeff(poly);
	}

	public Polynom add(Polynom b) {
		double[] p1, p2;
		if (p.length > b.p.length) {
			p1 = p;
			p2 = b.p;
		} else {
			p2 = p;
			p1 = b.p;
		}

		double[] res = p1.clone();

		int d = p1.length - p2.length;
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
		return new Polynom(conv(p, b.p));
	}

	public String toString() {
		String s = "";

		for (int i = 0; i < p.length; i++) {
			s += "" + p[i] + "\n";
		}

		return s;
	}

	private double[] stringToCoeff(String s) {
		String[] tokens = s.split("[, ]+");
		double[] z = new double[tokens.length];
		for (int i = 0; i < z.length; i++) {
			z[i] = Double.parseDouble(tokens[i]);
		}
		return z;
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

	public Polynom subtract(Polynom b) {
		double[] p1, p2;
		double[] pSubtrahend = b.p.clone();
		for (int i = 0; i < pSubtrahend.length; i++) {
			pSubtrahend[i] = -pSubtrahend[i];
		}
		
		if (p.length > b.p.length) {
			p1 = p;
			p2 = pSubtrahend;
		} else {
			p2 = p;
			p1 = pSubtrahend;
		}

		double[] res = p1.clone();

		int d = p1.length - p2.length;
		for (int i = 0; i < p2.length; i++) {
			res[i + d] = p1[i + d] + p2[i];
		}

		return new Polynom(res);
	}

	public static void main(String[] args) {

		// Test add()
		Polynom b = new Polynom(new double[]    { 1, 2, 3, 4, 5, 6 });
		Polynom a = new Polynom(new double[] { 1, 2, 3, 4, 5, 6, 7 });
		Polynom c = b.subtract(a);
		System.out.println(c.toString());
	}

}
