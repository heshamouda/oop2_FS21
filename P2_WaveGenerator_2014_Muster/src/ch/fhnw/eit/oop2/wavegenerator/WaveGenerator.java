package ch.fhnw.eit.oop2.wavegenerator;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import ch.fhnw.eit.oop2.wavegenerator.gui.Controller;
import ch.fhnw.eit.oop2.wavegenerator.gui.View;
import ch.fhnw.eit.oop2.wavegenerator.model.Model;
import ch.fhnw.eit.oop2.wavegenerator.tools.Utility;

public class WaveGenerator extends JFrame {
	private static final long serialVersionUID = 1L;
	private Model model = new Model();
	private Controller controller = new Controller(model);
	private View view = new View(controller, model);

	public void init() {
		controller.setView(view);
		model.addObserver(view);
		add(view);

		pack();
		setMinimumSize(getPreferredSize());
		model.notifyObservers();

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
	}

	public static void main(String args[]) {
		WaveGenerator frame = new WaveGenerator();
		frame.setIconImage(Utility.loadResourceImage("aicon.jpg"));
		frame.setTitle("Funktionsgenerator");
		frame.init();
		frame.setVisible(true);
	}
}
