package server;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class AnalyzerServerApplication extends JFrame {

	private static enum LAF {
		METAL, OCEAN, SYSTEM
	}

	private enum Mode {
		FIXED, PACKED, FIXEDRESIZABLE, PACKEDRESIZABLE, FIXEDMINPACKEDRESIZABLE
	}

	private static final long serialVersionUID = 1L;

	private static LAF laf = LAF.SYSTEM;
	private Mode mode = Mode.FIXEDMINPACKEDRESIZABLE;
	private int width = 480, height = 480;

	private StatusBar statusBar = new StatusBar();
	MockSoundCard card = new MockSoundCard();
	private ServerModel model = new ServerModel(card);
	private ServerController controller = new ServerController(model);
	private ServerView view = new ServerView(controller);

	public void init() {
		controller.setView(view);
		model.addObserver(view);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(view, BorderLayout.CENTER);
		getContentPane().add(statusBar, BorderLayout.SOUTH);
		card.addChannelListener(model);
		card.start();
		model.clientThread.start();
		model.notifyObservers();

		switch (mode) {
			case FIXED:
				pack();
				setMinimumSize(getPreferredSize());
				setSize(width, height);
				setResizable(false);
				validate();
				break;
			case FIXEDRESIZABLE:
				setPreferredSize(new Dimension(width, height));
				setMinimumSize(getPreferredSize());
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
			case FIXEDMINPACKEDRESIZABLE:
				pack();
				setMinimumSize(getPreferredSize());
				validate();
				setSize(new Dimension(width, height));
				setResizable(true);
				validate();
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
					}
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				AnalyzerServerApplication frame = new AnalyzerServerApplication();
				if (laf != LAF.SYSTEM) {
					frame.setUndecorated(true);
					frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
				}
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle(" Java Analyzer Server");
				frame.init();
				frame.setVisible(true);
			}
		});
	}
}
