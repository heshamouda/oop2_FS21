import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.MyBorderFactory;
import util.Observable;
import util.TraceV4;

public class PropertyPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private TraceV4 trace = new TraceV4(this);
	
	public JTextField tfEff = new JTextField(10);
	public JTextField tfPeak = new JTextField(10);
	public JTextField tfCrest = new JTextField(10);
	
	
	/**
	 * <pre>
	 * - platiert die Elemente im GridbagLayout
	 * - Textfelder sollen horizontal wachsen
	 * - Labels sollen unverändert bleiben
	 * - Als letzte Zeile eine in beide Richtung wachsende Leerzeile ergaenzen
	 * </pre>
	 */
	public PropertyPanel() {
		trace.constructorCall();
		setLayout(new GridBagLayout());
		setBorder(MyBorderFactory.createMyBorder(" Signaleigenschaften "));
		
			
		
	}

	/**
	 * - holt sich die aktuellen Daten aus Modell zum update der Elemente
	 * @param obs
	 * @param obj
	 */
	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		
		
	}
}

