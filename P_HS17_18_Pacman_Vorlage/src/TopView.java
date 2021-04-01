
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
//

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TopView extends JPanel implements ActionListener, SimpleTimerListener {
	private static final long serialVersionUID = -3747283994960667384L;
	// 27 + 3
	@SuppressWarnings("unused")
	private SimpleTimer timer;
	private JLabel lbScore = new JLabel();
	private JLabel lbLeben = new JLabel();
	private JTextField tfLeben = new JTextField("5");

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox cbGeister = new JComboBox(new String[] { "2", "3", "4", "5" });
	public PacmanSpielPanel pacmanSpielPanel;
	private Image imBG;

	/**
	 * <pre>
	 * - Setzt das null - Layout.
	 * - Setzt mittels setPreferredSize(new Dimension(breite, hoehe)); die bevorzugte Grösse des Panels gemaess Layout in der Aufgabenstellung.
	 * - Setzt die Hintergrundsfarbe auf Schwarz.
	 * - Laedt das Bild Clyde.png mit im Layout gegebener Groesse.
	 * - Baut das User-Interface gemaess Aufgabenstellung.
	 * - Ruft doClick() des Neu-Button auf.
	 * - Erzeugt mit: new SimpleTimer(50, this) den Timer timer.
	 * </pre>
	 */
	public TopView() {
		// 19
	}

	/**
	 * <pre>
	 * - Falls Quelle des Ereignisses gleich Neu-Button
	 *     - Information bezueglich Anzahl-Leben, Anzahl-Geister und Layout-Typ auslesen und in eine Ganz-
	 *       zahl in lokale Variable ablegen. 
	 *     - Methode neuesSpiel() des PacmanGamePanel mit den entsprechenden Argumenten aufrufen.
	 * - Falls Quelle des Ereignisses gleich Weiter-Button
	 *     - Methode weiter() des PacmanGamePanel aufrufen.
	 * </pre>
	 */
	public void actionPerformed(ActionEvent e) {
		// 6
	}

	/**
	 * <pre>
	 * - Methode update() des PacmanGamePanels aufrufen.
	 * - Text in Score-Label entsprechend dem Attribut score im  PacmanGamePanel setzen.
	 * - Text in Leben-Label entsprechend der Attribut anzahlLeben im  PacmanGamePanel setzen.
	 * </pre>
	 */
	public void update() {
		// 3
	}

	@Override
	/**
	 * <pre>
	 * - Ruft  paintComponent() der Superklasse auf.
	 * - Zeichnet das Bild imBG an der Stelle gegeben durch
	 * </pre>
	 * 
	 * @param g
	 */
	public void paintComponent(Graphics g) {
		// 2
		super.paintComponent(g);
	}
}
