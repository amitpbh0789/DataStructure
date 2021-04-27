import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocktest {

	public static void main(String[] args) {
		ReentrantLock mutex = new ReentrantLock();
		
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				
				try {
					mutex.lock();
					System.out.println("Lock acquired by t and count is "+mutex.getHoldCount());
					mutex.lock();
					System.out.println("Lock acquired by t and count is "+mutex.getHoldCount());
					mutex.lock();
					System.out.println("Lock acquired by t and count is "+mutex.getHoldCount());
				}catch(Exception e) {
					mutex.unlock();
				}
				
			}
		});
		
		t.start();
	}
}
