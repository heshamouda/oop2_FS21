package modem.gui.goodies;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;

import javax.swing.JPanel;

import dsv.Matlab;
import modem.model.Model;
import resources.MyBorderFactory;

public class ViewZeitBereich extends JPanel {
	private static final long serialVersionUID = -2021646150805080829L;
	private XYPlotPanel eqImpulsPanel = new XYPlotPanel("", "", "V", new double[] { 0, 80, -1.0, 1.0 },
			new boolean[] { false, false }, new boolean[] { false, true }, Color.blue);
	private XYPlotPanel stImpulsPanel = new XYPlotPanel("", "", "V", new double[] { 0, 80, -1.0, 1.0 },
			new boolean[] { false, false }, new boolean[] { false, true }, Color.red);
	private XYPlotPanel gStImpulsPanel = new XYPlotPanel("", "Zeit", "V", new double[] { 0, 80, -1.0, 1.0 },
			new boolean[] { false, false }, new boolean[] { false, true }, Color.green);

	public ViewZeitBereich() {
		super(new GridBagLayout());

		stImpulsPanel.setBorder(MyBorderFactory.createMyBorder(" Impulsantwort der Strecke "));
		add(stImpulsPanel, new GridBagConstraints(0, 1, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		eqImpulsPanel.setBorder(MyBorderFactory.createMyBorder(" Impulsantwort des Equlizers "));
		add(eqImpulsPanel, new GridBagConstraints(0, 2, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		gStImpulsPanel.setBorder(MyBorderFactory.createMyBorder(" Impulsantwort der Gesamtstrecke "));
		add(gStImpulsPanel, new GridBagConstraints(0, 3, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	}

	public void update(Observable obs, Object obj) {
		if (!isVisible())
			return;

		Model model = (Model) obs;

		double[] tAxis = model.gettAxis();

		double[] res = model.getImpulsKanalFilter();
		stImpulsPanel.setData(tAxis, Matlab.concat(res, Matlab.zeros(tAxis.length - res.length)));

		res = model.getImpulsFFFilter();
		eqImpulsPanel.setData(model.gettAxis(), Matlab.concat(res, Matlab.zeros(tAxis.length - res.length)));
		double[] strecke = Matlab.conv(Matlab.conv(model.getImpulsTransmitFilter(), model.getImpulsKanalFilter()),
				model.getImpulsFFFilter());

		res = Matlab.downsample(strecke, 2, 1);

		double[] fbFilter = model.getImpulsFBFilter();
		for (int i = 0; i < model.getImpulsFBFilter().length; i++) {
			res[i + model.delay.length + 1] = res[i + model.delay.length + 1] + fbFilter[i];
		}

		gStImpulsPanel.setData(model.gettAxis(), Matlab.concat(res, Matlab.zeros(tAxis.length - res.length)));

		res = Matlab.concat(Matlab.zeros(model.delay.length + 1), model.getImpulsFBFilter());
		gStImpulsPanel.addData(model.gettAxis(), Matlab.concat(res, Matlab.zeros(tAxis.length - res.length)), -1);

		res = Matlab.downsample(Matlab.conv(Matlab.conv(model.getImpulsTransmitFilter(), model.getImpulsKanalFilter()),
				model.getImpulsFFFilter()), 2, 1);
		gStImpulsPanel.addData(tAxis, Matlab.concat(res, Matlab.zeros(tAxis.length - res.length)));
	}
}
