import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

class BildPanel extends JPanel {

	public Image bild = Utility.loadResourceImage("musik.jpg", 300, 300);

	/**
	 * <pre>
	 * - setzt Null Layout
	 * - setzt preferredSize auf 300 x 300 Pixel
	 * </pre>
	 */
	public BildPanel() {
		

	}

	/**
	 * <pre>
	 * - zeichnet bild an Stelle 0,0, mit Breite und Hoehe des Panels und ImageObserver Null
	 * </pre>
	 */
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		

	}

}

public class InstrumentenPanel extends JPanel implements ActionListener {

	private JButton btcl = new JButton("Klarinette");
	private JButton btvl = new JButton("Geige");

	public JTextField tfAusgabe = new JTextField(10);
	public BildPanel bildPanel = new BildPanel();

	private MusikBox mBox = new MusikBox();
	private Klarinette cl = new Klarinette();
	private Geige vl = new Geige();

	/**
	 * <pre>
	 * - Baut GUI nach Skizze im GridbagLayout und registrier allfaellige Listener
	 * </pre>
	 */
	public InstrumentenPanel() {
		

	}

	/**
	 * <pre>
	 * - ruft je nach Event die passende spieleMusik Methode der MusikBox auf
	 * - loest Neuzeichnen aus
	 * </pre>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		
	}

}
