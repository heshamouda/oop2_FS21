package sfd.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import sfd.model.Model;
import util.TraceV8;

public class Controller {
	private TraceV8 trace = new TraceV8(this);
	private Model model;
	private View view;
	private final JFileChooser jfChooser = new JFileChooser(new File(".\\"));
	private String newLine = System.lineSeparator();

	public Controller(Model model) {
		trace.constructorCall();
		this.model = model;
		jfChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		jfChooser.setMultiSelectionEnabled(false);
		jfChooser.addChoosableFileFilter(new FileNameExtensionFilter("NetList-Dateien", "net", "NET"));
	}

	public void setView(View view) {
		trace.methodeCall();
		this.view = view;
	}

	public void ladeNetzliste() throws IOException {
		trace.methodeCall();
		int returnVal = jfChooser.showOpenDialog(view);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = jfChooser.getSelectedFile();
			String dateiName = file.getAbsolutePath();
			String zeile, text = "";
//			Exception-Handling in der Klasse MeineMenuBar():
//			Methoden-Kopf muss um throws IOException ergänzt werden!
			{
				BufferedReader eingabeDatei = new BufferedReader(new FileReader(dateiName));
				while ((zeile = eingabeDatei.readLine()) != null) {
					zeile = zeile.trim();
					if (!zeile.equals("")) {
						text += zeile + newLine;
					}
				}
				eingabeDatei.close();
			}

//			Exception-Handling direkt im Controller ...
//			try {
//				BufferedReader eingabeDatei = new BufferedReader(new FileReader(dateiName));
//				while ((zeile = eingabeDatei.readLine()) != null) {
//					zeile = zeile.trim();
//					if (!zeile.equals("")) {
//						text += zeile + newLine;
//					}
//				}
//				eingabeDatei.close();
//			} catch (FileNotFoundException e) {
//				TraceV8.appendToPane("Fehler beim Öffnen der Datei", Color.BLUE);
//			} catch (IOException e) {			
//				TraceV8.appendToPane("Fehler beim Lesen oder Schliessen der Datei", Color.BLUE);				
//			} finally {
//				System.out.println("Finally");
//			}

			String block = split(text, "#netlist" + newLine);
			view.nlPanel.textArea.setText("#netlist" + newLine + block);
			model.setNetlist(block.split("[" + newLine + "]+"));

			block = split(text, "#signalflow" + newLine);
			view.sfPanel.textArea.setText("#signalflow" + newLine + block);
			model.setSignalflow(block.split("[" + newLine + "]+"));

			block = split(text, "#loops" + newLine);
			view.sfPanel.textArea.append("#loops" + newLine + block);
			model.setLoops(block.split("[" + newLine + "]+"));

			model.berechne();
		}
	}

	/**
	 * <pre>
	 * - Information aus den beiden JTextAreas in Datei speichern
	 * </pre>
	 */
	public void speichereNetzliste() {
		trace.methodeCall();
		if (jfChooser.showOpenDialog(view) == JFileChooser.APPROVE_OPTION) {
			String dateiName = jfChooser.getSelectedFile().getAbsolutePath();
			try {
				PrintWriter ausgabeDatei = new PrintWriter(new FileWriter(dateiName, false));
				ausgabeDatei.println(view.nlPanel.textArea.getText() + newLine);
				ausgabeDatei.println(view.sfPanel.textArea.getText());
				ausgabeDatei.close();
			} catch (IOException e) {
				System.err.println("Dateifehler: " + e.toString());
			}
		}
	}

	/**
	 * <pre>
	 * - Falls die Zeichenkette s die Zeichenkette splitter nicht enthält:
	 *   - "Illegales Dateiformat" zurück geben.
	 * - Sonst:
	 *   - Den Text von und exklusive die Zeichenkette splitter bis zum nächsten # oder bis zum Textende zurück.
	 * </pre>
	 * 
	 * @param s
	 * @param splitter
	 * @return
	 */
	private String split(String s, String splitter) {
		trace.methodeCall();
		if (s.indexOf(splitter) < 0) {
			return "Illegales Dateiformat";
		} else {
			s = s.substring(s.indexOf(splitter) + (splitter).length());
			if (s.indexOf('#') > 0)
				return s.substring(0, s.indexOf('#') - 1) + newLine;
			else
				return s + newLine;
		}
	}
}
