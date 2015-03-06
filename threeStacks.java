/* 3.1 Use a single array to implement three stacks
 */
public class threeStacks {
	public int stacksize = 100;
	public int[] buffer = new int[stacksize * 3];
	public int[] stackPointer = {-1, -1, -1};

	public void push(int stackNum, int value) throws Exception {
		if(stackPointer[stackNum] + 1 >= stacksize) {
			throw new Exception("Out of space!");
		}

		stackPointer[stackNum]++;
		buffer[indexofStack(stackNum)] = value;
	}

	public int pop(int stackNum) throws Exception {
		if(stackPointer[stackNum] == -1) {
			throw new Exception("This is an empty stack!");
		}
		int value = buffer[indexofStack(stackNum)];
		stackPointer[stackNum]--;
		return value;
	} 

	public int top(int stackNum) throws Exception {
		if(stackPointer[stackNum] == -1) {
			throw new Exception("This is an empty stack!");
		}
		return buffer[indexofStack(stackNum)];
	}

	public int indexofStack(int stackNum) {
		return stacksize * stackNum + stackPointer[stackNum];
	}
}