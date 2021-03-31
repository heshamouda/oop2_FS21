import java.awt.Image;
import javax.sound.sampled.Clip;
import javax.swing.JLabel;
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
		
		this.bild =  Utility.loadResourceImage("clarinet.jpg", 300, 300);
		
		this.audioClip = Utility.loadAudioClip("adagio.wav");
	}

	/**
	 * <pre>
	 * - setzt Textfeld mit Namen und Eigenschaft des Instruments (Name der Methode) 
	 * - setzt BildPanel Bild mit entsprechendem Klassenattribut
	 * - spielt audioClip mit .setFramePosition und .start
	 * </pre>
	 */
	public void spieltschoen(JTextField tf, BildPanel bp) {
		 tf.setText("spieltschoen"+ name);
		 bp.add(tf);
		  
		 audioClip.setFramePosition(1);
		 audioClip.start();
	}

}
