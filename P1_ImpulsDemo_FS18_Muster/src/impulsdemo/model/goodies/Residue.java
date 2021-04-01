package impulsdemo.model.goodies;

import org.apache.commons.math3.complex.Complex;

//DIESE DATEI MUSS NICHT BEARBEITET WERDEN! SIE WIRD NICHT BEWERTET!

public class Residue {
	public Complex[] R;
	public Complex[] P;
	public Double K;

	public Residue(double[] B, double[] A) {
		Object[] RPK = Matlab.residue(B, A);
		R = (Complex[]) RPK[0];
		P = (Complex[]) RPK[1];
		K = (Double) RPK[2];
	}
}
