package questions;

import java.awt.Image;

import utils.ImageHelper;

public class FlagQuestion extends QuizQuestion {

	public FlagQuestion(Country[] options, Country correctOption) {
		super(options, correctOption);
	}

	@Override
	public String getQuestion() {
		return "Welchem Land gehoert diese Flagge?";
	}

	@Override
	public String[] getOptions() {
		String[] answers = new String[4];

		for (int i = 0; i < 4; i++) {
			answers[i] = options[i].getName();
		}

		return answers;
	}

	@Override
	public Image loadImage() {
		String code = correctOption.getCode();
		return ImageHelper.loadImage("./res/flags/" + code + ".png");
	}

}
