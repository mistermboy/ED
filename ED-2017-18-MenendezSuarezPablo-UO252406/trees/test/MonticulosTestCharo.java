package trees.test;

import static org.junit.Assert.*;

import org.junit.Test;

import trees.BinaryHeap;

public class MonticulosTestCharo {

	@Test
	public void test() {
		BinaryHeap<Integer> m = new BinaryHeap<Integer>(7);
		// Intenta borrar en un montículo vacio
		assertFalse(m.remove(5));
		assertTrue(m.add(2));
		assertTrue(m.add(4));
		assertTrue(m.add(12));
		assertTrue(m.add(5));
		assertTrue(m.add(6));
		assertEquals("2,4,12,5,6", m.toString());
		System.out.println(m.toString());

		// Borra un elemento que no existe
		assertFalse(m.remove(40));

		assertTrue(m.add(8));
		assertEquals("2,4,8,5,6,12", m.toString());
		System.out.println(m.toString());
		assertTrue(m.remove(4));
		assertEquals("2,5,8,12,6", m.toString());
		System.out.println(m.toString());

		// Inserto elementos
		assertTrue(m.add(1));
		assertEquals("1,5,2,12,6,8", m.toString());
		System.out.println(m.toString());

		// Inserto elementos
		assertTrue(m.add(10));
		assertEquals("1,5,2,12,6,8,10", m.toString());
		System.out.println(m.toString());

		// Inserto y no cabe
		assertFalse(m.add(20));
		assertEquals("1,5,2,12,6,8,10", m.toString());
		System.out.println(m.toString());

		// Borra la raiz
		assertEquals(new Integer(1), m.poll());
		assertEquals("2,5,8,12,6,10", m.toString());
		System.out.println(m.toString());
	}

}
