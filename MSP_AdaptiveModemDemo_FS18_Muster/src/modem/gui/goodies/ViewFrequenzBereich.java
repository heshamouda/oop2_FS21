package modem.gui.goodies;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;

import javax.swing.JPanel;

import org.apache.commons.math3.complex.Complex;

import dsv.Matlab;
import dsv.PicoMatlab;
import modem.model.Model;
import resources.MyBorderFactory;

public class ViewFrequenzBereich extends JPanel {
	private static final long serialVersionUID = -3345524379780063531L;
	private XYPlotPanel stAmplitudenPanel = new XYPlotPanel("", "", "dB", new double[] { 0, 50e6, -80.0, 5.0 },
			new boolean[] { false, false }, new boolean[] { false, true }, Color.blue);
	private XYPlotPanel eqAmplitudenPanel = new XYPlotPanel("", "", "dB", new double[] { 0, 50e6, -80.0, 20.0 },
			new boolean[] { false, false }, new boolean[] { false, true }, Color.red);
	private XYPlotPanel gStAmplitudenPanel = new XYPlotPanel("", "Frequenz", "dB", new double[] { 0, 50e6, -5.0, 5.0 },
			new boolean[] { false, false }, new boolean[] { false, true }, Color.green);

	public ViewFrequenzBereich() {
		super(new GridBagLayout());

		stAmplitudenPanel.setBorder(MyBorderFactory.createMyBorder(" Amplitudengang der Strecke "));
		add(stAmplitudenPanel, new GridBagConstraints(0, 1, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		eqAmplitudenPanel.setBorder(MyBorderFactory.createMyBorder(" Amplitudengang des Equlizers "));
		add(eqAmplitudenPanel, new GridBagConstraints(0, 2, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		gStAmplitudenPanel.setBorder(MyBorderFactory.createMyBorder(" Amplitudengang der Gesamtstrecke "));
		add(gStAmplitudenPanel, new GridBagConstraints(0, 3, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	}

	public void update(Observable obs, Object obj) {
		if (!isVisible())
			return;

		Model model = (Model) obs;

		Complex[] H = PicoMatlab.freqz(model.getImpulsKanalFilter(), new double[] { 1.0 }, model.getfAxis().length,
				1.0);
		double[] amplitudenGang = Matlab.multiply(Matlab.log10(Matlab.abs(H)), 20.0);
		stAmplitudenPanel.setData(model.getfAxis(), amplitudenGang);

		Complex[] res = PicoMatlab.freqz(model.getImpulsFFFilter(), new double[] { 1.0 }, model.getfAxis().length, 1.0);
		amplitudenGang = Matlab.multiply(Matlab.log10(Matlab.abs(res)), 20.0);
		eqAmplitudenPanel.setData(model.getfAxis(), amplitudenGang);

		double[] strecke = Matlab.conv(Matlab.conv(model.getImpulsTransmitFilter(), model.getImpulsKanalFilter()),
				model.getImpulsFFFilter());
		double[] h = Matlab.downsample(strecke, 2, 1);
		double[] fbFilter = model.getImpulsFBFilter();
		for (int i = 0; i < model.getImpulsFBFilter().length; i++) {
			h[i + model.delay.length + 1] = h[i + model.delay.length + 1] + fbFilter[i];
		}
		H = PicoMatlab.freqz(h, new double[] { 1.0 }, model.getfAxis().length, 1.0);
		amplitudenGang = Matlab.multiply(Matlab.log10(Matlab.abs(H)), 20.0);

		gStAmplitudenPanel.setData(model.getfAxis(), amplitudenGang);

	}
}
