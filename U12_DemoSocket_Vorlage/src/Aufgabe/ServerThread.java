package Aufgabe;

import java.io.*;
import java.net.*;

/**
 * This thread is responsible to handle client connection.
 *
 * @author www.codejava.net
 */
public class ServerThread extends Thread {
	private Socket client;
	String text;
	String reverseText;

	public ServerThread(Socket client) {
		this.client = client;
	}

	public void run() {
		
	}
}