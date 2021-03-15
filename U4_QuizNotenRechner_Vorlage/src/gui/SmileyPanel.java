package gui;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import util.MyBorderFactory;
import util.Observable;
import util.SimpleTimer;
import util.SimpleTimerListener;
import util.TraceV3;
import util.Utility;

public class SmileyPanel extends JPanel implements SimpleTimerListener {
	private static final long serialVersionUID = 1L;
	private TraceV3 trace = new TraceV3(this);
	private Image imSmiley = Utility.loadResourceImage("smileys2.png");
	double x = 0.0, xNeu = 0.0;
	
	private SimpleTimer timer;

	
	/**
	 * <pre>
	 * - erzeugt und startet SimpleTimer(50, this); 
	 * </pre>
	 */
	public SmileyPanel() {
		super(null);// 
		trace.constructorCall();
		setPreferredSize(new Dimension(400, 300));
		setBorder(MyBorderFactory.createMyBorder(" SmileyPanel "));
		
		

	}
	/**
	 * <pre>
	 * - zeichnet imSmiley bei Koordinaten xNeu,10 
	 * - zeichnet Linie bei (200, 300, 200, 5)
	 * </pre>
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		trace.paintCall();
		
	}

	/**
	 * <pre>
	 * - Berechnet x Koordinate gemaess Rechenvorschrift und aktueller Note
	 * </pre>
	 */
	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		
	}

	/**
	 * <pre>
	 * - berechnet xNeu durch Gewichtung von 10% x + 90% xNeu
	 * - Neuzeichnen ausloesen 
	 * </pre>
	 */
	@Override
	public void timerAction() {
		//Bild soll gefiltert zur neuen Position laufen
		

	}
}
