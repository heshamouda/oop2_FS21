
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

		hpButton = new JRadioButton("Hochpass");
		hpButton.setMnemonic(KeyEvent.VK_H);
		hpButton.setActionCommand("Hochpass");
		hpButton.setSelected(true);
		hpButton.addActionListener(this);

		lpButton = new JRadioButton("Tiefpass");
		lpButton.setMnemonic(KeyEvent.VK_T);
		lpButton.setActionCommand("Tiefpass");
		lpButton.addActionListener(this);

		ButtonGroup filtergGroup = new ButtonGroup();
		filtergGroup.add(hpButton);
		filtergGroup.add(lpButton);

		add(hpButton, BorderLayout.WEST);
		add(lpButton, BorderLayout.EAST);

		add(taOutput, BorderLayout.CENTER);
		add(btExecute, BorderLayout.NORTH);
		btExecute.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btExecute) {
			taOutput.append("EXCUTE Button fired \r \n");
		}
		if (e.getSource() == lpButton) {
			taOutput.append("Radio Button LowPass fired \r \n");
		}
		if (e.getSource() == hpButton) {
			taOutput.append("Radio Button HighPass fired \r \n");
		}

	}

}
