import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class View extends JPanel {
	private TraceV8 trace = new TraceV8(this);
	private Rechteck rechteck = new Rechteck(50, 50, 25, 75);
	private Kreis kreis = new Kreis(75, 125, 75);
	private Form[] formen = new Form[0];

	public View() {
		super(null);
		trace.constructorCall();
		setPreferredSize(new Dimension(400, 400));
	}

	@Override
	public void paintComponent(Graphics g) {
//		trace.paintCall();
		for (int i = 0; i < formen.length; i++) {
			formen[i].zeichne(g);
		}
	}
}
