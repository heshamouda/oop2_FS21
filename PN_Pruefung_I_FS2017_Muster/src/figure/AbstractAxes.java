package figure;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.JPanel;

/**
 * <p>
 * AbstractAxes:
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2008
 * </p>
 * 
 * <p>
 * Company: FHNW
 * </p>
 * 
 * @author Richard Gut
 * @version 1.0
 * 
 */
public abstract class AbstractAxes extends JPanel implements MouseListener, MouseMotionListener {
	/** Wahl der x/y Eigenschaft der Achsen. */
	public static final int LIN_LIN = 0, LOG_LIN = 1;
	/** x,y Position und Breite und Hoehe der Achsen inklusive Insets. */
	protected int x, y, width, height;
	/** Insets der Achsen */
	protected int bottomInset, topInset, leftInset, rightInset;
	/** Effektive Plotflaeche. */
	protected int innerWidth, innerHeight;
	/** x / y Offset und Skalierung */
	protected double xScale = 1, xOffset = 0, yScale = 1, yOffset = 0;
	/** x / y Maxima und Minima */
	protected double xMax = 1.0, xMin = -1.0, yMax = 1.0, yMin = -1.0;
	protected Vector axesObjectVector = new Vector();
	protected boolean sizeHasBeenSet = false;
	protected boolean sizeChanged = true;
	protected int axesMode = LIN_LIN;

	public AbstractAxes() {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.setDoubleBuffered(false);
	}

	public void addAxesObject(AxesObject object) {
		axesObjectVector.add(object);
		object.setParent(this);
		object.setScaling(xScale, xOffset, yScale, yOffset, axesMode);
		this.addMouseListener(object);
		this.addMouseMotionListener(object);
		repaint();
	}

	public void removeAxesObject(AxesObject object) {
		axesObjectVector.remove(object);
		object.setParent(null);
		this.removeMouseListener(object);
		this.removeMouseMotionListener(object);
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

	public double[] getXAxis() {
		return new double[] { xMin, xMax };
	}

	public double[] getYAxis() {
		return new double[] { yMin, yMax };
	}

	public void setAxesMode(int axesMode) {
		this.axesMode = axesMode;
	}

	protected void calcScaling() {
		switch (axesMode) {
			case LIN_LIN:
				xScale = innerWidth / (xMax - xMin);
				xOffset = xScale * -xMin + leftInset;
				break;
			case LOG_LIN:
				xScale = innerWidth / ((Math.log(xMax) / Math.log(10)) - (Math.log(xMin) / Math.log(10)));
				xOffset = xScale * -((Math.log(xMin) / Math.log(10))) + leftInset;
				break;
		}
		yScale = innerHeight / (yMax - yMin);
		yOffset = yScale * yMin + topInset + innerHeight;
		for (int i = 0; i < axesObjectVector.size(); i++) {
			((AxesObject) axesObjectVector.elementAt(i)).setScaling(xScale, xOffset, yScale, yOffset, axesMode);
		}
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
		repaint();
	}

	public void mouseReleased(MouseEvent mouseEvent) {
		repaint();
	}

	public void mouseDragged(MouseEvent mouseEvent) {
		repaint();
	}

	public void mouseClicked(MouseEvent mouseEvent) {}

	public void mouseEntered(MouseEvent mouseEvent) {}

	public void mouseExited(MouseEvent mouseEvent) {}

	public void mouseMoved(MouseEvent mouseEvent) {}
}
