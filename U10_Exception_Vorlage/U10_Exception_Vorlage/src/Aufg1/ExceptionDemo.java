package Aufg1;
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

		

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		

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
