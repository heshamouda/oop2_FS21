import java.io.*;

public class MSPClient {
	public static void main(String[] args) {
		MSPClient client = new MSPClient();
		try {
			client.test();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

	void test() throws IOException {
		String ip = "127.0.0.1";
		int port = 11111;
		java.net.Socket socket = new java.net.Socket(ip, port);
		String nachricht = "GetTimeAxis";

		PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(
				socket.getOutputStream()));

		printWriter.println(nachricht);
		printWriter.flush();

		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));

		for (int i = 0; i < 960; i++) {
			String empfangeneNachricht = bufferedReader.readLine();
			System.out.println(empfangeneNachricht);
		}
		socket.close();
	}

}
