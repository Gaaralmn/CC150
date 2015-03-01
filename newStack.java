public class newStack {
	private static final int capacity = 3;
	public int size;
	public Node top;

	public newStack() {
		size = 0;
		top = null;
	}

	public boolean isEmpty() {
		return size ==0;
	}

	public boolean isFull() {
		return size == capacity;
	}

	public void push(int val) throws FullStackException {
		if(isFull()) {
			throw new FullStackException("The Stack is full already!");
		}
		Node tmp = new Node(val, top);
		top = tmp;
		size++;
	}

	public int pop() throws EmptyStackException {
		if(isEmpty()) {
			throw new EmptyStackException("The Stack is empty!");
		}
		int tmp = top.getElement();
		top = top.getNext();
		size--;
		return tmp;
	}

	public int top() throws EmptyStackException {
		if(isEmpty()) {
			throw new EmptyStackException("The Stack is empty!");
		}
		return top.getElement();
	}
}