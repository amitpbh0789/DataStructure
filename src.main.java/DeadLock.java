
public class DeadLock {

	
	public static void main(String[] args) {
		Object mutex1 = new Object();
		Object mutex2 = new Object();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					synchronized(mutex1) {
						System.out.println("lock acquired on mutex1 by thread1");
						
						Thread.sleep(100);
						System.out.println("waiting for lock on mutex2 by thread1");
						synchronized(mutex2){
							System.out.println("Acquired lock on mutex2 by thread1");
						}
					}
				}catch(Exception e) {
					
				}
				
			}
		});
		
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					synchronized(mutex2) {
						System.out.println("lock acquired on mutex2 by thread2");
						
						Thread.sleep(100);
						System.out.println("waiting for lock on mutex1 by thread2");
						synchronized(mutex1){
							System.out.println("Acquired lock on mutet1 by thread 2");
						}
					}
				}catch(Exception e) {
					
				}
				
			}
		});
		
		t1.start();
		t2.start();
	}
}
