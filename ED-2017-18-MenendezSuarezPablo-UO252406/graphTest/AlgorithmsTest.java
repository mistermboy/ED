package graphTest;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithms.Algorithms;

public class AlgorithmsTest {
	
	
	Algorithms a = new Algorithms();
	
	
	@Test
	public void testFactorialIterativo() {
		
		//PRUEBAS POSITIVAS
		assertEquals(1,a.factorialIterativo(0));
		assertEquals(1,a.factorialIterativo(1));
		assertEquals(2,a.factorialIterativo(2));
		assertEquals(6,a.factorialIterativo(3));
		assertEquals(24,a.factorialIterativo(4));
		assertEquals(120,a.factorialIterativo(5));
		assertEquals(720,a.factorialIterativo(6));
		assertEquals(5040,a.factorialIterativo(7));
		assertEquals(40320,a.factorialIterativo(8));
		assertEquals(362880,a.factorialIterativo(9));
		assertEquals(3628800,a.factorialIterativo(10));
		assertEquals(39916800,a.factorialIterativo(11));
		assertEquals(479001600,a.factorialIterativo(12));
		
		
		//PRUEBAS NEGATIVAS
		assertEquals(-1,a.factorialIterativo(-9));
		
		
	}

	@Test
	public void testFactorialRec() {
		
		//PRUEBAS POSITIVAS
		assertEquals(1,a.factorialRec(0));
		assertEquals(1,a.factorialRec(1));
		assertEquals(2,a.factorialRec(2));
		assertEquals(6,a.factorialRec(3));
		assertEquals(24,a.factorialRec(4));
		assertEquals(120,a.factorialRec(5));
		assertEquals(720,a.factorialRec(6));
		assertEquals(5040,a.factorialRec(7));
		assertEquals(40320,a.factorialRec(8));
		
		//PRUEBAS NEGATIVAS
		assertEquals(-1,a.factorialRec(-9));
	}

	@Test
	public void testFibonacciRec() {
		
		//PRUEBAS POSITIVAS
		assertEquals(0,a.fibonacciRec(0));
		assertEquals(1,a.fibonacciRec(1));
		assertEquals(1,a.fibonacciRec(2));
		assertEquals(2,a.fibonacciRec(3));
		assertEquals(3,a.fibonacciRec(4));
		assertEquals(5,a.fibonacciRec(5));
		assertEquals(8,a.fibonacciRec(6));
		assertEquals(13,a.fibonacciRec(7));
		assertEquals(21,a.fibonacciRec(8));
		assertEquals(34,a.fibonacciRec(9));
		
		//PRUEBAS NEGATIVAS
		assertEquals(-1,a.fibonacciRec(-9));
	}
	
	@Test
	public void testFibonacciIterativo() {
		
		//PRUEBAS POSITIVAS
		assertEquals(0,a.fibonacciIterativo(0));
		assertEquals(1,a.fibonacciIterativo(1));
		assertEquals(1,a.fibonacciIterativo(2));
		assertEquals(2,a.fibonacciIterativo(3));
		assertEquals(3,a.fibonacciIterativo(4));
		assertEquals(5,a.fibonacciIterativo(5));
		assertEquals(8,a.fibonacciIterativo(6));
		assertEquals(13,a.fibonacciIterativo(7));
		assertEquals(21,a.fibonacciIterativo(8));
		assertEquals(34,a.fibonacciIterativo(9));
		
		//PRUEBAS NEGATIVAS
		assertEquals(-1,a.fibonacciIterativo(-9));
	}
	
	
	@Test
	public void testPow1Rec() {
		
		//PRUEBAS POSITIVAS
		assertEquals(1,a.pow1Rec(0));
		assertEquals(2,a.pow1Rec(1));
		assertEquals(4,a.pow1Rec(2));
		assertEquals(8,a.pow1Rec(3));
		assertEquals(16,a.pow1Rec(4));
		
		//PRUEBAS NEGATIVAS
		assertEquals(-1,a.pow1Rec(-9));
	}
	
	
	@Test
	public void testPow2Rec() {
		
		//PRUEBAS POSITIVAS
		assertEquals(1,a.pow2Rec(0));
		assertEquals(2,a.pow2Rec(1));
		assertEquals(4,a.pow2Rec(2));
		assertEquals(8,a.pow2Rec(3));
		assertEquals(16,a.pow2Rec(4));
		
		//PRUEBAS NEGATIVAS
		assertEquals(-1,a.pow2Rec(-9));
	}
	
	
	@Test
	public void testPow3Rec() {
		
		//PRUEBAS POSITIVAS
		assertEquals(1,a.pow3Rec(0));
		assertEquals(2,a.pow3Rec(1));
		assertEquals(4,a.pow3Rec(2));
		assertEquals(8,a.pow3Rec(3));
		assertEquals(16,a.pow3Rec(4));
		
		//PRUEBAS NEGATIVAS
		assertEquals(-1,a.pow3Rec(-9));
	}
	
	@Test
	public void testPow4Rec() {
		
		//PRUEBAS POSITIVAS
		assertEquals(1,a.pow4Rec(0));
		assertEquals(2,a.pow4Rec(1));
		assertEquals(4,a.pow4Rec(2));
		assertEquals(8,a.pow4Rec(3));
		assertEquals(16,a.pow4Rec(4));
		
		//PRUEBAS NEGATIVAS
		assertEquals(-1,a.pow4Rec(-9));
	}
	

}
