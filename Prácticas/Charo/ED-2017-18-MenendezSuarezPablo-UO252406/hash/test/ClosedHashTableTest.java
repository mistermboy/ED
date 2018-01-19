package hash.test;

import static org.junit.Assert.*;

import org.junit.Test;

import hash.ClosedHashTable;

public class ClosedHashTableTest {

	/**
	 * Pruebas para el método add
	 */
	@Test
	public void testAdd() {
		// Lineal
		ClosedHashTable<Integer> tabla = new ClosedHashTable<Integer>(7, 1, 0.16, 0.5);
		assertEquals(7, tabla.getSize());
		assertEquals(0, tabla.getNumElementos());

		assertTrue(tabla.add(1));
		assertEquals(1, tabla.getNumElementos());

		assertTrue(tabla.add(8));
		assertEquals(2, tabla.getNumElementos());

		assertTrue(tabla.add(15));
		assertEquals(3, tabla.getNumElementos());

		assertTrue(tabla.add(22));
		assertEquals(4, tabla.getNumElementos());

		assertTrue(tabla.add(29));
		assertEquals(5, tabla.getNumElementos());

		assertTrue(tabla.add(36));
		assertEquals(6, tabla.getNumElementos());

		assertTrue(tabla.add(43));
		assertEquals(7, tabla.getNumElementos());

		// System.out.println(tabla.toString());

		// Cuadratica
		ClosedHashTable<Integer> tabla2 = new ClosedHashTable<Integer>(7, 2, 0.16, 0.5);

		assertEquals(7, tabla2.getSize());
		assertEquals(0, tabla2.getNumElementos());

		assertTrue(tabla2.add(1));
		assertEquals(1, tabla2.getNumElementos());

		assertTrue(tabla2.add(8));
		assertEquals(2, tabla2.getNumElementos());

		assertTrue(tabla2.add(15));
		assertEquals(3, tabla2.getNumElementos());

		assertTrue(tabla2.add(22));
		assertEquals(4, tabla2.getNumElementos());

		// System.out.println(tabla2.toString());

		// Teoría Lineal

		ClosedHashTable<Integer> tabla3 = new ClosedHashTable<Integer>(5, 1, 0.16, 0.5);

		assertEquals(5, tabla3.getSize());

		tabla3.add(4);
		tabla3.add(13);
		tabla3.add(24);
		tabla3.add(3);

		assertEquals(4, tabla2.getNumElementos());
		// Teoría Cuadrática

		// System.out.println(tabla3.toString());

		ClosedHashTable<Integer> tabla4 = new ClosedHashTable<Integer>(5, 2, 0.16, 0.5);

		assertEquals(5, tabla4.getSize());

		tabla4.add(4);
		tabla4.add(13);
		tabla4.add(24);
		tabla4.add(3);

		assertEquals(4, tabla2.getNumElementos());
		// System.out.println(tabla4.toString());

		ClosedHashTable<Integer> tabla5 = new ClosedHashTable<Integer>(5, 1, 0.16, 0.5);

		assertEquals(5, tabla5.getSize());

		tabla5.add(4);
		tabla5.add(13);
		tabla5.add(24);
		tabla5.add(3);

		assertEquals(4, tabla2.getNumElementos());
		// System.out.println(tabla5.toString());

		// Añadir un null
		assertFalse(tabla5.add(null));

		// Añadir un elemento que ya existe
		assertFalse(tabla5.add(3));

		// System.out.println(tabla5.toString());
	}

	/**
	 * Pruebas para el método remove
	 */
	@Test
	public void testRemove() {

		ClosedHashTable<Integer> tabla = new ClosedHashTable<Integer>(5, 2, 0.16, 0.5);

		assertEquals(5, tabla.getSize());

		tabla.add(4);
		tabla.add(13);
		tabla.add(24);
		tabla.add(3);

		// System.out.println(tabla.toString());

		assertEquals(4, tabla.getNumElementos());

		tabla.remove(3);

		assertEquals(3, tabla.getNumElementos());

		// System.out.println(tabla.toString());
	}

	/**
	 * Pruebas para el método find
	 */
	@Test
	public void testFind() {

		ClosedHashTable<Integer> tabla = new ClosedHashTable<Integer>(5, 2, 0.16, 0.5);

		assertEquals(5, tabla.getSize());

		tabla.add(4);
		tabla.add(13);
		tabla.add(24);
		tabla.add(3);

		// System.out.println(tabla.toString());

		// Elementos que existen
		assertEquals(3, tabla.find(3), 0.1);
		assertEquals(24, tabla.find(24), 0.1);
		assertEquals(13, tabla.find(13), 0.1);
		assertEquals(4, tabla.find(4), 0.1);
		// Elementos que no existen
		assertNull(tabla.find(8));
		assertNull(tabla.find(33));
		assertNull(tabla.find(58));
		assertNull(tabla.find(69));

	}

	/**
	 * Pruebas para el método redispersion
	 */
	@Test
	public void testRedispersion() {

		ClosedHashTable<Integer> tabla = new ClosedHashTable<Integer>(5, 2, 0.16, 0.5);

		assertEquals(5, tabla.getSize());

		assertEquals(0, tabla.getNumRedis());
		tabla.add(4);
		assertEquals(0, tabla.getNumRedis());
		tabla.add(13);
		assertEquals(0, tabla.getNumRedis());
		tabla.add(24);
		assertEquals(1, tabla.getNumRedis());
		tabla.add(3);
		assertEquals(1, tabla.getNumRedis());
		assertEquals(11, tabla.getSize());
		assertEquals("[_E_]-[_E_]-[24]-[13]-[4]-[_E_]-[_E_]-[3]-[_E_]-[_E_]-[_E_]-[Tam:11 NElem:4]", tabla.toString());
		// System.out.println(tabla.toString());

		tabla = new ClosedHashTable<Integer>(3, 2, 0.16, 0.5);
		assertEquals(3, tabla.getSize());
		assertEquals(0, tabla.getNumElementos());

		assertEquals(0, tabla.getNumRedis());
		assertTrue(tabla.add(2));
		assertEquals(0, tabla.getNumRedis());
		assertEquals(1, tabla.getNumElementos());
		assertEquals(3, tabla.getSize());

		assertTrue(tabla.add(5));
		assertEquals(1, tabla.getNumRedis());
		assertEquals(2, tabla.getNumElementos());
		assertEquals(7, tabla.getSize());

		assertEquals("[_E_]-[_E_]-[2]-[_E_]-[_E_]-[5]-[_E_]-[Tam:7 NElem:2]", tabla.toString());
		// System.out.println(tabla.toString());
	}

	/**
	 * Preubas para el método inverseRedispersion
	 */
	@Test
	public void testInverseRedispersion() {

		ClosedHashTable<Integer> tabla = new ClosedHashTable<Integer>(5, 2, 0.16, 0.5);

		assertEquals(5, tabla.getSize());

		tabla.add(4);
		tabla.add(13);
		tabla.add(24);
		tabla.add(3);
		assertEquals(11, tabla.getSize());
		assertEquals("[_E_]-[_E_]-[24]-[13]-[4]-[_E_]-[_E_]-[3]-[_E_]-[_E_]-[_E_]-[Tam:11 NElem:4]", tabla.toString());
		// System.out.println(tabla.toString());
		assertEquals(0, tabla.getNumInvers());
		tabla.remove(4);
		tabla.remove(13);
		assertEquals(0, tabla.getNumInvers());
		tabla.remove(24);
		assertEquals(1, tabla.getNumInvers());
		assertEquals("[_E_]-[_E_]-[_E_]-[3]-[_E_]-[Tam:5 NElem:1]", tabla.toString());

		// System.out.println(tabla.toString());

		tabla = new ClosedHashTable<Integer>(11, 2, 0.16, 0.5);
		assertEquals(11, tabla.getSize());
		assertEquals(0, tabla.getNumElementos());

		tabla.add(6);
		tabla.add(1);
		tabla.add(9);

		assertEquals(11, tabla.getSize());
		assertEquals(3, tabla.getNumElementos());

		assertEquals(0, tabla.getNumInvers());

		assertTrue(tabla.remove(6));
		assertEquals(2, tabla.getNumElementos());
		assertEquals(11, tabla.getSize());

		assertEquals("[_E_]-[1]-[_E_]-[_E_]-[_E_]-[_E_]-[_D_]-[_E_]-[_E_]-[9]-[_E_]-[Tam:11 NElem:2]",
				tabla.toString());

		assertTrue(tabla.remove(1));
		assertEquals(1, tabla.getNumInvers());
		assertEquals(1, tabla.getNumElementos());
		assertEquals(5, tabla.getSize());

		assertEquals("[_E_]-[_E_]-[_E_]-[_E_]-[9]-[Tam:5 NElem:1]", tabla.toString());

		assertFalse(tabla.remove(null));
		assertFalse(tabla.remove(69));

		// Vaciamos la tabla
		assertTrue(tabla.remove(9));
		// System.out.println(tabla.toString());

		assertEquals("[_E_]-[_E_]-[_E_]-[_E_]-[_D_]-[Tam:5 NElem:0]", tabla.toString());

	}

	/**
	 * Mas pruebas para el add con diferentes objetos
	 */
	@Test
	public void testAddObject() {
		// Add String
		ClosedHashTable<String> tabla = new ClosedHashTable<String>(7, 1, 0.16, 0.5);

		assertEquals(0, tabla.getNumElementos());

		assertTrue(tabla.add("HOLA"));
		assertTrue(tabla.add("MUNDO"));
		assertTrue(tabla.add("STAR"));
		assertTrue(tabla.add("WARS"));

		assertEquals(4, tabla.getNumElementos());

		// Add Float
		ClosedHashTable<Float> tabla3 = new ClosedHashTable<Float>(7, 1, 0.16, 0.5);

		assertEquals(0, tabla3.getNumElementos());

		assertTrue(tabla3.add(7.1f));
		assertTrue(tabla3.add(6.9f));
		assertTrue(tabla3.add(8.3f));
		assertTrue(tabla3.add(5.4f));

		assertEquals(4, tabla3.getNumElementos());
	}

	/**
	 * Mas pruebas para el Remove con diferentes objetos
	 */
	@Test
	public void testRemoveObject() {
		// Remove String
		ClosedHashTable<String> tabla = new ClosedHashTable<String>(7, 1, 0.16, 0.5);

		assertEquals(0, tabla.getNumElementos());

		assertTrue(tabla.add("HOLA"));
		assertTrue(tabla.add("MUNDO"));
		assertTrue(tabla.add("STAR"));
		assertTrue(tabla.add("WARS"));

		assertEquals(4, tabla.getNumElementos());

		assertTrue(tabla.remove("HOLA"));
		assertTrue(tabla.remove("MUNDO"));
		assertTrue(tabla.remove("STAR"));
		assertTrue(tabla.remove("WARS"));

		assertEquals(0, tabla.getNumElementos());

		assertFalse(tabla.remove("HOLA"));
		assertFalse(tabla.remove(null));

		// Remove Float
		ClosedHashTable<Float> tabla3 = new ClosedHashTable<Float>(7, 1, 0.16, 0.5);

		assertEquals(0, tabla3.getNumElementos());

		assertTrue(tabla3.add(7.1f));
		assertTrue(tabla3.add(6.9f));
		assertTrue(tabla3.add(8.3f));
		assertTrue(tabla3.add(5.4f));

		assertEquals(4, tabla3.getNumElementos());

		assertTrue(tabla3.remove(7.1f));
		assertTrue(tabla3.remove(6.9f));
		assertTrue(tabla3.remove(8.3f));
		assertTrue(tabla3.remove(5.4f));

		assertEquals(0, tabla3.getNumElementos());

		assertFalse(tabla3.remove(8.3f));
		assertFalse(tabla3.remove(null));

	}

	/**
	 * Mas pruebas para el Find con diferentes objetos
	 */
	@Test
	public void testFindObject() {
		// Find String
		ClosedHashTable<String> tabla = new ClosedHashTable<String>(7, 1, 0.16, 0.5);

		assertEquals(0, tabla.getNumElementos());

		assertTrue(tabla.add("HOLA"));
		assertTrue(tabla.add("MUNDO"));
		assertTrue(tabla.add("STAR"));
		assertTrue(tabla.add("WARS"));

		assertEquals("MUNDO", tabla.find("MUNDO"));

		assertEquals(4, tabla.getNumElementos());

		assertTrue(tabla.remove("HOLA"));
		assertTrue(tabla.remove("MUNDO"));
		assertTrue(tabla.remove("WARS"));

		assertEquals("STAR", tabla.find("STAR"));
		assertNull(tabla.find("Vader"));

		assertEquals(1, tabla.getNumElementos());

		// Find Float
		ClosedHashTable<Float> tabla3 = new ClosedHashTable<Float>(7, 1, 0.16, 0.5);

		assertEquals(0, tabla3.getNumElementos());

		assertTrue(tabla3.add(7.1f));
		assertTrue(tabla3.add(6.9f));
		assertTrue(tabla3.add(8.3f));
		assertTrue(tabla3.add(5.4f));

		assertEquals(7.1f, tabla3.find(7.1f), 0.1);

		assertEquals(4, tabla3.getNumElementos());

		assertTrue(tabla3.remove(7.1f));
		assertTrue(tabla3.remove(8.3f));
		assertTrue(tabla3.remove(5.4f));

		assertEquals(6.9f, tabla3.find(6.9f), 0.1);
		assertNull(tabla3.find(6.3f));

		assertEquals(1, tabla3.getNumElementos());

	}

}
