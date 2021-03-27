package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import util.MyBorderFactory;
import util.Observable;
import util.Observer;
import util.TraceV5;

public class View extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;

	public ParameterPanel parameterPanel;
	public PropertyPanel propertyPanel = new PropertyPanel();
	public PlotPanel plotPanel = new PlotPanel();

	public View(Controller controller) {
		super(new GridBagLayout());
		setBorder(MyBorderFactory.createMyBorder(" View Panel "));

		parameterPanel = new ParameterPanel(controller);
		
		add(plotPanel, new GridBagConstraints(0, 0, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));

		add(parameterPanel, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0));

		add(propertyPanel, new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0));

		

	}

	public void update(Observable obs, Object obj) {
		propertyPanel.update(obs, obj);
		plotPanel.update(obs, obj);

	}

}
