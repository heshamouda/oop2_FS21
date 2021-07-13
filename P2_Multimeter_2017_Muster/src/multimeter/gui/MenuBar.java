package multimeter.gui;
//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.

//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name:
//Vorname:

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar implements ActionListener {
	// 10 + 12
	private static final long serialVersionUID = 1L;
	private JMenu menu;
	private JCheckBoxMenuItem menuItemLog;
	private JMenuItem menuItemExit;
	private Controller controller;

	/**
	 * Erzeugt MenuBar gemäss Aufgabenstellung.
	 * 
	 * @param controller
	 * @param frame
	 */
	public MenuBar(Controller controller) {
		// 10
		this.controller = controller;
		menu = new JMenu("File");
		menuItemLog = new JCheckBoxMenuItem("Logging");
		menuItemLog.addActionListener(this);
		menu.add(menuItemLog);
		menu.addSeparator();
		menuItemExit = new JMenuItem("Exit");
		menuItemExit.addActionListener(this);
		menu.add(menuItemExit);
		add(menu);
	}

	/**
	 * <pre>
	 * Challenge:
	 * - ...
	 * </pre>
	 */
	public void actionPerformed(ActionEvent e) {
		// 12
		if (e.getSource() == menuItemLog && menuItemLog.isSelected()) {
			JFileChooser chooser = new JFileChooser();
			chooser.setMultiSelectionEnabled(false);
			int result = chooser.showSaveDialog(null);
			if (result == JFileChooser.APPROVE_OPTION) {
				File file = chooser.getSelectedFile();
				controller.startLogging(file.toString());
			}
		}
		if (e.getSource() == menuItemLog && !menuItemLog.isSelected()) {
			controller.stopLogging();
		}
		if (e.getSource() == menuItemExit) {
			controller.stopLogging();
			System.exit(0);
		}
	}
}
