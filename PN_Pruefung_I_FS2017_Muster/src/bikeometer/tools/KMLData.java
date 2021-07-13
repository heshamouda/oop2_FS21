package bikeometer.tools;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Vector;

public class KMLData {
	// 30
	private Vector<KMLPoint> kmlVector = new Vector<KMLPoint>();

	public KMLData(String datei) {
		// 1
		readData(datei);
	}

	private void readData(String datei) {
		// 20
		try {
			BufferedReader eingabeDatei = new BufferedReader(new FileReader(datei));
			String zeile;
			int anfang, ende;
			while ((zeile = eingabeDatei.readLine()) != null) {
				if ((anfang = zeile.indexOf("<Point><coordinates>")) >= 0) {
					while (anfang != -1) {
						zeile = zeile.substring(anfang);
						ende = zeile.indexOf("</coordinates></Point>");
						String z = zeile.substring(20, ende);
						StringTokenizer tokens = new StringTokenizer(z, ", ");
						double laenge = Double.parseDouble(tokens.nextToken());
						double breite = Double.parseDouble(tokens.nextToken());
						double hoehe = Double.parseDouble(tokens.nextToken());
						kmlVector.add(new KMLPoint(laenge, breite, hoehe));
						// System.out.println("Länge: " + laenge + " Breite: " +
						// breite + " Höhe: " + hoehe);
						anfang = zeile.indexOf("<Point><coordinates>", ende);
					}
				}
			}
			eingabeDatei.close();
		} catch (IOException e) {
			System.err.println("Dateifehler: " + e.toString());
		}
	}

	public double[][] getTrace() {
		// 6
		double[][] trace = new double[kmlVector.size()][3];
		for (int i = 0; i < trace.length; i++) {
			trace[i][0] = ((KMLPoint) kmlVector.elementAt(i)).laenge;
			trace[i][1] = ((KMLPoint) kmlVector.elementAt(i)).breite;
			trace[i][2] = ((KMLPoint) kmlVector.elementAt(i)).hoehe;
		}
		return trace;
	}

	// public static void main(String[] args) {
	// new KMLData("20110708.kml");
	// }
}

class KMLPoint {
	double laenge, breite, hoehe;

	public KMLPoint(double laenge, double breite, double hoehe) {
		this.laenge = laenge;
		this.breite = breite;
		this.hoehe = hoehe;
	}
}
