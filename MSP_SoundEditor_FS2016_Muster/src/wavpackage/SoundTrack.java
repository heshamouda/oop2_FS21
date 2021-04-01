package wavpackage;

import java.io.File;

public class SoundTrack {
	public static final int LEFT = 0, RIGHT = 1;
	private double[][] signal;
	private double[] tAxis;
	private int numSamples, numChannels, numBitsPerSample;
	private double duration;
	private int sampleRate;

	private SoundTrack(SoundTrack soundTrack) {
		signal = soundTrack.signal.clone();
		signal[0] = soundTrack.signal[0].clone();
		signal[1] = soundTrack.signal[1].clone();
		tAxis = soundTrack.tAxis.clone();
		numSamples = soundTrack.numSamples;
		numChannels = soundTrack.numChannels;
		numBitsPerSample = soundTrack.numBitsPerSample;
		duration = soundTrack.duration;
		sampleRate = soundTrack.sampleRate;
	}

	public SoundTrack(String wavDatei) {
		readWav(wavDatei);
	}

	public SoundTrack clone() {
		return new SoundTrack(this);
	}

	public double getDuration() {
		return duration;
	}

	public int getNumBitsPerSample() {
		return numBitsPerSample;
	}

	public int getNumChannels() {
		return numChannels;
	}

	public int getNumSamples() {
		return numSamples;
	}

	public int getSampleRate() {
		return sampleRate;
	}

	public double[][] getSignal() {
		return signal;
	}

	public double[] getTimeAxis() {
		return tAxis;
	}

	private void readWav(String wavDatei) {
		try {
			WavFile wavFile = WavFile.openWavFile(new File(wavDatei));
			wavFile.display();
			numChannels = wavFile.getNumChannels();
			numSamples = (int) wavFile.getNumFrames();
			numBitsPerSample = wavFile.getValidBits();
			sampleRate = (int) wavFile.getSampleRate();
			duration = numSamples / sampleRate;
			signal = new double[numChannels][numSamples];
			double[] buffer = new double[numSamples * numChannels];
			int framesRead = wavFile.readFrames(buffer, buffer.length);
			for (int s = 0; s < framesRead; s++) {
				signal[LEFT][s] = buffer[2 * s];
				signal[RIGHT][s] = buffer[2 * s + 1];
			}
			wavFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tAxis = new double[numSamples];
		for (int i = 0; i < tAxis.length; i++) {
			tAxis[i] = i / ((float) sampleRate);
		}
	}

	public void setSignal(double[][] signal) {
		this.signal = signal;
		this.numSamples = signal[LEFT].length;
		duration = numSamples / sampleRate;
		tAxis = new double[numSamples];
		for (int i = 0; i < tAxis.length; i++) {
			tAxis[i] = i / ((double) sampleRate);
		}
	}

	public void writeWav(String wavDatei) {
		System.gc();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			WavFile wavFile = WavFile.newWavFile(new File(wavDatei), 2, numSamples, 16, sampleRate);
			wavFile.writeFrames(signal, numSamples);
			wavFile.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
