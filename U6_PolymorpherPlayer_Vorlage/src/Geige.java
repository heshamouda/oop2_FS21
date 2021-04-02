import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Geige extends MusikInstrument{
	
	private String name = "Geige";
	 
	
	private Image bild;
	private Clip audioClip;
	
	
	public Geige() {
		
		
		bild = Utility.loadResourceImage("violin.jpg",300,300);
		audioClip = Utility.loadAudioClip("schindler.wav");
		
	}
	
	public void spieltleise(JTextField tf,BildPanel bp) {
		tf.setText(name + " spielt leise");
		bp.bild = bild;
		audioClip.setFramePosition(0);
		audioClip.start();
		
	}
	
	@Override
	public void spielen(JTextField tf, BildPanel bp) {
		
		spieltleise(tf, bp);

	}

	
	
	
	
	
}
