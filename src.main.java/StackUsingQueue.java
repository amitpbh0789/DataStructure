import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) {

		StackUsingQueue stack = new StackUsingQueue();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());
		stack.pop();
		System.out.println(stack.peek());

	}

	/**
	 * O(N)
	 */
	public void push(int val) {
		int size = queue.size();
		queue.offer(val);
		for(int i=0; i<size; i++) {
			queue.offer(queue.poll());
		}
		
	}

	/**
	 * O(1)
	 */
	public int pop() {

		if(queue.isEmpty())
			return -1;
		else
			return queue.poll();
	}
	
	/**
	 * O(1)
	 */
	public int peek() {
		if(queue.isEmpty())
			return -1;
		else
			return queue.peek();
	}
}
