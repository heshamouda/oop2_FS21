import util.TraceV8;

public class Controller {
	private TraceV8 trace = new TraceV8(this);
	private Model model;
	private View view;

	public Controller(Model model) {
		trace.constructorCall();
		this.model = model;
	}

	public void setView(View view) {
		trace.methodeCall();
		this.view = view;
	}

	public void btBerechne() {
		trace.methodeCall();
		double amp = Double.parseDouble(view.parameterPanel.tfAmp.getText());
		double freq = Double.parseDouble(view.parameterPanel.tfFreq.getText());
		int nHarm = Integer.parseInt(view.parameterPanel.tfHarm.getText());
		String form = (String) view.parameterPanel.chForm.getSelectedItem();

		model.berechne(amp, freq, nHarm, form, 1024);
	}
}
