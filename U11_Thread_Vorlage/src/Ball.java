import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	private Graphics g;
	private int x = 150, dx = 7;
	private int y = 150, dy = 2;
	private int d = 10;
	private int xLinks = 150, xRechts = 250;
	private int yOben = 150, yUnten = 250;
	private Color color = Color.red;

	public Ball(Graphics g) {
		this.g = g;
		color = new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
	}

	public void anzeigen() {
		while (true) {
			// Rechteck zeichnen �
			g.setColor(Color.black);
			g.drawRect(xLinks, yOben, xRechts - xLinks + d, yUnten - yOben + d);
			// Mittels for - Schleife warten ...
			
//			for (int i = 0; i < 10e6; i++) {
//				
//			}
//			
			try {
				Thread.sleep(50);
				System.out.println(Thread.currentThread());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Ball an alter Position l�schen �
			g.setColor(Color.white);
			g.fillOval(x, y, d, d);
			// Neue Position des Balls berechnen �
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
			// Ball an neuer Position zeichnen �
			g.setColor(color);
			g.fillOval(x, y, d, d);
		}
	}
}
