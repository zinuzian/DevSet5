package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

import org.junit.jupiter.api.Test;

import set.IntSetBST;

class SetBSTTest {
	
	@Test
	void maxSizeTest() {
		IntSetBST set = new IntSetBST(1, 100);
		set.insert(10);
		set.insert(20);
		assertEquals(1, set.size());
		assertArrayEquals(new int[] {10}, set.report());
	}
	
	@Test
	void negativeSizeTest() {
		IntSetBST set = new IntSetBST(-1, 100);
		assertEquals(0, set.size());
	}
	
	@Test
	void maxValueTest() {
		IntSetBST set = new IntSetBST(10, 0);
		set.insert(10);
		assertEquals(0, set.size());
	}
	
	@Test
	void maxValueTest2() {
		IntSetBST set = new IntSetBST(10, 10);
		set.insert(10);
		assertEquals(1, set.size());
		assertArrayEquals(new int[] {10}, set.report());
	}
	
	@Test
	void maxValueTest3() {
		IntSetBST set = new IntSetBST(10, Integer.MAX_VALUE);
		set.insert(Integer.MAX_VALUE);
		assertEquals(1, set.size());
		assertArrayEquals(new int[] {Integer.MAX_VALUE}, set.report());
	}
	
	@Test
	void maxValueTest4() {
		IntSetBST set = new IntSetBST(10, Integer.MIN_VALUE);
		set.insert(Integer.MIN_VALUE);
		assertEquals(1, set.size());
		assertArrayEquals(new int[] {Integer.MIN_VALUE}, set.report());
	}
	
	@Test
	void duplicateInputTest() {
		IntSetBST set = new IntSetBST(10, 100);
		set.insert(10);
		set.insert(10);
		assertEquals(1, set.size());
		assertArrayEquals(new int[] {10}, set.report());
	}
	
	@Test
	void randomInputTest() {
		Random random = new Random();
		
		int maxSize = random.nextInt(10000000);
		int maxValue = random.nextInt(10000000);
		
		HashSet<Integer> tmpResult = new HashSet<Integer>();
		
		IntSetBST set = new IntSetBST(maxSize, maxValue);
		for (int i = 0; i < maxSize; i++) {
			int element = random.nextInt();
			
			set.insert(element);
			
			if (element <= maxValue) {
				tmpResult.add(element);
			}
		}
		
		ArrayList<Integer> expectedResult = new ArrayList<Integer>(tmpResult);
		Collections.sort(expectedResult);
		
		assertEquals(expectedResult.size(), set.size(), "size");
		
		int[] result = set.report();
		for (int i = 0; i < expectedResult.size(); i++) {
			assertEquals(expectedResult.get(i).intValue(), result[i]);
		}
	}
	
	@Test
	void complexityTest() {
		System.gc();
		Runtime r = Runtime.getRuntime();
		
		long[] timestamp = new long[4];
		
		timestamp[0] = System.currentTimeMillis();
		
		int maxValue = 100000000;
		int maxSize = maxValue / 25;
		
		Random random = new Random();
		
		long firstMemorySize = r.totalMemory() - r.freeMemory();
		
		IntSetBST set = new IntSetBST(maxSize, maxValue);
		
		timestamp[1] = System.currentTimeMillis();
		
		for (int i = 0; i < maxSize; i++) {
			set.insert(random.nextInt(maxValue));
		}
		
		long lastMemorySize = r.totalMemory() - r.freeMemory();
		
		timestamp[2] = System.currentTimeMillis();
		
		set.report();
		
		timestamp[3] = System.currentTimeMillis();
		
		System.out.println("initialize : " + String.format("%.3f", (timestamp[1] - timestamp[0]) / 1000.0) + "s");
		System.out.println("insert : " + String.format("%.3f", (timestamp[2] - timestamp[1]) / 1000.0) + "s");
		System.out.println("report : " + String.format("%.3f", (timestamp[3] - timestamp[2]) / 1000.0) + "s");
		System.out.println("total : " + String.format("%.3f", (timestamp[3] - timestamp[0]) / 1000.0) + "s");
		System.out.println("space : " + (lastMemorySize - firstMemorySize) + "byte");
	}
	
}
