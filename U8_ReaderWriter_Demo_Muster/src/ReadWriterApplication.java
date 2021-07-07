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
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileFilter;

public class ReadWriterApplication extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JFileChooser jfcDialog = new JFileChooser(new File(".//"));
	private JTextArea jtArea = new JTextArea(20, 80);
	private JButton btLaden = new JButton("Laden");
	private JButton btSpeichern = new JButton("Speichern");
	private PrintWriter ausgabeDatei;
	private BufferedReader eingabeDatei;
	private BufferedReader tastatur;
	private String zeile;

	public ReadWriterApplication() {
		setLayout(new GridBagLayout());

		add(jtArea, new GridBagConstraints(0, 0, 3, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));

		btLaden.addActionListener(this);
		add(btLaden, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(new JLabel(), new GridBagConstraints(1, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		btSpeichern.addActionListener(this);
		add(btSpeichern, new GridBagConstraints(2, 1, 1, 1, 1.0, 0.0, GridBagConstraints.CENTER,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

		

		FileFilter filter = new FileNameExtensionFilter("TXT-Dateien", "txt", "TXT");
		jfcDialog.addChoosableFileFilter(filter);
		jfcDialog.setAcceptAllFileFilterUsed(true);
		
		FileFilter filter2 = new FileNameExtensionFilter("JAVA-Dateien", "java");
		jfcDialog.addChoosableFileFilter(filter2);

		tastatur = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Name:");
		try {
			zeile = tastatur.readLine();
			System.out.println("Du heisst: " + zeile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String dateiName = null;
		if (e.getSource() == btLaden) {
			int returnVal = jfcDialog.showOpenDialog(this);  //3. FileChooser beleben
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = jfcDialog.getSelectedFile();
				System.out.println("" + file.isDirectory());
				System.out.println("" + file.getName());
				System.out.println("" + file.getAbsolutePath());
				dateiName = file.getAbsolutePath();

				// dateiName = "Kurztest.txt";  1.mit fixem Name arbeiten
				try {
					eingabeDatei = new BufferedReader(new FileReader(dateiName));
					jtArea.setText("");
					String zeile;
					while ((zeile = eingabeDatei.readLine()) != null) {
						jtArea.append(zeile + "\n");
					}
					eingabeDatei.close();
				} catch (IOException exc) {
					System.err.println("Dateifehler: " + exc.toString());
					System.exit(1);
				}
			}
		}
		if (e.getSource() == btSpeichern) {
			int returnVal = jfcDialog.showSaveDialog(this); // file Choser beleben
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = jfcDialog.getSelectedFile();
				System.out.println("" + file.isDirectory());
				System.out.println("" + file.getName());
				System.out.println("" + file.getAbsolutePath());
				dateiName = file.getAbsolutePath();
				// dateiName = "Kurztest.txt"; 2. schreiben auf fixe Datei
				try {
					ausgabeDatei = new PrintWriter(new FileWriter(dateiName, false));
					ausgabeDatei.print(jtArea.getText());
					// ausgabeDatei.print(zeile);// schreibt eingelesene Zeile in Datei
					ausgabeDatei.close();
				} catch (IOException exc) {
					System.err.println("Dateifehler: " + exc.toString());
					System.exit(1);
				}
			}
		}
	}

	private void schreibeDatei(String[] zeilen, String dateiName) {
	}

	private String[] leseDatei(String dateiName) {

		return null;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception exception) {
					exception.printStackTrace();
				}

				ReadWriterApplication frame = new ReadWriterApplication();
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
