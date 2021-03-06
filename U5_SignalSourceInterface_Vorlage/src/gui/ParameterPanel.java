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
		
		this.controller = controller;
		
		
		slFilter.setMajorTickSpacing(1);
		//slFilter.setMinorTickSpacing(2);
		slFilter.setPaintTicks(true);
		slFilter.setPaintLabels(true);
		slFilter.addChangeListener(this);

		add(new JLabel("Varianz"), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(tfVarianz, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

		add(btRefresh, new GridBagConstraints(0, 1, 2, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		
		add(new JLabel("Filter Level"), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		
		add(slFilter, new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

		btRefresh.addActionListener(this);
		add(new JLabel(), new GridBagConstraints(0, 2, 2, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0)); // leerzeile
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		controller.btRefresh();
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		controller.slValue();
	}

}
