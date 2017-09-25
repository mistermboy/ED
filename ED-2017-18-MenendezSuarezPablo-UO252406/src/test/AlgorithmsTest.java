package test;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithms.Algorithms;

public class AlgorithmsTest {
	
	
	Algorithms a = new Algorithms();
	

	
	@Test
	public void testFactorial() {
		assertEquals(24,a.factorial(4));
		assertEquals(1,a.factorial(0));
	}

//	@Test
//	public void testFactorialRec() {
//		
//	}
//
//	@Test
//	public void testFibonacciRec() {
//		
//	}
	
	
	@Test
	public void testPow1() {
		assertEquals(1,a.pow1(0));
		assertEquals(2,a.pow1(1));
		assertEquals(4,a.pow1(2));
		assertEquals(8,a.pow1(3));
		assertEquals(16,a.pow1(4));
	}
	
	
	@Test
	public void testPow2() {
		assertEquals(1,a.pow2(0));
		assertEquals(2,a.pow2(1));
		assertEquals(4,a.pow2(2));
		assertEquals(8,a.pow2(3));
		assertEquals(16,a.pow2(4));
	}
	
	
	@Test
	public void testPow3() {
		assertEquals(1,a.pow3(0));
		assertEquals(2,a.pow3(1));
		assertEquals(4,a.pow3(2));
		assertEquals(8,a.pow3(3));
		assertEquals(16,a.pow3(4));
	}
	
	@Test
	public void testPow4() {
		assertEquals(1,a.pow4(0));
		assertEquals(2,a.pow4(1));
		assertEquals(4,a.pow4(2));
		assertEquals(8,a.pow4(3));
		assertEquals(16,a.pow4(4));
	}
	

}
