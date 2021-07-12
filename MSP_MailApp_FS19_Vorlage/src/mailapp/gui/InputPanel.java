// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
// Modulanlass:

package mailapp.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mailapp.model.Model;
import util.Observable;
import util.TraceV7;

public class InputPanel extends JPanel implements ItemListener, ActionListener {
	private TraceV7 trace = new TraceV7(this);
	private static final long serialVersionUID = 1L;
	// 17 + 6
	private Controller controller;
	private String[] mailListe = {};
	@SuppressWarnings("rawtypes")
	public JComboBox cbZeile = new JComboBox();
	public JTextField tfSeperator = new JTextField(5);

	/**
	 * <pre>
	 * - Baut das GUI gemäss Aufgabenstellung (Layout / Klassendiagramm).
	 * </pre>
	 * 
	 * @param controller
	 */
	public InputPanel(Controller controller) {
		super(new GridBagLayout());
		trace.constructorCall();
		tfSeperator.setText(",\\t");
		tfSeperator.setMinimumSize(tfSeperator.getPreferredSize());
		// 6

	}

	/**
	 * <pre>
	 * - Wandelt obs in ein Model model.
	 * - Falls die MailListe des Models nicht der MailListe entspricht:
	 *   - ItemListener this von JComboBox entfernen.
	 *   - Alle Items von JComboBox entfernen.
	 *   - Für i gleich Null bis kleiner der Länge der MailListe des Models:
	 *     - i-tes Element der MailListe des Models holen, '\t' durch ' ' ersetzen und Zeichenkette als Item zur JComboBox hinzufügen.
	 *   - JComboBox mittels setEditable() auf nicht editierbar setzen.
	 *   - this als ItemListener bei der JComboBox registrieren.
	 *   - mailListe gleich der MailListe des Models setzen.
	 * </pre>
	 * 
	 * @param obs
	 * @param obj
	 */
	@SuppressWarnings("unchecked")
	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		// 9
	}

	/**
	 * <pre>
	 * - Falls der Selected-Index der JComboBox grösser gleich Null ist:
	 *   - Mittels setActiveMail() des Controlles Selected-Index der JComboBox setzen.
	 * </pre>
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		// 2
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.setSeperators();
	}
}
