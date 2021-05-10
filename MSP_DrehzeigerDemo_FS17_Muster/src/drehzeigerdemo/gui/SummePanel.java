package drehzeigerdemo.gui;

import java.util.Observable;

import org.apache.commons.math3.complex.Complex;

import drehzeigerdemo.gui.goodies.ZeigerPlot;
import drehzeigerdemo.model.Model;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: Muster
//Vorname:

public class SummePanel extends ZeigerPlot {
	// 3
	private static final long serialVersionUID = 1L;

	/**
	 * <pre>
	 * - Wandelt Observable obs in Model model.
	 * - Holt die Drehzeiger aus dem Model und speichert sie in lokale Var. drehZeiger.
	 * - Ruft mit drehZeiger setData() auf.
	 * </pre>
	 * 
	 * @param obs
	 * @param obj
	 */
	public void update(Observable obs, Object obj) {
		// 3
		Model model = (Model) obs;
		Complex[] drehZeiger = model.getDrehZeiger();
		setData(drehZeiger);
	}
}
