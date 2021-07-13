//Name: Muster
//Vorname:
//Klasse:

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

class TopView extends JPanel implements Observer {
	// 7 + 2 = 9 Pte
	public PanelTransformPlot panelTransformPlot;
	private PanelTransformWahl panelTRWahl;
	private PanelSignalWahl panelSignalWahl;

	/**
	 * - Ist als GridBagLayout organisiert!
	 * - Setzt Border mit Titel " Top View ".
	 * - Erzeugt die drei Panel.
	 * - Setzt die Panel mittels add() aufs Panel.  
	 * 
	 * @param controller
	 */
	public TopView(Controller controller) {
		super(new GridBagLayout());
		// 8 Pte
		setBorder(MyBorderFactory.createMyBorder(" Top View "));
		panelTransformPlot = new PanelTransformPlot();
		panelTRWahl = new PanelTransformWahl(controller);
		panelSignalWahl = new PanelSignalWahl(controller);

		add(panelTransformPlot, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0));

		add(panelTRWahl, new GridBagConstraints(1, 0, 1, 1, 0.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
				new Insets(10, 10, 10, 10), 0, 0));

		add(panelSignalWahl, new GridBagConstraints(0, 1, 2, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
	}

	/**
	 * - Ruft update() des Panels mit den Plots auf.
	 * - Löst ein neu Zeichnen aus.
	 */
	public void update(Observable obs, Object arg) {
		// 2 Pte
		panelTransformPlot.update(obs, arg);
		repaint();
	}
}
