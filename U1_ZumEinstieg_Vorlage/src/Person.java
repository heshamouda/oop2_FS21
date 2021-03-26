import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.sound.sampled.Clip;
import javax.swing.JPanel;

public class Person extends JPanel implements MouseListener {

	private String name = "";
	private String vorname = "";
	private Boolean paintFlag = false;

	private Image bild;
	private Clip audioClip;

	public Person(String name, String vorname, String bildDatei, String audioDatei) {

		this.name = name;
		this.vorname = vorname;
		bild = Utility.loadResourceImage(bildDatei);
		audioClip = Utility.loadAudioClip(audioDatei);
		addMouseListener(this);

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		if (paintFlag == false) {
			g.setColor(Color.LIGHT_GRAY);
		} else {
			g.setColor(Color.pink);
		}
		g.fillRect(5, 5, 205, 340);
		g.setColor(Color.black);
		g.drawRect(5, 5, 205, 340);
		g.drawString("Vorname " + vorname, 20, 20);
		g.drawString("Name " + name, 20, 20);
		g.drawImage(bild, 20, 50, null);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		paintFlag = true;
		audioClip.setFramePosition(0);
		audioClip.start();
		repaint();

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		paintFlag = false;
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
