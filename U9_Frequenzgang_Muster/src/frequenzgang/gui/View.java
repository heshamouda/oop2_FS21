package frequenzgang.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.Observable;
import util.Observer;
import util.TraceV5;

public class View extends JPanel implements Observer, ActionListener {
	private TraceV5 trace = new TraceV5(this);
	private static final long serialVersionUID = -7462236257522307804L;
	public JTextField tfZaehler = new JTextField(40);
	public JTextField tfNenner = new JTextField(40);
	private Controller controller;

	public JButton btOk = new JButton("Berechne Frequenzgang");
	private AmplitudenPlot amplitudenPlot = new AmplitudenPlot();
	private PhasenPlot phasenPlot = new PhasenPlot();

	public View(Controller controller) {
		super(new GridBagLayout());
		trace.constructorCall();
	

		this.controller = controller;
		add(new JLabel("Zaehler: "), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(tfZaehler, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		tfZaehler.setText("0, 0, 0, 0, 1.5585e+16");

		add(new JLabel("Nenner: "), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(tfNenner, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		tfNenner.setText("1.0, 2.919e+004, 4.262e+8, 3.645e+12, 1.558e+16");

		add(amplitudenPlot, new GridBagConstraints(0, 2, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0));

		add(phasenPlot, new GridBagConstraints(0, 3, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));

		add(btOk, new GridBagConstraints(0, 4, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 10, 10), 0, 0));
		btOk.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		trace.eventCall();
		controller.btOkAction();
	
	}

	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		amplitudenPlot.update(obs, obj);
		phasenPlot.update(obs, obj);
	
	}
}
