package Aufg3;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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
		if (e.getSource().equals(eingabeTf)) {
			try {
				int zahl = Integer.parseInt(eingabeTf.getText());

				ausgabeTf.setText("" + berechnung(zahl));
			} catch (ValueToBigException exc) {
				ausgabeTf.setText("Fehler in Eingabe!!");
				System.out.println("catch: " + exc.getMessage() + "ErrorID " + exc.getErrorID());
				
			} catch (NumberFormatException exc) {
				ausgabeTf.setText("Fehler in Eingabe!!");
				System.out.println("catch:" + exc.getMessage());
			} finally {
				System.out.println("finally wird immer durchlaufen!");
			}

		}

	}

	private int berechnung(int zahl) throws ValueToBigException {
		int resultat = 0;
		if((resultat = 2 * zahl) > 200) {
			//throw new NumberFormatException();
			throw new ValueToBigException("Zahl ausserhalb gültigem Bereich!",42);
		}
		return resultat;
	}
	

}

class ValueToBigException extends NumberFormatException {
	
	private static final long serialVersionUID = 1L;
	private int errorID;

	public ValueToBigException(String message, int errorId) {
		super(message);
		this.errorID = errorId;
	}

	public int getErrorID() {
		return errorID;
	}
}
public class ExceptionDemoAufg3 extends JFrame {
	private static final long serialVersionUID = 1L;

	public ExceptionDemoAufg3() {
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
				ExceptionDemoAufg3 demo = new ExceptionDemoAufg3();
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
