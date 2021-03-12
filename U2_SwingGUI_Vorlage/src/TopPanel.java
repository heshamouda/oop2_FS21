import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class TopPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private ParameterPanel parameterPanel = new ParameterPanel();
	private PropertyPanel propertyPanel = new PropertyPanel();
	private ControlPanel controlPanel = new ControlPanel();

	public TopPanel() {
		setLayout(new GridBagLayout());

		
	}

}
