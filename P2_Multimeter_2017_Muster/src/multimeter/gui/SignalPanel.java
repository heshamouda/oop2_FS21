package multimeter.gui;
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
//

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import multimeter.MultimeterApplikation;
import multimeter.model.signalquelle.SignalQuelle;
import multimeter.resources.MyBorderFactory;

public class SignalPanel extends JPanel implements ActionListener {
	// 30
	private static final long serialVersionUID = 1L;
	private JRadioButton jrbSinus = new JRadioButton("Sinus");
	private JRadioButton jrRechteck = new JRadioButton("Rechteck");
	private JTextField tfAmplitude = new JTextField("1.0");
	private JTextField tfGleichanteil = new JTextField("0.0");
	private JTextField tfFrequenz = new JTextField("1e3");
	private ButtonGroup group = new ButtonGroup();
	private JButton jbtUebernehmen = new JButton("Übernehmen");

	private Controller controller;

	/**
	 * <pre>
	 * - Baut GUI gemäss Aufgabenstellung. 
	 * - Setzt bevorzugte Grösse auf 25% von MultimeterApplikation.appWidth 
	 *   und 100% von MultimeterApplikation.appHeight. 
	 *   - Löst einen doClick() auf dem Übernehmen-Button aus.
	 * </pre>
	 * 
	 * @param controller
	 */
	public SignalPanel(Controller controller) {
		// 21
		super(new GridBagLayout());
		this.controller = controller;
		setBorder(MyBorderFactory.createMyBorder(" SignalPanel "));
		setPreferredSize(new Dimension((int) (0.25 * MultimeterApplikation.appWidth),
				(int) (1.0 * MultimeterApplikation.appHeight)));

		Insets insets = new Insets(5, 5, 5, 5);

		add(new JLabel("Signalform: "), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, insets, 10, 10));
		add(jrbSinus, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				insets, 10, 10));
		add(jrRechteck, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				insets, 10, 10));
		add(new JLabel(""), new GridBagConstraints(3, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, insets, 10, 10));

		add(new JLabel("Amplitude Vp: "), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, insets, 10, 10));
		add(tfAmplitude, new GridBagConstraints(1, 1, 3, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, insets, 10, 10));

		add(new JLabel("Gleichanteil: "), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, insets, 10, 10));
		add(tfGleichanteil, new GridBagConstraints(1, 2, 3, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, insets, 10, 10));

		add(new JLabel("Frequenz: "), new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, insets, 10, 10));
		add(tfFrequenz, new GridBagConstraints(1, 3, 3, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, insets, 10, 10));

		add(jbtUebernehmen, new GridBagConstraints(0, 4, 4, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, insets, 10, 10));

		add(new JLabel(""), new GridBagConstraints(0, 10, 4, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 10, 10));

		jrbSinus.setSelected(true);
		group.add(jrbSinus);
		group.add(jrRechteck);
		jbtUebernehmen.addActionListener(this);
		jbtUebernehmen.doClick();
	}

	@Override
	/**
	 * <pre>
	 * - Liest Werte aus den Textfeldern in double aus und speichert sie in lokale Var.
	 * - Falls Sinus gewählt:
	 *   - lokale Var. auf SignalQuelle.SINUS setzen.
	 *   Sonst:
	 *   - lokale Var. auf SignalQuelle.RECHTECK setzen
	 * - Entsprechende Methode des Controllers aufrufen.
	 * </pre>
	 * 
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		// 9
		double amp = Double.parseDouble(tfAmplitude.getText());
		double dc = Double.parseDouble(tfGleichanteil.getText());
		double freq = Double.parseDouble(tfFrequenz.getText());
		int signalMode = 0;

		if (jrbSinus.isSelected())
			signalMode = SignalQuelle.SINUS;
		else
			signalMode = SignalQuelle.RECHTECK;

		controller.setParameters(signalMode, amp, dc, freq);
	}
}
