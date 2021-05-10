import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JPanel implements Observer, ActionListener {
	private static final long serialVersionUID = 1L;
	TraceV8 trace = new TraceV8(this);
	public JTextField tf1 = new JTextField(40), tf2 = new JTextField(40);
	private Controller controller;
	private JButton btOK = new JButton("OK");
	
	
	 
	public View(Controller controller) {
		trace.constructorCall();

		this.controller = controller;
		setLayout(new BorderLayout());

		JPanel pNord = new JPanel(new GridLayout(2, 2));
		pNord.add(new Label("Eingabetext"));
		pNord.add(new Label("Ausgabetext"));
		pNord.add(tf1);
		pNord.add(tf2);
		add(pNord, BorderLayout.NORTH);
		add(btOK, BorderLayout.SOUTH);
		btOK.addActionListener(this);
	}


 
	public void actionPerformed(ActionEvent e) {
		 trace.eventCall();
		 controller.btAction(tf1.getText());		
	}
	
	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		if (obs instanceof Model) {
			Model model = (Model) obs;
			String textInModel = model.getData();
			tf2.setText(textInModel);
		}
	}
}
