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
import util.TraceV8;

public class ParameterPanel extends JPanel implements ActionListener, ItemListener {
	private static final long serialVersionUID = 1L;
	private TraceV8 trace = new TraceV8(this);
	private Controller controller;
	public JTextField tfAmp = new JTextField("1.0");
	public JTextField tfFreq = new JTextField("1.0");
	public JTextField tfHarm = new JTextField("10");
	public JComboBox<String> chForm = new JComboBox<String>();

	public ParameterPanel(Controller controller) {
		trace.constructorCall();
		setLayout(new GridBagLayout());
		setBorder(MyBorderFactory.createMyBorder(" SignalParameter "));
		this.controller = controller;

		chForm.addItem("Rechteck");
		chForm.addItem("Dreiecke");
		chForm.addItem("S‰gezahn");
		chForm.addItem("Trapez");
		chForm.addItem("Puls");

		add(new JLabel("Amplitude: "), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(tfAmp, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		tfAmp.addActionListener(this);

		add(new JLabel("Frequenz: "), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(tfFreq, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		tfFreq.addActionListener(this);

		add(new JLabel("Wellenform: "), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(chForm, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		chForm.addItemListener(this);

		add(new JLabel("Anzahl Harmonische: "), new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(tfHarm, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		tfHarm.addActionListener(this);

		add(new JLabel(), new GridBagConstraints(0, 4, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));

	}

	/**
	 * <pre>
	 * -Liest Information aus GUI aus.
	 * - Berechnet entsprechendes Signal.
	 * - Legt es in Signal ab.
	 * - l√∂st repaint aus.
	 * </pre>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		trace.eventCall();
		controller.btBerechne();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		trace.eventCall();
		controller.btBerechne();
	}
}
