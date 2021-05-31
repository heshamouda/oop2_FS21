import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class AWTDemo extends Frame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private Button start, stop;
	private Ball ball;

	public AWTDemo() {
		setLayout(new FlowLayout());
		start = new Button("Start");
		add(start);
		start.addActionListener(this);
		stop = new Button("Stop");
		add(stop);
		stop.addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == start) {
			// ...
			Graphics g = getGraphics();
			ball = new Ball(g);
			ball.anzeigen();
			

		}
	}

	

	public static void main(String[] args) {
		AWTDemo f = new AWTDemo();
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.setSize(400, 300);
		f.setVisible(true);
		f.setBackground(Color.white);
		f.setLocationRelativeTo(null);
	}

}
