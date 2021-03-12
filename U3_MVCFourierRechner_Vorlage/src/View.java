import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

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

	}
}
