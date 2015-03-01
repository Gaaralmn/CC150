import java.util.*;
/* CC150 3_1 Use a single array to implement three stacks !
 * Fixed partition !
 */
public class threeStack {
	private int stackSize = 100;
	public int[] buffer = new int[stackSize * 3];
	public int[] stackPointer = {-1, -1, -1};

	public void push(int val, int stackNum) {
		if(stackPointer[stackNum] + 1 >= stackSize) {
			System.out.println("The stack is full already!");
		}
		stackPointer[stackNum]++;
		int index = getIndex(stackNum);
		buffer[index] = val;
	} 

	public int pop(int stackNum) throws Exception {
		if(isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		int index = getIndex(stackNum);
		int tmp = buffer[index];
		stackPointer[stackNum]--;
		return index;
	}

	public boolean isEmpty(int stackNum) {
		if(stackPointer[stackNum] == -1)
			return true;
		return false;
	}

	public int getIndex(int stackNum) {
		int index = stackNum * stackSize + stackPointer[stackNum];
		return index;
	}

	public int peek(int stackNum) throws Exception {
		if(isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		int index = getIndex(stackNum);
		return buffer[index];
	}

	public static void main(String[] args) {
		threeStack ts = new threeStack();
		for(int i = 0; i <= 99; i++) {
			ts.push(i, 2);
		}
		System.out.println(ts.buffer[299]);
	}
}

