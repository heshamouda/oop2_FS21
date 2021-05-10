package modem.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import modem.gui.goodies.BDGPanel;

// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiderhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:

public class View extends JPanel implements Observer {
	// 8
	private static final long serialVersionUID = 1L;
	private BDGPanel bdgPanel;
	public ParameterPanel parameterPanel;
	private ReiterPanel reiterPanel;

	/**
	 * <pre>
	 * - Baut das GUI gem‰ﬂ Aufgabenstellung.
	 * </pre>
	 * 
	 * @param controller
	 * 
	 */
	public View(Controller controller) {
		// 7
		super(new GridBagLayout());

		parameterPanel = new ParameterPanel(controller);
		add(parameterPanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		bdgPanel = new BDGPanel("BDGModem.png");
		add(bdgPanel, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));

		reiterPanel = new ReiterPanel();
		add(reiterPanel, new GridBagConstraints(0, 1, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));
	}

	/**
	 * <pre>
	 * - Ruft entsprechende Methode update() des beheimateten Panels auf.
	 * </pre>
	 */
	public void update(Observable obs, Object obj) {
		// 1
		reiterPanel.update(obs, obj);
	}

}
