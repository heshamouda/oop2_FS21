package multimeter.resources;

import java.awt.Container;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.ImageIcon;

public class Utility {

	private static Container p = new Container();

	public static ImageIcon loadResourceIcon(String strBild) {
		ImageIcon icon = new ImageIcon(Utility.class.getResource("resources/" + strBild));
		return icon;
	}

	public static Image loadResourceImage(String strBild) {
		MediaTracker tracker = new MediaTracker(p);
		Image img = (new ImageIcon(Utility.class.getResource("resources/" + strBild))).getImage();
		tracker.addImage(img, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException ex) {
			System.out.println("Can not load image: " + strBild);
		}
		return img;
	}

	public static Image loadScaledResourceImage(String strBild, int width, int height, int hints) {
		MediaTracker tracker = new MediaTracker(p);
		Image img = (new ImageIcon(Utility.class.getResource("resources/" + strBild))).getImage()
				.getScaledInstance(width, height, hints);
		tracker.addImage(img, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException ex) {
			System.out.println("Can not load image: " + strBild);
		}
		return img;
	}
}
