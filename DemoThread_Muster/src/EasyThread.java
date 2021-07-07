
public class EasyThread extends Thread {
	
	private String name;
	
	public EasyThread(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		EasyThread thread = new EasyThread("easyThread1");
		EasyThread thread2 = new EasyThread("easyThread2");
		thread.start();
		thread2.start();
		System.out.println("Wait for other easyThread");
		
		System.out.println("Main Thread is ready");
	}
	
	public void run() {
		for(int i = 1; i< 10; i++) {
			
			System.out.println(name + " is counting "+ i);
		}
		
		System.out.println(name + " is ready");
	}
}
