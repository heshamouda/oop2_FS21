import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class App {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		JFrame frame= new JFrame("Roll the Dice");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final View panel= new View();
		panel.setPreferredSize(new Dimension(300, 200));
		panel.setDoubleBuffered(true);
		frame.add(panel);
		
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		
		
		panel.init();
		panel.setFocusable(true);
		panel.requestFocus();
		panel.invalidate();
		 

	}

}
