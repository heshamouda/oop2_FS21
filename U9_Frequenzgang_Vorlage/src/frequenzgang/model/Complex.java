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
//		
//		return zahl;z.
		return new Complex(this.re+z.re,this.im + z.im);
	}

	public Complex sub(Complex z) {

		return null;
	}

	public Complex mul(double z) {

		return null;
	}

	public Complex mul(Complex z) {

		return null;
	}

	public Complex div(double z) {

		return null; 
	}

	public Complex div(Complex z) {

		return null;
	}

	public Complex power(double x) {

		return null;
	}

	public double angle() {
		return 0;
		 
	}

	public double abs() {
		return 0;
		 
	}

	public double [] angle(Complex[] c) {
		return null;
		 
	}

	public static void main(String[] args) {
		Complex c1 = new Complex(2, 4);
		Complex c2 = new Complex(5, -3);

	}
}