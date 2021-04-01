
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
//

import java.awt.Graphics;
import java.awt.Image;

public class Pacman extends AnimObjekt {
	Trace trace = new Trace(this, true);
	// 20
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
		super(spalte, zeile, groesse, labyrinth, "pacman_0.gif");
		trace.constructorCall();


//		for (int i = 0; i < bild.length; i++) {
//			bild[i] = Utility.loadResourceImage("pacman_" + i + ".gif", groesse, groesse);
//		}

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
		trace.methodeCall();
		// 1

//		if (vx > 0) {
//			super.bild = bild[0];
//		}
//		if (vy < 0) {
//			super.bild = bild[1];
//		}
//		if (vx < 0) {
//			super.bild = bild[2];
//		}
//		if (vy > 0) {
//			super.bild = bild[3];
//		}

		super.anzeigen(g);
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
		trace.methodeCall();
		// 18
		super.update();
		if (ueberFeld()) {

			if (neueRichtung == UP && labyrinth[zeile - 1][spalte] == 0) {
				vx = 0;
				vy = -v;
			}
			if (neueRichtung == DOWN && labyrinth[zeile + 1][spalte] == 0) {
				vx = 0;
				vy = v;
			}
			if (neueRichtung == LEFT && labyrinth[zeile][spalte - 1] == 0) {
				vx = -v;
				vy = 0;
			}
			if (neueRichtung == RIGHT && labyrinth[zeile][spalte + 1] == 0) {
				vx = v;
				vy = 0;
			}

			if ((vy < 0 && labyrinth[zeile - 1][spalte] != 0) || (vy > 0 && labyrinth[zeile + 1][spalte] != 0)
					|| (vx < 0 && labyrinth[zeile][spalte - 1] != 0) || (vx > 0 && labyrinth[zeile][spalte + 1] != 0)) {
				vx = 0;
				vy = 0;
			}
			neueRichtung = NONE;
		}
	}

	public void setNeueRichtung(int neueRichtung) {
		trace.methodeCall();
		this.neueRichtung = neueRichtung;
	}
}
