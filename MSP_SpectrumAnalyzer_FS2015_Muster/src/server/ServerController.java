package server;

public class ServerController {

	private ServerModel model;

	public ServerController(ServerModel model) {
		this.model = model;
	}

	public void setResolution(short resolution) {
		model.setResolution(resolution);
	}

	public void setView(ServerView view) {
	}

	public void setAmplitude(double amplitude) {
		model.setAmplitude(amplitude);
	}

	public void setForm(String form) {
		model.setForm(form);
	}

	public void setFrequency(double frequency) {
		model.setFrequency(frequency);
	}

}
