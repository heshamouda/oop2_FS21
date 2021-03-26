package gui;
import model.Model;
import util.TraceV3;

public class Controller {
	private TraceV3 trace = new TraceV3(this);
	private Model model;
	private View view;

	/**
	 * <pre>
	 * - setzt Attribut der Klasse
	 * </pre>
	 */
	public Controller(Model model) {
		trace.constructorCall();
		
	}

	/**
	 * <pre>
	 * - setzt Attribut der Klasse
	 * </pre>
	 */
	public void setView(View view) {
		trace.methodeCall();
		
	}

	/**
	 * <pre>
	 * - ruft bercheneNote(...) mit den passenden Parametern aus der View auf
	 * </pre>
	 */
	public void btBerechne() {
		trace.methodeCall();
		
		
	}

	/**
	 * <pre>
	 * - macht ein Reset auf die Defaultwerte
	 *    AnzahlPunkte:8
	 *    MaxPunkte:12
	 * </pre>
	 */
	public void btReset() {
		trace.methodeCall();
	
		
	}
}
