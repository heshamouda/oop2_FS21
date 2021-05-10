package impulsdemo.gui.goodies;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

import javax.swing.JPanel;

import org.apache.commons.math3.complex.Complex;

import impulsdemo.TraceV2;

//DIESE DATEI MUSS NICHT BEARBEITET WERDEN! SIE WIRD NICHT BEWERTET!

public class ZeigerPlot extends JPanel {
	private TraceV2 tr = new TraceV2(this);
	private static final long serialVersionUID = 1L;
	Complex[] data = new Complex[0];
	private Complex[] tail = new Complex[125];
	private int tailIndex = 0;
	private static boolean doUpdate = true;
	protected double dx_tail = 0.0025;

	public ZeigerPlot() {
		tr.constructorCall();
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				doUpdate = !doUpdate;
			}
		});
		Font font = getFont();
		setFont(font.deriveFont(Font.ITALIC));
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

		double scale = Math.min((double) (this.getWidth()), (double) (this.getHeight())) * 2.0;

		double xCenter = this.getWidth() / 2;
		double yCenter = this.getHeight() / 2;

		g.setColor(Color.black);
		((Graphics2D) g).setStroke(new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));

		drawArrow(g, (int) (xCenter - scale), (int) (yCenter), (int) (xCenter + scale), (int) (yCenter));
		drawArrow(g, (int) (xCenter), (int) (yCenter + scale), (int) (xCenter), (int) (yCenter - scale));

		g.setColor(Color.red);
		g.drawString("Re{}", (int) (xCenter + scale - 25), (int) (yCenter - 10));
		g.drawString("Im{}", (int) (xCenter - 30), (int) (yCenter - scale + 15));

		((Graphics2D) g).setStroke(new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND));

		if (data.length > 1) {
			Complex startPunkt = new Complex(0, 0);
			Complex endPunkt = null;
			for (int i = 0; i < data.length; i++) {
				if (data[i] != null && data[i].abs() > 1e-16) {
					g.setColor(Color.red);

					endPunkt = startPunkt.add(data[i]);
					drawArrow(g, (xCenter + scale * startPunkt.getReal()),
							(yCenter - scale * startPunkt.getImaginary()), (xCenter + scale * endPunkt.getReal()),
							(yCenter - scale * endPunkt.getImaginary()));
					startPunkt = endPunkt;
				}
			}
			tail[tailIndex] = endPunkt;

			for (int i = 0; i < tail.length; i++) {
				if (tail[(tailIndex - i + tail.length) % tail.length] != null) {

					Color c = getBackground();
					g.setColor(new Color((int) (i * (float) c.getRed() / tail.length),
							(int) (i * (float) c.getGreen() / tail.length),
							(int) (255 - i * (255.0 - c.getBlue()) / tail.length)));

					Complex punkt = tail[(tailIndex - i + tail.length) % tail.length];
					g.fillOval((int) (xCenter + scale * punkt.getReal()) - 2, (int) (yCenter - scale * dx_tail * i) - 2,
							4, 4);
				}
			}
			tailIndex = (tailIndex + 1) % tail.length;

		} else {
			Complex startPunkt = new Complex(0, 0);
			for (int i = 0; i < data.length; i++) {
				if (data[i] != null) {
					g.setColor(Color.red);
					Complex endPunkt = startPunkt.add(data[i]);
					drawArrow(g, (xCenter + scale * startPunkt.getReal()),
							(yCenter - scale * startPunkt.getImaginary()), (xCenter + scale * endPunkt.getReal()),
							(yCenter - scale * endPunkt.getImaginary()));
					g.setColor(Color.blue);
					g.fillOval((int) (xCenter + scale * endPunkt.getReal()) - 2,
							(int) (yCenter - scale * endPunkt.getImaginary()) - 2, 4, 4);
				}
			}
		}
	}

	private void drawArrow(Graphics g, double x_tail, double y_tail, double x_tip, double y_tip) {
		Graphics2D g2 = (Graphics2D) g;
		double phi = Math.toRadians(15);
		double barb = 10;
		double dy = y_tip - y_tail;
		double dx = x_tip - x_tail;
		double theta = Math.atan2(dy, dx);
		double x, y, rho = theta + phi;
		g2.draw(new Line2D.Double(x_tail, y_tail, x_tip, y_tip));
		for (int j = 0; j < 2; j++) {
			x = x_tip - barb * Math.cos(rho);
			y = y_tip - barb * Math.sin(rho);
			g2.draw(new Line2D.Double(x_tip, y_tip, x, y));
			rho = theta - phi;
		}
	}

	public void drawArrowHead(Graphics g, int x_tail, int y_tail, int x_tip, int y_tip) {
		Graphics2D g2 = (Graphics2D) g;
		double phi = Math.toRadians(40);
		double barb = 20;
		double dy = y_tip - y_tail;
		double dx = x_tip - x_tail;
		double theta = Math.atan2(dy, dx);
		double x, y, rho = theta + phi;
		for (int j = 0; j < 2; j++) {
			x = x_tip - barb * Math.cos(rho);
			y = y_tip - barb * Math.sin(rho);
			g2.draw(new Line2D.Double(x_tip, y_tip, x, y));
			rho = theta - phi;
		}
	}

	public void drawArrowHead(Graphics g, Point tip, Point tail) {
		Graphics2D g2 = (Graphics2D) g;
		double phi = Math.toRadians(40);
		double barb = 20;
		double dy = tip.y - tail.y;
		double dx = tip.x - tail.x;
		double theta = Math.atan2(dy, dx);
		double x, y, rho = theta + phi;
		for (int j = 0; j < 2; j++) {
			x = tip.x - barb * Math.cos(rho);
			y = tip.y - barb * Math.sin(rho);
			g2.draw(new Line2D.Double(tip.x, tip.y, x, y));
			rho = theta - phi;
		}
	}

	public void setData(Complex[] data) {
		if (isVisible() && doUpdate) {
			this.data = data;
			repaint();
		}
	}

	public void setData(Complex data) {
		setData(new Complex[] { data });
	}

	public void setData(Complex data1, Complex data2) {
		setData(new Complex[] { data1, data2 });
	}

	public void clearTail() {
		tail = new Complex[125];
		tailIndex = 0;
	}
}
