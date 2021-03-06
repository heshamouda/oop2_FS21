import java.awt.Color;
import java.awt.Graphics;

import javax.swing.SwingWorker;

public class SwingWorkerBall extends SwingWorker {
	private boolean weitermachen = true;
	private Graphics g;
	private int x = 150, dx = 7;
	private int y = 150, dy = 2;
	private int d = 10;
	private int xLinks = 150, xRechts = 250;
	private int yOben = 150, yUnten = 250;
	private Color color = Color.red;
	

	public SwingWorkerBall(Graphics g) {
		this.g = g;
		
		color = new Color((int) (Math.random() * 255),
				(int) (Math.random() * 255), (int) (Math.random() * 255));
	}

	public void stoppen() {
		weitermachen = false;
	}

	protected Object doInBackground() throws Exception {
		
		while (weitermachen) {
			g.setColor(Color.black);
			g.drawRect(xLinks, yOben, xRechts - xLinks + d, yUnten - yOben + d);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				System.err.println("Ausnahme bei Sleep");
			}
			g.setColor(Color.white);
			g.fillOval(x, y, d, d);
			if (x + dx <= xLinks)
				dx = -dx;
			if (x + dx >= xRechts)
				dx = -dx;
			if (y + dy <= yOben)
				dy = -dy;
			if (y + dy >= yUnten)
				dy = -dy;
			x = x + dx;
			y = y + dy;
			g.setColor(color);
			g.fillOval(x, y, d, d);
		}
		g.setColor(Color.white);
		g.fillOval(x, y, d, d);
		
		return null;
	}

}



