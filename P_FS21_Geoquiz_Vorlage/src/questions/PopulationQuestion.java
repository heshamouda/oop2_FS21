// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiderhandlung die Note 1 erteilt wird.
//
// Name:Ouda
// Vorname:Hesham
//
package questions;

import java.awt.Image;

import utils.ImageHelper;
import utils.RandomUtil;

public class PopulationQuestion extends QuizQuestion {

	public PopulationQuestion(Country[] options, Country correctOption) {
		super(options, correctOption);
	}

	private String formatPop(int population) {
		

		if (population > 1000){
			//( String) population = Integer.toString( population); //Integer to string
			 
			population = Integer.parseInt((population/10000 + "." + population%1000));	
			
		}
		if (population > 1000000){
			population = Integer.parseInt((population/10000 + "." + population%1000));	
		}		 
		  	
			

		return "" + population;
	}

	@Override
	public String getQuestion() {
		return "Wieviele Einwohner hat " + correctOption.getName();
	}

	@Override
	public String[] getOptions() {
		String[] answers = new String[4];

		for (int i = 0; i < 4; i++) {
			answers[i] = formatPop(options[i].getPopulation());
		}

		return answers;
	}

	@Override
	public Image loadImage() {
		String code = correctOption.getCode();
		return ImageHelper.loadImage("./res/outlines/" + code + ".png");
	}

}
