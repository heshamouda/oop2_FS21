import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class FilterDemoApplikation extends JFrame {

	private enum Mode {
		FIXED, PACKED, FIXEDRESIZABLE, PACKEDRESIZABLE
	};

	private Mode mode = Mode.PACKEDRESIZABLE;
	private int width = 800, height = 650;
	private Model model = new Model();
	private Controller controller = new Controller(model);
	private View view = new View(controller);

	private static enum LAF {
		METAL, OCEAN, SYSTEM
	}

	private static LAF laf = LAF.SYSTEM;

	public void init() {
		model.addObserver(view);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(view, BorderLayout.CENTER);

		// Center the window
		switch (mode) {
			case FIXED:
				pack();
				setMinimumSize(getPreferredSize());
				setSize(width, height);
				setResizable(false);
				validate();
				break;
			case FIXEDRESIZABLE:
				pack();
				setMinimumSize(getPreferredSize());
				setSize(width, height);
				setResizable(true);
				validate();
				break;
			case PACKED:
				pack();
				setMinimumSize(getPreferredSize());
				setResizable(false);
				break;
			case PACKEDRESIZABLE:
				pack();
				setMinimumSize(getPreferredSize());
				setResizable(true);
				break;
		}
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					switch (laf) {
						case METAL:
							UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
							break;
						case OCEAN:
							UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
							MetalLookAndFeel.setCurrentTheme(new OceanTheme());
							break;
						case SYSTEM:
							UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
							break;
					}
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				FilterDemoApplikation frame = new FilterDemoApplikation();
				if (laf != LAF.SYSTEM) {
					frame.setUndecorated(true);
					frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
				}
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("Filter - Demo");
				frame.init();
				frame.setVisible(true);
			}
		});
	}
}
