
public class Synchronizer {

	private int balance = 0;

	public void balanceMaker() {

		Thread t1;

		Thread t2;
		
		
		System.out.println("balance = " + balance);

	}

	public  void add() {
		balance++;

	}

	public void sub() {
		balance--;
	}
	
	

	public static void main(String[] args) {
		Synchronizer sync = new Synchronizer();
		sync.balanceMaker();

	}

}
