import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import figure.Line;
import figure.PlotAxes;

public class PanelPlot extends JPanel {
	private static final long serialVersionUID = -4522467773085225830L;
	private PlotAxes plotAxes = new PlotAxes();
	private Line xyLine0 = new Line(Color.RED);
	private Line xyLine1 = new Line(Color.GRAY);

	public PanelPlot() {
		super(new BorderLayout());
		this.setPreferredSize(new Dimension(600, 40));

		plotAxes.setAxis(0.0, 8, -3, 3);
		plotAxes.setFont(null);
		plotAxes.setTickLength(0, 0);
		plotAxes.setTickSpacing(1, 1, 1, 1);
		plotAxes.setLineColor(Color.black);
		plotAxes.setGridColor(Color.black);
		plotAxes.setTextColor(Color.black);
		plotAxes.setTickColor(Color.black);
		plotAxes.addAxesObject(xyLine0);
		xyLine0.setWidth(4.0f);
		plotAxes.addAxesObject(xyLine1);
		xyLine1.setWidth(2.0f);

		add(plotAxes);
	}

	public void setData(double[] x, double[] y, double amp) {
		double[] xv = new double[2 * x.length];
		double[] yv = new double[2 * y.length];

		for (int i = 0; i < x.length; i++) {
			xv[2 * i] = x[i];
			xv[2 * i + 1] = x[i] + 1;
			yv[2 * i] = y[i] * amp;
			yv[2 * i + 1] = y[i] * amp;
			xyLine0.setData(xv, yv);
		}

		double[] xv1 = new double[2 * x.length];
		double[] yv1 = new double[2 * y.length];

		for (int i = 0; i < x.length; i++) {
			xv1[2 * i] = x[i];
			xv1[2 * i + 1] = x[i] + 1;
			yv1[2 * i] = y[i];
			yv1[2 * i + 1] = y[i];
			xyLine1.setData(xv1, yv1);
		}

		plotAxes.setToolTipText("Koeffizient: " + Math.round(10.0 * amp) / 10.0);
	}

	public void setData(double[] x, double[] y) {
		double[] xv1 = new double[2 * x.length];
		double[] yv1 = new double[2 * y.length];

		for (int i = 0; i < x.length; i++) {
			xv1[2 * i] = x[i];
			xv1[2 * i + 1] = x[i] + 1;
			yv1[2 * i] = y[i];
			yv1[2 * i + 1] = y[i];
			xyLine0.setData(xv1, yv1);
		}
	}

	public void setColor(Color color) {
		xyLine0.setColor(color);
		repaint();
	}
}
