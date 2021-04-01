package wavetableplayer;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class WaveTablePlayer implements Runnable {

	private final int bufSize = 2 * 8192; // in bit
	private byte[] data = new byte[bufSize / 8];
	private final int fs = 44100;
	private SourceDataLine line;
	private Thread thread;
	private WaveForm waveForm;
	private int phase = 0;

	public WaveTablePlayer(WaveForm waveForm) {
		this.waveForm = waveForm;
		AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, fs, 16, 1, (16 / 8) * 1, fs, false);
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
		thread = new Thread(this);
		thread.start();
	}

	public WaveForm getWaveForm() {
		return waveForm;
	}

	public void setWaveForm(WaveForm waveForm) {
		this.waveForm = waveForm;
	}

	public void stop() {
		thread = null;
	}

	public void run() {
		while (thread != null) {
			for (int i = 0; i < data.length / 2; i++) {
				double x = 0.25*getNextSample();
				data[2 * i] = (byte) (((short) x & 0x00ff));
				data[2 * i + 1] = (byte) (((short) x & 0xff00) >> 8);
			}
			line.write(data, 0, data.length);
		}
		line.stop();
		line.close();
		line = null;
	}

	private double getNextSample() {
		int dphi = (int) (16 * waveForm.waveTable.length * waveForm.frequency / fs);
		phase = (phase + dphi) & 0xffff;
		return 32767.0 * waveForm.amplitude * waveForm.waveTable[phase >> 4];
	}

	//	public static void main(String s[]) {
	//		WaveTablePlayer waveTablePlayer = new WaveTablePlayer(new SineWave(0.0, 0.5));
	//		waveTablePlayer.getWaveForm().setFrequency(1000);
	//		for (int i = 2; i < 20; i++) {
	//			try {
	//				Thread.sleep(1500);
	//				waveTablePlayer.getWaveForm().setFrequency(i * 1000);
	//			} catch (InterruptedException e) {
	//				// TODO Auto-generated catch block
	//				e.printStackTrace();
	//			}
	//		}
	//		waveTablePlayer.stop();
	//	}
}
