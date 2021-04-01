package frequenzgang.model;

/**
 * Klasse zur Repräsentation von komplexen Zahlen mit zugehörigen Methoden.
 * 
 * @author Richard Gut
 * 
 */
public class Complex {
	public double re; // Realteil
	public double im; // Imaginäretei

	public Complex() {
		this(0.0, 0.0);
	}

	public Complex(double re) {
		this(re, 0.0);
	}

	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	public Complex(Complex z) {
		this(z.re, z.im);
	}

	/**
	 * <pre>
	 * - Berechnet den Real- und den Imaginärteil der Addition 
	 *   von this plus z.
	 * - Gibt ein neues Objekt der Art Complex mit entsprechendem 
	 *   Real- und Imaginärteil zurück.
	 * </pre>
	 * 
	 * @param z
	 * @return
	 */
	public Complex add(Complex z) {
		return null;
	}

	/**
	 * <pre>
	 * - Berechnet den Real- und den Imaginärteil der Subtraktion 
	 *   von this minus z.
	 * - Gibt ein neues Objekt der Art Complex mit entsprechendem 
	 *   Real- und Imaginärteil zurück.
	 * </pre>
	 * 
	 * @param z
	 * @return
	 */
	public Complex subtract(Complex z) {
		return null;
	}

	/**
	 * <pre>
	 * - Berechnet den Real- und den Imaginärteil der Multiplikation 
	 *   von this mal z.
	 * - Gibt ein neues Objekt der Art Complex mit entsprechendem 
	 *   Real- und Imaginärteil zurück.
	 * </pre>
	 * 
	 * @param z
	 * @return
	 */
	public Complex multiply(Complex z) {
		return null;
	}

	/**
	 * <pre>
	 * - Berechnet den Real- und den Imaginärteil der Division 
	 *   von this durch z.
	 * - Gibt ein neues Objekt der Art Complex mit entsprechendem 
	 *   Real- und Imaginärteil zurück.
	 * </pre>
	 * 
	 * @param z
	 * @return
	 */
	public Complex devide(Complex z) {
		return null;
	}

	public String toString() {
		return "Re: " + this.re + " Im: " + this.im;
	}

	public static void main(String[] args) {
		Complex a = new Complex(2, 4);
		Complex b = new Complex(5, -3);
	}
}