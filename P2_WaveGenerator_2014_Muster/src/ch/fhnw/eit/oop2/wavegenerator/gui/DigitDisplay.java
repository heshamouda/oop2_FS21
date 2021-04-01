package ch.fhnw.eit.oop2.wavegenerator.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DigitDisplay extends JPanel {
	private static final long serialVersionUID = 1L;
	public final static int KHZ = 1, VPP = 2;
	private SiebenSegment[] siebenSegment;
	private int unit = VPP;
	// private int selDigit = 0;
	private double xScale, yScale;

	public DigitDisplay(int x, int y, int width, int height) {
		super(null);
		int nSegments = 5;
		siebenSegment = new SiebenSegment[nSegments];
		for (int i = 0; i < siebenSegment.length; i++) {
			siebenSegment[i] = new SiebenSegment(
					8 + (siebenSegment.length - 1 - i) * 60, 8);
		}
		setPreferredSize(new Dimension(width, height));
	}

	public void paintComponent(Graphics z) {
		Graphics2D g = (Graphics2D) z;
		g.scale(xScale, yScale);
		g.setColor(Color.black);
		g.fillRect(0, 0, siebenSegment.length * 60 + 8 + 40, 108);
		g.setColor(Color.red);
		g.fillRect(122, 96, 4, 4);
		g.setColor(Color.DARK_GRAY);
		g.drawString("Vpp", siebenSegment.length * 60 + 8, 16);
		g.drawString("kHz", siebenSegment.length * 60 + 8, 32);
		g.setColor(Color.red);
		// g.drawLine((siebenSegment.length - selDigit - 1) * 60 + 10, 110,
		// (siebenSegment.length - selDigit) * 60, 110);
		switch (unit) {
		case VPP:
			g.drawString("Vpp", siebenSegment.length * 60 + 8, 16);
			// g.drawString("Amplitude", 40, 125);
			break;
		case KHZ:
			g.drawString("kHz", siebenSegment.length * 60 + 8, 32);
			// g.drawString("Frequency", 95, 125);
			break;
		}
		for (int i = 0; i < siebenSegment.length; i++) {
			siebenSegment[i].zeichne(g);
		}
	}

	public void setBounds(int x, int y, int width, int height) {
		xScale = ((double) width) / 345;
		yScale = ((double) height) / 107;
		super.setBounds(x, y, width, height + 20);
	}

	/**
	 * Setzt die anzuzeigende Einheit.
	 * 
	 * @param unit
	 *            Eiheit gemaess Field.
	 */
	public void setUnit(int unit) {
		this.unit = unit;
	}

	public int getUnit() {
		return unit;
	}

	/**
	 * Setzt den darzustellenden Wert.
	 * 
	 * @param wert
	 *            Wert.
	 */
	public void setValue(int wert) {
		siebenSegment[siebenSegment.length - 1].setzeSignum(wert);
		for (int i = 0; i < siebenSegment.length; i++) {
			siebenSegment[i].setzeWert(Math.abs(wert) % 10);
			wert /= 10;
		}
	}

	// public void setSelDigit(int selDigit) {
	// this.selDigit = selDigit;
	// repaint();
	// }

//	public static void main(String[] args) {
//		JFrame frame = new JFrame("Anzeige");
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.addMouseMotionListener(new MouseMotionAdapter() {
//			public void mouseMoved(MouseEvent e) {
//				System.out.println("X-Pos: " + e.getX() + " Y-Pos: " + e.getY());
//			}
//		});
//		Container thePane = frame.getContentPane();
//		thePane.setLayout(new BorderLayout());
//		thePane.add(new DigitDisplay(0, 0, 250, 150));
//		frame.pack();
//		frame.setVisible(true);
//	}
}

class Segment {
	public static final int HORIZONTAL = 0;
	public static final int VERTIKAL = 1;
	private int x, y, orientierung;
	private boolean istEin = false;

	public Segment(int x, int y, int orientierung) {
		// Konstruiert an der Position x,y ein Segment mit Orientierung
		// orientierung.
		this.x = x;
		this.y = y;
		this.orientierung = orientierung;
	}

	public void setzeStatus(boolean status) {
		// Schaltete Segement ein resp. aus.
		istEin = status;
	}

	public void zeichne(Graphics g) {
		// Zeichnet an der Position gegeben durch x, y ein HORIZONTALES oder
		// VERTIKALES Segement
		if (istEin) {
			g.setColor(Color.red);
		} else {
			g.setColor(Color.DARK_GRAY);
		}
		if (orientierung == HORIZONTAL) {
			int[] px = { 2 + x, 6 + x, 34 + x, 38 + x, 38 + x, 34 + x, 6 + x,
					2 + x };
			int[] py = { -2 + y, -6 + y, -6 + y, -2 + y, 2 + y, 6 + y, 6 + y,
					2 + y };
			g.fillPolygon(px, py, px.length);
		}
		if (orientierung == VERTIKAL) {
			int[] px = { -2 + x, -6 + x, -6 + x, -2 + x, 2 + x, 6 + x, 6 + x,
					2 + x };
			int[] py = { 2 + y, 6 + y, 34 + y, 38 + y, 38 + y, 34 + y, 6 + y,
					2 + y };
			g.fillPolygon(px, py, px.length);
		}
	}
}

class SiebenSegment {
	private Segment[] segment = new Segment[7];

	public SiebenSegment(int x, int y) {
		// Konstruiert an der Position x,y eine Sieben-Segment-Anzeige.
		segment[0] = new Segment(x + 6, y + 6, Segment.HORIZONTAL);
		segment[1] = new Segment(x + 46, y + 6, Segment.VERTIKAL);
		segment[2] = new Segment(x + 46, y + 46, Segment.VERTIKAL);
		segment[3] = new Segment(x + 6, y + 86, Segment.HORIZONTAL);
		segment[4] = new Segment(x + 6, y + 46, Segment.VERTIKAL);
		segment[5] = new Segment(x + 6, y + 6, Segment.VERTIKAL);
		segment[6] = new Segment(x + 6, y + 46, Segment.HORIZONTAL);
	}

	public void setzeSignum(int zahl) {
		for (int i = 0; i < segment.length; i++)
			segment[i].setzeStatus(false);
		if (zahl < 0)
			segment[6].setzeStatus(true);
	}

	public void setzeWert(int zahl) {
		// Setzt den anzuzeigenden Wert der Sieben-Segement-Anzeige gemaess
		// zahl.
		for (int i = 0; i < segment.length; i++)
			segment[i].setzeStatus(false);

		switch (zahl) {
		case 0:
			segment[0].setzeStatus(true);
			segment[1].setzeStatus(true);
			segment[2].setzeStatus(true);
			segment[3].setzeStatus(true);
			segment[4].setzeStatus(true);
			segment[5].setzeStatus(true);
			break;
		case 1:
			segment[1].setzeStatus(true);
			segment[2].setzeStatus(true);
			break;
		case 2:
			segment[0].setzeStatus(true);
			segment[1].setzeStatus(true);
			segment[6].setzeStatus(true);
			segment[4].setzeStatus(true);
			segment[3].setzeStatus(true);
			break;
		case 3:
			segment[0].setzeStatus(true);
			segment[1].setzeStatus(true);
			segment[6].setzeStatus(true);
			segment[2].setzeStatus(true);
			segment[3].setzeStatus(true);
			break;
		case 4:
			segment[5].setzeStatus(true);
			segment[6].setzeStatus(true);
			segment[1].setzeStatus(true);
			segment[2].setzeStatus(true);
			break;
		case 5:
			segment[0].setzeStatus(true);
			segment[5].setzeStatus(true);
			segment[6].setzeStatus(true);
			segment[2].setzeStatus(true);
			segment[3].setzeStatus(true);
			break;
		case 6:
			segment[5].setzeStatus(true);
			segment[4].setzeStatus(true);
			segment[3].setzeStatus(true);
			segment[2].setzeStatus(true);
			segment[6].setzeStatus(true);
			break;
		case 7:
			segment[0].setzeStatus(true);
			segment[1].setzeStatus(true);
			segment[2].setzeStatus(true);
			break;
		case 8:
			segment[0].setzeStatus(true);
			segment[1].setzeStatus(true);
			segment[2].setzeStatus(true);
			segment[3].setzeStatus(true);
			segment[4].setzeStatus(true);
			segment[5].setzeStatus(true);
			segment[6].setzeStatus(true);
			break;
		case 9:
			segment[0].setzeStatus(true);
			segment[1].setzeStatus(true);
			segment[2].setzeStatus(true);
			segment[3].setzeStatus(true);
			segment[5].setzeStatus(true);
			segment[6].setzeStatus(true);
			break;
		}
	}

	public void zeichne(Graphics g) {
		// Ruft alle Segemente zum zeichnen auf.
		for (int i = 0; i < segment.length; i++) {
			segment[i].zeichne(g);
		}
	}
}
