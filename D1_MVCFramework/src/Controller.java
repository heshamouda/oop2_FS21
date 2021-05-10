public class Controller {
	private TraceV8 trace = new TraceV8(this);
	private Model model;
	private View view;

	public Controller(Model model) {
		trace.methodeCall();
		this.model = model;
	}

	public void btAction(String stInfo) {
		trace.methodeCall();
		model.setData(stInfo);
		view.tf1.setText("");
		view.tf1.requestFocus();
		System.out.println(model.getData());
	}

	public void setView(View view) {
		trace.methodeCall();
		this.view = view;
	}
}
