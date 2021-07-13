
// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiderhandlung die Note 1 erteilt wird.
//
// Name:Ouda
// Vorname:Hesham
//
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

import questions.Country;
import questions.FlagQuestion;
import questions.OutlineQuestion;
import questions.PopulationQuestion;
import questions.QuizQuestion;
import utils.Observable;
import utils.RandomUtil;

public class Model extends Observable {

	public static final int STATE_IDLE = 0;
	public static final int STATE_GAME_OVER = 1;

	public int state = STATE_IDLE;
	public int points = 0;

	public QuizQuestion currentQuestion;

	public Country[] countries = new Country[233];
	public Country[] options = new Country[4];
	Country correctCountry;

	public void notifyObservers() {
		setChanged();
		super.notifyObservers();
	}

	/**
	 * <pre>
	 * - erzeugt lokales int array indices der Laenge 4 mit zufaelligen Werten zwischen 0 und Laenge von countries
	 *   (Hinweis: RandomUtil.randomDistinct Methode aus package utils benutzen)
	 * - erzeugt lokale int Variable correct mit Zufallszahl zwischen 0 und 3
	 * - setzt correctCountry mit countries[indices[correct]]
	 * - setzt alle vier options mit den indices der countries
	 * - erzeugt lokale int Variable type mit Zufallszahlen zwischen 0 und 2
	 * - fuer type gleich 0 wird als currentQuestion eine FlagQuestion erzeugt
	 * - fuer type gleich 1 wird als currentQuestion eine OutlineQuestion erzeugt
	 * - fuer type gleich 2 wird als currentQuestion eine PopulationQuestion erzeugt
	 * - benachrichtigt Observer (verwenden Sie "notifyObservers()")
	 * </pre>
	 */
	public void generateQuestion() {

		int[] indices =  new int [4];
		 
			indices = new RandomUtil().randomDistinct(4, 0, countries.length);
			
		
		
		int correct = (int) Math.random() * 3;
		correctCountry = countries[indices[correct]];
		options[0] = countries[indices[0]];
		options[1] = countries[indices[1]];
		options[2] = countries[indices[2]];
		options[3] = countries[indices[3]];
		options[4] = countries[indices[4]];

		int type = (int) Math.random() * 2;

		if (type == 0) {
			currentQuestion = new FlagQuestion(options, correctCountry);

		}
		if (type == 1) {
			currentQuestion = new OutlineQuestion(options, correctCountry);
		}
		if (type == 2) {
			currentQuestion = new PopulationQuestion(options, correctCountry);

		}
		notifyObservers();


	}

	/**
	 * <pre>
	 * - Liesst die Laender und deren Eckdaten aus countries.csv und speichert die komma-separierten Werte 
	 *   gemaess Definition in Aufgabenblatt in die passenden Country Attribute. 
	 * - Schliessen Sie alle Ressourcen nach Fertigstellung.
	 * </pre>
	 */
	public void loadCountries() throws IOException {
		String[] zeilen = {};
		int counter = 0;

		try {
			BufferedReader eingabeDatei = new BufferedReader(new FileReader("./res/countries.csv"));
			 
			while ((eingabeDatei.readLine()) != null) {
				counter++;
			}

			eingabeDatei.close();

			 
			zeilen = new String[counter];
			eingabeDatei = new BufferedReader(new FileReader("./res/countries.csv"));
			for (int i = 0; i < zeilen.length; i++) {
				zeilen[i] = eingabeDatei.readLine();
			}
			eingabeDatei.close();
			
		} catch (IOException exc) {
			 
			System.exit(1);
		}
		for (int i = 0; i < zeilen.length; i++) {
			//countries [i] =   zeilen[i];
;			
		}
	}


	 

	/**
	 * <pre>
	 * - Falls option[i] dem richtigen Country entspricht wird Punkte erhoeht
	 * - generiert neue Frage
	 * </pre>
	 */
	public void answered(int i) {
		for (   i= 0; i < countries.length; i++) {
			if (options[i]== correctCountry) {
				points++;
				generateQuestion();
				
			}
			
		}

	}
}
