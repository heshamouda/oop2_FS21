package frequenzgang.model;

/**
 * Klasse zur Repräsentation von komplexen Zahlen mit zugehörigen Methoden.
 * 
 * 
 * 
 */
public class Complex {
	public double re; // Realteil
	public double im; // Imaginäretei

	public Complex() {
		this(0.0, 0.0);

	}

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	public Complex(double re) {
		this(re, 0.0);

	}

	public Complex(Complex z) {
		this(z.re, z.im);
	}

	public String toString() {
		return ("Re: " + this.re + " Im: " + this.im);
	}

	public Complex add(Complex z) {
//		Complex zahl = new Complex();
//		zahl.re = this.re + z.re;
//		zahl.im = this.im + z.im;
//		return zahl;

		return new Complex(this.re + z.re, this.im + z.im);
	}

	public Complex sub(Complex z) {
		return new Complex(re - z.re, im - z.im);
	}

	public Complex mul(double z) {
		return new Complex(this.re * z, this.im * z);
	}

	public Complex mul(Complex z) {
		return new Complex((re * z.re - im * z.im), (re * z.im + im * z.re));
	}

	public Complex div(double z) {
		return new Complex(this.re / z, this.im / z);
	}

	public static void main(String[] args) {
		Complex c1 = new Complex(2, 4);
		Complex c2 = new Complex(5, -3);
		Complex result, result2, result3, result4;
		result = c1.add(c2);
		result2 = c1.mul(c2);
		result3 = c1.mul(2.0);
		result4 = c1.div(2.0);
		
		System.out.println("Addition: " + result.toString());
		System.out.println("Multiplikation: " + result2.toString());
		System.out.println("Multiplikation real: " + result3.toString());
		System.out.println("Division real: " + result4.toString());

	}
}