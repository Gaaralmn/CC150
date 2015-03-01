/**
 * CC150 3.6 Sort a Stack to ascending order with an aditional Stack.
 * Date: Feb 28, 2015
 * @author Qing Wang
 * Tag: Use the property of stack.
 * Following Up: If ultimated stacks are allowed, how to sort? 
 * Hints for following up: Use modified quicksort or mergesort!
 */
import java.util.*;
public class stackSort {
/**
 * Original method.
 */
	public void sort(Stack<Integer> stack) {
		Stack<Integer> newStack = new Stack<Integer>();
		if(stack.size() > 1) {
			newStack.push(stack.pop());
			while(!stack.isEmpty()) {
				if(newStack.peek() > stack.peek()) {
					newStack.push(stack.pop());
				} else {
					int tmp = stack.pop();
					int count = 0;
					while(!newStack.isEmpty() && newStack.peek() < tmp) {
						stack.push(newStack.pop());
						count++;
					}
					newStack.push(tmp);
					while(count > 0) {
						newStack.push(stack.pop());
						count--;
					}
				}
			}
			while(!newStack.isEmpty()) {
				stack.push(newStack.pop());
			}
		}
	}

	public Stack<Integer> Sort(Stack<Integer> stack) {
		Stack<Integer> newStack = new Stack<Integer>();
		while(!stack.isEmpty()) {
			int tmp = stack.pop();
			while(!newStack.isEmpty() && newStack.peek() > tmp) {
				stack.push(newStack.pop());
			}
			newStack.push(tmp);
		}
		return newStack;
	}
/**
 * Test part! 
 */
	public static void main(String[] args) {
		stackSort ss = new stackSort();
		Stack<Integer> s = new Stack<Integer>();
		s.push(3);
		s.push(7);
		s.push(6);
		s.push(8);
		s.push(1);
		s.push(5);
		s.push(2);
		s.push(9);
		s.push(0);
		s.push(4);
		s = ss.Sort(s);
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}
	}
}