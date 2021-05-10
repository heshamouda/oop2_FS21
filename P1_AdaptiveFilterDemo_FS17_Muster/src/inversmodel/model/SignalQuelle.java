package inversmodel.model;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: Muster
//Vorname:

public class SignalQuelle implements Runnable {
	// 11
	private double[] frameBuffer;
	private double intervallZeit = 100;
	private SignalListener signalListener;
	private int abtastRate;
	private long zeitIndex = 0;
	private double rechteckFrequenz = 1e3;
	private double rechteckPegel = 0.0;
	private double rauschPegel = 1.0;
	private ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

	// private boolean rauschenOn = true;
	// private boolean rechteckOn = true;

	/**
	 * Baut eine Signalquelle ...
	 * 
	 * <pre>
	 * - Erzeugt einen frameBuffer der Länge frameLaenge.
	 * - Berechnet die sleepTime als (1.0 durch rate) mal frameLaenge mal 1000.0.
	 * - Setzt die entsprechenden Attribute.
	 * </pre>
	 * 
	 * @param abtastRate
	 *            Abtastrate in Hz.
	 * @param frameLaenge
	 *            Länge eines Frames.
	 * @param signalListener
	 *            Listener, der aufgerufen werden soll.
	 */
	public SignalQuelle(int abtastRate, int frameLaenge, SignalListener signalListener) {
		// 4
		frameBuffer = new double[frameLaenge];
		intervallZeit = (1.0 / abtastRate) * frameLaenge * 1000.0;
		this.signalListener = signalListener;
		this.abtastRate = abtastRate;
	}

	/**
	 * Startet die Signalquelle ...
	 * 
	 * <pre>
	 * Erzeugt den Executor gemäss Aufgabenstellung.
	 * service.scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)
	 * </pre>
	 */
	public void start() {
		// 1
		service. scheduleAtFixedRate(this, 100, (long) intervallZeit, TimeUnit.MILLISECONDS);
	}

	/**
	 * Generiert bei jedem Aufruf Abtastwerte und ruft damit den signalListener
	 * auf ...
	 * 
	 * <pre>
	 * - Für k gleich 0 bis kleiner der Länge des Frame-Buffers:
	 *   - Lokale Var. rauschSignal gleich rauschPegel mal Zufallszahl im Bereich +/- 1.0 setzen.
	 *   - Lokale Var. rechteckSignal gleich rechteckPegel mal Signum von Sinus von (2 mal PI mal rechteckFrequenz mal zeitIndex/rate) setzen.
	 *   - zeitIndex inkrementieren.  
	 *   - Frame-Buffer an der Stelle k gleich rauschSignal plus rechteckSignal setzen.
	 * - Falls Signal-Listener nicht gleich null:
	 *   - processSignal() des Signal-Listener aufrufen.
	 * </pre>
	 */
	@Override
	public void run() {
		// 6
		for (int k = 0; k < frameBuffer.length; k++) {
			// if (rauschenOn)
			double rauschSignal = rauschPegel * 2.0 * (Math.random() - 0.5);
			// if (rechteckOn)
			double rechteckSignal = rechteckPegel
					* Math.signum(Math.sin(2.0 * Math.PI * rechteckFrequenz * zeitIndex++ / abtastRate));
			frameBuffer[k] = rauschSignal + rechteckSignal;
		}
		if (signalListener != null)
			signalListener.processSignal(frameBuffer);
	}

	public void setRechteckPegel(double rechteckPegel) {
		this.rechteckPegel = rechteckPegel;
	}

	public void setRauschPegel(double rauschPegel) {
		this.rauschPegel = rauschPegel;
	}

	// public void setRauschenOn(boolean rauschenOn) {
	// this.rauschenOn = rauschenOn;
	// }
	//
	// public void setRechteckOn(boolean rechteckOn) {
	// this.rechteckOn = rechteckOn;
	// }
}
