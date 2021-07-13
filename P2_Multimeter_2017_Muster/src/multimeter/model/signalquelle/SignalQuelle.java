package multimeter.model.signalquelle;

import java.util.Vector;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SignalQuelle implements Runnable {
	public static final int SINUS = 0, RECHTECK = 1;
	private int periode, mode;
	private Vector<ChannelListener> listenerVector = new Vector<ChannelListener>();
	private double freq = 1.0e3, amp = 1.0, samplingRate, time, dc;
	private ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

	public SignalQuelle(int samplingRate, int frameLaenge, ChannelListener listener) {
		this.samplingRate = samplingRate;
		periode = (int) (frameLaenge * 1e3 * 1.0 / samplingRate);
		addChannelListener(listener);
	}

	public void addChannelListener(ChannelListener listener) {
		listenerVector.add(listener);
	}

	public void removeChannelListener(ChannelListener listener) {
		listenerVector.remove(listener);
	}

	public void run() {
		double[] data = new double[2048];
		if (!listenerVector.isEmpty()) {
			for (int i = 0; i < data.length; i++) {
				if (mode == RECHTECK)
					data[i] = dc + amp * Math.signum(Math.sin(2 * Math.PI * freq * time));
				if (mode == SINUS)
					data[i] = dc + amp * Math.sin(2 * Math.PI * freq * time);
				time += 1.0 / samplingRate;
			}
			for (int i = 0; i < listenerVector.size(); i++) {
				listenerVector.elementAt(i).process(data);
			}
			if (time > 3600.0)
				time -= 3600.0;
		}
	}

	public void setParameters(int mode, double amp, double dc, double freq) {
		this.mode = mode;
		this.amp = amp;
		this.freq = freq;
		this.dc = dc;
	}

	public void start() {
		service.scheduleAtFixedRate(this, 100, (long) periode, TimeUnit.MILLISECONDS);
	}

	public void stop() {
		service.shutdownNow();
	}
}
