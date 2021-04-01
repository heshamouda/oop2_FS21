package client.tools.figure;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.util.Vector;

/**
 $Author:$<br>
 $Date:$<br>
 $Revision:$<br>
 $Source:$<br>
 */
public class Marker {
  protected Line line;
  protected int xIndex = 0, yIndex = 0;
  protected boolean isSelected;
  protected Color color = Color.red;
  protected double x, y;
  protected Vector<MarkerListener> markerListenerVector = new Vector<MarkerListener>();

  public Marker() {
  }

  public Marker(Color color) {
    this.color = color;
  }

  public void addMarkerListener(MarkerListener markerListener) {
    if (markerListener == null) {
      return;
    }
    markerListenerVector.add(markerListener);
  }

  public double getX() {
    if (line == null || line.xData.length == 0 || line.yData.length == 0) {
      return 0.0;
    }
    return line.xData[xIndex];
  }

  public double getY() {
    if (line == null || line.xData.length == 0 || line.yData.length == 0) {
      return 0.0;
    }
    return line.yData[yIndex];
  }

  private double minDistance(double x, double y) {
    double dx = line.xDataInt[xIndex] - x;
    double dy = line.yDataInt[yIndex] - y;
    return Math.sqrt(dx * dx + dy * dy);
  }

  public void mouseDragged(MouseEvent mouseEvent) {
    if (line == null || line.xData.length == 0 || line.yData.length == 0) {
      return;
    }

    if (!isSelected) {
      return;
    }
    int i;
    for (i = 1; i < line.xData.length && mouseEvent.getX() > line.xDataInt[i]; i++) {
      ;
    }
    xIndex = i - 1;
    yIndex = i - 1;
    for (i = 0; i < markerListenerVector.size(); i++) {
      markerListenerVector.elementAt(i).markerDragged(this);
    }
//    System.out.println("markerDragged xIndex: " + line.yData[xIndex]);
  }
  
  public void mousePressed(MouseEvent mouseEvent) {
    if (line == null || line.xData.length == 0 || line.yData.length == 0) {
      return;
    }

    if (minDistance(mouseEvent.getX(), mouseEvent.getY()) < 10.0) {
      mouseEvent.consume();
      isSelected = true;
      int i;
      for (i = 1; i < line.xData.length && mouseEvent.getX() > line.xDataInt[i]; i++) {
        ;
      }
      xIndex = i - 1;
      yIndex = i - 1;
      for (i = 0; i < markerListenerVector.size(); i++) {
        markerListenerVector.elementAt(i).markerPressed(this);
      }
//      System.out.println("markerPressed");
    }
  }

  public void mouseReleased(MouseEvent mouseEvent) {
    if (line == null || line.xData.length == 0 || line.yData.length == 0) {
      return;
    }

    if (isSelected) {
      mouseEvent.consume();
      isSelected = false;
      int i;
      for (i = 1; i < line.xData.length && mouseEvent.getX() > line.xDataInt[i]; i++) {
        ;
      }
      xIndex = i - 1;
      yIndex = i - 1;
      for (i = 0; i < markerListenerVector.size(); i++) {
        markerListenerVector.elementAt(i).markerReleased(this);
      }
//      System.out.println("markerReleased");
    }
  }

  public void paint(Graphics2D g) {
    if (line == null || line.xDataInt.length == 0 || line.yDataInt.length == 0) {
      return;
    }
	((Graphics2D)g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g.setColor(color);
    paintMarker(g, line.xDataInt[xIndex], line.yDataInt[yIndex]);
  }

  public void paintMarker(Graphics2D g, int x, int y) {
//    g.fillOval(x - 10, y - 10, 20, 20);
    g.drawOval(x - 10, y - 10, 20, 20);
//    g.setColor(Color.black);
    g.drawLine(x - 9, y, x + 9, y);
    g.drawLine(x, y - 9, x, y + 9);
  }

  public void removeMarkerListener(MarkerListener markerListener) {
    markerListenerVector.remove(markerListener);
  }

  public void setLine(Line line) {
    this.line = line;
  }

  public void setMarker(double x) {
    if (line == null || line.xData.length == 0 || line.yData.length == 0) {
      return;
    }
    this.x = x;
    if (x > line.xData[line.xData.length - 1]) {
      xIndex = line.xData.length - 1;
      yIndex = line.yData.length - 1;
      return;
    }
    if (x <= line.xData[0]) {
      xIndex = 0;
      yIndex = 0;
      return;
    }
    int i;
    for (i = 0; i < line.xData.length && x > line.xData[i]; i++) {
      ;
    }
    xIndex = i - 1;
    yIndex = i - 1;
  }

}
