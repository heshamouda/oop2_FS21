import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MVCFramework extends JFrame {
	private TraceV8 trace = new TraceV8(this);

	public MVCFramework() {
		trace.constructorCall();
		View view = new View();
		add(view);
		pack();
	}

	public static void main(String args[]) {
		TraceV8.mainCall();
		MVCFramework demo = new MVCFramework();
		demo.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		demo.setVisible(true);
		demo.setTitle("Abstrakte Klassen und Interfaces");
	}
}
