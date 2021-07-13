package sfd.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import sfd.model.Model;
import util.MyBorderFactory;
import util.Observable;
import util.TraceV8;

public class AmplitudenPlot extends JPanel {
	private TraceV8 trace = new TraceV8(this);
	private static final long serialVersionUID = -4522467773085225830L;
	private JFreeChart chart = ChartFactory.createXYLineChart("", "Frequenz [Hz]", "Amplitude [dB]", null,
			PlotOrientation.VERTICAL, false, false, false);

	public AmplitudenPlot() {
		trace.constructorCall();
		this.setLayout(new BorderLayout());
		this.setBorder(MyBorderFactory.createMyBorder(" Amplitudengang "));

		// Farben und Settings
		chart.setBackgroundPaint(getBackground());
		XYPlot xyplot = chart.getXYPlot();
		xyplot.setBackgroundPaint(getBackground());
		xyplot.setRangeGridlinePaint(Color.black);
		xyplot.setDomainGridlinePaint(Color.black);
		xyplot.getRenderer().setSeriesPaint(0, Color.black);

		ValueAxis axis = xyplot.getDomainAxis();
		axis.setRange(0, 1e4);
		axis.setAutoRange(false);
		axis.setLabelPaint(Color.black);
		axis.setTickLabelPaint(Color.black);
		axis.setTickLabelPaint(Color.black);

		axis = xyplot.getRangeAxis();
		axis.setAutoRange(true);
		axis.setLabelPaint(Color.black);
		axis.setTickLabelPaint(Color.black);

		ChartPanel panel = new ChartPanel(chart);

		add(panel);
		setPreferredSize(new Dimension(-1, 300));
	}

	private void setData(double[] x, double[] y) {
		trace.methodeCall();
		XYSeries series = new XYSeries("Amplitudengang");
		for (int i = 1; i < x.length; i++) {
			series.add(x[i], 20.0 * Math.log(y[i]) / Math.log(10.0));
		}
		XYPlot xyplot = chart.getXYPlot();
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		xyplot.setDataset(dataset);
	}

	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		Model model = (Model) obs;
		setData(model.getFaxis(), model.getAmplitude());
		repaint();
	}

}
