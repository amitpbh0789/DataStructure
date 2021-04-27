import java.util.concurrent.Semaphore;

public class SemaphoreTest {

	public static void main(String[] args) {
		Semaphore mutex = new Semaphore(2);
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					mutex.acquire();
					System.out.println(mutex.availablePermits());
					mutex.acquire();
					System.out.println(mutex.availablePermits());
//					mutex.acquire(); // Mutex limit is over so thread will hang forever until lock is released
//					System.out.println(mutex.availablePermits());
				}catch(Exception e) {
					
				} finally {
					mutex.release();
				}
			}
		});
		t.start();
	}
}
