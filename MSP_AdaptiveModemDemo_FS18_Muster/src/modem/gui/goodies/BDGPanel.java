package modem.gui.goodies;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import modem.AdaptiveModemDemo;
import resources.MyBorderFactory;
import resources.Utility;

public class BDGPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image bild;
	private Image img;
	private int randLinks = 0, randOben = 0;

	private double c = 0.0;

	public BDGPanel(String stBildDatei) {
		super(null);

		setBorder(MyBorderFactory.createMyBorder(" Blockdiagramm "));

		setPreferredSize(
				new Dimension((int) (AdaptiveModemDemo.appWidth * 0.5), (int) (AdaptiveModemDemo.appHeight * 0.4)));

		bild = Utility.loadResourceImage(stBildDatei);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (bild != null) {
			double q = Math.min((double) (this.getWidth() - 20) / bild.getWidth(this),
					(double) (this.getHeight() - 40) / bild.getHeight(this));
			if (q != c) {
				c = q;
				int bildBreite = (int) (bild.getWidth(this) * c);
				int bildHoehe = (int) (bild.getHeight(this) * c);
				randLinks = (this.getWidth() - bildBreite) / 2;
				randOben = (this.getHeight() - bildHoehe) / 2;

				img = bild.getScaledInstance(bildBreite, bildHoehe, Image.SCALE_SMOOTH);
			}
			g.drawImage(img, randLinks, randOben, this);
		}
	}
}
