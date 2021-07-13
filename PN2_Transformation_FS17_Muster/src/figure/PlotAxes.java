package figure;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

/**
 $Author: bmo $<br>
 $Date: 2005/04/05 12:17:06 $<br>
 $Revision: 1.1 $<br>
 $Source: /home/stud/cvs/projects-bmo/Universelle_Datenerfassung/Applikation/src/figure/PlotAxes.java,v $<br>
 */
public class PlotAxes extends AbstractAxes implements MouseListener, MouseMotionListener {

	protected int majorTickLength = 10;
	protected int minorTickLength = 5;
	protected float lineWidth = 1.0f;
	protected double majorXTickSpacing = 1.0;
	protected double minorXTickSpacing = 0.2;
	protected double majorYTickSpacing = 1.0;
	protected double minorYTickSpacing = 0.2;
	protected String xLabel = null;
	protected String yLabel = null;
	protected String title = null;
	protected String strUnitX = "";
	protected String strUnitY = "";
	protected Font font = new Font("TimesRoman", Font.BOLD, 16);
	protected BufferedImage yLabelImg;
	protected Color txtColor = null;
	protected Color figColor = null;
	protected Color pltColor = null;
	protected Color tickColor = null;
	protected Color gridColor = null;
	protected Color lineColor = Color.black;

	public void setTextColor(Color color) {
		this.txtColor = color;
	}

	public void setFigureColor(Color color) {
		this.figColor = color;
	}

	public void setPlotColor(Color color) {
		this.pltColor = color;
	}

	public void setTickColor(Color color) {
		this.tickColor = color;
	}

	public void setGridColor(Color color) {
		this.gridColor = color;
	}

	public void setLineColor(Color color) {
		this.lineColor = color;
	}

	public void paintComponent(Graphics z) {
		if (sizeChanged) {
			if (figColor != null) {
				yLabelImg = rotateText(yLabel, font, txtColor, figColor);
			} else {
				yLabelImg = rotateText(yLabel, font, txtColor, getBackground());
			}
			calcInsets();
			sizeChanged = false;
		}
		Graphics2D g = (Graphics2D) z;
		g.setFont(font);
		// draw figure-area
		if (figColor != null) {
			g.setColor(figColor);
		} else {
			g.setColor(getBackground());
		}
		g.fillRect(0, 0, width, height);
		// draw plot-area
		if (pltColor != null) {
			g.setColor(pltColor);
		} else {
			g.setColor(getBackground());
		}
		g.fillRect(leftInset, topInset, innerWidth, innerHeight);
		// set line width
		g.setStroke(new BasicStroke(lineWidth));

		if (tickColor != null) {
			// Tick x-axis
			for (int i = (int) Math.ceil(xMin / majorXTickSpacing); i <= (int) Math.floor(xMax / majorXTickSpacing); i++) {
				g.setColor(tickColor);
				g.drawLine((int) (i * majorXTickSpacing * xScale + xOffset), (int) (innerHeight + topInset), (int) (i
						* majorXTickSpacing * xScale + xOffset), (int) (innerHeight + topInset + majorTickLength));
				if (font != null) {
					String tickText = "" + i * majorXTickSpacing;
					Rectangle2D r = g.getFontMetrics().getStringBounds(tickText, g);
					g.setColor(txtColor);
					g.drawString(tickText, (int) (i * majorXTickSpacing * xScale + xOffset - r.getWidth() / 2),
							(int) (innerHeight + topInset + r.getHeight()) + majorTickLength);
				}
			}
			g.setColor(tickColor);
			for (int i = (int) Math.ceil(xMin / minorXTickSpacing); i <= (int) Math.floor(xMax / minorXTickSpacing); i++) {
				g.drawLine((int) (i * minorXTickSpacing * xScale + xOffset), (int) (innerHeight + topInset), (int) (i
						* minorXTickSpacing * xScale + xOffset), (int) (innerHeight + topInset + minorTickLength));
			}
			// Tick y-axis
			for (int i = (int) Math.ceil(yMin / majorYTickSpacing); i <= (int) Math.floor(yMax / majorYTickSpacing); i++) {
				g.setColor(tickColor);
				g.drawLine((int) (leftInset - majorTickLength), (int) (-i * majorYTickSpacing * yScale + yOffset),
						(int) ((int) (leftInset)), (int) (-i * majorYTickSpacing * yScale + yOffset));
				if (font != null) {
					String tickText = "" + i * majorYTickSpacing;
					Rectangle2D r = getFontMetrics(font).getStringBounds(tickText, g);
					int h = getFontMetrics(font).getAscent();
					g.setColor(txtColor);
					g.drawString(tickText, (int) (leftInset - majorTickLength - r.getWidth() - 5), (int) (-i
							* majorYTickSpacing * yScale + yOffset + h / 2));
				}
			}
			g.setColor(tickColor);
			for (int i = (int) Math.ceil(yMin / minorYTickSpacing); i <= (int) Math.floor(yMax / minorYTickSpacing); i++) {
				g.drawLine((int) (leftInset - minorTickLength), (int) (-i * minorYTickSpacing * yScale + yOffset),
						(int) ((int) (leftInset)), (int) (-i * minorYTickSpacing * yScale + yOffset));
			}
		}
		if (txtColor != null) {
			// draw text
			g.setColor(txtColor);
			//Title
			if (title != null) {
				Rectangle2D r = g.getFontMetrics().getStringBounds(title, g);
				g
						.drawString(title, (int) ((innerWidth - r.getWidth()) / 2 + leftInset), (int) ((topInset + r
								.getHeight()) / 2));
			}
			// x-Label
			if (xLabel != null) {
				Rectangle2D r = g.getFontMetrics().getStringBounds(xLabel, g);
				g.drawString(xLabel, (int) ((innerWidth - r.getWidth()) / 2 + leftInset), (int) (innerHeight + topInset + 2 * r
						.getHeight())
						+ majorTickLength);
				r = g.getFontMetrics().getStringBounds(strUnitX, g);
				g.drawString(strUnitX, (int) (leftInset + innerWidth + 5), (int) (innerHeight + topInset + r.getHeight())
						+ majorTickLength);
			}
			// y-Label
			if (yLabel != null) {
				g.drawImage(yLabelImg, yLabelImg.getWidth() / 2, topInset + (innerHeight - yLabelImg.getHeight()) / 2, this);
				Rectangle2D r = g.getFontMetrics().getStringBounds(strUnitY, g);
				g.drawString(strUnitY, (int) (leftInset - majorTickLength - r.getWidth() - 5),
						(int) ((topInset + r.getHeight()) / 2));
			}
		}
		// draw grid
		if (gridColor != null) {
			g.setColor(gridColor);
			for (int i = (int) Math.ceil(xMin / majorXTickSpacing); i <= (int) Math.floor(xMax / majorXTickSpacing); i++) {
				g.drawLine((int) (i * majorXTickSpacing * xScale + xOffset), (int) (topInset), (int) (i * majorXTickSpacing
						* xScale + xOffset), (int) (innerHeight + topInset));
			}
			for (int i = (int) Math.ceil(yMin / majorYTickSpacing); i <= (int) Math.floor(yMax / majorYTickSpacing); i++) {
				g.drawLine((int) (leftInset), (int) (-i * majorYTickSpacing * yScale + yOffset),
						(int) ((int) (leftInset + innerWidth)), (int) (-i * majorYTickSpacing * yScale + yOffset));
			}
		}
		// draw frame
		g.setStroke(new BasicStroke(2.0f));
		g.setColor(lineColor);
		g.drawRect(leftInset, topInset, innerWidth, innerHeight);
		// clipp for subsequent plots
		g.clipRect(leftInset - 1, topInset - 1, innerWidth + 2, innerHeight + 2);
		for (int i = 0; i < axesObjectVector.size(); i++) {
			((AxesObject) axesObjectVector.elementAt(i)).paint(g);
		}
	}

	public void setUnitStrings(String unitX, String unitY) {
		if (unitX != null) {
			strUnitX = unitX;
		}
		if (unitY != null) {
			strUnitY = unitY;
		}
	}

	public void setLineWidth(float lineWidth) {
		this.lineWidth = lineWidth;
	}

	public double getLineWidth() {
		return lineWidth;
	}

	public void setTickLength(int majorTickLength, int minorTickLength) {
		this.majorTickLength = majorTickLength;
		this.minorTickLength = minorTickLength;
		sizeChanged = true;
	}

	public void setLabel(String xLabel, String yLabel) {
		this.xLabel = xLabel;
		this.yLabel = yLabel;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setTickSpacing(double majorXTickSpacing, double minorXTickSpacing, double majorYTickSpacing,
			double minorYTickSpacing) {
		this.majorXTickSpacing = majorXTickSpacing;
		this.minorXTickSpacing = minorXTickSpacing;
		this.majorYTickSpacing = majorYTickSpacing;
		this.minorYTickSpacing = minorYTickSpacing;
	}

	public void setXTickSpacing(double majorXTickSpacing, double minorXTickSpacing) {
		this.majorXTickSpacing = majorXTickSpacing;
		this.minorXTickSpacing = minorXTickSpacing;
	}

	public void setYTickSpacing(double majorYTickSpacing, double minorYTickSpacing) {
		this.majorYTickSpacing = majorYTickSpacing;
		this.minorYTickSpacing = minorYTickSpacing;
	}

	public double[] getTickSpacing() {
		return new double[] { majorXTickSpacing, minorXTickSpacing, majorYTickSpacing, minorYTickSpacing };
	}

	public double[] getXTickSpacing() {
		return new double[] { majorXTickSpacing, minorXTickSpacing };
	}

	public double[] getYTickSpacing() {
		return new double[] { majorYTickSpacing, minorYTickSpacing };
	}

	public void setSize(int width, int height) {
		super.setSize(width, height);
		sizeChanged = true;
	}

	public Font getFont() {
		return font;
	}

	public void setFont(Font font) {
		super.setFont(font);
		this.font = font;
		sizeChanged = true;
	}

	protected void calcInsets() {
		if (font != null) {
			int h = getFontMetrics(font).getHeight();
			int w = getFontMetrics(font).stringWidth("-XX.XX");

			if (title == null || title.length() == 0) {
				topInset = h;
			} else {
				topInset = 2 * h;
			}
			if (yLabel == null || yLabel.length() == 0) {
				leftInset = majorTickLength + w;
			} else {
				leftInset = h + majorTickLength + w;
			}
			if (xLabel == null || xLabel.length() == 0) {
				bottomInset = 1 * h + majorTickLength;
			} else {
				bottomInset = 2 * h + majorTickLength;
			}
			rightInset = getFontMetrics(font).stringWidth(strUnitX) + 15;
		} else {
			topInset = 5;
			bottomInset = 5;
			leftInset = 5;
			rightInset = 5;
		}
		innerWidth = width - leftInset - rightInset;
		innerHeight = height - topInset - bottomInset;
		calcScaling();
	}

	private BufferedImage rotateText(String text, Font font, Color txtColor, Color bgColor) {
		if (text == null || text.length() == 0) {
			return new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
		}
		Rectangle2D r = getFontMetrics(font).getStringBounds(text,
				(new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB)).getGraphics());
		BufferedImage txtImage = new BufferedImage((int) r.getHeight(), (int) r.getWidth(), BufferedImage.TYPE_INT_RGB);
		Graphics2D bg = (Graphics2D) txtImage.getGraphics();
		bg.setFont(font);
		bg.rotate(-Math.PI / 2.0);
		bg.translate(-r.getWidth(), 0);
		bg.setColor(getBackground());
		bg.fillRect(0, 0, (int) r.getWidth(), (int) r.getHeight());
		bg.setColor(txtColor);
		bg.drawString(text, 0, (int) (r.getHeight() - bg.getFontMetrics().getDescent()));
		return txtImage;
	}
}
