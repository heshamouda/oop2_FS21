//Name: Muster
//Vorname:
//Klasse:

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelSignalWahl extends JPanel implements ActionListener {
	// 16 Pte = 16 Pte
	private JRadioButton radioSinus, radioDreieck;
	private Controller controller;

	/**
	 * - Ist als GridBagLayout organisiert!
	 * - Setzt Border mit Titel " Wahl des Signals ".
	 * - Setzt Attribut controller entsprechend controller.
	 * - Erzeugt ButtonGroup und die beiden JRadioButton.
	 * - Registriert das Panel bei den RadioButton als ActionListener und fügt sie der Gruppe zu.
	 * - Setzt die RadioButton mittels add() aufs Panel.  
	 * - Fügt ein leeres JLabel, hinzu um den horizontalen Zuwachs aufzunehmen.
	 * 
	 * @param controller
	 */
	public PanelSignalWahl(Controller controller) {
		super(new GridBagLayout());
		// 12 Pte.
		setBorder(MyBorderFactory.createMyBorder(" Wahl des Signals "));
		this.controller = controller;
		ButtonGroup group = new ButtonGroup();
		radioSinus = new JRadioButton("Sinus", true);
		radioSinus.addActionListener(this);
		group.add(radioSinus);
		radioDreieck = new JRadioButton("Dreieck", false);
		radioDreieck.addActionListener(this);
		group.add(radioDreieck);

		add(radioSinus, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(10, 10, 10, 10), 0, 0));
		add(radioDreieck, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(10, 10, 10, 10), 0, 0));
		add(new JLabel(""), new GridBagConstraints(2, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

	}

	/**
	 * Ruft entsprechend der Quelle, setSignal() mit entsprechndem Signal - Argument aus Model beim controller auf.
	 */
	public void actionPerformed(ActionEvent e) {
		// 4 Pte
		if (e.getSource() == radioSinus) {
			controller.setSignal(Model.SINUS);
		}
		if (e.getSource() == radioDreieck) {
			controller.setSignal(Model.DREIECK);
		}
	}

}
