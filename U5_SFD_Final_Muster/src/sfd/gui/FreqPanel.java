package sfd.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sfd.model.Model;
import sfd.model.RationalFunction;
import util.Observable;
import util.Observer;
import util.TraceV8;

public class FreqPanel extends JPanel implements Observer {
	private TraceV8 trace = new TraceV8(this);
	private static final long serialVersionUID = -7462236257522307804L;
	public JTextField tfZaehler = new JTextField(40);
	public JTextField tfNenner = new JTextField(40);
	private AmplitudenPlot amplitudenPlot = new AmplitudenPlot();
	private PhasenPlot phasenPlot = new PhasenPlot();

	public FreqPanel() {
		super(new GridBagLayout());
		trace.constructorCall();

		JLabel lb1 = new JLabel("Zaehler:  ");
		add(lb1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(10, 10, 10, 10), 0, 0));
		tfZaehler.setEditable(false);
		add(tfZaehler, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

		JLabel lb2 = new JLabel("Nenner:  ");
		add(lb2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(10, 10, 10, 10), 0, 0));
		tfNenner.setEditable(false);
		add(tfNenner, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

		add(amplitudenPlot, new GridBagConstraints(0, 2, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0));

		add(phasenPlot, new GridBagConstraints(0, 3, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));

	}

	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		Model model = (Model) obs;
		RationalFunction rationalFunction = model.getRationalFunction();
		tfZaehler.setText(rationalFunction.numerator.toString());
		tfNenner.setText(rationalFunction.denominator.toString());
		amplitudenPlot.update(obs, obj);
		phasenPlot.update(obs, obj);
	}
}
