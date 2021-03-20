import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class App {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		JFrame frame = new JFrame("Java Application");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final MainPanel panel = new MainPanel();
		panel.setPreferredSize(new Dimension(800, 600));
		panel.setDoubleBuffered(true);
		frame.add(panel);
		panel.init();

		frame.pack();
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);

		
		panel.setFocusable(true);
		panel.requestFocus();

	}
}
