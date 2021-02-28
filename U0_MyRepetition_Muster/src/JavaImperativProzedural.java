public class JavaImperativProzedural {

	// !!!Primitive Datentypen:!!!

	boolean bool = true;
	char c = 'c';

	// Ganzzahlen
	byte bt = 0;
	short st = 0;
	int i = 0;
	long l = 0l;

	// Fliesskommazahlen
	float f = 0.0f;
	double d = 0.0;

	public static void main(String[] args) {
		// !!! Imperative Sprachelemente:!!!
		int i = 0; // Lokale Var.

		float ergebnis = 2.0f * 5 / 2; //1. Mit Cast spielen
		System.out.println("Ergebnis = " + ergebnis);

		// Verzweigungen:
		if (i > 0) {
			System.out.println("Wert i grösser 0: " + i);

		} else {
			System.out.println("Wert i kleiner gleich 0: " + i);
		}

		switch (i) {
		case 0:
			System.out.println("Wert i  gleich 0: " + i);
			break;

		case 1:
			System.out.println("Wert i  gleich 1: " + i);

			break;
		default:
			break;
		}

		// Schleifen:
		for (int j = 0; j < 5; j++) {
			System.out.println("Wert j: " + j);
		}

		int k = 0;
		do {
			System.out.println("Wert k: " + k);
			k++;
		} while (k < 5);

		int l = 0;
		while (l < 5) {
			System.out.println("Wert l: " + l);
			l++;
		}

		// !!!Prozedurale Sprachelemente:!!!

		double x = 7.0;
		double y = quadrat(x);
		System.out.println("Wert x: " + x + " Wert y: " + y);

		int z = (int) magic((int) x, 5.0);
		System.out.println(z);
	}

	// Überladen:
	public  static double quadrat(double x) {
		System.out.println("quadrat(double x)");
		return x * x;
	}

	
	public static float quadrat(float x) {
		System.out.println("quadrat(float x)");
		return x * x;
	}
	

	public static double magic(double x, double y) {
		System.out.println("double magic");
		return x * x * y;
	}

	public static int magic(float x, float y) {
		System.out.println("int magic");
		return (int) (x * x * y);
	}

}
