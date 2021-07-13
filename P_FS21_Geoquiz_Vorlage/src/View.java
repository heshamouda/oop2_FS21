// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiderhandlung die Note 1 erteilt wird.
//
// Name:Ouda
// Vorname:Hesham
//
import java.awt.Button;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import utils.Observable;
import utils.Observer;

public class View extends JPanel implements Observer, ActionListener {

	final Controller controller;
	final Insets insets = new Insets(5, 5, 5, 5);

	JLabel labelPunkte = new JLabel("Punkte:");

	JButton buttonA = new JButton("A");
	JButton buttonB = new JButton("B");
	JButton buttonC = new JButton("C");
	JButton buttonD = new JButton("D");

	JPanel panelQuestion = new JPanel();
	JLabel labelQuestion = new JLabel("TestLabel");
	ImagePanel imageQuestion = new ImagePanel();

	public View(Controller controller) {
		this.controller = controller;
	}

	/**
	 * <pre>
	 * - baut das GUI gemaess Aufgabenblatt im GridBagLayout
	 * - das panelQuestion soll Hintergrundfarbe weiss haben.
	 * </pre>
	 */
	public void init() {
		setLayout(new GridBagLayout());
		//setBorder(MyBorderFactory.createMyBorder(" labelPunkte "));
		panelQuestion = new JPanel(new GridLayout(2, 2));
		panelQuestion.add(labelPunkte);
		panelQuestion.add(imageQuestion);
		 


		add(panelQuestion, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.BOTH, new Insets(10, 10, 10, 10), 0, 0));
		panelQuestion.setBackground(Color.WHITE);
		
		add(buttonA, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

		add(buttonB, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(buttonC, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(buttonD, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		 buttonA.addActionListener(this);
		 buttonB.addActionListener(this);
		 buttonC.addActionListener(this);
		 buttonD.addActionListener(this);
			


	}

	/**
	 * <pre>
	 * - erstellen Sie eine Variable model ...
	 *   ... und casten Sie observable in Model und weisen Sie dies der Variablen "model" zu.
	 * - Erstellen Sie eine Variable question vom Typen String und weisen Sie ihr model.currentQuestion.getQuestion() zu
	 * - Erstellen Sie eine Variable image vom Typen Image und weisen Sie ihr model.currentQuestion.loadImage() zu
	 * - setzt das passende JLabel mit question 
	 * - Falls image ungleich null:
	 *     - macht imageQuestion sichtbar, setzt image und ruft zugehörige repaint()  Methode auf
	 * - Sonst:
	 *     - macht imageQuestion unsichtbar
	 * - setzt ButtonTexte mit den Texten der currentQuestion Optionen. 
	 *   buttonA ist Index 0 des Stringarrays, buttonB Index1 usw...
	 * - schreibt Punktzahl aus Model in passendes JLabel (inkl. dem vorhergehenden Beschreibungstext "Punkte: ")
	 * </pre>
	 */
	@Override
	public void update(Observable observable, Object obj) {
		 
			Model model = (Model) observable;
			String question = model.currentQuestion.getQuestion();
			Image image = model.currentQuestion.loadImage();
			//question. =labelQuestion;
			if (!(image == null)) {
				imageQuestion.setVisible(true);				
		} else {
			imageQuestion.setVisible(false);		
			
		}
			//current
			 

	}

	/**
	 * <pre>
	 * - ruft je nach Quelle des Events die Controller Methode answered mit Argument
	 *   0 fuer buttonA, 1 fuer buttonB usw. auf.
	 * </pre>
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.equals(buttonA)) {
			controller.answered(0) ;
		}
		if (e.equals(buttonB)) {
			controller.answered(1) ;
		}
		if (e.equals(buttonC)) {
			controller.answered(2) ;
		}
		if (e.equals(buttonD)) {
			controller.answered(3) ;
		}
		 
		 
		 
	}
}
