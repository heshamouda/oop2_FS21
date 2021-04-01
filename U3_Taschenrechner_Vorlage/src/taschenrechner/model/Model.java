package taschenrechner.model;

import util.Observable;
import util.TraceV4;

public class Model extends Observable {
	TraceV4 trace = new TraceV4(this);

	public Model() {
		trace.constructorCall();
	}

	public void add() {
		trace.methodeCall();

		setChanged();
		notifyObservers();
	}

	public int getValue() {
		trace.methodeCall();

		return 0;
	}

	public void subtract() {
		// TODO Auto-generated method stub
		
	}

}
