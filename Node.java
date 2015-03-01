public class Node {
	private int element;
	public Node next;

	public Node() {
		this(0, null);
	}

	public Node(int e, Node n) {
		element = e;
		next = n;
	}

	public void setNext(Node n) {
		next = n;
	}

	public Node getNext() {
		return this.next;
	}

	public void setElement(int val) {
		element = val;
	}

	public int getElement() {
		return element;
	}
}