import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MeineMenuBar extends JMenuBar implements ActionListener {
	TraceV8 trace = new TraceV8(this);
	private static final long serialVersionUID = 1L;
	private JMenu menuDatei = new JMenu("Datei");
	private JMenuItem ladenItem = new JMenuItem("Datei öffnen");
	private JMenuItem speichernItem = new JMenuItem("Datei Speichern");
	private JMenuItem exitItem = new JMenuItem("Exit");
	private ReadWriterApplication readWriterApplication;

	private final JFileChooser jfcLaden = new JFileChooser(new File(".\\"));

	public MeineMenuBar(ReadWriterApplication readWriterApplication) {
		trace.constructorCall();
		this.readWriterApplication = readWriterApplication;
		ladenItem.addActionListener(this);
		menuDatei.add(ladenItem);
		speichernItem.addActionListener(this);
		menuDatei.add(speichernItem);
		menuDatei.addSeparator();
		exitItem.addActionListener(this);
		menuDatei.add(exitItem);

		add(menuDatei);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		trace.eventCall();
		if (e.getSource() == exitItem) {
			System.exit(0);
		}
		if (e.getSource() == ladenItem) {
			int returnVal = jfcLaden.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = jfcLaden.getSelectedFile();
				String[] text = readWriterApplication.leseDatei(file.getAbsolutePath());
				for (int i = 0; i < text.length; i++) {
					readWriterApplication.jtArea.append(text[i]);
				}
				System.out.println("" + file.isDirectory());
				System.out.println("" + file.getName());
				System.out.println("" + file.getAbsolutePath());
			}
		}
	}
}
