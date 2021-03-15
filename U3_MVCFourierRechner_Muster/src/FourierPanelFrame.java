import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import util.TraceV4;
import util.Utility;

public class FourierPanelFrame extends JFrame {
	public TraceV4 trace = new TraceV4(this);
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		TraceV4.mainCall(true, true, true);
		FourierPanelFrame frame = new FourierPanelFrame();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
		Model model = new Model();
		Controller controller = new Controller(model);
		View view = new View(controller);
		controller.setView(view);
		model.addObserver(view);
		
		frame.add(view);
		frame.pack();
		frame.setMinimumSize(frame.getPreferredSize());
		frame.setTitle("|FHNW|EIT|OOP|MVC Fourier-Panel|");
		frame.setResizable(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
//		view.buttonPanel.btBerechne.doClick();
	}
}