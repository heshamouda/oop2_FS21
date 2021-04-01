package soundeditor.gui;

// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
// Klasse:
//

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JPanel;

import soundeditor.gui.goodies.SignalPlot;

public class SignalPanel extends JPanel implements ActionListener {
	// 12
	private static final long serialVersionUID = 1L;
	private SignalPlot signalPlot = new SignalPlot();
	private JButton jbPlay = new JButton("Play");
	private JButton jbStop = new JButton("Stop");
	private Controller controller;

	/**
	 * - Baut das User-Interface gem�ss Aufgabenstellung.
	 * 
	 * <pre>
	 * - Der Signal-Plot w�chst in beide Richtungen.
	 * - Der  Play-Button und der Stop-Button wachsen nicht.
	 * - Vergessen Sie Attribut und Border nicht zu setzen.
	 * </pre>
	 * 
	 * @param controller
	 */
	public SignalPanel(Controller controller) {
		super(new GridBagLayout());
		// 7
	}

	/**
	 * Ruft die zum Button zugeh�rige Funktion des Controllers auf.
	 */
	public void actionPerformed(ActionEvent e) {
		// 4
	}

	/**
	 * Ruft update() von signalPlot auf.
	 * 
	 * @param obs
	 * @param obj
	 */
	public void update(Observable obs, Object obj) {
		// 1
	}
}
