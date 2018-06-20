package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.Random;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import set.IntSetSimplelists;

public class TestIntSetSimplelists extends TestCase{

	IntSetSimplelists set;

	public Integer[] testTimeElapsed(int maxval, int maxelem){
		try {
			String s1,s2,s3,s4,s5;
			File file = new File("maxval" + maxval + "maxelem" + maxelem+".txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));

			System.out.print("testTimeElapsed "); 
			System.out.println("max value = " + maxval + " max element = " + maxelem);




			//Init
			double total = 0.0;
			double start = System.currentTimeMillis();

			set = new IntSetSimplelists();
			set.intSetImp(maxelem, maxval);
			Random random = new Random();

			double end = System.currentTimeMillis();
			total += end-start;
			System.out.println(s1="Initialize time elapsed : "+(end-start)/1000.0 +"sec");


			//Insert
			start = System.currentTimeMillis();

			while(set.size() < maxelem){
				set.insert(random.nextInt(maxval));
				if(set.size()%10000 == 0) {
					System.out.println(set.size() + "elements inserted");
				}
			}
			end = System.currentTimeMillis();
			total += end-start;
			System.out.println(s2="Insert time elapsed : "+(end-start)/1000.0 +"sec");

			assertEquals(maxelem,set.size());
			DecimalFormat format = new DecimalFormat("###,###,###.##");
			long tot = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();

			//Report
			start = System.currentTimeMillis();

			Integer[] report = set.report();

			end = System.currentTimeMillis();
			total += end-start;

			System.out.println(s3="Report time elapsed : "+(end-start)/1000.0 +"sec");

			System.out.println(s4="Total time elapsed : "+total/1000.0 +"sec");


			System.out.println(s5="Space Complexity:" + format.format(tot/(1024*1024.0))+"\n\n"); 
			// output file generation
			bw.write(s1+"\n");
			bw.write(s2+"\n");
			bw.write(s3+"\n");
			bw.write(s4+"\n");
			bw.write(s5+"\n");

			String s = "{ ";
			for(int i=0;i<maxelem;i++){
				s += String.valueOf(report[i])+" ";
				if(i%100==99){
					s+="\n";
					bw.write(s);
					s="";
				}
			}
			s += " }";
			bw.write(s);

			bw.close();



			return report;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

//	@Test
//	public void test1000000() {
//		int n=1000000;
//		testTimeElapsed(n,n/25);
//		testTimeElapsed(n,n/100);
//		testTimeElapsed(n,n/50);
//
//
//
//	}
//	@Test
//	public void test100000000() {
//		int n=100000000;
//		testTimeElapsed(n,n/100);
//		testTimeElapsed(n,n/50);
//		testTimeElapsed(n,n/25);
//	}
	@Test
	public void testReport() {
		int n=1000000;
		Integer[] report;
		report=testTimeElapsed(n,n/100);
		for(int i=0;i<report.length-1;i++) {
			assertTrue(report[i] < report[i+1]);
		}
	}
	@Test
	public void testInsert() {
		set = new IntSetSimplelists();
		set.intSetImp(10, 100);
		set.insert(15);
		set.insert(64);
		set.insert(12);
		set.insert(66);
		set.insert(89);
		set.insert(1);
		set.insert(27);
		assertEquals(set.size(), 7);

		set.insert(35);
		set.insert(35);
		assertEquals(set.size(), 8);

		set.insert(100);	//boundary
		set.insert(98232);
		assertEquals(set.size(), 8);

		set.insert(30);//9
		set.insert(31);//10
		set.insert(32);//10
		set.insert(33);//10
		assertEquals(set.size(), 10);

		Integer[] report = set.report();
		for(int i=0;i<report.length-1;i++) {
			assertTrue(report[i] < report[i+1]);
		}
	}

	@Test
	public void testContains() {
		set = new IntSetSimplelists();
		set.intSetImp(10, 100);

		set.insert(10);
		assertEquals(set.contains(10),-1);	//exists
		assertEquals(set.contains(11),1);	//should be inserted to idx=1

		set.insert(11);
		assertEquals(set.contains(11),-1);	//exists
	}

	@Test
	public void testInit() {
		set = new IntSetSimplelists();
		assertEquals(set.contains(10),-2);	//LinkedList not initialized
		set.insert(10);
		assertEquals(set.size(),-1);	//not initialized
		set.intSetImp(10, 100);
		assertEquals(set.contains(10),0);	//not contains and should be inserted to idx=0
		assertEquals(set.size(),0);
	}

}
