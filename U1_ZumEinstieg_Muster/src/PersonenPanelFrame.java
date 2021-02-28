import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JPanel;

class PersonenPanel extends JPanel {
	private Person person1;
	private Person person2;
	
	/**
	 * <pre>
	 * - NullLayout setzen
	 * - person1 mit Mozart erzeugen
	 * - person2 mit Beethoven erzeugen
	 * - person1 bei Koordinaten (15, 0, 215, 350) hinzufügen
	 * - person2 bei Koordinaten (230, 0, 215, 350) hinzufügen
	 */
	public PersonenPanel(){
		setLayout(null);
		person1 = new Person("Mozart","Wolfgang Amadeus","Mozart.jpg","gmoll.wav");
		person2 = new Person(" van Beethoven","Ludwig","Beethoven.jpg","cmoll.wav");
		add(person1).setBounds(15, 0, 215, 350); //(10, 100, 150, 200);
		add(person2).setBounds(230, 0, 215, 350);//(200,100,150,200);
	
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
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
	}
}