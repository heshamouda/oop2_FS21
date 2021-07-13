package multimeter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import multimeter.gui.Controller;
import multimeter.gui.MenuBar;
import multimeter.gui.View;
import multimeter.model.Model;

public class MultimeterApplikation extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int appWidth = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * (2.0 / 3.0));
	public static final int appHeight = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * (0.35));

	private Model model = new Model();
	private Controller controller = new Controller(model);
	private View view = new View(controller);
	private MenuBar menuBar = new MenuBar(controller);

	public MultimeterApplikation() {
		controller.setView(view);
		model.addObserver(view);
		getContentPane().add(view, BorderLayout.CENTER);
		model.notifyObservers();
		setJMenuBar(menuBar);
		setTitle("Digitales Multimeter");
		pack();
		// setIconImage(icon);
		setMinimumSize(getPreferredSize());
		// Zentrieren:
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		setVisible(true);
		model.start();
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				MultimeterApplikation demo = new MultimeterApplikation();
				demo.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
			}
		});
	}
}
