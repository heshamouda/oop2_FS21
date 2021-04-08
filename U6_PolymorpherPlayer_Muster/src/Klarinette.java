import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.sound.sampled.Clip;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Klarinette extends MusikInstrument{
	
	private String name = "Klarinette";
	 
	
	private Image bild;
	private Clip audioClip;
	
	
	public Klarinette() {
		
		
		bild = Utility.loadResourceImage("clarinet.jpg",300,300);
		audioClip = Utility.loadAudioClip("adagio.wav");
		
	}
	
	public void spieltschoen(JTextField tf, BildPanel bp) {
		tf.setText(name + " spielt schön");
		bp.bild = bild;
		audioClip.setFramePosition(0);
		audioClip.start();
		
	}

	@Override
	public void spielen(JTextField tf, BildPanel bp) {
		// TODO Auto-generated method stub
		spieltschoen(tf, bp);
		
	}

	

	
	
	
	
	
}
