//Name: Muster
//Vorname:
//Klasse:

import java.awt.Color;

/**
 * Delegiert die entsprechenden Aufgaben an den Controller, resp. setzt die eigenen Attribute.
 *
 */
public class Controller {
	// 5 = 5
	private Model model;
	private TopView view;

	public Controller(Model model) {
		// 1
		this.model = model;
	}

	public void setTransformation(int transform) {
		// 1
		model.setTransform(transform);
	}

	public void setSignal(int form) {
		// 1
		model.setSignal(form);
	}

	public void setColor(Color color) {
		// 1
		view.panelTransformPlot.setColor(color);
	}

	public void setView(TopView view) {
		// 1
		this.view = view;
	}
}
