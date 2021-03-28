import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.Observable;
import util.Observer;
import util.TraceV4;

public class View extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	private TraceV4 trace = new TraceV4(this);

	public ParameterPanel parameterPanel;
	private PropertyPanel propertyPanel;
	private PlotPanel plotPanel;
	public ButtonPanel buttonPanel;

	/**
	 * <pre>
	 * - erzeugt die Panels und platziert im GridbagLayout
	 *   Panels sollen bei Vergroesserung mitwachsen
	 * </pre>
	 */
	public View(Controller controller) {
		trace.constructorCall();
		setLayout(new GridBagLayout());

		parameterPanel = new ParameterPanel(controller);
		propertyPanel = new PropertyPanel();
		plotPanel = new PlotPanel();
		buttonPanel = new ButtonPanel(controller);

		add(parameterPanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
				GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0));

		add(propertyPanel, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
				GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0));

		add(plotPanel, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));

		add(buttonPanel, new GridBagConstraints(0, 2, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));
	}

	/**
	 * <pre>
	 * - ruft die update Methode der entsprechenden Panels auf
	 * 
	 * </pre>
	 */
	@Override
	public void update(Observable obs, Object obj) {
		trace.methodeCall();

		propertyPanel.update(obs, obj);
		plotPanel.update(obs, obj);

	}
}
