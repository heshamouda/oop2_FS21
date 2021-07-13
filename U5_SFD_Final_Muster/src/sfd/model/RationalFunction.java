package sfd.model;

public class RationalFunction {

	public Polynom numerator;
	public Polynom denominator;

	public RationalFunction(double d) {
		this.numerator = new Polynom(d);
		this.denominator = new Polynom(d);
	}

	public RationalFunction(double n, double d) {
		this.numerator = new Polynom(n);
		this.denominator = new Polynom(d);
	}

	public RationalFunction(Polynom numerator, Polynom denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public RationalFunction add(double d) {
		return new RationalFunction(denominator.multiply(d).add(numerator), denominator);
	}

	public RationalFunction add(RationalFunction fun) {
		return new RationalFunction(numerator.multiply(fun.denominator).add(denominator.multiply(fun.numerator)),
				denominator.multiply(fun.denominator));
	}

	public RationalFunction divide(double d) {
		return new RationalFunction(numerator, denominator.multiply(d));
	}

	public RationalFunction divide(RationalFunction fun) {
		return new RationalFunction(numerator.multiply(fun.denominator), denominator.multiply(fun.numerator));
	}

	public Complex[] freqs(double[] f) {
		Complex[] res = new Complex[f.length];
		for (int k = 0; k < res.length; k++) {
			Complex jw = new Complex(0, 2.0 * Math.PI * f[k]);
			Complex p1 = numerator.polyval(jw);
			Complex p2 = denominator.polyval(jw);
			res[k] = p1.div(p2);
		}
		return res;
	}

	public RationalFunction multiply(double d) {
		return new RationalFunction(numerator.multiply(d), denominator);
	}

	public RationalFunction multiply(RationalFunction fun) {
		return new RationalFunction(numerator.multiply(fun.numerator), denominator.multiply(fun.denominator));
	}

	public void setPolynoms(Polynom numerator, Polynom denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public RationalFunction subtract(double d) {
		return new RationalFunction(numerator.subtract(denominator.multiply(d)), denominator);
	}

	public RationalFunction subtract(RationalFunction fun) {
		return new RationalFunction(numerator.multiply(fun.denominator).subtract(denominator.multiply(fun.numerator)),
				denominator.multiply(fun.denominator));
	}

	public String toString() {
		String s = "F=";
		s += "(" + numerator.toString() + ")/";
		s += "(" + denominator.toString() + ")";
		return s;
	}

	public static void main(String[] args) {
		// Tests
		RationalFunction funA = new RationalFunction(new Polynom("1 2"), new Polynom("3 4"));
		RationalFunction funB = new RationalFunction(new Polynom("5 6"), new Polynom("7 8"));
		RationalFunction fun = funA.add(funB);
		System.out.println(fun);
	}
}
