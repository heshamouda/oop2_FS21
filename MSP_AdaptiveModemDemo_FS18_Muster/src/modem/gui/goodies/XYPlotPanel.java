package modem.gui.goodies;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;

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
	int index = 0;

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

	XYSeriesCollection dataset;

	@Override
	public void paintComponent(Graphics g) {
		try {
			super.paintComponent(g);
		} catch (Exception e) {
			System.out.println("Got'cha");
		}
	}

	public void setData(double[] x, double[] y) {
		if (!isShowing() || x.length == 0 || y.length == 0)
			return;

		try {
			index = 0;
			dataset = new XYSeriesCollection();
			XYSeries series = new XYSeries("Plot" + index);
			for (int i = 0; i < x.length; i++) {
				series.add(x[i], y[i]);
			}
			dataset.addSeries(series);
			chart.getXYPlot().setDataset(index++, dataset);
		} catch (Exception e) {
			System.out.println("PROBLEM in Plot");
		}
	}

	public void addData(double[] x, double[] y) {
		if (!isShowing() || x.length == 0 || y.length == 0)
			return;

		try {
			XYSeries series = new XYSeries("Plot" + index);
			for (int i = 0; i < x.length; i++) {
				series.add(x[i], y[i]);
			}
			dataset.addSeries(series);
			chart.getXYPlot().setDataset(index++, dataset);
		} catch (Exception e) {
			System.out.println("PROBLEM in Plot");
		}
	}

	public void addData(double[] x, double[] y, double scale) {
		if (!isShowing() || x.length == 0 || y.length == 0)
			return;

		try {
			XYSeries series = new XYSeries("Plot" + index);
			for (int i = 0; i < x.length; i++) {
				series.add(x[i], scale * y[i]);
			}
			dataset.addSeries(series);
			chart.getXYPlot().setDataset(index++, dataset);
		} catch (Exception e) {
			System.out.println("PROBLEM in Plot");
		}
	}
}
