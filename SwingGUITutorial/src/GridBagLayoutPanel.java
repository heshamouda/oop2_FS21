import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

public class GridBagLayoutPanel extends JPanel {

	private JPanel panel1 = new JPanel();
	private JPanel panel2 = new JPanel();
	private JPanel panel3 = new JPanel();

	public GridBagLayoutPanel(Controller controller) {
		super(new GridBagLayout());

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

		panel1.setPreferredSize(new Dimension(400, 100));
		panel1.setBorder(MyBorderFactory.createMyBorder(" Panel 1 "));
		// x, y, x-span, y-span, x-weight, y-weight, anchor, fill, insets(int top, int left, int bottom, int right), internal padding x, internal padding y. 
		add(panel1, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));

		panel2.setPreferredSize(new Dimension(200, 100));
		panel2.setBorder(MyBorderFactory.createMyBorder(" Panel 2 "));
		// x, y, x-span, y-span, x-weight, y-weight, anchor, fill, insets(int top, int left, int bottom, int right), internal padding x, internal padding y. 
		add(panel2, new GridBagConstraints(1, 0, 1, 1, 0.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(10, 10, 10, 10), 0, 0));

		panel3.setPreferredSize(new Dimension(400, 100));
		panel3.setBorder(MyBorderFactory.createMyBorder(" Panel 3 "));
		// x, y, x-span, y-span, x-weight, y-weight, anchor, fill, insets(int top, int left, int bottom, int right), internal padding x, internal padding y. 
		add(panel3, new GridBagConstraints(0, 1, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 10, 10), 0, 0));

		// x-weight, y-weight: 	Geben an wie die ZELLEN in x resp. y - Richtung wachsen!
		// anchor:				Gibt an, wie die Komponente innerhab der zugehörigen Zellen verankert ist!
		// fill:				Gibt an, wie die KOMPONENTE sich an die zugehörigen Zellen anpasst!

	}

	//	public static void main(String args[]) {
	//		SwingUtilities.invokeLater(new Runnable() {
	//
	//			public void run() {
	//				try {
	//					UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
	//				} catch (Exception exception) {
	//					exception.printStackTrace();
	//				}
	//				JFrame frame = new JFrame();
	//				frame.setUndecorated(true);
	//				frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
	//				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	//				frame.setTitle("TopView");
	//				frame.getContentPane().add(new GridBagLayoutPanel(null));
	//				frame.pack();
	//				frame.setMinimumSize(frame.getPreferredSize());
	//				frame.setVisible(true);
	//			}
	//		});
	//	}

}
