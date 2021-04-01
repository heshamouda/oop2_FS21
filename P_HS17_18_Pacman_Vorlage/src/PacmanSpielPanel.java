
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: Gut
// Vorname: Richard
//

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class PacmanSpielPanel extends JPanel implements KeyListener {
	// 43
	private static final long serialVersionUID = 1L;

	public GrafikObjekt[][] spielfeld;
	public int groesse;
	public int anzahlLeben;
	public int score;
	private int anzahlGeister;
	private boolean spielStop;
	private Geist[] geist;
	private Pacman pacman;

	/**
	 * <pre>
	 * - Setzt das Attribut groesse entsprechend der Angabe im Layout.
	 * </pre>
	 * 
	 */
	public PacmanSpielPanel() {
		// 1
	}

	/**
	 * <pre>
	 * - Falls Attribut anzahlLeben gleich Null ODER score gleich 420:
	 *   - spielStop gleich true setzen. 
	 *   - Entsprechende Attribute setzen.
	 *   - neuesSpielfeld() mit entsprechendem Argument aufrufen.
	 *   - neueGeister() mit entsprechenden Argumenten aufrufen.
	 *   - neuen Pacman an der Stelle 2,4 mit entsprechenden Argumenten erzeugen.
	 *   - score auf Null setzen.
	 *   - spielStop auf false setzen.
	 * </pre>
	 * 
	 * @param anzahlLeben
	 * @param anzahlGeister
	 */
	public void neuesSpiel(int anzahlLeben, int anzahlGeister) {
		// 9
	}

	/**
	 * <pre>
	 * - Neuen GrafikObjekt-Array spielfeld entsprechend der Grösse von labyrinth erzeugen.
	 * - Für zeile gleich 0 bis kleiner Anzahl Zeilen des Spielfeldes:
	 *   - Für spalte gleich 0 bis kleiner Anzahl Spalten des Spielfeldes:
	 *     - Falls labyrinth an der Stelle (zeile, spalte) gleich 1:
	 *       - spielfeld[zeile][spalte] gleich neues GraphicObjekt an (x,y)-Stelle gegeben durch 
	 *         (spalte * groesse, zeile * groesse) der Groesse groesse und mit Lego-Bild setzen.
	 *     - Sonst:
	 *       - spielfeld[zeile][spalte] gleich neues GraphicObjekt an (x,y)-Stelle gegeben durch 
	 *         (spalte * groesse, zeile * groesse) der Groesse groesse und mit Bier-Bild setzen.
	 * </pre>
	 * 
	 * @param labyrinth
	 */
	private void neuesSpielfeld(int[][] labyrinth) {
		// 7
	}

	/**
	 * <pre>
	 * - Neuen Geist-Array mit Länge anzahlGeister erzeugen.
	 * - Für i gleich 0 bis kleiner der Länge des Arrays:
	 *   - Neuen Geist an der Stelle (4,5) entsprechender Groesse groesse erzeugen und als i-tes Element im Array ablegen.
	 * </pre>
	 * 
	 * @param anzahlGeister
	 * @param labyrinth
	 */
	private void neueGeister(int anzahlGeister, int[][] labyrinth) {
		// 3
	}

	@Override
	/**
	 * <pre>
	 * - paintComponent() der Superklasse aufrufen.
	 * - Alle Elemente des Spielfeldes die ungleich null sind anzeigen.
	 * - Alle Geister Anzeigen.
	 * - Den Pacman anzeigen.
	 * </pre>
	 * 
	 * @param g
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// 8
	}

	/**
	 * <pre>
	 * - Falls anzahlLeben nicht gleich 0 UND spielStop:
	 *   - Neue Geister mittels neueGeister() mit entsprechender Anzahl Geister und dem Labyrinth labyrinth erzeugen.
	 *   - spielStop gleich false setzen.
	 * </pre>
	 * 
	 */
	public void weiter() {
		// 3
	}

	/**
	 * <pre>
	 * - Falls spielStop:
	 *   - Methode wieder verlassen.
	 * - Methode update() des Pacmans aufrufen.
	 * - Falls Methode ueberFeld() des Pacmans true UND Spielfeld an der Stelle (zeile, spalte) an der sich der Pacman
	 *   befindet nicht gleich null:
	 *   - Entsprechende Stelle im Spielfeld gleich null setzen.
	 *   - score um 10 erhöhen.
	 * - Für jeden Geist:
	 *   - Methode update() des Geistes aufrufen.
	 *   - Falls Kollision zwischen Pacman und Geist:
	 *     - spielStop gleich true setzen.
	 * - Neuzeichnen ausloesen.
	 * </pre>
	 * 
	 */
	public void update() {
		// 12
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			pacman.setNeueRichtung(Pacman.UP);
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			pacman.setNeueRichtung(Pacman.DOWN);
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			pacman.setNeueRichtung(Pacman.LEFT);
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			pacman.setNeueRichtung(Pacman.RIGHT);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public int[][] labyrinth = { { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1 },
			{ 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1 }, { 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
			{ 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

}