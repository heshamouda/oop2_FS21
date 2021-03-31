package taschenrechner.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import util.Observable;
import util.Observer;
import util.TraceV4;

public class View extends JPanel implements Observer, ActionListener {
	TraceV4 trace = new TraceV4(this);
	private Controller controller;
	private String[][] stButtonText = { { "7", "8", "9", "+" }, { "7", "8", "9", "+" }, { "7", "8", "9", "+" },
			{ "7", "8", "9", "+" } };
	private JButton[][] buttons = new JButton[4][4];
	private JPanel buttonPanel = new JPanel(new GridLayout(4, 4));

	public View(Controller controller) {
		super(new BorderLayout());
		trace.constructorCall();
		this.controller = controller;

		for (int i = 0; i < buttons.length; i++) {
			for (int k = 0; k < buttons[0].length; k++) {
				buttons[i][k] = new JButton(stButtonText[i][k]);
				buttons[i][k].addActionListener(this);
				buttonPanel.add(buttons[i][k]);
			}
		}

		add(buttonPanel, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		trace.eventCall();
	}

	@Override
	public void update(Observable observable, Object obj) {

	}

}
