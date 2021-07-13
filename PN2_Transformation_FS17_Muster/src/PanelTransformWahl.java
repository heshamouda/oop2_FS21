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

public class PanelTransformWahl extends JPanel implements ActionListener {
	// 12 + 4 = 16 Pte
	private JRadioButton radioFourier, radioHadamard;
	private Controller controller;

	/**
	 * - Ist als GridBagLayout organisiert!
	 * - Setzt Border mit Titel " Wahl der Transformation ".
	 * - Setzt Attribut controller entsprechend controller.
	 * - Erzeugt ButtonGroup und die beiden JRadioButton, registriert das Panel bei den RadioButton als 
	 * 	 ActionListener und fügt sie der Group zu.
	 * - Setzt die RadioButton mittels add() aufs Panel.  
	 * - Fügt ein leeres JLabel hinzu um den vertikalen Zuwachs aufzunehmen.
	 * 
	 * @param controller
	 */
	public PanelTransformWahl(Controller controller) {
		super(new GridBagLayout());
		// 12 Pte
		setBorder(MyBorderFactory.createMyBorder(" Wahl der Transformation "));
		this.controller = controller;
		ButtonGroup group = new ButtonGroup();
		radioFourier = new JRadioButton("Fourier - Transformation", true);
		radioFourier.addActionListener(this);
		group.add(radioFourier);
		radioHadamard = new JRadioButton("Hadamard - Transformation", false);
		radioHadamard.addActionListener(this);
		group.add(radioHadamard);

		add(radioFourier, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(radioHadamard, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(new JLabel(""), new GridBagConstraints(0, 2, 1, 1, 0.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.VERTICAL, new Insets(10, 10, 10, 10), 0, 0));

	}

	/**
	 * Ruft entsprechend der Quelle, setTransformation() mit entsprechndem Transform - Argument aus Model beim controller auf.
	 */
	public void actionPerformed(ActionEvent e) {
		// 4 Pte
		if (e.getSource() == radioFourier) {
			controller.setTransformation(Model.FOURIER);
		}
		if (e.getSource() == radioHadamard) {
			controller.setTransformation(Model.HADAMARD);
		}
	}

}
