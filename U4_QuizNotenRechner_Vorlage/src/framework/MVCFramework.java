package framework;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import gui.Controller;
import gui.View;
import model.Model;
import util.Observer;
import util.TraceV3;

public class MVCFramework extends JFrame {
	private TraceV3 trace = new TraceV3(this);
	private static final long serialVersionUID = 1L;
	Model model = new Model();
	Controller controller = new Controller(model);
	View view = new View(controller);

	public MVCFramework() {
		trace.constructorCall();
		controller.setView(view);
		model.addObserver((Observer) view);
		trace.registerObserver(model, view);
		add(view, BorderLayout.CENTER);
		TraceV3.eventScrollPane.setPreferredSize(new Dimension(-1, 200));
		add(TraceV3.eventScrollPane, BorderLayout.SOUTH);
		SwingUtilities.updateComponentTreeUI(this);
		pack();
		setMinimumSize(getPreferredSize());
		setResizable(true);
		setLocationRelativeTo(null);
	}

	public static void main(String args[]) {
		TraceV3.mainCall(true, true, true);
		MVCFramework demo = new MVCFramework();
		demo.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		demo.setVisible(true);
		demo.setTitle("MVCFramework");
	}
}
