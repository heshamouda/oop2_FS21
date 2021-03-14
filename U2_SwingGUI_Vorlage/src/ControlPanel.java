
import java.awt.BorderLayout;
import java.awt.Dimension;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class ControlPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JRadioButton hpButton, lpButton;
	private JButton btExecute = new JButton("EXECUTE");
	private JTextArea taOutput = new JTextArea(10, 40);

	public ControlPanel() {
		setLayout(new BorderLayout());
		setBorder(MyBorderFactory.createMyBorder(" Control Panel "));
		setPreferredSize(new Dimension(550, 400));
		//create the buttons
		hpButton= new JRadioButton("Hochpass");
		hpButton.setMnemonic(KeyEvent.VK_H); //to be actioned using alt+H
		hpButton.setActionCommand("Hochpass is on"); //to read when press the button
		hpButton.setSelected(true);
		hpButton.addActionListener(this);
		
		lpButton= new JRadioButton("Tiefpass");
		lpButton.setMnemonic(KeyEvent.VK_T); //to be actioned using alt+H
		lpButton.setActionCommand("Tiefpass is on"); //to read when press the button
		//lpButton.setSelected(true);
		//lpButton.addActionListener(this);
		
		//create the field of group
		ButtonGroup filterGroup= new ButtonGroup();
		filterGroup.add(hpButton);
		filterGroup.add(lpButton);
		
		//add the buttons
		add(hpButton,BorderLayout.WEST);
		add(lpButton,BorderLayout.EAST);
		
		
		
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

	}
}
