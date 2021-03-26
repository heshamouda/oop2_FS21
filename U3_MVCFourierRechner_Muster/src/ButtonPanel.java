import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import util.MyBorderFactory;
import util.TraceV4;

public class ButtonPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	private TraceV4 trace = new TraceV4(this);
	private Controller controller;
	
	
	public JButton btBerechne = new JButton("Berechne");

	public ButtonPanel(Controller controller) {
		trace.constructorCall();
		setLayout(new BorderLayout());
		setBorder(MyBorderFactory.createMyBorder(" Button "));
		
		this.controller = controller;
		add(btBerechne, BorderLayout.CENTER);
		btBerechne.addActionListener(this);
	}

	/**
	 *überführt Action zum Controller
	 */
	@Override 
	public void actionPerformed(ActionEvent e) {
		trace.eventCall();
		
		controller.btBerechne();
		
	}
}
