package bikeometer.gui;
import bikeometer.model.Model;
import bikeometer.tools.KMLData;
import bikeometer.tools.Utility;

// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name:
// Vorname:
// Klasse:
//

public class Controller {
	// 7
	private Model model;
	private TopView topView;

	/**
	 * <pre>
	 * - Setzt Attribut model entsprechend model.
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
	 * - Erzeugt unter Verwendung von kmlDatei ein Objekt der Klasse KMLData.
	 * - Setzt mit dem erzeugten Objekt und der Intervallzeit intervall den Trace im Model - Objekt.
	 * </pre>
	 * 
	 * @param kmlDatei
	 * @param intervall
	 */
	public void loadKMLDatei(String kmlDatei, double intervall) {
		// 2
		KMLData kmlData = new KMLData(kmlDatei);
		model.setTrace(kmlData.getTrace(), intervall);
	}

	/**
	 * <pre>
	 * - Setzt via TopView das BackgroundImage des xyPlot - Objekts.
	 * - Verwendet dazu die Methode Utility.loadImage(imageDatei).
	 * </pre>
	 * 
	 * @param imageDatei
	 */
	public void loadXYBackgroundImage(String imageDatei) {
		// 1
		topView.xyPlot.setBackgroundImage(Utility.loadImage(imageDatei));
	}

	/**
	 * - Ruft entsprechende Methode des Models auf.
	 * 
	 * @param markerA
	 * @param markerB
	 */
	public void setMarkerPositions(double markerA, double markerB) {
		// 1
		model.setMarkerPositions(markerA, markerB);
	}

	/**
	 * <pre>
	 * - Setzt das Attribut topView entsprechend topView.
	 * - Setzt via TopView das default BackgroundImage des xyPlot - Objektes.
	 * - Verwendet dazu die Methode Utility.loadResourceImage("bike3.png").
	 * </pre>
	 * 
	 * @param topView
	 */
	public void setTopView(TopView topView) {
		// 2
		this.topView = topView;
		topView.xyPlot.setBackgroundImage(Utility.loadResourceImage("bike3.png"));
	}
}
