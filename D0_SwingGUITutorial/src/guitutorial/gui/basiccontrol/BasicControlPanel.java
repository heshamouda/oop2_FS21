package guitutorial.gui.basiccontrol;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.Calendar;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import guitutorial.gui.Controller;
import guitutorial.gui.StatusBar;
import guitutorial.util.Utility;

public class BasicControlPanel extends JPanel implements ActionListener, ListSelectionListener, ItemListener, ChangeListener {

	private JLabel label = new JLabel("Label");

	private JTextField textField;
	private JTextField passWordField;

	private JButton btOk;
	private JComboBox comboBox;
	private JList list;
	private JCheckBox chinCheckBox, glassesCheckBox, hairCheckBox;
	private JSlider framesPerSecond;
	private String birdString = "Bird", catString = "Cat", dogString = "Dog";
	private String[] monthStrings = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December" };
	private JSpinner monthSpinner, dateSpinner, numberSpinner;
	private String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
	private JRadioButton birdButton, catButton, dogButton;

	private Controller controller;

	public BasicControlPanel(Controller controller) {
		super(new GridBagLayout());
		this.controller = controller;

		// JButton
		btOk = new JButton("OK", Utility.loadResourceIcon("axialis-blue/24x24/Ok.png"));
		btOk.setVerticalTextPosition(AbstractButton.CENTER);
		btOk.setHorizontalTextPosition(AbstractButton.TRAILING);
		btOk.setMnemonic(KeyEvent.VK_O);
		btOk.setActionCommand("Gruppe1:ok");
		btOk.addActionListener(this);

		// JComboBox
		comboBox = new JComboBox(petStrings);
		comboBox.setSelectedIndex(4);
		comboBox.setActionCommand("petList");
		comboBox.addActionListener(this);

		// JList
		DefaultListModel defaultListModel = new DefaultListModel();
		defaultListModel.addElement("Scott Hommel");
		defaultListModel.addElement("Alan Sommerer");
		defaultListModel.addElement("Debbie Scott");
		list = new JList(defaultListModel);
		list.setVisibleRowCount(2);
		list.addListSelectionListener(this);
		JScrollPane listScroller = new JScrollPane(list);

		// JRadioButton
		birdButton = new JRadioButton(birdString);
		birdButton.setMnemonic(KeyEvent.VK_B);
		birdButton.setActionCommand(birdString);
		birdButton.setSelected(true);
		birdButton.addActionListener(this);

		catButton = new JRadioButton(catString);
		catButton.setMnemonic(KeyEvent.VK_C);
		catButton.setActionCommand(catString);
		catButton.addActionListener(this);

		dogButton = new JRadioButton(dogString);
		dogButton.setMnemonic(KeyEvent.VK_D);
		dogButton.setActionCommand(dogString);
		dogButton.addActionListener(this);

		ButtonGroup group = new ButtonGroup();
		group.add(birdButton);
		group.add(catButton);
		group.add(dogButton);

		// JCheckBox
		chinCheckBox = new JCheckBox("Chin");
		chinCheckBox.setMnemonic(KeyEvent.VK_C);
		chinCheckBox.setSelected(true);
		glassesCheckBox = new JCheckBox("Glasses");
		glassesCheckBox.setMnemonic(KeyEvent.VK_G);
		glassesCheckBox.setSelected(false);
		hairCheckBox = new JCheckBox("Hair");
		hairCheckBox.setMnemonic(KeyEvent.VK_H);
		hairCheckBox.setSelected(true);
		chinCheckBox.addItemListener(this);
		glassesCheckBox.addItemListener(this);
		hairCheckBox.addItemListener(this);

		// JSlider
		framesPerSecond = new JSlider(JSlider.HORIZONTAL, 0, 30, 15);
		framesPerSecond.addChangeListener(this);
		framesPerSecond.setMajorTickSpacing(10);
		framesPerSecond.setMinorTickSpacing(2);
		framesPerSecond.setPaintTicks(true);
		framesPerSecond.setPaintLabels(true);
		framesPerSecond.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				if (e.getWheelRotation() < 0) {
					framesPerSecond.setValue(framesPerSecond.getValue() + framesPerSecond.getMinorTickSpacing());
				}
				if (e.getWheelRotation() > 0) {
					framesPerSecond.setValue(framesPerSecond.getValue() - framesPerSecond.getMinorTickSpacing());
				}
			}
		});

		// JSpinner 
		SpinnerListModel spinnerListModel = new SpinnerListModel(monthStrings);
		monthSpinner = new JSpinner(spinnerListModel);
		monthSpinner.addChangeListener(this);
		monthSpinner.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				Object s;
				if (e.getWheelRotation() < 0 && (s = monthSpinner.getNextValue()) != null) {
					monthSpinner.setValue(s);
				}
				if (e.getWheelRotation() > 0 && (s = monthSpinner.getPreviousValue()) != null) {
					monthSpinner.setValue(s);
				}
			}
		});

		// JSpinner 
		SpinnerDateModel spinnerDateModel = new SpinnerDateModel();
		spinnerDateModel.setCalendarField(Calendar.DAY_OF_MONTH);
		dateSpinner = new JSpinner(spinnerDateModel);
		JSpinner.DateEditor editor = new JSpinner.DateEditor(dateSpinner, "MMMM dd, yyyy");
		dateSpinner.setEditor(editor);
		dateSpinner.addChangeListener(this);
		dateSpinner.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				Object s;
				if (e.getWheelRotation() < 0 && (s = dateSpinner.getNextValue()) != null) {
					dateSpinner.setValue(s);
				}
				if (e.getWheelRotation() > 0 && (s = dateSpinner.getPreviousValue()) != null) {
					dateSpinner.setValue(s);
				}
			}
		});

		// JSpinner 
		SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(50, 0, 100, 5);
		numberSpinner = new JSpinner(spinnerNumberModel);
		numberSpinner.addChangeListener(this);
		numberSpinner.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				Object s;
				if (e.getWheelRotation() < 0 && (s = numberSpinner.getNextValue()) != null) {
					numberSpinner.setValue(s);
				}
				if (e.getWheelRotation() > 0 && (s = numberSpinner.getPreviousValue()) != null) {
					numberSpinner.setValue(s);
				}
			}
		});

		// JTextField
		textField = new JTextField();
		textField.setActionCommand("textInput");
		textField.addActionListener(this);

		// JPasswordField
		passWordField = new JPasswordField();
		passWordField.setActionCommand("pwdInput");
		passWordField.addActionListener(this);

		// Adding stuff to display
		add(btOk, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));
		add(comboBox, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));
		add(listScroller, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.BOTH,
				new Insets(10, 10, 10, 10), 0, 0));
		add(birdButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
				new Insets(10, 10, 10, 10), 0, 0));
		add(catButton, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
				new Insets(10, 10, 10, 10), 0, 0));
		add(dogButton, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
				new Insets(10, 10, 10, 10), 0, 0));
		add(chinCheckBox, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
				new Insets(10, 10, 10, 10), 0, 0));
		add(glassesCheckBox, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
				new Insets(10, 10, 10, 10), 0, 0));
		add(hairCheckBox, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
				new Insets(10, 10, 10, 10), 0, 0));
		add(monthSpinner, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(dateSpinner, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(numberSpinner, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(label, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE,
				new Insets(10, 10, 10, 10), 0, 0));
		add(textField, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST, GridBagConstraints.HORIZONTAL,
				new Insets(10, 10, 10, 10), 0, 0));
		add(passWordField, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));
		add(framesPerSecond, new GridBagConstraints(0, 5, 3, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(10, 10, 10, 10), 0, 0));

		// Klebstoff tut immer gut ...
		add(Box.createVerticalGlue(), new GridBagConstraints(0, 6, 3, 1, 0.0, 1.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.VERTICAL, new Insets(0, 0, 0, 0), 0, 0));
		add(Box.createHorizontalGlue(), new GridBagConstraints(3, 0, 1, 6, 1.0, 0.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("ok")) {
			StatusBar.showStatus(this, e, e.getActionCommand());
		}
		if (e.getActionCommand().equals("petList")) {
			StatusBar.showStatus(this, e,
					e.getActionCommand() + "->" + ((JComboBox) e.getSource()).getSelectedItem().toString());
		}
		if (e.getActionCommand().equals(birdString) || e.getActionCommand().equals(catString)
				|| e.getActionCommand().equals(dogString)) {
			StatusBar.showStatus(this, e, e.getActionCommand());
		}
	}

	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() instanceof JSlider) {
			if (e.getValueIsAdjusting() == false) {
				if (list.getSelectedIndex() == -1) {
					StatusBar.showStatus("None");
				} else {
					StatusBar.showStatus(this, e, list.getModel().getElementAt(list.getSelectedIndex()).toString());
				}
			}
		}
	}

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() instanceof JCheckBox) {
			StatusBar.showStatus(this, e, ((JCheckBox) e.getSource()).getText());
		}
	}

	public void stateChanged(ChangeEvent e) {
		if (e.getSource() instanceof JSlider) {
			JSlider source = (JSlider) e.getSource();
			if (!source.getValueIsAdjusting()) {
				int fps = (int) source.getValue();
				StatusBar.showStatus(this, e, "Wert: " + fps);
			}
		}
		if (e.getSource() instanceof JSpinner) {
			StatusBar.showStatus(this, e, ((JSpinner) e.getSource()).getModel().getValue().toString());
		}
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				} catch (Exception exception) {
					exception.printStackTrace();
				}
				JFrame frame = new JFrame();
				frame.setUndecorated(true);
				frame.getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setTitle("BasicControlPanel");
				frame.getContentPane().add(new BasicControlPanel(null));
				frame.pack();
				frame.setMinimumSize(frame.getPreferredSize());
				frame.setVisible(true);
			}
		});
	}
}
