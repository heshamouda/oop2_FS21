import util.TraceV4;

public class Controller {
	private TraceV4 trace = new TraceV4(this);
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
	 * initiiert das Klassenobjekt view von aussen
	 * 
	 * @param view
	 */
	public void setView(View view) {
		trace.methodeCall();

	}

	/**
	 * <pre>
	 * - reagiert auf Actions aus der View und leitet es ans Modell weiter 
	 * - ruft die model.berechne(..) mit den aktuelle Parametern aus der view und N=620 auf
	 * Hinweis:Um die Signalform auszulesen, kann das Item der ComboBox zu einem String gecastet werden
	 * </pre>
	 */
	public void btBerechne() {
		trace.methodeCall();

	}
}
