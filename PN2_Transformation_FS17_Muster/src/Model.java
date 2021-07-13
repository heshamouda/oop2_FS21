//Name: Muster
//Vorname:
//Klasse:

import java.util.Observable;

/**
 * Model der Transformationsapplikation nach bekanntem Strickmuster. Legt Transformation fest, berechnet xAxis, signal und coeff. 
 *
 */
public class Model extends Observable {
	// 8/2 + 3 + 3 + 5 + 14 + 8  = 37 

	public static final int SINUS = 0, DREIECK = 1, FOURIER = 2, HADAMARD = 3;

	private double[][] fourier = { { 1.0000, 1.0000, 1.0000, 1.0000, 1.0000, 1.0000, 1.0000, 1.0000 },
			{ 0, 1.0000, 1.4142, 1.0000, 0.0000, -1.0000, -1.4142, -1.0000 },
			{ 1.4142, 1.0000, 0.0000, -1.0000, -1.4142, -1.0000, -0.0000, 1.0000 },
			{ 0, 1.4142, 0.0000, -1.4142, -0.0000, 1.4142, 0.0000, -1.4142 },
			{ 1.4142, 0.0000, -1.4142, -0.0000, 1.4142, 0.0000, -1.4142, -0.0000 },
			{ 0, 1.0000, -1.4142, 1.0000, 0.0000, -1.0000, 1.4142, -1.0000 },
			{ 1.4142, -1.0000, -0.0000, 1.0000, -1.4142, 1.0000, 0.0000, -1.0000 },
			{ 1.0000, -1.0000, 1.0000, -1.0000, 1.0000, -1.0000, 1.0000, -1.0000 } };

	private double[][] hadamard = { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, -1, -1, -1, -1, 1, 1 }, { 1, 1, 1, 1, -1, -1, -1, -1 },
			{ 1, 1, -1, -1, 1, 1, -1, -1 }, { 1, -1, -1, 1, 1, -1, -1, 1 }, { 1, -1, -1, 1, -1, 1, 1, -1 },
			{ 1, -1, 1, -1, -1, 1, -1, 1 }, { 1, -1, 1, -1, 1, -1, 1, -1 } };

	private double[][] transformMatrix = fourier;

	private double[] xAxis = new double[8];
	private double[] signal = new double[8];
	private double[] coeff = new double[8];

	public Model() {
		// 3
		for (int i = 0; i < xAxis.length; i++) {
			xAxis[i] = i;
		}
		setSignal(SINUS);
	}

	private void transform() {
		// 5
		for (int i = 0; i < transformMatrix.length; i++) {
			coeff[i]=0;
			for (int j = 0; j < transformMatrix[0].length; j++) {
				coeff[i] += signal[j] * transformMatrix[i][j];
			}
			coeff[i] /= transformMatrix[0].length;
		}
	}

	public void setSignal(int form) {
		// 14 
		switch (form) {
			case SINUS:
				for (int i = 0; i < signal.length; i++) {
					signal[i] = Math.sqrt(2.0) * Math.sin(2.0 * Math.PI * i / 8);
				}
				break;
			case DREIECK:
				for (int i = 0; i < signal.length / 2 - 1; i++) {
					signal[i] = i / 3.0;
				}
				signal[signal.length / 2] = 0;
				for (int i = signal.length / 2 + 1; i < signal.length; i++) {
					signal[i] = -1.0 + (i - 5) / 3.0;
				}
		}
		transform();
		notifyObservers();
	}

	public void setTransform(int transform) {
		// 8
		switch (transform) {
			case FOURIER:
				transformMatrix = fourier;
				break;
			case HADAMARD:
				transformMatrix = hadamard;
		}
		transform();
		notifyObservers();
	}

	public double[] getXAxis() {
		return xAxis;
	}

	public double[] getTransformMatrix(int zeile) {
		return transformMatrix[zeile];
	}

	public double[] getSignal() {
		return signal;
	}

	public double getCoeff(int element) {
		return coeff[element];
	}

	public void notifyObservers() {
		setChanged();
		super.notifyObservers();
	}
}
