package guitutorial.gui.infodisplay;

import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.SwingWorker;

import guitutorial.gui.Controller;
import guitutorial.gui.StatusBar;

public class InfoDisplayPanel extends JPanel implements ActionListener, PropertyChangeListener {

	private Controller controller;
	private JButton startButton;
	private JLabel label;
	private TextField textField;

	private JProgressBar progressBar;
	private InfoDisplayPanel.Task task;

	public InfoDisplayPanel(Controller controller) {
		super(new GridBagLayout());
		this.controller = controller;

		startButton = new JButton("Start");
		startButton.setActionCommand("start");
		startButton.addActionListener(this);

		label = new JLabel("0 %");
		textField = new TextField("0 %");
		textField.setEditable(false);

		progressBar = new JProgressBar(0, 100);
		progressBar.setValue(0);
		progressBar.setStringPainted(true);

		add(startButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
				new Insets(10, 10, 10, 10), 0, 0));

		add(new JSeparator(JSeparator.VERTICAL), new GridBagConstraints(1, 0, 1, 3, 0.0, 1.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.VERTICAL, new Insets(10, 10, 10, 10), 0, 0));

		add(progressBar, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
				new Insets(10, 10, 10, 10), 0, 0));

		add(label, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 10, 10), 0, 0));

		add(textField, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 10, 10), 0, 0));

		add(Box.createHorizontalGlue(), new GridBagConstraints(3, 0, 1, 3, 1.0, 0.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
	}

	public void actionPerformed(ActionEvent evt) {
		startButton.setEnabled(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		task = new Task();
		task.addPropertyChangeListener(this);
		task.execute();
	}

	/**
	 * Invoked when task's progress property changes.
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("progress")) {
			int progress = task.getProgress();
			progressBar.setValue(progress);
			label.setText("" + progress + " %");
			textField.setText("" + progress + " %");
			StatusBar.showStatus(String.format("Completed %d%% of task.", task.getProgress()));
		}
	}

	class Task extends SwingWorker {
		/*
		 * Main task. Executed in background thread.
		 */
		public Void doInBackground() {
			Random random = new Random();
			int progress = 0;
			// Initialize progress property.
			setProgress(progress);
			while (progress < 100) {
				// Sleep for up to one second.
				try {
					Thread.sleep(random.nextInt(1000));
				} catch (InterruptedException ignore) {
				}
				// Make random progress.
				progress += random.nextInt(10);
				setProgress(Math.min(progress, 100));
			}
			return null;
		}

		/*
		 * Executed in event dispatching thread
		 */
		public void done() {
			Toolkit.getDefaultToolkit().beep();
			startButton.setEnabled(true);
			setCursor(null);
			StatusBar.showStatus("Done!");
		}
	}
}
