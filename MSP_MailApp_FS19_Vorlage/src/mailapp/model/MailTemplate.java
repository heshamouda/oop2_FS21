// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
// Modulanlass:

package mailapp.model;

import util.TraceV7;

public class MailTemplate extends BasicMail {
	TraceV7 trace = new TraceV7(this);
	// 5

	public MailTemplate() {
		trace.constructorCall();
		empfaenger = "$Empfaenger$";
		betreff = "oop2 | Note";
		nachricht = "Sehr geehrte(r) $Vorname$ $Name$\r\n" + "\r\n" + "Sie haben die Note $Note$ erzielt!\r\n" + "\r\n"
				+ "Gruss\r\n" + "\r\n" + "Prof. Dr. Mailler";
	}

	public void setAlias(String[] alias) {
		trace.methodeCall();
		// 5
	}
}
