// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
//

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PNEingabe extends JPanel implements ActionListener {
	// 27
	private static final int ORDNUNG = 0, GRENZFREQUENZ = 1, WELLIGKEIT = 2;
	private Controller controller;
	private NumberTextField[] eingabeTextFeld = new NumberTextField[3];
	private JButton jbBerechne = new JButton("Berechnen");
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox jcbTyp = new JComboBox(new String[] { "Butterworth", "Chebyshev" });
	private PNEController pneController = new PNEController();

	/**
	 * <pre>
	 * Aufgabe 1:
	 * - Baut GUI gemäss Layout - Angaben in der Aufgabenstellung. Die Elemente im Array eingabeTextFeld[] werden 
	 *   mittels eingabeTextFeld[ORDNUNG] etc. zugegriffen.
	 *   Hinweis: new NumberTextField(NumberTextField.INTEGER) für Ganzzahl, 
	 *            new NumberTextField(NumberTextField.DOUBLE) für Double - Eingabe.
	 * - Registriert DIESES (engl. this) als Listener bei den entsprechenden Elementen gemäss Klassendiagramm.
	 * Aufgabe 4:
	 * - Setzt das eingabeTextFeld[WELLIGKEIT] auf nicht enabled.
	 * - Setzt den JButton auf nicht enabled.
	 * </pre>
	 * 
	 * @param controller
	 */
	public PNEingabe(Controller controller) {

	}

	/**
	 * <pre>
	 * Aufgabe 1:
	 * - Liesst mittels parseInput() des entsprechenden Textfeldes die Ordnung N, 
	 *   die Grenzfrequenz Fn und die Welligkeit R aus.
	 * - Holt mittels getSelectedIndex() den gewählten typ als Ganzzahl aus der JComboBox.
	 * - Ruft die Methode setFilter() des controller mit (typ, N, 2*pi*Fg, R) auf.
	 * Aufgabe 4:
	 * - Setzt den JButton auf NICHT enabled.
	 * - Setzt typGeaendert des pneController auf unwahr. 
	 * </pre>
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

	}

	class PNEController implements FocusListener, ItemListener {
		private boolean typGeaendert = true;
		// 22
		@Override
		public void focusGained(FocusEvent e) {}

		/**
		 * <pre>
		 * - Falls (istOK() UND istGeaendert())
		 *     - JButton auf enabled setzen.
		 * </pre>
		 * 
		 */
		@Override
		public void focusLost(FocusEvent e) {

		}

		/**
		 * <pre>
		 * - Lokalen boolean geaendert gleich typGeaendert setzen.
		 * - Für i gleich Null bis kleiner Länge des Arrays eingabeTextFeld,
		 *     - Falls das i-te eingabeTextFeld isEnabled(),
		 *         - Lokalen boolean geaendert ODER gleich eingabeTextFeld[i].isChanged() setzen.
		 * - Lokalen boolean geaendert zurück geben. 
		 * </pre>
		 * 
		 * @return
		 */
		private boolean istGeaendert() {

			
			return true; // Um Compiler glücklich zu halten ...
		}

		/**
		 * <pre>
		 * - Lokalen boolean ok gleich wahr setzen.
		 * - Für i gleich Null bis kleiner der Länge des Arrays eingabeTextFeld,
		 *     - Falls das i-te eingabeTextFeld isEnabled(),
		 *         Lokalen boolean ok UND gleich eingabeTextFeld[i].isOK() setzen.
		 * - Lokalen boolean ok zurück geben.
		 * </pre>
		 * 
		 * @return
		 */
		private boolean istOK() {


			return true; // Um Compiler glücklich zu halten ...
		}

		/**
		 * <pre>
		 * - Falls gwählter Index der JComboBox gleich Null,
		 *     - Das eingabeTextFeld[WELLIGKEIT] auf NCIHT enabled setzen,
		 *     - Den Text des eingabeTextFeld[WELLIGKEIT] auf "" setzen.
		 *   sonst,
		 *     - Das eingabeTextFeld[WELLIGKEIT] auf enabled setzen,
		 * - typGeaendert auf wahr setzen.
		 * - Methode focusLost() mit null aufrufen.
		 * </pre>
		 * 
		 */
		@Override
		public void itemStateChanged(ItemEvent e) {

		}
	}
}

