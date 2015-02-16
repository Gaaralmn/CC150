import java.util.*;

class Node {
	public int data;
	public Node next;

	public Node(int D, Node n) {
		data = D;
		next = n;
	}

	public void setNext(Node n) {
		next = n;
	}
} 

class IntWrapper {
	public int value = 0;
}

public class LinkedLists {
	Node head; 
	public void deleteDups1(Node n) {             // With buffer
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		Node prev = null;
		while(n != null) {
			if(table.containsKey(n.data)) {
				prev.next = n.next;
			} else {
				table.put(n.data, true);
				prev = n;
			}
			n = n.next;
		}
	}

	public void deleteDups2(Node n) {             // Without buffer
		Node current  = n;
		while(current.next != null) {
			Node runner = current;
			while(runner.next != null) {
				if(current.data == runner.next.data){
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
		
	}

	public int findkthTolast(Node n, int k) {
		if(n.next == null) {
			return 0;
		}
		int i = findkthTolast(n.next, k) + 1;
		if(i == k) {
			System.out.println(n.data);
			System.out.println(k);
		} 
		return i;
	}

	public Node findkthTolast1(Node n, int k, IntWrapper i) {
		if(n == null) {
			return null;
		}
		Node newNode = findkthTolast1(n.next, k, i);
		i.value += 1;
		if(i.value == k) {
			return n;
		} 
		return newNode;
	}

	public Node findkthTolast2(Node n, int k) {
		if(n == null) {
			return null;
		}
		Node p1 = n;
		Node p2 = n;
		for(int i = 0; i < k ; ++i) { // p1->p2->p3->p4
			if(p1 == null)
				return null;
			p1 = p1.next;
		}
		while(p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}

	public void deleteMiddle(Node mid) {
		if((mid == null)||(mid.next == null)) {

		} else {
			mid.data = mid.next.data;
			mid.next = mid.next.next;
		}
	}
	
	public void printNode(Node n) {
		do {
			System.out.println(n.data);
			n = n.next;
		} while(n.next != null);
		System.out.println(n.data);
		System.out.println('\n');
	}
	public static void main(String[] args) {
		LinkedLists L = new LinkedLists();
		L.head = new Node(0,null);
		Node n1 = new Node(1, null);
		L.head.setNext(n1);
		Node n2 = new Node(2, null);
		n1.setNext(n2);
		Node n3 = new Node(2, null);
		n2.setNext(n3);
		Node n4 = new Node(3, null);
		n3.setNext(n4);
		Node n5 = new Node(3, null);
		n4.setNext(n5);
		Node n6 = new Node(4, null);
		n5.setNext(n6);
		L.printNode(L.head);
		// IntWrapper i = new IntWrapper();
		//Node j = L.findkthTolast2(L.head, 7);
		L.deleteMiddle(n3);
		L.printNode(L.head);
		//System.out.println(i.value);
	}
}