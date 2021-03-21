import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	final JButton colorButton= new JButton("color");
	final JPanel colorPanel= new JPanel();
//
//	private final Insets insets = new Insets(5, 5, 5, 5);
//
//	JButton bt(String name) {
//		return new JButton(name);
//	}
//
//	/**
//	 * Run init code here (the view has valid dimensions at this point)
//	 */
	public void init() {
		setLayout(null);
		add(colorButton);
		colorButton.setBounds(50, 200, 100,50);
		add(colorPanel);
		colorPanel.setBounds(0, 0, 200, 200);
		
		colorButton.addActionListener(new ActionListener(	) {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Color color= Math.random() > 0.5 ? Color.RED: Color.BLUE;
				colorPanel.setBackground(color);
				
			}
		});
		colorPanel.setBackground(Color.blue);
//		setLayout(new GridBagLayout());
//
//		panel.setBackground(Color.DARK_GRAY);
//
//		add(panel, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, insets,
//				0, 0));
//
//		add(button, new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.PAGE_END, GridBagConstraints.NONE,
//				insets, 0, 0));
//
	}
}
