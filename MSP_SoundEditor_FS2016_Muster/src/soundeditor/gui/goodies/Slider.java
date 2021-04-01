package soundeditor.gui.goodies;

import javax.swing.JSlider;

public class Slider extends JSlider {
	private static final long serialVersionUID = 1L;

	public Slider(int min, int max, int value, int nMajor, int nMinor) {
		super(min, max, value);
		setPaintLabels(true);
		setPaintTicks(true);
		setMajorTickSpacing(nMajor);
		setMinorTickSpacing(nMinor);
	}

}
