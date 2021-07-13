package sfd;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import sfd.gui.Controller;
import util.TraceV8;

public class MeineMenuBar extends JMenuBar implements ActionListener {
	TraceV8 trace = new TraceV8(this);
	private static final long serialVersionUID = 1L;
	private JMenu menuDatei = new JMenu("Datei");
	private JMenuItem ladenItem = new JMenuItem("Datei öffnen");
	private JMenuItem speichernItem = new JMenuItem("Datei speichern");
	private JMenuItem exitItem = new JMenuItem("Exit");

	private Controller controller;

	public MeineMenuBar(Controller controller) {
		trace.constructorCall();
		this.controller = controller;
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
//			Exception-Handling in der Klasse MeineMenuBar()
			try {
				controller.ladeNetzliste();
			} catch (FileNotFoundException ex) {
				TraceV8.appendToPane("Fehler beim Öffnen der Datei!", Color.BLUE);
				JOptionPane.showMessageDialog(getParent(), "Fehler beim Öffnen der Datei!",
						"FileNotFoundException", JOptionPane.ERROR_MESSAGE);
			} catch (IOException ex) {
				TraceV8.appendToPane("Fehler beim Lesen oder Schliessen der Datei!", Color.BLUE);
				JOptionPane.showMessageDialog(getParent(), "Fehler beim Lesen oder Schliessen der Datei!",
						"FileNotFoundException", JOptionPane.ERROR_MESSAGE);
			} finally {
//				System.out.println("Finally");
			}
//			Exception-Handling in der Klasse Controller()
//			controller.ladeNetzliste();
		}
		if (e.getSource() == speichernItem) {
			controller.speichereNetzliste();
		}
	}
}
