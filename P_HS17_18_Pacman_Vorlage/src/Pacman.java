
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
//

import java.awt.Graphics;
import java.awt.Image;

public class Pacman {
	// 20 + 1
	public static final int NONE = 0, UP = 1, DOWN = 2, LEFT = 3, RIGHT = 4;
	protected int neueRichtung = NONE;
	protected Image[] bild = new Image[4];

	/**
	 * 
	 * <pre>
	 * Teil I
	 * - Ruft den geeigneten Konstruktor der Superklasse mit den entsprechenden 
	 *   Argumenten und "pacman_0.gif" auf.
	 * Challenge League:
	 * - Do what ever it takes ...
	 * </pre>
	 * 
	 * 
	 * @param spalte
	 * @param zeile
	 * @param groesse
	 * @param labyrinth
	 */
	public Pacman(int spalte, int zeile, int groesse, int[][] labyrinth) {
		// 1

	}

	/**
	 * <pre>
	 * Challenge League:
	 * - Do what ever it takes ...
	 * Teil I:
	 * - Ruft anzeigen() der Superklasse auf.
	 * </pre>
	 * 
	 * @param g
	 */
	public void anzeigen(Graphics g) {
		// 1
	}

	/**
	 * <pre>
	 * - Ruft Methode update() der Super-Klasse auf.
	 * - Falls ueberFeld():
	 *   - Fuer jede neueRichtung (UP, DOWN, LEFT, RIGHT) ueberpruefen ob die 
	 *     die entsprechende Zelle im Labyrinth gleich 0 ist. Wenn die Zelle 0 ist,
	 *     werden die Elemente des Geschwindigkeitsvektor (vx,vy) entsprechend der Richtung auf plus oder minus
	 *     v gesetzt.
	 *   - Ueberpruefen, ob der Pacman auflaeuft:
	 *     Wenn ((vy kleiner 0 UND Zelle in die Richtung nicht 0) ODER (vy groesser 0 UND Zelle in die Richtung nicht 0) 
	 *     ODER  (vx kleiner 0 UND Zelle in die Richtung nicht 0) ODER (vx groesser 0 UND Zelle in die Richtung nicht 0)) 
	 *     dann wird sowohl vx wie auch vy gleich 0 gesetz. 
	 *   - Die neue Richtung wird auf NONE gesetzt.
	 * </pre>
	 * 
	 */
	public void update() {
		// 18
	}

	public void setNeueRichtung(int neueRichtung) {
		this.neueRichtung = neueRichtung;
	}
}
