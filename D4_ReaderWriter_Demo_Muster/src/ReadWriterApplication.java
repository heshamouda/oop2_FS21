import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ReadWriterApplication extends JFrame implements ActionListener {
	private TraceV8 trace = new TraceV8(this);
	private static final long serialVersionUID = 4794428813076429487L;
	private final JFileChooser jfChooser = new JFileChooser(new File("./"));
	public JTextArea jtArea = new JTextArea(40, 80);
	private JButton btLaden = new JButton("Laden");
	private JButton btSpeichern = new JButton("Speichern");
	private MeineMenuBar meineMenuBar = new MeineMenuBar(this);

	public ReadWriterApplication() {
		trace.constructorCall();
		setLayout(new GridBagLayout());
		JScrollPane scroll = new JScrollPane(jtArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		add(scroll, new GridBagConstraints(0, 0, 3, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));

		btLaden.addActionListener(this);
		add(btLaden, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(new JLabel(), new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		btSpeichern.addActionListener(this);
		add((AbstractButton) btSpeichern, new GridBagConstraints(2, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

		btLaden.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		setJMenuBar(meineMenuBar);

		pack();
		setVisible(true);

		jfChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jfChooser.setMultiSelectionEnabled(false);
		jfChooser.addChoosableFileFilter(new FileNameExtensionFilter("TXT-Dateien", "txt", "TXT"));
		jfChooser.addChoosableFileFilter(new FileNameExtensionFilter("JAVA-Dateien", "java"));
		jfChooser.setAcceptAllFileFilterUsed(false); // Für "Alle Dateien" aus ...
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		trace.eventCall();
		System.out.println("" + e.getSource());

		if (e.getSource() == btLaden) {
			String dateiName = "Witze.txt";
			try {
				BufferedReader eingabeDatei = new BufferedReader(new FileReader(dateiName));
				jtArea.setText("");
				String zeile;
				while ((zeile = eingabeDatei.readLine()) != null) {
					jtArea.append(zeile + "\n");
				}
				eingabeDatei.close();
			} catch (IOException exc) {
				System.err.println("Dateifehler: " + e.toString());
				System.exit(1);
			}
		}

		if (e.getSource() == btSpeichern) {
			String dateiName = "WitzeSave.txt";
			try {
				PrintWriter ausgabeDatei = new PrintWriter(new FileWriter(dateiName, false));
				ausgabeDatei.print(jtArea.getText());
				ausgabeDatei.close();
			} catch (IOException exc) {
				System.err.println("Dateifehler: " + e.toString());
			}
		}
	}

	public void schreibeDatei(String[] zeilen, String dateiName) {
		trace.methodeCall();
		try {
			PrintWriter ausgabeDatei = new PrintWriter(new FileWriter(dateiName, false));

			for (int i = 0; i < zeilen.length; i++) {
				ausgabeDatei.println(zeilen[i]);
			}
			ausgabeDatei.close();
		} catch (IOException exc) {
			System.err.println("Dateifehler: " + exc.toString());
		}
	}

	public String[] leseDatei(String dateiName) {
		trace.methodeCall();
		String[] str = null;
		try {
			// Anzahl Zeilen zählen:
			BufferedReader eingabeDatei = new BufferedReader(new FileReader(dateiName));
			int cnt = 0;
			while (eingabeDatei.readLine() != null) {
				cnt++;
			}
			eingabeDatei.close();
			// Gezählte Anzahl Zeile lesen:
			eingabeDatei = new BufferedReader(new FileReader(dateiName));
			str = new String[cnt];
			for (int i = 0; i < str.length; i++) {
				str[i] = eingabeDatei.readLine();
			}
			eingabeDatei.close();
		} catch (IOException exc) {
			System.err.println("Dateifehler: " + exc.toString());
		}
		return str;
	}

	public static void main(String args[]) {
		TraceV8.mainCall();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				ReadWriterApplication demo = new ReadWriterApplication();
				demo.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
			}
		});
	}
}
