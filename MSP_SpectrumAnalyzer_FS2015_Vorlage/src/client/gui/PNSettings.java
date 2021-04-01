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

import common.AnalyzerConstants;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name:
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
	 * - Baut die Benutzerschnittstelle gem�ss Beschreibung in der Aufgabenstellung. Der JSpinner 
	 *   verf�gt �ber die Werte 512, 1024, 2048 und 4096 und ist gem�ss Beispiel - Code in der 
	 *   Aufgabenstellung zu realisieren.
	 * </pre>
	 * 
	 * @param ctrl
	 */
	public PNSettings(Controller ctrl) {
	}

	/**
	 * <pre>
	 * - Ruft zugeh�rige Methode im Controller, mit der Zeichenkette des gew�hlten Items 
	 *   der JComboBox auf.
	 * </pre>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	}

	/**
	 * <pre>
	 * - Ruft zugeh�rige Methode im Controller, mit gew�hlter Buffer - L�nge auf.
	 * </pre>
	 */
	@Override
	public void stateChanged(ChangeEvent e) {
	}
}
