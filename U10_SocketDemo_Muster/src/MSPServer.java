import java.io.*;

public class MSPServer {
	public static void main(String[] args) {
		MSPServer server = new MSPServer();
		try {
			server.test();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void test() throws IOException {
		int port = 11111;
		java.net.ServerSocket serverSocket = new java.net.ServerSocket(port);
		while (true) {
			java.net.Socket client = warteAufAnmeldung(serverSocket);
			String nachricht = leseNachricht(client);
			System.out.println(nachricht);
			schreibeNachricht(client, nachricht);
		}
	}

	java.net.Socket warteAufAnmeldung(java.net.ServerSocket serverSocket)
			throws IOException {
		java.net.Socket socket = serverSocket.accept();
		return socket;
	}

	String leseNachricht(java.net.Socket socket) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		return bufferedReader.readLine();
	}

	void schreibeNachricht(java.net.Socket socket, String nachricht)
			throws IOException {
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(
				socket.getOutputStream()));
		printWriter.println(nachricht);
		printWriter.flush();
	}
}
