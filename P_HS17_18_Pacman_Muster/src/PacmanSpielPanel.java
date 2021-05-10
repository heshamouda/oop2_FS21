
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
//

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class PacmanSpielPanel extends JPanel implements KeyListener {
	// 43
	Trace trace = new Trace(this, true);
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
		trace.constructorCall();
		// 1
		groesse = 50;
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
		trace.methodeCall();
		// 9
		if (this.anzahlLeben == 0 || score == 420) {
			spielStop = true;
			this.anzahlLeben = anzahlLeben;
			this.anzahlGeister = anzahlGeister;

			neuesSpielfeld(labyrinth);
			neueGeister(anzahlGeister, labyrinth);
			pacman = new Pacman(2, 4, groesse, labyrinth);
			score = 0;
			spielStop = false;
		}
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
		trace.methodeCall();
		// 7
		spielfeld = new GrafikObjekt[labyrinth.length][labyrinth[0].length];
		for (int zeile = 0; zeile < spielfeld.length; zeile++) {
			for (int spalte = 0; spalte < spielfeld[0].length; spalte++) {
				if (labyrinth[zeile][spalte] == 1) {
					spielfeld[zeile][spalte] = new GrafikObjekt(spalte * groesse, zeile * groesse, groesse, "Lego.png");
				} else {
					spielfeld[zeile][spalte] = new GrafikObjekt(spalte * groesse, zeile * groesse, groesse, "Bier.png");
				}
			}
		}
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
		trace.methodeCall();
		// 3
		geist = new Geist[anzahlGeister];
		for (int i = 0; i < geist.length; i++) {
			geist[i] = new Geist(4, 5, groesse, labyrinth);
		}
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
		trace.methodeCall();
		Utility.setHighRenderQuality(g);
		super.paintComponent(g);
		// 8
		for (int zeile = 0; zeile < spielfeld.length; zeile++) {
			for (int spalte = 0; spalte < spielfeld[0].length; spalte++) {
				if (spielfeld[zeile][spalte] != null)
					spielfeld[zeile][spalte].anzeigen(g);
			}
		}
		for (int i = 0; i < geist.length; i++) {
			geist[i].anzeigen(g);
		}
		pacman.anzeigen(g);
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
		trace.methodeCall();
		// 3
		if (anzahlLeben != 0 && spielStop) {
			neueGeister(anzahlGeister, labyrinth);
			spielStop = false;
		}
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
		trace.methodeCall();
		// 12
		if (spielStop) {
			return;
		}
		pacman.update();
		if (pacman.ueberFeld() && spielfeld[pacman.zeile][pacman.spalte] != null) {
			spielfeld[pacman.zeile][pacman.spalte] = null;
			score += 10;
		}
		for (int i = 0; i < geist.length; i++) {
			geist[i].update();
			if (pacman.kollisionTesten(geist[i])) {
				spielStop = true;
				anzahlLeben--;
			}
		}
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		trace.methodeCall();
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