package multimeter.gui;
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.

// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import multimeter.model.Model;

public class Controller implements ActionListener {
	// 18
	private Model model;
	private View view;
	private PrintWriter logWriter;
	private javax.swing.Timer timer;

	/**
	 * <pre>
	 * - Erzeugt und startet Swing-Timer javax.swing.Timer(), so dass alle 333 ms
	 *   mittels ActionListener ein Display-Update resultiert. 
	 * - Setzt entsprechendes Attribut.
	 * - Startet den Timer.
	 * </pre>
	 * 
	 * @param model
	 */
	public Controller(Model mdl) {
		// 3
		this.model = mdl;
		timer = new javax.swing.Timer(333, this);
		timer.start();
	}

	/**
	 * - Setzt entsprechendes Attribut.
	 * 
	 * @param view
	 */
	public void setView(View view) {
		// 1
		this.view = view;
	}

	/**
	 * <pre>
	 * - Ruft setMode() des Models auf
	 * - Ruft vom DisplayPanel auf der View setUnit() mit mode auf.
	 * </pre>
	 * 
	 * @param mode
	 */
	public void setMode(int mode) {
		// 2
		model.setMode(mode);
		view.displayPanel.setUnit(mode);
	}

	/**
	 * <pre>
	 * - Ruft notifyObservers() des Models auf.
	 *  
	 * Challenge:
	 * - Falls logWriter nicht gleich null ist, wird der aktuelle Value des 
	 *   Models dem logwriter mittels println() als neue Zeile hinzugefügt.
	 * </pre>
	 */
	public void updateDisplay() {
		// 1 + 2
		model.notifyObservers();
		if (logWriter != null) {
			logWriter.println("" + model.getValue());
		}
	}

	/**
	 * <pre>
	 * Challenge:
	 * - Stoppt mittels stopLogging() eine allfällige Aufzeichnung.
	 * - Erzeugt neuen PrintWriter mit gegebener Datei.
	 * </pre>
	 * 
	 * @param fileName
	 */
	public void startLogging(String fileName) {
		// 4
		stopLogging();
		try {
			logWriter = new PrintWriter(new FileWriter(fileName, false));
		} catch (IOException exc) {
			System.err.println("Dateifehler!");
		}
	}

	/**
	 * <pre>
	 * Challenge:
	 * - Schliesst, falls logWriter nicht null, den logWriter und setzt ihn null.
	 * </pre>
	 */
	public void stopLogging() {
		// 3
		if (logWriter != null) {
			logWriter.close();
		}
		logWriter = null;
	}

	/**
	 * - Rufte entsprechende Methode des Models auf.
	 * 
	 * @param signalMode
	 * @param amp
	 * @param dc
	 * @param freq
	 */
	public void setParameters(int signalMode, double amp, double dc, double freq) {
		// 1
		model.setParameters(signalMode, amp, dc, freq);
	}

	/**
	 * - Ruft updateDisplay() auf.
	 * 
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// 1
		updateDisplay();
	}
}
