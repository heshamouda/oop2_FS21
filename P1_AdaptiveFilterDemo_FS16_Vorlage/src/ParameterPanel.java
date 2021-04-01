import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	// 13 + 3
	static final long serialVersionUID = 1L;
	private Controller controller;
	public JTextField tfSignal;
	public JTextField tfStoerer;
	public JTextField tfSchritt;

	/**
	 * Baut GUI zur Eingabe der Parameter ...
	 * 
	 * <pre>
	 * - Setzt entsprechendes Attribut.
	 * - Baut das GUI gemäss Aufgabenstellung.
	 * </pre>
	 * 
	 * @param controller
	 *            Referenz des Controllers.
	 */
	public ParameterPanel(Controller controller) {
		// ~ 12
	}

	@Override
	/**
	 * <pre>
	 * - Entsprechende Methode des Controllers aufrufen.
	 * </pre>
	 */
	public void actionPerformed(ActionEvent e) {
		// 1
	}
}
