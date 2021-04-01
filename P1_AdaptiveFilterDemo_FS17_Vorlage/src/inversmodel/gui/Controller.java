package inversmodel.gui;

import javax.swing.JOptionPane;

import inversmodel.model.Model;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: 
//Vorname:

public class Controller {
	// 8
	private Model model;
	private View view;

	/**
	 * Baut den Controller ...
	 * 
	 * <pre>
	 * - Entsprechendes Attribut setzen.
	 * </pre>
	 * 
	 * @param model
	 *            Referenz des Models.
	 */
	public Controller(Model model) {
		// 1
	}

	/**
	 * Liest Parameter aus dem GUI aus, wandelt sie und gibt sie ans Model
	 * weiter ...
	 * 
	 * <pre>
	 * - Werte aus GUI auslesen und wandeln.
	 * - Entsprechende Methode des Models aufrufen.
	 * </pre>
	 * 
	 */
	public void setParameter() {
		// 4
	}

	/**
	 * Setzt adaptives Filter zurück nach dem Parameter übernommen wurden ...
	 * 
	 * <pre>
	 * - Entsprechende Methode des Models aufrufen.
	 * </pre>
	 * 
	 */
	public void resetFilter() {
		// 2
	}


	/**
	 * - Entsprechende Methode des Models aufrufen.
	 * 
	 * @param schrittOn
	 */
	public void setSchrittOn(boolean schrittOn) {
		// 1
	}

	public void setView(View view) {
		this.view = view;
	}

}
