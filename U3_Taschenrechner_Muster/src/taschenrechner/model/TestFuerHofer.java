package taschenrechner.model;

public class TestFuerHofer {
	
	private static String string = " N0 - b0 - N1 - b1 - N2 - b2 - N3 ";
	private static String zahlen = "1.5, 3.7, 28, 56.7";
	

	public static void main(String[] args) {

		int l = string.length();
		System.out.println(l);
		string = string.trim();
		l = string.length();
		System.out.println(l);

		String[] result = string.split("[- ]+");
		
		for (String s : result) {
			System.out.println(s);
		}

		result = zahlen.split("[, ]+");
		double[] z = new double[result.length];
		for (int k= 0; k<z.length; k++) {
			z[k] = Double.parseDouble(result[k]);
			System.out.println(z[k]);
		}
	}
}
