//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: Muster
//Vorname:

public class SignalQuelle extends Thread {
	// 21
	private double[] frameBuffer;
	private double sleepTime = 100;
	private SignalListener signalListener;
	private int rate;
	private int n = 0;
	private double fStoerer = 5;
	private double stoerPegel = 1.0;
	private double signalPegel = 1.0;
	private boolean signalOn = true;
	private boolean stoererOn = true;

	/**
	 * Baut eine Signalquelle ...
	 * 
	 * <pre>
	 * - Erzeugt einen frameBuffer der Länge frameLaenge.
	 * - Berechnet die sleepTime als (1.0 durch rate) mal frameLaenge mal 1000.0.
	 * - Setzt die entsprechenden Attribute.
	 * - Startet mittels start() den Thread.
	 * </pre>
	 * 
	 * @param rate
	 *            Abtastrate in Hz.
	 * @param frameLaenge
	 *            Länge eines Frames.
	 * @param signalListener
	 *            Listener, der aufgerufen werden soll.
	 */
	public SignalQuelle(int rate, int frameLaenge, SignalListener signalListener) {
		// 5
		frameBuffer = new double[frameLaenge];
		sleepTime = (1.0 / rate) * frameLaenge * 1000.0;
		this.signalListener = signalListener;
		this.rate = rate;
		start();
	}

	/**
	 * Generiert in einer Endlosschleife fortwährend Abtastwerte und ruft damit
	 * den signalListener auf ...
	 * 
	 * <pre>
	 * - Solange wahr
	 *   - Für k gleich 0 bis kleiner der frameBuffer-Länge:
	 *     - lokale Var. signal und stoerer deklarieren.
	 *     - Falls signalOn:
	 *       - signal gleich signalPegel mal Zufallszahl im Bereich +/- 1.0 setzen.
	 *     - Falls stoererOn:
	 *       - stoerer gleich Sinus von (2 mal PI mal fStoerer mal n/rate) setzen.
	 *       - n inkrementieren.  
	 *     - frameBuffer an der Stelle k gleich signal plus stoerer setzen.
	 *   - Falls signalListener nicht gleich null:
	 *     - processSignal() des signalListener aufrufen.
	 *   - Mittels Methode sleep() für sleepTime schlafen.
	 * </pre>
	 */
	public void run() {
		// 12
		while (true) {
			for (int k = 0; k < frameBuffer.length; k++) {
				double signal = 0.0;
				double stoerer = 0.0;
				if (signalOn)
					signal = signalPegel * 2.0 * (Math.random() - 0.5);
				if (stoererOn)
					stoerer = stoerPegel * Math.sin(2.0 * Math.PI * fStoerer * n++ / rate);
				frameBuffer[k] = signal + stoerer;
			}
			if (signalListener != null)
				signalListener.processSignal(frameBuffer);
			sleep();
		}
	}

	/**
	 * Schläft für sleepTime ms ...
	 * 
	 * <pre>
	 * - Mittels Thread.sleep() für sleepTime schlafen.
	 * </pre>
	 */
	private void sleep() {
		// 4
		try {
			Thread.sleep((long) sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void setStoerPegel(double stoerPegel) {
		this.stoerPegel = stoerPegel;
	}

	public void setSignalPegel(double signalPegel) {
		this.signalPegel = signalPegel;
	}

	public void setSignalOn(boolean b) {
		this.signalOn = b;
	}

	public void setStoererOn(boolean b) {
		this.stoererOn = b;
	}

}
