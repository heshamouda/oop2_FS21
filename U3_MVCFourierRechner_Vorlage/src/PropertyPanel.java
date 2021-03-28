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
	private static final Insets insets = new Insets(10, 10, 10, 10);
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

		add(new JLabel("Effektiwert"), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, insets, 0, 0));
		add(tfEff, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				insets, 0, 0));
		tfEff.setEditable(false);
		add(new JLabel("Sitzenwert"), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, insets, 0, 0));
		add(tfPeak, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				insets, 0, 0));
		tfPeak.setEditable(false);
		add(new JLabel("Crest-Faktor"), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, insets, 0, 0));
		add(tfCrest, new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, insets, 0, 0));
		tfCrest.setEditable(false);
		
		add(new JLabel(), new GridBagConstraints(0, 4, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0)); // leerzeile

	}

	/**
	 * - holt sich die aktuellen Daten aus Modell zum update der Elemente
	 * 
	 * @param obs
	 * @param obj
	 */
	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		Model model = (Model) obs;
		
	}
}
