package figure;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class AxesObject implements MouseListener, MouseMotionListener {
	protected AbstractAxes parent;
	protected double xScale = 1.0, xOffset = 0.0, yScale = 1.0, yOffset = 0.0;
	protected int axesMode = AbstractAxes.LIN_LIN;

	public AxesObject() {
	}

	public void mouseClicked(MouseEvent mouseEvent) {
	}

	public void mouseDragged(MouseEvent mouseEvent) {
	}

	public void mouseEntered(MouseEvent mouseEvent) {
	}

	public void mouseExited(MouseEvent mouseEvent) {
	}

	public void mouseMoved(MouseEvent mouseEvent) {
	}

	public void mousePressed(MouseEvent mouseEvent) {
	}

	public void mouseReleased(MouseEvent mouseEvent) {
	}

	public abstract void paint(Graphics2D g);

	public int scaleX(double x) {
		if (axesMode == AbstractAxes.LIN_LIN) {
			return (int) Math.round(x * xScale + xOffset);
		}
		if (axesMode == AbstractAxes.LOG_LIN) {
			return (int) Math.round((Math.log(x) / Math.log(10)) * xScale + xOffset);
		}
		return 0;
	}

	public int scaleY(double y) {
		if (axesMode == AbstractAxes.LIN_LIN || axesMode == AbstractAxes.LOG_LIN) {
			return (int) Math.round(-y * yScale + yOffset);
		}
		return 0;
	}

	public void setParent(AbstractAxes parent) {
		this.parent = parent;
	}

	public void setScaling(double xScale, double xOffset, double yScale, double yOffset, int axesMode) {
		this.xScale = xScale;
		this.xOffset = xOffset;
		this.yScale = yScale;
		this.yOffset = yOffset;
		this.axesMode = axesMode;
	}

	public abstract void setStyle(String lineStyle);
}
