package gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import util.MyBorderFactory;

public class ParameterPanel extends JPanel implements ActionListener, ChangeListener {
	private static final long serialVersionUID = 1L;

	private Controller controller;
	public JTextField tfVarianz = new JTextField("4.0");
	public JButton btRefresh = new JButton("Refresh");
	public JSlider slFilter = new JSlider(JSlider.HORIZONTAL, 1, 3, 2);

	public ParameterPanel(Controller controller) {
		setLayout(new GridBagLayout());
		setBorder(MyBorderFactory.createMyBorder(" Parameter Panel "));
		
		
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		
	}

}
