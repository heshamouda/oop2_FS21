package Aufgabe;

import java.io.*;
import java.net.*;

/**
 * This thread is responsible to handle client connection.
 *
 * @author www.codejava.net
 */
public class ServerThread extends Thread {
	private Socket client;
	String text;
	String reverseText;

	public ServerThread(Socket client) {
		this.client = client;
	}

	public void run() {
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));

			PrintWriter writer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));

			// ------------------------------

			// Mit do-while:solange text nicht "bye":
			// -text aus Inputstream lesen Stream
			// -reverseText mit new StringBuilder(text).reverse().toString() erzeugen
			// -reversetext in Stream schreiben

			do {
				text = reader.readLine();
				reverseText = new StringBuilder(text).reverse().toString();
				writer.println("Server: " + reverseText);
				writer.flush();
			} while (!text.equals("bye"));// damit compiler glücklich

			// Schliessen der Ressourcen
			// konsolenausgabe: "client disconnected"
			writer.close();
			reader.close();
			client.close();
			System.out.println("client disconnected");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}