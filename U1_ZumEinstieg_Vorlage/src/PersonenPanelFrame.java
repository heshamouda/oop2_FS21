import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

class PersonenPanel extends JPanel {
	private Person person1;
	private Person person2;

	/**
	 * <pre>
	 * - NullLayout setzen - person1 mit Mozart erzeugen - person2 mit Beethoven
	 * erzeugen - person1 bei Koordinaten (15, 0, 215, 350) hinzufügen - person2 bei
	 * Koordinaten (230, 0, 215, 350) hinzufügen
	 */
	public PersonenPanel() {
		setLayout(null);
		person1 = new Person("Mozart", "Wofgang", "Mozart.jpg", "gmoll.wav");
		person2 = new Person("Beethoven", "Ludwig", "Beethoven.jpg", "cmoll.wav");
		add(person1).setBounds(15, 0, 215, 350);
		add(person2).setBounds(230, 0, 215, 350);

	}
}

public class PersonenPanelFrame extends JFrame {
	private PersonenPanel view;

	public PersonenPanelFrame() {
		view = new PersonenPanel();
		add(view);
		setSize(460, 400);
		setTitle("|FHNW|EIT|OOP|Personen - Panel|");
		setIconImage(Utility.loadResourceImage("clef.png"));
		setResizable(true);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public static void main(String args[]) {
		PersonenPanelFrame frame = new PersonenPanelFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
	}
}