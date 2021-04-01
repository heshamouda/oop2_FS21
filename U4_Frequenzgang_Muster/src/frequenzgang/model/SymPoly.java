package frequenzgang.model;

public class SymPoly {

	public String[] p;

	public SymPoly(String[] p) {
		this.p = p;
	}

	public SymPoly(String poly) {
		this.p = stringToCoeff(poly);
	}

	public SymPoly add(SymPoly b) {
		String[] p1, p2;
		if (p.length > b.p.length) {
			p1 = p;
			p2 = b.p;
		} else {
			p2 = p;
			p1 = b.p;
		}

		String[] res = p1.clone();

		int d = p1.length - p2.length;
		for (int i = 0; i < p2.length; i++) {
			res[i + d] = "(" + p1[i + d] + "+" + p2[i] + ")";
		}

		return new SymPoly(res);
	}

	public int length() {
		return p.length;
	}

	public SymPoly multiply(SymPoly b) {
		return new SymPoly(conv(p, b.p));
	}

	public String toString() {
		String s = "";

		for (int i = 0; i < p.length; i++) {
			s += "" + p[i] + "\n";
		}

		return s;
	}

	private String[] stringToCoeff(String s) {
		return s.split("[, ]+");
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

	public static final String[] conv(String[] a, String[] b) {
		String[] res = new String[a.length + b.length - 1];
		for (int i = 0; i < res.length; i++) {
			res[i] = "";
		}

		for (int n = 0; n < res.length; n++) {
			for (int i = Math.max(0, n - a.length + 1); i <= Math.min(b.length - 1, n); i++) {
				res[n] += "+(" + b[i] + "*" + a[n - i] + ")";
			}
			res[n] = res[n].substring(1);
		}

		return res;
	}

	public void trim() {
		int i = 0;
		while (p[i].equals("")) {
			i++;
		}
		if (i != 0) {
			String[] res = new String[p.length - i];
			for (int j = 0; j < res.length; j++) {
				res[j] = p[j + i];
			}
			this.p = res;
		}
	}

	public SymPoly subtract(SymPoly b) {
		String[] p1, p2;
		String[] pSubtrahend = b.p.clone();
		for (int i = 0; i < pSubtrahend.length; i++) {
			pSubtrahend[i] = "-" + pSubtrahend[i];
		}

		if (p.length > b.p.length) {
			p1 = p;
			p2 = pSubtrahend;
		} else {
			p2 = p;
			p1 = pSubtrahend;
		}

		String[] res = p1.clone();

		int d = p1.length - p2.length;
		for (int i = 0; i < p2.length; i++) {
			res[i + d] = "(" + p1[i + d] + "+" + p2[i] + ")";
		}

		return new SymPoly(res);
	}

	public static void main(String[] args) {

		// Test add()
		String[] p1 = { "a", "b" };
		String[] p2 = { "c", "d" };

		SymPoly b = new SymPoly(p1);
		SymPoly a = new SymPoly(p2);
		SymPoly c = b.subtract(a);
		SymPoly d = new SymPoly("e, f");
		SymPoly e = c.multiply(d);
		System.out.println(e.toString());
	}

}
