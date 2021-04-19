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
		setLayout(null);
		setPreferredSize(new Dimension(300, 300));
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
		g.drawImage(bild, 0, 0, getWidth(), getHeight(), null);
	}

}

public class InstrumentenPanel extends JPanel implements ActionListener {

	private JButton btcl = new JButton("Klarinette");
	private JButton btvl = new JButton("Geige");
	private JButton btpn = new JButton("Piano");
	public JTextField tfAusgabe = new JTextField(10);
	public BildPanel bildPanel = new BildPanel();

	private MusikBox mBox = new MusikBox();
	private Klarinette cl = new Klarinette();
	private Geige vl = new Geige();
	private Klavier bn = new Klavier();

	/**
	 * <pre>
	 * - Baut GUI nach Skizze im GridbagLayout und registrier allfaellige Listener
	 * </pre>
	 */
	public InstrumentenPanel() {
		setLayout(new GridBagLayout());
		add(btcl, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 10, 10), 0, 0));
		add(btvl, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 10, 10), 0, 0));
		add(btpn, new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 10, 10), 0, 0));
		add(tfAusgabe, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.EAST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(bildPanel, new GridBagConstraints(1, 1, 1, 3, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));
		
		btcl.addActionListener(this);
		btvl.addActionListener(this);
		btpn.addActionListener(this);
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
		if (e.getSource() == btcl) {
			mBox.spieleMusik(cl,tfAusgabe , bildPanel);
		}
		
		if (e.getSource() == btvl) {
			mBox.spieleMusik(vl,tfAusgabe , bildPanel);
		}
		if (e.getSource() == btpn) {
			mBox.spieleMusik(bn, tfAusgabe, bildPanel);
		}
		repaint();
	}
}
