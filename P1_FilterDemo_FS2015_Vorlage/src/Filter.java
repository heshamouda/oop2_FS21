public class Filter {
	public double[] B, A;
	public Complex[] rB, rA;

	public Filter(double[] B, double[] A, Complex[] rB, Complex[] rA) {
		this.B = B;
		this.A = A;
		this.rB = rB;
		this.rA = rA;
	}

}

