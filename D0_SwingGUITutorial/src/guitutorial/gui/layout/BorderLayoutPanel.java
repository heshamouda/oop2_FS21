package guitutorial.gui.layout;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import guitutorial.gui.Controller;
import guitutorial.util.MyBorderFactory;

public class BorderLayoutPanel extends JPanel {

	private JPanel panelNord = new JPanel();
	private JPanel panelCenter = new JPanel();
	private JPanel panelSued = new JPanel();
	private JPanel panelOst = new JPanel();
	private JPanel panelWest = new JPanel();

	/**
	 * Erzeugt ein BorderLayoutPanel bla, bla 
	 * @param controller
	 */
	public BorderLayoutPanel(Controller controller) {
		super(new BorderLayout());

		panelNord.setPreferredSize(new Dimension(0, 40));
		panelNord.setBorder(MyBorderFactory.createMyBorder(" Nord "));
		add(panelNord, BorderLayout.NORTH);

		panelCenter.setPreferredSize(new Dimension(400, 400));
		panelCenter.setBorder(MyBorderFactory.createMyBorder(" Zentrum "));
		add(panelCenter, BorderLayout.CENTER);

		panelSued.setPreferredSize(new Dimension(0, 40));
		panelSued.setBorder(MyBorderFactory.createMyBorder(" Süd "));
		add(panelSued, BorderLayout.SOUTH);

		panelOst.setPreferredSize(new Dimension(80, 0));
		panelOst.setBorder(MyBorderFactory.createMyBorder(" Ost "));
		add(panelOst, BorderLayout.EAST);

		panelWest.setPreferredSize(new Dimension(80, 0));
		panelWest.setBorder(MyBorderFactory.createMyBorder(" West "));
		add(panelWest, BorderLayout.WEST);
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				JFrame frame = new JFrame();
				frame.setUndecorated(true);
				frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("TopView");
				frame.getContentPane().add(new BorderLayoutPanel(null));
				frame.pack();
				frame.setMinimumSize(frame.getPreferredSize());
				frame.setVisible(true);
			}
		});
	}
}
