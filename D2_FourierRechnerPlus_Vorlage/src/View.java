import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import util.Observable;
import util.Observer;
import util.TraceV8;

public class View extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	private TraceV8 trace = new TraceV8(this);
	public ParameterPanel parameterPanel;
	private PropertyPanel propertyPanel;
	private PlotPanel plotPanel;
	public ButtonPanel buttonPanel;

	public View(Controller controller) {
		trace.constructorCall();
		setLayout(new GridBagLayout());

		parameterPanel = new ParameterPanel(controller);
		propertyPanel = new PropertyPanel();
		plotPanel = new PlotPanel();
		buttonPanel = new ButtonPanel(controller);

		add(parameterPanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0));
		add(propertyPanel, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0));

		add(plotPanel, new GridBagConstraints(0, 1, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));

		add(buttonPanel, new GridBagConstraints(0, 2, 2, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
	}

	@Override
	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		propertyPanel.update(obs, obj);
		plotPanel.update(obs, obj);
	}
}

