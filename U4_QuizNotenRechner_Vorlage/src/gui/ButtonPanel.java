package gui;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import util.MyBorderFactory;
import util.TraceV3;

public class ButtonPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private TraceV3 trace = new TraceV3(this);
	private Controller controller;
	private JButton btBerechne = new JButton("Berechne");
	private JButton btReset = new JButton("Reset");

	/**
	 * <pre>
	 * - setzt Attribute der Klasse
	 * - platziert die Elemente im GridbagLayout nach Skizze und Klassendiagramm
	 * </pre>
	 */
	public ButtonPanel(Controller controller) {
		super(new GridBagLayout());
		trace.constructorCall();
		setBorder(MyBorderFactory.createMyBorder(" ButtonPanel "));
		
		
		
		
	}

	/**
	 * <pre>
	 * - ruft je nach Event die passende Controller Methode auf
	 * </pre>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		trace.eventCall();
		
	}
}
