import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class TopPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ParameterPanel parameterPanel = new ParameterPanel();
	private PropertyPanel propertyPanel = new PropertyPanel();
	private ControlPanel controlPanel = new ControlPanel();
	// GridBagConstraints gpc=new GridBagConstraints();

	public TopPanel() {
		setLayout(new GridBagLayout());

		add(parameterPanel, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

		add(propertyPanel, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

		add(controlPanel, new GridBagConstraints(0, 1, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0));

	}

}
