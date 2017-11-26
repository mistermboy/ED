package trees.test;

import static org.junit.Assert.*;

import org.junit.Test;

import trees.BinaryHeap;

public class BinaryHeapTest {

	/**
	 * Pruebas para el m�todo add
	 */
	@Test
	public <T> void testAdd() {

		// Pruebas con enteros
		BinaryHeap<Integer> tree = new BinaryHeap<Integer>(20);

		assertTrue(tree.add(1));
		assertTrue(tree.add(10));
		assertTrue(tree.add(3));
		assertTrue(tree.add(9));
		assertTrue(tree.add(5));
		assertTrue(tree.add(12));
		assertTrue(tree.add(16));
		assertTrue(tree.add(11));
		assertTrue(tree.add(7));
		assertTrue(tree.add(4));
		assertTrue(tree.add(60));
		assertTrue(tree.add(29));
		assertTrue(tree.add(-3));
		assertTrue(tree.add(-9));
		assertTrue(tree.add(-20));
		assertTrue(tree.add(-17));

		// System.out.println(tree.toString());

		// A�adir null
		assertFalse(tree.add(null));

		// A�adir repetidos
		assertTrue(tree.add(1));
		assertTrue(tree.add(3));
		assertTrue(tree.add(9));
		assertTrue(tree.add(5));

		// A�adir elementos que se salgan de la lista
		tree = new BinaryHeap<Integer>(2);

		assertTrue(tree.add(1));
		assertTrue(tree.add(10));

		assertFalse(tree.add(8));
		assertFalse(tree.add(9));
		assertFalse(tree.add(10));

		// Pruebas con String
		BinaryHeap<String> sT = new BinaryHeap<String>(20);

		assertTrue(sT.add("A"));
		assertTrue(sT.add("D"));
		assertTrue(sT.add("C"));

		assertTrue(sT.add("M"));
		assertTrue(sT.add("L"));
		assertTrue(sT.add("H"));

		assertTrue(sT.add("X"));
		assertTrue(sT.add("Y"));
		assertTrue(sT.add("Z"));

		// A�adir null
		assertFalse(sT.add(null));

		// A�adir repetidos
		assertTrue(sT.add("X"));
		assertTrue(sT.add("Y"));
		assertTrue(sT.add("Z"));

		// A�adir elementos que se salgan de la lista
		sT = new BinaryHeap<String>(2);

		assertTrue(sT.add("X"));
		assertTrue(sT.add("Y"));

		assertFalse(sT.add("A"));
		assertFalse(sT.add("B"));
		assertFalse(sT.add("C"));

		// System.out.println(tree.toString());
	}

	/**
	 * Pruebas para el m�todo remove
	 */
	@Test
	public <T> void testRemove() {
		// Pruebas con enteros
		BinaryHeap<Integer> tree = new BinaryHeap<Integer>(20);

		assertTrue(tree.add(1));
		assertTrue(tree.add(10));
		assertTrue(tree.add(3));
		assertTrue(tree.add(9));
		assertTrue(tree.add(5));
		assertTrue(tree.add(12));
		assertTrue(tree.add(16));
		assertTrue(tree.add(11));
		assertTrue(tree.add(7));
		assertTrue(tree.add(4));
		assertTrue(tree.add(60));
		assertTrue(tree.add(29));
		assertTrue(tree.add(-3));
		assertTrue(tree.add(-9));
		assertTrue(tree.add(-20));
		assertTrue(tree.add(-17));

		// Borramos elementos
		assertTrue(tree.remove(1));
		assertTrue(tree.remove(12));
		assertTrue(tree.remove(16));
		assertTrue(tree.remove(11));
		assertTrue(tree.remove(7));

		// Eliminar null
		assertFalse(tree.remove(null));
		// Eliminar un elemento que no existe
		assertFalse(tree.remove(9999));

		// Eliminar elementos repetidos
		assertTrue(tree.add(1));
		assertTrue(tree.add(1));
		assertTrue(tree.add(1));

		assertTrue(tree.remove(1));
		assertTrue(tree.remove(1));
		assertTrue(tree.remove(1));

		// Pruebas con String
		BinaryHeap<String> sT = new BinaryHeap<String>(20);

		assertTrue(sT.add("A"));
		assertTrue(sT.add("D"));
		assertTrue(sT.add("C"));

		assertTrue(sT.add("M"));
		assertTrue(sT.add("L"));
		assertTrue(sT.add("H"));

		assertTrue(sT.add("X"));
		assertTrue(sT.add("Y"));
		assertTrue(sT.add("Z"));

		// Borrar elementos que si existen
		assertTrue(sT.remove("D"));
		assertTrue(sT.remove("L"));
		assertTrue(sT.remove("Y"));

		// Borrar null
		assertFalse(sT.remove(null));
		// Eliminar un elemento que no existe
		assertFalse(sT.remove("VOY A PASAR TODOS LOS TEST"));

	}

	/**
	 * Pruebas para el m�todo isEmpty
	 */
	@Test
	public void isEmptyTest() {

		// Creamos una lista vac�a
		BinaryHeap<Integer> tree = new BinaryHeap<Integer>(10);
		assertEquals(true, tree.isEmpty());

		// A�adimos y comprobamos que ya no est� vac�a
		tree.add(2);
		assertEquals(false, tree.isEmpty());

		// Hacemos un clear y volvemos a comprobar que est� vac�a
		tree.clear();
		assertEquals(true, tree.isEmpty());
	}

	/**
	 * Pruebas para el m�todo clear
	 */
	@Test
	public void clearTest() {

		// Creamos una lista, le a�adimos elementos y comprobamos que no est�
		// vac�a
		BinaryHeap<Integer> tree = new BinaryHeap<Integer>(10);

		assertTrue(tree.add(1));
		assertTrue(tree.add(10));
		assertTrue(tree.add(3));
		assertTrue(tree.add(9));
		assertTrue(tree.add(5));
		assertTrue(tree.add(12));

		assertEquals(false, tree.isEmpty());

		// Vaciamos la lista y comprobamos que se vac�a
		tree.clear();
		assertEquals(true, tree.isEmpty());

	}

	@Test
	public void hijoMenorTest() {

		BinaryHeap<Integer> tree = new BinaryHeap<Integer>(10);

		assertTrue(tree.add(1));
		assertTrue(tree.add(10));
		assertTrue(tree.add(3));
		assertTrue(tree.add(9));
		assertTrue(tree.add(5));
		assertTrue(tree.add(12));
		assertTrue(tree.add(7));
		assertTrue(tree.add(8));

		System.out.println(tree.toString());

		// Cuando el hijo menor es el derecho
		assertEquals(2, tree.hijomenor(0));
		// Cuando el hijo menor es el hizquierdo
		assertEquals(3, tree.hijomenor(1));

		// Cuando solo tiene un hijo
		assertEquals(7, tree.hijomenor(3));

		// Cuando no tiene hijos
		assertEquals(-1, tree.hijomenor(7));

		// negativo
		assertEquals(-1, tree.hijomenor(-6));

	}

}
