import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JPanel;

class ViewPanel extends JPanel {

	String x, y, z;
	String myFirstName;
	String mySecondName;

	public ViewPanel() {
		super(null);
		setPreferredSize(new Dimension(400, 300));
		myFirstName = "Hans";
		mySecondName = "Mustermann";
		x = new String("Susanne");
		y = new String("Mustermann");
		
	
		int count = 7;

		String message = String.format("count is %05d", count);
		System.out.println(message);

		double pi = Math.PI;

		double scientific = 100654;
		
		

		//String vergleichen
		//.equals

		

		//.equalsIgnoreCase
		if(x.equalsIgnoreCase("Susanne"));
			System.out.println("Name is alaways the same");
		

		//.compareTo
		int n = "bdoor".compareTo("adoor");
		System.out.println("n= " + n);

		//String verändern
		String testString;
		//.replace
		

		//.toLowerCase
		

		//.trim
		String testStringOriginal = "\tIch \twuensche \tIhnen \teinen \tguten \tTag!\n";
		System.out.println(testStringOriginal);
		

		//String analysieren
		//.length()
		
		//.substring
		testString = "Hi there!";
		System.out.println(testString);

		//.charAt
		char testChar='t';
		System.out.println(testChar);

		//.indexOf  .lastIndexOf
		//int testPosition = "Try this and this too!"
		//System.out.println(testPosition);
		

		//.endsWith
		boolean r = "Try this and this too!".endsWith("!");
		System.out.println(r);
		
		//Zerlegen von Zeichenketten
		//split

		//String[] result ="This, is a.test"
		
		

		//StringTokenizer
		String zitat = "Das Geheimnis des Erfolgs ist die Beständigkeit des Ziels";
		
		
		
		//System.arraycopy
		int[] sourceArray = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] destArray = new int[10];

		

		for (int i = 0; i < destArray.length; i++) {
			System.out.print(destArray[i] + "");
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setFont(new Font("Arial", Font.BOLD, 15));
		g.drawString("My Name is " + myFirstName + " " + mySecondName, 100, 100);
		int z = 25;
		g.drawString("The number is " + z, 100, 150);

		g.drawString("  " + "      ", 100, 200);

	}

}

public class JavaLibFramework extends JFrame {

	public ViewPanel view = new ViewPanel();

	public JavaLibFramework() {
		add(view);
		pack();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JavaLibFramework demo = new JavaLibFramework();

		demo.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		demo.setVisible(true);
		demo.setTitle("JavaLibraryDemo");
		demo.setLocationRelativeTo(null);

	}

}
