package gui;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.MyBorderFactory;
import util.Observable;
import util.TraceV3;

public class InputPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private TraceV3 trace = new TraceV3(this);
	public JTextField tfAnzahlPunkte = new JTextField("8.0");
	public JTextField tfMaxPunkte = new JTextField("12.0");
	public JTextField tfNote = new JTextField(10);
	private Controller controller;

	/**
	 * <pre>
	 * - setzt Attribute der Klasse
	 * - platziert die Elemente im GridbagLayout nach Skizze und Klassendiagramm
	 * </pre>
	 */
	public InputPanel(Controller controller) {
		super(new GridBagLayout());
		trace.constructorCall();
		setBorder(MyBorderFactory.createMyBorder(" InputPanel "));

		

	}

	/**
	 * <pre>
	 * - ruft btBerechne() des Controlers auf
	 * </pre>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		trace.eventCall();
		
	}

	/**
	 * <pre>
	 * - zeigt Note auf eine Nachkommastellen gerundet an
	 * </pre>
	 */
	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		
	}
}
