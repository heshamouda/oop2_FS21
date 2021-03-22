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

	private JTextField tfMinVal = new JTextField(10);

	private JTextField tfMaxVal = new JTextField(10);

	private JTextField tfMeanPower = new JTextField(10);

	public PropertyPanel() {
		setLayout(new GridBagLayout());
		setBorder(MyBorderFactory.createMyBorder(" Property Panel "));

		

	}

	public void update(Observable obs, Object obj) {
		if (obs instanceof Model) {
			Model model = (Model) obs;
			

		}
	}

}
