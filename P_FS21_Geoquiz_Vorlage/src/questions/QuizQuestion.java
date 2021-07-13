package questions;

import java.awt.Image;

public abstract class QuizQuestion {

	protected Country[] options;
	protected Country correctOption;

	public QuizQuestion(Country[] options, Country correctOption) {
		this.options = options;
		this.correctOption = correctOption;
	}

	public abstract String getQuestion();

	public abstract String[] getOptions();

	public abstract Image loadImage();

}
