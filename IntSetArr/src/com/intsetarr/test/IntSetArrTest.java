package com.intsetarr.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import com.intsetarr.IntSetArr;

class IntSetArrTest {

	@Test
	void test() {
		int m = 10;
		int maxval = 150;
		int[] v = new int[m];
		
		int testMax = 0, testMin = maxval;
		
		Random rand = new Random();
		
		IntSetArr S = new IntSetArr(m, maxval);

		while (S.size() < m) {
			int randnum = rand.nextInt(maxval);
			S.insert(randnum);
			if (testMax < randnum)
				testMax = randnum;
			if (testMin > randnum)
				testMin = randnum;
		}
		
		S.report(v);
		
		assertEquals(testMax, v[m - 1], "testMax");
		assertEquals(testMin, v[0], "testMin");

	}

}
