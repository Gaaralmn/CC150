/**
 * CC150 3.3 Implement a set of stacks with limited size!
 */
import java.util.*;
public class setofStacks {
	ArrayList<newStack> stacks = new ArrayList<newStack>();

	public newStack getLastStack() {
		if(stacks.size() == 0) {
			return null;
		}
		return stacks.get(stacks.size() - 1);
	}

	public int pop() throws EmptyStackException {
		if(stacks.size() == 0) {
			throw new EmptyStackException("The set of stacks is empty!");
		}
		newStack last = getLastStack();
		int tmp = last.pop();
		if(last.isEmpty()) {
			stacks.remove(last);
			System.out.println("One Stack of the set is removed!");
		}
		return tmp;
	}

	public void push(int val) {
		if(stacks.isEmpty()) {
			stacks.add(new newStack());
			System.out.println("The previous one is full and a new stack is added!");
		}
		newStack last = getLastStack();
		if(last.isFull()) {
			stacks.add(new newStack());
			last = getLastStack();
		}
		last.push(val);
	}

	public int top() throws IndexOutOfBoundsException {
		if(getLastStack() == null) {
			throw new IndexOutOfBoundsException("The set of stacks is empty!");
		}
		return getLastStack().top();
	}

	public static void main(String[] args) {
		setofStacks ss = new setofStacks();
		int i = 0; 
		while(i < 8) {
			ss.push(i);
			i++;
		}
		while(i > 0) {
			System.out.println(ss.pop());
			i--;
		}
		System.out.println(ss.top());
	}
}


