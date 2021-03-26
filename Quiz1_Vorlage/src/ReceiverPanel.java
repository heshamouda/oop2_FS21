
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiderhandlung die Note 1 erteilt wird.
//
// Name: Hesham
// Vorname:
//
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import util.MyBorderFactory;

public class ReceiverPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public JTextField tfZeile = new JTextField(10);
	public JButton btClear = new JButton("Clear");
	public JTextArea taLeft = new JTextArea(10, 20);

	/**
	 * <pre>
	 * - setzt LayoutManager auf BorderLayout
	 * - Konstruiert das Panel gemaess Aufgabenblatt
	 * - implementiert für den btClear einen anonymen ActionListener:
	 *   - loescht Inhalt vom tfZeile und taLeft
	 * 
	 * </pre>
	 */
	public ReceiverPanel() {

		setBorder(MyBorderFactory.createMyBorder(" BorderLayout Receiver "));
		setLayout(new BorderLayout ());
		
		btClear.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getSource().equals(btClear)) {
					
					
				}
				
			}
		});

	}

}
