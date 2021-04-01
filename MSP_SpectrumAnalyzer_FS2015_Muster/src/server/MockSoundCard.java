package server;

import java.util.Vector;

public class MockSoundCard extends Thread {
	private static final int SINUS = 0, RECTANGLE = 1;
	private int waveForm = SINUS;
	private int periode;
	private boolean keepRunning = true;
	private Vector<ChannelListener> listenerVector = new Vector<ChannelListener>();
	private double frequency = Math.PI * 1.0e3;
	private double samplingRate;
	private double t;

	public MockSoundCard() {
		samplingRate = 48e3;
		periode = (int) (1e3 * 2048 * 1.0 / samplingRate); // In ms!
	}

	public void addChannelListener(ChannelListener listener) {
		listenerVector.add(listener);
	}

	public void removeChannelListener(ChannelListener listener) {
		listenerVector.remove(listener);
	}

	public void run() {
		double[] data = new double[2048];
		while (keepRunning) {
			if (!listenerVector.isEmpty()) {
				for (int i = 0; i < data.length; i++) {
					switch (waveForm) {
					case RECTANGLE:
						data[i] = 0.0;
						for (int k = 0; k <= Math.floor(samplingRate
								/ (4.0 * frequency)); k++) {
							data[i] += (4.0 / Math.PI)
									* Math.sin(2.0 * Math.PI * (2.0 * k + 1.0)
											* frequency * t) / (2.0 * k + 1.0);
						}
						break;
//					case RECTANGLE:
//						data[i] = Math.signum(Math.sin(2 * Math.PI * frequency * t));
//						break;
					case SINUS:
						data[i] = Math.sin(2 * Math.PI * frequency * t);
						break;
					}

					t += 1.0 / samplingRate;
				}
				for (int i = 0; i < listenerVector.size(); i++) {
					listenerVector.elementAt(i).process(data);
				}
				// if (t > 1.0) t -= 1.0;
			}
			try {
				Thread.sleep(periode);
			} catch (InterruptedException e) {
				System.err.println("sleep exception");
			}
		}
	}

	public void stopTimer() {
		keepRunning = false;
	}

	public void setForm(String form) {
		if(form.equalsIgnoreCase("Rectangle"))
			waveForm = RECTANGLE;
		if(form.equalsIgnoreCase("Sinus"))
			waveForm = SINUS;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
		
	}

}
