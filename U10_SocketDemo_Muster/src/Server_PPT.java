// Aus: http://de.wikibooks.org/wiki/Java_Standard:_Socket_ServerSocket_(java.net)_UDP_und_TCP_IP

// Server.java
// import java.net.ServerSocket;
// import java.net.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_PPT {

	public Server_PPT() {
		int port = 11112;

		ServerSocket serviceSocket;
		try {
			serviceSocket = new ServerSocket(port);
			System.out.println("Server läuft ...");
			while (true) {
				Socket client = warteAufAnmeldung(serviceSocket);
				System.out.println(client);
				String nachricht = leseNachricht(client);
				System.out.println(nachricht);
				schreibeNachricht(client, "Message from Server ...");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	Socket warteAufAnmeldung(ServerSocket serverSocket) throws IOException {
		Socket socket = serverSocket.accept();
		return socket;
	}

	String leseNachricht(Socket socket) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String zeile = bufferedReader.readLine();
		return zeile;
	}

	void schreibeNachricht(Socket socket, String nachricht) throws IOException {
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		printWriter.println(nachricht);
		printWriter.flush();
	}
	
	public static void main(String[] args) {
		new Server_PPT();
	}
}
