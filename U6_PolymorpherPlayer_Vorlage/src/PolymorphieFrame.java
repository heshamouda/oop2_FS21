import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.JFrame;


	public class PolymorphieFrame extends JFrame {
	private InstrumentenPanel view;

	public PolymorphieFrame() {
		view = new InstrumentenPanel();
		add(view);
		setTitle("|FHNW|EIT|OOP|Polymorher Player - Panel|");
		setIconImage(Utility.loadResourceImage("clef.png"));
		setResizable(true);
		setVisible(true);
		
		pack();
		setMinimumSize(getPreferredSize());
		setLocationRelativeTo(null);
	}

	public static void main(String args[]) {
		PolymorphieFrame frame = new PolymorphieFrame();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
	}
}