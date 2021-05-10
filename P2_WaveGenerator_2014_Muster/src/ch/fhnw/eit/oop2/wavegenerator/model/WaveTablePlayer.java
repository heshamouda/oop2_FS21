package ch.fhnw.eit.oop2.wavegenerator.model;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class WaveTablePlayer implements Runnable {

	private final int bufSize = 1 * 8192; // in bit
	private byte[] data = new byte[bufSize / 8];
	private double time;
	private final int fs = 48000;
	private SourceDataLine line;
	private Thread thread;
	private WaveForm waveForm;

	public WaveForm getWaveForm() {
		return waveForm;
	}

	public void setWaveForm(WaveForm waveForm) {
		this.waveForm = waveForm;
	}

	public WaveTablePlayer(WaveForm waveForm) {
		this.waveForm = waveForm;
		AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
				fs, 16, 1, (16 / 8) * 1, fs, false);
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
		if (!AudioSystem.isLineSupported(info)) {
			System.err.println("Line matching " + info + " not supported.");
			return;
		}
		try {
			line = (SourceDataLine) AudioSystem.getLine(info);
			line.open(format, bufSize);
		} catch (LineUnavailableException ex) {
			System.err.println("Unable to open the line: " + ex);
			return;
		}
		line.start();
		start();
	}

	private double[] getSignal(int length) {
		// waveForm.length muss eine 2er Potenz sein!
		double[] signal = new double[length];
		if (waveForm.getWaveTable() == null)
			return signal;
		for (int i = 0; i < signal.length; i++) {
			signal[i] = (waveForm.getAmplitude() / 1000.0)
					* 32767.0
					* waveForm.getWaveTable()[((int) Math.round(waveForm
							.getWaveTable().length
							* time
							* waveForm.getFrequency()))
							& (waveForm.getWaveTable().length - 1)];
			time += 1.0 / fs;
		}
		if (time > 1.0 / waveForm.getFrequency())
			time -= 1.0 / waveForm.getFrequency();
		return signal;
	}

	public void run() {
		while (thread != null) {
			double[] x = getSignal(data.length / 2);
			for (int i = 0; i < data.length / 2; i++) {
				data[2 * i] = (byte) (((short) x[i] & 0x00ff));
				data[2 * i + 1] = (byte) (((short) x[i] & 0xff00) >> 8);
			}
			line.write(data, 0, data.length);
		}
		line.stop();
		line.close();
		line = null;
	}

	public void start() {
		thread = new Thread(this);
		thread.start();
	}

	public void stop() {
		thread = null;
	}

	public double[] sinewav(int length) {
		double[] s = new double[length];

		for (int i = 0; i < s.length; i++) {
			s[i] = 0.5 * (Math.sin(2.0 * Math.PI * i / length));
		}

		return s;
	}

	// public static void main(String s[]) {
	// WaveForm waveForm = new SineWave(1000, 500);
	// WaveTablePlayer waveTablePlayer = new WaveTablePlayer(waveForm);
	// try {
	// Thread.sleep(3000);
	// waveTablePlayer.stop();
	// } catch (InterruptedException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
}
