package impulsdemo.gui.goodies;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.commons.math3.complex.Complex;

import impulsdemo.ImpulsDemoApplikation;
import impulsdemo.TraceV2;
import impulsdemo.model.Model;

// DIESE DATEI MUSS NICHT BEARBEITET WERDEN! SIE WIRD NICHT BEWERTET!

public class ZeigerPanel extends JPanel {
	private TraceV2 tr = new TraceV2(this);
	private static final long serialVersionUID = 1L;
	private ZeigerPlot[] drehZeigerPlot = new ZeigerPlot[11];
	private ZeigerPlot[] summenZeigerPlot = new ZeigerPlot[(drehZeigerPlot.length + 1) / 2];

	public ZeigerPanel() {
		super(new GridBagLayout());
		tr.constructorCall();
		setPreferredSize(
				new Dimension(-1, (int) ((drehZeigerPlot.length - 1) / 2 * 0.35 * ImpulsDemoApplikation.appHeight)));

		Insets insets = new Insets(4, 4, 4, 4);

		drehZeigerPlot[0] = new ZeigerPlot();
		summenZeigerPlot[0] = new ZeigerPlot();
		add(drehZeigerPlot[0], new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, insets, 0, 0));
		add(summenZeigerPlot[0], new GridBagConstraints(4, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, insets, 0, 0));

		for (int i = 1; i < summenZeigerPlot.length; i++) {
			drehZeigerPlot[2 * i - 1] = new ZeigerPlot();
			drehZeigerPlot[2 * i] = new ZeigerPlot();
			summenZeigerPlot[i] = new ZeigerPlot();

			add(drehZeigerPlot[2 * i - 1], new GridBagConstraints(0, i + 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, insets, 0, 0));
			add(new JLabel("+"), new GridBagConstraints(1, i + 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.NONE, insets, 0, 0));
			add(drehZeigerPlot[2 * i], new GridBagConstraints(2, i + 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, insets, 0, 0));

			add(new JLabel("="), new GridBagConstraints(3, i + 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.NONE, insets, 0, 0));

			add(summenZeigerPlot[i], new GridBagConstraints(4, i + 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
					GridBagConstraints.BOTH, insets, 0, 0));
		}
	}

	public void update(Observable obs, Object obj) {
		Model model = (Model) obs;
		Complex[] drehZeiger = model.getDrehZeiger();

		if (drehZeiger == null)
			return;

		if (model.isAngehalten()) {
			for (int i = 0; i < summenZeigerPlot.length; i++) {
				summenZeigerPlot[i].clearTail();
			}
		}

		drehZeigerPlot[0].setData(drehZeiger[(drehZeiger.length - 1) / 2].multiply(4.0));
		summenZeigerPlot[0].setData(drehZeiger[(drehZeiger.length - 1) / 2].multiply(4.0));

		for (int i = 1; i < summenZeigerPlot.length; i++) {
			if (((drehZeiger.length - 1) / 2 - i) > -1) {
				drehZeigerPlot[2 * i - 1].setData(drehZeiger[(drehZeiger.length - 1) / 2 - i].multiply(4.0));
				drehZeigerPlot[2 * i].setData(drehZeiger[(drehZeiger.length - 1) / 2 + i].multiply(4.0));
				summenZeigerPlot[i].setData(drehZeiger[(drehZeiger.length - 1) / 2 - i].multiply(4.0),
						drehZeiger[(drehZeiger.length - 1) / 2 + i].multiply(4.0));
			} else {
				drehZeigerPlot[2 * i - 1].setData(new Complex(0, 0));
				drehZeigerPlot[2 * i].setData(new Complex(0, 0));
				summenZeigerPlot[i].setData(new Complex(0, 0));
			}

		}
	}
}
