package taschenrechner.model;

import util.Observable;
import util.TraceV5;

public class Model extends Observable {
	TraceV5 trace = new TraceV5(this);
	private int[] stack = new int[4];

	public Model() {
		trace.constructorCall();
	}

	/**
	 * <pre>
	 * - Setzt stack[0] gleich stack[0] + stack[1].
	 * - Ruft pull() auf.
	 * - Notifiziert Observer.
	 * </pre>
	 */
	public void add() {
		trace.methodeCall();
		stack[0] = stack[0] + stack[1];
		pull();
		notifyObservers();
	}

	/**
	 * <pre>
	 * - Setzt stack[0] gleich stack[0] - stack[1].
	 * - Ruft pull() auf.
	 * - Notifiziert Observer.
	 * </pre>
	 */
	public void subtract() {
		trace.methodeCall();
		stack[0] = stack[1] - stack[0];
		pull();
		notifyObservers();
	}

	/**
	 * <pre>
	 * - Setzt stack[0] gleich stack[0] / stack[1].
	 * - Ruft pull() auf.
	 * - Notifiziert Observer.
	 * </pre>
	 */
	public void divide() {
		trace.methodeCall();

		stack[0] = stack[1] / stack[0];
		pull();
		notifyObservers();
	}

	/**
	 * <pre>
	 * - Setzt stack[0] gleich stack[0] * stack[1].
	 * - Ruft pull() auf.
	 * - Notifiziert Observer.
	 * </pre>
	 */
	public void multiply() {
		trace.methodeCall();
		stack[0] = stack[0] * stack[1];
		pull();
		notifyObservers();
	}

	/**
	 * <pre>
	 * - Ruft push() auf.
	 * </pre>
	 */
	public void enter() {
		trace.methodeCall();
		push();
	}

	/**
	 * <pre>
	 * - Setzt stack[0] gleich value
	 * - Notifiziert Observer.
	 * </pre>
	 * 
	 * @param value
	 */
	public void setValue(int value) {
		trace.methodeCall();
		stack[0] = value;
		notifyObservers();
	}

	/**
	 * <pre>
	 * - Gibt den Wert von stack[0] zurück.
	 * </pre>
	 * 
	 * @return
	 */
	public int getValue() {
		trace.methodeCall();
		return stack[0];
	}

	/**
	 * <pre>
	 * - Alle Werte im stack ab 2 um eins nach unten kopieren.
	 * - Zu oberst eine Null einfüllen.
	 * </pre>
	 */
	private void pull() {
		trace.methodeCall();
		for (int i = 1; i < stack.length - 1; i++) {
			stack[i] = stack[i + 1];
		}
		stack[stack.length - 1] = 0;
	}

	/**
	 * <pre>
	 * - Alle Werte im stack um eins nach oben kopieren.
	 * - Den untersten Wert belassen.
	 * </pre>
	 */
	private void push() {
		trace.methodeCall();
		for (int i = stack.length - 1; i > 0; i--) {
			stack[i] = stack[i - 1];
		}
		notifyObservers();
	}

	/**
	 * <pre>
	 * - Zeichenkette mit Inhalt des Stacks zurückgeben.
	 * </pre>
	 * 
	 * @return
	 */
	public String getStackInfo() {
		trace.methodeCall();
		String s = "";
		for (int i = stack.length - 1; i >= 0; i--) {
			s += "" + stack[i] + "\n";
		}
		return s;
	}

	/**
	 * <pre>
	 * - setChanged() aufrufen.
	 * - notifyObservers() der Super-Klasse aufrufen.
	 * </pre>
	 */
	public void notifyObservers() {
		trace.methodeCall();
		setChanged();
		super.notifyObservers();
	}
}
