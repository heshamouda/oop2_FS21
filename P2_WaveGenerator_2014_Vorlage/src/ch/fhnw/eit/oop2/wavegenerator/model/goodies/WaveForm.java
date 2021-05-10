package ch.fhnw.eit.oop2.wavegenerator.model.goodies;

public abstract class WaveForm {
	private int frequency = 1000, amplitude = 0;
	protected double[] waveTable = new double[32 * 1024];

	public WaveForm(int frequency, int amplitude) {
		this.frequency = frequency;
		this.amplitude = amplitude;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public int getAmplitude() {
		return amplitude;
	}

	public void setAmplitude(int amplitude) {
		this.amplitude = amplitude;
	}

	public double[] getWaveTable() {
		return waveTable;
	}
}
