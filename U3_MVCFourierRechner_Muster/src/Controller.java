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

		this.model = model;

	}

	/**
	 * initiiert das Klassenobjekt view von aussen
	 * 
	 * @param view
	 */
	public void setView(View view) {
		trace.methodeCall();
		this.view = view;
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

		double amp = Double.parseDouble(view.parameterPanel.tfAmp.getText());
		double freq = Double.parseDouble(view.parameterPanel.tfFreq.getText());
		int nHarm = Integer.parseInt(view.parameterPanel.tfHarm.getText());
		String form = (String) view.parameterPanel.cbForm.getSelectedItem();

		model.berechne(amp, freq, nHarm, form, 620);
	}
}
