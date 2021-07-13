// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiderhandlung die Note 1 erteilt wird.
//
// Name:Ouda
// Vorname:Hesham
//
import java.io.IOException;

public class Controller {

	private final Model model;
	private View view;

	public Controller(Model model) {
		this.model = model;
	}

	/**
	 * <pre>
	 * - setzt Attribut
	 * - laedt Countries mittels Methode aus Model
	 * - generiert Fragen mittels Methode aus Model
	 * </pre>
	 */
	public void setView(View view) {
		this.view = view;
		try {
			model.loadCountries();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		model.generateQuestion();
		
	}

	/**
	 * <pre>
	 * - ruft passende Modelmethode auf
	 * </pre>
	 */
	void answered(int i) {
		model.answered(i);
		
	}
}
