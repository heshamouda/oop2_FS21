import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import util.MyBorderFactory;
import util.TraceV4;

public class ParameterPanel extends JPanel implements ActionListener, ItemListener {
	private static final long serialVersionUID = 1L;
	private TraceV4 trace = new TraceV4(this);
	private Controller controller;

	public JTextField tfAmp = new JTextField("1.0");
	public JTextField tfFreq = new JTextField("1.0");
	public JTextField tfHarm = new JTextField("10");
	public JComboBox<String> cbForm = new JComboBox<String>();

	/**
	 * <pre> 
	 * - setzt Attribut der Klasse 
	 * - platziert die Elemente im GridbagLayout
	 * - Textfelder und ComboBox sollen horizontal wachsen
	 * - Labels sollen unverändert bleiben
	 * - Als letzte Zeile eine in beide Richtung wachsende Leerzeile ergaenzen
	 * </pre>
	 */
	public ParameterPanel(Controller controller) {
		trace.constructorCall();
		setLayout(new GridBagLayout());
		setBorder(MyBorderFactory.createMyBorder(" SignalParameter "));

		this.controller = controller;

		cbForm.addItem("Rechteck");
		cbForm.addItem("Dreieck");
		cbForm.addItem("Sägezahn");

		add(new JLabel("Amplitude"), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(tfAmp, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 10, 10), 0, 0));
		tfAmp.addActionListener(this);

		add(new JLabel("Frequenz"), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(tfFreq, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 10, 10), 0, 0));
		tfFreq.addActionListener(this);

		add(new JLabel("Wellenform"), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(cbForm, new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 10, 10), 0, 0));
		cbForm.addItemListener(this);

		add(new JLabel("Anzahl Harmonische: "), new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(tfHarm, new GridBagConstraints(1, 3, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 10, 10), 0, 0));
		tfHarm.addActionListener(this);

		add(new JLabel(), new GridBagConstraints(0, 4, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0)); // leerzeile

	}

	/**
	 * <pre>
	 * -ruft die Controller Methode btBerechnen() auf
	 * -loesst neuzeichnen aus
	 * </pre>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		trace.eventCall();

		controller.btBerechne();
		repaint();
	}

	/**
	 * <pre>
	 * -ruft die Controller Methode btBerechnen() auf
	 * - lösst neuzeichnen aus
	 * </pre>
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		trace.eventCall();

		controller.btBerechne();
		repaint();
	}
}
