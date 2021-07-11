package Aufg1;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;


class ExceptionPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JTextField eingabeTf = new JTextField(25), ausgabeTf = new JTextField(25);

	public ExceptionPanel() {
		setLayout(new GridBagLayout());

		add(new JLabel("Geben Sie eine Ganzzahl ein"), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
				GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(eingabeTf, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

		eingabeTf.addActionListener(this);

		add(new JLabel("Ausgabe"), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(ausgabeTf, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

		add(new JLabel(), new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0));

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(eingabeTf)) {
			try {
				int zahl = Integer.parseInt(eingabeTf.getText());
				//ausgabeTf.setText(Integer.toString(2 * zahl));
				ausgabeTf.setText("" + 10 / zahl);
			}catch(NumberFormatException exc) {
				ausgabeTf.setText("Fehler in Eingabe!!");
				System.out.println("catch: "+ exc.getMessage());
				System.out.println("catch: "+ exc.toString());
			}catch(ArithmeticException exc) {
				ausgabeTf.setText("Division by zero not allowed!!");
				System.out.println("catch: " + exc.getMessage());
				System.out.println("catch: "+ exc.toString());
			}
			finally {
				System.out.println("finally wird immer durchlaufen!");
			}
			
		}
		
		//Beispiel geprüfte Ausnahme
		//BufferedReader eingabeDatei = new BufferedReader(new FileReader("name"));

	}

	
	
	private int berechnung(int zahl)  {

		return 0;
	}

}



public class ExceptionDemo extends JFrame {
	private static final long serialVersionUID = 1L;

	public ExceptionDemo() {
		ExceptionPanel view = new ExceptionPanel();
		add(view);
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				ExceptionDemo demo = new ExceptionDemo();
				demo.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
				demo.pack();
				demo.setMinimumSize(demo.getPreferredSize());
				demo.setVisible(true);
				demo.setLocationRelativeTo(null);
			}
		});
	}
}
