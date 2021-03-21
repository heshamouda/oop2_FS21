package gui;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import util.MyBorderFactory;
import util.Observable;
import util.Observer;
import util.TraceV3;

public class View extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	TraceV3 trace = new TraceV3(this);
	public SmileyPanel smileyPanel = new SmileyPanel();
	public InputPanel inputPanel;
	public ButtonPanel buttonPanel;

	/**
	 * -erzeugt und platziert die drei Panels im GridbagLayout nach Skizze
	 */
	public View(Controller controller) {
		super(new GridBagLayout());
		trace.constructorCall();
		setBorder(MyBorderFactory.createMyBorder(" ViewPanel "));

		inputPanel = new InputPanel(controller);
		buttonPanel = new ButtonPanel(controller);
		add(inputPanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));
		add(smileyPanel, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(buttonPanel, new GridBagConstraints(0, 1, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

	}

	/**
	 * <pre>
	 * - sorgt für update der Panels
	 * </pre>
	 */
	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		inputPanel.update(obs, obj);
		smileyPanel.update(obs, obj);
	}
}
