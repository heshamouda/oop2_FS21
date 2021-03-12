import java.awt.event.KeyEvent;

import javax.swing.JTabbedPane;

public class ContainerPane extends JTabbedPane {

	private SplitPane splitPane;
	private ScrollPane scrollPane;

	public ContainerPane(Controller controller) {
		setTabPlacement(JTabbedPane.RIGHT);

		splitPane = new SplitPane(controller);
		addTab("SplitPane", Utility.loadResourceIcon("blue-velvet/16x16/chart.png"), splitPane,
				"<html>Der JSplitPane lässt sowohl eine horizontale als auch eine vertikale Teilung zu.</html>");
		setMnemonicAt(0, KeyEvent.VK_P);

		scrollPane = new ScrollPane(controller);
		addTab("ScrollPane", Utility.loadResourceIcon("blue-velvet/16x16/configure.png"), scrollPane,
				"Die Klasse javax.swing.JScrollPane ist ein Container, welcher mit einer Scrollbar <br> "
						+ "ausgestattet wird, wenn die Inhalte zu groß sind, um sie komplett darstellen zu können.");
		setMnemonicAt(1, KeyEvent.VK_C);
	}
}
