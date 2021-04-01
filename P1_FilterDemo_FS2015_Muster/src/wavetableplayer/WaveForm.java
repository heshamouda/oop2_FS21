package wavetableplayer;
public abstract class WaveForm {
	double frequency = 1000, amplitude = 0;
	double[] waveTable = new double[0xfff+1];

	public WaveForm(double frequency, double amplitude) {
		this.frequency = frequency;
		this.amplitude = amplitude;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

	public void setAmplitude(double amplitude) {
		this.amplitude = amplitude;
	}
	
	public double getFrequency() {
		return frequency;
	}

	public double getAmplitude() {
		return amplitude;
	}
}
