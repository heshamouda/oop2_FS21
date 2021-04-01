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
	}

	/**
	 * <pre>
	 * - Ruft processing() auf.
	 * </pre>
	 */
	public void actionPerformed(ActionEvent e) {
		// 1
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
		// 11 + 16

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