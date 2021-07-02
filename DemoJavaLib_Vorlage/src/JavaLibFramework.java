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

	/**
	 * Representation of Strings: String concat special characters like \n for new
	 * line, \t for tabular formatting %05d, %5d, %.4f, %.3e
	 */

	public ViewPanel() {
		super(null);
		setPreferredSize(new Dimension(400, 300));
		myFirstName = "Hans";
		mySecondName = "Mustermann";

		// Mit Konstruktor initialisieren: String sind Objekte
		x = new String("Susanne");
		y = new String("Mustermann");
		System.out.println("My Name is \n" + myFirstName);

		int count = 7;

		String message = String.format("count is %05d", count); // formatting count is --> 00007
		System.out.println(message);

		double pi = Math.PI;
		message = String.format("pi is %.4f", pi); // determine comma position
		System.out.println(message);
		double scientific = 100654;

		String message3 = String.format("Scientific is %.3e", scientific); // scientific formatting
		System.out.println(message3);

		/**
		 * Compare Strings 
		 * .equal() --> has the same value
		 * .equalsIgnoreCase()--> to ignore the case upper or low
		 * .compareTo()--> to compare the characters sequences
		 * 
		 */
		// String vergleichen
		// .equals
		if (myFirstName.equals("Hans")) {
			System.out.println("Name is identical1");
			
		}

		if (myFirstName =="Hans") {
			 
			System.out.println("Name is identical12");
		}
		// .equalsIgnoreCase
		if (x.equalsIgnoreCase("Susanne"))
			;
		System.out.println("Name is alaways the same");

		// .compareTo
		int n = "ameise".compareTo("bmeise");
		System.out.println("n= " + n);
		 n = "bmeise".compareTo("ameise");
			System.out.println("n= " + n);
/**
 * Changes charachters with
 * .replace()--> replace with anothers
 * .toLowerCase() OR  toUpperCase()
 * .trim()--> remve spaces at the beginning and the end of Strings
 */
		// String verändern
		String testString;
		// .replace
		String test2String = "Mississipi".replace("s", "t");
		System.out.println(test2String);

		// .toLowerCase
		String lowString= "HELLO".toLowerCase();
		System.out.println(lowString);

		// .trim
		String testStringOriginal = "\tIch \twuensche \tIhnen \teinen \tguten \tTag!\n";
		System.out.println(testStringOriginal);
		System.out.println(testStringOriginal.trim());

		/**
		 * analyses String 
		 * .length()--> get the length
		 * .subString()--> give charachters with predefinded index
		 * .chartAt()--> to get a charachter at predefinded index
		 * .indexOf()--> 
		 * 
		 */
		// String analysieren
		// .length()
		System.out.println(testStringOriginal.length());
		System.out.println(testStringOriginal.trim().length());

		// .substring
		testString = "Hi there!".substring(3, 8);
		System.out.println(testString);

		// .charAt
		char testChar = 't';
		System.out.println(testChar);

		// .indexOf .lastIndexOf
		 int testPosition = "Try this and this too!".indexOf("this" ,8);
		System.out.println(testPosition);

		// .endsWith
		boolean r = "Try this and this too!".endsWith("u");
		System.out.println(r);
		 r = "Try this and this too!".startsWith("T");
		System.out.println(r);

/**
 * Decomposition of strings
 */
		// Zerlegen von Zeichenketten
		// split

		 String[] result ="This, is a.test".split("[,. ]+");
		 for (int i = 0; i < result.length; i++) {
			String string = result[i];
			System.out.println(string);			
		}

		// StringTokenizer
		String zitat = "Das Geheimnis des Erfolgs ist die Beständigkeit des Ziels";
		StringTokenizer tokenizer = new StringTokenizer(zitat, " ");
		while (tokenizer.hasMoreTokens()) {
			System.out.println(tokenizer.nextToken());
			
		}

		// System.arraycopy
		int[] sourceArray = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] destArray = new int[10];
		System.arraycopy(sourceArray, 0, destArray, 5,3);

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
