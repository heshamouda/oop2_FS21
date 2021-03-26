import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class BasicLayoutPanel extends JPanel {

	private JButton bt1 = new JButton("Button 1");
	private JButton bt2 = new JButton("Button 2");
	private JButton bt3 = new JButton("Button 3");
	private JButton bt4 = new JButton("Button 4");
	private JButton bt5 = new JButton("Button 5");

//	private JButton bt1 = new JButton("Nord");
//	private JButton bt2 = new JButton("Ost");
//	private JButton bt3 = new JButton("Süd");
//	private JButton bt4 = new JButton("West");
//	private JButton bt5 = new JButton("Zentriert");

	public BasicLayoutPanel() {

//		setLayout(new FlowLayout(FlowLayout.CENTER, 50, 25));
//		setLayout(new BorderLayout(20,50));
		setLayout(new GridLayout(2, 3, 20, 20));
		setBorder(MyBorderFactory.createMyBorder("BasicLayoutPanel"));
//		bt1.setFont( new Font("Serif", Font.BOLD, 30) );
//		bt2.setFont( new Font("Serif", Font.BOLD, 30) );
//		bt3.setFont( new Font("Serif", Font.BOLD, 30) );
//		bt4.setFont( new Font("Serif", Font.BOLD, 30) );
//		bt5.setFont( new Font("Serif", Font.BOLD, 30) );

		add(bt1);
		add(bt2);
		add(bt3);
		add(bt4);
		add(bt5);

		// für Border-Layout das verwenden
//		add(bt1,BorderLayout.NORTH);
//		add(bt2,BorderLayout.EAST);
//		add(bt3,BorderLayout.SOUTH);
//		add(bt4, BorderLayout.WEST);
//		add(bt5, BorderLayout.CENTER);
	}
	
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
//				
				JFrame frame = new JFrame();
				
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("TopView");
				frame.add(new BasicLayoutPanel());
				frame.pack();
//				frame.setMinimumSize(frame.getPreferredSize());
				frame.setSize(400, 300);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

}
