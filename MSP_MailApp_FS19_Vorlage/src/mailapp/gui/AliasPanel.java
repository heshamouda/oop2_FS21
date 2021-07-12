package mailapp.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import mailapp.model.Model;
import util.Observable;
import util.TraceV7;

public class AliasPanel extends JPanel implements ActionListener {
	private TraceV7 trace = new TraceV7(this);
	private static final long serialVersionUID = 1L;
	private Controller controller;
	public JTextField[] tfTokens = new JTextField[16];
	public JTextField[] tfAlias = new JTextField[tfTokens.length];
	private int nTokens = 0;
//	public String[] tokens = {}, alias = {};

	public AliasPanel(Controller controller) {
		super(new GridBagLayout());
		trace.constructorCall();
		this.controller = controller;

		for (int z = 0; z < tfTokens.length; z++) {
			add(new JLabel("Token: "), new GridBagConstraints(0, z, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
			tfTokens[z] = new JTextField(10);
			tfTokens[z].setFocusable(false);
			add(tfTokens[z], new GridBagConstraints(1, z, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
			add(new JLabel("Alias: "), new GridBagConstraints(2, z, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
			tfAlias[z] = new JTextField(10);
			add(tfAlias[z], new GridBagConstraints(3, z, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
					GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
			tfAlias[z].addActionListener(this);
		}

		add(new JLabel(), new GridBagConstraints(0, tfTokens.length, 4, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		for (int i = 0; i < tfTokens.length; i++) {
			tfTokens[i].setEditable(false);
			tfAlias[i].setEditable(false);
		}
	}

	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		Model model = (Model) obs;

		String[] tokens = model.getMail().getTokens();
		nTokens = tokens.length;
		int i = 0;
		for (; i < nTokens && i < tfTokens.length; i++) {
			tfTokens[i].setText(tokens[i]);
		}
		for (; i < tfTokens.length; i++) {
			tfTokens[i].setText("");
		}

		String[] alias = model.getMailTemplate().getTokens();
		i = 0;
		for (; i < nTokens && i < tfAlias.length; i++) {
			if (i < alias.length) {
				tfAlias[i].setText(alias[i]);
			}
			tfAlias[i].setEditable(true);
		}
		for (; i < tfAlias.length; i++) {
			tfAlias[i].setText("");
			tfAlias[i].setEditable(false);
			tfAlias[i].setFocusable(false);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		trace.eventCall();
		String[] alias = new String[nTokens];
		for (int i = 0; i < alias.length; i++) {
			alias[i] = tfAlias[i].getText();
		}
		controller.setAlias(alias);
		for (int i = 0; i < tfAlias.length; i++) {
			if (e.getSource() == tfAlias[i] && tfAlias[i].isFocusable() && i < tfAlias.length - 1) {
				tfAlias[i + 1].requestFocus();
			}
		}
	}
}
