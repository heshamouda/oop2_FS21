package impulsdemo;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import impulsdemo.gui.Controller;
import impulsdemo.gui.View;
import impulsdemo.model.Model;
import resources.Utility;

//DIESE DATEI MUSS NICHT BEARBEITET WERDEN! SIE WIRD NICHT BEWERTET!

public class ImpulsDemoApplikation extends JFrame {
	TraceV2 tr = new TraceV2(this);
	private static final long serialVersionUID = 1L;
	public static final int appWidth = (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() * (2.0 / 3.0));
	public static final int appHeight = (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() * (2.0 / 3.0));

	private Image icon = Utility.loadResourceImage("Icon.png");
	private Model model = new Model();
	private Controller controller = new Controller(model);
	private View view = new View(controller);

	public ImpulsDemoApplikation() {
		tr.constructorCall();
		setTitle("Impuls - Demo");
		setIconImage(icon);
		getContentPane().add(view);
		model.addObserver(view);
		tr.registerObserver(model, view);
		try {
			view.parameterPanel.btReset.doClick();
		} catch (Exception e) {
			// To keep students happy ...
		}
		DPIFixV3.scaleSwingFonts();
		SwingUtilities.updateComponentTreeUI(this);

		pack();
		setMinimumSize(getPreferredSize());

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		setVisible(true);
	}

	public static void main(String args[]) {
		TraceV2.mainCall(false, false, false);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				ImpulsDemoApplikation demo = new ImpulsDemoApplikation();
				demo.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
			}
		});
	}
}
