package mailapp.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import mailapp.model.Mailer;
import util.TraceV7;

public class AccountDialog extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private TraceV7 trace = new TraceV7(this);
	public static final int CANCEL_OPTION = 0, APPROVE_OPTION = 1;
	private JTextField tfMailServer = new JTextField(Mailer.getMailServer());
	private JTextField tfUsername = new JTextField(Mailer.getUserName());
	private JPasswordField tfPassword = new JPasswordField(Mailer.getPassword());
	private JTextField tfAbsender = new JTextField(Mailer.getAbsender());
	private JButton btOK = new JButton("OK");
	private JButton btCancel = new JButton("CANCEL");
	private int returnValue = CANCEL_OPTION;

	AccountDialog(JFrame frame) {
		super(frame, "Account-Dialog", true);
		trace.constructorCall();
		setLayout(new GridBagLayout());

		int z = 0;
		add(new JLabel("Mail-Server: "), new GridBagConstraints(0, z, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		tfMailServer.setColumns(35);
		add(tfMailServer, new GridBagConstraints(1, z, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(new JLabel("Bsp: smtp.fhnw.ch"), new GridBagConstraints(2, z, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		z = 1;
		add(new JLabel("User-Name: "), new GridBagConstraints(0, z, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(tfUsername, new GridBagConstraints(1, z, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(new JLabel("Bsp: richard.gut@fhnw.ch"), new GridBagConstraints(2, z, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		z = 2;
		add(new JLabel("Password: "), new GridBagConstraints(0, z, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(tfPassword, new GridBagConstraints(1, z, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(new JLabel("Bsp: SchatziPutzi61"), new GridBagConstraints(2, z, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		z = 3;
		add(new JLabel("Absender: "), new GridBagConstraints(0, z, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(tfAbsender, new GridBagConstraints(1, z, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(new JLabel("Bsp: richard.gut@fhnw.ch"), new GridBagConstraints(2, z, 1, 1, 0.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

		JPanel p = new JPanel(new GridLayout(1, 50, 2, 50));
		p.add(btOK);
		p.add(btCancel);
		z = 4;
		add(p, new GridBagConstraints(2, z, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 10, 10), 0, 0));

		btCancel.addActionListener(this);
		btOK.addActionListener(this);
		pack();
	}

	public int showDialog() {
		trace.methodeCall();
		setVisible(true);
		return returnValue;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		trace.eventCall();
		if (e.getSource() == btOK)
			returnValue = APPROVE_OPTION;
		else
			returnValue = CANCEL_OPTION;
		setVisible(false);
	}

	public String getAbsender() {
		trace.methodeCall();
		return tfAbsender.getText();
	}

	public String getPassword() {
		trace.methodeCall();
		return new String(tfPassword.getPassword());
	}

	public String getUsername() {
		trace.methodeCall();
		return tfUsername.getText();
	}

	public String getMailServer() {
		trace.methodeCall();
		return tfMailServer.getText();
	}

}