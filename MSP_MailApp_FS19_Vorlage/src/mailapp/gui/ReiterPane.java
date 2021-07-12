package mailapp.gui;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import mailapp.model.Model;
import util.Observable;
import util.TraceV7;

public class ReiterPane extends JTabbedPane {
	private TraceV7 trace = new TraceV7(this);
	private static final long serialVersionUID = 1L;
	public AliasPanel aliasPanel;
	public ListPanel listPanel;
	public MailPanel mailPanel;

	public ReiterPane(Controller controller) {
		trace.constructorCall();
		listPanel = new ListPanel(controller);
		aliasPanel = new AliasPanel(controller);
		mailPanel = new MailPanel(controller);

		addTab("Liste", listPanel);
		addTab("Alias", new JScrollPane(aliasPanel));
		addTab("Mail", mailPanel);

		enabled(false);
	}

	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		Model model = (Model) obs;
		if (model.getMailListe().length != 0) {
			enabled(true);
		} else {
			enabled(false);
		}
		aliasPanel.update(obs, obj);
		mailPanel.update(obs, obj);
	}

	private void enabled(boolean b) {
		setEnabledAt(1, b);
		setEnabledAt(2, b);
	}
}
