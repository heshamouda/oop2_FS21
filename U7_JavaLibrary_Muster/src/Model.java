import util.Observable;

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

		return ergebnis;
	}

	/**
	 * holt Array der sortierten Zeilen aus dem Model
	 * 
	 * @return
	 */
	public String[] getAlphabetOrder() {

		return sortZeilen;
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

		// Variante1 nur zwei Operanten
//		String[] tokens = term.split("[+-]");
//		int[] z = new int[tokens.length];// beinhaltet alle Zahlen mit Leerzeichen
//		for (int i = 0; i < z.length; i++) {
//			z[i] = Integer.parseInt(tokens[i].trim());// Leerzeichen an Raendern entfernen
//		}
//		
//		// suchen ob + vorhanden
//		if (term.indexOf("+") > (-1)) {
//			ergebnis = z[0] + z[1];
//		}else {
//			ergebnis = z[0] - z[1];
//		}

		// Variante2 beliebige Operatoren
		String[] tokens = term.split("[ ]+");
		String[] z = new String[tokens.length];// beinhaltet alle Zahlen und Operatoren mit Leerzeichen
		for (int i = 0; i < z.length; i++) {
			z[i] = tokens[i].trim();// Leerzeichen an Raendern entfernen
		}
		System.out.println();
		int op = 1;
		ergebnis = op * Integer.parseInt(z[0]);
		for (int k = 1; k < z.length; k = k + 2) {
			if (z[k].equals("+")) {
				op = 1;
			} else {
				op = -1;
			}
			ergebnis += op * Integer.parseInt(z[k + 1]);
		}

		

		notifyObservers();

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

		
		sortZeilen = text.split("[\n]+");

		//Bubblesort Algorithmus: auch mit do-While oder for-Schleife möglich
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < sortZeilen.length - 1; i++) {
				if (sortZeilen[i].compareTo(sortZeilen[i + 1]) > 0) {
					String tmp = sortZeilen[i + 1];
					sortZeilen[i + 1] = sortZeilen[i];
					sortZeilen[i] = tmp;
					sorted = false;
				}
			}
		}

		notifyObservers();

	}

	public void notifyObservers() {

		setChanged();
		super.notifyObservers();
	}
}