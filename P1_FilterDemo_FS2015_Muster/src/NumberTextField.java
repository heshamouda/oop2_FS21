// Ich bestaetige, dass ich diese Pruefung selbstaendig geloest habe.
// Ich weiss, dass bei Zuwiederhandlung die Note 1 erteilt wird.
//
// Name: 
// Vorname:
//

import javax.swing.JTextField;

public class NumberTextField extends JTextField {

	public static final int INTEGER = 0, DOUBLE = 1;
	private boolean inputOK = false;
	private double inputWert = Double.NaN;
	private int inputTyp = INTEGER;
	private boolean inputChanged = false;

	public NumberTextField(int typ) {
		super();
		this.inputTyp = typ;
	}

	public boolean isChanged() {
		boolean tmp = inputChanged;
		inputChanged = false;
		return tmp;
	}

	public boolean isOK() {
		double parse = parseInput();
		if (Double.compare(parse, inputWert) != 0) {
			if (Double.compare(parse, Double.NaN) != 0) {
				inputWert = parse;
				inputOK = true;
				inputChanged = true;
			} else {
				inputWert = Double.NaN;
				inputOK = false;
			}
		}
		return inputOK;
	}

	public double parseInput() {
		// 16
		setText(getText().trim());
		if (getText().length() == 0) {
			return Double.NaN;
		}
		try {
			double value = Double.NaN;
			if (INTEGER == inputTyp) {
				value = Integer.parseInt(getText());
			}
			if (DOUBLE == inputTyp) {
				value = Double.parseDouble(getText());
			}
			return value;
		} catch (NumberFormatException exc) {
			requestFocus();
			setText("Fehleingabe");
			setSelectionStart(0);
			setSelectionEnd(getText().length());
		}
		return Double.NaN;
	}

}
