package guitutorial.gui;

import java.awt.event.KeyEvent;

import javax.swing.JTabbedPane;

import guitutorial.gui.basiccontrol.BasicControlPanel;
import guitutorial.gui.container.ContainerPane;
import guitutorial.gui.infodisplay.InfoDisplayPanel;
import guitutorial.gui.layout.LayoutPane;
import guitutorial.util.MyBorderFactory;
import guitutorial.util.Observable;
import guitutorial.util.Observer;
import guitutorial.util.Utility;

public class TopView extends JTabbedPane implements Observer {

	BasicControlPanel basicControlPanel;
	InfoDisplayPanel infoDisplayPanel;
	ContainerPane containerPane;
	LayoutPane layoutPane;

	public TopView(Controller controller) {
		setTabPlacement(JTabbedPane.TOP);
		setBorder(MyBorderFactory.createMyBorder(" Topview "));

		basicControlPanel = new BasicControlPanel(controller);
		addTab("BasicControlPanel", Utility.loadResourceIcon("axialis-blue/16x16/Weather Sun.png"), basicControlPanel,
				"Simple components that are used primarily to get input from the user they may also show simple state.");
		setMnemonicAt(0, KeyEvent.VK_B);

		infoDisplayPanel = new InfoDisplayPanel(controller);
		addTab("InfoDisplayPanel", Utility.loadResourceIcon("axialis-blue/16x16/Weather Snow.png"), infoDisplayPanel,
				"These components exist solely to give the user information.");
		setMnemonicAt(1, KeyEvent.VK_I);

		containerPane = new ContainerPane(controller);
		addTab("ContainerPane", Utility.loadResourceIcon("axialis-blue/16x16/Weather Rain.png"), containerPane,
				"Swing provides many different containers ...");
		setMnemonicAt(2, KeyEvent.VK_C);

		layoutPane = new LayoutPane(controller);
		addTab("LayoutPane", Utility.loadResourceIcon("axialis-blue/16x16/Weather Cloud Sun.png"), layoutPane,
				"This tab shows some usefull layout - managers ..");
		setMnemonicAt(3, KeyEvent.VK_L);

		this.setSelectedComponent(basicControlPanel);
	}

	public void update(Observable obs, Object obj) {}

}
