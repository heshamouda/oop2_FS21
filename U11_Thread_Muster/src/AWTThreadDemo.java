import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AWTThreadDemo extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Button start, stop;
	private ThreadBall[] ball = new ThreadBall[50];
//	private ThreadBall ball;

	private int i = 0;

	public AWTThreadDemo() {
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
//			ball = new ThreadBall(g);
			ball[i] = new ThreadBall(g);
			System.out.println(ball[i].getState());
			ball[i].start();

			System.out.println(ball[i].getState());
			i++;

		}

		if (e.getSource() == stop) {
			// ...
			if (i > 0) {
//				ball.stoppen();
				i--;
				ball[i].stoppen();
				System.out.println(ball[i].getState());// hier lebt er noch im waiting Modus
				try {
					Thread.sleep(50);
					System.out.println(ball[i].getState());// nach dem Warten ist der Thread dann wirklich tot (run()
															// mit weitermachen false durchgelaufen
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

	}

	public static void main(String[] args) {
		AWTThreadDemo f = new AWTThreadDemo();
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
