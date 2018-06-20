package set;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class IntSetSimplelists {

	private int max_element = 0;
	private int max_value = 0;
	private LinkedList<Integer> set = null;

	public static void main(String[] args){
		try {
			File file = new File("output.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));


			Random random = new Random();
			int maxValue = 1000000;
			int maxElem = 10000;
			IntSetSimplelists set = new IntSetSimplelists();
			set.intSetImp(maxElem, maxValue);

			ArrayList<Integer> pool = new ArrayList<Integer>();
			for(int i=0;i<maxValue;i++) {
				pool.add(i);
			}
			System.out.println("Pool gened");

			while(set.size()<maxElem) {
				int num = random.nextInt(pool.size());
				int val = pool.get(num);
				set.insert(val);
				pool.remove(num);
			}

			System.out.println("Inserted");

			Integer [] result = set.report();


			String s = "{ ";
			for(int i=0;i<maxElem;i++){
				s += String.valueOf(result[i])+" ";
				if(i%100==99){
					s+="\n";
					bw.write(s);
					s="";
				}
			}
			s += " }";
			bw.write(s);

			bw.close();
			System.out.println("File gened");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void intSetImp(int maxelems, int maxval){
		if(maxelems >= maxval)
			return;
		this.max_element = maxelems;
		this.max_value = maxval;
		set = new LinkedList<Integer>();
	}

	public void insert(int element) {
		int idx;
		if(		(idx=this.contains(element)) < 0	||
				this.set.size() >= this.max_element || 
				element >= this.max_value 				)
			return;

		this.set.add(idx,element);

	}

	public int size() {
		return this.set.size();
	}

	public LinkedList<Integer> getSet(){
		return this.set;
	}

	private int contains(int k) {	//binary search for binary insert
		if (set.size() == 0) 
			return 0;

		int lowerBound = 0;
		int upperBound = set.size() - 1;
		int curIn=0;

		while (true) {
			curIn = (upperBound + lowerBound) / 2;
			if (set.get(curIn) == k) {
				return -1;
			} else if (set.get(curIn) < k) {
				lowerBound = curIn + 1; // its in the upper
				if (lowerBound > upperBound)
					return curIn + 1;
			} else {
				upperBound = curIn - 1; // its in the lower
				if (lowerBound > upperBound)
					return curIn;
			}
		}
	}

	public Integer[] report(){

		//		this.set.sort(new Comparator<Integer>() {
		//
		//			@Override
		//			public int compare(Integer o1, Integer o2) {
		//				// TODO Auto-generated method stub
		//				return o1-o2;
		//			}
		//			
		//		});

		return set.toArray(new Integer[set.size()]);

	} 
}
