package bikeometer.gui;

// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
// Klasse:
//

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bikeometer.tools.MyBorderFactory;

public class InputPanel extends JPanel implements ActionListener {
	// 4 + 18 = 22
	private static final long serialVersionUID = 1L;
	private JTextField tfKMLDatei = new JTextField(10);
	private JTextField tfIntervall = new JTextField("  5.0");
	private JButton btBrowse = new JButton("Durchsuchen");
	private JButton btLoad = new JButton("Laden");
	private JFileChooser fc = new JFileChooser("./");
	private Controller controller;

	/**
	 * <pre>
	 * - Das InputPanel ist als GridLayout organisiert und erzeugt und platziert die entsprechenden GUI - Elemente. 
	 * - Setzt das Attribut controller entsprechend controller
	 * - Registriert ActionListener.
	 * - Hat eine Border mit Text "InputPanel - Eingaben".
	 * </pre>
	 * 
	 * @param controller
	 */
	public InputPanel(Controller controller) {
		// 11
		super(new GridLayout(1, 6, 10, 10));
		this.controller = controller;
		setBorder(MyBorderFactory.createMyBorder("InputPanel - Eingaben"));
		add(new JLabel("KML - Datei: "));
		add(tfKMLDatei);
		btBrowse.addActionListener(this);
		add(btBrowse);
		add(new JLabel("Zeitintervall: "));
		add(tfIntervall);
		btLoad.addActionListener(this);
		add(btLoad);
	}

	/**
	 * <pre>
	 * - Falls Quelle des Ereignis "Durchsuchen" - Button
	 * 		- Mittels JFileChooser Dateiname ermitteln und im ersten Textfeld ablegen.
	 * - Falls Quele des Ereignis "Laden" - Button
	 * 		- loadKMLDatei des Controller - Objektes mit Text aus erstem TextFeld und Zahl aus zweitem Textfeld aufrufen.
	 * </pre>
	 */
	public void actionPerformed(ActionEvent e) {
		// 7
		if (e.getSource() == btBrowse) {
			int returnVal = fc.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				tfKMLDatei.setText(file.getPath());
			}
		}
		if (e.getSource() == btLoad) {
			controller.loadKMLDatei(tfKMLDatei.getText(), Double.parseDouble(tfIntervall.getText()));
		}
	}

}
