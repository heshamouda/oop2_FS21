package mailapp.model;

import util.TraceV7;

public class BasicMail {
	private TraceV7 trace = new TraceV7("BasicMail",this);
	// 3
	protected String empfaenger = "";
	protected String betreff = "";
	protected String nachricht = "";
	protected String[] tokens = {};

	public BasicMail() {
		trace.constructorCall();
	}

	public void setData(String empfaenger, String betreff, String nachricht) {
		trace.methodeCall();
		// 3
		this.empfaenger = empfaenger;
		this.betreff = betreff;
		this.nachricht = nachricht;
	}

	public String getEmpfanger() {
		trace.methodeCall();
		return empfaenger;
	}

	public String getBetreff() {
		trace.methodeCall();
		return betreff;
	}

	public String getNachricht() {
		trace.methodeCall();
		return nachricht;
	}

	public String[] getTokens() {
		trace.methodeCall();
		return tokens;
	}

	public void setTokens(String[] tokens) {
		trace.methodeCall();
		this.tokens = tokens;
	}

}
