package inversmodel.gui;

import javax.swing.JOptionPane;

import inversmodel.model.Model;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: Muster
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
		this.model = model;
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
		double rechteckPegel = 0, rauschPegel = 0, schritttWeite = 0;

		try {
			rechteckPegel = Double.parseDouble(view.parameterPanel.tfRechteck.getText());

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(view, "!!!Fehleingabe!!!");
			view.parameterPanel.tfRechteck.requestFocus();
			view.parameterPanel.tfRechteck.setText("");
		}
		try {
			rauschPegel = Double.parseDouble(view.parameterPanel.tfRauschen.getText());

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(view, "!!!Fehleingabe!!!");
			view.parameterPanel.tfRauschen.requestFocus();
			view.parameterPanel.tfRauschen.setText("");
		}
		try {
			schritttWeite = Double.parseDouble(view.parameterPanel.tfSchrittWeite.getText());

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(view, "!!!Fehleingabe!!!");
			view.parameterPanel.tfSchrittWeite.requestFocus();
			view.parameterPanel.tfSchrittWeite.setText("");
		}

		model.setParameter(rechteckPegel, rauschPegel, schritttWeite);
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
		model.resetFilter();
	}

	/**
	 * - Entsprechende Methode des Models aufrufen.
	 * 
	 * @param rauschenOn
	 *            true: on, false: off
	 */
	// public void setSignalOn(boolean rauschenOn) {
	// // 1
	// model.setRauschenOn(rauschenOn);
	// }

	/**
	 * - Entsprechende Methode des Models aufrufen.
	 * 
	 * @param rechteckOn
	 *            true: on, false: off
	 */

	// public void setRechteckOn(boolean rechteckOn) {
	// // 1
	// model.setRechteckOn(rechteckOn);
	// }

	/**
	 * - Entsprechende Methode des Models aufrufen.
	 * 
	 * @param schrittOn
	 */
	public void setSchrittOn(boolean schrittOn) {
		// 1
		model.setSchrittOn(schrittOn);
	}

	public void setView(View view) {
		this.view = view;
	}

}
