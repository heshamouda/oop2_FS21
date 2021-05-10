package test;

public class F {
	String s = "F";

	String m() {
		return s;

	}
}

class G extends F {
	String m() {
		return super.m() + "G";

	}

	String n() {
		return super.m() + "X";

	}

	public static void main(String[] args) {
		System.out.println(new G().n());

	}

}
