import java.awt.Image;
import javax.sound.sampled.Clip;
import javax.swing.JTextField;


public class Geige {
	
	private String name = "Geige";
	 
	
	private Image bild;
	private Clip audioClip;
	
	/**
	 * <pre>
	 * - laedt Bild mit Utility.loadResourceImage("violin.jpg",300,300);
	 * - laedt audioClip mit Utility.loadAudioClip("schindler.wav");
	 * </pre>
	 */
	public Geige() {
		bild = Utility.loadResourceImage("violin.jpg",300,300);
		audioClip = Utility.loadAudioClip("schindler.wav");
	}
	
	/**
	 * <pre>
	 * - setzt Textfeld mit Namen und Eigenschaft des Instruments (Name der Methode) 
	 * - setzt BildPanel Bild mit entsprechendem Klassenattribut
	 * - spielt audioClip mit .setFramePosition und .start
	 * </pre>
	 */
	public void spieltleise(JTextField tf,BildPanel bp) {
		tf.setText(name + " spielt leise");
		bp.bild = bild;
		audioClip.setFramePosition(0);
		audioClip.start();		
	}	
}
