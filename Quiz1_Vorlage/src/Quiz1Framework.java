
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiderhandlung die Note 1 erteilt wird.
//
// Name: Hesham
// Vorname: Ouda
//
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Quiz1Framework extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private View view;

	JMenuBar wholeMenuBar = new JMenuBar();
	JMenu fileMenu;
	JMenuItem exitItem;

	public Quiz1Framework() {

		view = new View();
		add(view);

		// ToDo hier: Menu nach Aufgabenblatt erstellen und beleben
		

	}

	/**
	 * <pre>
	 * - schliesst Anwendung
	 * </pre>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

	}

	public static void main(String[] args) {
		Quiz1Framework frame = new Quiz1Framework();

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});

		frame.pack();
		frame.setMinimumSize(frame.getPreferredSize());

		frame.setTitle("|FHNW|EIT|OOP|Quiz1|");

		frame.setResizable(true);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

}