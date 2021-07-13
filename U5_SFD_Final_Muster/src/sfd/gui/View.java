package sfd.gui;

import java.awt.Dimension;

import javax.swing.JTabbedPane;

import util.MyBorderFactory;
import util.Observable;
import util.Observer;
import util.TraceV8;
import util.Utility;

public class View extends JTabbedPane implements Observer {
	private static final long serialVersionUID = 1L;
	private TraceV8 trace = new TraceV8(this);
	public NLPanel nlPanel;
	public SFPanel sfPanel;
	public FreqPanel freqPanel;

	public View(Controller controller) {
		trace.constructorCall();
		setPreferredSize(new Dimension(600, 600));
		setBorder(MyBorderFactory.createMyBorder(""));

		nlPanel = new NLPanel();
		addTab(" Netlist ", Utility.loadResourceIcon("\\axialis-blue\\24x24\\Write.png"), nlPanel);

		sfPanel = new SFPanel();
		addTab(" Signalfluss ", Utility.loadResourceIcon("\\axialis-blue\\24x24\\Write.png"), sfPanel);

		freqPanel = new FreqPanel();
		addTab(" Signalfluss ", Utility.loadResourceIcon("\\axialis-blue\\24x24\\Stats2.png"), freqPanel);
	}

	@Override
	public void update(Observable obs, Object obj) {
		trace.methodeCall();
		freqPanel.update(obs, obj);
	}
}
