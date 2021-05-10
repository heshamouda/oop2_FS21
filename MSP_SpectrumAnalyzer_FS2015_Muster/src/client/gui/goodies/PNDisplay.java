package client.gui.goodies;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;

import javax.swing.JPanel;

import client.gui.Controller;
import client.model.Model;
import client.tools.figure.AbstractAxes;
import client.tools.figure.Line;
import client.tools.figure.LineListenerAdapter;
import client.tools.figure.PlotAxes;

public class PNDisplay extends JPanel {
	//
	private static final long serialVersionUID = 1L;
	private PlotAxes plotAxes = new PlotAxes();
	private Line line = new Line(Color.yellow);
	private Line lineMarkerLeft = new Line(Color.magenta);
	private Line lineMarkerRight = new Line(Color.magenta);
	private Controller controller;

	public PNDisplay(Controller ctrl) {
		super(new BorderLayout());
		setPreferredSize(new Dimension(600, 300));
		setBorder(MyBorderFactory.createBorder(" "
				+ "Power - Spectral - Density" + " "));
		this.controller = ctrl;

		plotAxes.setAxesMode(AbstractAxes.LIN_LIN);
		plotAxes.setAxis(0, 24e3, -140.0, 0.0);

		plotAxes.setFont(getFont());
		plotAxes.setTickSpacing(5e3, 1e3, 20, 5);
		plotAxes.setTextColor(Color.black);
		plotAxes.setTickColor(Color.black);

		plotAxes.setFigureColor(this.getBackground());
		plotAxes.setPlotColor(new Color(1, 0, 128));
		plotAxes.setGridColor(new Color(70, 90, 220));
		plotAxes.setFrameColor(Color.BLACK);

		line.setWidth(2.0f);
		line.setColor(Color.yellow);
		plotAxes.addAxesObject(line);

		lineMarkerLeft.setData(new double[] { 0 + 10, 0 + 10 }, new double[] {
				-140, 0 });
		lineMarkerLeft.setWidth(3.0f);
		lineMarkerLeft.addLineListener(new LineListenerAdapter() {
			@Override
			public void lineDragged(double x, double y, double[] xData,
					double[] yData) {
				if (x < 10)
					x = 10;
				if (x > 24e3 - 10)
					x = 24e3 - 10;

				lineMarkerLeft.setXData(new double[] { x, x });
				if (x > (lineMarkerRight.getXData()[0])) {
					lineMarkerRight.setXData(new double[] { x, x });
					controller.setLineMarkerRight(x);
				}
				controller.setLineMarkerLeft(x);
			}
		});
		plotAxes.addAxesObject(lineMarkerLeft);
		lineMarkerRight.setData(new double[] { 24e3 - 10, 24e3 - 10 },
				new double[] { -140, 00 });
		lineMarkerRight.setWidth(3.0f);
		lineMarkerRight.addLineListener(new LineListenerAdapter() {
			@Override
			public void lineDragged(double x, double y, double[] xData,
					double[] yData) {
				if (x < 10)
					x = 10;
				if (x > 24e3 - 10)
					x = 24e3 - 10;
				lineMarkerRight.setXData(new double[] { x, x });
				if (x < (lineMarkerLeft.getXData()[0])) {
					lineMarkerLeft.setXData(new double[] { x, x });
					controller.setLineMarkerLeft(x);
				}
				controller.setLineMarkerRight(x);
			}
		});
		plotAxes.addAxesObject(lineMarkerRight);

		add(plotAxes);
	}

	public void update(Observable obs, Object obj) {
		Model model = (Model) obs;
		double[] spectrum = model.getPowerSpectrum();
		double[] spectrumdB = new double[spectrum.length];
		for (int i = 0; i < spectrumdB.length; i++) {
			spectrumdB[i] = 10.0 * Math.log10(spectrum[i]);
		}
		line.setData(model.getFrequencyAxis(), spectrumdB);
		repaint();
	}

}
