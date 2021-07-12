package mailapp.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;

import util.TraceV7;

public class ListPanel extends JPanel implements ActionListener {
	private TraceV7 trace = new TraceV7(this);
	private static final long serialVersionUID = 1L;
	private Controller controller;

	public JTextArea taListe = new JTextArea(
			"Gut, Richard\trichard.gut@fhnw.ch\t120\t6.0\r\n" + "Gutkind, Robert\tr_gut@bluewin.ch\t100\t5.0\r\n");

	public ListPanel(Controller controller) {
		super(new GridBagLayout());
		trace.constructorCall();
		this.controller = controller;
		taListe.setTabSize(4);

		add(taListe, new GridBagConstraints(0, 0, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));

		taListe.getDocument().addDocumentListener(new DocumentAdapter() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				actionPerformed(null);
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				actionPerformed(null);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		trace.eventCall();
		if (!taListe.getText().equals(""))
			controller.setEintraege();
	}
}
