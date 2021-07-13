package multimeter.gui;
//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.

//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name:
//Vorname:

import java.awt.Color;

// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: Muster
// Vorname:
//

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import multimeter.MultimeterApplikation;
import multimeter.gui.goodies.BasicRadioButton;
import multimeter.model.Model;
import multimeter.resources.MyBorderFactory;

public class ModePanel extends JPanel implements ActionListener {
	// 19
	private static final long serialVersionUID = 1L;
	private String[] text = { "Volt AC", "Volt DC", "Volt Effektiv", "Frequenz" };
	private Controller controller;
	private BasicRadioButton[] button = new BasicRadioButton[4];
	private ButtonGroup btGroup = new ButtonGroup();

	/**
	 * <pre>
	 * - Baut mittels for-Schleife User-Interface gemäss Aufgabenstellung. 
	 * - Setzt bevorzugte Grösse auf 75% von MultimeterApplikation.appWidth und  35% von MultimeterApplikation.appHeight.
	 * </pre>
	 * 
	 * @param controller
	 */
	public ModePanel(Controller controller) {
		// 11
		super(new GridBagLayout());
		this.controller = controller;

		setBorder(MyBorderFactory.createMyBorder(" ModePanel "));
		setBackground(Color.gray);
		setPreferredSize(new Dimension((int) (0.75 * MultimeterApplikation.appWidth),
				(int) (0.35 * MultimeterApplikation.appHeight)));

		for (int i = 0; i < button.length; i++) {
			button[i] = new BasicRadioButton(text[i]);
			button[i].addActionListener(this);
			btGroup.add(button[i]);
			add(button[i], new GridBagConstraints(i, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0));
		}
		button[0].setSelected(true);
	}

	/**
	 * Entsprechend der Quelle setMode() des Controllers mit entsprechendem
	 * Argument (Model.MODE_ACV etc.) aufrufen.
	 */
	public void actionPerformed(ActionEvent e) {
		// 8
		if (e.getSource() == button[0])
			controller.setMode(Model.MODE_VAC);
		if (e.getSource() == button[1])
			controller.setMode(Model.MODE_VDC);
		if (e.getSource() == button[2])
			controller.setMode(Model.MODE_VEFF);
		if (e.getSource() == button[3])
			controller.setMode(Model.MODE_FREQ);
	}
}
