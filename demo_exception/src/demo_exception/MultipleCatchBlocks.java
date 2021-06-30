package demo_exception;

public class MultipleCatchBlocks {
	
	public static void main(String[] args) {
		try { 
		System.out.println("Sratemnt1");
		System.out.println(10/0);
		System.out.println("Sratemnt3");
		
	}catch (ArithmeticException e) {
		System.out.println(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
