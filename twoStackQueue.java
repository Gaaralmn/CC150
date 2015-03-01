/**
 * CC150 3.5 Implement a Myqueue class which implements a queue using two stacks.
 * @author Qing Wang
 * Tag: 
 */
import java.util.*;
public class twoStackQueue {
	private Stack<Integer> stack;
	private Stack<Integer> bufferStack;

	public twoStackQueue() {
		stack = new Stack<Integer>();
		bufferStack = new Stack<Integer>();
	}

	public void add(int val) {
		stack.push(val);
	}

	public int poll() throws EmptyStackException {
		if(bufferStack.isEmpty()) {
			while(!stack.isEmpty()) {
				int tmp = stack.pop();
				bufferStack.push(tmp);
			}
		}
		if(bufferStack.isEmpty()) {
			throw new EmptyStackException("The queue is empty!");
		} else {
			return bufferStack.pop();
		}
	}

	public int peek() throws EmptyStackException {
		if(bufferStack.isEmpty()) {
			while(!stack.isEmpty()) {
				int tmp = stack.pop();
				bufferStack.push(tmp);
			}
		}
		if(bufferStack.isEmpty()) {
			throw new EmptyStackException("The queue is empty!");
		} else {
			return bufferStack.peek();
		}
	}

	public static void main(String[] args) {
		twoStackQueue tsq = new twoStackQueue();
		tsq.add(1);
		tsq.add(2);
		tsq.add(4);
		tsq.add(3);

		tsq.poll();
		tsq.poll();
		System.out.println(tsq.poll());
		tsq.poll();
		tsq.poll();
	}
}