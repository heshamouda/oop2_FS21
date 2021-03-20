import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PlotPanel extends JPanel {

	private final int yMin;
	private final int yMax;
	private final int[] samples;

	private JLabel lblPlot = new JLabel();

	public PlotPanel(int yMin, int yMax, int numSamples) {
		this.yMin = yMin;
		this.yMax = yMax;
		this.samples = new int[numSamples];
	}

	void init() {
		setLayout(new GridBagLayout());
		add(lblPlot, new GridBagConstraints(0, 0, 1, 1, 1, 1, GridBagConstraints.PAGE_START, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 0, 0));

		lblPlot.setForeground(Color.WHITE);
	}

	public void setLabelText(String labelText) {
		lblPlot.setText(labelText);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());

		g.setColor(Color.WHITE);

		for (int i = 0; i < samples.length - 1; i++) {
			double dx = getWidth() / (samples.length - 1.0);
			double dy = (double) getHeight() / ((double) yMax - yMin);

			int x0 = (int) (i * dx);
			int y0 = (int) (getHeight() / 2 - (samples[i] * dy));

			int x1 = (int) ((i + 1) * dx);
			int y1 = (int) (getHeight() / 2 - (samples[i + 1] * dy));

			g.drawLine(x0, y0, x1, y1);
		}
	}

	public void update(int[] samples) {
		System.arraycopy(samples, 0, this.samples, 0, this.samples.length);
		repaint();
	}

}
