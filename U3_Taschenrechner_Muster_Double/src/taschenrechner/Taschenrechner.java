package taschenrechner;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import taschenrechner.gui.Controller;
import taschenrechner.gui.View;
import taschenrechner.model.Model;
import util.TraceV5;

public class Taschenrechner extends JFrame {
	private TraceV5 trace = new TraceV5(this);
	private static final long serialVersionUID = 1L;
	private Model model = new Model();
	private Controller controller = new Controller(model);
	private View view = new View(controller);

	public Taschenrechner() {
		trace.constructorCall();
		model.addObserver(view);
		trace.registerObserver(model, view);
		getContentPane().add(view);

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
	}

	public static void main(String args[]) {
		TraceV5.mainCall(true, true, true);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Taschenrechner frame = new Taschenrechner();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("UPN Taschenrechner");
				frame.pack();
				frame.setMinimumSize(frame.getPreferredSize());
				frame.setVisible(true);
			}
		});
	}
}
