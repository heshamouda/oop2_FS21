// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
// Modulanlass:

package mailapp.model;

import util.TraceV7;

public class Mail extends BasicMail {
	private TraceV7 trace = new TraceV7(this);
	// 17
	private String listenEintrag = "";

	/**
	 * <pre>
	 * Der Konstruktor der Klasse Mail setzt das entsprechende Attribut. So der Listen-Eintrag nicht null 
	 * und nicht gleich "" ist, wird der Eintrag an den Stellen der Seperatoren aufgetrennt und der resultierende
	 * String-Array im Attribut tokens abgelegt. Die tokens werden in der Folge dann noch getrimmt, so dass 
	 * White-Space am Anfang und Ende wegfallen. Nachdem die tokens festgellegt sind, werden die Attribute 
	 * empfaenger, betreff und nachricht gleich jener Eintraege im MailTemplate gesetzt. Dann wird buildMail()
	 * mit dem MailTemplate aufgerufen werden.
	 * </pre>
	 * 
	 * @param listenEintrag
	 * @param seperators
	 * @param mailTemplate
	 */
	public Mail(String listenEintrag, String seperators, MailTemplate mailTemplate) {
		trace.constructorCall();
		// 9
	}

	/**
	 * <pre>
	 * Beim Erstellen der Mails werden in empfaenger, betreff und nachricht 
	 * mittels einer for-Schleife die MailTemplate Tokens durch die Tokens der Mail ersetzt.
	 * D.h. es gilt in empfaenger, betreff und nachricht $Empfaenger$ durch felix.huber@students.fhnw.ch,
	 * $Name$ durch Huber usw. unter Verwendung der Methode replaceAlias() zu ersetzen.
	 * </pre>
	 * 
	 * @param mailTemplate
	 */
	public void buildMail(MailTemplate mailTemplate) {
		trace.methodeCall();
		// 4	
	}

	/**
	 * <pre>
	 * Falls strAlt nicht "" (leere Zeichenkette) ist:
	 * Ersetzt in der Zeichenkette string alle Zeichenketten strAlt durch die Zeichenkette strNeu. Versuchen 
	 * Sie das Problem mittels indexOf() und substring(x, y) zu lösen.
	 * </pre>
	 * 
	 * @param string
	 * @param strAlt
	 * @param strNeu
	 * @return
	 */
	private String replaceAlias(String string, String strAlt, String strNeu) {
		trace.methodeCall();
		// 3 - 5 ;-) 
		return string;
	}

	public String getListenEintag() {
		trace.methodeCall();
		return listenEintrag;
	}
}
