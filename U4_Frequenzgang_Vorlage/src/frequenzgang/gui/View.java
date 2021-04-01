package frequenzgang.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.Observable;
import util.Observer;
import util.TraceV8;

public class View extends JPanel implements Observer, ActionListener {
	private TraceV8 trace = new TraceV8(this);
	private static final long serialVersionUID = -7462236257522307804L;
	public JTextField tfZaehler = new JTextField(40);
	public JTextField tfNenner = new JTextField(40);
	private Controller controller;

	public JButton btOk = new JButton("Ok");
	private AmplitudenPlot amplitudenPlot = new AmplitudenPlot();
	private PhasenPlot phasenPlot = new PhasenPlot();

	public View(Controller controller) {
		super(new GridBagLayout());
		trace.constructorCall();
	}

	public void actionPerformed(ActionEvent e) {
		trace.eventCall();
	}

	public void update(Observable obs, Object obj) {
		trace.methodeCall();
	}
}
