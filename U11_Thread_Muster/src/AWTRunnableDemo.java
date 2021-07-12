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

public class AWTRunnableDemo extends Frame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Button start, stop;
	private RunnableBall[] ball = new RunnableBall[50];

	private int i = 0;

	public AWTRunnableDemo() {
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

			ball[i] = new RunnableBall(g);
			Thread thread = new Thread(ball[i]);
			thread.start();
			i++;

		}

		if (e.getSource() == stop) {
			// ...
			if (i > 0) {
				// ball.stoppen();
				i--;
				ball[i].stoppen();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

	}

	

	public static void main(String[] args) {
		AWTRunnableDemo f = new AWTRunnableDemo();
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		f.setSize(400, 300);
		f.setVisible(true);
		f.setBackground(Color.white);
	}

}
