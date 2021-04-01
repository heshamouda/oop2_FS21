package client.model;

// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: Muster
// Vorname:
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import client.gui.goodies.PNStatus;
import common.AnalyzerConstants;

public class SignalSource implements Runnable {
	// 32
	private double[] buffer = new double[0];

	private String serverAdress = "127.0.0.1";
	// private String serverAdress = "192.168.241.1";
	private int serverPort = 11111;

	private Socket socket;
	private PrintWriter serverWriter;
	private BufferedReader serverReader;

	private DataListener dataListener;

	private Thread thread;

	private int bufferLength = 512;

	/**
	 * <pre>
	 * - Setzt das entsprechende Attribut.
	 * - Erzeugt Socket unter Verwendung von serverAdress und serverPort.
	 * - Erzeugt mit dem Socket den serverWriter und den serverReader.
	 * - Zeigt in der StatusBar "Connected to Server!" an.
	 * - Erzeugt einen neuen Thread thread mit this als Argument.
	 * - Started den thread.
	 * - Im Falle eine IOException wird "Unable to connect to Server!" in der StatusBar angezeigt.
	 * </pre>
	 * 
	 * @param dataListener
	 */
	public SignalSource(DataListener dataListener) {
		// 10
		this.dataListener = dataListener;
		try {
			socket = new Socket(serverAdress, serverPort);
			serverWriter = new PrintWriter(new OutputStreamWriter(
					socket.getOutputStream()));
			serverReader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			PNStatus.showStatus("Connected to Server!");
			thread = new Thread(this);
			thread.start();
		} catch (IOException e) {
			PNStatus.showStatus("Unable to connect to Server!");
		}
	}

	/**
	 * <pre>
	 * - Liest eine Zeile mittels serverReader und gibt sie zurück.
	 * - Im Falle einere IOException wird in der StatusBar "Unable to read from Server ..." ausgegeben 
	 *   und socket gleich null gesetzt.
	 * </pre>
	 * 
	 * @return
	 */
	private String readFromServer() {
		// 6
		try {
			return serverReader.readLine();
		} catch (IOException e) {
			PNStatus.showStatus("Unable to read from Server ...");
			socket = null;
		}
		return "";
	}

	/**
	 * <pre>
	 * - ! Die Methode run() kommuniziert mittels writeToServer() und readFromServer() mit dem Spectrum - Analyzer - Server !
	 * - Solange socket nicht gleich null
	 * 		- Falls bufferLength ungleich der Länge von buffer:
	 * 			- Mittels AnalyzerConstants SetBLOCKLENGTH mit mit angehängter bufferLength auf den Server schreiben.
	 * 			- Neuen double - Array buffer der Länge bufferLength erzeugen.
	 * 		- Mittels AnalyzerConstants GetBUFFER auf den Server schreiben.
	 * 		- Mittels for - Schleife entsprechend der Länge von buffer Zeilen vom Server lesen,
	 * 		  in double	konvertieren und in buffer ablegen. 
	 * 		- Methode process() des dataListener mit buffer aufrufen.
	 * 		- Für 50 ms schlafen
	 * 	 	- Im Falle einer InterruptedException "Sleep - Error!" in die StatusBar schreiben.
	 * </pre>
	 */
	@Override
	public void run() {
		// 13
		while (socket != null) {
			if (bufferLength != buffer.length) {
				writeToServer(AnalyzerConstants.SetBLOCKLENGTH + " "
						+ bufferLength);
				buffer = new double[bufferLength];
			}
			writeToServer(AnalyzerConstants.GetBUFFER);
			for (int i = 0; i < buffer.length; i++) {
				buffer[i] = Double.parseDouble(readFromServer())
						/ Short.MAX_VALUE;
			}
			dataListener.process(buffer);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				PNStatus.showStatus("Sleep - Error!");
			}
		}
	}

	/**
	 * <pre>
	 * - Setzt entsprechendes Attribut.
	 * </pre>
	 * 
	 * @param length
	 */
	public void setBufferLength(int length) {
		// 1
		bufferLength = length;
	}

	/**
	 * <pre>
	 * - Schreibt den String s mittels serverWriter.
	 * - Ruft flush() des serverWriter auf.
	 * 
	 * </pre>
	 * 
	 * @param s
	 */
	private void writeToServer(String s) {
		// 2
		serverWriter.println(s);
		serverWriter.flush();
	}

}
