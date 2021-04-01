import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

public class Utility {

	private static Container p = new Container();

	// public static Image loadImage(String strBild) {
	// MediaTracker tracker = new MediaTracker(p);
	// Image img = (new ImageIcon(strBild)).getImage();
	// tracker.addImage(img, 0);
	// try {
	// tracker.waitForID(0);
	// } catch (InterruptedException ex) {
	// System.out.println("Can not load image: " + strBild);
	// }
	// return img;
	// }
	//
	// public static Image loadResourceImage(String strBild) {
	// MediaTracker tracker = new MediaTracker(p);
	// Image img = (new
	// ImageIcon(Utility.class.getClassLoader().getResource("bilder/" +
	// strBild))).getImage();
	// tracker.addImage(img, 0);
	// try {
	// tracker.waitForID(0);
	// } catch (InterruptedException ex) {
	// System.out.println("Can not load image: " + strBild);
	// }
	// return img;
	// }

	// public static ImageIcon loadResourceIcon(String strBild) {
	// ImageIcon icon = new
	// ImageIcon(Utility.class.getClassLoader().getResource("bilder/" + strBild));
	// return icon;
	// }

	public static Image loadResourceImage(String strBild, int width, int height) {
		MediaTracker tracker = new MediaTracker(p);
		Image img = (new ImageIcon(Utility.class.getClassLoader().getResource("bilder/" + strBild))).getImage();
		if (strBild.endsWith(".gif")) {
			img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
		} else {
			img = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		}
		tracker.addImage(img, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException ex) {
			System.out.println("Can not load image: " + strBild);
		}
		return img;
	}

	public static void setHighRenderQuality(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2d.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		g2d.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
	}

	// public static AudioClip loadAudioClip(String strAudioDatei) {
	// AudioClip audioClip = null;
	// audioClip =
	// Applet.newAudioClip(Utility.class.getClassLoader().getResource("audio/" +
	// strAudioDatei));
	// return audioClip;
	// }
	//
	// public static Cursor getInvisibleCursor() {
	// Toolkit toolkit = Toolkit.getDefaultToolkit();
	// Image image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
	// return toolkit.createCustomCursor(image, new Point(0, 0), "img");
	// }
	//
	// public static Cursor getDefaultCursor() {
	// return Cursor.getDefaultCursor();
	// }
}
