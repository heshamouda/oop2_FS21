import java.awt.Image;
import javax.sound.sampled.Clip;
import javax.swing.JTextField;

public class Klarinette {

	private String name = "Klarinette";

	private Image bild;
	private Clip audioClip;
	
	/**
	 * <pre>
	 * - laedt Bild mit Utility.loadResourceImage("clarinet.jpg", 300, 300);
	 * - laedt audioClip mit Utility.loadAudioClip("adagio.wav");
	 * </pre>
	 */
	public Klarinette() {
		
		bild =  Utility.loadResourceImage("clarinet.jpg", 300, 300);
		
		audioClip = Utility.loadAudioClip("adagio.wav");
	}

	/**
	 * <pre>
	 * - setzt Textfeld mit Namen und Eigenschaft des Instruments (Name der Methode) 
	 * - setzt BildPanel Bild mit entsprechendem Klassenattribut
	 * - spielt audioClip mit .setFramePosition und .start
	 * </pre>
	 */
	public void spieltschoen(JTextField tf, BildPanel bp) {
		 tf = new JTextField ("spieltschoen"+ name);
		 bp = new BildPanel();
		 audioClip.setFramePosition(0);
		 audioClip.start();

	}

}
