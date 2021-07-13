package sfd.model;

import java.util.HashMap;

import util.Observable;
import util.TraceV8;

public class Model extends Observable {
	private TraceV8 trace = new TraceV8(this);
	private HashMap<String, RationalFunction> branchMap = new HashMap<>();
	private HashMap<String, RationalFunction> fwdMap = new HashMap<>();
	private HashMap<String, RationalFunction> loopMap = new HashMap<>();
	private HashMap<String, RationalFunction> detMap = new HashMap<>();

	private String[] fwdPath;
	private String[] loops;
	private String[] kofaktor;
	private String determinante;
	RationalFunction rationalFunction;
	private Complex[] H = new Complex[0];
	private double[] faxis = new double[0];

	public Model(double fStart, double fStop, int n) {
		trace.constructorCall();
		faxis = new double[n];
		for (int i = 0; i < faxis.length; i++) {
			faxis[i] = fStart + i * (fStop - fStart) / (n - 1);
		}
	}

	public void setNetlist(String[] netlist) {
		trace.methodeCall();
		for (int k = 0; k < netlist.length; k++) {
			String[] item = netlist[k].split("[{}]+");
			String branchID = item[0].split("[\t ]+")[0];
			branchMap.put(branchID, new RationalFunction(new Polynom(item[1]), new Polynom(item[2])));
		}
		System.out.println(branchMap);
	}

	public void setSignalflow(String[] signalflow) {
		trace.methodeCall();
		fwdPath = new String[(signalflow.length - 1) / 2];
		kofaktor = new String[(signalflow.length - 1) / 2];
		for (int k = 0; k < signalflow.length - 1; k += 2) {
			fwdPath[k / 2] = signalflow[k];
			kofaktor[k / 2] = signalflow[k + 1];
		}
		determinante = signalflow[signalflow.length - 1];
	}

	public void setLoops(String[] loops) {
		trace.methodeCall();
		this.loops = loops;
		System.out.println(loops);
	}

	public void berechne() {
		trace.methodeCall();
		// Loops berechnen: L1 N1 - b1 - N2 - b2 -
		for (int k = 0; k < loops.length; k++) {
			RationalFunction loopFun = new RationalFunction(new Polynom(1.0), new Polynom(1.0));
			String[] items = loops[k].split("[\t -]+");
			String loopID = items[0];
			for (int i = 1; i < items.length - 1; i += 2) {
				loopFun = loopFun.multiply(branchMap.get(items[i + 1]));
			}
			loopMap.put(loopID, loopFun);
		}

		// Vorwärtspfade: P1 Nin - b0 - N1 - b1 - N2 - b3 - Nout
		for (int k = 0; k < fwdPath.length; k++) {
			RationalFunction fwdFun = new RationalFunction(new Polynom(1.0), new Polynom(1.0));
			String[] items = fwdPath[k].split("[\t -]+");
			String fwdID = items[0];
			for (int i = 2; i < items.length; i += 2) {
				fwdFun = fwdFun.multiply(branchMap.get(items[i]));
			}
			fwdMap.put(fwdID, fwdFun);
		}

		// Determinante: D 1  L1  L1*L2 - ...
		RationalFunction detFun = new RationalFunction(new Polynom(1.0), new Polynom(1.0));
		String[] items = determinante.split("[\t +-]+"); // Reihenfolge der Delimiter gem. RegExp: https://regex101.com/
		String detID = items[0];
		for (int i = 2; i < items.length; i++) {
			detFun = detFun.add(productLoops(items[i]));
		}
		detMap.put(detID, detFun);

		// Kofaktoren: D1 1  L1  L1*L2 - ...
		for (int i = 0; i < kofaktor.length; i++) {
			RationalFunction coFun = new RationalFunction(new Polynom(1.0), new Polynom(1.0));
			items = kofaktor[i].split("[\t +-]+"); // Reihenfolge der Delimiter gem. RegExp: https://regex101.com/
			String coID = items[0];
			for (int k = 2; k < items.length; k++) {
				coFun = coFun.add(productLoops(items[k]));
			}
			detMap.put(coID, coFun);
		}

		// Übertragungsfunktion
		rationalFunction = new RationalFunction(new Polynom(1.0), new Polynom(1.0));
		rationalFunction = fwdMap.get("P1").multiply(detMap.get("D1"));
		for (int k = 2; fwdMap.containsKey("P" + k); k++) {
			RationalFunction prod = fwdMap.get("P" + k).multiply(detMap.get("D" + k));
			rationalFunction = rationalFunction.add(prod);
		}
		rationalFunction = rationalFunction.divide(detMap.get("D"));
		H = rationalFunction.freqs(faxis);
		notifyObservers();
	}

	private RationalFunction productLoops(String s) { // Bsp. für s: L1 oder L1*L2 oder L1*L2*L3
		trace.methodeCall();
		RationalFunction proFun = new RationalFunction(new Polynom(1.0), new Polynom(1.0));
		String[] items = s.split("[*]+");
		for (int i = 0; i < items.length; i++) {
			proFun = proFun.multiply(loopMap.get(items[i]));
		}
		if (items.length % 2 == 1) {
			return proFun.multiply(new RationalFunction(new Polynom(-1.0), new Polynom(1.0)));
		} else {
			return proFun;
		}
	}

	/**
	 * Benachrichtigt Observers.
	 */
	public void notifyObservers() {
		trace.methodeCall();
		setChanged();
		super.notifyObservers();
	}

	/**
	 * Holt Frequenzachse.
	 * 
	 * @return
	 */
	public double[] getFaxis() {
		trace.methodeCall();
		return faxis;
	}

	/**
	 * Holt Amplitude von H.
	 * 
	 * @return
	 */
	public double[] getAmplitude() {
		trace.methodeCall();
		return Complex.abs(H);
	}

	/**
	 * Holt Phase von H.
	 * 
	 * @return
	 */
	public double[] getPhase() {
		trace.methodeCall();
		return Complex.angle(H);
	}

	public int getLength() {
		trace.methodeCall();
		if (H == null)
			return 0;
		else
			return H.length;
	}

	public RationalFunction getRationalFunction() {
		trace.methodeCall();
		return rationalFunction;
	}
}
