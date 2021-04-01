// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
//

public class FilterFactory {
	// 21

	/**
	 * <pre>
	 * [filter] = BUTTER(N,Wn,'s'), design an Nth order lowpass analog Butterworth filters.
	 * 
	 * - Gemäss Algorithmus in der Aufgabenstellung.
	 *  
	 * </pre>
	 *
	 * @param 	N		Order
	 * @param 	Wg		Cut-off-frequency in rad/s
	 * @return 			Filter - Object
	 */
	public static Filter createButter(int N, double Wg) {


		// Zeile muss am Schluss sinngemäss ersetzt werden!
		return new Filter(new double[]{1.0}, new double[]{1.0}, new Complex[] {}, new Complex[] {});
	}

	/**
	 * <pre>
	 * [filter] = CHEBY1(N,R,Wp,'s') designs an Nth order lowpass analog Chebyshev filter 
	 * with R decibels of peak-to-peak ripple in the passband.
	 * 
	 * - Gemäss Algorithmus in der Aufgabenstellung.
	 * 
	 * </pre>
	 * 
	 * @param N		Order
	 * @param R		Ripple in dB
	 * @param Wg	Cut-off-frequency in rad/s.
	 * @return		Filter - Object
	 */
	public static Filter createCheby1(int N, double R, double Wg) {

		
		// Zeile muss am Schluss sinngemäss ersetzt werden!
		return new Filter(new double[]{1.0}, new double[]{1.0}, new Complex[] {}, new Complex[] {});
	}
}

