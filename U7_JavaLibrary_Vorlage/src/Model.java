import java.util.StringTokenizer;

import util.Observable;
import util.TraceV3;

public class Model extends Observable {

	private int ergebnis = 47;
	private String[] sortZeilen = {};

	public Model() {

	}

	/**
	 * holt ergebnis aus dem Model
	 * 
	 * @return
	 */
	public int getErgebnis() {

		return 0;//damit Compiler glücklich
	}

	/**
	 * holt Array der sortierten Zeilen aus dem Model
	 * 
	 * @return
	 */
	public String[] getAlphabetOrder() {

		return null;//damit Compiler glücklich
	}

	/**
	 * <pre>
	 * -berechnet aus dem String die zugehörige Rechenoperation und legt es im
	 *  Ergebnis ab 
	 * -informiert Observers wenn fertig
	 * </pre>
	 * 
	 * @param term
	 */
	public void berechneErgebnis(String term) {

		

	}

	/**
	 * <pre>
	 * -sortiert und speichert Textzeilen des TextAreas in alphabetische Reihenfolge
	 *  im Array sortZeilen des Models 
	 * -informiert Observers wenn fertig
	 * </pre>
	 * 
	 * @param text
	 */
	public void alphabetSort(String text) {

		

	}

	public void notifyObservers() {

		
	}
}