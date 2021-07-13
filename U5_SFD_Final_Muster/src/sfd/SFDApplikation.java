package sfd;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import sfd.gui.Controller;
import sfd.gui.View;
import sfd.model.Model;
import util.TraceV8;

public class SFDApplikation extends JFrame {
	private TraceV8 trace = new TraceV8(this);
	private static final long serialVersionUID = 1L;

	public SFDApplikation() {
		trace.constructorCall();
		Model model = new Model(0, 1e4, 1000);
		Controller controller = new Controller(model);
		View view = new View(controller);
		MeineMenuBar menuBar = new MeineMenuBar(controller);
		controller.setView(view);

		model.addObserver(view);
		trace.registerObserver(model, view);
		setJMenuBar(menuBar);

		add(view);
		add(TraceV8.eventScrollPane, BorderLayout.SOUTH);
		pack();

		// Center the window
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
//		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		setMinimumSize(getPreferredSize());
		System.out.println(getPreferredSize());
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
				SFDApplikation frame = new SFDApplikation();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("SFD - Applikation");
				frame.setVisible(true);
			}
		});
	}
}
