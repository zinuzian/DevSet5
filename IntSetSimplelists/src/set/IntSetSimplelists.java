package set;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class IntSetSimplelists {

	private int max_element = 0;
	private int max_value = 0;
	private ArrayList<Integer> set = new ArrayList<Integer>();

	public static void main(String[] args){
		try {
			File file = new File("output.txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));

			IntSetSimplelists set = new IntSetSimplelists();
			Random random = new Random();
			int maxValue = 10000000;
			int maxElem = 100000;
			set.intSetImp(maxElem, maxValue);

			for(int i=0;i<maxElem;i++){
				set.insert(random.nextInt(maxValue));
			}

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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void intSetImp(int maxelems, int maxval){
		this.max_element = maxelems;
		this.max_value = maxval;
	}

	public void insert(int element) {
		if(	element >= this.max_value && 
				this.set.size() >= this.max_element && 
				this.set.contains(element)				)
			return;

		this.set.add(element);

	}

	public int size() {
		return this.set.size();
	}

	public Integer[] report(){

		this.set.sort(new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}

		});
		return set.toArray(new Integer[set.size()]);

	} 
}
