package bikeometer.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.util.Observable;

import javax.swing.JPanel;

import bikeometer.BikeOMeter;
import bikeometer.model.Model;
import bikeometer.tools.MyBorderFactory;
import figure.AbstractAxes;
import figure.Line;
import figure.PlotAxes;

public class XYPlot extends JPanel {
	private static final long serialVersionUID = 1L;
	private Line line = new Line(Color.yellow);
	private Line positionA = new Line(Color.RED);
	private Line positionB = new Line(Color.GREEN);
	private PlotAxes xyAxes = new PlotAxes();

	public XYPlot() {
		setLayout(new BorderLayout());
		setBorder(MyBorderFactory.createMyBorder("XYPlot - 2D Trajektorie"));
		xyAxes.setPreferredSize(new Dimension((int) (0.35 * BikeOMeter.appWidth), (int) (0.8 * BikeOMeter.appHeight)));
		xyAxes.setAxesMode(AbstractAxes.LIN_LIN);
		xyAxes.setAxis(-600, 1000, -300, 1300);
		xyAxes.setFont(null);
		xyAxes.addAxesObject(line);
		line.setWidth(5.0f);
		xyAxes.addAxesObject(positionA);
		positionA.setWidth(8.0f);
		xyAxes.addAxesObject(positionB);
		positionB.setWidth(8.0f);
		add(xyAxes, BorderLayout.CENTER);
	}

	public void setBackgroundImage(Image image) {
		xyAxes.setBackgroundImage(image);
		repaint();
	}

	public void setData(double[] t, double[] signal) {
		if (signal == null || t == null)
			return;
		line.setData(t, signal);
		repaint();
	}

	public void update(Observable obs, Object obj) {
		Model model = (Model) obs;
		setData(model.getTraceX(), model.getTraceY());
		double[] xD = model.getTraceX();
		double[] yD = model.getTraceY();
		double[] tD = model.getTimeAxis();
		double x, y;
		double t = model.markerA;
		int index = model.getIndex(t);
		if (index < tD.length - 1) {
			double dx = xD[index + 1] - xD[index];
			double dy = yD[index + 1] - yD[index];
			double dt = tD[index + 1] - tD[index];
			x = xD[index] + (t - tD[index]) * (dx / dt);
			y = yD[index] + (t - tD[index]) * (dy / dt);
		} else {
			y = yD[yD.length - 1];
			x = xD[xD.length - 1];
		}
		positionA.setData(new double[] { x, x + 5 }, new double[] { y, y + 5 });

		t = model.markerB;
		index = model.getIndex(t);
		if (index < tD.length - 1) {
			double dx = xD[index + 1] - xD[index];
			double dy = yD[index + 1] - yD[index];
			double dt = tD[index + 1] - tD[index];
			x = xD[index] + (t - tD[index]) * (dx / dt);
			y = yD[index] + (t - tD[index]) * (dy / dt);
		} else {
			y = yD[yD.length - 1];
			x = xD[xD.length - 1];
		}
		positionB.setData(new double[] { x, x + 5 }, new double[] { y, y + 5 });
		repaint();
	}
}
