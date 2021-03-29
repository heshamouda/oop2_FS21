package gui;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Model;
import util.MyBorderFactory;
import util.Observable;
import util.TraceV3;

public class InputPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static final Insets insets = new Insets(10, 10, 10, 10);
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
		this.controller = controller;
		
		add(new JLabel("Anzahl Punkte:"), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, insets, 0, 0));
		
		add(tfAnzahlPunkte, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, insets, 0, 0));	
		
		
		add(new JLabel("Max Punktzahl:"), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, insets, 0, 0));
		add(tfMaxPunkte, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, insets, 0, 0));		
		
		
		add(new JLabel("Note"), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, insets, 0, 0));
		add(tfNote , new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, insets, 0, 0));
		tfNote.setEditable(false);
		
		
		add(new JLabel(""),new GridBagConstraints(0, 3, 2, 1, 1.0, 1.0, GridBagConstraints.WEST,
				GridBagConstraints.BOTH, insets, 0, 0));		

	}

	/**
	 * <pre>
	 * - ruft btBerechne() des Controlers auf
	 * </pre>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		trace.eventCall();
		controller.btBerechne();		
	}

	/**
	 * <pre>
	 * - zeigt Note auf eine Nachkommastellen gerundet an
	 * </pre>
	 */
	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		if (obs instanceof Model) {
			Model model = (Model) obs;
			
			double note = Math.round(model.getData() * 1.0) / 10.0;
			tfNote.setText(""+ note);
		}
	}
}
