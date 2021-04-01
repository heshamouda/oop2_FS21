package server;

// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
//

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

import common.AnalyzerConstants;

// 30
public class ServerModel extends Observable implements Runnable,
		ChannelListener {

	private short[] buffer = new short[2048];

	private int count = 0;

	private int port = 11111;
	private ServerSocket serverSocket;
	private Socket client;
	public Thread clientThread;

	private String newline = System.getProperty("line.separator");
	private String stRequest;
	private String stResponse;
	private BufferedReader clientReader;
	private PrintWriter clientWriter;

	private short resolution = 7;

	private double amplitude = 0.5;

	private MockSoundCard card;

	public ServerModel(MockSoundCard card) {
		this.card = card;
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			StatusBar.showStatus(e.getMessage());
		}

		clientThread = new Thread(this);
	}

	public int getBlockLength() {
		// TODO Auto-generated method stub
		return buffer.length;
	}

	public short[] getBuffer() {
		// 1
		return buffer;
	}

	public boolean getConnectionState() {
		if (client == null)
			return false;
		else
			return true;
	}

	public String getRequest() {
		return stRequest;
	}

	public String getResponse() {
		return stResponse;
	}

	public void notifyObservers() {
		setChanged();
		super.notifyObservers();
	}

	public void process(double[] samples) {
		double value;
		if (buffer == null)
			return;
		for (int i = 0; i < samples.length; i++) {
			if (count < buffer.length) {

				if (Math.abs(amplitude * samples[i] * Short.MAX_VALUE) > Short.MAX_VALUE){
					value = Math.signum(samples[i])*Short.MAX_VALUE;
				}
				else{
					value = amplitude * samples[i] * Short.MAX_VALUE;
				}

				buffer[count++] = (short) ((((int) (value)) >> (16 - resolution)) << (16 - resolution));
			}
		}

		synchronized (this) {
			if (count == buffer.length) {
				notify();
			}
		}
	}

	private String processRequest(String stRequest) {
		int begin;
		String cmd;

		cmd = AnalyzerConstants.GetBUFFER;
		if (stRequest.equals(cmd)) {
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			String s = "";
			for (int i = 0; i < buffer.length - 1; i++) {
				s += "" + buffer[i] + newline;
			}
			count = 0;

			return s + "" + buffer[buffer.length - 1];
		}

		cmd = AnalyzerConstants.SetBLOCKLENGTH;
		if ((begin = stRequest.indexOf(cmd)) >= 0) {
			int blockLength = Integer.parseInt(stRequest.substring(begin
					+ cmd.length() + 1));
			buffer = null;
			count = 0;
			buffer = new short[blockLength];
			System.out.println("buffer = new short[blockLength];");
		}

		return null;
	}

	private String readFromClient() throws IOException {
		return clientReader.readLine();
	}

	public void run() {
		while (true) {
			try {
				if (client == null) {
					client = serverSocket.accept();
					clientReader = new BufferedReader(new InputStreamReader(
							client.getInputStream()));
					clientWriter = new PrintWriter(new OutputStreamWriter(
							client.getOutputStream()));
					StatusBar.showStatus("Got Connected ...");
				}
				try {
					stRequest = readFromClient();
					stResponse = processRequest(stRequest);
					if (stResponse != null)
						writeToClient(stResponse);
				} catch (Exception e) {
					client = null;
					StatusBar.showStatus("Lost Connection ...");
				}
				notifyObservers();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void setResolution(short resolution) {
		this.resolution = resolution;
	}

	private void writeToClient(String s) {
		clientWriter.println(s);
		clientWriter.flush();
	}

	public void setAmplitude(double amplitude) {
		this.amplitude = amplitude;
	}

	public void setForm(String form) {
		card.setForm(form);
	}

	public void setFrequency(double frequency) {
		card.setFrequency(frequency);
	}
}
