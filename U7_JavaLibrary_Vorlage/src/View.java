import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import util.MyBorderFactory;
import util.Observable;
import util.Observer;

public class View extends JPanel implements Observer, ActionListener {
	private static final long serialVersionUID = 1L;

	private Controller controller;
	public JButton btSort = new JButton("Sortieren");
	public JTextField tfTerm = new JTextField("42 + 5", 20);
	public JTextField tfResult = new JTextField(10);
	public JTextArea taBoard = new JTextArea(20, 40);

	public View(Controller controller) {
		super(new GridBagLayout());
		setBorder(MyBorderFactory.createMyBorder(" View Panel "));

		
		
		

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}

	public void update(Observable obs, Object obj) {
		
		
		

	}

	
}
