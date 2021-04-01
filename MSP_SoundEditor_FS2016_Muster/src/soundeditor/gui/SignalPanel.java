package soundeditor.gui;
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.

// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: MUSTER
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
import tools.MyBorderFactory;

public class SignalPanel extends JPanel implements ActionListener {
	// 12
	private static final long serialVersionUID = 1L;
	private SignalPlot signalPlot = new SignalPlot();
	private JButton jbPlay = new JButton("Play");
	private JButton jbStop = new JButton("Stop");
	private Controller controller;

	/**
	 * - Baut das User-Interface gemäss Aufgabenstellung.
	 * 
	 * <pre>
	 * - Der Signal-Plot wächst in beide Richtungen.
	 * - Der  Play-Button und der Stop-Button wachsen nicht.
	 * - Vergessen Sie Attribut und Border nicht zu setzen.
	 * </pre>
	 * 
	 * @param controller
	 */
	public SignalPanel(Controller controller) {
		super(new GridBagLayout());
		// 7
		this.controller = controller;
		setBorder(MyBorderFactory.createMyBorder(" Signal "));

		add(signalPlot, new GridBagConstraints(0, 0, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 0, 0, 0), 0, 0));

		jbPlay.addActionListener(this);
		add(jbPlay, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));

		jbStop.addActionListener(this);
		add(jbStop, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(0, 0, 0, 0), 0, 0));
	}

	/**
	 * Ruft die zum Button zugehörige Funktion des Controllers auf.
	 */
	public void actionPerformed(ActionEvent e) {
		// 4
		if (e.getSource() == jbPlay) {
			controller.startPlayer();
		}
		if (e.getSource() == jbStop) {
			controller.stopPlayer();
		}
	}

	/**
	 * Ruft update() von signalPlot auf.
	 * 
	 * @param obs
	 * @param obj
	 */
	public void update(Observable obs, Object obj) {
		// 1
		signalPlot.update(obs, obj);
	}
}
