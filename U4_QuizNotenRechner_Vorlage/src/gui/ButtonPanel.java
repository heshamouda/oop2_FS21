package gui;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.MyBorderFactory;
import util.TraceV3;

public class ButtonPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final Insets insets = new Insets(10, 10, 10, 10);
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
		this.controller = controller;
		
		add(btBerechne, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, insets, 0, 0));
		btBerechne.addActionListener(this);
		
		add(btReset, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, insets, 0, 0));	
		btReset.addActionListener(this);
	}

	/**
	 * <pre>
	 * - ruft je nach Event die passende Controller Methode auf
	 * </pre>.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		trace.eventCall();
		if (e.getSource()== btBerechne) {
			controller.btBerechne();		
		}
		
		if (e.getSource().equals(btReset)) {
			controller.btReset();
		}
		
	}
}
