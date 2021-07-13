package bikeometer;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import bikeometer.gui.Controller;
import bikeometer.gui.MenuBar;
import bikeometer.gui.TopView;
import bikeometer.model.Model;
import bikeometer.tools.Utility;

public class BikeOMeter extends JFrame {
	private static final long serialVersionUID = 7529693236378777836L;
	private static Image icon = Utility.loadResourceImage("bike0.png");
	public static final int appWidth = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * (2.0 / 3.0));
	public static final int appHeight = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * (2.0 / 3.0));

	public BikeOMeter() {
		Model model = new Model();
		Controller controller = new Controller(model);
		TopView viewPanel = new TopView(model, controller);
		controller.setTopView(viewPanel);
		MenuBar menuBar = new MenuBar(controller);
		setJMenuBar(menuBar);
		controller.loadKMLDatei("Test1_intervall_05_0.kml", 6.0);
		model.addObserver(viewPanel);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(viewPanel, BorderLayout.CENTER);
		pack();
		setMinimumSize(getPreferredSize());
		setResizable(true);
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
		model.notifyObservers();
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				BikeOMeter frame = new BikeOMeter();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("E-Bike-O-Meter");
				frame.setIconImage(icon);
			}
		});
	}
}
