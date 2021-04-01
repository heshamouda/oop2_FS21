package impulsdemo.gui.goodies;

import java.awt.Graphics;
import java.util.Observable;

import org.apache.commons.math3.complex.Complex;

import impulsdemo.TraceV2;
import impulsdemo.model.Model;

// DIESE DATEI MUSS NICHT BEARBEITET WERDEN! SIE WIRD NICHT BEWERTET!

public class SummePanel extends ZeigerPlot {
	private TraceV2 tr = new TraceV2(this);
	private static final long serialVersionUID = 1L;

	public SummePanel() {
		tr.constructorCall();
	}

	public void update(Observable obs, Object obj) {
		Model model = (Model) obs;
		Complex[] drehZeiger = model.getDrehZeiger();
		if (model.isAngehalten()) {
			clearTail();
		}
		setData(drehZeiger);
	}

	@Override
	public void paintComponent(Graphics g) {

		System.out.println("Hallo");
		super.paintComponent(g);
		System.out.println("" + data.length);
	}
}
