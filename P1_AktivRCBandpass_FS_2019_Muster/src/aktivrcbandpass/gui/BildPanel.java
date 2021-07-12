package aktivrcbandpass.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.JPanel;

import util.TraceV7;
import util.Utility;

public class BildPanel extends JPanel {
	private TraceV7 trace = new TraceV7(this);
	private static final long serialVersionUID = 1L;
	private Image bild;

	public BildPanel(String stBildDatei) {
		super(null);
		trace.constructorCall();
		bild = Utility.loadResourceImage(stBildDatei);
		setPreferredSize(new Dimension(bild.getWidth(this), bild.getHeight(this)));
		setBackground(Color.white);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		trace.paintCall();

		double min = Math.min((double) (this.getWidth()) / bild.getWidth(this),
				(double) (this.getHeight()) / bild.getHeight(this));

		int bildBreite = (int) (bild.getWidth(this) * min);
		int bildHoehe = (int) (bild.getHeight(this) * min);
		int randLinks = (this.getWidth() - bildBreite) / 2;
		int randOben = (this.getHeight() - bildHoehe) / 2;

		MediaTracker tracker = new MediaTracker(this);
		Image bd = bild.getScaledInstance(bildBreite, bildHoehe, Image.SCALE_SMOOTH);
		tracker.addImage(bd, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException ex) {
			System.out.println("Can not scale image: " + bild);
		}

		g.drawImage(bd, randLinks, randOben, bildBreite, bildHoehe, this);
	}
}
