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
//Name: Muster
//Vorname:

public class ParameterPanel extends JPanel implements ActionListener {
	// 13 + 3
	static final long serialVersionUID = 1L;
	private Controller controller;
	public JTextField tfSignal = new JTextField("0.5");
	public JTextField tfStoerer = new JTextField("1.0");
	public JTextField tfSchritt = new JTextField("0.0005");

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
		// 12
		super(new GridBagLayout());
		this.controller = controller;

		add(new JLabel("Signalpegel: "), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		tfSignal.setHorizontalAlignment(SwingConstants.RIGHT);
		tfSignal.addActionListener(this);
		add(tfSignal, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel("Störsignalpegel: "), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		tfStoerer.setHorizontalAlignment(SwingConstants.RIGHT);
		tfStoerer.setColumns(30);
		tfStoerer.addActionListener(this);
		add(tfStoerer, new GridBagConstraints(0, 3, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel("Schrittweite: "), new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		tfSchritt.setHorizontalAlignment(SwingConstants.RIGHT);
		tfSchritt.addActionListener(this);
		add(tfSchritt, new GridBagConstraints(0, 5, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel(""), new GridBagConstraints(0, 6, 1, 1, 0.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.VERTICAL, new Insets(5, 5, 5, 5), 0, 0));

	}

	@Override
	/**
	 * <pre>
	 * - Entsprechende Methode des Controllers aufrufen.
	 * </pre>
	 */
	public void actionPerformed(ActionEvent e) {
		// 1
		controller.setParameter();
	}
}
