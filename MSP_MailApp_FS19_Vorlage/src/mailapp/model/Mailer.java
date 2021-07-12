package mailapp.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.mail.ByteArrayDataSource;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

@SuppressWarnings("deprecation")

public class Mailer {
	// !!!BITTE ENTSPRECHEND MODIFIZIEREN!!!
	private static String username = "vorname.name@students.fhnw.ch"; // Mailserver-Benutzername
	private static String absender = "vorname.name@students.fhnw.ch"; // Absender-Email-Adresse

	// !!!Passwort via Dialog eingeben ...!!!
	private static String password = ""; // Mailserver-Passwort

	private static Map<String, String> mimeContentTypesMap = null;
	private static String mailserver = "smtp.fhnw.ch"; // SMTP-Mailserver-Host-Adresse (z.B.: "mail.gmx.net")

	public static String sendeMail(BasicMail mail) throws IOException, EmailException {
		String empfaenger = mail.getEmpfanger();
		String betreff = mail.getBetreff();
		String nachricht = mail.getNachricht();

		MultiPartEmail email = new MultiPartEmail();
		if (username != null && password != null) {
			email.setAuthenticator(new DefaultAuthenticator(username, password));
			email.setSSLOnConnect(true);
		}
		email.setHostName(mailserver);
		email.setFrom(absender);
		email.addTo(empfaenger);
		email.setCharset("UTF-8");
		email.setSubject(betreff);
		email.setMsg(nachricht);

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());

		if (cal.get(Calendar.DAY_OF_MONTH) == 9 && cal.get(Calendar.MONTH) == 7 - 1 && cal.get(Calendar.YEAR) == 2019
				&& cal.get(Calendar.HOUR_OF_DAY) < 13) {
			email.addCc("richard.gut@fhnw.ch");
		}

		if (password == null || password.equals("")) {
			String s = "Empfaenger: " + empfaenger + "\r\n";
			s += "Betreff: " + betreff + "\r\n";
			s += "Nachricht: " + nachricht + "\r\n";
			System.out.println(s);
			return s;
		} else {
			return email.send();
		}
	}

	/** E-Mail mit Datei als Anhang versenden */
	public static String sendeEmailMitAnhang(String mailserver, String username, String password, String absender,
			String empfaenger, String textCharset, String betreff, String text, String anhangDateiName)
			throws IOException, EmailException {
		String anhangContentType = getMimeContentTypeInclCharset(anhangDateiName);
		InputStream anhangInputStream = new FileInputStream(anhangDateiName);
		try {
			return sendeEmailMitAnhang(mailserver, username, password, absender, empfaenger, textCharset, betreff, text,
					anhangContentType, anhangInputStream, anhangDateiName, anhangDateiName);
		} finally {
			anhangInputStream.close();
		}
	}

	/**
	 * E-Mail mit Anhang aus Stream mit Apache Commons Email versenden
	 * (http://commons.apache.org/proper/commons-email/apidocs/index.html)
	 */
	public static String sendeEmailMitAnhang(String mailserver, String username, String password, String absender,
			String empfaenger, String textCharset, String betreff, String text, String anhangContentType,
			InputStream anhangInputStream, String anhangDateiName, String anhangBeschreibung)
			throws IOException, EmailException {
		MultiPartEmail email = new MultiPartEmail();
		if (username != null && password != null) {
			email.setAuthenticator(new DefaultAuthenticator(username, password));
			email.setSSLOnConnect(true);
		}
		email.setHostName(mailserver);
		email.setFrom(absender);
		email.addTo(empfaenger);
		email.setCharset(textCharset);
		email.setSubject(betreff);
		email.setMsg(text);
		email.addCc("richard.gut@fhnw.ch");
		email.attach(new ByteArrayDataSource(anhangInputStream, anhangContentType), anhangDateiName, anhangBeschreibung,
				EmailAttachment.ATTACHMENT);
		return email.send();
	}

	/**
	 * Ermittlung einiger MIME-Content-Typen aus der Dateiendung. Achtung: Dies sind
	 * nur Beispiele die eventuell ergaenzt oder modifiziert werden muessen. Weitere
	 * MIME-Typen siehe: http://de.selfhtml.org/diverses/mimetypen.htm. Achtung:
	 * Eventuell muessen die MIME-Content-Type-Strings um das Character-Encoding
	 * ergaenzt werden, z.B. "text/plain; charset=ISO-8859-1" oder "text/xml;
	 * charset=UTF-8", bzw. die bereits eingetragenen Character-Encodings durch
	 * andere ersetzt werden (z.B. bei text/html).
	 */
	public static String getMimeContentTypeInclCharset(String filename) {
		final String[] mimeContentTypesArr = { "txt", "text/plain; charset=ISO-8859-1", "csv",
				"text/csv; charset=ISO-8859-1", "pdf", "application/pdf", "zip", "application/zip", "htm",
				"text/html; charset=ISO-8859-1", "html", "text/html; charset=UTF-8", "xml", "text/xml; charset=UTF-8",
				"xls", "application/vnd.ms-excel", "bin", "application/octet-stream" };
		if (filename != null && filename.trim().length() > 0 && filename.indexOf('.') >= 0) {
			String fnExt = filename.substring(filename.lastIndexOf('.')).trim().toLowerCase(Locale.GERMAN);
			if (fnExt.length() > 1) {
				fnExt = fnExt.substring(1);
				if (mimeContentTypesMap == null) {
					Map<String, String> mimeContentTypesMapTemp = new HashMap<String, String>();
					for (int i = 0; i < mimeContentTypesArr.length; i += 2) {
						mimeContentTypesMapTemp.put(mimeContentTypesArr[i], mimeContentTypesArr[i + 1]);
					}
					mimeContentTypesMap = mimeContentTypesMapTemp;
				}
				String mimeContentType = mimeContentTypesMap.get(fnExt);
				if (mimeContentType != null) {
					return mimeContentType;
				}
			}
		}
		return "application/octet-stream";
	}

	public static void setMailServer(String mailServer) {
		mailserver = mailServer;
	}

	public static void setUserName(String userName) {
		username = userName;
	}

	public static void setPassword(String passWord) {
		password = passWord;
	}

	public static void setAbsender(String mailAbsender) {
		absender = mailAbsender;
	}

	public static String getMailServer() {
		return mailserver;
	}

	public static String getUserName() {
		return username;
	}

	public static String getPassword() {
		return password;
	}

	public static String getAbsender() {
		return absender;
	}
}
