package client.tools;

import java.awt.Container;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

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
		} catch (Exception ex) {
			System.out.println("Can not load image: " + strBild);
		}
		return img;
	}

	public static ImageIcon loadResourceIcon(String strBild) {
		ImageIcon icon = new ImageIcon(Utility.class.getClassLoader()
				.getResource("resources" + "/" + strBild));
		return icon;
	}

	public static Image loadResourceImage(String strBild) {
		MediaTracker tracker = new MediaTracker(p);
		Image img = (new ImageIcon(Utility.class.getResource("resources/"
				+ strBild))).getImage();
		tracker.addImage(img, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException ex) {
			System.out.println("Can not load image: " + strBild);
		}
		return img;

		// MediaTracker tracker = new MediaTracker(p);
		// URL url = Utility.class.getClassLoader().getResource(
		// "resources" + "/" + strBild);
		// Image img = (new ImageIcon(url)).getImage();
		// tracker.addImage(img, 0);
		// try {
		// tracker.waitForID(0);
		// } catch (Exception ex) {
		// System.out.println("Can not load image: " + strBild);
		// }
		// return img;
	}

	public static Image loadResourceImage(String strBild, int width, int height) {
		MediaTracker tracker = new MediaTracker(p);
		Image img = (new ImageIcon(Utility.class.getClassLoader().getResource(
				"resources" + "/" + strBild))).getImage();
		img = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		tracker.addImage(img, 0);
		try {
			tracker.waitForID(0);
		} catch (Exception ex) {
			System.out.println("Can not load image: " + strBild);
		}
		return img;
	}

	public static String loadResourceText(String datei) {
		// Looks like resources within jar want to be accessed with "/" and not
		// with File.separator!
		String res = "resources" + "/" + datei;
		URL url = Utility.class.getClassLoader().getResource(res);
		String txt = "";
		try {
			String inputLine;
			BufferedReader in = new BufferedReader(new InputStreamReader(
					url.openStream()));
			while ((inputLine = in.readLine()) != null) {
				txt += inputLine + "\n";
			}
			in.close();
		} catch (Exception e) {
			System.out.println("Can not load File: " + datei);
		}
		return txt;
	}

	// public static void main(String[] args) {
	// Image img = loadResourceImage("hai_1.png");
	// System.out.println("" + img);
	//
	// String txt = loadResourceText("Test.txt");
	// System.out.println(txt);
	// }
}
