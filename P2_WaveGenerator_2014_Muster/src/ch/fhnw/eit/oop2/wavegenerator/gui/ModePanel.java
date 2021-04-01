package ch.fhnw.eit.oop2.wavegenerator.gui;
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
//

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import ch.fhnw.eit.oop2.wavegenerator.model.Model;
import ch.fhnw.eit.oop2.wavegenerator.tools.MyBorderFactory;

public class ModePanel extends JPanel implements ActionListener {
	// 19
	private static final long serialVersionUID = 1L;
	private JToggleButton jtbSine = new JToggleButton("Sinus");
	private JToggleButton jtbSquare = new JToggleButton("Rechteck");
	private JToggleButton jtbRamp = new JToggleButton("Sägezahn");
	private ButtonGroup group = new ButtonGroup();
	private Controller controller;

	/**
	 * <pre>
	 * - Setzt Attribut des Controllers.
	 * - Baut User-Interface gemäss Beschreibung in der Aufagbestellung.
	 * </pre>
	 * 
	 * @param controller
	 */
	public ModePanel(Controller controller) {
		// 13
		super(new GridLayout(1, 3, 10, 10));
		this.controller = controller;

		setBorder(MyBorderFactory.createMyBorder("  Mode     "));

		group.add(jtbSine);
		group.add(jtbSquare);
		group.add(jtbRamp);
		jtbSine.setSelected(true);

		jtbSine.addActionListener(this);
		jtbSquare.addActionListener(this);
		jtbRamp.addActionListener(this);

		add(jtbSine);
		add(jtbSquare);
		add(jtbRamp);
	}

	/**
	 * <pre>
	 * - Erlaubt die Wahl der WaveForm und ruft dazu je nach Ereignis die Methode, mit entsprechendem Argumt, in Controller auf.
	 * </pre>
	 */
	public void actionPerformed(ActionEvent e) {
		// 6
		if (e.getSource() == jtbSine) {
			controller.setWaveForm(Model.SINE);
		}
		if (e.getSource() == jtbSquare) {
			controller.setWaveForm(Model.SQUARE);
		}
		if (e.getSource() == jtbRamp) {
			controller.setWaveForm(Model.RAMP);
		}
	}
}
