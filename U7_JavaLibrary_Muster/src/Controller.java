

public class Controller {

	private Model model;
	private View view;

	public Controller(Model model) {

		this.model = model;
	}

	public void setView(View view) {
		this.view = view;
	}

	public void btSortieren() {
		
		
		model.alphabetSort(view.taBoard.getText());

	}

	public void tfRecalc() {
		model.berechneErgebnis(view.tfTerm.getText());

	}
}
