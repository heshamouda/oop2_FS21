
public class EasyRunnable implements Runnable {

	private String name;

	public EasyRunnable(String name) {
		this.name = name;
	}

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new EasyRunnable("easyRunnable1"));
		
		thread.start();
		
		System.out.println("Wait for other easyRunnable");
		thread.join();
		System.out.println("Main Thread is ready");
	}

	public void run() {
		for (int i = 1; i < 10; i++) {
			
			System.out.println(name + " is counting " + i);
		}
		
		System.out.println(name + " is ready");
	}
}
