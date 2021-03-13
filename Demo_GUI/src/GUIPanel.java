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
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		
		
	}

	class BirdAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
				
			
		}

		

	}

}
