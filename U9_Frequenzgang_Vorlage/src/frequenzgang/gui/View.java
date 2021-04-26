package frequenzgang.gui;

import java.awt.Dimension;
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
import util.TraceV5;

public class View extends JPanel implements Observer, ActionListener {
	private TraceV5 trace = new TraceV5(this);
	private static final long serialVersionUID = -7462236257522307804L;
	public JTextField tfZaehler = new JTextField(40);
	public JTextField tfNenner = new JTextField(40);
	private Controller controller;

	public JButton btOk = new JButton("Berechne Frequenzgang");
	private AmplitudenPlot amplitudenPlot = new AmplitudenPlot();
	private PhasenPlot phasenPlot = new PhasenPlot();

	public View(Controller controller) {
		super(new GridBagLayout());
		trace.constructorCall();
		tfZaehler.setText("0, 0, 0, 0, 1.5585e+16");
		tfNenner.setText("1.0, 2.919e+004, 4.262e+8, 3.645e+12, 1.558e+16");

	}

	public void actionPerformed(ActionEvent e) {
		trace.eventCall();
		
	
	}

	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		
	
	}
}
