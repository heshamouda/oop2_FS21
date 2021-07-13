package demotimeclientserver;

import java.io.*;
import java.net.*;
import java.util.Date;

/**
 * This program demonstrates a simple TCP/IP socket server.
 *
 * @author www.codejava.net
 */
public class TimeServer {

	public static void main(String[] args) {

		int port = 6868;// int port = Integer.parseInt(args[0]);

		try (ServerSocket serverSocket = new ServerSocket(port)) {

			System.out.println("Server is listening on port " + port);

			while (true) {
				Socket socket = serverSocket.accept();

				System.out.println("New client connected");

				OutputStream output = socket.getOutputStream();
				PrintWriter writer = new PrintWriter(output, true);

				writer.println(new Date().toString());
				
				writer.close();
				socket.close();
			}

		} catch (IOException ex) {
			System.out.println("Server exception: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}