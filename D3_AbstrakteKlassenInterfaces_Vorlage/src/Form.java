
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class Form {
	private TraceV8 trace = new TraceV8("Form", this);
	protected int x, y, breite, hoehe;
	protected Color color = Color.BLACK;

	public Form(int x, int y, int breite, int hoehe) {
		trace.constructorCall();
		this.x = x;
		this.y = y;
		this.breite = breite;
		this.hoehe = hoehe;
	}

	public abstract void zeichne(Graphics g);

	public void setColor(Color color) {
		trace.methodeCall();
		this.color = color;
	}

	protected void formMethode() {
	}

}