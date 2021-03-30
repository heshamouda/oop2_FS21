package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Model;
import util.MyBorderFactory;
import util.Observable;

public class PropertyPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JTextField tfMinVal = new JTextField(10);

	private JTextField tfMaxVal = new JTextField(10);

	private JTextField tfMeanPower = new JTextField(10);

	public PropertyPanel() {
		setLayout(new GridBagLayout());
		setBorder(MyBorderFactory.createMyBorder(" Property Panel "));

		add(new JLabel("MinValue"), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(tfMinVal, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		tfMinVal.setEditable(false);

		add(new JLabel("MaxValue"), new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(tfMaxVal, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		tfMaxVal.setEditable(false);

		add(new JLabel("Average Power"), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(tfMeanPower, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		tfMeanPower.setEditable(false);

		add(new JLabel(), new GridBagConstraints(0, 4, 2, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0)); // leerzeile

	}

	public void update(Observable obs, Object obj) {
		if (obs instanceof Model) {
			Model model = (Model) obs;
			tfMaxVal.setText(Double.toString(model.getMaxValue()));
			tfMinVal.setText(Double.toString(model.getMinValue()));
			tfMeanPower.setText(Double.toString(model.getMeanPower()));

		}
	}

}
