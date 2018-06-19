package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import sets.IntSetBins;

class SetBinsTest {

	@Test
	void function_test() {
		IntSetBins bins = new IntSetBins();
		bins.intSetimp(10, 10);
		bins.generateSet();
		bins.report();
		
		
		assertEquals(bins.getMaxelements(), 10);
		assertEquals(bins.getMaxvalue(),10);
		for(int i = 0; i <10; i++) {
			assertEquals(bins.getset(i),i);
		}
	}

	@Test
	void performance_test() {
		
		//maxval  : n = 10 ^6
		//maxelems : m = n/100, n/50, n/25
		double time[] = new double[4]; // initialize, insert, report, Total
		int maxval;
		int maxsize;
		
		Scanner s = new Scanner(System.in);
		maxval = s.nextInt();
		maxsize = s.nextInt();
		
		double start_time = System.currentTimeMillis();
		
		double end_time;
		double start_time2 = System.currentTimeMillis();
		IntSetBins bins = new IntSetBins();
		
		// initialize
		bins.intSetimp(maxsize, maxval);
		end_time = System.currentTimeMillis();
		time[0] = (end_time - start_time2) / 1000.0;
	
		//insert
		start_time2 = System.currentTimeMillis();
		bins.generateSet();
		end_time = System.currentTimeMillis();
		time[1] = (end_time - start_time2) / 1000.0;
		
		
		//report
		start_time2 = System.currentTimeMillis();
		bins.report();
		end_time = System.currentTimeMillis();
		time[2] = (end_time - start_time2) / 1000.0;
		
		//total
		//end_time = System.currentTimeMillis();
		//time[3] = (end_time - start_time) / 1000.00;
		time[3] = time[0] + time[1] + time[2];
		
		System.out.println("Time Complexity");
		System.out.println("initialize :" + time[0]);
		System.out.println("insert : " + time[1]);
		System.out.println("report : " + time[2]);
		System.out.println("total : " + time[3]);
		System.out.println(" ");
		System.out.println("Space Complexity");
		System.out.println("Space : " + bins.size()*4);
	}
}
