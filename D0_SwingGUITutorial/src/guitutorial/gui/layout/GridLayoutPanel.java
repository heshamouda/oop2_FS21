package guitutorial.gui.layout;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import guitutorial.gui.Controller;
import guitutorial.gui.StatusBar;

public class GridLayoutPanel extends JPanel implements ActionListener {

	private JButton[] buttons = new JButton[12];

	public GridLayoutPanel(Controller controller) {
		super(new GridLayout(0, 3));

		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton("" + i);
			buttons[i].addActionListener(this);
			add(buttons[i]);
		}
	}

	public void actionPerformed(ActionEvent e) {
		StatusBar.showStatus(this, e, ((JButton) e.getSource()).getText());
	}
}
