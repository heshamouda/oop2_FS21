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
public class ReverseServer2 {

	public static void main(String[] args) {

		int port = 6868;
		

		try (ServerSocket serverSocket = new ServerSocket(port)) {

			System.out.println("Server is listening on port " + port);

						
			while (true) {

				Socket client = serverSocket.accept();
				System.out.println("New client connected");
				
//				ServerThread serverThread;
//				serverThread = new ServerThread(client);
//				serverThread.start();
				new ServerThread(client).start();



			}
			


		} catch (IOException ex) {
			System.out.println("Server exception: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}