// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
// Modulanlass:

package mailapp.model;

import util.Observable;
import util.TraceV7;

public class Model extends Observable {
	private TraceV7 trace = new TraceV7(this);
	// 21
	private String[] mailListe = {};
	private String seperators = ",\\t";
	private MailTemplate mailTemplate = new MailTemplate();
	private Mail[] mails = new Mail[0];
	private int activeMailIndex = 0;
	private String s = "";

	public Model() {
		trace.constructorCall();
	}

	/**
	 * <pre>
	 * - Setzt entsprechendes Attribut und ruft buildMails() auf.
	 * </pre>
	 * 
	 * @param mailListe
	 */
	public void setMailListe(String[] mailListe) {
		trace.methodeCall();
		// 2
	}

	/**
	 * <pre>
	 * - Ruft entsprechende Methode des MailTemplates und buildMails() auf.
	 * </pre>
	 * 
	 * @param empfaenger
	 * @param betreff
	 * @param nachricht
	 */
	public void setTemplateDaten(String empfaenger, String betreff, String nachricht) {
		trace.methodeCall();
		// 2
	}

	/**
	 * <pre>
	 * - Ruft entsprechende Methode des MailTemplates und notifyObservers() auf.
	 * </pre>
	 * 
	 * @param alias
	 */
	public void setAlias(String[] alias) {
		trace.methodeCall();
		// 2
	}

	/**
	 * <pre>
	 * Dieser Methode kommt die Aufgabe zu, alle Mails zu erzeugen. Dazu wird als erstes ein 
	 * Mail-Array mails der Länge der mailListe erzeugt und dann in einer for-Schleife die Mails 
	 * mit dem entsprechenden mailListe-Eintrag, den Seperatoren und dem MailTemplate erzeugt. 
	 * Falls der activeMailIndex grösser ist als die Anzahl mails, ist der activeMailIndex auf 
	 * Null zu setzen.
	 * </pre>
	 */
	private void buildMails() {
		trace.methodeCall();
		// 6
	}

	/**
	 * <pre>
	 * - Ruft sendeMail() des Mailers mit der durch activeMailIndex gegebenen Mail auf.
	 * </pre>
	 */
	public void sendMail() {
		trace.methodeCall();
		// 4
	}

	/**
	 * <pre>
	 * - Das gleiche wie sendeMail() aber für alle Mails.
	 * </pre>
	 */
	public void sendAllMails() {
		trace.methodeCall();
		// 5
	}

	public void setActiveMailIndex(int activeMailIndex) {
		trace.methodeCall();
		this.activeMailIndex = activeMailIndex;
		notifyObservers();
	}

	public void setSeperators(String seperators) {
		trace.methodeCall();
		this.seperators = seperators;
	}

	public String[] getMailListe() {
		trace.methodeCall();
		return mailListe;
	}

	public String getMailListe(int i) {
		trace.methodeCall();
		return mailListe[i];
	}

	public Mail getMail() {
		trace.methodeCall();
		return mails[activeMailIndex];
	}

	public MailTemplate getMailTemplate() {
		trace.methodeCall();
		return mailTemplate;
	}

	public int getActiveMailIndex() {
		trace.methodeCall();
		return activeMailIndex;
	}

	public void notifyObservers() {
		trace.methodeCall();
		s = TraceV7.getMethodName(3) + "()";
		setChanged();
		super.notifyObservers(s);
		s = "";
	}
}
