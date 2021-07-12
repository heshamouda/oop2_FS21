// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
// Modulanlass:

package aktivrcbandpass.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerListModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import aktivrcbandpass.model.Model;
import util.MyBorderFactory;
import util.Observable;
import util.TraceV7;

public class InputPanel extends JPanel implements ActionListener, ChangeListener {
	private static final long serialVersionUID = 1L;
	// 33
	private TraceV7 trace = new TraceV7(this);
	public JTextField tfF = new JTextField("10e3");
	public JTextField tfQ = new JTextField("10.0");
	public JTextField tfR = new JTextField("1.591549431E7");
	private Controller controller;
	private String[] stE12 = new String[] { "1.0", "1.2", "1.5", "1.8", "2.2", "2.7", "3.3", "3.9", "4.7", "5.6", "6.8",
			"8.2" };
	public JSpinner valueSpinner = new JSpinner(new SpinnerListModel(expandReihe(stE12)));
	public JSpinner prefixSpinner = new JSpinner(new SpinnerListModel(new String[] { "pF", "nF", "\u03BCF" }));

	/**
	 * <pre>
	 * - Baut das User-Interface gemäss Angaben in der Aufgabenstellung.
	 * - Setzt mittels tfF.setActionCommand("F") das ActionCommand des Textfeldes auf "F" 
	 *   und die restlichen ActionCommands der Textfelder entsprechend auf "Q" und "R".
	 * - Setzt entsprechendes Attribut.
	 * </pre>
	 * 
	 * @param controller
	 */
	public InputPanel(Controller controller) {
		super(new GridBagLayout());
		trace.constructorCall();
		// 21

		setBorder(MyBorderFactory.createMyBorder(" InputPanel "));
		this.controller = controller;

		int z = 0;
		add(new JLabel("Resonanzfrequenz: "), new GridBagConstraints(0, z, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(tfF, new GridBagConstraints(1, z, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 10, 10), 0, 0));
		add(new JLabel("Hz"), new GridBagConstraints(2, z, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		tfF.addActionListener(this);
		tfF.setActionCommand("F");

		z = 1;
		add(new JLabel("Guete: "), new GridBagConstraints(0, z, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(tfQ, new GridBagConstraints(1, z, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 10, 10), 0, 0));
		tfQ.addActionListener(this);
		tfQ.setActionCommand("Q");

		z = 2;
		add(new JLabel("R: "), new GridBagConstraints(0, z, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(tfR, new GridBagConstraints(1, z, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 10, 10), 0, 0));
		add(new JLabel("\u03A9"), new GridBagConstraints(2, z, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		tfR.addActionListener(this);
		tfR.setActionCommand("R");

		z = 3;
		add(new JLabel("C: "), new GridBagConstraints(0, z, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(valueSpinner, new GridBagConstraints(1, z, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(prefixSpinner, new GridBagConstraints(2, z, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		valueSpinner.addChangeListener(this);
		prefixSpinner.addChangeListener(this);

		valueSpinner.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				Object value = null;
				if (e.getWheelRotation() > 0)
					value = valueSpinner.getNextValue();
				if (e.getWheelRotation() < 0)
					value = valueSpinner.getPreviousValue();
				if (value != null)
					valueSpinner.setValue(value);
			}
		});
	}

	/**
	 * - Expandiert die E-Reihe der Art, dass in einem neuen Zeichenketten-Array die
	 * 36 Werte von "1.0" bis "820.0" stehen:
	 * 
	 * <pre>
	 * - Erzeugt einen lokalen String-Array res der dreifachen Länge von eReihe.
	 * - Deklariert einen lokalen double-Wert faktor gleich 1.
	 * - Für k gleich Null bis kleiner 3:
	 *   - Für i = Null bis kleiner der Länge der eReihe: 
	 *     - res and der Stelle (i plus k mal Länge der eReihe) gleich dem, auf eine Stellen gerundeten Wert,
	 *       von eReihe an der Stelle i mal faktor, setzen.
	 *       Hinweis: res und eReihe sind Arrays mit Zeichenketten. Sie müssen entsprechend gewandelt werden.
	 *   - faktor gleich faktor mal 10.0 setzen.
	 * - res mittels return zurückgeben.
	 * </pre>
	 * 
	 * - Die Methode kann in der Folge direkt beim Erzeugen des Spinners verwendet
	 * werden.
	 * 
	 * @param eReihe
	 * @return
	 */
	private String[] expandReihe(String[] eReihe) {
		trace.methodeCall();
		// 7
		String[] res = new String[eReihe.length * 3];

		double faktor = 1.0;
		for (int k = 0; k < 3; k++) {
			for (int i = 0; i < eReihe.length; i++) {
				res[i + k * eReihe.length] = "" + Math.round(10.0 * Double.parseDouble(eReihe[i]) * faktor) / 10.0;
			}
			faktor *= 10.0;
		}
		return res;
	}

	/**
	 * 
	 * <pre>
	 * - Holt mittels getParameter() die Parameter aus dem Model und setzt die 
	 *   entsprechenden Werte gerundet in die TextFelder. Schauen Sie sich die 
	 *   Methode im Model an!
	 * </pre>
	 * 
	 * @param obs
	 * @param obj
	 */
	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		// 5
		Model model = (Model) obs;
		double[] para = model.getParameter();
		tfF.setText("" + Math.round(para[Model.F]));
		tfQ.setText("" + Math.round(para[Model.Q]));
		tfR.setText("" + Math.round(para[Model.R]));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		trace.eventCall();
		controller.aktion(e.getActionCommand());
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		trace.eventCall();
		controller.aktion("C");
	}
}
