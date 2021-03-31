

public class Controller {

	
	private View view;
	private Model model;
	
	
	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
	}


	public void roll() {
		 System.out.println("TODO roll the dice");		
		 model.roll();
		 view.update(model);
		 
	}
}
