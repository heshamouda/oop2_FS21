package client.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.gui.goodies.MyBorderFactory;
import client.model.Model;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: Muster
//Vorname:
//

public class PNMarker extends JPanel {
	// 19
	private static final long serialVersionUID = 1L;
	private JTextField tfBandStart = new JTextField(10);
	private JTextField tfBandStop = new JTextField(10);
	private JTextField tfBandRMS = new JTextField(10);

	/**
	 * <pre>
	 * - Baut Benuterzschnittstelle gemäss Aufgabenstellung.
	 * </pre>
	 * 
	 * @param ctrl
	 */
	public PNMarker() {
		// 15
		super(new GridBagLayout());
		setBorder(MyBorderFactory.createBorder(" " + "Band - Marker" + " "));

		tfBandStart.setEditable(false);
		add(new JLabel("Band - Start: "), new GridBagConstraints(0, 1, 1, 1,
				0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(tfBandStart, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));
		add(new JLabel("Hz"), new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
				GridBagConstraints.LINE_END, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 0, 0));

		tfBandStop.setEditable(false);
		add(new JLabel("Band - Stop: "), new GridBagConstraints(0, 2, 1, 1,
				0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(tfBandStop, new GridBagConstraints(1, 2, 1, 1, 1.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));
		add(new JLabel("Hz"), new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
				GridBagConstraints.LINE_END, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 0, 0));

		tfBandRMS.setEditable(false);
		add(new JLabel("In-Band-RMS: "), new GridBagConstraints(0, 3, 1, 1,
				0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(tfBandRMS, new GridBagConstraints(1, 3, 1, 1, 1.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));
		add(new JLabel("V"), new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
				GridBagConstraints.LINE_END, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel(), new GridBagConstraints(0, 4, 3, 1, 0.0, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(5, 5, 5, 5), 0, 0));

	}

	/**
	 * <pre>
	 * - Setzt den Text in den Textfeldern aufgrund der entsprechenden Werte im Model.
	 *   Frequenzen sind auf Herz gerundet, die Spannung auf 4 Stellen nach dem Komma.
	 * </pre>
	 * 
	 * @param obs
	 * @param obj
	 */
	public void update(Observable obs, Object obj) {
		// 4
		Model model = (Model) obs;
		tfBandStart.setText("" + Math.round(model.getLineMarkerLeft()));
		tfBandStop.setText("" + Math.round(model.getLineMarkerRight()));
		tfBandRMS.setText("" + Math.round(10000 * model.getRMS()) / 10000.0);
	}
}
