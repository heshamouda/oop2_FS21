import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * Zunächst RadioButtons mit normalem ActionListener implementieren Im 2.
 * Schritt dann Beispiel mit innerer Klasse (Standardadapter) und anonymer
 * Klasse, die Interface implementiert (anonymer Adapter)
 * 
 * 
 *
 */
public class GUIPanel extends JPanel implements ActionListener {

	private JRadioButton birdButton, catButton, dogButton;
	private int zahl = 42;

	public GUIPanel() {
		setBorder(MyBorderFactory.createMyBorder(" GUIPanel "));
		birdButton = new JRadioButton("Bird");
		birdButton.setMnemonic(KeyEvent.VK_B);
		birdButton.setActionCommand("Bird");
		birdButton.setSelected(true);

		birdButton.addActionListener(this);
//		birdButton.addActionListener(new BirdAction());

		catButton = new JRadioButton("Cat");
		catButton.setMnemonic(KeyEvent.VK_C);
		catButton.setActionCommand("Cat");
		catButton.setSelected(false);

		catButton.addActionListener(this);
//		catButton.addActionListener(new ActionListener(){
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Ich bin der anonyme KatzenListener");
//				
//			}
//			
//		});

		ButtonGroup group = new ButtonGroup();
		group.add(birdButton);
		group.add(catButton);

		add(birdButton);
		add(catButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(birdButton)) {
			System.out.println(birdButton.getActionCommand() + "Button selected");
		}
		if (e.getSource().equals(catButton)) {
			System.out.println(catButton.getActionCommand() + "Button selected");
		}

	}

	class BirdAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(birdButton.getActionCommand() + " mit private Attribut" + zahl);

		}

	}

}
