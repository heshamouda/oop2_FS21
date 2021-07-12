import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ADHocPanel extends JPanel implements ActionListener {
	TraceV4 trace = new TraceV4(this);
	private JTextField tfGr = new JTextField("169");
	private JTextField tfGw = new JTextField("80");
	private TextField tfSex = new TextField("m");
	private JLabel lbBMI = new JLabel("24.4");
	private JButton btBerechne = new JButton("Berechne");

	private Image[] imFrau = new Image[9];
	private Image[] imMann = new Image[9];
	private Image bild;

	/**
	 * <pre>
	 * <b> Baut GUI und lädt Bilder ... </b>
	 * - Baut GUI
	 * - Lädt Bilder in Arrays:
	 * - Für i gleich 0 bis i kleiner 9:
	 * 		i-tes Bild mann_i.png mittels Utility - Klasse in i-tes Element von imMann laden
	 * 		i-tes Bild frau_i.png mittels Utility - Klasse in i-tes Element von imFrau laden
	 * - ActionEvent von btBerechne programmatisch auslösen.
	 * </pre>
	 */
	public void init() {
		trace.methodeCall();
		setLayout(null);
		int y = 10;
		add(new JLabel("Grösse: ")).setBounds(10, y, 50, 20);
		add(tfGr).setBounds(60, y, 240, 20);
		add(new JLabel("cm ")).setBounds(310, y, 50, 20);
		y = y + 30;
		add(new JLabel("Gewicht: ")).setBounds(10, y, 50, 20);
		add(tfGw).setBounds(60, y, 240, 20);
		add(new JLabel("kg ")).setBounds(310, y, 50, 20);
		y = y + 30;
		add(new JLabel("Sex: ")).setBounds(10, y, 50, 20);
		add(tfSex).setBounds(60, y, 240, 20);
		add(new JLabel("m/w ")).setBounds(310, y, 50, 20);
		y = y + 30;
		add(btBerechne).setBounds(60, y, 240, 20);

		btBerechne.addActionListener(this);
		for (int i = 0; i < imFrau.length; i++) {
			imMann[i] = Utility.loadResourceImage("mann_" + i + ".png");
			imFrau[i] = Utility.loadResourceImage("frau_" + i + ".png");
		}
	}

	/**
	 * <pre>
	 * <b> Zeichnet das Bild ... </b>
	 * 
	 * 		- bild an der Stelle 110, 170 zeichnen
	 * </pre>
	 */
	@Override
	public void paintComponent(Graphics g) {
		trace.paintCall();
		super.paintComponent(g);
		g.drawImage(bild, 110, 170, this);
	}

	/**
	 * <pre>
	 * <b> Berechnet den BMI auf eine Stelle nach dem Komma ... </b>
	 * 
	 * - BMI berechnen. 
	 * - Wert mal Zehn rechnen, runden und wieder durch Zehn dividieren.
	 * </pre>
	 * 
	 * @param gewicht Gewicht der Person in kg
	 * @param groesse Groesse der Person in cm
	 * @return BMI auf eine Stelle nach dem Komma gerundet.
	 */
	private double berechneBMI(double gewicht, double groesse) {
		trace.methodeCall();
		return Math.round(10.0 * gewicht / Math.pow(groesse / 100.0, 2.0)) / 10.0;
	}

	/**
	 * <pre>
	 * - Berechnet den zum bmi zugehörigen Bild-Index:
	 *   linear zwischen bmi 17 -> index 0 und bmi 33 -> index 8.
	 * - Falls index kleiner Null:
	 *     - index gleich null;
	 * - Falls index grösser 8:
	 *     - index gleich 8;
	 * </pre>
	 * 
	 * @param bmi
	 * @return
	 */
	private int berechneIndex(double bmi) {
		trace.methodeCall();
		int index = (int) Math.round(((bmi - 17.0) * 8.0 / 16.0));
		if (index < 0) {
			index = 0;
		}
		if (index > 8) {
			index = 8;
		}
		return index;
	}

	/**
	 * <pre>
	 * <b> Werte aus den GUI - Komponenten auslesen und Berechnungen ausführen ... </b>
	 * 
	 *  - Text aus tfGr und tfGw auslesen und in lokale Variabeln ablegen.
	 * 	- Text aus tfSex lesen und in lokalem String sex ablegen.
	 * 	- Mittels berechneBMI() mit den Argumenten gewicht und groesse den BMI berechnen und in lokaler Var. ablegen.
	 * 	- Mittels berechneBildIndex() mit dem Argumenten bmi den Index des zum BMI zugehörigen Bildes berechnen in lokaler Var. ablegen.
	 * 	- Falls sex gleich "m"
	 * 		- bild gleich imMann an der Stelle des berechneten Bild-Index setzen.
	 * 	- Sonst 
	 * 		- bild gleich imFrau an der Stelle des berechneten Bild-Index setzen.
	 *  - Neuzeichnen auslösen.
	 * 
	 * </pre>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		trace.eventCall();
		double gr = Double.parseDouble(tfGr.getText());
		double gw = Double.parseDouble(tfGw.getText());
		double bmi = berechneBMI(gw, gr);
		lbBMI.setText("" + bmi);
		int index = berechneIndex(bmi);
		if (tfSex.getText().equals("m")) {
			bild = imMann[index];
		} else {
			bild = imFrau[index];
		}
		repaint();
	}
}

public class ADHocPanelFrame extends JFrame {
	TraceV4 trace = new TraceV4(this);
	private static final long serialVersionUID = 1L;
	private static Image icon = Utility.loadResourceImage("apple.png");

	public static void main(String args[]) {
		TraceV4.mainCall();
		ADHocPanelFrame frame = new ADHocPanelFrame();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(1);
			}
		});
		ADHocPanel view = new ADHocPanel();
		view.init();
//		view.addMouseMotionListener(new MouseMotionAdapter() {
//			public void mouseMoved(MouseEvent e) {
//				System.out.println("x: " + e.getX() + " y: " + e.getY());
//			}
//		});
		frame.add(view);
		frame.setSize(400, 600);
		frame.setIconImage(icon);
		frame.setTitle("|FHNW|EIT|OOP|Calculation-Panel|");
		frame.setResizable(true);
		frame.setVisible(true);
	}
}