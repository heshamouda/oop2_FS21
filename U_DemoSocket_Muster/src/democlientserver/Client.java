package democlientserver;
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
		//Socket server = new Socket("127.0.0.1", 11112);
		//Socket server = new Socket("192.168.178.55", 11112);//Fritzbox
		Socket server = new Socket("192.168.178.49", 11112);//Raspi
		
		schreibeNachricht(server, "Nachricht von Client ...");
		System.out.println(server);
		
		String nachricht = leseNachricht(server);//wartet bis was kommt
		System.out.println(nachricht);

		server.close();
	}

	void schreibeNachricht(Socket socket, String nachricht) throws IOException {
		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		printWriter.println(nachricht);
		printWriter.flush(); // entleert Buffer
		
		
	}

	String leseNachricht(Socket socket) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String zeile = bufferedReader.readLine();
		return zeile;
	}
}
