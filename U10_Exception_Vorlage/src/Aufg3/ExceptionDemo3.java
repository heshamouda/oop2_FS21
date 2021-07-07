package Aufg3;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.Buffer;

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

		add(new JLabel(), new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			int number = Integer.parseInt(eingabeTf.getText());			
		 
			ausgabeTf.setText("" + berechnung(number));
		} catch (ValueToBigException exc) {

			ausgabeTf.setText("Error: division on zero!");
			System.out.println("catch: "+ exc.getMessage());
			System.out.println("catch: "+ exc.toString());		
		}
		catch (NumberFormatException exc) {

			ausgabeTf.setText("Error in input");
			System.out.println("catch: "+ exc.getMessage());
			System.out.println("catch: "+ exc.toString());		
		}
		
		finally {
			System.out.println("Finally will  always go throw");
		}
		
		
		
//		try {
//			BufferedReader inputTextFile = new BufferedReader(new FileReader("name"));
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		

	}

	private int berechnung(int zahl) throws ValueToBigException{
		
		int result = 0;
		if ((result = 2* zahl) > 200) {
//			throw new NumberFormatException();	
			throw new ValueToBigException("number is outside domain", 25);
		}

		return result;
	}

	
	class ValueToBigException extends NumberFormatException{
		private int errorID;
		public ValueToBigException(String message, int errorID) {
			super(message);
			this.errorID = errorID;
			
		}	
		
		public int getErrorID() {
			return errorID;
		}
	}
}

public class ExceptionDemo3 extends JFrame {
	private static final long serialVersionUID = 1L;

	public ExceptionDemo3() {
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
				ExceptionDemo3 demo = new ExceptionDemo3();
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
