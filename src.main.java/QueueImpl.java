import java.util.Stack;

public class QueueImpl {

	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();
	public static void main(String[] args) {
		
		QueueImpl queue = new QueueImpl();
		queue.enqueue(4);
		queue.enqueue(2);
		queue.enqueue(10);
		queue.enqueue(1);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
	
	public void enqueue(int val) {
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		s1.push(val);
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
	
	public int dequeue() {
		if(!s1.isEmpty()) {
			return s1.pop();
		}
		return 0;
	}
}
