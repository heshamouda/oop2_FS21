package bikeometer.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Observable;

import javax.swing.JPanel;

import bikeometer.BikeOMeter;
import bikeometer.model.Model;
import bikeometer.tools.MyBorderFactory;
import figure.AbstractAxes;
import figure.Line;
import figure.PlotAxes;

public class HPlot extends JPanel {
	private static final long serialVersionUID = 1L;
	private Line line = new Line(Color.yellow);
	private PlotAxes thAxes = new PlotAxes();
	private Line lineMarkerA = new Line(Color.red);
	private Line lineMarkerB = new Line(Color.green);
	private double tAxisMin = 0.0, tAxisMax = 1800.0;

	public HPlot() {
		setLayout(new BorderLayout());
		setBorder(MyBorderFactory.createMyBorder("HPlot - Höhe"));
		setPreferredSize(new Dimension((int) (0.65 * BikeOMeter.appWidth), (int) (0.4 * BikeOMeter.appHeight)));
		thAxes.setAxesMode(AbstractAxes.LIN_LIN);
		thAxes.setAxis(tAxisMin, tAxisMax, 300.0, 600.0);
		thAxes.setTickSpacing(100.0, 500.0, 50.0, 100.0);
		thAxes.setFont(new Font("TimesRoman", Font.PLAIN, 10));
		thAxes.setFigureColor(getBackground());
		thAxes.setPlotColor(Color.darkGray);
		thAxes.setFrameColor(Color.white);
		thAxes.setGridColor(Color.white);
		thAxes.setTextColor(Color.black);
		thAxes.setTickColor(Color.black);
		thAxes.setFrameColor(Color.black);
		thAxes.addAxesObject(line);
		line.setWidth(3.0f);
		add(thAxes, BorderLayout.CENTER);
		lineMarkerA.setData(new double[] { 5, 5 }, new double[] { 0, 5000 });
		lineMarkerA.setWidth(3.0f);
		thAxes.addAxesObject(lineMarkerA);
		lineMarkerB.setData(new double[] { 0, 0 }, new double[] { 0, 5000 });
		lineMarkerB.setWidth(3.0f);
		thAxes.addAxesObject(lineMarkerB);
	}

	public void setAxis(double tMin, double tMax, double hMin, double hMax) {
		this.tAxisMin = tMin;
		this.tAxisMax = tMax;
		thAxes.setAxis(tAxisMin, tAxisMax, hMin, hMax);
	}

	public void setData(double[] t, double[] h) {
		if (h == null || t == null)
			return;
		line.setData(t, h);
		repaint();
	}

	public void update(Observable obs, Object obj) {
		Model model = (Model) obs;
		setData(model.getTimeAxis(), model.gethProfile());
		if (model.newData) {
			setAxis(model.tMin, model.tMax, model.hMin, model.hMax);
			lineMarkerB.setXData(new double[] { model.tMin, model.tMin });
			lineMarkerA.setXData(new double[] { model.tMax, model.tMax });
		} else {
			lineMarkerA.setXData(new double[] { model.markerA, model.markerA });
			lineMarkerB.setXData(new double[] { model.markerB, model.markerB });
		}

	}

}
