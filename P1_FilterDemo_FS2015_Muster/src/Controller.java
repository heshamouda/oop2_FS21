// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: Muster
// Vorname:
//

public class Controller {
	// 8
	private Model model;

	/**
	 * <pre>
	 * - Setzt das entsprechende lokale Attribut.
	 * </pre>
	 * 
	 * @param model
	 */
	public Controller(Model model) {
		// 1
		this.model = model;
	}

	/**
	 * <pre>
	 * - switch (typ)
	 *     - Fall 0: Mittels entsprechender Methode in der FilterFactory ein Butterworth-Filter 
	 *               kreieren und als Filter im model setzen.
	 *     - Fall 1: Mittels entsprechender Methode in der FilterFactory ein Cheby1-Filter 
	 *               kreieren und als Filter im model setzen. 
	 *                
	 * </pre>
	 * 
	 * @param typ
	 * @param N
	 * @param W
	 * @param R
	 */
	public void setFilter(int typ, int N, double W, double R) {
		// 7
		switch (typ) {
			case 0:
				model.setFilter(FilterFactory.createButter(N, W));
				break;
			case 1:
				model.setFilter(FilterFactory.createCheby1(N, R, W));
				break;
		}
	}
}
