package tools.dsp;

public class Delay {
	protected double[] buffer;
	protected int index = 0;

	public Delay(int delay) {
		buffer = new double[delay + 1];
	}

	public double getValue() {
		int k = buffer.length - 1;
		return buffer[(index + k + buffer.length) % buffer.length];
	}

	public void setValue(double value) {
		if (--index < 0)
			index = buffer.length - 1;
		buffer[index] = value;
	}
}
