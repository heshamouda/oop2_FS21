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

		
	}

	/**
	 * <pre>
	 * - sorgt für update der Panels
	 * </pre>
	 */
	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		
	}
}
