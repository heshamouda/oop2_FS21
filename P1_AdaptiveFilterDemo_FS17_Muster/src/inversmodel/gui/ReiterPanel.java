package inversmodel.gui;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.Observable;

import javax.swing.JTabbedPane;

import inversmodel.InverseModelDemo;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: Muster
//Vorname:

public class ReiterPanel extends JTabbedPane {
	// 6
	private static final long serialVersionUID = -7176405344277868872L;
	private ViewFrequenzBereich vFrequenzBereich = new ViewFrequenzBereich();
	private ViewZeitBereich vZeitBereich = new ViewZeitBereich();

	/**
	 * <pre>
	 * - Baut das GUI gemäss Aufgabenstellung.
	 * </pre>
	 * 
	 */
	public ReiterPanel() {
		// 3
//		super(JTabbedPane.TOP);

		setPreferredSize(
				new Dimension((int) (1.0 * InverseModelDemo.appWidth), (int) (0.6 * InverseModelDemo.appHeight)));

		addTab("Freuenzbereich", vFrequenzBereich);
		addTab("Zeitbereich", vZeitBereich);
	}

	/**
	 * Entsprechende Panel zum Aufdatieren aufrufen ...
	 * 
	 * <pre>
	 * - Entsprechende Methoden update() der beiden Panel aufrufen.
	 * </pre>
	 */
	public void update(Observable obs, Object obj) {
		// 2
		vFrequenzBereich.update(obs, obj);
		vZeitBereich.update(obs, obj);
	}

}
