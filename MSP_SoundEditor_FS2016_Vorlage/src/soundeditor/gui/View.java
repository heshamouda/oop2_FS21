package soundeditor.gui;

// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
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
	}

	public void update(Observable obs, Object obj) {
		if (signalPanel != null)
			signalPanel.update(obs, obj);
	}
}
