import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerTest {

	public static void main(String[] args) throws InterruptedException {
		ProducerConsumer obj = new ProducerConsumer();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					obj.produce();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					obj.consume();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
	}
}

class ProducerConsumer{
	
	Queue<Integer> queue = new LinkedList<>();
	int capacity = 3;
	int count=1;
	
	public void produce() throws InterruptedException {
		
		while(true) {
			synchronized(this) {
				if(queue.size() == capacity)
					wait();
				System.out.println("Producer produced "+ count);
				queue.add(count++);
				notify();
				Thread.sleep(1000);
			}
		}
	}
	
	public void consume() throws InterruptedException {
		while(true) {
			synchronized(this) {
				if(queue.size()==0)
					wait();
				int num = queue.poll();
				System.out.println("Concumer consumed "+num);
				notify();
				Thread.sleep(1000);
			}
		}
	}
}
