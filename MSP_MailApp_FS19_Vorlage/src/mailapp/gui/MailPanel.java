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

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import mailapp.model.BasicMail;
import mailapp.model.Model;
import util.Observable;
import util.TraceV7;

public class MailPanel extends JPanel implements ActionListener {
	private TraceV7 trace = new TraceV7(this);
	// 32
	private static final long serialVersionUID = 1L;
	private Controller controller;
	public JCheckBox cbVorschau = new JCheckBox("Vorschau");
	public JTextField tfEmpfaenger = new JTextField("Empfaenger");
	public JTextField tfBetreff = new JTextField("Betreff");
	public JTextArea taNachricht = new JTextArea();
	public JButton btSend = new JButton("Sende E-Mail");
	public JButton btSendAll = new JButton("Sende alle E-Mails");

	/**
	 * <pre>
	 * - Baut das GUI gemäss Aufgabenstellung (Layout / Klassendiagramm).
	 * </pre>
	 * 
	 * @param controller
	 */
	public MailPanel(Controller controller) {
		super(new GridBagLayout());
		trace.constructorCall();
		// 14

	}

	/**
	 * <pre>
	 * - Falls Check-Box isSelected():
	 *   - mail gleich Mail des Models.
	 * - Sonst:
	 *   - mail gleich MailTemplate des Models.
	 * - Text in Textfeld Empfaenger gleich Empfaenger der mail setzen.
	 * - Text in Textfeld Betreff gleich Betreff der mail setzen.
	 * - Text in der Text-Area Nachricht gleich Nachricht der mail setzen.
	 * 
	 * Tipp: Beachten Sie die verschiedenen get-Methoden von Model und mail im Klassendiagramm.
	 * </pre>
	 * 
	 * @param obs
	 * @param obj
	 */
	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		Model model = (Model) obs;
		BasicMail mail;
		// 7

	}

	/**
	 * <pre>
	 * - Falls Quelle des Ereignisses gleich Check-Box Vorschau:
	 *   - Falls Check-Box Vorschau isSelected():
	 *     - buildMails() des Controllers aufrufen.
	 *     - enabled() mit true aufrufen.
	 *   - Sonst:
	 *     - notifyObservers() des Controllers aufrufen.
	 *     - enabled() mit false aufrufen.
	 * - Falls Quelle des Ereignisses gleich Send-Button:
	 *   - sendMail() des Controllers aufrufen.
	 * - Falls Quelle des Ereignisses gleich Send-All-Button:
	 *   - sendAllMails() des Controllers aufrufen.
	 * </pre>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		trace.eventCall();
		// 11

	}

	private void enabled(boolean b) {
		btSend.setEnabled(b);
		btSendAll.setEnabled(b);

		tfEmpfaenger.setEditable(!b);
		tfBetreff.setEditable(!b);

		taNachricht.setEditable(!b);
		taNachricht.setBackground(tfEmpfaenger.getBackground());
	}

}
