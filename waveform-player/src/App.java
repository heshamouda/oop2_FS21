import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class App {

	public static void main(String[] args) throws Exception {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		final View view = new View();

		JFrame frame = new JFrame("Waveform Player");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		view.setPreferredSize(new Dimension(800, 600));
		view.setDoubleBuffered(true);

		frame.add(view);
		view.init();

		frame.pack();
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);

		view.setFocusable(true);
		view.requestFocus();

	}
}
