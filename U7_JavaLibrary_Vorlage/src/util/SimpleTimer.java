package util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class SimpleTimer extends javax.swing.Timer implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Vector<SimpleTimerListener> listenerVector = new Vector<SimpleTimerListener>();

	public SimpleTimer(int periode, SimpleTimerListener listener) {
		super(periode, null);
		addActionListener(this);
		addTimerListener(listener);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (!listenerVector.isEmpty()) {
			for (int i = 0; i < listenerVector.size(); i++) {
				((listenerVector.elementAt(i))).timerAction();
			}
		}
	}

	public void addTimerListener(SimpleTimerListener listener) {
		listenerVector.add(listener);
	}

	public void removeTimerListener(SimpleTimerListener listener) {
		listenerVector.remove(listener);
	}
}
