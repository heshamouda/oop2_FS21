
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
//

import java.awt.Graphics;
import java.awt.Image;

public class GrafikObjekt {
	// 5
	protected int x, y;
	protected int groesse;
	protected Image bild;

	public GrafikObjekt() {
	}

	/**
	 * <pre>
	 * - Setzt die entsprechenden Attribute.
	 * - Laedt das Bild gegeben durch die Bild-Datei mit entsprechender Groesse.
	 * </pre>
	 * 
	 * @param x
	 * @param y
	 * @param groesse
	 * @param bildDatei
	 */
	public GrafikObjekt(int x, int y, int groesse, String bildDatei) {
		// 4
	}

	/**
	 * <pre>
	 * - Zeichnet das Bild an entsprechender (x,y)-Position.
	 * </pre>
	 * 
	 * @param g
	 */
	public void anzeigen(Graphics g) {
		// 1
	}
}
