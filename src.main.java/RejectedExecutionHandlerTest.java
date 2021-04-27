import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;


public class RejectedExecutionHandlerTest {

	public static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
	public static ThreadPoolExecutor alternateExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
	public static void main(String[] args) {

		MyRejectedExecutionHandler handler = new MyRejectedExecutionHandler();
		executor.setRejectedExecutionHandler(handler);
		
		Worker[] arr = new Worker[10];
		for(int i=0; i<arr.length; i++) {
			arr[i] = new Worker(i);
			executor.execute(arr[i]);
			if(i==6)
				executor.shutdown();
		}
		executor.shutdown();
		while(!executor.isTerminated()) {
			
		}
		System.out.println("Rejeced execution handler will start executing the remaining work");
		alternateExecutor.shutdown();
		while(!alternateExecutor.isTerminated()) {
		}
		System.out.println("Alternate Execution Completed");
		
	}
}

class MyRejectedExecutionHandler implements RejectedExecutionHandler{

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		
		System.out.println(r.toString()+ "is Rejected");
		System.out.println("MyRejectedExecutionHandler trying to execute again");
		try {
			RejectedExecutionHandlerTest.alternateExecutor.execute(r);
			System.out.println(r.toString()+ " started by MyRejectedExecutionHandler");
		}catch(Exception e) {
			
		}
	}
}

class Worker implements Runnable{
	int id;
	public Worker(int i) {
		this.id = i;
	}
	@Override
	public void run() {
		
		try {
			System.out.println("Execution Started");
			Thread.sleep(100);
			System.out.println("Execution Completed");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Worker [id=" + id +"]";
	}
	
	
}
