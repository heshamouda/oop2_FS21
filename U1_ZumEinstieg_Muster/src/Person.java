import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.sound.sampled.Clip;
import javax.swing.JPanel;


public class Person extends JPanel implements MouseListener {
	
	private String name;// = "";
	private String vorname;// = "";
	private Boolean paintflag = false; 
	
	private Image bild;
	private Clip audioClip;
	
	/**
	 * <pre>
	 * - initiiert Attribute und laedt clip und Bild gemaess Übergabeparameter
	 * - registriert MouseListener
	 * </pre>
	 */
	public Person(String name, String vorname, String bildDatei, String audioDatei) {
		this.name = name;
		this.vorname = vorname;
		bild = Utility.loadResourceImage(bildDatei);
		audioClip = Utility.loadAudioClip(audioDatei);
		addMouseListener(this);
	}
	
	/**
	 * <pre>
	 * - setzt je nach flag die Farbe
	 * - zeichnet den Rahmen, Namen und das Bild
	 * </pre>
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(paintflag == false) {
			g.setColor(Color.lightGray);
		}
		else
		{
			g.setColor(Color.pink);
		}
		
		g.fillRect(5, 5, 205, 340);
		g.setColor(Color.black);
		g.drawRect(5, 5, 205, 340);
		g.drawString("Vorname: " + vorname,20,20);
		g.drawString("Name: " + name,20,40);
		g.drawImage(bild,20,50,this);
		
	}
	
	/**
	 * <pre>
	 * - setzt flag fuer Hintergrundfarbe
	 * - spielt Audioclip der Person ab
	 * - erzwingt Neuzeichnen
	 * </pre>
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		paintflag = true;
		audioClip.setFramePosition(0);
		audioClip.start();
		repaint();
		
	}
	
	/**
	 * <pre>
	 * - setzt flag für Hintergrundfarbe zurück und erzwingt Neuzeichnen
	 * </pre>
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		paintflag = false;
		repaint();
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
