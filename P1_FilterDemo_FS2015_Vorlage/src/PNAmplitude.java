import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Observable;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class PNAmplitude extends JPanel implements ActionListener {
	private JFreeChart chart = ChartFactory.createXYLineChart("", "Frequenz", "Amplitude [dB]", null, PlotOrientation.VERTICAL,
			false, false, false);
	private XYPlot xyplot;
	private double frequency = 0.0;
	private Model model;
	private JPopupMenu popup = new JPopupMenu();

	public PNAmplitude() {
		super(new BorderLayout());
		setPreferredSize(new Dimension(650, 325));
		setBorder(MyBorderFactory.createBorder(" " + getClass().getName() + " "));

		JMenuItem item;
		popup.add(item = new JMenuItem("Reset Zoom"));
		item.setHorizontalTextPosition(SwingConstants.RIGHT);
		item.addActionListener(this);

		// Farben und Settings
		chart.setBackgroundPaint(getBackground());
		xyplot = chart.getXYPlot();

		xyplot.setBackgroundPaint(getBackground());
		xyplot.setRangeGridlinePaint(Color.black);
		xyplot.setDomainGridlinePaint(Color.black);
		xyplot.getRenderer().setSeriesPaint(0, Color.blue);
		xyplot.getRenderer().setSeriesPaint(1, Color.green);
		xyplot.getRenderer().setSeriesStroke(0, new BasicStroke(1.5f));
		xyplot.getRenderer().setSeriesStroke(1, new BasicStroke(1.0f));
		ValueAxis axis = xyplot.getDomainAxis();

		axis.setRange(0, 12e3);
		axis.setAutoRange(false);
		axis.setLabelPaint(Color.black);
		axis.setTickLabelPaint(Color.black);
		axis = xyplot.getRangeAxis();
		axis.setRange(-90, 10);
		axis.setAutoRange(false);
		axis.setLabelPaint(Color.black);
		axis.setTickLabelPaint(Color.black);

		ChartPanel panel = new ChartPanel(chart);
		panel.setBorder(new EmptyBorder(new Insets(0, 10, 0, 10)));
		panel.setPopupMenu(popup);
		add(panel);
		panel.addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {

				if (e.getWheelRotation() < 0) {
					frequency -= 50;
				} else {
					frequency += 50;
				}
				if (frequency < 0.0) frequency = 0.0;
				if (frequency > 11e3) frequency = 11e3;

				if (model != null) {
					model.setTestFrequenz(frequency);
				}
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				xyplot.getRenderer().setSeriesStroke(1, new BasicStroke(1.0f));
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				xyplot.getRenderer().setSeriesStroke(1, new BasicStroke(3.0f));
			}
		});
	}

	private void setData(double[] x, double[] y, double frequency) {
		this.frequency = frequency;
		XYPlot xyplot = chart.getXYPlot();

		// Amplitudengang
		XYSeries series = new XYSeries("Amplitudengang");
		for (int i = 1; i < x.length; i++) {
			series.add(x[i], 20.0 * Math.log10(y[i]));
		}

		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);

		// Frequenzpunkt
		series = new XYSeries("Amplitudengang");
		int i = 0;
		while (x[i] < frequency)
			i++;

		series.add(x[i], -90.0);
		series.add(x[i], 20.0 * Math.log10(y[i]));

		//	dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		xyplot.setDataset(dataset);

		repaint();
	}

	public void update(Observable obs, Object obj) {
		this.model = (Model) obs;
		setData(model.getFAxis(), model.getAmplitudengang(), model.getTestFrequenz());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		ValueAxis axis = xyplot.getDomainAxis();
		axis.setRange(0, 12e3);
		axis = xyplot.getRangeAxis();
		axis.setRange(-90, 10);
	}

}

