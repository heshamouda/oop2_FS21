package server;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ServerView extends JPanel implements ActionListener, Observer,
		ChangeListener {
	private static final long serialVersionUID = 1L;

	private JTextArea txtArea = new JTextArea();
	private JPanel jpState = new JPanel(new GridLayout(1, 4, 5, 5));
	private JPanel jpSettings = new JPanel(new GridLayout(4, 3, 5, 5));
	private JTextField jtfBlockLength = new JTextField();
	private JTextField jtfConnectionState = new JTextField();
	private JToggleButton jtbHistoryOn = new JToggleButton("On");
	private JToggleButton jtbHistoryOff = new JToggleButton("Off");
	private ButtonGroup btGroup = new ButtonGroup();
	private JDoubleTextField tfFrequency = new JDoubleTextField(""
			+ (1000.0 * Math.PI), 10, false);

	private SpinnerNumberModel numberModelAmplitude = new SpinnerNumberModel(
			new Double(0.5), new Double(0.0), new Double(1.2), new Double(0.01));
	private JSpinner spinnerAmplitude = new JSpinner(numberModelAmplitude);

	private SpinnerListModel listModelForm = new SpinnerListModel(new String[] {
			"Sinus", "Rectangle" });
	private JSpinner spinnerForm = new JSpinner(listModelForm);

	private SpinnerListModel listModelResolution = new SpinnerListModel(
			new String[] { "6", "7", "8", "9", "10", "12", "14", "16" });
	private JSpinner spinnerResolution = new JSpinner(listModelResolution);

	private boolean historyOn = true;

	private ServerController controller;

	public ServerView(ServerController controller) {
		super(new GridBagLayout());

		setBorder(MyBorderFactory.createMyBorder(" Communication "));
		this.controller = controller;

		jpSettings.setBorder(MyBorderFactory.createMyBorder(" Settings "));

		spinnerAmplitude.addChangeListener(this);
		spinnerAmplitude.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				Object value = null;
				if (e.getWheelRotation() < 0) {
					value = numberModelAmplitude.getNextValue();
				} else {
					value = numberModelAmplitude.getPreviousValue();
				}
				if (value != null)
					numberModelAmplitude.setValue(value);
			}
		});

		jpSettings.add(new JLabel("Amplitude: "));
		jpSettings.add(spinnerAmplitude);
		jpSettings.add(new JLabel("V-Peak"));

		tfFrequency.addActionListener(this);
		tfFrequency.setHorizontalAlignment(JTextField.RIGHT);
		jpSettings.add(new JLabel("Frequency: "));
		jpSettings.add(tfFrequency);
		jpSettings.add(new JLabel("Hz"));

		spinnerForm.addChangeListener(this);
		spinnerForm.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				Object value = null;
				if (e.getWheelRotation() < 0) {
					value = listModelForm.getNextValue();
				} else {
					value = listModelForm.getPreviousValue();
				}
				if (value != null)
					spinnerForm.setValue(value);
			}
		});

		jpSettings.add(new JLabel("Form: "));
		jpSettings.add(spinnerForm);
		jpSettings.add(new JLabel(""));

		spinnerResolution.addChangeListener(this);
		spinnerResolution.addMouseWheelListener(new MouseWheelListener() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				Object value = null;
				if (e.getWheelRotation() < 0) {
					value = listModelResolution.getNextValue();
				} else {
					value = listModelResolution.getPreviousValue();
				}
				if (value != null)
					spinnerResolution.setValue(value);
			}
		});

		jpSettings.add(new JLabel("Resolution: "));
		jpSettings.add(spinnerResolution);
		jpSettings.add(new JLabel("Bit"));

		add(jpSettings, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));

		jpState.setBorder(MyBorderFactory.createMyBorder(" State "));
		jpState.add(new JLabel("Connection - State: "));
		jtfConnectionState.setEditable(false);
		jpState.add(jtfConnectionState);
		jpState.add(new JLabel("Block - Length: "));
		jtfBlockLength.setEditable(false);
		jpState.add(jtfBlockLength);

		add(jpState, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));

		txtArea.setLineWrap(true);
		txtArea.setEditable(false);
		txtArea.setVisible(true);

		JScrollPane scroll = new JScrollPane(txtArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		scroll.setBorder(MyBorderFactory.createMyBorder(" History "));

		add(scroll, new GridBagConstraints(0, 2, 1, 1, 1.0, 1.0,
				GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
						5, 5, 5, 5), 0, 0));

		btGroup.add(jtbHistoryOn);
		btGroup.add(jtbHistoryOff);
		jtbHistoryOn.setSelected(true);

		jtbHistoryOn.addActionListener(this);
		jtbHistoryOff.addActionListener(this);

		JPanel panel = new JPanel();
		panel.add(new JLabel("History: "));
		panel.add(jtbHistoryOn);
		panel.add(jtbHistoryOff);

		add(panel, new GridBagConstraints(0, 3, 0, 1, 1.0, 0.0,
				GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 5), 0, 0));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == tfFrequency) {
			controller.setFrequency(Double.parseDouble(tfFrequency.getText()));
		} else {
			if (historyOn) {
				historyOn = false;
			} else {
				historyOn = true;
				txtArea.setText("");
			}
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == spinnerAmplitude)
			controller.setAmplitude(Double.parseDouble(spinnerAmplitude
					.getValue().toString()));
		if (e.getSource() == spinnerResolution)
			controller.setResolution(Short.parseShort(spinnerResolution
					.getValue().toString()));

		if (e.getSource() == spinnerForm)
			controller.setForm(spinnerForm.getValue().toString());
	}

	public void update(Observable obs, Object obj) {
		ServerModel model = (ServerModel) obs;

		jtfBlockLength.setText("" + model.getBlockLength());

		if (model.getConnectionState())
			jtfConnectionState.setText("Connected");
		else
			jtfConnectionState.setText("Not Connected");

		if (model.getRequest() == null)
			return;

		if (historyOn) {
			String txt = "";
			txt += model.getRequest() + "\n";
			String stResponse = model.getResponse();
			if (stResponse != null) {
				if (stResponse.length() < 50)
					txt += stResponse + "\n";
				else {
					txt += stResponse.substring(0, 50) + "\n";
					txt += "... \n";
					txt += stResponse.substring(stResponse.length() - 50,
							stResponse.length() - 1) + "\n";
				}
			}
			txtArea.append(txt);
		}

	}
}
