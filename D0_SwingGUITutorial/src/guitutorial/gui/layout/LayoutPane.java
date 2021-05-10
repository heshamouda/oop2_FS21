package guitutorial.gui.layout;

import java.awt.event.KeyEvent;

import javax.swing.JTabbedPane;

import guitutorial.gui.Controller;
import guitutorial.util.Utility;

public class LayoutPane extends JTabbedPane {

	private FlowLayoutPanel flowLayoutPanel;
	private BorderLayoutPanel borderLayoutPanel;
	private GridLayoutPanel gridLayoutPanel;
	private GridBagLayoutPanel gridBagLayoutPanel;
	private CardLayoutPanel cardLayoutPanel;

	public LayoutPane(Controller controller) {
		setTabPlacement(JTabbedPane.RIGHT);

		flowLayoutPanel = new FlowLayoutPanel(controller);
		addTab("FlowLayoutPanel", Utility.loadResourceIcon("blue-velvet/16x16/chart.png"), flowLayoutPanel,
				"<html> ... </html>");
		setMnemonicAt(0, KeyEvent.VK_P);

		borderLayoutPanel = new BorderLayoutPanel(controller);
		addTab("BorderLayoutPanel", Utility.loadResourceIcon("blue-velvet/16x16/chart.png"), borderLayoutPanel,
				"<html> ... </html>");
		setMnemonicAt(0, KeyEvent.VK_P);

		gridLayoutPanel = new GridLayoutPanel(controller);
		addTab("GridLayoutPanel", Utility.loadResourceIcon("blue-velvet/16x16/chart.png"), gridLayoutPanel,
				"<html> ... </html>");
		setMnemonicAt(0, KeyEvent.VK_P);

		gridBagLayoutPanel = new GridBagLayoutPanel(controller);
		addTab("GridBagLayoutPanel", Utility.loadResourceIcon("blue-velvet/16x16/chart.png"), gridBagLayoutPanel,
				"<html> ... </html>");
		setMnemonicAt(0, KeyEvent.VK_P);

		cardLayoutPanel = new CardLayoutPanel(controller);
		addTab("CardLayoutPanel", Utility.loadResourceIcon("blue-velvet/16x16/chart.png"), cardLayoutPanel,
				"<html> ... </html>");
		setMnemonicAt(0, KeyEvent.VK_P);
	}
}
