package bikeometer.model;

// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
// Klasse:
//

import java.util.Observable;

public class Model extends Observable {
	// 52
	public double vMin = 0.0, vMax = 40.0, hMin = 380.0, hMax = 560.0, tMin, tMax;
	public double markerA, markerB;
	public double geschwindigkeit, hoehe, distanz, deltaHoehe;
	public boolean newData = false;

	private static final double ERDDURCHMESSER = 40e6;
	private double[][] trace;
	private double zeitIntervall;
	private double[] vProfile, hProfile, sProfile, tAxis, traceX, traceY;

	private void calculateProfiles() {
		// 22
		traceX = new double[trace.length];
		traceY = new double[trace.length];
		sProfile = new double[trace.length - 1];
		vProfile = new double[trace.length - 1];
		hProfile = new double[trace.length - 1];

		// XY-Position relativ zum Ursprung
		for (int i = 0; i < traceX.length; i++) {
			traceX[i] = (ERDDURCHMESSER / 360.0) * Math.cos(Math.toRadians(trace[i][1])) * (trace[i][0] - trace[0][0]);
			traceY[i] = (ERDDURCHMESSER / 360.0) * (trace[i][1] - trace[0][1]);
		}

		// Distanz zwischen den Punkten
		double s = 0.0;
		for (int i = 0; i < sProfile.length; i++) {
			s += Math.sqrt(Math.pow(traceX[i + 1] - traceX[i], 2.0) + Math.pow(traceY[i + 1] - traceY[i], 2.0));
			sProfile[i] = s;
		}

		// Geschwindigkeit zwischen den Punkten
		for (int i = 0; i < vProfile.length - 1; i++) {
			vProfile[i] = 3.6 * (sProfile[i + 1] - sProfile[i]) / zeitIntervall;
		}
		vProfile[vProfile.length - 1] = vProfile[vProfile.length - 2];

		// Höhenprofil als Mittelwert von zwei Punkten
		for (int i = 0; i < hProfile.length; i++) {
			hProfile[i] = (trace[i][2] + trace[i + 1][2]) / 2.0;
		}

		// Zeitachse
		tAxis = new double[trace.length - 1];
		for (int i = 0; i < tAxis.length; i++) {
			tAxis[i] = zeitIntervall * i;
		}
		tMin = 0.0;
		tMax = zeitIntervall * (tAxis.length - 1);
	}

	/**
	 * <pre>
	 * - Mittels getIndex() lokalen int indexA aufgrund von markerA bestimmen.
	 * - Mittels getIndex() lokalen int indexB aufgrund von markerB bestimmen.
	 * - hoehe gleich hProfile[indexA].
	 * - deltaHoehe gleich hProfile[indexA] minus hProfile[indexB].
	 * - distanz gleich sProfile[indexA] minus sProfile[indexB].
	 * - geschwindigkeit gleich vProfile[indexA].
	 * </pre>
	 * 
	 */
	private void calculateProperties() {
		// 6
		int indexA = getIndex(markerA);
		int indexB = getIndex(markerB);
		hoehe = hProfile[indexA];
		deltaHoehe = hoehe - hProfile[indexB];
		distanz = sProfile[indexA] - sProfile[indexB];
		geschwindigkeit = vProfile[indexA];
	}

	/**
	 * Berechnet den aufgrund von time den index im tAxis Array.
	 * 
	 * <pre>
	 * - Setzt lokalen int index gleich der Laenge von tAxis minus 1.
	 * - für i gleich Null bis Laenge von tAxis minus 2
	 * 		- Falls tAxis[i] goesser time
	 * 			- index gleich i setzen und for - Schleife verlassen.
	 * - index zurückgeben.
	 * </pre>
	 * 
	 * @param time
	 * @return
	 */
	public int getIndex(double time) {
		// 6
		int index = tAxis.length - 1;
		for (int i = 0; i < tAxis.length - 1; i++) {
			if (tAxis[i] > time) {
				index = i;
				break;
			}
		}
		return index;
	}

	/**
	 * <pre>
	 * - Attribut trace gleich trace setzen.
	 * - Attribut zeitIntervall gleich timeIntervall setzen.
	 * - Profile mit entsprechender Methode berechnen.
	 * - markerA gleich tMax und markerB gleich tMin setzen.
	 * - Properties mit entsprechender Methode berechnen.
	 * - newData gleich true setzen.
	 * - Observer notifizieren.
	 * </pre>
	 * 
	 * @param trace
	 * @param timeIntervall
	 */
	public void setTrace(double[][] trace, double timeIntervall) {
		// 8
		this.trace = trace;
		this.zeitIntervall = timeIntervall;
		calculateProfiles();
		markerA = tMax;
		markerB = tMin;
		calculateProperties();
		newData = true;
		notifyObservers();
	}

	/**
	 * - Entsprechend Groesse zurueck geben.
	 * 
	 * @return
	 */
	public double[] getTraceX() {
		// 1
		return traceX;
	}

	/**
	 * - Entsprechend Groesse zurueck geben.
	 * 
	 * @return
	 */
	public double[] getTraceY() {
		// 1
		return traceY;
	}

	/**
	 * - Entsprechend Groesse zurueck geben.
	 * 
	 * @return
	 */
	public double[] getvProfile() {
		// 1
		return vProfile;
	}

	/**
	 * - Entsprechend Groesse zurueck geben.
	 * 
	 * @return
	 */
	public double[] gethProfile() {
		// 1
		return hProfile;
	}

	/**
	 * - Entsprechend Groesse zurueck geben.
	 * 
	 * @return
	 */
	public double[] getsProfile() {
		// 1
		return sProfile;
	}

	/**
	 * - Entsprechend Groesse zurueck geben.
	 * 
	 * @return
	 */
	public double[] getTimeAxis() {
		// 1
		return tAxis;
	}

	/**
	 * <pre>
	 * - Attribute markerA und markerB entsprechend setzen.
	 * - Properties mit entsprechender Methode neu berechnen.
	 * - Observer notifizieren.
	 * 
	 * </pre>
	 * 
	 * @param markerA
	 * @param markerB
	 */
	public void setMarkerPositions(double markerA, double markerB) {
		// 4
		this.markerA = markerA;
		this.markerB = markerB;
		calculateProperties();
		notifyObservers();
	}

	// ----------------------------------------------------------
	public void notifyObservers() {
		setChanged();
		super.notifyObservers();
	}

}
