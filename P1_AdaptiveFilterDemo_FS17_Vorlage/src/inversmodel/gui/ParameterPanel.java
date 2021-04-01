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

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: 
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
	}
}
