package modem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import modem.gui.Controller;
import modem.gui.View;
import modem.gui.goodies.StatusBar;
import modem.model.Model;
import resources.Utility;

public class AdaptiveModemDemo extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int appWidth = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * (3.0 / 4.0));
	public static final int appHeight = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * (3.0 / 4.0));
	private Image icon = Utility.loadResourceImage("Icon.png");
	private Model model = new Model();
	private Controller controller = new Controller(model);
	private View view = new View(controller);

	public AdaptiveModemDemo() {
		getContentPane().add(view, BorderLayout.CENTER);
		getContentPane().add(new StatusBar(), BorderLayout.SOUTH);
		controller.setView(view);
		model.addObserver(view);
		controller.setParameter();

//		DPIFixV3.scaleSwingFonts();
//		SwingUtilities.updateComponentTreeUI(this);

		pack();

		setTitle("Modem Demo");
		setIconImage(icon);
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
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				AdaptiveModemDemo demo = new AdaptiveModemDemo();
				demo.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
			}
		});
	}
}
