
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class Rechteck extends Form {
	private TraceV8 trace = new TraceV8(this);

	public Rechteck(int x, int y, int b, int h) {
		super(x, y, b, h);
		trace.constructorCall();
	}

	public void zeichne(Graphics g) {
		g.setColor(color);
		g.drawRect(x - breite / 2, y - hoehe / 2, breite, hoehe);
	}

	public void rechteckMethode() {
		trace.methodeCall();
	}
}