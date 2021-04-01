package modem.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import resources.MyBorderFactory;

// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiderhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:

public class ParameterPanel extends JPanel implements ActionListener {
	// 35
	static final long serialVersionUID = 1L;
	private Controller controller;

	public JComboBox<?> cbKanalLaenge = new JComboBox<Object>(new String[] { "100", "200", "300" });

	public JTextField tfAWGNAmplitude = new JTextField("0.05");
	public JTextField tfTonAmplitude = new JTextField("0.0");
	public JTextField tfTonFrequenz = new JTextField("5e6");
	public JTextField tfSchrittFF = new JTextField("1e-5");
	public JTextField tfSchrittFB = new JTextField("1e-4");

	private JButton btReset = new JButton("Reset Equalizer");

	/**
	 * <pre>
	 * - Baut das GUI gemäß Aufgabenstellung.
	 * - Setzt allfällige Attribute.
 	 * - Setzt die bevorzugte Grösse auf 50% von AdaptiveModemDemo.appWidth und 45% von AdaptiveModemDemo.appHeight
	 * </pre>
	 * 
	 * @param controller
	 * 
	 */
	public ParameterPanel(Controller controller) {
		// 31
	}

	@Override
	/**
	 * <pre>
	 * - Falls Quelle des Ereignisses gleich btReset:
	 *   - Entsprechende Methode des Controllers aufrufen.
	 * - Sonst:
	 *   - setParameter() des Controllers aufrufen.
	 * </pre>
	 */
	public void actionPerformed(ActionEvent e) {
		// 4
	}
}
