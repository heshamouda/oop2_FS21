package impulsdemo.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import impulsdemo.ImpulsDemoApplikation;
import impulsdemo.TraceV2;
import impulsdemo.model.Model;
import resources.MyBorderFactory;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: Muster
//Vorname:

public class ParameterPanel extends JPanel implements ActionListener {
	// 51
	private TraceV2 tr = new TraceV2(this);
	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private JComboBox jcbLTIType = new JComboBox(new String[] { Model.LHE, Model.JW, Model.RHE });
	public JButton btReset = new JButton("Reset");

	private JTextField tfZaehler = new JTextField("0.0, 0.0, 0.04, 0.0, 0.0");
	private JTextField tfNenner = new JTextField("1.0,  0.2828, 2.0200, 0.2800, 0.9801");

	private JLabel lbZaehler = new JLabel("Zaehler: ");
	private JLabel lbNenner = new JLabel("Nenner: ");
	private JButton btStart = new JButton("Start");
	private JCheckBox cbLTI2Ord = new JCheckBox("LTI System 2. Ordnung");
	private JCheckBox cbLTIbel = new JCheckBox("LTI System beliebiger Ordnung");
	private ButtonGroup group = new ButtonGroup();

	private Controller controller;

	/**
	 * <pre>
	 * - Setzt bevorzugte Grösse auf (35% von DrehzeigerDemoApplikation.appWidth, 100% von DrehzeigerDemoApplikation.appHeight).
	 * - Setzt entsprechendes Attribut.
	 * - Setzt die Border mit entsprechendes Beschriftung.
	 * - Baut das GUI gemäss Aufgabenstellung.
	 * </pre>
	 * 
	 * @param controller
	 *            Referenz des Controllers.
	 */
	public ParameterPanel(Controller controller) {
		// 29
		super(new GridBagLayout());
		tr.constructorCall();
		setPreferredSize(
				new Dimension((int) (0.35 * ImpulsDemoApplikation.appWidth), (int) (ImpulsDemoApplikation.appHeight)));
		this.controller = controller;
		setBorder(MyBorderFactory.createMyBorder(" ParameterPanel: Einstellungen "));
		group.add(cbLTI2Ord);
		group.add(cbLTIbel);

		cbLTI2Ord.addActionListener(this);
		add(cbLTI2Ord, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		jcbLTIType.addActionListener(this);
		add(jcbLTIType, new GridBagConstraints(0, 1, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(new JLabel(" "), new GridBagConstraints(0, 2, 2, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		cbLTIbel.addActionListener(this);
		add(cbLTIbel, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		lbZaehler.setEnabled(false);
		tfZaehler.setEnabled(false);
		add(lbZaehler, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(tfZaehler, new GridBagConstraints(1, 4, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		lbNenner.setEnabled(false);
		tfNenner.setEnabled(false);
		add(lbNenner, new GridBagConstraints(0, 5, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(tfNenner, new GridBagConstraints(1, 5, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel(" "), new GridBagConstraints(0, 6, 2, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		btReset.addActionListener(this);
		add(btReset, new GridBagConstraints(0, 7, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		btStart.addActionListener(this);
		add(btStart, new GridBagConstraints(1, 7, 1, 1, 1.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel(" "), new GridBagConstraints(0, 8, 2, 1, 1.0, 1.0, GridBagConstraints.LINE_START,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		cbLTI2Ord.setSelected(true);
	}

	/**
	 * <pre>
	 * - Falls Quelle des Ereignisses gleich cbLTIbel:
	 *   - Bei den entsprechenden Komponenten setEnabled() mit wahr resp. unwahr aufrufen.
	 *   - Bei btReset Methode doClick() auslösen.
	 * - Falls Quelle des Ereignisses gleich cbLTI2Ord:
	 *   - Bei den entsprechenden Komponenten setEnabled() mit wahr resp. unwahr aufrufen.
	 *   - Bei btReset Methode doClick() auslösen.
	 * - Falls (Quelle des Ereignisses gleich btReset) ODER (Quelle des Ereignisses gleich btStart):
	 *   - Falls cbLTIbel selektiert ist:
	 *     - Entsprechende Methode des Controllers mit Text des Zaehler- und des Nenner-Textfeldes aufrufen.
	 *   - Falls cbLTI2Ord selektiert ist:
	 *     - Entsprechende Methode des Controllers mit Parameter (String) jcbLTIType.getSelectedItem() aufrufen.
	 *   - btReset() des Controllers aufrufen.
	 * - Falls Quelle des Ereignisses gleich btStart:
	 *   - Entsprechende Methode des Controllers aufrufen.
	 * 	 *
	 * </pre>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// 22
		tr.eventCall();
		if (e.getSource() == cbLTIbel) {
			lbZaehler.setEnabled(true);
			tfZaehler.setEnabled(true);
			lbNenner.setEnabled(true);
			tfNenner.setEnabled(true);
			jcbLTIType.setEnabled(false);
			btReset.doClick();
		}
		if (e.getSource() == cbLTI2Ord) {
			lbZaehler.setEnabled(false);
			tfZaehler.setEnabled(false);
			lbNenner.setEnabled(false);
			tfNenner.setEnabled(false);
			jcbLTIType.setEnabled(true);
			btReset.doClick();
		}
		if (e.getSource() == btReset || e.getSource() == btStart) {
			if (cbLTIbel.isSelected()) {
				controller.setParameter(tfZaehler.getText(), tfNenner.getText());
			}
			if (cbLTI2Ord.isSelected()) {
				controller.setSystemType((String) jcbLTIType.getSelectedItem());
			}
			controller.btReset();
		}
		if (e.getSource() == btStart) {
			controller.btStart();
		}
	}
}
