import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class App {

	public static void main(String[] args) {

		Model model = new Model();
		Controller controller = new Controller(model);
		View view = new View(controller);
		model.addObserver(view);
		controller.setView(view);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		JFrame frame = new JFrame("Geoquiz");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		view.setPreferredSize(new Dimension(800, 800));
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
