// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiderhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
//
import java.awt.GridLayout;

import javax.swing.JPanel;

import util.MyBorderFactory;


public class View extends JPanel {

	private static final long serialVersionUID = 1L;

	private ReceiverPanel receivPanel = new ReceiverPanel();
	private TransmitterPanel transPanel = new TransmitterPanel(receivPanel);
	
	/**
	 * <pre>
	 * - setzt LayoutManager GridLayout entsprechend Skizze im Aufgabnblatt
	 *   (hgap = vgap = 5)
	 * - platziert receivPanel und transPanel gemaess Skizze
	 * </pre>
	 */
	public View() {
		setBorder(MyBorderFactory.createMyBorder(" View "));
		//3
		setLayout(new GridLayout(2,1,5,5));

		add(transPanel);

		add(receivPanel);

		

	}

}
