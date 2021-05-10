package modem.model;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import modem.model.communication.Pam;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: 
//Vorname:

public class SymbolQuelle implements Runnable {
	// 8
	private double[] symbol;
	private SymbolListener symbolListener;
	private ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

	/**
	 * <pre>
	 * - Erzeugt den double-Array symbol mit entsprechender Anzahl Elementen.
	 * - Setzt das entsprechende Attribut.
	 * - Bewirkt mittels service.scheduleAtFixedRate(Runnable runnable, long initialDelay, 
	 *   long periode, TimeUnit TimeUnit.MILLISECONDS), dass die Methode run() nach einer 
	 *   Anfangsverzögerung von 1500 ms alle 200 ms ausgeführt wird.
	 * </pre>
	 * 
	 * @param anzahl
	 * @param symbolListener
	 */
	public SymbolQuelle(int anzahl, SymbolListener symbolListener) {
		// 3
		symbol = new double[anzahl];
		this.symbolListener = symbolListener;
		service.scheduleAtFixedRate(this, 1500, 200, TimeUnit.MILLISECONDS);
	}

	@Override
	/**
	 * <pre>
	 * - Für i gleich Null bis kleiner der Länge von symbol:
	 *   - Erzeugt durch (Pam.scrambler(0x1) << 1 | Pam.scrambler(0x1)) zwei Bits und 
	 *     bildet die Bits mittels statischer Methode mapper() der Klasse Pam in ein Symbol ab.
	 *   - Legt das Symbol in symbol[i] ab.
	 * - Falls symbolListener nicht gleich null
	 *   - processSymbol() des symbolListener mit entsprechendem Argument aufrufen.
	 * </pre>
	 */
	public void run() {
		// 5
		for (int i = 0; i < symbol.length; i++) {
			int bits = Pam.scrambler(0x1) << 1 | Pam.scrambler(0x1);
			symbol[i] = Pam.mapper(bits);
		}
		if (symbolListener != null)
			symbolListener.processSymbol(symbol);
	}
}
