import java.io.*;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {
		Client client = new Client();
		try {
			client.test();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	void test() throws IOException {
		Socket socket = new Socket("127.0.0.1", 11112);
		schreibeNachricht(socket, "Nachricht von Client ...");
		System.out.println(socket);
		String nachricht = leseNachricht(socket);
		System.out.println(nachricht);
		socket.close();
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
}
