
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
//

import java.awt.Graphics;
import java.awt.Image;

public class GrafikObjekt {
	Trace trace = new Trace(this, true);
	// 5
	protected int x, y;
	protected int groesse;
	protected Image bild;

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
		trace.constructorCall();

		// 4
		this.x = x;
		this.y = y;
		this.groesse = groesse;
		bild = Utility.loadResourceImage(bildDatei, groesse, groesse);
	}

	/**
	 * <pre>
	 * - Zeichnet das Bild an entsprechender (x,y)-Position.
	 * </pre>
	 * 
	 * @param g
	 */
	public void anzeigen(Graphics g) {
		trace.methodeCall();
		// 1
		g.drawImage(bild, x, y, null);
	}
}
