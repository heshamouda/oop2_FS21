package guitutorial.gui.container;

import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import guitutorial.gui.Controller;

public class SplitPane extends JSplitPane {

	private JPanel jpLeft = new JPanel(new GridBagLayout());
	private JPanel jpRight = new JPanel();
	private Controller controller;

	public SplitPane(Controller controller) {
		//		setBorder(MyBorderFactory.createMyBorder(" SplitPane "));
		this.controller = controller;

		setOneTouchExpandable(true);
		setResizeWeight(0.0);
		setDividerSize(10);

		setContinuousLayout(false);
		// Stuff on left component.
		jpLeft.add(new JLabel("Hallo Velo links"));
		// Stuff on right component.
		jpRight.add(new JLabel("Hallo Velo rechts"));
		// Setting left and right component.
		setLeftComponent(jpLeft);
		setRightComponent(jpRight);
		setDividerLocation(jpLeft.getPreferredSize().width + getInsets().left);
	}
}
