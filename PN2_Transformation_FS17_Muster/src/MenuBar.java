//Name: Muster
//Vorname:
//Klasse:

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Erzeugt Menu zur Steuerung der Farbe und für Exit.
 *
 */
public class MenuBar extends JMenuBar implements ActionListener {
	// 16 Pte
	private JMenu menu;
	private JMenuItem menuItemColor, menuItemExit;
	private JFrame frame;
	private Controller controller;

	public MenuBar(Controller controller, JFrame frame) {
		// 10 Pte
		this.frame = frame;
		this.controller = controller;
		menu = new JMenu("Settings");
		add(menu);
		menuItemColor = new JMenuItem("Farbe");
		menuItemColor.addActionListener(this);
		menu.add(menuItemColor);
		menu.addSeparator();
		menuItemExit = new JMenuItem("Exit");
		menuItemExit.addActionListener(this);
		menu.add(menuItemExit);
		add(menu);
	}

	public void actionPerformed(ActionEvent e) {
		// 6 Pte
		if (e.getSource() == menuItemColor) {
			ColorPalette colorDialog = new ColorPalette(frame);
			colorDialog.setVisible(true);
			controller.setColor(colorDialog.getColor());
		}
		if (e.getSource() == menuItemExit) {
			System.exit(0);
		}
	}
}
