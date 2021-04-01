
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
	Trace trace = new Trace(this, true);
	private static final long serialVersionUID = -3747283994960667384L;
	// 27
	@SuppressWarnings("unused")
	private SimpleTimer timer;
	private JButton btNeu = new JButton("Neues Spiel");
	private JButton btWeiter = new JButton("Weiter ...");
	private JLabel lbScore = new JLabel();
	private JLabel lbLeben = new JLabel();
	private JTextField tfLeben = new JTextField("5");
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private JComboBox cbGeister = new JComboBox(new String[] { "2", "3", "4", "5" });
	public PacmanSpielPanel pacmanSpielPanel;
	private Image imBG = Utility.loadResourceImage("Clyde.png", 350, 500);

	/**
	 * <pre>
	 * - Setzt das null - Layout.
	 * - Setzt mittels setPreferredSize(new Dimension(breite, hoehe)); die bevorzugte Grösse des Panels gemaess Layout in der Aufgabenstellung.
	 * - Setzt die Hintergrundsfarbe auf Schwarz.
	 * - Baut das User-Interface gemaess Aufgabenstellung.
	 * - Ruft doClick() des Neu-Button auf.
	 * - Erzeugt mit: new SimpleTimer(50, this) den Timer timer.
	 * </pre>
	 */
	public TopView() {
		//trace.constructorCall();
		// 19
		setLayout(null);
		setPreferredSize(new Dimension(900, 500));
		setBackground(Color.black);

		pacmanSpielPanel = new PacmanSpielPanel();
		add(pacmanSpielPanel).setBounds(0, 0, 550, 500);

		add(new JLabel("Score:")).setBounds(570, 25, 150, 20);
		add(lbScore).setBounds(720, 25, 150, 20);

		add(new JLabel("Verbleibende Leben: ")).setBounds(570, 50, 150, 20);
		add(lbLeben).setBounds(720, 50, 150, 20);

		add(new JLabel("Anzahl Leben: ")).setBounds(570, 100, 150, 20);
		add(tfLeben).setBounds(720, 100, 75, 20);

		add(new JLabel("Anzahl Geister: ")).setBounds(570, 125, 150, 20);
		add(cbGeister).setBounds(720, 125, 150, 20);

		add(btNeu).setBounds(570, 250, 300, 20);
		btNeu.addActionListener(this);

		add(btWeiter).setBounds(570, 275, 300, 20);
		btWeiter.addActionListener(this);

		btNeu.doClick();

		timer = new SimpleTimer(50, this);
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
		trace.eventCall();
		// 6
		if (e.getSource() == btNeu) {
			int anzahlLeben = Integer.parseInt(tfLeben.getText());
			int anzahlGeister = cbGeister.getSelectedIndex() + 2;
			pacmanSpielPanel.neuesSpiel(anzahlLeben, anzahlGeister);
		}
		if (e.getSource() == btWeiter) {
			pacmanSpielPanel.weiter();
		}
	}

	/**
	 * <pre>
	 * - Methode update() des PacmanGamePanels aufrufen.
	 * - Text in Score-Label entsprechend dem Attribut score im  PacmanGamePanel setzen.
	 * - Text in Leben-Label entsprechend der Attribut anzahlLeben im  PacmanGamePanel setzen.
	 * </pre>
	 */
	public void update() {
		trace.methodeCall();
		// 3
		pacmanSpielPanel.update();
		lbScore.setText(pacmanSpielPanel.score + " Punkte");
		lbLeben.setText(pacmanSpielPanel.anzahlLeben + " Leben");
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
		trace.methodeCall();
		// 2
		super.paintComponent(g);
		g.drawImage(imBG, 550, 0, this);
	}
}
