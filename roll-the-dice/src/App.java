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
		
		//instances
		
		final Model model= new Model();
		
		JFrame frame= new JFrame("Roll the Dice");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final View view= new View();
		final Controller controller= new Controller(view, model);
		
		

		
		//call reference in view
		view.setController(controller);
 
		
		view.setPreferredSize(new Dimension(300, 200));
		view.setDoubleBuffered(true);
		frame.add(view);
		
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		
		
		view.init();
		view.setFocusable(true);
		view.requestFocus();
		view.invalidate();
		 

	}

}
