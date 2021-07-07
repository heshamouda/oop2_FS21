package Aufgabe;
import java.io.*;
import java.net.*;

/**
 * This program demonstrates a simple TCP/IP socket server that echoes every
 * message from the client in reversed form. This server is single-threaded.
 * https://www.codejava.net/java-se/networking/java-socket-server-examples-tcp-ip
 * 
 * @author www.codejava.net
 */
public class ReverseServer {

	public static void main(String[] args) {

		String text;
		String reverseText;
		int port = 6868;

		try (ServerSocket serverSocket = new ServerSocket(port)) {

			System.out.println("Server is listening on port " + port);

			while (true) {

				// - auf Anmeldung Clients warten und als Konsolenausgabe bestätigen
				// - alle Outputstreams und Inputstreams erzeugen
				Socket client = serverSocket.accept();
				System.out.println("New client connected");
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));

				
				// Mit do-while:solange text nicht "bye":
				// -text aus Inputstream lesen Stream
				// -reverseText mit new StringBuilder(text).reverse().toString() erzeugen
				// -reversetext in Stream schreiben

				do {

					text = reader.readLine();
					reverseText = new StringBuilder(text).reverse().toString();
					writer.println("Server: " + reverseText);
					writer.flush();

				} while (!text.equals("bye"));

				// Schliessen der Ressourcen
				// konsolenausgabe: "client disconnected"
				writer.close();
				reader.close();
				client.close();

				System.out.println("client disconnected");

			}

		} catch (IOException ex) {
			System.out.println("Server exception: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}