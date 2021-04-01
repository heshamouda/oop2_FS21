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
	}
}
