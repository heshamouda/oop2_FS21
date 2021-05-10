//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: 
//Vorname:

public class Controller {
	// 9
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
		// ~ 4
	}

	/**
	 * Setzt adaptives Filter zurück nach dem Parameter übernommen wurden ...
	 * 
	 * <pre>
	 * - Methode setParameter() aufrufen.
	 * - Entsprechende Methode des Models aufrufen.
	 * </pre>
	 * 
	 */
	public void resetFilter() {
		// 2
	}

	public void setView(View view) {
		this.view = view;
	}

	/**
	 * Ruft entsprechende Methode des Models auf ...
	 * 
	 * @param b
	 *            true: on, false: off
	 */
	public void setSignalOn(boolean b) {
		// 1
		model.setSignalOn(b);
	}

	/**
	 * Ruft entsprechende Methode des Models auf ...
	 * 
	 * @param b
	 *            true: on, false: off
	 */

	public void setStoererOn(boolean b) {
		// 1
		model.setStoererOn(b);
	}
}
