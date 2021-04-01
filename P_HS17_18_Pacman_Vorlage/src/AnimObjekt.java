
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
//

public class AnimObjekt {
	// 10 + 1
	protected int vx = 0, vy = 0;
	protected int zeile = -1, spalte = -1;
	protected int v = 4;
	protected int[][] labyrinth;

	public AnimObjekt() {
	}

	/**
	 * <pre>
	 * - Entsprechenden Konstruktor der Super-Klasse mit (x,y)-Position gleich
	 *   (spalte * groesse, zeile * groesse), Groesse groesse und Zeichenkette
	 *   bildDatei aufrufen.
	 * - Entsprechendes Attribut setzen.
	 * </pre>
	 * 
	 * @param spalte
	 * @param zeile
	 * @param groesse
	 * @param bildDatei
	 */
	public AnimObjekt(int spalte, int zeile, int groesse, int[][] labyrinth, String bildDatei) {
		// 2
	}

	/**
	 * <pre>
	 * - Wenn der Abstand der (x,y)-Positionen der beiden Figuren kleiner als die 
	 *   halbe Groesse groesse ist:
	 *   - true zurück geben.
	 * - false zurück geben.
	 * </pre>
	 * 
	 * @param figur
	 * @return
	 */
	public boolean kollisionTesten(AnimObjekt figur) {
		// 3
		return false;
	}

	/**
	 * <pre>
	 * - zeile = spalte = -1 setzen.
	 * - Falls x Modulo groesse kleiner v UND y Modulo groesse kleiner v:
	 *   - splate gleich x durch groesse.
	 *   - zeile gleich y durch groesse.
	 *   - true zurueck geben.
	 * - false zurueck geben.
	 * </pre>
	 * 
	 * @return
	 */
	public boolean ueberFeld() {
		// 6
		return false;
	}

	public void update() {
		// x += vx;
		// y += vy;
	}
}
