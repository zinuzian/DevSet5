package sets;

import java.util.ArrayList;
import java.util.Random;

public class IntSetBins {
	ArrayList<Integer> IntSetBins;
	int maxval;
	int maxelems;
	double time[];
	
	public IntSetBins(){
		
	}
	
	public void intSetimp(int maxelems, int maxval) {
		this.maxval = maxval;
		this.maxelems = maxelems;
		IntSetBins = new ArrayList<Integer>(maxelems);
	}
	
	public void insert(int element) {
		if(!IntSetBins.contains(element)){
			IntSetBins.add(element);
		}	
	}
	
	public int size() {
		return IntSetBins.size();
	}
	
	public void report() {
		ArrayList<Integer> bin = new ArrayList<Integer>();
		
		for(int i = 0; i < maxval + 1; i++) {
			bin.add(0);
		}
		
		for(int i = 0; i < IntSetBins.size(); i++) {
			int value = bin.get(IntSetBins.get(i));
			bin.set(IntSetBins.get(i), value + 1);
		}
		
		int out = 0;
		for(int i = 0; i < bin.size(); i++) {
			for(int j = 0; j < bin.get(i); j++) {
				IntSetBins.set(out++, i);
			}
		}
		
	}
	
	public void print(){
		for(int i = 0; i < IntSetBins.size() ; i++) {
			System.out.println(i+": "+IntSetBins.get(i));
		}
	}
	
	public void generateSet() {
		Random random = new Random();
		while(IntSetBins.size() < maxelems) {
			insert(random.nextInt(maxval));
		}
	}
	
	
	///테스트 패키지에서 값을 참조하기 위한 get 함수 추가
	public int getMaxelements() {
		return maxelems;
	}
	
	public int getMaxvalue() {
		return maxval;
	}
	
	public int getset(int i) {
		return IntSetBins.get(i);
	}
}
