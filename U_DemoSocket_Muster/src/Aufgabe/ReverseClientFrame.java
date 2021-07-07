package Aufgabe;

import java.net.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

/**
 * This program demonstrates a simple TCP/IP socket client that reads input from
 * the user and prints echoed message from the server in a Client GUI.
 *
 * @author www.codejava.net
 * @author stefan.gorenflo
 */

class ClientPanel extends JPanel {

	public JTextField tftext = new JTextField(30);
	public JTextField tfreverse = new JTextField(30);

	public ClientPanel() {
		super(new BorderLayout());
		setPreferredSize(new Dimension(400, 300));

		add(tftext, BorderLayout.NORTH);
		add(tfreverse, BorderLayout.SOUTH);

	}

}

public class ReverseClientFrame extends JFrame {

	private ClientPanel clientPanel = new ClientPanel();

	public ReverseClientFrame() {
		setLayout(new BorderLayout());
		add(clientPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);

	}

	public static void main(String[] args) {

		ReverseClientFrame client = new ReverseClientFrame();
		client.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		client.pack();
		client.setVisible(true);
		client.setTitle("Client");
		client.clientCommunication();

	}

	void clientCommunication() {
		String hostname = "localhost";
		// String hostname = "192.168.178.49"; //Raspi
		String text;
		String reverseText;
		int port = 6868;
		try (Socket server = new Socket(hostname, port)) {// try with resources
			// hier alle Outputstreams und Inputstreams erzeugen

			PrintWriter writer = new PrintWriter(new OutputStreamWriter(server.getOutputStream()));
			BufferedReader reader = new BufferedReader(new InputStreamReader(server.getInputStream()));

			// Mit do-while solange text nicht "bye":
			// -text aus Textfeld tftext einlesen und mit PrintWriter in den Stream
			// schreiben
			// -reversetext aus dem Stream lesen und in Textfeld tfreverse schreiben

			do {
				text = clientPanel.tftext.getText();

				writer.println(text);
				writer.flush();

				reverseText = reader.readLine();

				clientPanel.tfreverse.setText(reverseText);

			} while (!text.equals("bye"));

			// Schliessen der Ressourcen
			// mit 2 Sekunden Verzögerung Fenster schliessen
			writer.close();
			reader.close();

			try {
				Thread.sleep(2000);

				System.exit(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (UnknownHostException ex) {

			System.out.println("Server not found: " + ex.getMessage());

		} catch (IOException ex) {

			System.out.println("I/O error: " + ex.getMessage());
		}
	}

}
