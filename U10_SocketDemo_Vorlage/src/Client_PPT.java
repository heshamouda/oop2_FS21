import java.io.*;
import java.io.PrintWriter;
import java.net.Socket;

public class Client_PPT {

	public Client_PPT() {
		Socket server;
		try {
			server = new Socket("127.0.0.1", 11112);
			schreibeNachricht(server, "Nachricht von Client ...");
			System.out.println(server);
			String nachricht = leseNachricht(server);
			System.out.println(nachricht);
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void schreibeNachricht(Socket socket, String nachricht) throws IOException {
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		printWriter.println(nachricht);
		printWriter.flush();
	}

	String leseNachricht(Socket socket) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String zeile = bufferedReader.readLine();
		return zeile;
	}

	public static void main(String[] args) {
		new Client_PPT();
	}
}
