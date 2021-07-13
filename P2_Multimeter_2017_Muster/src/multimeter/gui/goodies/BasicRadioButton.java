package multimeter.gui.goodies;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JRadioButton;

import multimeter.resources.Utility;

public class BasicRadioButton extends JRadioButton implements ImageObserver {
	private static final long serialVersionUID = 1L;
	private double xScale;
	private double yScale;
	private Image img = Utility.loadResourceImage("button.png");
	private Image bgSel = Utility.loadResourceImage("bgndsel.png");
	private Image bg = Utility.loadResourceImage("bgnd.png");

	public BasicRadioButton(String text) {
		if (text == null) {
			setText("");
		} else {
			setText(text);
		}
		setBounds(0, 0, img.getWidth(null) + 2, img.getHeight(null) + 2);
		setContentAreaFilled(false);
		setFocusable(false);
		setBorder(null);
		setPreferredSize(new Dimension(58, 40));
	}

	public void setBounds(int x, int y, int width, int height) {
		// xScale = yScale = Math.min(width / 117, height / 82.0);
		xScale = width / 117.0;
		yScale = height / 82.0;
		super.setBounds(x, y, width, height);
	}

	public void paintComponent(Graphics g) {
		Graphics2D z = (Graphics2D) g;
		z.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		z.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
		z.scale(xScale, yScale);

		if (getModel().isPressed())
			z.drawImage(((ImageIcon) getPressedIcon()).getImage(), 0, 0, null);
		else if (getModel().isSelected())
			z.drawImage(((ImageIcon) getSelectedIcon()).getImage(), 0, 0, null);
		else
			z.drawImage(((ImageIcon) getIcon()).getImage(), 0, 0, null);
	}

	private ImageIcon createIcon(Image img) {
		int w = img.getWidth(null) + 2;
		int h = img.getHeight(null) + 2;

		MediaTracker tracker = new MediaTracker(this);
		Image im = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		tracker.addImage(im, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException ex) {
			System.out.println("Can not scale image!");
		}

		BufferedImage bufImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics g = bufImg.getGraphics();

		g.drawImage(bg, 0, 0, null);
		g.drawImage(im, 1, 0, null);
		float f = 15.0f;
		g.setFont(g.getFont().deriveFont(f - 1.0f));
		g.setColor(Color.black);
		g.drawString(getText(), 20, 35);

		return new ImageIcon(bufImg);
	}

	private ImageIcon createPressedIcon(Image img) {
		int w = img.getWidth(null) + 2;
		int h = img.getHeight(null) + 2;

		MediaTracker tracker = new MediaTracker(this);
		Image im = img.getScaledInstance(w - 2, h - 2, Image.SCALE_SMOOTH);
		tracker.addImage(im, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException ex) {
			System.out.println("Can not scale image!");
		}

		BufferedImage bufImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics g = bufImg.getGraphics();

		g.drawImage(bg, 0, 0, null);
		g.drawImage(im, 2, 2, null);
		float f = 15.0f;
		g.setFont(g.getFont().deriveFont(f - 1.0f));
		g.setColor(Color.black);
		g.drawString(getText(), 21, 35);

		return new ImageIcon(bufImg);
	}

	private ImageIcon createSelectedIcon(Image img) {
		int w = img.getWidth(null) + 2;
		int h = img.getHeight(null) + 2;

		MediaTracker tracker = new MediaTracker(this);
		Image im = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		tracker.addImage(im, 0);
		try {
			tracker.waitForID(0);
		} catch (InterruptedException ex) {
			System.out.println("Can not scale image!");
		}

		BufferedImage bufImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics g = bufImg.getGraphics();

		g.drawImage(bgSel, 0, 0, null);
		g.drawImage(im, 1, 0, null);
		float f = 15.0f;
		g.setFont(g.getFont().deriveFont(f - 1.0f));
		g.setColor(Color.black);
		g.drawString(getText(), 20, 35);

		return new ImageIcon(bufImg);
	}

	public void setText(String text) {
		super.setText(text);
		setIcon(createIcon(img));
		setPressedIcon(createPressedIcon(img));
		setSelectedIcon(createSelectedIcon(img));
	}
}
