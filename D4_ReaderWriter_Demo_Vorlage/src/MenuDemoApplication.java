import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class MenuDemoApplication extends JFrame implements ActionListener {
	private TraceV8 trace = new TraceV8(this);
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
	private JMenu menu, submenu;
	private JMenuItem menuItem, submenuItem;

	public MenuDemoApplication() {
		trace.constructorCall();
		menuBar = new JMenuBar();

		menu = new JMenu("menu:JMenu"); // Top-Level Menu

		menuItem = new JMenuItem("menuItem:JMenuItem", KeyEvent.VK_J);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK));

		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();

		submenu = new JMenu("submenu:JMenu");
		menu.add(submenu);

		submenuItem = new JMenuItem("sumenuItem:JMenuItem", KeyEvent.VK_S);
		submenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.CTRL_MASK));
		submenuItem.addActionListener(this);
		submenu.add(submenuItem);

		// ...
		menuBar.add(menu);
		setJMenuBar(menuBar);

		pack();
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		trace.eventCall();
		System.out.println("" + e.getSource());
	}

	public static void main(String args[]) {
		TraceV8.mainCall();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				MenuDemoApplication demo = new MenuDemoApplication();
				demo.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
			}
		});
	}
}
