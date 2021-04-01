package drehzeigerdemo.gui;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import drehzeigerdemo.DrehzeigerDemoApplikation;
import drehzeigerdemo.model.Model;
import resources.MyBorderFactory;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: 
//Vorname:

public class ParameterPanel extends JPanel implements ActionListener, MouseWheelListener {
	// 24 + 6
	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private JComboBox jcbSignalForm = new JComboBox(new String[] { Model.RECHTECK, Model.DREIECK, Model.SAEGEZAHN });
	private JTextField tfAmplitude = new JTextField("0.5");
	private JTextField tfFrequenz = new JTextField("0.1");
	private SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(33, 3, 127, 2);
	private JSpinner jspAnzahlLinien = new JSpinner(spinnerNumberModel);
	private JButton btUebernehmen = new JButton("Übernehmen");
	private Controller controller;

	/**
	 * <pre>
	 * - Setzt bevorzugte Grösse auf (25% von DrehzeigerDemoApplikation.appWidth, 100% von DrehzeigerDemoApplikation.appHeight).
	 * - Setzt entsprechendes Attribut.
	 * - Baut das GUI gemäss Aufgabenstellung.
	 * - Löst doClick() des Buttons aus.
	 * </pre>
	 * 
	 * @param controller
	 *            Referenz des Controllers.
	 */
	public ParameterPanel(Controller controller) {
		// 19
	}

	/**
	 * <pre>
	 * - Holt die entsprechende Information aus den GUI - Elementen und ruft 
	 *   setParameter() des Controllers auf.
	 * </pre>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// 5
	}

	/**
	 * <pre>
	 * Challenge:
	 * - Ergänzen Sie den Code so, dass sich der Spinner mit dem Mausrad 
	 *   verändern lässt. Tipp für die Zutaten: getWheelRotation(), getNextValue(), 
	 *   setValue(), getPreviousValue() oder so ;-) ...
	 * </pre>
	 */
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// 6
	}
}
