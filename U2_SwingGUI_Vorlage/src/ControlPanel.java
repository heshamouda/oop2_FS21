
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
		
		hpButton= new JRadioButton("Hochpass");
		hpButton.setMnemonic(KeyEvent.VK_H); //to be actioned using alt+H
		hpButton.setActionCommand("Hochpass"); //to read when press the button
		hpButton.setSelected(true);
		hpButton.addActionListener(this);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

	}
}
