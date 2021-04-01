package drehzeigerdemo.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import org.apache.commons.math3.complex.Complex;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: Muster
//Vorname:

public class Model extends Observable implements ActionListener {
	public static final String RECHTECK = "Rechteck", DREIECK = "Dreieck", SAEGEZAHN = "Sägezahn";
	
	// 32
	private long n = 0;
	private double frequenz = 0.1, T = 0.05;
	private Complex[] spektralLinie = new Complex[127];
	private Complex[] drehZeiger = new Complex[127];
	private int anzahlLinien;
	private javax.swing.Timer timer;

	/**
	 * <pre>
	 * - Baut einen Swing - Timer mit Intervall T mal 1000 und Model als ActionListener.
	 * - Startet den Swing - Timer.
	 * </pre>
	 */
	public Model() {
		// 2
		timer = new javax.swing.Timer((int) (T * 1000.0), this);
		timer.start();
	}

	/**
	 * <pre>
	 * - Ruft processing() auf.
	 * </pre>
	 */
	public void actionPerformed(ActionEvent e) {
		// 1
		processing();
	}

	/**
	 * <pre>
	 * - Erzeugt einen Array drehZeiger mit Platz für 127 komplexe Werte.
	 * - Für m gleich -(anzahlLinien - 1) / 2 bis m kleiner gleich (anzahlLinien - 1) / 2:
	 *   - Drehzeiger an der Stelle [m + (spektralLinie.length - 1) / 2] gemäss Aufgabenstellung berechnen.
	 * - n inkrementieren.
	 * - Beobachter notifizieren.
	 * </pre>
	 */
	public void processing() {
		// 5
		drehZeiger = new Complex[127];
		for (int m = -(anzahlLinien - 1) / 2; m <= (anzahlLinien - 1) / 2; m++) {
			drehZeiger[m + (spektralLinie.length - 1) / 2] = (new Complex(0.0, 2.0 * Math.PI * m * frequenz * n * T))
					.exp().multiply(spektralLinie[m + (spektralLinie.length - 1) / 2]);
		}
		n++;
		notifyObservers();
	}

	/**
	 * <pre>
	 * - Setzt entsprechende Attribute.
	 * - Erzeugt einen Array spektralLinie mit Platz für 127 komplexe Werte.
	 * 
	 * - Switch abhängig von Signalform:
	 *   - Fall RECHTECK:
	 * 	   - Für m gleich -(anzahlLinien - 1) / 2 bis m kleiner gleich (anzahlLinien - 1) / 2:
	 *       - Spektrallinie an der Stelle [m + (spektralLinie.length - 1) / 2] gemäss Aufgabenstellung berechnen.
	 *       
	 * Challenge:
	 *   - Fall DREIECK:
	 * 	   - Für m gleich -(anzahlLinien - 1) / 2 bis m kleiner gleich (anzahlLinien - 1) / 2:
	 *       - Spektrallinie an der Stelle [m + (spektralLinie.length - 1) / 2] gemäss Aufgabenstellung berechnen.
	 *   - Fall SAEGEZAHN:
	 * 	   - Für m gleich -(anzahlLinien - 1) / 2 bis m kleiner gleich (anzahlLinien - 1) / 2:
	 *       - Spektrallinie an der Stelle [m + (spektralLinie.length - 1) / 2] gemäss Aufgabenstellung berechnen.
	 * </pre>
	 * 
	 * @param signalForm
	 * @param amplitude
	 * @param frequenz
	 * @param anzahlLinien
	 */
	public void setParameter(String signalForm, double amplitude, double frequenz, int anzahlLinien) {
		this.frequenz = frequenz;
		this.anzahlLinien = anzahlLinien;
		spektralLinie = new Complex[127];
//		spektralLinie[0]
		// 8 + 16

		switch (signalForm) {
		case RECHTECK:
			for (int m = -(anzahlLinien - 1) / 2; m <= (anzahlLinien - 1) / 2; m++) {
				if (m % 2 == 0) {
					spektralLinie[m + (spektralLinie.length - 1) / 2] = new Complex(0, 0);
				} else {
					spektralLinie[m + (spektralLinie.length - 1) / 2] = new Complex(
							2.0 * amplitude / (Math.abs(m) * Math.PI) * Math.pow(-1.0, (Math.abs(m) - 1) / 2), 0);
				}
			}
			break;
		case DREIECK:
			for (int m = -(anzahlLinien - 1) / 2; m <= (anzahlLinien - 1) / 2; m++) {
				if (m % 2 == 0) {
					spektralLinie[m + (spektralLinie.length - 1) / 2] = new Complex(0, 0);
				} else {
					spektralLinie[m + (spektralLinie.length - 1) / 2] = new Complex(2.0 * amplitude / (m * m * Math.PI),
							0);
				}
			}
			break;
		case SAEGEZAHN:
			for (int m = -(anzahlLinien - 1) / 2; m <= (anzahlLinien - 1) / 2; m++) {
				if (m < 0) {
					spektralLinie[m + (spektralLinie.length - 1) / 2] = new Complex(0.0,
							amplitude / (Math.abs(m) * Math.PI));
				}
				if (m == 0) {
					spektralLinie[m + (spektralLinie.length - 1) / 2] = new Complex(0.0, 0.0);
				}
				if (m > 0) {
					spektralLinie[m + (spektralLinie.length - 1) / 2] = new Complex(0.0,
							-amplitude / (Math.abs(m) * Math.PI));
				}
			}
			break;
		}
	}

	public Complex[] getDrehZeiger() {
		return drehZeiger;
	}

	@Override
	public void notifyObservers() {
		setChanged();
		super.notifyObservers();
	}
}