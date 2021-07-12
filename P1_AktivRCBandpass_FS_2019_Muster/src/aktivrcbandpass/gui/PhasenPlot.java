package aktivrcbandpass.gui;

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

import aktivrcbandpass.model.Model;
import util.MyBorderFactory;
import util.Observable;
import util.TraceV7;

public class PhasenPlot extends JPanel {
	private TraceV7 trace = new TraceV7(this);
	private static final long serialVersionUID = 2848069135069767765L;
	private JFreeChart chart = ChartFactory.createXYLineChart("", "Frequenz [Hz]", "Phase [rad]", null,
			PlotOrientation.VERTICAL, false, false, false);;

	public PhasenPlot() {
		trace.constructorCall();
		this.setLayout(new BorderLayout());
		this.setBorder(MyBorderFactory.createMyBorder(" Phasengang "));

		// Farben und Settings
		chart.setBackgroundPaint(getBackground());
		XYPlot xyplot = chart.getXYPlot();
		xyplot.setBackgroundPaint(getBackground());
		xyplot.setRangeGridlinePaint(Color.black);
		xyplot.setDomainGridlinePaint(Color.black);
		xyplot.getRenderer().setSeriesPaint(0, Color.black);

		// x-Axis
		ValueAxis axis = xyplot.getDomainAxis();
		axis.setRange(0, 2e4);
		axis.setAutoRange(false);
		axis.setLabelPaint(Color.black);
		axis.setTickLabelPaint(Color.black);
		axis.setLabelFont(getFont().deriveFont(12.0f));
		axis.setTickLabelPaint(Color.black);
		axis.setTickLabelFont(getFont().deriveFont(12.0f));

		// y - Axis
		axis = xyplot.getRangeAxis();
		axis.setRange(-Math.PI, Math.PI);
		axis.setAutoRange(false);
		axis.setLabelPaint(Color.black);
		axis.setTickLabelPaint(Color.black);
		axis.setLabelFont(getFont().deriveFont(12.0f));
		axis.setTickLabelPaint(Color.black);
		axis.setTickLabelFont(getFont().deriveFont(12.0f));

		ChartPanel panel = new ChartPanel(chart);
		add(panel);
		setPreferredSize(new Dimension(500, 200));
	}

	private void setData(double[] x, double[] y) {
		trace.methodeCall();

		XYSeries series = new XYSeries("Phasengang");
		for (int i = 1; i < x.length; i++) {
			series.add(x[i], y[i]);
		}
		XYPlot xyplot = chart.getXYPlot();
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		xyplot.setDataset(dataset);
	}

	public void update(Observable obs, Object obj) {
		trace.methodeCall();

		Model model = (Model) obs;
		setData(model.getFAchse(), model.getPhase());
		repaint();
	}
}
