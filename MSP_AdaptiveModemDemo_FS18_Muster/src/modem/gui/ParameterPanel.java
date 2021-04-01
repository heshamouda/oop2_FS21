package modem.gui;

import java.awt.Dimension;
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

import modem.AdaptiveModemDemo;
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
	 * - Setzt die Bevorzugte Grösse auf 50% von AdaptiveModemDemo.appWidth und 45% von AdaptiveModemDemo.appHeight
	 * </pre>
	 * 
	 * @param controller
	 * 
	 */
	public ParameterPanel(Controller controller) {
		// 31
		super(new GridBagLayout());
		this.controller = controller;
		setBorder(MyBorderFactory.createMyBorder(" Parameter "));
		setPreferredSize(
				new Dimension((int) (AdaptiveModemDemo.appWidth * 0.5), (int) (AdaptiveModemDemo.appHeight * 0.45)));

		int r = 0;
		add(new JLabel("Kanal: "), new GridBagConstraints(0, r++, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel("Länge: "), new GridBagConstraints(0, r, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(cbKanalLaenge, new GridBagConstraints(1, r, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(new JLabel("m"), new GridBagConstraints(2, r++, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel("Rauschen: "), new GridBagConstraints(0, r++, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel("AWGN: "), new GridBagConstraints(0, r, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(tfAWGNAmplitude, new GridBagConstraints(1, r, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(new JLabel("Vrms"), new GridBagConstraints(2, r++, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel("Ton-Amplitude: "), new GridBagConstraints(0, r, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(tfTonAmplitude, new GridBagConstraints(1, r, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(new JLabel("Vp"), new GridBagConstraints(2, r++, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel("Ton-Frequenz: "), new GridBagConstraints(0, r, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(tfTonFrequenz, new GridBagConstraints(1, r, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(new JLabel("Hz"), new GridBagConstraints(2, r++, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel("Empfänger: "), new GridBagConstraints(0, r++, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel("Step FF: "), new GridBagConstraints(0, r, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(tfSchrittFF, new GridBagConstraints(1, r++, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel("Step FB: "), new GridBagConstraints(0, r, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(tfSchrittFB, new GridBagConstraints(1, r++, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		add(btReset, new GridBagConstraints(1, r++, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel(" "), new GridBagConstraints(0, r++, 3, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		cbKanalLaenge.addActionListener(this);
		tfAWGNAmplitude.addActionListener(this);
		tfTonAmplitude.addActionListener(this);
		tfTonFrequenz.addActionListener(this);
		tfSchrittFF.addActionListener(this);
		tfSchrittFB.addActionListener(this);
		btReset.addActionListener(this);
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
		if (e.getSource() == btReset)
			controller.resetFilter();
		controller.setParameter();
	}
}
