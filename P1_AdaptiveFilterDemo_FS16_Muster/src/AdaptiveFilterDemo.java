import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class AdaptiveFilterDemo extends JFrame {
	private static final long serialVersionUID = 1L;
	private Model model = new Model();
	private Controller controller = new Controller(model);
	private View view = new View(controller);
	private Image icon = Utility.loadResourceImage("Icon.png");

	public void init() {
		setIconImage(icon);
		controller.setView(view);
		model.addObserver(view);
		getContentPane().add(view);
		controller.setParameter();
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AdaptiveFilterDemo demo = new AdaptiveFilterDemo();
				demo.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
				demo.setTitle("Adaptive - Filter Demo");
				demo.init();
				demo.pack();
				demo.setMinimumSize(demo.getPreferredSize());
				demo.setVisible(true);
			}
		});
	}
}
