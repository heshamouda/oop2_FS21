package impulsdemo.gui.goodies;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import impulsdemo.TraceV2;
import resources.Utility;

//DIESE DATEI MUSS NICHT BEARBEITET WERDEN! SIE WIRD NICHT BEWERTET!

public class BildPanel extends JPanel {
	private TraceV2 tr = new TraceV2(this);
	private static final long serialVersionUID = 1L;
	private Image bild;

	public BildPanel(String stBildDatei) {
		super(null);
		tr.constructorCall();
		bild = Utility.loadResourceImage(stBildDatei);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		double min = Math.min((double) (this.getWidth()) / bild.getWidth(this),
				(double) (this.getHeight()) / bild.getHeight(this));

		int bildBreite = (int) (bild.getWidth(this) * min);
		int bildHoehe = (int) (bild.getHeight(this) * min);
		int randLinks = (this.getWidth() - bildBreite) / 2;
		// int randOben = (this.getHeight() - bildHoehe) / 2;

		g.drawImage(bild, randLinks, 0, bildBreite, bildHoehe, this);
	}
}
