package guitutorial.gui.layout;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import guitutorial.gui.Controller;
import guitutorial.gui.StatusBar;
import guitutorial.util.MyBorderFactory;

public class CardLayoutPanel extends JPanel implements ActionListener {

	private final static String BUTTONPANEL = "Card with JButtons";
	private final static String TEXTPANEL = "Card with JTextField";
	private JPanel panelCard1 = new JPanel();
	private JPanel panelCard2 = new JPanel();
	private JPopupMenu popup = new JPopupMenu();
	private ButtonGroup btGroup = new ButtonGroup();
	private JButton btCard1, btCard2;
	private Controller controller;

	public CardLayoutPanel(Controller ctrl) {
		super(new CardLayout());

		controller = ctrl;
		JRadioButton jrb = new JRadioButton(BUTTONPANEL, true);
		btGroup.add(jrb);
		jrb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				showCard1();
			}
		});
		popup.add(jrb);
		jrb = new JRadioButton(TEXTPANEL);
		btGroup.add(jrb);
		jrb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				showCard2();
			}
		});
		popup.add(jrb);
		panelCard1.setBorder(MyBorderFactory.createMyBorder(" Card 1 "));
		panelCard1.addMouseListener(new PopupListener());
		panelCard2.setBorder(MyBorderFactory.createMyBorder(" Card 2 "));
		panelCard2.addMouseListener(new PopupListener());
		panelCard1.add(new JLabel("Card mit rechter Maustaste wechseln ..."));

		panelCard1.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				StatusBar.showStatus("x-Position: " + e.getX() + " y-Position: " + e.getY());
			}
		});

		btCard1 = new JButton("Button 2");
		btCard1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}
		});

		panelCard1.add(btCard1);
		btCard2 = new JButton("Button 3");
		btCard2.addActionListener(this);
		panelCard1.add(btCard2);

		panelCard2.add(new JTextField("TextField", 20));
		add(panelCard1, BUTTONPANEL);
		add(panelCard2, TEXTPANEL);
	}

	private void showCard1() {
		CardLayout cl = (CardLayout) (getLayout());
		cl.show(this, BUTTONPANEL);
	}

	private void showCard2() {
		CardLayout cl = (CardLayout) (getLayout());
		cl.show(this, TEXTPANEL);
	}

	class PopupListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			maybeShowPopup(e);
		}

		public void mouseReleased(MouseEvent e) {
			maybeShowPopup(e);
		}

		private void maybeShowPopup(MouseEvent e) {
			if (e.isPopupTrigger()) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btCard1) {
			StatusBar.showStatus(this, e, "btCard1");
		}
		if (e.getSource() == btCard2) {
			StatusBar.showStatus(this, e, "btCard2");
		}

	}
}
