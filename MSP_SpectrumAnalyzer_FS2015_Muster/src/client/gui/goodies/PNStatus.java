package client.gui.goodies;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.EventObject;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class PNStatus extends JPanel implements ActionListener {
	class PopupListener extends MouseAdapter {

		private void maybeShowPopup(MouseEvent e) {
			if (e.isPopupTrigger()) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			maybeShowPopup(e);
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			maybeShowPopup(e);
		}
	}

	private static final long serialVersionUID = 1L;
	private static JTextArea textArea = new JTextArea(3, 50);
	private JPopupMenu popup = new JPopupMenu();

	private static JCheckBoxMenuItem cbMenuItem = new JCheckBoxMenuItem(
			"Append", true);

	public PNStatus() {
		super(new BorderLayout());
		textArea.setEditable(false);
		cbMenuItem.setMnemonic(KeyEvent.VK_C);
		popup.add(cbMenuItem);
		popup.addSeparator();
		JMenuItem menuItem = new JMenuItem("Clear Status");
		menuItem.setActionCommand("clear");
		menuItem.addActionListener(this);
		popup.add(menuItem);
		MouseListener popupListener = new PopupListener();
		addMouseListener(popupListener);
		textArea.addMouseListener(popupListener);
		setBorder(MyBorderFactory.createBorder(" " + "Status" + " "));
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane
				.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(scrollPane, BorderLayout.CENTER);
		setMinimumSize(new Dimension(
				(int) (this.getPreferredSize().getWidth()),
				(int) (this.getPreferredSize().getHeight())));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("clear")) {
			textArea.setText("");
		}
	}

	public static void clear() {
		textArea.setText("");
	}

	public static void showStatus(EventObject e, String text) {
		if (cbMenuItem.getState()) {
			textArea.setText(textArea.getText() + "\n"
					+ e.getSource().getClass().getSimpleName() + ": " + text);
		} else {
			textArea.setText(e.getSource().getClass().getSimpleName() + ": "
					+ text);
		}
	}

	public static void showStatus(Object o, EventObject e, String text) {
		if (cbMenuItem.getState()) {
			textArea.setText(textArea.getText() + "\n" + o.getClass()
					+ ": Command \"" + text + "\" fired by "
					+ e.getSource().getClass().getSimpleName());
		} else {
			textArea.setText(o.getClass() + ": Command \"" + text
					+ "\" fired by " + e.getSource().getClass().getSimpleName());
		}
	}

	public static void showStatus(String text) {
		if (cbMenuItem.getState()) {
			textArea.setText(textArea.getText() + "\n" + text);
		} else {
			textArea.setText(text);
		}
	}
}
