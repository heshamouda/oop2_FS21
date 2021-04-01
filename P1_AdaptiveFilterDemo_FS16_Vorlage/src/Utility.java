import java.awt.Container;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Utility {

	private static Container p = new Container();

	public static Cursor getDefaultCursor() {
		return Cursor.getDefaultCursor();
	}

	public static Cursor getInvisibleCursor() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
		return toolkit.createCustomCursor(image, new Point(0, 0), "img");
	}

	public static Image loadImage(String strBild) {
		MediaTracker tracker = new MediaTracker(p);
		Image img = (new ImageIcon(strBild)).getImage();
		tracker.addImage(img, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException ex) {
			System.out.println("Can not load image: " + strBild);
		}
		return img;
	}

	public static Image loadResourceImage(String strBild) {
		MediaTracker tracker = new MediaTracker(p);
		Image img = (new ImageIcon(Utility.class.getResource("bilder/" + strBild))).getImage();
		tracker.addImage(img, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException ex) {
			System.out.println("Can not load image: " + strBild);
		}
		return img;
	}

	public static Image loadResourceImage(String strBild, int width, int height) {
		MediaTracker tracker = new MediaTracker(p);
		Image img = (new ImageIcon(Utility.class.getResource("bilder/" + strBild))).getImage();
		img = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		tracker.addImage(img, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException ex) {
			System.out.println("Can not load image: " + strBild);
		}
		return img;
	}

	public static Image getScaledImage(Image img, int width, int height) {
		MediaTracker tracker = new MediaTracker(p);
		img = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		tracker.addImage(img, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException ex) {
			System.out.println("Can not scale image: ");
		}
		return img;
	}

}
