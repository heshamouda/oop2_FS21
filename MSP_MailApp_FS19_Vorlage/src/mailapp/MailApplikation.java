package mailapp;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import mailapp.gui.MenuBar;
import mailapp.gui.Controller;
import mailapp.gui.View;
import mailapp.model.Model;
import util.TraceV7;
import util.Utility;

public class MailApplikation extends JFrame {
	private TraceV7 trace = new TraceV7(this);
	private static final long serialVersionUID = 1L;
	public static final int appWidth = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * (2.0 / 3.0));
	public static final int appHeight = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * (2.0 / 3.0));

	private Model model = new Model();
	private Controller controller = new Controller(model);
	private View view = new View(controller);
	private MenuBar menuBar = new MenuBar(this);

	public MailApplikation() {
		trace.constructorCall();

		controller.setView(view);
		model.addObserver(view);
		trace.registerObserver(model, view);
		getContentPane().add(view);
		setJMenuBar(menuBar);

		setPreferredSize(
				new Dimension((int) (0.6 * MailApplikation.appWidth), (int) (1.0 * MailApplikation.appHeight)));
		setMinimumSize(getPreferredSize());

		// Center the window
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		setIconImage(Utility.loadResourceImage("MailIcon.png"));
	}

	public static void main(String args[]) {
		TraceV7.mainCall(true, true, true);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MailApplikation frame = new MailApplikation();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Mail - Applikation");
				frame.setVisible(true);
			}
		});
	}
}
