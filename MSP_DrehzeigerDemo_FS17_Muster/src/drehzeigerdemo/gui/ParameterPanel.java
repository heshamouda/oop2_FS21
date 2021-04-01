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
//Name: Muster
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
		super(new GridBagLayout());
		setPreferredSize(new Dimension((int) (0.25 * DrehzeigerDemoApplikation.appWidth),
				(int) (DrehzeigerDemoApplikation.appHeight)));
		this.controller = controller;
		setBorder(MyBorderFactory.createMyBorder(" ParameterPanel: Einstellungen "));

		add(new JLabel("Signalform: "), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(jcbSignalForm, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		tfAmplitude.setHorizontalAlignment(SwingConstants.RIGHT);
		add(new JLabel("Amplitude: "), new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(tfAmplitude, new GridBagConstraints(0, 3, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		tfFrequenz.setHorizontalAlignment(SwingConstants.RIGHT);
		add(new JLabel("Frequenz: "), new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(tfFrequenz, new GridBagConstraints(0, 5, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel("Anzahl Linien: "), new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0, GridBagConstraints.LINE_START,
				GridBagConstraints.NONE, new Insets(5, 5, 5, 5), 0, 0));
		add(jspAnzahlLinien, new GridBagConstraints(0, 7, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		btUebernehmen.addActionListener(this);
		add(btUebernehmen, new GridBagConstraints(0, 9, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		add(new JLabel(""), new GridBagConstraints(0, 10, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		jspAnzahlLinien.addMouseWheelListener(this);
		btUebernehmen.doClick();
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
		String signalForm = (String) jcbSignalForm.getSelectedItem();
		double amplitude = Double.parseDouble(tfAmplitude.getText());
		double frequenz = Double.parseDouble(tfFrequenz.getText());
		int anzahlLinien = spinnerNumberModel.getNumber().intValue();

		controller.setParameter(signalForm, amplitude, frequenz, anzahlLinien);
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
		if (e.getWheelRotation() > 0) {
			if (jspAnzahlLinien.getNextValue() != null)
				jspAnzahlLinien.setValue(jspAnzahlLinien.getNextValue());
		} else {
			if (jspAnzahlLinien.getPreviousValue() != null)
				jspAnzahlLinien.setValue(jspAnzahlLinien.getPreviousValue());
		}
	}
}
