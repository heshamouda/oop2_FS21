package taschenrechner.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import taschenrechner.model.Model;
import util.Observable;
import util.Observer;
import util.TraceV5;

public class View extends JPanel implements Observer, ActionListener {
	TraceV5 trace = new TraceV5(this);
	private static final long serialVersionUID = 1L;
	private JButton btEnter = new JButton("Enter");
	private JTextField tfOut = new JTextField(30);
	private JPanel panelButton = new JPanel(new GridLayout(4, 4, 10, 10));
	private JButton[][] button = new JButton[4][4];
	private String[][] stButtonText = { { "7", "8", "9", "/" }, { "4", "5", "6", "*" }, { "1", "2", "3", "-" },
			{ "0", "", ".", "+" } };
	private Controller controller;

	/**
	 * <pre>
	 * - Setzt BorderLayout(10,10); - Setzt Attribute controller. - Erzeugt die
	 * Button, fügt sie dem Panel Button hinzu und registriert this als
	 * ActionListener bei jedem Button. - Baut den Rest des GUI.
	 * 
	 * <pre>
	 * 
	 * @param controller
	 */
	public View(Controller ctrl) {
		super(new BorderLayout(10, 10));
		trace.constructorCall();

		this.controller = ctrl;
		setBackground(Color.lightGray);
		for (int i = 0; i < button.length; i++) {
			for (int k = 0; k < button[0].length; k++) {
				button[i][k] = new JButton(stButtonText[i][k]);
				panelButton.add(button[i][k]);
				button[i][k].addActionListener(this);
			}
		}
		add(this.tfOut, BorderLayout.NORTH);
		panelButton.setBackground(Color.lightGray);
		add(panelButton, BorderLayout.CENTER);
		add(btEnter, BorderLayout.SOUTH);
		btEnter.addActionListener(this);
	}

	/**
	 * <pre>
	 * - Schaut ob einer der Button 1 - 9 gedrückt wurde:
	 * 	 - Falls ja:
	 * 	 	 - number() von controller mit zugehöriger Zahl aufrufen.
	 * - Falls Button mit der 0:
	 * 		 - number() von controller mit 0 aufrufen.
	 * - Falls anderer Button:
	 * 		 - entsprechende Methode von controller aufrufen.
	 * 
	 * </pre>
	 */
	public void actionPerformed(ActionEvent e) {
		trace.eventCall();

		switch (((JButton) e.getSource()).getText()) {
		case "/":
			controller.divide();
			break;
		case "*":
			controller.multiply();
			break;
		case "+":
			controller.add();
			break;
		case "-":
			controller.subtract();
			break;
		case "Enter":
			controller.enter();
			break;
		case ".":
			controller.dot();
			break;
		case "":
			break;
		default:
			int zahl = Integer.parseInt(((JButton) e.getSource()).getText());
			controller.number(zahl);
		}
	}

	/**
	 * <pre>
	 * - modelObject in Model wandeln.
	 * - Text in tfOut entsprechend Wert von getValue von model setzen.
	 * - StackInfo mittels syso anzeigen.
	 * </pre>
	 */
	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		Model model = (Model) obs;
		String s = String.format("%3.9f", model.getValue());
		// Nullen am Ende entfernen ...
		while (s.endsWith("0") && s.charAt(s.length() - 2) != '.') {
			s = s.substring(0, s.length() - 1);
		}
		tfOut.setText(s);
	}
}
