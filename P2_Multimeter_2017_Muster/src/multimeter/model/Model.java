package multimeter.model;
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.

// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
//

import java.util.Observable;

import multimeter.model.signalquelle.ChannelListener;
import multimeter.model.signalquelle.SignalQuelle;

public class Model extends Observable implements ChannelListener {
	// 27
	public static final int MODE_VAC = 0, MODE_VDC = 1, MODE_VEFF = 2, MODE_FREQ = 3;

	private int mode = MODE_VAC, oldPol = 1, abtastRate = 48000;
	private double vac, vdc, veff, freq, pV, alpha = 0.999, alphaFreq = 0.9;

	private SignalQuelle signalQuelle = new SignalQuelle(abtastRate, 2048, this);

	public Model() {
	}

	/**
	 * Gibt je nach gesetztem Attribut mode den entsprechenden Wert zurück. Man
	 * beachte: Frequenz in kHz zurück geben!
	 * 
	 * @return
	 */
	public double getValue() {
		// 10 Pte
		switch (mode) {
		case MODE_VAC:
			return vac;
		case MODE_VDC:
			return vdc;
		case MODE_VEFF:
			return veff;
		case MODE_FREQ:
			return freq / 1000.0;
		}
		return 0.0;
	}

	/**
	 * Diese Methode wird jedes Mal, wenn 2048 neue Abtastwerte vorliegen
	 * aufgerufen. In dieser Methode werden die Berechnungen gemäss
	 * Aufgabenstellung durchgeführt.
	 */
	public void process(double[] samples) {
		// 14
		int crossCount = 0;
		for (int i = 0; i < samples.length; i++) {
			vdc = alpha * vdc + (1.0 - alpha) * samples[i];
			pV = alpha * pV + (1.0 - alpha) * (samples[i]) * (samples[i]);

			double threshold = 0.05;
			if (samples[i] - vdc > threshold && oldPol == -1) {
				oldPol = +1;
				crossCount++;
			}
			if (samples[i] - vdc < threshold && oldPol == 1) {
				oldPol = -1;
				crossCount++;
			}
		}
		freq = alphaFreq * freq + (1.0 - alphaFreq) * (0.5 * crossCount * abtastRate / samples.length);
		vac = Math.sqrt(pV - vdc * vdc);
		veff = Math.sqrt(pV);
	}

	/**
	 * - Setzt entsprechendes Attribut.
	 * 
	 * @param mode
	 */
	public void setMode(int mode) {
		// 1
		this.mode = mode;
	}

	/**
	 * - Ruft entsprechende Methode der Signalquelle auf.
	 * 
	 * @param signalMode
	 * @param amp
	 * @param dc
	 * @param freq
	 */
	public void setParameters(int signalMode, double amp, double dc, double freq) {
		// 1
		signalQuelle.setParameters(signalMode, amp, dc, freq);
	}

	/**
	 * - Ruft entsprechende Methode der Signalquelle auf.
	 */
	public void start() {
		// 1
		signalQuelle.start();
	}

	public void notifyObservers() {
		setChanged();
		super.notifyObservers();
	}
}
