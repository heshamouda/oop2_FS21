package gui;

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

import model.Model;
import util.MyBorderFactory;
import util.Observable;

public class PlotPanel extends JPanel  {
	
	private JFreeChart chart = ChartFactory.createXYLineChart("Signal", "Samples", "Value", null,
			PlotOrientation.VERTICAL, false, false, false);
	

	public PlotPanel() {
		super(new BorderLayout());
		this.setBorder(MyBorderFactory.createMyBorder(" Signal Panel "));

		// Farben und Settings
		chart.setBackgroundPaint(getBackground());
		XYPlot xyplot = chart.getXYPlot();
		xyplot.setBackgroundPaint(getBackground());
		xyplot.setRangeGridlinePaint(Color.black);
		xyplot.setDomainGridlinePaint(Color.black);
		xyplot.getRenderer().setSeriesPaint(0, Color.red);
		xyplot.getRenderer().setSeriesPaint(1, Color.green);

		ValueAxis axis = xyplot.getDomainAxis();
		axis.setRange(0, 1e2);
		axis.setAutoRange(false);
		axis.setLabelPaint(Color.black);
		axis.setTickLabelPaint(Color.black);
		axis = xyplot.getRangeAxis();
		axis.setRange(-5, 5);
		axis.setAutoRange(false);
		axis.setLabelPaint(Color.black);
		axis.setTickLabelPaint(Color.black);

		ChartPanel panel = new ChartPanel(chart);
		add(panel, BorderLayout.CENTER);
		setPreferredSize(new Dimension(800, 450));

	}



	private void setData(double[] y, double[] filty) {
		XYSeries series1 = new XYSeries("XYGraph");
		XYSeries series2 = new XYSeries("XYGraph2");
		for (int i = 0; i < y.length; i++) {
			series1.add(i, y[i]);
			series2.add(i, filty[i]);

		}
		XYPlot xyPlot = chart.getXYPlot();
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);
		xyPlot.setDataset(dataset);
	}

	public void update(Observable obs, Object obj) {
		if (obs instanceof Model) {
			Model model = (Model) obs;
			setData(model.getSignal(), model.getFiltSignal());

		}
	}

}
