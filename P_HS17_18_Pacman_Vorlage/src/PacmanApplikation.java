
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class PacmanApplikation extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final double width = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static final double height = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

	private Image icon = Utility.loadResourceImage("pacman.png", 64, 64);
	private TopView view = new TopView();

	public PacmanApplikation() {
		getContentPane().add(view);
		addKeyListenertoAllComponents(getContentPane(), view.pacmanSpielPanel);
		pack();
		setTitle("Pacman");
		setIconImage(icon);
		// Zentrieren:
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		setVisible(true);
		setResizable(false);
	}

	public void addKeyListenertoAllComponents(Container container, KeyListener keyListener) {
		synchronized (container.getTreeLock()) {
			addKeyListenertoAll(container.getComponents(), keyListener);
		}
	}

	public void addKeyListenertoAll(Component[] comps, KeyListener keyListener) {
		for (int i = 0; i < comps.length; i++) {
			if (comps[i] instanceof Container) {
				comps[i].addKeyListener(keyListener);
				if (comps[i] instanceof JLabel)
					comps[i].setForeground(Color.white);
				else
					comps[i].setForeground(Color.black);
				addKeyListenertoAll(((Container) comps[i]).getComponents(), keyListener);
			} else if (comps[i] instanceof JComponent) {
				comps[i].addKeyListener(keyListener);

			}
		}
	}

	public static void setUIFont(javax.swing.plaf.FontUIResource f) {
		@SuppressWarnings("rawtypes")
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource)
				UIManager.put(key, f);
		}
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				try {
					setUIFont(new javax.swing.plaf.FontUIResource("Helvetic", Font.BOLD, (int) (height / 1080 * 16)));
				} catch (Exception e) {
				}
				PacmanApplikation frame = new PacmanApplikation();
				frame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
			}
		});
	}
}
