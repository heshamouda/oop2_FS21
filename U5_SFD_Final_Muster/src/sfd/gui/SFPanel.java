package sfd.gui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import util.TraceV8;

public class SFPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private TraceV8 trace = new TraceV8(this);
	public JTextArea textArea = new JTextArea();
	private JScrollPane scroll = new JScrollPane(textArea);

	public SFPanel() {
		super(new BorderLayout());
		trace.constructorCall();
		textArea.setLineWrap(false);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scroll);
	}
}
