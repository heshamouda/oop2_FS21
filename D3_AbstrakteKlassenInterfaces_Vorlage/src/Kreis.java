
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

public class Kreis extends Form {
	private TraceV8 trace = new TraceV8(this);

	public Kreis(int x, int y, int d) {
		super(x, y, d, d);
		trace.constructorCall();
	}

	public void zeichne(Graphics g) {
		g.setColor(color);
		g.drawOval(x - breite / 2, y - hoehe / 2, breite, hoehe);
	}

	public void kreisMethode() {
		trace.methodeCall();
	}

}