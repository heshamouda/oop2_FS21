import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class View extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Rechteck rechteck = new Rechteck(100, 120, 200, 70);
	private Kreis kreis = new Kreis(10, 20, 70);
	
	 

	public View() {
		super(null);
		setPreferredSize(new Dimension(600, 400));

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		
	

	}

}

class Form {
	protected int x, y, breite, hoehe;

	public Form(int x, int y, int breite, int hoehe) {
		this.x = x;
		this.y = y;
		this.breite = breite;
		this.hoehe = hoehe;
	}

	public  void zeichne(Graphics g) {
		
	}
	
	
		
	

}

class Rechteck extends Form {
	public Boolean binRechteck;

	public Rechteck(int x, int y, int breite, int hoehe) {
		super(x, y, breite, hoehe);
	}

	public void zeichne(Graphics g) {
		g.setColor(Color.GREEN);
		g.drawRect(x, y, breite, hoehe);
	}

}

class Kreis extends Form {
	public Boolean binKreis;

	public Kreis(int x, int y, int d) {
		super(x, y, d, d);
	}

	public void zeichne(Graphics g) {
		g.setColor(Color.RED);
		g.drawOval(x, y, breite, hoehe);
	}
}
