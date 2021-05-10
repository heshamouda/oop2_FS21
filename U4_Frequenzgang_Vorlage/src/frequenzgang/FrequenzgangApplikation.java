package frequenzgang;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import frequenzgang.gui.Controller;
import frequenzgang.gui.View;
import frequenzgang.model.Model;
import util.TraceV8;

public class FrequenzgangApplikation extends JFrame {
	private TraceV8 trace = new TraceV8(this);
	private boolean packFrame = true;
	private int width, height;

	
	public void init() {
		trace.methodeCall();
		Model model = new Model(0, 10e3, 1000);
		Controller controller = new Controller(model);
		View view = new View(controller);
		controller.setView(view);

		model.addObserver(view);
		trace.registerObserver(model, view);

		add(view);

		if (packFrame) {
			pack();
			width = this.getWidth();
			height = this.getHeight();
		} else {
			setSize(width, height);
			validate();
		}
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
		setMinimumSize(getPreferredSize());
//		view.btOk.doClick();
	}

	public static void main(String args[]) {
		TraceV8.mainCall(true, true, true);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				FrequenzgangApplikation frame = new FrequenzgangApplikation();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Frequenzgang - Applikation");
				frame.init();
				frame.setVisible(true);
			}
		});
	}
}
