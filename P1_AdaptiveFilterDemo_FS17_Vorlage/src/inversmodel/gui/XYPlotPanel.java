package inversmodel.gui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class XYPlotPanel extends JPanel {
	private static final long serialVersionUID = -4522467773085225830L;
	private JFreeChart chart;

	public XYPlotPanel(String title, String xLabel, String yLabel, double[] range, boolean[] autoRange,
			boolean[] tickLabelsVisible, Color seriesPaint) {
		super(new BorderLayout());

		chart = ChartFactory.createXYLineChart(title, xLabel, yLabel, null, PlotOrientation.VERTICAL, false, false,
				false);

		// Farben und Settings
		chart.setBackgroundPaint(getBackground());
		XYPlot xyplot = chart.getXYPlot();
		xyplot.setBackgroundPaint(getBackground());
		xyplot.setRangeGridlinePaint(Color.black);
		xyplot.setDomainGridlinePaint(Color.black);

		ValueAxis xAxis = xyplot.getDomainAxis(0);
		xAxis.setRange(range[0], range[1]);
		xAxis.setAutoRange(autoRange[0]);
		xAxis.setTickLabelsVisible(tickLabelsVisible[0]);

		ValueAxis yAxis = xyplot.getRangeAxis(0);
		yAxis.setRange(range[2], range[3]);
		yAxis.setAutoRange(autoRange[1]);
		yAxis.setTickLabelsVisible(tickLabelsVisible[1]);

		XYItemRenderer renderer = new StandardXYItemRenderer();
		renderer.setSeriesStroke(0, new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
		renderer.setSeriesPaint(0, seriesPaint);
		xyplot.setRenderer(0, renderer);

		add(new ChartPanel(chart));
	}

	XYSeriesCollection dataset = new XYSeriesCollection();

	public void setData(double[] y) {
		if (!isShowing())
			return;

		try {
			if (y.length == 0)
				return;

			double[] x = new double[128];

			for (int i = 0; i < x.length; i++) {
				x[i] = i;
			}

			dataset.removeAllSeries();
			XYSeries series = new XYSeries("Plot");
			for (int i = 1; i < x.length; i++) {
				series.add(x[i], y[i]);
			}

			dataset.addSeries(series);
			chart.getXYPlot().setDataset(0, dataset);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("PROBLEM in Plot");
		}
	}

	public void setData(double[] x, double[] y) {
		if (!isShowing())
			return;

		try {
			if (y.length == 0)
				return;

			dataset.removeAllSeries();
			XYSeries series = new XYSeries("Plot");
			for (int i = 1; i < x.length; i++) {
				series.add(x[i], y[i]);
			}

			dataset.addSeries(series);
			chart.getXYPlot().setDataset(0, dataset);
		} catch (IndexOutOfBoundsException e) {
			System.out.println("PROBLEM in Plot");
		}

	}
}
