package inversmodel.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import inversmodel.InverseModelDemo;
import resources.Utility;

public class BDGPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Image bild;

	/**
	 * Baut GUI zur Darstellung des Blockdiagrammes ...
	 * 
	 * <pre>
	 * - Setzt die bevorzugte grösse mittels setPreferredSize() auf 50% von 
	 *   InverseModelDemo.appWidth und 40% von InverseModelDemo.appHeight.
	 * - Baut das GUI gemäss Aufgabenstellung.
	 * - Lädt Bild gegeben durch stBildDatei.
	 * </pre>
	 * 
	 * @param stBildDatei
	 *            Bilddatei des Blockdiagramms.
	 */
	public BDGPanel(String stBildDatei) {
		super(null);

		setPreferredSize(
				new Dimension((int) (0.5 * InverseModelDemo.appWidth), (int) (0.4 * InverseModelDemo.appHeight)));

		bild = Utility.loadResourceImage(stBildDatei);
	}

	@Override
	/**
	 * <pre>
	 * - Ruft paintComponent() der Super-Klasse auf.
	 * - Berechnet einen double min als Minimum der (eignene Breite / Breite des Bildes) und
	 *   (eigene Höhe / Höhe des Bildes). Die Divisionen sind in double auszuführen!
	 * - Berechnet eine Ganzzahl bildBreite gleich Breite des Bildes mal min.
	 * - Berechnet eine Ganzzahl bildHoehe gleich Höhe des Bildes mal min.
	 * - Berechnet eine Ganzzahl randOben als (eigene Höhe minus bildHoehe) dividiert durch 2.
	 * - Berechnet eine Ganzzahl randLinks als (eigene Breite minus bildBreite) dividiert durch 2.
	 * - Zeichnet das Bild an entsprechender Stelle mit entsprechender Grösse.
	 * </pre>
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		double min = Math.min((double) (this.getWidth()) / bild.getWidth(this),
				(double) (this.getHeight()) / bild.getHeight(this));

		int bildBreite = (int) (bild.getWidth(this) * min);
		int bildHoehe = (int) (bild.getHeight(this) * min);
		int randLinks = (this.getWidth() - bildBreite) / 2;
		int randOben = (this.getHeight() - bildHoehe) / 2;

		g.drawImage(bild, randLinks, randOben, bildBreite, bildHoehe, this);
	}

}
