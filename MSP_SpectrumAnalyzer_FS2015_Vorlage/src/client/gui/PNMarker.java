package client.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name:
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
	}
}
