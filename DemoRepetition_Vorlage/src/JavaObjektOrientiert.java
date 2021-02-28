
import java.awt.Graphics;
import java.awt.Label;

import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

class View extends JPanel implements MouseMotionListener{

	private TraceV7 trace = new TraceV7(this);
	private static final long serialVersionUID = 1L;

	private Quadrat quadrat = new Quadrat(200, 200, 150);
	private Kreis kreis = new Kreis(200, 400, 150);

	public View() {
		super(null);
		trace.constructorCall();
		addMouseMotionListener(this); //register the listener

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		quadrat.zeichne(g);
		kreis.zeichne(g);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("xpos : "+e.getX() + " ypos : "+e.getY());
	}

}

class Form {
	protected int x, y, d;

	public Form(int x, int y, int d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}

	public void zeichne(Graphics graphics) {
		//nothing to DO here

	}
}

class Quadrat extends Form {
	private TraceV7 trace = new TraceV7(this);
	//private int x, y, d;

	public Quadrat(int x, int y, int d) {
		super(x,y,d);
		trace.constructorCall();
//		this.x = x;
//		this.y = y;
//		this.d = d;
	}

	public void zeichne(Graphics g) {
		trace.methodeCall();
		g.drawRect(x - d / 2, y - d / 2, d, d);
		g.drawString("Flaeche = " + calcFlaeche(d), x - 50, y);
	}

	public int calcFlaeche(int breite) {
		return breite * breite;
	}

}

class Kreis extends Form{
	private TraceV7 trace = new TraceV7(this);
	//private int x, y, d;

	public Kreis(int x, int y, int d) {
		super(x, y, d);
		trace.constructorCall();
//		this.x = x;
//		this.y = y;
//		this.d = d;
	}

	public void zeichne(Graphics g) {
		trace.methodeCall();
		g.drawOval(x - d / 2, y - d / 2, d, d);
		g.drawString("Flaeche = " + calcFlaeche(d), x - 50, y);
	}

	public int calcFlaeche(int durchmesser) {
		return (int) (Math.PI * durchmesser * durchmesser / 4.0);
	}

}

public class JavaObjektOrientiert extends JFrame {
	private static final long serialVersionUID = 1L;
	private TraceV7 trace = new TraceV7(this);

	private View viewPanel = new View();

	public JavaObjektOrientiert() {
		trace.constructorCall();
		add(viewPanel);
		setSize(720, 720);

		setTitle("|FHNW|EIT|OOP|ObjektOrientiert|");
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
	}

	public static void main(String args[]) {
		TraceV7.mainCall();
		JavaObjektOrientiert frame = new JavaObjektOrientiert();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});

	}
}
