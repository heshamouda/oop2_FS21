package taschenrechner.gui;
import taschenrechner.model.Model;
import util.TraceV4;

public class Controller {
	TraceV4 trace = new TraceV4(this);
	private Model model;
	// Es gilt: ENTER ist 0, Zahl ist 1 etc.
	private static final int ENTER = 0, ZAHL = 1, OPERATION = 2;
	private int zustand = ENTER;

	public Controller(Model model) {
		trace.constructorCall();
		this.model = model;
	}

	public void add() {
		trace.methodeCall();
		model.add();
		zustand = OPERATION;
	}

	public void number(int i) {

		switch (zustand) {
		case ZAHL:
			// value aus Model holen mit 10 multiplizieren und i dazu addieren. Wert ins model setzen.
			break;
		case ENTER:
			// Wert i ins Model setzen.

			break;
		case OPERATION:
			// Methode enter() des Models aufrufen und den Wert i ins Model setzen.

			break;
		}
		zustand = ZAHL;
	}

	public void subtract() {

		model.subtract();
	}

}
