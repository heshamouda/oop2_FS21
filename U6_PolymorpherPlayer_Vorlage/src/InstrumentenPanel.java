import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
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
		g.drawImage(bild, 0, 0, BildPanel.WIDTH, BildPanel.HEIGHT, null);
		repaint();
	}

}

public class InstrumentenPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private static final Insets insets = new Insets(10, 10, 10, 10);
	private JButton btcl = new JButton("Klarinette");
	private JButton btvl = new JButton("Geige ");

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
		
		setLayout(new GridBagLayout());
	 
		add(btcl, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, insets, 0, 0));
		btcl.addActionListener(this);
		
		add(tfAusgabe, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, insets, 0, 0));
		
		
		add(btvl, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.FIRST_LINE_START, GridBagConstraints.NONE, insets, 0, 0));
		btvl.addActionListener(this);
		
		add(bildPanel, new GridBagConstraints(1, 1, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH, insets, 0, 0));

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
		if (e.equals(btcl)) {
			mBox.spieleMusik(cl, tfAusgabe, bildPanel); 	
		}
		
		if (e.equals(btvl)) {
			mBox.spieleMusik(vl, tfAusgabe, bildPanel); 
		}	
		
		repaint();
	}

}
