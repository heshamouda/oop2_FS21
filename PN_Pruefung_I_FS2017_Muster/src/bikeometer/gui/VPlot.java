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
import figure.LineListenerAdapter;
import figure.PlotAxes;

public class VPlot extends JPanel {
	private static final long serialVersionUID = 1L;
	private Line line = new Line(Color.yellow);
	private PlotAxes vtAxes = new PlotAxes();
	private Line lineMarkerA = new Line(Color.red);
	private Line lineMarkerB = new Line(Color.green);
	private double tAxisMin = 0.0, tAxisMax = 1800.0;
	private double tA = tAxisMin, tB = tAxisMin;
	private Controller controller;

	public VPlot(Controller controller) {
		setLayout(new BorderLayout());
		this.controller = controller;
		setBorder(MyBorderFactory.createMyBorder("VPlot - Geschwindigkeit"));
		setPreferredSize(new Dimension((int) (0.65 * BikeOMeter.appWidth), (int) (0.4 * BikeOMeter.appHeight)));
		vtAxes.setAxesMode(AbstractAxes.LIN_LIN);
		vtAxes.setAxis(tAxisMin, tAxisMax, 0.0, 40.0);
		vtAxes.setTickSpacing(100.0, 500.0, 5.0, 10.0);
		vtAxes.setFont(new Font("TimesRoman", Font.PLAIN, 10));
		vtAxes.setFigureColor(getBackground());
		vtAxes.setPlotColor(Color.darkGray);
		vtAxes.setFrameColor(Color.white);
		vtAxes.setGridColor(Color.white);
		vtAxes.setTextColor(Color.black);
		vtAxes.setTickColor(Color.black);
		vtAxes.setFrameColor(Color.black);
		vtAxes.addAxesObject(line);
		line.setWidth(3.0f);
		add(vtAxes, BorderLayout.CENTER);
		lineMarkerA.setData(new double[] { 5, 5 }, new double[] { 0, 250 });
		lineMarkerA.setWidth(3.0f);
		lineMarkerA.addLineListener(new LineListenerAdapter() {
			public void lineDragged(double x, double y, double[] xData, double[] yData) {
				if (x < line.getXData()[0]) {
					lineMarkerA.setXData(new double[] { line.getXData()[0], line.getXData()[0] });
					tA = line.getXData()[0];
				} else if (x > line.getXData()[line.getXData().length - 1]) {
					lineMarkerA.setXData(new double[] { line.getXData()[line.getXData().length - 1],
							line.getXData()[line.getXData().length - 1] });
					tA = line.getXData()[line.getXData().length - 1];
				} else {
					lineMarkerA.setXData(new double[] { x, x });
					tA = x;
				}
				setMarkerPositions();
			}
		});
		lineMarkerB.setData(new double[] { 0, 0 }, new double[] { 0, 250 });
		lineMarkerB.setWidth(3.0f);
		lineMarkerB.addLineListener(new LineListenerAdapter() {
			public void lineDragged(double x, double y, double[] xData, double[] yData) {
				if (x < line.getXData()[0]) {
					lineMarkerB.setXData(new double[] { line.getXData()[0], line.getXData()[0] });
					tB = line.getXData()[0];
				} else if (x > line.getXData()[line.getXData().length - 1]) {
					lineMarkerB.setXData(new double[] { line.getXData()[line.getXData().length - 1],
							line.getXData()[line.getXData().length - 1] });
					tB = line.getXData()[line.getXData().length - 1];
				} else {
					lineMarkerB.setXData(new double[] { x, x });
					tB = x;
				}
				setMarkerPositions();
			}
		});
		vtAxes.addAxesObject(lineMarkerA);
		vtAxes.addAxesObject(lineMarkerB);
	}

	public void setAxis(double tMin, double tMax, double vMin, double vMax) {
		this.tAxisMin = tMin;
		this.tAxisMax = tMax;
		vtAxes.setAxis(tAxisMin, tAxisMax, vMin, vMax);
	}

	public void setData(double[] t, double[] v) {
		if (v == null || t == null)
			return;
		line.setData(t, v);
		repaint();
	}

	public void update(Observable obs, Object obj) {
		Model model = (Model) obs;
		setData(model.getTimeAxis(), model.getvProfile());
		if (model.newData) {
			setAxis(model.tMin, model.tMax, model.vMin, model.vMax);
			lineMarkerB.setXData(new double[] { model.tMin, model.tMin });
			lineMarkerA.setXData(new double[] { model.tMax, model.tMax });
		}
	}

	private void setMarkerPositions() {
		controller.setMarkerPositions(tA, tB);
	}
}
