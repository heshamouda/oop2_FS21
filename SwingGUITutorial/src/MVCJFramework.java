import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class MVCJFramework extends JFrame {

	private enum Mode {
		FIXED, PACKED, FIXEDRESIZABLE, PACKEDRESIZABLE
	};

	private Mode mode = Mode.PACKEDRESIZABLE;
	private int width = 600, height = 400;
	private Model model = new Model();
	private Controller controller = new Controller(model);
	private TopView view = new TopView(controller);
	private MenuBar menuBar = new MenuBar(controller, this);
	private ToolBar toolBar = new ToolBar(controller);
	private StatusBar statusBar = new StatusBar();

	private static enum LAF {
		METAL, OCEAN, SYSTEM, NIMROD, NAPKIN
	}

	private static LAF laf = LAF.SYSTEM;

	public void init() {

		controller.setView(view);
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(toolBar, BorderLayout.PAGE_START);
		getContentPane().add(view, BorderLayout.CENTER);
		getContentPane().add(statusBar, BorderLayout.SOUTH);
		setJMenuBar(menuBar);

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
						case NIMROD:
							UIManager.setLookAndFeel(new MyNimRODLookAndFeel("DarkGray.theme"));
							break;
						case NAPKIN:
							UIManager.setLookAndFeel(new net.sourceforge.napkinlaf.NapkinLookAndFeel());
							break;
					}
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				MVCJFramework frame = new MVCJFramework();
				if (laf != LAF.SYSTEM) {
					frame.setUndecorated(true);
					frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
				}
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("MVCJFramework");
				frame.init();
				frame.setVisible(true);
			}
		});
	}
}
