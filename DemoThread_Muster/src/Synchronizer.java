
public class Synchronizer {

	private int balance = 0;

	public void balanceMaker() {

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					add();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10000; i++) {
					sub();
				}

			}
		});

		t1.start();
		t2.start();
		try {
			t1.join(); // wait until threads are finished
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("balance = " + balance);

	}

	public synchronized void add() {
		balance++;

	}

	public synchronized void sub() {
		balance--;
	}
	
	

	public static void main(String[] args) {
		Synchronizer sync = new Synchronizer();
		sync.balanceMaker();

	}

}
