package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Model;
import util.MyBorderFactory;
import util.Observable;

public class PropertyPanel extends JPanel {
	private static final long serialVersionUID = 1L;	
	private static final Insets insets = new Insets(10, 10, 10, 10);

	private JTextField tfMinVal = new JTextField(10);

	private JTextField tfMaxVal = new JTextField(10);

	private JTextField tfMeanPower = new JTextField(10);

	public PropertyPanel() {
		setLayout(new GridBagLayout());
		setBorder(MyBorderFactory.createMyBorder(" Property Panel "));

		add(new JLabel("MinValue"), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, insets, 0, 0));
		add(tfMinVal, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, insets, 0, 0));	
		tfMinVal.setEditable(false);	
		
		add(new JLabel("MaxValue"), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, insets, 0, 0));
		add(tfMaxVal, new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, insets, 0, 0));
		tfMaxVal.setEditable(false);
		
		add(new JLabel("Average power"), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, insets, 0, 0));
		add(tfMeanPower, new GridBagConstraints(1, 2, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, insets, 0, 0));
		tfMeanPower.setEditable(false);
	}

	public void update(Observable obs, Object obj) {
		if (obs instanceof Model) {
			Model model = (Model) obs;	
			tfMinVal.setText(Double.toString(model.getMinValue()));
			tfMaxVal.setText(Double.toString(model.getMaxValue()));
			tfMeanPower.setText(Double.toString(model.getMeanPower()));
		}
	}
}
