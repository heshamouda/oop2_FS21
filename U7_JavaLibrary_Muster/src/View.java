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

		this.controller = controller;
		add(new JLabel("Term:"), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(new JLabel("Ergebnis:"), new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(tfTerm, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(tfResult, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(new JLabel(), new GridBagConstraints(0, 2, 2, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(taBoard, new GridBagConstraints(0, 2, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0));
		add(btSort, new GridBagConstraints(0, 3, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		tfTerm.addActionListener(this);
		btSort.addActionListener(this);
		
		

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(tfTerm)) {
			controller.tfRecalc();
		}
		if (e.getSource().equals(btSort)) {
			controller.btSortieren();
		}
		
	}

	public void update(Observable obs, Object obj) {
		if(obs instanceof Model ) {
			Model model = (Model)obs;
			tfResult.setText(Integer.toString(model.getErgebnis()));
			
			taBoard.setText("");
			String[] zeilen = model.getAlphabetOrder();
			for (int i = 0; i < zeilen.length; i++) {
				taBoard.append(zeilen[i] + "\n");
			}
		}
		
		

	}

	
}
