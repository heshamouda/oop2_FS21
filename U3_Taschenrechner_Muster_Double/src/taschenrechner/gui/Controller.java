package taschenrechner.gui;

import taschenrechner.model.Model;
import util.TraceV5;

public class Controller {
	TraceV5 trace = new TraceV5(this);
	private Model model;
	private static final int ENTER = 0, ZAHL = 1, OPERATION = 2;
	private int zustand = ENTER;
	private int dotCnt = 1;

	public Controller(Model model) {
		trace.constructorCall();
		this.model = model;
	}

	/**
	 * <pre>
	 * - Ruft entsprechende Methode des models auf.
	 * - Setzt zustand auf OPERATION.
	 * </pre>
	 */
	public void add() {
		trace.methodeCall();
		model.add();
		zustand = OPERATION;
		dotCnt = 1;
	}

	/**
	 * <pre>
	 * - Ruft entsprechende Methode des models auf.
	 * - Setzt zustand auf OPERATION.
	 * </pre>
	 */
	public void subtract() {
		trace.methodeCall();
		model.subtract();
		zustand = OPERATION;
		dotCnt = 1;
	}

	/**
	 * <pre>
	 * - Ruft entsprechende Methode des models auf.
	 * - Setzt zustand auf OPERATION.
	 * </pre>
	 */
	public void multiply() {
		trace.methodeCall();
		model.multiply();
		zustand = OPERATION;
		dotCnt = 1;
	}

	/**
	 * <pre>
	 * - Ruft entsprechende Methode des models auf.
	 * - Setzt zustand auf OPERATION.
	 * </pre>
	 */
	public void divide() {
		trace.methodeCall();
		model.divide();
		zustand = OPERATION;
		dotCnt = 1;
	}

	/**
	 * <pre>
	 * - Ruft entsprechende Methode des models auf.
	 * - Setzt zustand auf ENTER.
	 * </pre>
	 */
	public void enter() {
		trace.methodeCall();
		model.enter();
		zustand = ENTER;
		dotCnt = 1;
	}

	/**
	 * <pre>
	 * Falls lastOp gleich ZAHL
	 * 		Value des Models mit 10 multiplizieren und neue Zahl i dazu addieren.
	 * 		Value des Models entsprechend setzen.
	 * Falls latsOP gleich OPERATION
	 * 		enter() des Objektes model aufrufen.
	 * 		Value des Models auf i setzen.
	 * Falls lastOp gleich ENTER
	 * 		Value des Models auf i setzen.
	 * </pre>
	 * 
	 * @param i
	 */
	public void number(int i) {
		trace.methodeCall();

		switch (zustand) {
		case ZAHL:
			if (dotCnt == 1) {
				model.setValue(model.getValue() * 10 + i);
			} else {
				dotCnt--;
				model.setValue(model.getValue() + i * Math.pow(10, dotCnt));
			}
			break;
		case OPERATION:
			model.enter();
			model.setValue(i);
			break;
		case ENTER:
			model.setValue(i);
			break;
		}
		zustand = ZAHL;
	}

	public void dot() {
		dotCnt = 0;
	}

}
