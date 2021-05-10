package wavpackage;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

public class WavPlayer implements Runnable {
	private SourceDataLine line;
	private Thread thread;
	private final int bufSize = 32 * 8 * 1024; // in bit
	private byte[] data = new byte[bufSize / 8];
	private double[][] signal;
	public boolean isPlaying = false;

	int index;

	double[][] val;

	double[] out1, out2;

	public WavPlayer(int fs, double[][] signal) {
		this.signal = signal;
		// AudioFormat(AudioFormat.Encoding encoding, float sampleRate, int
		// sampleSizeInBits, int channels, int frameSize, float
		// frameRate, boolean bigEndian)
		AudioFormat format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, fs, 16, 2, (16 / 8) * 2, fs, false);
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
		if (!AudioSystem.isLineSupported(info)) {
			shutDown("Line matching " + info + " not supported.");
			return;
		}
		try {
			line = (SourceDataLine) AudioSystem.getLine(info);
			line.open(format, bufSize);
		} catch (LineUnavailableException ex) {
			shutDown("Unable to open the line: " + ex);
			return;
		}
		line.start();
		start();
	}

	public WavPlayer(SoundTrack wavData) {
		this(wavData.getSampleRate(), wavData.getSignal());
	}

	private double[][] getSignal(int length) {
		if (index + length > signal[0].length)
			return null;
		if (val == null) {
			val = new double[2][length];
			out1 = new double[length];
			out2 = new double[length];
		}
		for (int i = 0; i < length; i++) {
			val[0][i] = 32767 * signal[0][index];
			val[1][i] = 32767 * signal[1][index++];
		}
		// equalizer1.equalizer(out1, val[0]);
		// equalizer2.equalizer(out2, val[1]);
		val[0] = out1;
		val[1] = out2;
		return val;
	}

	public void run() {
		while (thread != null) {
			double[][] x = getSignal(data.length / 4);
			if (x == null)
				break;
			for (int i = 0; i < x[0].length; i++) {
				data[4 * i + 0] = (byte) (((short) x[0][i] & 0x00ff));
				data[4 * i + 1] = (byte) (((short) x[0][i] & 0xff00) >> 8);

				data[4 * i + 2] = (byte) (((short) x[1][i] & 0x00ff));
				data[4 * i + 3] = (byte) (((short) x[1][i] & 0xff00) >> 8);
			}
			line.write(data, 0, data.length);
		}
		isPlaying = false;
		line.stop();
		line.close();
		line = null;
		shutDown(null);
		this.signal = null;
		System.gc();
	}

	private void shutDown(String message) {
		if (message != null) {
			System.err.println(message);
		}
		if (thread != null) {
			thread = null;
		}
	}

	public void start() {
		thread = new Thread(this);
		thread.setName("Playback");
		thread.setPriority(Thread.MAX_PRIORITY);
		isPlaying = true;
		thread.start();
	}

	public void stop() {
		thread = null;
		isPlaying = false;
		this.signal = null;
		System.gc();
	}

}
