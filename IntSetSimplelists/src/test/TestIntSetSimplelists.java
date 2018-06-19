package test;

import java.util.Random;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import set.IntSetSimplelists;

public class TestIntSetSimplelists extends TestCase{

	IntSetSimplelists set;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		junit.textui.TestRunner.run(suite());
	}
	public static Test suite(){
		return new TestSuite(IntSetSimplelists.class);
	}

	@Before
	public void setUp(){
		set = new IntSetSimplelists();
	}

	@Test
	public void testsimpleListInstantiateTest(){
		// max elem = n/100, n/50, n/25
		// max value = 100000000, 1000000

		int n = 1000000;
		set = new IntSetSimplelists();
		set.intSetImp(n/100,n);
		assertEquals(n/100,set.size());	

		set = new IntSetSimplelists();
		set.intSetImp(n/50,n);
		assertEquals(n/50,set.size());	

		set = new IntSetSimplelists();
		set.intSetImp(n/25,n);
		assertEquals(n/25,set.size());


		n = 100000000;
		set = new IntSetSimplelists();
		set.intSetImp(n/100,n);
		assertEquals(n/100,set.size());	

		set = new IntSetSimplelists();
		set.intSetImp(n/50,n);
		assertEquals(n/50,set.size());

		set = new IntSetSimplelists();
		set.intSetImp(n/25,n);
		assertEquals(n/25,set.size());
	}

	@Test
	public void testTimeElapsed1000000by100(){
		
		double total = 0.0;
		double start = System.currentTimeMillis();
		
		set = new IntSetSimplelists();
		int maxval = 1000000;
		int maxelem = maxval/100;
		set.intSetImp(maxelem, maxval);
		Random random = new Random();
		
		double end = System.currentTimeMillis();
		total += end-start;
		System.out.println("Initialize time elapsed : "+(end-start)/1000.0 +"sec");
		
		
		
		
		start = System.currentTimeMillis();
		
		do{
			set.insert(random.nextInt(maxval));
		}while(set.size() <= maxelem);

		end = System.currentTimeMillis();
		total += end-start;
		System.out.println("Insert time elapsed : "+(end-start)/1000.0 +"sec");
		
		
		
		
		start = System.currentTimeMillis();
		
		Integer[] report = set.report();
		
		end = System.currentTimeMillis();
		total += end-start;
		System.out.println("Report time elapsed : "+(end-start)/1000.0 +"sec");
		
		System.out.println("Total time elapsed : "+total/1000.0 +"sec");
		System.out.println("Space Complexity : "+set.size()*4);
	}
	/*
	//@Test
	public void testTimeElapsed1000000by50(){
		set = new IntSetSimplelists();
		int maxval = 1000000;
		int maxelem = maxval/50;
		set.intSetImp(maxelem, maxval);
		Random random = new Random();

		do{
			set.insert(random.nextInt(maxval));
		}while(set.size() <= maxelem);

		Integer[] report = set.report();
		for(int i=0;i<report.length-1;i++){
			assertNotSame(report[i],report[i+1]);
		}
	}
	//@Test
	public void testTimeElapsed1000000by25(){
		set = new IntSetSimplelists();
		int maxval = 1000000;
		int maxelem = maxval/25;
		set.intSetImp(maxelem, maxval);
		Random random = new Random();

		do{
			set.insert(random.nextInt(maxval));
		}while(set.size() <= maxelem);

		Integer[] report = set.report();
		for(int i=0;i<report.length-1;i++){
			assertNotSame(report[i],report[i+1]);
		}
	}
	//@Test
	public void testTimeElapsed100000000by100(){
		set = new IntSetSimplelists();
		int maxval = 100000000;
		int maxelem = maxval/100;
		set.intSetImp(maxelem, maxval);
		Random random = new Random();

		do{
			set.insert(random.nextInt(maxval));
		}while(set.size() <= maxelem);

		Integer[] report = set.report();
		for(int i=0;i<report.length-1;i++){
			assertNotSame(report[i],report[i+1]);
		}
	}
	*/
}
