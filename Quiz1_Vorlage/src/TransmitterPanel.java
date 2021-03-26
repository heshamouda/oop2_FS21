
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiderhandlung die Note 1 erteilt wird.
//
// Name: Hesham
// Vorname: Ouda
//
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import util.MyBorderFactory;

public class TransmitterPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public JTextField tfName = new JTextField(2);
	public JTextArea taKommentar = new JTextArea(10, 30);
	public JButton btSenden = new JButton("Senden");
	public JComboBox<String> cbAnrede = new JComboBox<String>();
	public JCheckBox chAGB = new JCheckBox();

	/**
	 * <pre>
	 * - setzt LayoutManager auf GridBagLayout
	 * - Konstruiert das Panel gemaess Aufgabenblatt
	 * - implementiert für den btSenden einen anonymen ActionListener:
	 * 		- Falls Checkbox chAGB angewählt
	 * 			-schreibt Text aus taKommentar ins TextArea des receivPanel
	 * 			-schreibt Anrede und Name in Textfeld des receivPanel
	 * </pre>
	 */
	public TransmitterPanel(ReceiverPanel receivPanel) {

		setBorder(MyBorderFactory.createMyBorder(" GridBagLayout Transmitter "));
		setLayout(new GridBagLayout());

		add(new JLabel("Anrede"), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));

		add(cbAnrede, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

		add(new JLabel("Name"), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(tfName, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 10, 10), 0, 0));

		add(new JLabel("Nachricht"), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
		add(taKommentar, new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));

		add(btSenden, new GridBagConstraints(1, 3, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(2, 10, 10, 10), 0, 0));

		btSenden.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (e.getSource() == btSenden) {
					System.out.println(tfName.getText() + " /r/n");
					System.out.println(taKommentar.getText() + " /r/n");

				}

			}
		});

	}

}
