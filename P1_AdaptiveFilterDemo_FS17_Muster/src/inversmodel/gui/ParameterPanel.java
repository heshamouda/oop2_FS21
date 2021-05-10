package inversmodel.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import inversmodel.InverseModelDemo;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: Muster
//Vorname:

public class ParameterPanel extends JPanel implements ActionListener {
	// 29
	static final long serialVersionUID = 1L;
	public JTextField tfRauschen = new JTextField("0.5");
	public JTextField tfRechteck = new JTextField("1.0");
	public JTextField tfSchrittWeite = new JTextField("0.0005");
	private JCheckBox cbSchrittWeite = new JCheckBox("");
	private JButton btReset = new JButton("Reset Equalizer");
	private Controller controller;

	/**
	 * Baut GUI zur Eingabe der Parameter ...
	 * 
	 * <pre>
	 * - Setzt entsprechendes Attribut.
	 * - Setzt die bevorzugte grösse mittels setPreferredSize() auf 50% von 
	 *   InverseModelDemo.appWidth und  40% von InverseModelDemo.appHeight.
	 * - Baut das GUI gemäss Aufgabenstellung.
	 * - Bei den Textfeldern die Textausrichtung mittels setHorizontalAlignment()
	 *   auf SwingConstants.RIGHT setzen.
	 * - Die Checkbox mittels setSelected() als gewählt setzen.
	 * </pre>
	 * 
	 * @param controller
	 *            Referenz des Controllers.
	 */
	public ParameterPanel(Controller controller) {
		// 21
		super(new GridBagLayout());
		this.controller = controller;

		setPreferredSize(
				new Dimension((int) (0.5 * InverseModelDemo.appWidth), (int) (0.4 * InverseModelDemo.appHeight)));

		add(new JLabel("Rauschsignal: "), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		tfRauschen.setHorizontalAlignment(SwingConstants.RIGHT);
		tfRauschen.addActionListener(this);
		add(tfRauschen, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel("Rechtecksignal: "), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		tfRechteck.setHorizontalAlignment(SwingConstants.RIGHT);
		tfRechteck.addActionListener(this);
		add(tfRechteck, new GridBagConstraints(0, 3, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel("Schrittweite: "), new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		tfSchrittWeite.setHorizontalAlignment(SwingConstants.RIGHT);
		tfSchrittWeite.addActionListener(this);
		add(tfSchrittWeite, new GridBagConstraints(0, 5, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		cbSchrittWeite.addActionListener(this);
		cbSchrittWeite.setSelected(true);
		add(cbSchrittWeite, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		btReset.addActionListener(this);
		add(btReset, new GridBagConstraints(0, 6, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel(""), new GridBagConstraints(0, 7, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	}

	@Override
	/**
	 * <pre>
	 * - Methode setParameter() des Controllers aufrufen. 
	 * - Falls Quelle des Ereignisses gleich Reset - Button
	 *   - Entsprechende Methode des Controllers aufrufen.
	 * - Falls Quelle des Ereignisses gleich der Checkbox:
	 *   - Falls die Checkbox isSelected():
	 *     - Entsprechende Methode des Controllers mit wahr aufrufen.
	 *   - Sonst:
	 *     - Entsprechende Methode des Controllers mit unwahr aufrufen.
	 * </pre>
	 */
	public void actionPerformed(ActionEvent e) {
		// 8
		controller.setParameter();

		if (e.getSource() == btReset) {
			controller.resetFilter();
		}
		if (e.getSource() == cbSchrittWeite) {
			if (cbSchrittWeite.isSelected())
				controller.setSchrittOn(true);
			else
				controller.setSchrittOn(false);
		}
	}
}
