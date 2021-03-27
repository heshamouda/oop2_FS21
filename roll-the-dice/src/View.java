import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JPanel{
	
	private JLabel lbDice= new JLabel("-");
	private JButton btRollButton= new JButton("Roll");
	private Insets insets= new Insets(5, 5, 5, 5);
	
	public void init() {
		setLayout(new GridBagLayout());
		
		add(lbDice, new GridBagConstraints(0 ,0 , 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 
				insets, 0, 0));
		
		add(btRollButton, new GridBagConstraints(0 ,1 , 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, 
				insets, 0, 0));
		
		
		
	}
	

}
