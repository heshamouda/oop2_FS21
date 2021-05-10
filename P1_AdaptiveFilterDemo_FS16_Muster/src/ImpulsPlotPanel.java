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

public class ImpulsPlotPanel extends JPanel {
	private static final long serialVersionUID = -4522467773085225830L;
	private JFreeChart chart = ChartFactory.createXYLineChart("", "", "", null, PlotOrientation.VERTICAL, false, false,
			false);

	public ImpulsPlotPanel() {
		super(new BorderLayout());
		setPreferredSize(new Dimension(400, 150));

		// Farben und Settings
		chart.setBackgroundPaint(getBackground());
		XYPlot xyplot = chart.getXYPlot();
		xyplot.setBackgroundPaint(getBackground());
		xyplot.setRangeGridlinePaint(Color.black);
		xyplot.setDomainGridlinePaint(Color.black);
		xyplot.getRenderer().setSeriesPaint(0, Color.red);
		xyplot.getRenderer().setSeriesPaint(1, Color.blue);
		xyplot.getRenderer().setSeriesStroke(0, new BasicStroke(4f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));
		xyplot.getRenderer().setSeriesStroke(1, new BasicStroke(6f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));

		ValueAxis axis = xyplot.getDomainAxis();
		axis.setRange(0, 32);
		axis.setAutoRange(false);
		axis.setTickLabelsVisible(false);
		axis = xyplot.getRangeAxis();
		axis.setRange(-0.10, 0.10);
		axis.setAutoRange(false);
		axis.setTickLabelsVisible(true);

		ChartPanel panel = new ChartPanel(chart);
		add(panel);
	}

	public void setData(double[] hEstimate) {
		double[] x = new double[hEstimate.length];

		for (int i = 0; i < x.length; i++) {
			x[i] = i;
		}
		XYSeries xyEstimate = new XYSeries("Estimate");
		for (int i = 1; i < x.length; i++) {
			xyEstimate.add(x[i], hEstimate[i]);
		}

		XYSeriesCollection dataEstimate = new XYSeriesCollection();
		dataEstimate.addSeries(xyEstimate);
		chart.getXYPlot().setDataset(dataEstimate);

		repaint();
	}

	public void update(Observable obs, Object obj) {
		Model model = (Model) obs;
		setData(model.getLMSFilterCoeffs());
	}

}
