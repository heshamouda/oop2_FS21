package guitutorial.gui.layout;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import guitutorial.gui.Controller;

public class FlowLayoutPanel extends JPanel {

	public JButton jbt1 = new JButton(" OK ");

	public FlowLayoutPanel(Controller controller) {
		super(new FlowLayout());

		add(jbt1);

	}

}
