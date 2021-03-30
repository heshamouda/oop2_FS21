package signalsource;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import gui.Controller;
import gui.View;
import model.Model;
import util.Observer;
import util.TraceV5;

public class SignalSourceApplikation extends JFrame {
	private TraceV5 trace = new TraceV5(this);

	public void init() {
		trace.methodeCall();
		// --hier Model/View/Controller Pattern erzeugen und view hinzufügen

		Model model = new Model();
		Controller controller= new Controller(model);
		View view = new View(controller);
		
		//add view		
		controller.setView(view);
		model.addObserver(view);
		add(view);
		
		
		
		
		// ---------------------

		pack();
		setMinimumSize(getPreferredSize());
		System.out.println(getPreferredSize());

	}

	public static void main(String args[]) {
		TraceV5.mainCall(true, true, true);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
//					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				SignalSourceApplikation frame = new SignalSourceApplikation();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Signal Source Interface");
				frame.init();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
	}
}
