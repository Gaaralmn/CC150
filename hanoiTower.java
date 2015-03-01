/**
 * Classic problem: Tower of Hanoi
 * @author Qing Wang 
 * Tag: "Recursive!", Think about it hardly!
 * Date: Feb 28, 2015
 */

import java.util.*;
public class hanoiTower {
	public static void main(String[] args) {
		Tower[] towers = new Tower[3];
		for(int i = 0; i < 3; i++) {
			towers[i] = new Tower(i);
		}
		int n = 10;
		for(int j = n; j > 0; j--) {
			towers[0].add(j);
		}
		towers[0].moveDisks(n, towers[2], towers[1]);
		towers[2].showTower();


	}
} 

class Tower {
	private Stack<Integer> T;
	private int index;

	public Tower(int i) {
		T = new Stack<Integer>();
		index = i; 
	}

	public int index() {
		return index;
	}

	public void add(int disk) {
		if(!T.isEmpty() && T.peek() <= disk) {
			System.out.println("There is problem placing disk!");
		} else {
			T.push(disk);
		}
	}

	public void showTower() {
		while(!T.isEmpty()) {
			System.out.print(T.pop() + " ");
		}
		System.out.println();
	}

	public void moveTopto(Tower t) {
		int top = T.pop();
		t.add(top);
		//System.out.println("Move disk" + top + "from" + index() + "to" + t.index());
	}

	public void moveDisks(int n, Tower dest, Tower buffer) {
		if(n > 0) {
			moveDisks(n-1, buffer, dest);
			moveTopto(dest);
			buffer.moveDisks(n-1, dest, this);
		}
	}
}