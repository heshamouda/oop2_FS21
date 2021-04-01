package ch.fhnw.eit.oop2.wavegenerator.gui;
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
//

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

import ch.fhnw.eit.oop2.wavegenerator.model.Model;
import ch.fhnw.eit.oop2.wavegenerator.tools.MyBorderFactory;

public class InputPanel extends JPanel implements ActionListener {
	// 41
	private static final long serialVersionUID = 1L;
	private static final int AMPLITUDE = 0, FREQUENCY = 1;

	private JButton[] jbtInput = new JButton[12];
	private String[] stInput = { "7", "8", "9", "4", "5", "6", "1", "2", "3",
			"Clear", "0", "Enter" };
	private JTextField jtfNumber = new JTextField();
	private JPanel jpNumField = new JPanel(new GridLayout(4, 3, 10, 10));
	private JToggleButton jtbAmplitude = new JToggleButton("Amplitude");
	private JToggleButton jtbFrequency = new JToggleButton("Frequenz");
	private ButtonGroup btGroup = new ButtonGroup();

	private int inputMode = AMPLITUDE;

	private Controller controller;

	/**
	 * <pre>
	 * - Setzt Attribut des Controllers.
	 * - Baut User-Interface gemäss Beschreibung in der Aufagbestellung.
	 * 
	 * </pre>
	 * 
	 * @param controller
	 * @param model
	 */
	public InputPanel(Controller controller, Model model) {
		// 19
		super(new GridBagLayout());
		this.controller = controller;
		setBorder(MyBorderFactory.createMyBorder("  Input    "));

		jtfNumber.setEditable(false);
		btGroup.add(jtbAmplitude);
		btGroup.add(jtbFrequency);
		jtbAmplitude.setSelected(true);

		jtbAmplitude.addActionListener(this);
		jtbFrequency.addActionListener(this);

		for (int i = 0; i < jbtInput.length; i++) {
			jbtInput[i] = new JButton(stInput[i]);
			jpNumField.add(jbtInput[i]);
			jbtInput[i].addActionListener(this);
		}

		add(jtfNumber, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));
		add(jpNumField, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
						5, 5, 5, 5), 0, 0));
		add(jtbAmplitude, new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));
		add(jtbFrequency, new GridBagConstraints(0, 3, 1, 1, 1.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));
		add(new JLabel(), new GridBagConstraints(0, 4, 1, 1, 0.0, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(5, 5, 5, 5), 0, 0));

		jtfNumber.setText("0");
	}

	/**
	 * <pre>
	 * - Falls Quelle jtbAmplitude: inputMode gleich AMPLITUDE, Text in Feld gleich 0, Einheit durch Aufruf der Methode im Controller auf DigitDisplay.VPP stellen, return.
	 * - Falls Quelle jtbFrequency: inputMode gleich FREQUENCY, Text in Feld gleich 0, Einheit durch Aufruf der Methode im Controller auf DigitDisplay.KHZ stellen, return.
	 * - Falls Quelle "Clear": Text in TextFeld gleich 0, return.
	 * - Falls Quelle "Enter":
	 *   - Falls inputMode gleich AMPLITUDE:
	 *     - Entsprechende Methode des Controllers mit Zahlen - Wert in TextFeld aufrufen.
	 *   - Sonst: 
	 *     - Entsprechende Methode des Controllers mit Zahlen - Wert in TextFeld aufrufen.
	 *   - Text in TextFeld gleich 0, return.
	 * - Zahl in TextFeld gleich 10 mal Zahl in TextFeld plus gedrückte Zahl setzen.
	 * </pre>
	 */
	public void actionPerformed(ActionEvent e) {
		// 22
		if (e.getSource() == jtbAmplitude) {
			inputMode = AMPLITUDE;
			jtfNumber.setText("0");
			controller.setUnit(DigitDisplay.VPP);
			return;
		}
		if (e.getSource() == jtbFrequency) {
			inputMode = FREQUENCY;
			jtfNumber.setText("0");
			controller.setUnit(DigitDisplay.KHZ);
			return;
		}
		if (e.getSource() == jbtInput[9]) {
			jtfNumber.setText("0");
			return;
		}
		if (e.getSource() == jbtInput[11]) {
			if (inputMode == AMPLITUDE) {
				controller.setAmplitude(Integer.parseInt(jtfNumber.getText()));
			} else {
				controller.setFrequency(Integer.parseInt(jtfNumber.getText()));
			}
			jtfNumber.setText("0");
			return;
		}
		int val = Integer.parseInt(((JButton) (e.getSource())).getText());
		jtfNumber.setText(""
				+ (10 * Integer.parseInt(jtfNumber.getText()) + val));
	}
}
