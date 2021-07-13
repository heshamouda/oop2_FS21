package multimeter.gui.goodies;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColorPalette extends JDialog {
	private static final long serialVersionUID = 1L;
	private Swatch first;
	private Swatch current;
	private JPanel colorPanel;
	private JLabel nameLabel;
	private ActionListener listener;
	private boolean on = true;

	public ColorPalette(JFrame frame) {
		super(frame, "Color - Dialog", true);
		setBounds(frame.getX() + 100, frame.getY() + 100, 250, 250);
		setLayout(new BorderLayout());
		int rows = 6, columns = 10;
		add("Center", colorPanel = new JPanel(new GridLayout(rows, columns, 1, 1)));
		addColor(new Color(.99f, .99f, .99f), "Chalk");
		addColor(new Color(.93f, .93f, .93f), "Marble");
		addColor(new Color(.80f, .80f, .80f), "Soapstone");
		addColor(new Color(.67f, .67f, .67f), "Concrete");
		addColor(new Color(.53f, .53f, .53f), "Granite");
		addColor(new Color(.47f, .47f, .47f), "Flint");
		addColor(new Color(.33f, .33f, .33f), "Shale");
		addColor(new Color(.20f, .20f, .20f), "Gabbro");
		addColor(new Color(.13f, .13f, .13f), "Basalt");
		addColor(new Color(.00f, .00f, .00f), "Black");

		addColor(new Color(.45f, .40f, .86f), "Violet Dusk");
		addColor(new Color(.36f, .53f, .95f), "Sky Blue");
		addColor(new Color(.38f, .84f, .67f), "Ocean Green");
		addColor(new Color(.37f, .74f, .44f), "Spring Frost");
		addColor(new Color(.49f, .51f, .36f), "Mildew");
		addColor(new Color(.90f, .90f, .35f), "Mustard");
		addColor(new Color(.99f, .75f, .34f), "Canteloupe");
		addColor(new Color(.97f, .48f, .34f), "Tulip");
		addColor(new Color(.85f, .27f, .42f), "Carnation");
		addColor(new Color(.73f, .34f, .76f), "Orchid");

		addColor(new Color(.51f, .33f, .82f), "Pale Violet");
		addColor(new Color(.41f, .46f, .91f), "Evening Blue");
		addColor(new Color(.36f, .73f, .79f), "Fog");
		addColor(new Color(.38f, .79f, .56f), "Chlorine");
		addColor(new Color(.44f, .60f, .37f), "Moss");
		addColor(new Color(.70f, .71f, .35f), "Olive");
		addColor(new Color(.99f, .91f, .34f), "Banana");
		addColor(new Color(.99f, .58f, .34f), "Grape Fruit");
		addColor(new Color(.94f, .38f, .34f), "Salmon");
		addColor(new Color(.86f, .33f, .68f), "Grape");

		addColor(new Color(.35f, .09f, .73f), "Violet");
		addColor(new Color(.09f, .13f, .80f), "Blue");
		addColor(new Color(.09f, .38f, .35f), "Seaweed");
		addColor(new Color(.18f, .55f, .13f), "Clover");
		addColor(new Color(.55f, .74f, .11f), "Cactus");
		addColor(new Color(.99f, .92f, .09f), "Lemon");
		addColor(new Color(.99f, .69f, .09f), "Tangerine");
		addColor(new Color(.99f, .46f, .09f), "Melon");
		addColor(new Color(.96f, .25f, .11f), "Red Orange");
		addColor(new Color(.93f, .09f, .12f), "Red");

		addColor(new Color(.42f, .09f, .69f), "Royal Violet");
		addColor(new Color(.27f, .09f, .78f), "Blue Violet");
		addColor(new Color(.09f, .29f, .51f), "Sea Blue");
		addColor(new Color(.09f, .46f, .20f), "Pine");
		addColor(new Color(.36f, .64f, .12f), "Fern");
		addColor(new Color(.73f, .83f, .10f), "Watercress");
		addColor(new Color(.99f, .80f, .09f), "Marigold");
		addColor(new Color(.99f, .57f, .09f), "Orange");
		addColor(new Color(.98f, .31f, .10f), "Fire");
		addColor(new Color(.94f, .12f, .11f), "Apple");

		addColor(new Color(.16f, .10f, .06f), "Sepia");
		addColor(new Color(.36f, .24f, .14f), "Raw Sienna");
		addColor(new Color(.55f, .38f, .21f), "Dirt");
		addColor(new Color(.75f, .52f, .29f), "Tan");
		addColor(new Color(.80f, .78f, .76f), "Warm Marble");
		addColor(new Color(.55f, .50f, .45f), "Warm Granite");
		addColor(new Color(.24f, .22f, .20f), "Warm Shale");
		addColor(new Color(.76f, .76f, .80f), "Cool Marble");
		addColor(new Color(.45f, .45f, .55f), "Cool Granite");
		addColor(new Color(.20f, .20f, .24f), "Cool Shale");
		nameLabel = new JLabel("Warm Shale", JLabel.CENTER);
		nameLabel.setOpaque(true);
		setColor("Red");
		add("South", nameLabel);
	}

	public void addActionListener(ActionListener listener) {
		this.listener = listener;
	}

	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		this.on = enabled;
	}

	public Color getColor() {
		// System.out.println(current.color);
		return current.color;
	}

	private void setColor(String name) {
		Swatch swatch = first;
		while (swatch.next != null && !swatch.name.equals(name)) {
			swatch = swatch.next;
		}
		setColor(swatch);
	}

	private void addColor(Color color, String name) {
		if (current == null) {
			current = new Swatch(color, name, this);
			first = current;
		} else {
			current.next = new Swatch(color, name, this); // swatches are stored
															// as a linked list
			current = current.next;
		}
		colorPanel.add(current);
	}

	private void setColor(Swatch swatch) {
		current.active = false;
		current.repaint();
		current = swatch;
		current.active = true;
		current.repaint();
		nameLabel.setText(current.name);
		nameLabel.setBackground(current.color);
		if (listener != null)
			listener.actionPerformed(new ActionEvent(this, 1001, ""));
		setVisible(false);
	}

	class Swatch extends JPanel implements MouseListener {
		private static final long serialVersionUID = 1L;
		Color color;
		boolean active;
		boolean over;
		String name;

		Swatch next;
		ColorPalette palette;

		public Swatch(Color color, String name, ColorPalette palette) {
			this.color = color;
			this.name = name;
			this.palette = palette;
			active = false;
			over = false;
			next = null;

			addMouseListener(this);
		}

		public void paintComponent(Graphics g) {
			int w = getWidth();
			int h = getHeight();

			g.setColor(color);
			g.fillRect(0, 0, w, h);
			if (active || over) {
				g.setColor(Color.black);
				g.drawRect(0, 0, w - 1, h - 1);
			}
		}

		public void mouseEntered(MouseEvent me) {
			if (!on)
				return;
			over = true;
			repaint();
			palette.nameLabel.setText(name);
			palette.setBackground(color);
		}

		public void mouseReleased(MouseEvent me) {
		}

		public void mouseExited(MouseEvent me) {
			if (!on)
				return;
			over = false;
			repaint();
			palette.nameLabel.setText(palette.current.name);
			palette.setBackground(palette.current.color);
		}

		public void mouseClicked(MouseEvent me) {
			if (!on)
				return;
			palette.setColor(this);
		}

		public void mousePressed(MouseEvent me) {
		}
	}
}