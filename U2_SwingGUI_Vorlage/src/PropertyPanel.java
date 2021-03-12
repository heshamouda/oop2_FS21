import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PropertyPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	private JTextField tfProp1 = new JTextField(10);
	private JButton btbutton1 = new JButton("Button1");
	private JTextField tfProp2 = new JTextField(10);

	public PropertyPanel() {
		setLayout(new GridBagLayout());
		setBorder(MyBorderFactory.createMyBorder(" Property Panel "));

		

	}

}
