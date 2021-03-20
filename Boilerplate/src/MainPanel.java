import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel {

	JPanel panel = new JPanel();
	JButton button = new JButton("ROLL");

	private final Insets insets = new Insets(5, 5, 5, 5);

	JButton bt(String name) {
		return new JButton(name);
	}

	/**
	 * Run init code here (the view has valid dimensions at this point)
	 */
	public void init() {
		setLayout(new GridBagLayout());

		panel.setBackground(Color.DARK_GRAY);

		add(panel, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets,
				0, 0));

		add(button, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.PAGE_END, GridBagConstraints.NONE,
				insets, 0, 0));

	}
}
