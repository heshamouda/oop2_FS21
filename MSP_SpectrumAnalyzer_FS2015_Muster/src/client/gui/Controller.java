package client.gui;

import client.model.Model;

// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
// 
// Name: Muster
// Vorname:

public class Controller {
	// 5
	private Model model;

	/**
	 *<pre>
	 *- Setzt entsprechendes Attribut.
	 *</pre>
	 * @param model
	 */
	public Controller(Model model) {
		this.model = model;
	}

	/**
	 *<pre>
	 *	- Ruft entsprechende Methode im Model auf.
	 *</pre>
	 * @param length
	 */
	public void setBufferLength(int length) {
		model.setBufferLength(length);
	}

	/**
	 *<pre>
	 *	- Ruft entsprechende Methode im Model auf.
	 *</pre>
	 * @param left
	 */
	public void setLineMarkerLeft(double left) {
		model.setLineMarkerLeft(left);
	}

	/**
	 *<pre>
	 *	- Ruft entsprechende Methode im Model auf.
	 *</pre>
	 * @param left
	 */
	public void setLineMarkerRight(double left) {
		model.setLineMarkerRight(left);
	}

	/**
	 *<pre>
	 *	- Ruft entsprechende Methode im Model auf.
	 *</pre>
	 * @param windowType
	 */
	public void setWindowType(String windowType) {
		model.setWindowType(windowType);
	}

}
