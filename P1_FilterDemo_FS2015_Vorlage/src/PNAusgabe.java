import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PNAusgabe extends JPanel {
	private JTextField jtfFrequenz = new JTextField();
	private JTextField jtfAmplitude = new JTextField();

	public PNAusgabe() {
		super(new GridBagLayout());
		setBorder(MyBorderFactory.createBorder(" " + getClass().getName() + " "));

		jtfAmplitude.setEditable(false);
		jtfFrequenz.setEditable(false);

		add(new JLabel("Amplitude: "), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(jtfAmplitude, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(new JLabel("dB"), new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel("Frequenz: "), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(jtfFrequenz, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(new JLabel("Hz"), new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel(), new GridBagConstraints(0, 2, 3, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));
	}

	public void update(Observable obs, Object obj) {
		Model model = (Model) obs;

		jtfAmplitude.setText("" + Math.round((200.0 * Math.log10(model.getTestAmplitude()))) / 10.0);
		jtfFrequenz.setText("" + model.getTestFrequenz());
	}

}

