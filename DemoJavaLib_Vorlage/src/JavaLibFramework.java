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
//		System.out.println("My Name is \n" + myFirstName );
	
		int count = 7;
		
		String message = String.format("count is %02d", count); //formatting 
		System.out.println(message);

		double pi = Math.PI;
		message = String.format("pi is %.6f", pi ); //determine comma position
		System.out.println(message);
		double scientific = 100654;
		
		String message3 = String.format("Scientific is %.1e",scientific); //scientific formatting
		System.out.println(message3);
		

		//String vergleichen
		//.equals
		if (myFirstName.equals ("Hans")) {
			System.out.println("Name is identical");
		}
		

		//.equalsIgnoreCase
		if(x.equalsIgnoreCase("Susanne"));
			System.out.println("Name is alaways the same");
		

		//.compareTo
		int n = "gmeise".compareTo("fmeise");
		System.out.println("n= " + n);

		//String verändern
		String testString;
		//.replace
		String test2String = "Mississipi".replace("s", "t");
		System.out.println(test2String);

		//.toLowerCase
		

		//.trim
		String testStringOriginal = "\tIch \twuensche \tIhnen \teinen \tguten \tTag!\n";
		System.out.println(testStringOriginal);
		System.out.println(testStringOriginal.trim());

		//String analysieren
		//.length()
		System.out.println(testStringOriginal.length());
		System.out.println(testStringOriginal.trim().length());
		
		//.substring
		testString = "Hi there!".substring(3,8);
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
		g.drawString("My Name is \n" + myFirstName + " " + mySecondName, 100, 100);
		int z = 25;
		g.drawString("The number is " + z, 100, 150);

		g.drawString(" \"  " + "    \\  ", 100, 200);

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
