import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Klavier extends MusikInstrument{
	
	private String name = "Klavier";
	 
	
	private Image bild;
	private Clip audioClip;
	
	
	public Klavier() {
		
		
		bild = Utility.loadResourceImage("piano.jpg",300,300);
		audioClip = Utility.loadAudioClip("elise.wav");
		
	}
	
	public void spieltmehrstimmig(JTextField tf,BildPanel bp) {
		tf.setText(name + " spielt mehrstimmig");
		bp.bild = bild;
		audioClip.setFramePosition(0);
		audioClip.start();
		
	}
	
	@Override
	public void spielen(JTextField tf, BildPanel bp) {
		
		spieltmehrstimmig(tf, bp);

	}

	
	
	
	
	
}
