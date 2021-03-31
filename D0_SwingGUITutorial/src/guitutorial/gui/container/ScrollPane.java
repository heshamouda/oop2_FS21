package guitutorial.gui.container;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import guitutorial.gui.Controller;

public class ScrollPane extends JPanel {

	private JTextArea textArea = new JTextArea(5, 30);
	private JScrollPane scrollPane = new JScrollPane(textArea);
	private Controller controller;

	public ScrollPane(Controller controller) {
		//		setBorder(MyBorderFactory.createMyBorder(" ScrollPane "));
		this.controller = controller;

		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);

		textArea.setText("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, "
				+ "sed diam nonumy eirmod tempor invidunt ut labore et dolore "
				+ "magna aliquyam erat, sed diam voluptua. At vero eos et accusam "
				+ "et justo duo dolores et ea rebum. Stet clita kasd gubergren, "
				+ "no sea takimata sanctus est Lorem ipsum dolor sit amet. "
				+ "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, "
				+ "sed diam nonumy eirmod tempor invidunt ut labore et dolore magna "
				+ "aliquyam erat, sed diam voluptua. At vero eos et accusam et "
				+ "justo duo dolores et ea rebum. Stet clita kasd gubergren, no "
				+ "sea takimata sanctus est Lorem ipsum dolor sit amet.");
	}

}
