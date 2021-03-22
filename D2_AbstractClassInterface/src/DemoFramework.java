import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DemoFramework extends JFrame {

	public DemoFramework() {
		View view = new View();
		add(view);

		

		pack();
		setPreferredSize(getMinimumSize());
	}

	public static void main(String args[]) {
		DemoFramework demo = new DemoFramework();
		demo.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		demo.setVisible(true);
		demo.setTitle("Abstrakte Klassen und Interface");
		demo.setLocationRelativeTo(null);
	}
}
