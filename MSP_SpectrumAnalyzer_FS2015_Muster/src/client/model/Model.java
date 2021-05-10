package client.model;

// Muster

import java.util.Observable;

import javax.swing.SwingUtilities;

import client.model.goodies.DSP;
import common.AnalyzerConstants;

public class Model extends Observable implements DataListener {
	// 27
	private SignalSource signalSource = new SignalSource(this);
	private int fftLength = 0;
	private double alpha = 0.8;
	private double samplingRate = 48e3;
	private double[] powerSpectrum;
	private double[] frequencyAxis;
	private double scale;
	private double[] window;
	private double lineMarkerLeft = 10, lineMarkerRight = 24e3 - 10;
	private String windowType = AnalyzerConstants.HANNING;

	public double getLineMarkerLeft() {
		return lineMarkerLeft;
	}

	public double getLineMarkerRight() {
		return lineMarkerRight;
	}

	/**
	 * <pre>
	 * - Gibt clone() des entsprechenden Arrays zurück.
	 * </pre>
	 * 
	 * @return
	 */
	public double[] getFrequencyAxis() {
		return frequencyAxis.clone();
	}

	/**
	 * <pre>
	 * - Gibt clone() des entsprechenden Arrays zurück.
	 * </pre>
	 * 
	 * @return
	 */
	public double[] getPowerSpectrum() {
		return powerSpectrum.clone();
	}

	/**
	 * <pre>
	 * - Definiert lokalen double pwr mit Wert Null.
	 * - Für den ganzzahligen Anteil von (fftLength mal lineMarkerLeft durch samplingRate) bis kleiner 
	 *   dem ganzzahligen Anteil von (fftLength mal lineMarkerRight durch samplingRate):
	 *     - Zu pwr den Wert von powerSpectrum an der Stelle i addieren.
	 * - Die Wurzel aus (samplingRate mal pwr durch fftLength) zurück geben.  
	 * </pre>
	 * 
	 * @return
	 */
	public double getRMS() {
		// 4
		double pwr = 0.0;
		for (int i = (int) (fftLength * lineMarkerLeft / samplingRate); i < (int) (fftLength
				* lineMarkerRight / samplingRate); i++) {
			pwr +=  powerSpectrum[i];
		}
		return Math.sqrt(samplingRate*pwr/fftLength);
	}

	/**
	 * <pre>
	 * - Falls fftLength != Länge von data:
	 *     - setFFTLength mit Argument Länge von data aufrufen.
	 * 
	 * - Gemitteltes Leistungsdichtespektrum gemäss Algorithms in der Aufgabenstellung berechen.
	 * 
	 * - Beobachter notifizieren.
	 * </pre>
	 */
	@Override
	public void process(double[] data) {
		// 11

		if (fftLength != data.length) {
			setFFTLength(data.length);
		}

		double[][] x = new double[data.length][2];
		for (int i = 0; i < x.length; i++) {
			x[i][0] = data[i] * window[i] * scale;
		}

		DSP.fft(x);
		double[][] XoneSided = DSP.two2oneSided(x);
		double[] pwrSpec = DSP.absSqr(XoneSided);
		for (int i = 0; i < pwrSpec.length; i++) {
			powerSpectrum[i] = alpha * powerSpectrum[i] + (1.0 - alpha)
					* pwrSpec[i];
		}

		notifyObservers();
	}

	/**
	 * <pre>
	 * - Entsprechendes Attribut setzen.
	 * - setWindowType() mit Argument windowType aufrufen.
	 * - Neuen double - Array powerSpectrum mit der Länge fftLength durch 2 plus 1 erzeugen.
	 * - Mittels linspace() der Klasse DSP lineare Frequenzachse von Null bis samplingRate durch 2 
	 *   mit gleich vielen Elementen wie powerSpectrum erzeugen.
	 * </pre>
	 * @param fftLength
	 */
	private void setFFTLength(int fftLength) {
		// 6
		this.fftLength = fftLength;
		setWindowType(windowType);
		powerSpectrum = new double[fftLength / 2 + 1];
		frequencyAxis = DSP.linspace(0.0, samplingRate / 2.0,
				powerSpectrum.length);
	}

	public void setLineMarkerLeft(double left) {
		lineMarkerLeft = left;
	}

	public void setLineMarkerRight(double right) {
		lineMarkerRight = right;
	}

	/**
	 * <pre>
	 * - Ruft entsprechende Methode der Signalquelle auf.
	 * </pre>
	 * @param length
	 */
	public void setBufferLength(int length) {
		signalSource.setBufferLength(length);
	}

	/**
	 * <pre>
	 * - Setzt entsprechendes Attribut.
	 * - Deklariert lokalen double s mit Wert Null;
	 * - Für i gleich Null bis kleiner der Länge von window:
	 *     - Zu s den quadrierten Wert von window an der Stelle i addieren.
	 * - scale gleich Wurzel aus (1.0 durch (2 mal samplingRate mal s)) setzen.
	 * </pre>
	 * @param window
	 */
	private void setWindow(double[] window) {
		// 5
		this.window = window;
		double s = 0.0;
		for (int i = 0; i < window.length; i++) {
			s += window[i] * window[i];
		}
		scale = Math.sqrt(1.0 / (2.0 * samplingRate * s));
	}

	/**
	 * <pre>
	 * - Stezt das entsprechende Attribut.
	 * - Falls windowType gleich der Kopnstanten HANNING in AnalyzerConstants
	 *     - Methode setWindow() mit Argument DSP.hanning() mit Länge fftLength aufrufen.
	 * - Falls windowType gleich der Kopnstanten RECTWIN in AnalyzerConstants
	 *     - Methode setWindow() mit Argument DSP.rectwin() mit Länge fftLength aufrufen.
	 * </pre>
	 * @param windowType
	 */
	public void setWindowType(String windowType) {
		// 5
		this.windowType = windowType;
		if (windowType.equals(AnalyzerConstants.HANNING)) {
			setWindow(DSP.hanning(fftLength));
		}
		if (windowType.equals(AnalyzerConstants.RECTWIN)) {
			setWindow(DSP.rectwin(fftLength));
		}
	}

	@Override
	public void notifyObservers() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				notifyObserversLater();
			}
		});
	}

	public void notifyObserversLater() {
		setChanged();
		super.notifyObservers();
	}

}
