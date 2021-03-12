import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MVCFramework extends JFrame {
	private TraceV8 trace = new TraceV8(this, true);
	private static final long serialVersionUID = 1L;

	public MVCFramework() {
		trace.constructorCall();
		Model model = new Model();
		Controller controller = new Controller(model);
		View view = new View(controller);
		controller.setView(view);
		model.addObserver((Observer) view);
		trace.registerObserver(model, view);
				
		add(view);
		pack();
		setMinimumSize(getPreferredSize());
	}

	public static void main(String args[]) {
		TraceV8.mainCall(true, true, true);
		MVCFramework demo = new MVCFramework();
		demo.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		demo.setVisible(true);
		demo.setTitle("MVCFramework");
		demo.setLocationRelativeTo(null);
	}
}
