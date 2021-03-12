import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class ParameterPanel extends JPanel  {
	private static final long serialVersionUID = 1L;
	
	
	

	public JTextField tfParam1 = new JTextField("5.0");
	public JTextField tfParam2 = new JTextField("4");
	public JTextField tfParam3 = new JTextField("xx");


	public ParameterPanel() {
		
		setLayout(new GridBagLayout());
		setBorder(MyBorderFactory.createMyBorder(" Parameter Panel "));

		
		

	}


}
