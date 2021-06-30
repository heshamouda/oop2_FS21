package demo_exception;

public class Demo1 {

	public static int getIntValue() throws NumberFormatException {
		String number = "4.23";
		try {
			return Integer.parseInt(number);

		} catch (NumberFormatException exception) {
//			exception.printStackTrace();
			System.out.println(exception.toString());
			exception.getMessage();

			return 0;
		}

	}

	public static void main(String[] args) {
		int number = getIntValue();
		System.out.println(number);
	}

}
