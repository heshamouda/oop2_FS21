// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: Muster
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
		// 20
		super(new GridBagLayout());
		setBorder(MyBorderFactory.createBorder(" " + getClass().getName() + " "));
		this.controller = controller;

		// x, y, x-span, y-span, x-weight, y-weight, anchor, fill, insets(int top, int left, int bottom, int right), internal padding x, internal padding y. 
		add(new JLabel("Filter - Typ: "), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(jcbTyp, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));
		jcbTyp.addFocusListener(pneController);
		jcbTyp.addItemListener(pneController);

		eingabeTextFeld[ORDNUNG] = new NumberTextField(NumberTextField.INTEGER);
		add(new JLabel("Filterordnung: "), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(eingabeTextFeld[ORDNUNG], new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		eingabeTextFeld[ORDNUNG].addFocusListener(pneController);

		eingabeTextFeld[GRENZFREQUENZ] = new NumberTextField(NumberTextField.DOUBLE);
		add(new JLabel("Grenzfrequenz: "), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(eingabeTextFeld[GRENZFREQUENZ], new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(new JLabel("Hz"), new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		eingabeTextFeld[GRENZFREQUENZ].addFocusListener(pneController);

		eingabeTextFeld[WELLIGKEIT] = new NumberTextField(NumberTextField.DOUBLE);
		add(new JLabel("Welligkeit: "), new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(eingabeTextFeld[WELLIGKEIT], new GridBagConstraints(1, 3, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
		add(new JLabel("dB"), new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		eingabeTextFeld[WELLIGKEIT].addFocusListener(pneController);

		add(jbBerechne, new GridBagConstraints(0, 4, 3, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));
		jbBerechne.addActionListener(this);

		add(Box.createRigidArea(new Dimension(300, 0)), new GridBagConstraints(0, 5, 3, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		eingabeTextFeld[WELLIGKEIT].setEnabled(false);
		jbBerechne.setEnabled(false);

	}

	/**
	 * <pre>
	 * - Liesst mittels parseInput() des entsprechenden Textfeldes die Ordnung N, 
	 *   die Grenzfrequenz Fn und die Welligkeit R aus.
	 * - Holt mittels getSelectedIndex() den gewählten typ als Ganzzahl aus der JComboBox.
	 * - Ruft die Methode setFilter() des controller mit (typ, N, 2*pi*Fg, R) auf.
	 * - Setzt den JButton auf NICHT enabled.
	 * - Setzt typGeaendert des pneController auf unwahr. 
	 * </pre>
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// 9
		int N = (int) eingabeTextFeld[ORDNUNG].parseInput();
		double Fg = eingabeTextFeld[GRENZFREQUENZ].parseInput();
		double R = eingabeTextFeld[WELLIGKEIT].parseInput();
		int typ = jcbTyp.getSelectedIndex();

		controller.setFilter(typ, N, Fg * 2.0 * Math.PI, R);

		jbBerechne.setEnabled(false);
		pneController.typGeaendert = false;
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
			// 4
			if (istOK() && istGeaendert()) {
				jbBerechne.setEnabled(true);
			}
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
			// 5
			boolean geaendert = typGeaendert;
			for (int i = 0; i < eingabeTextFeld.length; i++) {
				if (eingabeTextFeld[i].isEnabled()) {
					geaendert |= eingabeTextFeld[i].isChanged();
				}
			}
			return geaendert;
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
			// 5
			boolean ok = true;
			for (int i = 0; i < eingabeTextFeld.length; i++) {
				if (eingabeTextFeld[i].isEnabled()) {
					ok &= eingabeTextFeld[i].isOK();
				}
			}
			return ok;
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
			// 6
			if (jcbTyp.getSelectedIndex() == 0) {
				eingabeTextFeld[WELLIGKEIT].setEnabled(false);
				eingabeTextFeld[WELLIGKEIT].setText("");
			} else {
				eingabeTextFeld[WELLIGKEIT].setEnabled(true);
			}
			typGeaendert = true;
			focusLost(null);
		}
	}
}
