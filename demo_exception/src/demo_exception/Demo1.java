package demo_exception;

public class Demo1 {

	public static int getIntValue() {
		String number = "4.23";
		try {
			return Integer.parseInt(number);

		} catch (NumberFormatException exception) {
			 System.out.println("Error in parseInt");
			 return 0;
		}

	}

	public static void main(String[] args) {
		int number = getIntValue();
		System.out.println(number);
	}

}
