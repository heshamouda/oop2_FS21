import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class GridBagLayoutPanel extends JPanel {

	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();
	
//
	public GridBagLayoutPanel() {
		//super(new GridBagLayout());
		setLayout(new GridBagLayout());

		panel1.setPreferredSize(new Dimension(400, 160));
		panel1.setBorder(MyBorderFactory.createMyBorder(" Panel 1 "));
		panel2.setPreferredSize(new Dimension(200, 100));
		panel2.setBorder(MyBorderFactory.createMyBorder(" Panel 2 "));
		panel3.setPreferredSize(new Dimension(300, 100));
		panel3.setBorder(MyBorderFactory.createMyBorder(" Panel 3 "));

		add(panel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(50,50,50,50), 0, 0));

		add(panel2, new GridBagConstraints(1, 0, 1, 1, 0.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(10, 10, 10, 10), 0, 0));

		add(panel3, new GridBagConstraints(0, 1, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));

		

		

		//		Hinzufügen einer Komponente:
		//			add(component, new GridBagConstraints( x, y, x-span, y-span, x-weight, y-weight, 
		//			anchor, fill,  new Insets(top, left, bottom, right), internal_padding_x, internal_padding_y));
		//
		//			Bedeutung der Parameter:
		//			x, y:				Geben die Position der ersten zugehörigen Zelle an.
		//			x-span, y-span:		Geben Weite und Höhe des Raums für die KOMPONENTE in Anzahl Zellen in x-Richtung und y – Richtung an.
		//			x-weight, y-weight:	Geben an wie die ZELLEN in x resp. y - Richtung wachsen soll.
		//			anchor:				Gibt den Ankerpunkt der KOMPONENTE an. 
		//								Tritt nur in Erscheinung wenn Komponenten kleiner als Zelle ist oder nicht mit der Zelle wächst!
		//			fill:				Gibt an, wie die KOMPONENTE sich an die zugehörigen Zellen anpassen soll.
		//			new Insets(top, left, bottom, right):	Gibt den zusätzlichen Raum ausserhalb der KOMPONENTE an. 
		//			internal_padding_x, internal_padding_y: Gibt den zusätzlichen Raum innerhalb der Komponenten an.
		//
		//			Mögliche Werte für anchor:
		//			FIRST_LINE_START 		PAGE_START 	FIRST_LINE_END 
		//			LINE_START 		CENTER 	LINE_END 
		//			LAST_LINE_START 		PAGE_END 	LAST_LINE_END 
		//
		//			Mögliche Werte für fill:
		//			NONE	VERTICAL		HORIZONTAL	BOTH

	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
//				
				JFrame frame = new JFrame();
				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("TopView");
				frame.add(new GridBagLayoutPanel());
				frame.pack();
				frame.setMinimumSize(frame.getPreferredSize());
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

}
