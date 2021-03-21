import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	final JButton colorButton = new JButton("color");
	final JPanel colorPanel = new JPanel();
	final Insets insets= new Insets(5,5,5,5);
	final GridBagConstraints colorButtonConstraints= new GridBagConstraints(0,1,1,1,1.0,1.0,GridBagConstraints.CENTER
			,GridBagConstraints.BOTH,insets,0,0);
	
	final GridBagConstraints colorPanelConstraints= new GridBagConstraints(0,0,1,1,1.0,2.0,GridBagConstraints.CENTER
			,GridBagConstraints.BOTH, insets,0,0);
	


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
//setLayout(null);
//		colorButton.setBounds(50, 200, 100, 50);
//		colorPanel.setBounds(0, 0, 200, 200);
		setLayout(new GridBagLayout());
		add(colorButton, colorButtonConstraints);
		add(colorPanel, colorPanelConstraints);
		
		colorPanel.setMinimumSize(new Dimension(0,200));
		colorPanel.setPreferredSize(new Dimension(800,600));
		

		colorButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// Color color= Math.random() > 0.5 ? Color.RED: Color.BLUE;
				Color color = new Color((float) Math.random(), (float) Math.random(), (float) Math.random(), 1.0f);
				colorPanel.setBackground(color);

			}
		});

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
