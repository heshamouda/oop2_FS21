package soundeditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import soundeditor.gui.Controller;
import soundeditor.gui.MenuBar;
import soundeditor.gui.View;
import soundeditor.model.Model;
import tools.Utility;

public class SoundEditor extends JFrame {
	private static final long serialVersionUID = 7529693236378777836L;
	private static Image icon = Utility.loadResourceImage("icon.png");
	private Model model = new Model();
	private Controller controller = new Controller(model);
	private View view = new View(controller);

	public SoundEditor() {
		controller.setView(view);
		model.addObserver(view);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(view, BorderLayout.CENTER);
		MenuBar menuBar = new MenuBar(controller);
		setJMenuBar(menuBar);
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
		model.notifyObservers();
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SoundEditor frame = new SoundEditor();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Simple Sound Editor");
				frame.setIconImage(icon);
				frame.setVisible(true);
			}
		});
	}
}
