package client.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import client.gui.goodies.MyBorderFactory;
import common.AnalyzerConstants;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: Muster
//Vorname:
//

public class PNSettings extends JPanel implements ActionListener,
		ChangeListener {
	// 23
	private static final long serialVersionUID = 1L;
	private Controller controller;
	private JSpinner spinnerBufferLength;
	private SpinnerListModel listModelBufferLength;
	private JComboBox jcbWindowType = new JComboBox(new String[] {
			AnalyzerConstants.HANNING, AnalyzerConstants.RECTWIN });

	/**
	 * <pre>
	 * - Baut die Benutzerschnittstelle gemäss Beschreibung in der Aufgabenstellung. Der JSpinner 
	 *   verfügt über die Werte 512, 1024, 2048 und 4096 und ist gemäss Beispiel - Code in der 
	 *   Aufgabenstellung zu realisieren.
	 * </pre>
	 * 
	 * @param ctrl
	 */
	public PNSettings(Controller ctrl) {
		// 21
		super(new GridBagLayout());
		setBorder(MyBorderFactory.createBorder(" " + "Settings" + " "));
		this.controller = ctrl;

		listModelBufferLength = new SpinnerListModel(new String[] { "512",
				"1024", "2048", "4096" });
		spinnerBufferLength = new JSpinner(listModelBufferLength);
		spinnerBufferLength.addChangeListener(this);
		spinnerBufferLength.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				Object value = null;
				if (e.getWheelRotation() < 0) {
					value = listModelBufferLength.getNextValue();
				} else {
					value = listModelBufferLength.getPreviousValue();
				}
				if (value != null)
					listModelBufferLength.setValue(value);
			}
		});

		add(new JLabel("Buffer - Length: "), new GridBagConstraints(0, 0, 1, 1,
				0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(spinnerBufferLength, new GridBagConstraints(1, 0, 1, 1, 1.0, 0.0,
				GridBagConstraints.LINE_END, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));

		jcbWindowType.addActionListener(this);
		add(new JLabel("Window - Type: "), new GridBagConstraints(0, 2, 1, 1,
				0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(jcbWindowType, new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0,
				GridBagConstraints.LINE_END, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel(), new GridBagConstraints(0, 3, 3, 1, 0.0, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(5, 5, 5, 5), 0, 0));
	}

	/**
	 * <pre>
	 * - Ruft zugehörige Methode im Controller, mit der Zeichenkette des gewählten Items 
	 *   der JComboBox auf.
	 * </pre>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// 1
		controller.setWindowType(jcbWindowType.getSelectedItem().toString());
		
		System.out.println(jcbWindowType.getName());
	}

	/**
	 * <pre>
	 * - Ruft zugehörige Methode im Controller, mit gewählter Buffer - Länge auf.
	 * </pre>
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
		// 1
		controller.setBufferLength(Integer.parseInt(spinnerBufferLength
				.getValue().toString()));
		System.out.println((Integer)spinnerBufferLength.getValue());
	}
}
