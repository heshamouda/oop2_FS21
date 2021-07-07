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

		try (ServerSocket serverSocket = new ServerSocket(port)) {// try with resources

			System.out.println("Server is listening on port " + port);

			while (true) {

				// - auf Anmeldung Clients warten und als Konsolenausgabe bestätigen
				// - alle Outputstreams und Inputstreams erzeugen

				// ------------------------------

				// Mit do-while:solange text nicht "bye":
				// -text aus Inputstream lesen Stream
				// -reverseText mit new StringBuilder(text).reverse().toString() erzeugen
				// -reversetext in Stream schreiben

				do {

				} while (true);// damit compiler glücklich

				// Schliessen der Ressourcen
				// konsolenausgabe: "client disconnected"

			}

		} catch (IOException ex) {
			System.out.println("Server exception: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}