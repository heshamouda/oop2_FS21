package inversmodel;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import inversmodel.gui.View;
import resources.Utility;

public class InverseModelDemo extends JFrame {
	private static final long serialVersionUID = 1L;
	public static final int appWidth = (int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()*(2.0/3.0));
	public static final int appHeight = (int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight()*(2.0/3.0));
	
	private Image icon = Utility.loadResourceImage("Icon.png");
	private View view = new View();

	public InverseModelDemo() {
		getContentPane().add(view);
		pack();
		setTitle("Inverse - System Demo");
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
		view.startSignalQuelle();
	}

	public static void main(String args[]) {	
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				InverseModelDemo demo = new InverseModelDemo();
				demo.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
			}
		});
	}
}
