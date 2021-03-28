import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import util.MyBorderFactory;
import util.TraceV4;

public class ParameterPanel extends JPanel implements ActionListener, ItemListener {
	private static final long serialVersionUID = 1L;
	private TraceV4 trace = new TraceV4(this);
	private Controller controller;

	public JTextField tfAmp = new JTextField("1.0");
	public JTextField tfFreq = new JTextField("1.0");
	public JTextField tfHarm = new JTextField("10");
	public JComboBox<String> cbForm = new JComboBox<String>();

	/**
	 * <pre>
	 * - setzt Attribut der Klasse 
	 * - platziert die Elemente im GridbagLayout
	 * - Textfelder und ComboBox sollen horizontal wachsen
	 * - Labels sollen unverändert bleiben
	 * - Als letzte Zeile eine in beide Richtung wachsende Leerzeile ergaenzen
	 * </pre>
	 */
	public ParameterPanel(Controller controller) {
		trace.constructorCall();
		setLayout(new GridBagLayout());
		setBorder(MyBorderFactory.createMyBorder(" SignalParameter "));
 
	}

	/**
	 * <pre>
	 * -ruft die Controller Methode btBerechnen() auf
	 * - loesst neuzeichnen aus
	 * </pre>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		trace.eventCall();

	}

	/**
	 * <pre>
	 * -ruft die Controller Methode btBerechnen() auf
	 * -loesst neuzeichnen aus
	 * </pre>
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		trace.eventCall();

	}
}
