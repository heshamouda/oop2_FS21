// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
// Modulanlass:

package mailapp.gui;

import mailapp.model.Model;
import util.TraceV7;

public class Controller {
	private TraceV7 trace = new TraceV7(this);
	// 5
	private Model model;
	private View view;

	public Controller(Model model) {
		trace.constructorCall();
		this.model = model;
	}

	/**
	 * <pre>
	 * - Ruft die entsprechende Methode des Models mit dem Text des Separatoren-Textfeldes auf.
	 * - Ruft setEintraege() auf.
	 * </pre>
	 */
	public void setSeperators() {
		trace.methodeCall();
		// 2
	}

	/**
	 * <pre>
	 * - Ruft setTemplateDaten() des Models mit der entsprechenden Information aus den Textfeldern auf.
	 * </pre>
	 */
	public void buildMails() {
		trace.methodeCall();
		// 1
	}

	/**
	 * <pre>
	 * - Falls der Text der Text-Area des ListPanels nicht gleich "" ist:
	 *   - Holt den Text aus der Text-Area des ListPanels und trennt sie mittels .split("[\r\n]+") auf.
	 *   - Ruft damit setMailListe() des Models auf.
	 * </pre>
	 */
	public void setEintraege() {
		trace.methodeCall();
		// 2
	}

	public void setAlias(String[] alias) {
		trace.methodeCall();
		model.setAlias(alias);
	}

	public void setActiveMail(int i) {
		trace.methodeCall();
		model.setActiveMailIndex(i);
	}

	public void notifyObservers() {
		trace.methodeCall();
		model.notifyObservers();
	}

	public void sendMail() {
		trace.methodeCall();
		model.sendMail();
	}

	public void sendAllMails() {
		trace.methodeCall();
		model.sendAllMails();
	}

	public void setView(View view) {
		trace.methodeCall();
		this.view = view;
	}
}
