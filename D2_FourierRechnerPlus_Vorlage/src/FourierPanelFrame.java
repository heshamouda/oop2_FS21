import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import util.TraceV8;
import util.Utility;

public class FourierPanelFrame extends JFrame {
	public TraceV8 trace = new TraceV8(this);
	private static final long serialVersionUID = 1L;
	private static Image icon = Utility.loadResourceImage("apple.png");

	public FourierPanelFrame() {
		Model model = new Model();
		Controller controller = new Controller(model);
		View view = new View(controller);
		controller.setView(view);
		model.addObserver(view);
		add(view);
		view.buttonPanel.btBerechne.doClick();
	}

	public static void main(String args[]) {
		TraceV8.mainCall(true, true, true);
		FourierPanelFrame frame = new FourierPanelFrame();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
		frame.pack();
		frame.setMinimumSize(frame.getPreferredSize());
		frame.setIconImage(icon);
		frame.setTitle("|FHNW|EIT|OOP|Fourier-Panel|");
		frame.setResizable(true);
		frame.setVisible(true);
	}
}
