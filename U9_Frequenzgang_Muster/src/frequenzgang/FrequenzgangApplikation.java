package frequenzgang;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import frequenzgang.gui.Controller;
import frequenzgang.gui.View;
import frequenzgang.model.Model;
import util.TraceV5;

public class FrequenzgangApplikation extends JFrame {
	private TraceV5 trace = new TraceV5(this);
	
	

	
	public  FrequenzgangApplikation() {
		trace.methodeCall();
		Model model = new Model(0, 10e3, 1000);
		Controller controller = new Controller(model);
		View view = new View(controller);
		controller.setView(view);

		model.addObserver(view);
		

		add(view);
		pack();

		setMinimumSize(getPreferredSize());
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
	}

	public static void main(String args[]) {
		TraceV5.mainCall(true, true, true);
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
				
			}
		});
	}
}
