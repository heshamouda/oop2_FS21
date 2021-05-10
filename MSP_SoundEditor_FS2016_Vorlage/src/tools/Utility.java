package tools;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Utility {
	public static ImageIcon loadResourceIcon(String strBild) {
		ImageIcon icon = new ImageIcon(Utility.class.getResource("resources/" + strBild));
		return icon;
	}

	public static Image loadResourceImage(String strBild) {
		ImageIcon icon = new ImageIcon(Utility.class.getResource("resources/" + strBild));
		return icon.getImage();
	}
}
