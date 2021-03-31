package guitutorial.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import guitutorial.util.DPIFixV3;
import guitutorial.util.Observable;
import guitutorial.util.Observer;

public class MenuBar extends JMenuBar implements Observer, ActionListener {
	JFrame frame;
	Controller controller;

	JMenu menu_1, menu_2;
	JMenuItem menuItem_1, menuItem_2, menuItem_3, menuItem_4, menuItem_5, menuItem_6;

	public MenuBar(Controller controller, JFrame frame) {
		this.frame = frame;
		this.controller = controller;

		menu_1 = new JMenu("Datei");
		add(menu_1);

		menuItem_1 = new JMenuItem("Allwas on Top", KeyEvent.VK_T);
		menu_1.add(menuItem_1);
		menuItem_1.addActionListener(this);

		menu_1.addSeparator();

		menu_2 = new JMenu("A submenu");
		menu_1.add(menu_2);
		menuItem_2 = new JMenuItem("SubmenuItem", KeyEvent.VK_M);
		menu_2.add(menuItem_2);
		menuItem_2.addActionListener(this);

		menu_1.addSeparator();

		menuItem_3 = new JMenuItem("Resizable", KeyEvent.VK_R);
		menu_1.add(menuItem_3);
		menuItem_3.addActionListener(this);

		menuItem_4 = new JMenuItem("Not Resizable", KeyEvent.VK_N);
		menu_1.add(menuItem_4);
		menuItem_4.addActionListener(this);

		menu_1.addSeparator();

		menuItem_5 = new JMenuItem("XL", KeyEvent.VK_X);
		menu_1.add(menuItem_5);
		menuItem_5.addActionListener(this);

		menuItem_6 = new JMenuItem("XS", KeyEvent.VK_S);
		menu_1.add(menuItem_6);
		menuItem_6.addActionListener(this);
	}

	//	JMenu menu, submenu;
	//	JMenuItem menuItemOnTop, submenuItem;
	//

	//	public MenuBar(Controller controller, JFrame frame) {
	//		this.frame = frame;
	//		this.controller = controller;
	//		menu = new JMenu("Datei");
	//		menu.setMnemonic(KeyEvent.VK_D);
	//
	//		menu.addSeparator();
	//		submenu = new JMenu("A submenu");
	//		submenu.setMnemonic(KeyEvent.VK_S);
	//		submenuItem = new JMenuItem("SubmenuItem");
	//		submenu.add(submenuItem);
	//		menu.add(submenu);
	//
	//		menuItemOnTop = new JMenuItem("Allwas on Top", KeyEvent.VK_T);
	//		menuItemOnTop.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.ALT_MASK));
	//		menuItemOnTop.setActionCommand("OnTop");
	//		menuItemOnTop.addActionListener(this);
	//		menu.add(menuItemOnTop);
	//
	//		JMenuItem menuItemResizable = new JMenuItem("Resizable", KeyEvent.VK_R);
	//		menuItemResizable.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.ALT_MASK));
	//		menuItemResizable.setActionCommand("Resizable");
	//		menuItemResizable.addActionListener(this);
	//		menu.add(menuItemResizable);
	//
	//		JMenuItem menuItemNotResizable = new JMenuItem("Not Resizable", KeyEvent.VK_N);
	//		menuItemNotResizable.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.ALT_MASK));
	//		menuItemNotResizable.setActionCommand("NotResizable");
	//		menuItemNotResizable.addActionListener(this);
	//		menu.add(menuItemNotResizable);
	//
	//		JMenuItem menuItemXL = new JMenuItem("XL", KeyEvent.VK_X);
	//		menuItemXL.setActionCommand("XL");
	//		menuItemXL.addActionListener(this);
	//		menu.add(menuItemXL);
	//
	//		JMenuItem menuItemXS = new JMenuItem("XS", KeyEvent.VK_S);
	//		menuItemXS.setActionCommand("XS");
	//		menuItemXS.addActionListener(this);
	//		menu.add(menuItemXS);
	//
	//		add(menu);
	//	}

	public void update(Observable o, Object obj) {}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Resizable")) {
			frame.setResizable(true);
			Dimension dim = frame.getSize();
			dim.width -= 100;
			frame.setSize(dim);
		}
		if (e.getActionCommand().equals("NotResizable")) {
			frame.setResizable(false);
			Dimension dim = frame.getSize();
			dim.width += 100;
			frame.setSize(dim);
		}
		if (e.getActionCommand().equals("OnTop")) {
			StatusBar.showStatus(this, e, e.getActionCommand());
			if (((JFrame) this.getTopLevelAncestor()).isAlwaysOnTop()) {
				((JFrame) this.getTopLevelAncestor()).setAlwaysOnTop(false);
				menuItem_1.setText("Allwas on Top");
			} else {
				((JFrame) this.getTopLevelAncestor()).setAlwaysOnTop(true);
				menuItem_1.setText("Not allwas on Top");
			}
		}

		if (e.getActionCommand().equals("XL")) {
			DPIFixV3.scaleSwingFonts((float) Math.pow(2.0, 1.0 / 3.0));
			SwingUtilities.updateComponentTreeUI(frame);
			frame.pack();
		}

		if (e.getActionCommand().equals("XS")) {
			DPIFixV3.scaleSwingFonts((float) (1.0 / Math.pow(2.0, 1.0 / 3.0)));
			SwingUtilities.updateComponentTreeUI(frame);
			frame.pack();
		}
	}
}
