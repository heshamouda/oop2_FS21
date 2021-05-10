package client;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

import client.gui.Controller;
import client.gui.View;
import client.model.Model;
import client.tools.Utility;

public class SpectrumAnalyzerApplication extends JFrame {

	private static enum LAF {
		METAL, OCEAN, SYSTEM
	}

	private enum Mode {
		FIXED, PACKED, FIXEDRESIZABLE, PACKEDRESIZABLE, FIXEDMINPACKEDRESIZABLE
	}

	private static final long serialVersionUID = 1L;

	private static LAF laf = LAF.SYSTEM;
	private Mode mode = Mode.PACKEDRESIZABLE;
	private int width = 640, height = 480;

	private Model model = new Model();
	private Controller controller = new Controller(model);
	private View view = new View(controller);

	public void init() {
		setIconImage(Utility.loadResourceImage("scope_icon.png"));
		model.addObserver(view);
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(view, BorderLayout.CENTER);
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
		setLocation((screenSize.width - frameSize.width) / 2,
				(screenSize.height - frameSize.height) / 2);
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					switch (laf) {
					case METAL:
						UIManager
								.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
						break;
					case OCEAN:
						UIManager
								.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
						MetalLookAndFeel.setCurrentTheme(new OceanTheme());
						break;
					case SYSTEM:
						UIManager.setLookAndFeel(UIManager
								.getSystemLookAndFeelClassName());
						break;
					}
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				SpectrumAnalyzerApplication frame = new SpectrumAnalyzerApplication();
				if (laf != LAF.SYSTEM) {
					frame.setUndecorated(true);
					frame.getRootPane().setWindowDecorationStyle(
							JRootPane.FRAME);
				}
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle(" Java Analyzer Client ");
				frame.init();
				frame.setVisible(true);
			}
		});
	}
}
