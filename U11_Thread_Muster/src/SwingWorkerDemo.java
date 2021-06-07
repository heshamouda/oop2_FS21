import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class SwingWorkerDemo extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Button start, stop;
	private int i = 0;
	public SwingWorkerBall[] ball = new SwingWorkerBall[50];
	// private ThreadBall[] ball = new ThreadBall[50];

	public SwingWorkerDemo() {
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
			if (i == ball.length)
				return;
			//
			Graphics g = getGraphics();
			ball[i] = new SwingWorkerBall(g);
			// ball[i] = new ThreadBall(g);
			System.out.println(ball[i].getState());
			
			// ball[i].start();
			ball[i].execute();
			try {
				Thread.sleep(50);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			System.out.println(ball[i].getState());
			i++;
		}
		if (e.getSource() == stop) {
			// ...
			if (i > 0) {
				i--;
				ball[i].stoppen();
				System.out.println(ball[i].getState());// hier lebt er noch im waiting Modus
				try {
					Thread.sleep(50);
					System.out.println(ball[i].getState());// nach dem Warten ist der Thread dann wirklich tot (run()
															// mit weitermachen false durchgelaufen
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}



	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
				SwingWorkerDemo f = new SwingWorkerDemo();
				f.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
				f.setSize(400, 300);
				f.setVisible(true);
				f.getContentPane().setBackground(Color.white);
				f.setLocationRelativeTo(null);

			}
		});
	}

}
