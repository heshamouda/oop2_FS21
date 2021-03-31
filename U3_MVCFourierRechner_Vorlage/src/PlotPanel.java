import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import util.MyBorderFactory;
import util.Observable;
import util.TraceV4;

public class PlotPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private TraceV4 trace = new TraceV4(this);
	private double[] signal;

	public PlotPanel() {
		trace.constructorCall();
		setLayout(null);
		setBorder(MyBorderFactory.createMyBorder(" Plot "));
		setPreferredSize(new Dimension(750, 500));
	}

	@Override
	/**
	 * <pre>
	 * - Zeichnet Axen...
	 * - Zeichnet Plot...
	 * - Zeichnet Raster
	 * </pre>
	 */
	public void paintComponent(Graphics g) {
		trace.paintCall();
		super.paintComponent(g);

		if (signal != null) {
			double w = getWidth(), h = getHeight();
			int xOffset = 25, yOffset = (int) (h / 2);
			//double xScale = (w - 50) / signal.length, yScale = 0.75 * (h - 50) / 2;
			double xScale = (w - 50) / signal.length, yScale = 0.5 * (h - 50) / 2;

			int[] x = new int[signal.length];
			int[] y = new int[signal.length];

			for (int i = 0; i < signal.length; i++) {
				x[i] = (int) (xOffset + i * xScale);
				y[i] = (int) (yOffset - yScale * signal[i]);
			}

			g.setColor(Color.blue);
			((Graphics2D) g).setStroke(new BasicStroke(3));
			g.drawPolyline(x, y, x.length);

			g.setColor(Color.black);
			((Graphics2D) g).setStroke(new BasicStroke(1));
			g.drawLine(xOffset, yOffset, (int) (w - 25), yOffset); // x Achse
			g.drawLine(xOffset, 25, xOffset, (int) (h - 25)); // Y Achse
		}
	}

	/**
	 * - holt sich die aktuellen Daten aus Modell zum update (repaint)
	 * @param obs
	 * @param obj
	 */
	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		if (obs instanceof Model) {
			Model model = (Model) obs;
			signal = model.getSignal();
			repaint();
		}
	
	}
}

