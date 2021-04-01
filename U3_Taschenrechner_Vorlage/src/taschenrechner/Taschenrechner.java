package taschenrechner;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import taschenrechner.gui.Controller;
import taschenrechner.gui.View;
import taschenrechner.model.Model;
import util.TraceV4;

public class Taschenrechner extends JFrame {
	TraceV4 trace = new TraceV4(this);
	private static final long serialVersionUID = 1L;

	public Taschenrechner() {
		trace.constructorCall();
		Model model = new Model();
		Controller controller = new Controller(model);
		View view = new View(controller);
		add(view);
		model.addObserver(view);
		trace.registerObserver(model, view);

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
		TraceV4.mainCall(true, true, true);
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
