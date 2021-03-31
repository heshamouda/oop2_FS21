import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.MyBorderFactory;
import util.Observable;
import util.TraceV8;

public class PropertyPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private TraceV8 trace = new TraceV8(this);
	public JTextField tfEff = new JTextField(10);
	public JTextField tfPeak = new JTextField(10);
	public JTextField tfCrest = new JTextField(10);

	public PropertyPanel() {
		trace.constructorCall();
		setLayout(new GridBagLayout());
		setBorder(MyBorderFactory.createMyBorder(" Signaleigenschaften "));

		add(new JLabel("Effektivwert: "), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(tfEff, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		tfEff.setEditable(false);

		add(new JLabel("Spitzenwert: "), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(tfPeak, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		tfPeak.setEditable(false);

		add(new JLabel("Crest-Faktor: "), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(tfCrest, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		tfCrest.setEditable(false);

		add(new JLabel(), new GridBagConstraints(0, 3, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));
	}

	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		Model model = (Model) obs;
		double peak = model.getPeak();
		double rms = model.getRMS();
		
		tfPeak.setText(""+peak);
		tfEff.setText(""+rms);
		tfCrest.setText(""+(peak/rms));
	}
}
