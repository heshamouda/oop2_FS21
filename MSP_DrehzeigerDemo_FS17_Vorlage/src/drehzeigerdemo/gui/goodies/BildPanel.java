package drehzeigerdemo.gui.goodies;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import resources.Utility;

public class BildPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image bild;

	public BildPanel(String stBildDatei) {
		super(null);

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
