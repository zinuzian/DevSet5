package com.intsetarr;

public class IntSetArr {

	int arr[];
	int size;
	
	public IntSetArr(int m, int maxval) {
		arr = new int[m];
		size = 0;
	}
	
	public void insert(int element) {
		int p = findPlace(element);
		
		for (int i = p, j = 0; i < size; ++i, ++j) {
			arr[size - j] = arr[size - j - 1];
		}
		
		arr[p] = element;
		System.out.print("Insert "+element+": ");
		print();
		++size;
	}
	
	public int size() {
		return size;
	}
	
	public void report(int v[]) {
		for (int i = 0; i < size; ++i) {
			v[i] = arr[i];
		}
	}
	
	private int findPlace(int element) {
		int i = 0;
		
		for (i = 0; i < size; ++i) {
			if (arr[i] > element)
				break;
		}
		
		return i;
	}
	
	private void print() {
		for (int i = 0; i < size + 1; ++i) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
