package figure;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Stem extends Line {
	public Stem() {}

	public Stem(Color color) {
		super(color);
	}

	public Stem(double[] xData, double[] yData) {
		super(xData, yData);
	}

	public void paint(Graphics2D g) {
		if (xData == null || yData == null || xData.length == 0 || yData.length == 0 || color == null) {
			return;
		}
		BasicStroke s = (BasicStroke) g.getStroke();
		Color c = g.getColor();
		g.setStroke(new BasicStroke(lineWidth, s.getEndCap(), s.getLineJoin(), s.getMiterLimit(), dash, 0.0f));
		g.setColor(color);
		int baseLine = this.scaleY(0.0);
		for (int i = 0; i < yDataInt.length; i++) {
			g.drawLine(xDataInt[i], baseLine, xDataInt[i], yDataInt[i]);
			g.drawOval(xDataInt[i] - 2, yDataInt[i] - 2, 4, 4);
		}
		g.setColor(c);
		g.setStroke(s);
		if (markerVector.size() != 0) {
			for (int i = 0; i < markerVector.size(); i++) {
				((Marker) markerVector.elementAt(i)).paint((Graphics2D) g);
			}
		}
	}
}
