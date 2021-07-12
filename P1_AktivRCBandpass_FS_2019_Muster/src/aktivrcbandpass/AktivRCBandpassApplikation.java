package aktivrcbandpass;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import aktivrcbandpass.gui.Controller;
import aktivrcbandpass.gui.View;
import aktivrcbandpass.model.Model;
import util.TraceV7;

public class AktivRCBandpassApplikation extends JFrame {
	private TraceV7 trace = new TraceV7(this);
	private static final long serialVersionUID = 1L;
	public static final int appWidth = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * (2.0 / 3.0));
	public static final int appHeight = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * (2.0 / 3.0));

	private Model model = new Model();
	private Controller controller = new Controller(model);
	private View view = new View(controller);

	public AktivRCBandpassApplikation() {
		trace.constructorCall();

		controller.setView(view);
		model.addObserver(view);
		trace.registerObserver(model, view);

		add(view);
		setPreferredSize(new Dimension((int) (0.6 * AktivRCBandpassApplikation.appWidth),
				(int) (1.0 * AktivRCBandpassApplikation.appHeight)));
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
		// First update ...
		controller.aktion("R");

//		System.out.println(getSize());
	}

	public static void main(String args[]) {
		TraceV7.mainCall(true, true, true);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				AktivRCBandpassApplikation frame = new AktivRCBandpassApplikation();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Frequenzgang - Applikation");
				frame.setVisible(true);
			}
		});
	}
}
