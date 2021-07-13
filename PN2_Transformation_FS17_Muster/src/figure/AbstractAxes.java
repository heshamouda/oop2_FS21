package figure;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.JPanel;

public abstract class AbstractAxes extends JPanel implements MouseListener, MouseMotionListener {
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected int innerWidth;
	protected int innerHeight;
	protected int bottomInset;
	protected int topInset;
	protected int leftInset;
	protected int rightInset;
	protected double xScale = 1;
	protected double xOffset = 0;
	protected double yScale = 1;
	protected double yOffset = 0;
	protected double xMax = 1.0;
	protected double xMin = -1.0;
	protected double yMax = 1.0;
	protected double yMin = -1.0;
	protected Vector axesObjectVector = new Vector();
	protected boolean sizeHasBeenSet = false;
	protected boolean sizeChanged = true;
	protected int axesMode = LIN_LIN;
	public static int LIN_LIN = 0, LOG_LIN = 1, LIN_LOG = 2, LOG_LOG = 3;

	public AbstractAxes() {
		try {
			jbInit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public AbstractAxes(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		sizeHasBeenSet = true;
		try {
			jbInit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	void jbInit() throws Exception {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setDoubleBuffered(false);
	}

	public void addAxesObject(AxesObject object) {
		axesObjectVector.add(object);
		object.setParent(this);
		update();
	}

	public void removeAxesObject(AxesObject object) {
		axesObjectVector.remove(object);
		object.setParent(null);
	}

	public void setAxis(double xMin, double xMax, double yMin, double yMax) {
		this.xMax = xMax;
		this.xMin = xMin;
		this.yMax = yMax;
		this.yMin = yMin;
		calcScaling();
		repaint();
	}

	public void setXAxis(double xMin, double xMax) {
		this.xMax = xMax;
		this.xMin = xMin;
		calcScaling();
		repaint();
	}

	public void setYAxis(double yMin, double yMax) {
		this.yMax = yMax;
		this.yMin = yMin;
		calcScaling();
		repaint();
	}

	public void setAxesMode(int axesMode) {
		this.axesMode = axesMode;
	}

	public double[] getXAxis() {
		return new double[] { xMin, xMax };
	}

	public double[] getYAxis() {
		return new double[] { yMin, yMax };
	}

	protected void calcScaling() {
		/** @todo Skalierung fuer log aendern */
		if ((axesMode == LIN_LIN) || (axesMode == LIN_LOG)) {
			xScale = innerWidth / (xMax - xMin);
			xOffset = xScale * -xMin + leftInset;
		}
		if ((axesMode == LIN_LIN) || (axesMode == LOG_LIN) || (axesMode == LIN_LOG) || (axesMode == LOG_LOG)) {
			yScale = innerHeight / (yMax - yMin);
			yOffset = yScale * yMin + topInset + innerHeight;
		}
		if ((axesMode == LOG_LIN) || (axesMode == LOG_LOG)) {
			if (xMin > 0) {
				xScale = innerWidth / ((Math.log(xMax) / Math.log(10)) - (Math.log(xMin) / Math.log(10)));
				xOffset = xScale * -((Math.log(xMin) / Math.log(10))) + leftInset;
			} else {
				xScale = innerWidth / (Math.log(xMax) / Math.log(10));
				xOffset = leftInset;
			}
		}

		for (int i = 0; i < axesObjectVector.size(); i++) {
			((AxesObject) axesObjectVector.elementAt(i)).setScaling(xScale, xOffset, yScale, yOffset, axesMode);
		}
	}

	public void update() {
		sizeChanged = true;
		calcScaling();
		repaint();
	}

	public void setBounds(int x, int y, int width, int height) {
		super.setBounds(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		sizeChanged = true;
	}

	public void setBounds(Rectangle r) {
		super.setBounds(x, y, width, height);
		this.x = r.x;
		this.y = r.y;
		this.width = r.width;
		this.height = r.height;
		sizeChanged = true;
	}

	public synchronized Dimension getMaximumSize() {
		if (sizeHasBeenSet) {
			return new Dimension(width, height);
		} else {
			return super.getMaximumSize();
		}
	}

	public synchronized Dimension getMinimumSize() {
		if (sizeHasBeenSet) {
			return new Dimension(width, height);
		} else {
			return super.getMinimumSize();
		}
	}

	public synchronized Dimension getPreferredSize() {
		if (sizeHasBeenSet) {
			return new Dimension(width, height);
		} else {
			return super.getPreferredSize();
		}
	}

	public void mousePressed(MouseEvent mouseEvent) {
		int x = mouseEvent.getX();
		int y = mouseEvent.getY();
		if (x < leftInset || x > leftInset + innerWidth || y < topInset || y > topInset + innerHeight) {
			return;
		}
		for (int i = axesObjectVector.size() - 1; i >= 0; i--) {
			((MouseListener) axesObjectVector.elementAt(i)).mousePressed(mouseEvent);
		}
	}

	public void mouseReleased(MouseEvent mouseEvent) {
		int x = mouseEvent.getX();
		int y = mouseEvent.getY();
		if (x < leftInset || x > leftInset + innerWidth || y < topInset || y > topInset + innerHeight) {
			return;
		}
		for (int i = axesObjectVector.size() - 1; i >= 0; i--) {
			((MouseListener) axesObjectVector.elementAt(i)).mouseReleased(mouseEvent);
		}
	}

	public void mouseDragged(MouseEvent mouseEvent) {
		int x = mouseEvent.getX();
		int y = mouseEvent.getY();
		if (x < leftInset || x > leftInset + innerWidth || y < topInset || y > topInset + innerHeight) {
			return;
		}
		for (int i = axesObjectVector.size() - 1; i >= 0; i--) {
			((MouseMotionListener) axesObjectVector.elementAt(i)).mouseDragged(mouseEvent);
		}
	}

	public void mouseClicked(MouseEvent mouseEvent) {}

	public void mouseEntered(MouseEvent mouseEvent) {}

	public void mouseExited(MouseEvent mouseEvent) {}

	public void mouseMoved(MouseEvent mouseEvent) {}

}
