package Thread;

public class WaitingThread extends Thread{

	private Thread thread1;
	private Thread thread2;
	
	public WaitingThread(Thread thread1, Thread thread2) {
		this.thread1 = thread1;
		this.thread2 = thread2;
	}
	
	public void run() {
		thread1.start();
		
		try {
			thread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thread2.start();
	}
}
