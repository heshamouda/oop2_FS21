import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileFilter;

public class ReadWriterApplication2 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JFileChooser jfcDialog = new JFileChooser(new File(".//"));
	private JTextArea jtArea = new JTextArea(20, 80);
	private JButton btLaden = new JButton("Laden");
	private JButton btSpeichern = new JButton("Speichern");
	private PrintWriter ausgabeDatei;
	private BufferedReader eingabeDatei;

	public ReadWriterApplication2() {
		setLayout(new GridBagLayout());
		
		JScrollPane scroll = new JScrollPane(jtArea);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		add(scroll, new GridBagConstraints(0, 0, 3, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));

//		add(jtArea, new GridBagConstraints(0, 0, 3, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
//				new Insets(10, 10, 10, 10), 0, 0));

		btLaden.addActionListener(this);
		add(btLaden, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(new JLabel(), new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		btSpeichern.addActionListener(this);
		add(btSpeichern, new GridBagConstraints(2, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

		// jfcDialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		FileFilter filter = new FileNameExtensionFilter("TXT-Dateien", "txt", "TXT");
		jfcDialog.addChoosableFileFilter(filter);
//		filter = new FileNameExtensionFilter("JAVA-Dateien", "java");
//		jfcDialog.addChoosableFileFilter(filter);
		jfcDialog.setAcceptAllFileFilterUsed(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String dateiName = null;
		if (e.getSource() == btLaden) {
			int returnVal = jfcDialog.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = jfcDialog.getSelectedFile();
				System.out.println("" + file.isDirectory());
				System.out.println("" + file.getName());
				System.out.println("" + file.getAbsolutePath());
				dateiName = file.getAbsolutePath();

				String[] zeilen = leseDatei(dateiName);

				jtArea.setText("");
				for (int i = 0; i < zeilen.length; i++) {
					jtArea.append(zeilen[i] + "\n");
				}

			}
		}
		if (e.getSource() == btSpeichern) {

			int returnVal = jfcDialog.showSaveDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = jfcDialog.getSelectedFile();
				System.out.println("" + file.isDirectory());
				System.out.println("" + file.getName());
				System.out.println("" + file.getAbsolutePath());
				dateiName = file.getAbsolutePath();
				String text = jtArea.getText();
				String[] zeilen = text.split("[\n]+");// schreibt in jedes Element von zeilen eine zeile (bis
														// newfeet).The + after treats consecutive delimiter chars as
														// one
				schreibeDatei(zeilen, dateiName);
			}

		}

	}

	private void schreibeDatei(String[] zeilen, String dateiName) {
		try {
			ausgabeDatei = new PrintWriter(new FileWriter(dateiName, false));
			for (int i = 0; i < zeilen.length; i++) {
				ausgabeDatei.print(zeilen[i] + "\n");
			}
			ausgabeDatei.close();
		} catch (IOException exc) {
			System.err.println("Dateifehler: " + exc.toString());
			System.exit(1);
		}
	}

	private String[] leseDatei(String dateiName) {
		// Vorteil: Daten stehen für weitere Aktionen zur Verfügung
		String[] zeilen = {};
		int counter = 0;

		try {
			eingabeDatei = new BufferedReader(new FileReader(dateiName));
			// Zunächst Zeilen zählen für Array Initialisierung
			while ((eingabeDatei.readLine()) != null) {
				counter++;
			}

			eingabeDatei.close();

			// Zeilen einlesen und in zeilen[] abspeichern
			zeilen = new String[counter];
			eingabeDatei = new BufferedReader(new FileReader(dateiName));
			for (int i = 0; i < zeilen.length; i++) {
				zeilen[i] = eingabeDatei.readLine();
			}
			eingabeDatei.close();
			
		} catch (IOException exc) {
			System.err.println("Dateifehler: " + exc.toString());
			System.exit(1);
		}
		return zeilen;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception exception) {
					exception.printStackTrace();
				}

				ReadWriterApplication2 frame = new ReadWriterApplication2();
				frame.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(1);
					}
				});
				frame.setTitle(" Read - Writer - Demo ");
				frame.pack();
				frame.setMinimumSize(frame.getPreferredSize());
				frame.setVisible(true);
				frame.setResizable(true);
				frame.setLocationRelativeTo(null);
			}
		});
	}
}
