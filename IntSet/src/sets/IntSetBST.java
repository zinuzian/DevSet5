package sets;

import java.util.Iterator;
import java.util.TreeSet;

public class IntSetBST {
	
	private int maxelems; // maximum number of elements
	private int maxval; // maximum value of element
	private TreeSet<Integer> bst = null;
	
	IntSetBST(int maxelems, int maxval) {
		this.maxelems = maxelems;
		this.maxval = maxval;
		this.bst = new TreeSet<Integer>();
	}
	
	public void insert(int element) {
		if (this.bst.size() >= this.maxelems) {
			return;
		} else if (element > this.maxval) {
			return;
		} else {
			this.bst.add(element);
		}
	}
	
	public int size() {
		return this.bst.size();
	}
	
	public int[] report() {
		int[] returnValue = new int[this.size()];
		
		Iterator<Integer> iterator = this.bst.iterator();
		int index = 0;
		while (iterator.hasNext()) {
			returnValue[index++] = iterator.next();
		}
		
		return returnValue;
	}
	
}
