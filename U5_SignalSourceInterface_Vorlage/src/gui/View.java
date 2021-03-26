package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JPanel;
import util.MyBorderFactory;
import util.Observable;
import util.Observer;

public class View extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;

	public ParameterPanel parameterPanel;
	public PropertyPanel propertyPanel = new PropertyPanel();
	public PlotPanel plotPanel = new PlotPanel();

	public View(Controller controller) {
		super(new GridBagLayout());
		setBorder(MyBorderFactory.createMyBorder(" View Panel "));

		
		
		

		

	}

	public void update(Observable obs, Object obj) {
		

	}

}
