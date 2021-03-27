import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.FontUIResource;

public class View extends JPanel {

	// load an instance from controller in the view

	private Controller controller;

	public void setController(Controller controller) {
		this.controller = controller;
	}
	
	

	private JLabel lbDice = new JLabel("-");
	private JButton btRollButton = new JButton("Roll");
	private Insets insets = new Insets(5, 5, 5, 5);

	public void init() {
		setLayout(new GridBagLayout());
		
		lbDice.setFont(new Font("Monospaced",Font.PLAIN, 40));
		lbDice.setOpaque(true);
		lbDice.setBackground(Color.DARK_GRAY);
		lbDice.setForeground(Color.WHITE);

		add(lbDice, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				insets, 0, 0));

		add(btRollButton, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.NONE, insets, 0, 0));
		
		//action with button when controller called
		btRollButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.roll();				
			}
		});

	}

	public void update(Model model) {
		lbDice.setText(" "+model.dice+ " ");			
	}
}
