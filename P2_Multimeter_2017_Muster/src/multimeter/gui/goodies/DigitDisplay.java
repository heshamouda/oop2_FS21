package multimeter.gui.goodies;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class DigitDisplay extends JPanel {
	private static final long serialVersionUID = 1L;
	public final static int V = 0, A = 1, KHZ = 2, GRAD = 3;
	private SiebenSegment[] siebenSegment;
	private int unit = V;
	private double xScale, yScale;
	private Color color = Color.red;
	private Point point = new Point();
	private JPopUp menu = new JPopUp(this);
	private JPanel thePanel = this;

	public DigitDisplay() {
		super(null);
		int nSegments = 6;
		siebenSegment = new SiebenSegment[nSegments];
		for (int i = 0; i < siebenSegment.length; i++) {
			siebenSegment[i] = new SiebenSegment(8 + (siebenSegment.length - 1 - i) * 60, 8);
		}
		this.setPreferredSize(new Dimension((siebenSegment.length * 60 + 45), 107));
		this.setMinimumSize(getPreferredSize());
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				point.x = e.getX();
				point.y = e.getY();
			}

			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					menu.show(thePanel, e.getX(), e.getY());
				}
				if (e.getButton() == MouseEvent.BUTTON3) {
					menu.show(thePanel, e.getX(), e.getY());
				}
			}
		});
	}

	public void paintComponent(Graphics z) {
		
		// ____________________ BITTE EINFÜGEN ____________________
		super.paintComponent(z);
		// ________________________________________________________
		
		Graphics2D g = (Graphics2D) z;
		g.scale(xScale, yScale);
		g.setColor(color);
		g.fillRect(3 * 60 + 2, 96, 4, 4);
		g.setColor(Color.DARK_GRAY);
		g.drawString("V", siebenSegment.length * 60 + 8, 20);
		g.drawString("A", siebenSegment.length * 60 + 8, 35);
		g.drawString("kHz", siebenSegment.length * 60 + 8, 50);
		g.drawString("Grad", siebenSegment.length * 60 + 8, 65);
		g.setColor(color);
		switch (unit) {
		case V:
			g.drawString("V", siebenSegment.length * 60 + 8, 20);
			break;
		case A:
			g.drawString("A", siebenSegment.length * 60 + 8, 35);
			break;
		case KHZ:
			g.drawString("kHz", siebenSegment.length * 60 + 8, 50);
			break;
		case GRAD:
			g.drawString("Grad", siebenSegment.length * 60 + 8, 65);
			break;
		}
		for (int i = 0; i < siebenSegment.length; i++) {
			siebenSegment[i].zeichne(g);
		}
	}

	public void setBounds(int x, int y, int width, int height) {
		xScale = ((double) width) / (siebenSegment.length * 60 + 45);
		yScale = ((double) height) / 107;
		super.setBounds(x, y, width, height);
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
	public void setValue(double value) {
		int wert = (int) (1000 * value);
		siebenSegment[siebenSegment.length - 1].setzeSignum(wert);
		for (int i = 0; i < siebenSegment.length; i++) {
			siebenSegment[i].setzeWert(Math.abs(wert) % 10);
			wert /= 10;
		}
		repaint();
	}

	public void setColor(Color color) {
		this.color = color;
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
				g.setColor(color);
			} else {
				g.setColor(Color.DARK_GRAY);
			}
			if (orientierung == HORIZONTAL) {
				int[] px = { 2 + x, 6 + x, 34 + x, 38 + x, 38 + x, 34 + x, 6 + x, 2 + x };
				int[] py = { -2 + y, -6 + y, -6 + y, -2 + y, 2 + y, 6 + y, 6 + y, 2 + y };
				g.fillPolygon(px, py, px.length);
			}
			if (orientierung == VERTIKAL) {
				int[] px = { -2 + x, -6 + x, -6 + x, -2 + x, 2 + x, 6 + x, 6 + x, 2 + x };
				int[] py = { 2 + y, 6 + y, 34 + y, 38 + y, 38 + y, 34 + y, 6 + y, 2 + y };
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
}

class JPopUp extends JPopupMenu implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JMenuItem menuItemColor;
	private DigitDisplay digitPanel;

	public JPopUp(DigitDisplay displayPanel) {
		this.digitPanel = displayPanel;
		menuItemColor = new JMenuItem("Farbe");
		menuItemColor.addActionListener(this);
		add(menuItemColor);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menuItemColor) {
			ColorPalette colorDialog = new ColorPalette((JFrame) digitPanel.getTopLevelAncestor());
			colorDialog.setVisible(true);
			digitPanel.setColor(colorDialog.getColor());
		}
	}
}