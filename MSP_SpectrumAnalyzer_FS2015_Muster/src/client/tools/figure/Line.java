package client.tools.figure;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.util.Vector;

/**
 $Author:$<br>
 $Date: $<br>
 $Revision:$<br>
 $Source: $<br>
 */
public class Line
    extends AxesObject {
  protected double[] xData = new double[0], yData = new double[0];
  protected int[] xDataInt = new int[0], yDataInt = new int[0];
  protected String style;
  protected Color color = Color.black;
  protected float lineWidth = 1.0f;
  protected Vector<Marker> markerVector = new Vector<Marker>();
  protected boolean isSelected = false;
  protected Vector<LineListener> lineListenerVector = new Vector<LineListener>();
  protected float[] dash = null;

  public Line() {}

  public Line(Color color) {
    this.color = color;
  }

  public Line(double[] xData, double[] yData) {
    if (xData == null || yData == null) {
      return;
    }
    xDataInt = new int[xData.length];
    yDataInt = new int[yData.length];
    this.xData = xData;
    this.yData = yData;
  }

  public void addLineListener(LineListener lineListener) {
    lineListenerVector.add(lineListener);
  }

  public void addMarker(Marker marker) {
    markerVector.add(marker);
    marker.setLine(this);
  }

  public float getWidth() {
    return lineWidth;
  }

  public double[] getXData() {
    return xData;
  }

  public double[] getYData() {
    return yData;
  }

  protected double minDistance(double x, double y, double tolerance) {
    double dmin = Double.MAX_VALUE;
    for (int i = 0; i < xDataInt.length - 1; i++) {
      double dPoints = Point2D.distance(xDataInt[i], yDataInt[i], xDataInt[i + 1], yDataInt[i + 1]);
      if (Point2D.distance(xDataInt[i], yDataInt[i], x, y) < dPoints + tolerance || Point2D.distance(xDataInt[i + 1], yDataInt[i + 1], x, y) < dPoints + tolerance) {
        double dx = xDataInt[i + 1] - xDataInt[i];
        double dy = yDataInt[i + 1] - yDataInt[i];
        double theta = Math.atan2(dx, dy);
        AffineTransform at1 = new AffineTransform(1.0, 0.0, 0.0, 1.0, -xDataInt[i + 1], -yDataInt[i + 1]);
        AffineTransform at2 = new AffineTransform(Math.cos(theta), Math.sin(theta), -Math.sin(theta), Math.cos(theta), 0.0, 0.0);
        at2.concatenate(at1);
        Point2D p1 = at2.transform( (Point2D)new Point2D.Double(xDataInt[i], yDataInt[i]), null);
        Point2D pXY = at2.transform( (Point2D)new Point2D.Double(x, y), null);
        double c = Math.abs(pXY.getX());
        if (pXY.getY() < p1.getY()) {
          c = Point2D.distance(xDataInt[i], yDataInt[i], x, y);
        }
        if (pXY.getY() > 0.0) {
          c = Point2D.distance(xDataInt[i + 1], yDataInt[i + 1], x, y);
        }
        if (c < dmin) {
          dmin = c;
        }
      }
    }
    return dmin;
  }

  public void mouseDragged(MouseEvent mouseEvent) {
    if (xData == null || yData == null || xData.length == 0 || yData.length == 0) {
      return;
    }

    if (markerVector.size() != 0) {
      for (int i = markerVector.size() - 1; i >= 0 && !mouseEvent.isConsumed(); i--) {
        markerVector.elementAt(i).mouseDragged(mouseEvent);
      }
    }
    if (!mouseEvent.isConsumed()) {
      if (lineListenerVector.size() == 0) {
        return;
      }
      if (isSelected) {
        int x = mouseEvent.getX();
        int y = mouseEvent.getY();
        for (int i = 0; i < lineListenerVector.size(); i++) {
          lineListenerVector.elementAt(i).lineDragged( (x - xOffset) / xScale, ( -y + yOffset) / yScale, xData, yData);
        }
        parent.repaint();
      }
    }
  }

  public void mousePressed(MouseEvent mouseEvent) {
    if (xData == null || yData == null || xData.length == 0 || yData.length == 0) {
      return;
    }

    if (markerVector.size() != 0) {
      for (int i = markerVector.size() - 1; i >= 0 && !mouseEvent.isConsumed(); i--) {
        markerVector.elementAt(i).mousePressed(mouseEvent);
      }
    }
    if (!mouseEvent.isConsumed()) {
      if (lineListenerVector.size() == 0) {
        return;
      }

      int x = mouseEvent.getX();
      int y = mouseEvent.getY();
      if (minDistance(x, y, 5.0) < 5.0) {
        mouseEvent.consume();
        isSelected = true;
        for (int i = 0; i < lineListenerVector.size(); i++) {
          lineListenerVector.elementAt(i).linePressed( (x - xOffset) / xScale, ( -y - yOffset) / yScale, xData, yData);
        }
        parent.repaint();
      }
    }
  }

  public void mouseReleased(MouseEvent mouseEvent) {
    if (xData == null || yData == null || xData.length == 0 || yData.length == 0) {
      return;
    }

    if (markerVector.size() != 0) {
      for (int i = markerVector.size() - 1; i >= 0 && !mouseEvent.isConsumed(); i--) {
        markerVector.elementAt(i).mouseReleased(mouseEvent);
      }
    }
    if (!mouseEvent.isConsumed()) {
      if (lineListenerVector.size() == 0) {
        return;
      }
      if (isSelected) {
        int x = mouseEvent.getX();
        int y = mouseEvent.getY();
        isSelected = false;
        for (int i = 0; i < lineListenerVector.size(); i++) {
          lineListenerVector.elementAt(i).lineReleased( (x - xOffset) / xScale, (y - yOffset) / yScale, xData, yData);
        }
        parent.repaint();
      }
    }
  }

  public void paint(Graphics2D g) {
    if (xData == null || yData == null || xData.length == 0 || yData.length == 0 || color == null) {
      return;
    }

    BasicStroke s = (BasicStroke) g.getStroke();
    Color c = g.getColor();
    g.setStroke(new BasicStroke(lineWidth, s.getEndCap(), s.getLineJoin(), s.getMiterLimit(), dash, 0.0f));
    g.setColor(color);
    g.drawPolyline(xDataInt, yDataInt, Math.min(xDataInt.length, yDataInt.length));
    g.setColor(c);
    g.setStroke(s);

    if (markerVector.size() != 0) {
      for (int i = 0; i < markerVector.size(); i++) {
        markerVector.elementAt(i).paint( (Graphics2D) g);
      }
    }
  }

  public void removeLineListener(LineListener lineListener) {
    lineListenerVector.remove(lineListener);
  }

  public void removeMarker(Marker marker) {
    markerVector.remove(marker);
  }

  public void setColor(Color lineColor) {
    this.color = lineColor;
  }

  public void setData(double[] xData, double[] yData) {
    setXData(xData);
    setYData(yData);
  }

  public void setData(double[] xData, double[] yData, int length) {
    setXData(xData, length);
    setYData(yData, length);
  }

  public void setScaling(double xScale, double xOffset, double yScale, double yOffset, int axesMode) {
    super.setScaling(xScale, xOffset, yScale, yOffset, axesMode);
    if (xData == null || yData == null) {
      return;
    }
    for (int i = 0; i < xData.length; i++) {
      xDataInt[i] = scaleX(xData[i]);
    }
    for (int i = 0; i < yData.length; i++) {
      yDataInt[i] = scaleY(yData[i]);
    }
  }

  public void setStyle(String lineStyle) {
    if (lineStyle == null || lineStyle.equals("")) {
      return;
    }
    int c = 0;
    dash = new float[2 * lineStyle.length()];
    for (int i = 0; i < lineStyle.length(); i++) {
      if (lineStyle.charAt(i) == '-') {
        dash[c++] = 10.0f;
        dash[c++] = 0.0f;
      }
      if (lineStyle.charAt(i) == ' ') {
        dash[c++] = 0.0f;
        dash[c++] = 10.0f;
      }
      if (lineStyle.charAt(i) == '.') {
        dash[c++] = 2.0f;
        dash[c++] = 8.0f;
      }
    }
    this.style = lineStyle;
  }

  public void setWidth(float lineWidth) {
    this.lineWidth = lineWidth;
  }

  public void setXData(double[] xData) {
    if (xData == null) {
      return;
    }
    if (xDataInt.length != xData.length) {
      xDataInt = new int[xData.length];
    }
    for (int i = 0; i < xData.length; i++) {
      xDataInt[i] = scaleX(xData[i]);
    }
    this.xData = xData;
  }

  public void setXData(double[] xData, int length) {
    if (xData == null || xData.length < length) {
      return;
    }
    if (xDataInt.length != length) {
      xDataInt = new int[length];
      this.xData = new double[length];
    }
    for (int i = 0; i < length; i++) {
      xDataInt[i] = scaleX(xData[i]);
      this.xData[i] = xData[i];
    }
  }

  public void setYData(double[] yData) {
    if (yData == null) {
      return;
    }
    if (yDataInt.length != yData.length) {
      yDataInt = new int[yData.length];
    }
    for (int i = 0; i < yData.length; i++) {
      yDataInt[i] = scaleY(yData[i]);
    }
    this.yData = yData;
  }

  public void setYData(double[] yData, int length) {
    if (yData == null || yData.length < length) {
      return;
    }
    if (yDataInt.length != length) {
      yDataInt = new int[length];
      this.yData = new double[length];
    }
    for (int i = 0; i < length; i++) {
      yDataInt[i] = scaleY(yData[i]);
      this.yData[i] = yData[i];
    }
  }
}
