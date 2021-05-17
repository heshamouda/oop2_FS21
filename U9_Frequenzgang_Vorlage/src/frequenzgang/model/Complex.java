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

		return null;
	}

	public Complex div(Complex z) {

		return new Complex(abs() / z.abs() * Math.cos(angle() - z.angle()));
	}

	public Complex power(double x) {

		return new Complex(Math.pow(abs(), x) * Math.cos(angle() * x), Math.pow(abs(), x)*Math.sin( ));
	}

	public double angle() {
		return Math.atan2(im, re);
		}

	public double abs() {
		return Math.sqrt(Math.pow(re, 2.0) + Math.pow(im, 2.0));
		}

	public double[] angle(Complex[] c) {
		 double[] retValue = new double [c.length];
		 for (int i = 0; i < retValue.length; i++) {
			retValue [i]= c[i].angle();
		}
		 return retValue;
	}

	public static void main(String[] args) {
		Complex c1 = new Complex(2, 4);
		Complex c2 = new Complex(5, -3);
		Complex result1, result2, result3, result4, result5;
		result1 = c1.add(c1);
		result2 = c1.sub(c2);
		result3 = c1.mul(c2);
		result4 = c1.div(c2);
		result5 = c1.mul(2.0);
		
		System.out.println("Addition: " + result1.toString());
		System.out.println("Multiplikation: " + result2.toString());
		System.out.println("Multiplikation real: " + result3.toString());
		System.out.println("Division real: " + result4.toString());
		System.out.println("Division real: " + result5.toString());

		
	}
}