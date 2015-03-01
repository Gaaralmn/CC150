import java.util.*;
/* CC150 3.2 Implement a stack with method min to return the min value in stack !*/
public class minStack extends Stack<stackNode>{
	public void push(int val) {
		int newmin = Math.min(val, min());
		super.push(new stackNode(val, newmin));
	}

	public int min() {
		if(this.empty()) {
			return Integer.MAX_VALUE;
		}
		return this.peek().min;
	}

	public static void main(String[] args) {
		minStack ms2 = new minStack();
		ms2.push(8);
		ms2.push(3);
		ms2.push(6);
		ms2.push(4);
		ms2.push(9);
		ms2.push(1);
		System.out.println(ms2.min());
		ms2.pop();
		System.out.println(ms2.min());
	}
}

class minStack2 extends Stack<Integer>{
	Stack<Integer> assistStack = new Stack<Integer>();

	public void push(int val) {
		if(val < min()) {
			assistStack.push(val);
		}
		super.push(val);
	}

	public Integer pop() {
		int val = super.pop();
		if(val == min()) {
			assistStack.pop();
		}
		return val;
	}

	public int min() {
		if(empty()) {
			return Integer.MAX_VALUE;
		}
		return assistStack.peek();

	}
}

class stackNode {
	public int value;
	public int min;
	stackNode(int v, int m) {
		value = v;
		min = m;
	}
}