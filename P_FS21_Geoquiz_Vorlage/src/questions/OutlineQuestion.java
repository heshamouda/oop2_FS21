package questions;

import java.awt.Image;

import utils.ImageHelper;

public class OutlineQuestion extends QuizQuestion {

	public OutlineQuestion(Country[] options, Country correctOption) {
		super(options, correctOption);
	}

	@Override
	public String getQuestion() {
		return "Welches Land beschreibt dieser Umriss?";
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
		return ImageHelper.loadImage("./res/outlines/" + code + ".png");
	}

}
