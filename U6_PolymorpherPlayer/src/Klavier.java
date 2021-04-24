import java.awt.Image;
import javax.sound.sampled.Clip;
import javax.swing.JTextField;

public class Klavier extends MusikInstrument{

	private String name = "Klavier";

	private Image bild;
	private Clip audioClip;

	/**
	 * <pre>
	 * - laedt Piano Bild mit Utility.loadResourceImage("piano.jpg",300,300);
	 * - laedt audioClip mit Utility.loadAudioClip("elise.wav");
	 * </pre>
	 */
	public Klavier() {

		bild = Utility.loadResourceImage("piano.jpg", 300, 300);
		audioClip = Utility.loadAudioClip("elise.wav");

	}

	/**
	 * <pre>
	 * - setzt Textfeld mit Namen und Eigenschaft des Instruments (Name der Methode) 
	 * - setzt BildPanel Bild mit entsprechendem Klassenattribut
	 * - spielt audioClip mit .setFramePosition und .start
	 * </pre>
	 */
	public void spieltmehrstimmig(JTextField tf, BildPanel bp) {
		tf.setText(name + " spielt mehrstimmig");
		bp.bild = bild;
		audioClip.setFramePosition(0);
		audioClip.start();

	}

	@Override
	public void spielen(JTextField tf, BildPanel bildPanel) {
		spielen(tf, bildPanel);
		
	}

}
