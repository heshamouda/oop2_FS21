package dsv;

public abstract class Filter {
	public double[] A;
	public double[] B;

	public Filter(double[] B, double[] A) {
		this.B = B;
		this.A = A;
	}

	public abstract double filter(double sample);

	public abstract double[] filter(double[] samples);

}
