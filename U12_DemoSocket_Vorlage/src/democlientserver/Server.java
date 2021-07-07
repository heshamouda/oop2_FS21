package democlientserver;
//https://de.wikibooks.org/wiki/Java_Standard:_Socket_und_ServerSocket_(java.net)

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
		Server server = new Server();
		try {
			server.test();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void test() throws IOException {
		int port = 11112;
		// Server mit definiertem Port erzeugen
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("Server gestartet");
		
		while (true) {
			// horch was kommt von draussen rein
			
			Socket client = warteAufAnmeldung(serverSocket);
			System.out.println(client);

			String nachricht = leseNachricht(client);
			System.out.println(nachricht);

			schreibeNachricht(client, "Message from Server ...");

			client.close();
		}
	}

	Socket warteAufAnmeldung(ServerSocket serverSocket) throws IOException {
		
		return null;
	}

	String leseNachricht(Socket socket) throws IOException {
		
		return null;
	}

	void schreibeNachricht(Socket socket, String nachricht) throws IOException {
		
	}
}
