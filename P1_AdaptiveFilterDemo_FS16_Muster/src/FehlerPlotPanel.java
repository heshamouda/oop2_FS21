import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class FehlerPlotPanel extends JPanel {
	private static final long serialVersionUID = -4522467773085225830L;
	private JFreeChart chart = ChartFactory.createXYLineChart("", "", "", null, PlotOrientation.VERTICAL, false, false,
			false);

	public FehlerPlotPanel() {
		super(new BorderLayout());
		setPreferredSize(new Dimension(400, 150));

		// Farben und Settings
		chart.setBackgroundPaint(getBackground());
		XYPlot xyplot = chart.getXYPlot();
		xyplot.setBackgroundPaint(getBackground());
		xyplot.setRangeGridlinePaint(Color.black);
		xyplot.setDomainGridlinePaint(Color.black);
		xyplot.getRenderer().setSeriesStroke(0, new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
		xyplot.getRenderer().setSeriesPaint(0, new Color(0, 160, 0));

		ValueAxis axis = xyplot.getDomainAxis();
		axis.setRange(0, 1024);
		axis.setAutoRange(false);
		axis.setTickLabelsVisible(false);
		axis = xyplot.getRangeAxis();
		axis.setRange(-2.5, 2.5);
		axis.setAutoRange(false);
		axis.setTickLabelsVisible(true);

		ChartPanel panel = new ChartPanel(chart);
		add(panel);
	}

	public void setData(double[] y) {
		double[] x = new double[y.length];

		for (int i = 0; i < x.length; i++) {
			x[i] = i;
		}
		XYSeries series = new XYSeries("SignalPlot");
		for (int i = 1; i < x.length; i++) {
			series.add(x[i], y[i]);
		}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		chart.getXYPlot().setDataset(dataset);
		repaint();
	}

	public void update(Observable obs, Object obj) {
		Model model = (Model) obs;
		setData(model.getFehler());
	}

}
