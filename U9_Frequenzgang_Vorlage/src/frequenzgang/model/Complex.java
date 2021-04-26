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

	

	public static void main(String[] args) {
		Complex c1 = new Complex(2, 4);
		Complex c2 = new Complex(5, -3);
		
		
		

		

	}
}