import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import util.Observer;

public class JavaLibraryFramework extends JFrame {
	
	private static final long serialVersionUID = 1L;
	Model model = new Model();
	Controller controller = new Controller(model);
	View view = new View(controller);

	public JavaLibraryFramework() {
		
		controller.setView(view);
		model.addObserver(view);
		add(view);
		
		
		
		pack();
		setMinimumSize(getPreferredSize());
		setResizable(true);
		setLocationRelativeTo(null);
	}

	public static void main(String args[]) {
		
		JavaLibraryFramework demo = new JavaLibraryFramework();
		demo.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		demo.setVisible(true);
		demo.setTitle("String Manipulation");
	}
}

