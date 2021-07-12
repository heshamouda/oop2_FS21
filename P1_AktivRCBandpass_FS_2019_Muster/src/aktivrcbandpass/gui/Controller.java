// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
// Modulanlass:

package aktivrcbandpass.gui;

import aktivrcbandpass.model.Model;
import util.TraceV7;

public class Controller {
	private TraceV7 trace = new TraceV7(this);
	// 14
	private Model model;
	private View view;

	public Controller(Model model) {
		trace.constructorCall();
		this.model = model;
	}

	public void setView(View view) {
		trace.methodeCall();
		this.view = view;
	}

	/**
	 * <pre>
	 * - Switch (actionCommand)
	 *   - Fall "Q": Text aus tfQ auslesen, in double wandeln und damit entsprechende Methode des Models aufrufen.
	 *   - Fall "F" resp. "R": Sinngemäss.
	 *   - Fall "C":
	 *     - Mittels der Methode .getValue().toString() den Text aus dem prefixSpinner auslesen.
	 *       - Fall "pF": Mittels .getValue().toString() den Text aus dem valueSpinner auslesen,
	 *         in eine double wandeln und mit 1e-12 multipliziert die entsprechende Methode im Model aufrufen.
	 *   - Fall "nF", "\u03BCF": Sinngemäss.
	 * - Ruft berechne() des Models auf.
	 * </pre>
	 * 
	 * @param actionCommand
	 */

	public void aktion1(String actionCommand) {
		trace.methodeCall();
		// 24
		switch (actionCommand) {
		case "Q":
			model.setQ(Double.parseDouble(view.inputPanel.tfQ.getText()));
			break;
		case "F":
			model.setFr(Double.parseDouble(view.inputPanel.tfF.getText()));
			break;
		case "R":
			model.setR(Double.parseDouble(view.inputPanel.tfR.getText()));
			break;
		case "C":
			switch (view.inputPanel.prefixSpinner.getValue().toString()) {
			case "pF":
				model.setC(Double.parseDouble(view.inputPanel.valueSpinner.getValue().toString()) * 1e-12);
				break;
			case "nF":
				model.setC(Double.parseDouble(view.inputPanel.valueSpinner.getValue().toString()) * 1e-9);
				break;
			case "\u03BCF":
				model.setC(Double.parseDouble(view.inputPanel.valueSpinner.getValue().toString()) * 1e-6);
				break;
			}
		}
		model.berechne();
	}

	/**
	 * <pre>
	 * Hinweis: Die gewählte Zeichenkette kann mittels xyzSpinner.getValue().toString() aus einem Spinner 
	 *          ausgelesen werden.
	 * 
	 * - Dieser Methode kommt die Aufgabe zu, entsprechend der Zeichenkette actionCommand ("Q", "F", "R", oder "C") 
	 *   die richtige Setter-Methode des Models, mit dem entsprechenden Wert aufzurufen. 
	 *   
	 * - Wenn das actionCommand ein "C" ist, muss je nach Prefix-Spinner Wahl, der Zahlenwert im C-Textfeld mit 1e-12 ... 1e-6 multipliziert werden, 
	 *   bevor die Setter-Methode des Models aufgerufen wird.
	 *   
	 * - Der Code kann Wahlweise mit Switch-Anweisungen oder mit if-Anweisungen programmiert werden.
	 *    
	 * - Ruft zum Schluss die Methode berechne() des Models auf.
	 * </pre>
	 * 
	 * @param actionCommand
	 */

	public void aktion(String actionCommand) {
		trace.methodeCall();
		// 14

		if (actionCommand.equals("Q")) {
			model.setQ(Double.parseDouble(view.inputPanel.tfQ.getText()));
		}
		if (actionCommand.equals("F")) {
			model.setFr(Double.parseDouble(view.inputPanel.tfF.getText()));
		}
		if (actionCommand.equals("R")) {
			model.setR(Double.parseDouble(view.inputPanel.tfR.getText()));
		}
		if (actionCommand.equals("C")) {
			if (view.inputPanel.prefixSpinner.getValue().toString().equals("pF")) {
				model.setC(Double.parseDouble(view.inputPanel.valueSpinner.getValue().toString()) * 1e-12);
			}
			if (view.inputPanel.prefixSpinner.getValue().toString().equals("nF")) {
				model.setC(Double.parseDouble(view.inputPanel.valueSpinner.getValue().toString()) * 1e-9);
			}
			if (view.inputPanel.prefixSpinner.getValue().toString().equals("\u03BCF")) {
				model.setC(Double.parseDouble(view.inputPanel.valueSpinner.getValue().toString()) * 1e-6);
			}
		}

		model.berechne();
	}
}
