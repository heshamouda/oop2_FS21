package soundeditor.gui;

// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: MUSTER
// Vorname:
// Klasse:
//
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import tools.MyBorderFactory;

public class View extends JPanel implements ActionListener, Observer {
	// 20
	private static final long serialVersionUID = 1L;
	private JTabbedPane jTabbedPane = new JTabbedPane();

	protected EchoPanel echoPanel = new EchoPanel();
	protected EqualizerPanel equalizerPanel = new EqualizerPanel();
	private SignalPanel signalPanel;

	private JButton jbtRevert = new JButton(" Revert ");
	private JButton jbtApply = new JButton(" Apply ");

	private Controller controller;

	/**
	 * - Baut User-Interface gemäss Aufgabenstellung.
	 * 
	 * <pre>
	 * - Achten Sie darauf, dass alle Komponenten erzeugt sind bevor Sie sie hinzufügen.
	 * - Fügen Sie die Panels signalPanel, echoPanel und equalizerPanel je mittels
	 *   jTabbedPane.add(" Tab-Text ", panel) dem JTabbedPane hinzu.
	 * - Fügen Sie in der Folge das JTabbedPane sowie die JButton zur View hinzu.
	 * - Registrieren Sie allfällige Listener.
	 * - Setzen sie allfällige Attribute.
	 * </pre>
	 * 
	 * @param controller
	 */
	public View(Controller controller) {
		super(new GridBagLayout());
		// 11
		this.controller = controller;
		setBorder(MyBorderFactory.createMyBorder(" View "));

		signalPanel = new SignalPanel(controller);
		jTabbedPane.add(" Signal ", signalPanel);
		jTabbedPane.add(" Echo ", echoPanel);
		jTabbedPane.add(" Equalizer ", equalizerPanel);

		add(jTabbedPane, new GridBagConstraints(0, 0, 2, 1, 1.0, 1.0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 5), 0, 0));

		jbtRevert.addActionListener(this);
		add(jbtRevert, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));

		jbtApply.addActionListener(this);
		add(jbtApply, new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
	}

	/**
	 * <pre>
	 * - Mittels entsprechender Methode des Controllers den Player stoppen.
	 * - Falls die Quelle des Ereignisses gleich dem Apply-Button:
	 *   - Falls getSelectedComponent() des Tabbed-Pane gleich dem Echo-Panel:
	 *     - Entsprechende Methode des Controllers aufrufen.
	 *   - Falls getSelectedComponent() des Tabbed-Pane gleich dem Equalizer-Panel:
	 *     - Entsprechende Methode des Controllers aufrufen.
	 *   - SelectedIndex des Tabbed-Pane auf Null setzen.
	 * - Falls die Quelle des Ereignisses gleich dem Revert-Button:
	 *   - Entsprechende Methode des Controllers aufrufen.
	 * </pre>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// 9
		controller.stopPlayer();
		if (e.getSource() == jbtApply) {
			if (jTabbedPane.getSelectedComponent() == echoPanel) {
				controller.echoSoundTrack();
			}
			if (jTabbedPane.getSelectedComponent() == equalizerPanel) {
				controller.equalizeSoundTrack();
			}
			jTabbedPane.setSelectedIndex(0);
		}
		if (e.getSource() == jbtRevert) {
			controller.revert();
		}
	}

	public void update(Observable obs, Object obj) {
		if (signalPanel != null)
			signalPanel.update(obs, obj);
	}
}
