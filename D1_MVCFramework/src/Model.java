

public class Model extends Observable {
	private TraceV8 trace = new TraceV8(this);
	private String data = "";

	public Model() {
		trace.constructorCall();
	}

	public void setData(String data) {
		trace.methodeCall();
		this.data = data.toUpperCase();
		notifyObservers();
	}

	public String getData() {
		trace.methodeCall();
		return data;
	}

	public void notifyObservers() {
		trace.methodeCall();
		setChanged();
		super.notifyObservers();
	}
}