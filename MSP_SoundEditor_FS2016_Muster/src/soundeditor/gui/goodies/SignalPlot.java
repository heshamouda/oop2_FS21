package soundeditor.gui.goodies;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.JPanel;

import figure.AbstractAxes;
import figure.Line;
import figure.PlotAxes;
import soundeditor.model.Model;

public class SignalPlot extends JPanel {
	private static final long serialVersionUID = 1L;
	private Line lineLeft = new Line(Color.yellow);
	private Line lineRight = new Line(Color.cyan);
	private PlotAxes signalAxesLeft = new PlotAxes();
	private PlotAxes signalAxesRight = new PlotAxes();
	private double xAxisMin = 0.0, xAxisMax = 360.0;

	public SignalPlot() {
		super(new GridLayout(2, 1, 0, 0));
		setPreferredSize(new Dimension(700, -1));

		signalAxesLeft.setAxesMode(AbstractAxes.LIN_LIN);
		signalAxesLeft.setAxis(xAxisMin, xAxisMax, -1.0, 1.0);
		signalAxesLeft.setTickSpacing(10.0, 30.0, 0.5, 0.25);
		signalAxesLeft.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		signalAxesLeft.setLabel("Zeit", "Amplitude Links");
		signalAxesLeft.setFigureColor(getBackground());
		signalAxesLeft.setPlotColor(Color.darkGray);
		signalAxesLeft.setFrameColor(Color.white);
		signalAxesLeft.setGridColor(Color.white);
		signalAxesLeft.setTextColor(Color.black);
		signalAxesLeft.setTickColor(Color.black);
		signalAxesLeft.setFrameColor(Color.black);

		signalAxesLeft.addAxesObject(lineLeft);
		lineLeft.setWidth(2.0f);

		add(signalAxesLeft);

		signalAxesRight.setAxesMode(AbstractAxes.LIN_LIN);
		signalAxesRight.setAxis(xAxisMin, xAxisMax, -1.0, 1.0);
		signalAxesRight.setTickSpacing(10.0, 30.0, 0.5, 0.25);
		signalAxesRight.setFont(new Font("TimesRoman", Font.PLAIN, 12));
		signalAxesRight.setLabel("Zeit", "Amplitude Rechts");
		signalAxesRight.setFigureColor(getBackground());
		signalAxesRight.setPlotColor(Color.darkGray);
		signalAxesRight.setFrameColor(Color.white);
		signalAxesRight.setGridColor(Color.white);
		signalAxesRight.setTextColor(Color.black);
		signalAxesRight.setTickColor(Color.black);
		signalAxesRight.setFrameColor(Color.black);

		signalAxesRight.addAxesObject(lineRight);
		lineRight.setWidth(2.0f);

		add(signalAxesRight);
	}

	public void setData(double[] t, double[][] signal) {
		if (signal == null || t == null)
			return;
		int nPt = 5000;
		double[] x = new double[nPt];
		double[] yleft = new double[nPt];
		double[] yright = new double[nPt];
		int index1 = 0;
		while (index1 < t.length && t[index1] < xAxisMin) {
			index1++;
		}
		int index2 = 0;
		while (index2 < t.length && t[index2] < xAxisMax) {
			index2++;
		}
		int step = (index2 - index1) / nPt;
		for (int i = 0; i < x.length; i++) {
			x[i] = t[(index1 + i * step)];

			double maxLeft = 0.0, maxRight = 0.0;
			int indexLeft = 0, indexRight = 0;
			for (int j = 0; j < step; j++) {
				if (Math.abs(signal[0][(index1 + i * step + j)]) > maxLeft) {
					maxLeft = Math.abs(signal[0][(index1 + i * step + j)]);
					indexLeft = index1 + i * step + j;
				}
				if (Math.abs(signal[1][(index1 + i * step + j)]) > maxRight) {
					maxRight = Math.abs(signal[1][(index1 + i * step + j)]);
					indexRight = index1 + i * step + j;
				}
			}
			yleft[i] = signal[0][indexLeft];
			yright[i] = signal[1][indexRight];
		}
		lineLeft.setData(x, yleft);
		lineRight.setData(x, yright);
		repaint();
	}

	public void setXAxis(double xMin, double xMax) {
		this.xAxisMin = xMin;
		this.xAxisMax = xMax;
	}

	public void update(Observable obs, Object arg) {
		Model model = (Model) obs;
		if (model.getSoundTrack() == null)
			return;
		signalAxesRight.setAxis(0.0, model.getDuration(), -1.0, 1.0);
		signalAxesLeft.setAxis(0.0, model.getDuration(), -1.0, 1.0);
		setData(model.getTimeAxis(), model.getSignal());
	}

}
