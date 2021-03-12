public class Controller {
	private Model model;
	private TopView view;

	public Controller(Model model) {
		this.model = model;
	}
	
	public void setView(TopView view) {
		this.view = view;
		
	}
}
