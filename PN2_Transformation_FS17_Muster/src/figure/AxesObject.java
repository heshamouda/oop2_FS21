package figure;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 $Author: beinert $<br>
 $Date: 2005/08/04 13:21:06 $<br>
 $Revision: 1.4 $<br>
 $Source: /home/stud/cvs/projects-bmo/Universelle_Datenerfassung/Applikation/src/figure/AxesObject.java,v $<br>
 *
 * AxesObject koennen folgende Ausgestalltung haben: Line, Rechteck, Polygon, Kreis, TextFeld, ...
 *
 */
public abstract class AxesObject implements MouseListener, MouseMotionListener {
	protected AbstractAxes parent;
	protected double xScale = 1.0, xOffset = 0.0, yScale = 1.0, yOffset = 0.0;
	protected int axesMode;

	public AxesObject() {}

	public abstract void paint(Graphics2D g);

	public abstract void setStyle(String lineStyle);

	public void setScaling(double xScale, double xOffset, double yScale, double yOffset, int axesMode) {
		this.xScale = xScale;
		this.xOffset = xOffset;
		this.yScale = yScale;
		this.yOffset = yOffset;
		this.axesMode = axesMode;
	}

	public int scaleX(double x) {
		/** @todo Skalierung fuer log aendern */
		if (axesMode == AbstractAxes.LIN_LIN || axesMode == AbstractAxes.LIN_LOG) {
			return (int) Math.round(x * xScale + xOffset);
		}
		if (axesMode == AbstractAxes.LOG_LIN || axesMode == AbstractAxes.LOG_LOG) {
			return (int) Math.round((Math.log(x) / Math.log(10)) * xScale + xOffset);
		}
		return 0;
	}

	public int scaleY(double y) {
		if (axesMode == AbstractAxes.LIN_LIN || axesMode == AbstractAxes.LIN_LOG || axesMode == AbstractAxes.LOG_LIN
				|| axesMode == AbstractAxes.LOG_LOG) {
			return (int) Math.round(-y * yScale + yOffset);
		}
		return 0;
	}

	public void setParent(AbstractAxes parent) {
		this.parent = parent;
	}

	public void mouseClicked(MouseEvent mouseEvent) {}

	public void mouseEntered(MouseEvent mouseEvent) {}

	public void mouseExited(MouseEvent mouseEvent) {}

	public void mouseMoved(MouseEvent mouseEvent) {}

	public void mousePressed(MouseEvent mouseEvent) {}

	public void mouseReleased(MouseEvent mouseEvent) {}

	public void mouseDragged(MouseEvent mouseEvent) {}

}