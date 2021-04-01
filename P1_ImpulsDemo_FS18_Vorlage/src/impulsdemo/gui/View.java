package impulsdemo.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import impulsdemo.TraceV2;;

//Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
//Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
//Name: Muster
//Vorname:

public class View extends JPanel implements Observer {
	// 5
	private TraceV2 tr = new TraceV2(this);
	private static final long serialVersionUID = 1L;
	private ReiterPane reiterPane = new ReiterPane();
	public ParameterPanel parameterPanel;

	/**
	 * <pre>
	 * - Baut User-Interface gemäss Aufgabenstellung.
	 * - Registriert die View als Beobachter beim Model.
	 * </pre>
	 */
	public View(Controller controller) {
		// 4
		super(new GridBagLayout());
		tr.constructorCall();
	}

	/**
	 * <pre>
	 * - Datiert entsprechende Komponenten auf.
	 * </pre>
	 * 
	 * @param obs
	 * @param obj
	 */
	public void update(Observable obs, Object obj) {
		// 1
		tr.methodeCall();
	}
}
