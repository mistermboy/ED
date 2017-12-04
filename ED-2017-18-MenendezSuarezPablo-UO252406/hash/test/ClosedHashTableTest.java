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
	ClosedHashTable<Integer> tabla2 = new ClosedHashTable<Integer>(7, 1, 0.16, 0.5);

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
	
	
	
	
	 //Teoría Lineal
	
	 ClosedHashTable<Integer> tabla3 =new ClosedHashTable<Integer>(7, 1, 0.16, 0.5);
	
	 assertEquals(5, tabla3.getSize());
	
	 tabla3.add(4);
	 tabla3.add(13);
	 tabla3.add(24);
	 tabla3.add(3);
	
	 assertEquals(4, tabla2.getNumElementos());
	 //Teoría Cuadrática
	
	// System.out.println(tabla3.toString());
	
	 ClosedHashTable<Integer> tabla4 = new ClosedHashTable<Integer>(7, 1, 0.16, 0.5);
	
	 assertEquals(5, tabla4.getSize());
	
	 tabla4.add(4);
	 tabla4.add(13);
	 tabla4.add(24);
	 tabla4.add(3);
	
	
	 assertEquals(4, tabla2.getNumElementos());
	 // System.out.println(tabla4.toString());
	
	
	
	 //Comprobación de que la exploración por defecto cuando se le pasa
	 // algo distinto a 1 o 0 es la lineal
	
	 ClosedHashTable<Integer> tabla5 = new ClosedHashTable<Integer>(7, 1, 0.16, 0.5);
	
	 assertEquals(5, tabla5.getSize());
	
	 tabla5.add(4);
	 tabla5.add(13);
	 tabla5.add(24);
	 tabla5.add(3);
	
	 assertEquals(4, tabla2.getNumElementos());
	// System.out.println(tabla5.toString());
	
	 //Añadir un null
	 assertFalse(tabla5.add(null));
	
	 //Añadir un elemento que ya existe, (lo tiene que añadir en otra posición)
	 assertTrue(tabla5.add(3));
	
	 // System.out.println(tabla5.toString());
	 }
	//
	// /**
	// * Pruebas para el método remove
	// */
	// @Test
	// public void testRemove() {
	//
	// ClosedHashTable<Integer> tabla = new ClosedHashTable<>(5, 0.5, 0.16,(byte)
	// 1);
	//
	// assertEquals(5, tabla.getSize());
	//
	// tabla.add(4);
	// tabla.add(13);
	// tabla.add(24);
	// tabla.add(3);
	//
	//// System.out.println(tabla.toString());
	//
	// assertEquals(4, tabla.getNumOfElems());
	//
	// tabla.remove(3);
	//
	// assertEquals(3, tabla.getNumOfElems());
	//
	// // System.out.println(tabla.toString());
	// }
	//
	//
	// /**
	// * Pruebas para el método find
	// */
	// @Test
	// public void testFind() {
	//
	// ClosedHashTable<Integer> tabla = new ClosedHashTable<>(5, 0.5, 0.16,(byte)
	// 1);
	//
	// assertEquals(5, tabla.getSize());
	//
	// tabla.add(4);
	// tabla.add(13);
	// tabla.add(24);
	// tabla.add(3);
	//
	//// System.out.println(tabla.toString());
	//
	// //Elementos que existen
	// assertEquals(3,tabla.find(3),0.1);
	// assertEquals(24,tabla.find(24),0.1);
	// assertEquals(13,tabla.find(13),0.1);
	// assertEquals(4,tabla.find(4),0.1);
	// //Elementos que no existen
	// assertNull(tabla.find(8));
	// assertNull(tabla.find(33));
	// assertNull(tabla.find(58));
	// assertNull(tabla.find(69));
	//
	// }
	//
	//
	// /**
	// * Pruebas para el método redispersion
	// */
	// @Test
	// public void testRedispersion() {
	//
	// ClosedHashTable<Integer> tabla = new ClosedHashTable<>(5, 0.5, 0.16,
	// (byte) 1);
	//
	// assertEquals(5, tabla.getSize());
	//
	// assertEquals(0,tabla.getNumRedis());
	// tabla.add(4);
	// assertEquals(0,tabla.getNumRedis());
	// tabla.add(13);
	// assertEquals(0,tabla.getNumRedis());
	// tabla.add(24);
	// assertEquals(1,tabla.getNumRedis());
	// tabla.add(3);
	// assertEquals(1,tabla.getNumRedis());
	// assertEquals(11, tabla.getSize());
	// assertEquals(
	// "{_E_};{_E_};{24};{13};{4};{_E_};{_E_};{3};{_E_};{_E_};{_E_};[Size: 11
	// Num.Elems.: 4]",
	// tabla.toString());
	//// System.out.println(tabla.toString());
	//
	// tabla = new ClosedHashTable<>(3, 0.5, 0.16, (byte) 1);
	// assertEquals(3, tabla.getSize());
	// assertEquals(0, tabla.getNumOfElems());
	//
	// assertEquals(0,tabla.getNumRedis());
	// assertTrue(tabla.add(2));
	// assertEquals(0,tabla.getNumRedis());
	// assertEquals(1, tabla.getNumOfElems());
	// assertEquals(3, tabla.getSize());
	//
	// assertTrue(tabla.add(5));
	// assertEquals(1,tabla.getNumRedis());
	// assertEquals(2, tabla.getNumOfElems());
	// assertEquals(7, tabla.getSize());
	//
	// assertEquals("{_E_};{_E_};{2};{_E_};{_E_};{5};{_E_};[Size: 7 Num.Elems.:
	// 2]",tabla.toString());
	//// System.out.println(tabla.toString());
	// }
	//
	// /**
	// * Preubas para el método inverseRedispersion
	// */
	// @Test
	// public void testInverseRedispersion() {
	//
	// ClosedHashTable<Integer> tabla = new ClosedHashTable<>(5, 0.5, 0.16,
	// (byte) 1);
	//
	// assertEquals(5, tabla.getSize());
	//
	//
	// tabla.add(4);
	// tabla.add(13);
	// tabla.add(24);
	// tabla.add(3);
	// assertEquals(11, tabla.getSize());
	// assertEquals(
	// "{_E_};{_E_};{24};{13};{4};{_E_};{_E_};{3};{_E_};{_E_};{_E_};[Size: 11
	// Num.Elems.: 4]",
	// tabla.toString());
	//// System.out.println(tabla.toString());
	// assertEquals(0,tabla.getNumInvers());
	// tabla.remove(4);
	// tabla.remove(13);
	// assertEquals(0,tabla.getNumInvers());
	// tabla.remove(24);
	// assertEquals(1,tabla.getNumInvers());
	// assertEquals("{3};{_E_};{_E_};[Size: 3 Num.Elems.: 1]",
	// tabla.toString());
	//
	// // System.out.println(tabla.toString());
	//
	// tabla = new ClosedHashTable<>(11, 0.5, 0.16, (byte) 1);
	// assertEquals(11, tabla.getSize());
	// assertEquals(0, tabla.getNumOfElems());
	//
	// tabla.add(6);
	// tabla.add(1);
	// tabla.add(9);
	//
	// assertEquals(11, tabla.getSize());
	// assertEquals(3, tabla.getNumOfElems());
	//
	// assertEquals(0,tabla.getNumInvers());
	//
	// assertTrue(tabla.remove(6));
	// assertEquals(2, tabla.getNumOfElems());
	// assertEquals(11, tabla.getSize());
	//
	// assertEquals(
	// "{_E_};{1};{_E_};{_E_};{_E_};{_E_};{_D_};{_E_};{_E_};{9};{_E_};[Size: 11
	// Num.Elems.: 2]",
	// tabla.toString());
	//
	// assertTrue(tabla.remove(1));
	// assertEquals(1,tabla.getNumInvers());
	// assertEquals(1, tabla.getNumOfElems());
	// assertEquals(3, tabla.getSize());
	//
	// assertEquals("{9};{_E_};{_E_};[Size: 3 Num.Elems.: 1]",
	// tabla.toString());
	//
	// assertFalse(tabla.remove(null));
	// assertFalse(tabla.remove(69));
	//
	// // Vaciamos la tabla
	// assertTrue(tabla.remove(9));
	// System.out.println(tabla.toString());
	//
	// assertEquals("{_D_};{_E_};{_E_};[Size: 3 Num.Elems.: 0]",
	// tabla.toString());
	//
	//
	// }
	//
	// /**
	// * Mas pruebas para el add con diferentes objetos
	// */
	// @Test
	// public void testAddObject() {
	// // Add String
	// ClosedHashTable<String> tabla = new ClosedHashTable<>(7, 0.5, 0.16,(byte) 0);
	//
	// assertEquals(0, tabla.getNumOfElems());
	//
	// assertTrue(tabla.add("HOLA"));
	// assertTrue(tabla.add("MUNDO"));
	// assertTrue(tabla.add("STAR"));
	// assertTrue(tabla.add("WARS"));
	//
	// assertEquals(4, tabla.getNumOfElems());
	//
	//
	// // Add Double
	// ClosedHashTable<Double> tabla2 = new ClosedHashTable<>(7, 0.5, 0.16,
	// (byte) 0);
	//
	// assertEquals(0, tabla2.getNumOfElems());
	//
	// assertTrue(tabla2.add(7.1));
	// assertTrue(tabla2.add(6.9));
	// assertTrue(tabla2.add(8.3));
	// assertTrue(tabla2.add(5.4));
	//
	// assertEquals(4, tabla2.getNumOfElems());
	//
	// // Add Float
	// ClosedHashTable<Float> tabla3 = new ClosedHashTable<>(7, 0.5, 0.16,
	// (byte) 0);
	//
	// assertEquals(0, tabla3.getNumOfElems());
	//
	// assertTrue(tabla3.add(7.1f));
	// assertTrue(tabla3.add(6.9f));
	// assertTrue(tabla3.add(8.3f));
	// assertTrue(tabla3.add(5.4f));
	//
	// assertEquals(4, tabla3.getNumOfElems());
	// }
	//
	//
	// /**
	// * Mas pruebas para el Remove con diferentes objetos
	// */
	// @Test
	// public void testRemoveObject() {
	// // Remove String
	// ClosedHashTable<String> tabla = new ClosedHashTable<>(7, 0.5, 0.16,(byte) 0);
	//
	// assertEquals(0, tabla.getNumOfElems());
	//
	// assertTrue(tabla.add("HOLA"));
	// assertTrue(tabla.add("MUNDO"));
	// assertTrue(tabla.add("STAR"));
	// assertTrue(tabla.add("WARS"));
	//
	// assertEquals(4, tabla.getNumOfElems());
	//
	// assertTrue(tabla.remove("HOLA"));
	// assertTrue(tabla.remove("MUNDO"));
	// assertTrue(tabla.remove("STAR"));
	// assertTrue(tabla.remove("WARS"));
	//
	// assertEquals(0, tabla.getNumOfElems());
	//
	//
	// assertFalse(tabla.remove("HOLA"));
	// assertFalse(tabla.remove(null));
	//
	//
	// // Remove Double
	// ClosedHashTable<Double> tabla2 = new ClosedHashTable<>(7, 0.5, 0.16,
	// (byte) 0);
	//
	// assertEquals(0, tabla2.getNumOfElems());
	//
	// assertTrue(tabla2.add(7.1));
	// assertTrue(tabla2.add(6.9));
	// assertTrue(tabla2.add(8.3));
	// assertTrue(tabla2.add(5.4));
	//
	// assertEquals(4, tabla2.getNumOfElems());
	//
	// assertTrue(tabla2.remove(7.1));
	// assertTrue(tabla2.remove(6.9));
	// assertTrue(tabla2.remove(8.3));
	// assertTrue(tabla2.remove(5.4));
	//
	// assertEquals(0, tabla2.getNumOfElems());
	//
	// assertFalse(tabla2.remove(7.1));
	// assertFalse(tabla2.remove(null));
	//
	// // Remove Float
	// ClosedHashTable<Float> tabla3 = new ClosedHashTable<>(7, 0.5, 0.16,
	// (byte) 0);
	//
	// assertEquals(0, tabla3.getNumOfElems());
	//
	// assertTrue(tabla3.add(7.1f));
	// assertTrue(tabla3.add(6.9f));
	// assertTrue(tabla3.add(8.3f));
	// assertTrue(tabla3.add(5.4f));
	//
	// assertEquals(4, tabla3.getNumOfElems());
	//
	//
	// assertTrue(tabla3.remove(7.1f));
	// assertTrue(tabla3.remove(6.9f));
	// assertTrue(tabla3.remove(8.3f));
	// assertTrue(tabla3.remove(5.4f));
	//
	// assertEquals(0, tabla3.getNumOfElems());
	//
	// assertFalse(tabla3.remove(8.3f));
	// assertFalse(tabla3.remove(null));
	//
	// }
	//
	// /**
	// * Mas pruebas para el Find con diferentes objetos
	// */
	// @Test
	// public void testFindObject() {
	// // Find String
	// ClosedHashTable<String> tabla = new ClosedHashTable<>(7, 0.5, 0.16,(byte) 0);
	//
	// assertEquals(0, tabla.getNumOfElems());
	//
	// assertTrue(tabla.add("HOLA"));
	// assertTrue(tabla.add("MUNDO"));
	// assertTrue(tabla.add("STAR"));
	// assertTrue(tabla.add("WARS"));
	//
	// assertEquals("MUNDO",tabla.find("MUNDO"));
	//
	// assertEquals(4, tabla.getNumOfElems());
	//
	// assertTrue(tabla.remove("HOLA"));
	// assertTrue(tabla.remove("MUNDO"));
	// assertTrue(tabla.remove("WARS"));
	//
	// assertEquals("STAR",tabla.find("STAR"));
	// assertNull(tabla.find("Vader"));
	//
	// assertEquals(1, tabla.getNumOfElems());
	//
	//
	//
	//
	// // Find Double
	// ClosedHashTable<Double> tabla2 = new ClosedHashTable<>(7, 0.5, 0.16,
	// (byte) 0);
	//
	// assertEquals(0, tabla2.getNumOfElems());
	//
	// assertTrue(tabla2.add(7.1));
	// assertTrue(tabla2.add(6.9));
	// assertTrue(tabla2.add(8.3));
	// assertTrue(tabla2.add(5.4));
	//
	// assertEquals(7.1,tabla2.find(7.1),0.1);
	//
	// assertEquals(4, tabla2.getNumOfElems());
	//
	// assertTrue(tabla2.remove(7.1));
	// assertTrue(tabla2.remove(8.3));
	// assertTrue(tabla2.remove(5.4));
	//
	// assertEquals(6.9,tabla2.find(6.9),0.1);
	// assertNull(tabla2.find(6.3));
	//
	// assertEquals(1, tabla2.getNumOfElems());
	//
	//
	//
	// // Find Float
	// ClosedHashTable<Float> tabla3 = new ClosedHashTable<>(7, 0.5, 0.16,
	// (byte) 0);
	//
	// assertEquals(0, tabla3.getNumOfElems());
	//
	// assertTrue(tabla3.add(7.1f));
	// assertTrue(tabla3.add(6.9f));
	// assertTrue(tabla3.add(8.3f));
	// assertTrue(tabla3.add(5.4f));
	//
	// assertEquals(7.1f,tabla3.find(7.1f),0.1);
	//
	// assertEquals(4, tabla3.getNumOfElems());
	//
	//
	// assertTrue(tabla3.remove(7.1f));
	// assertTrue(tabla3.remove(8.3f));
	// assertTrue(tabla3.remove(5.4f));
	//
	//
	// assertEquals(6.9f,tabla3.find(6.9f),0.1);
	// assertNull(tabla3.find(6.3f));
	//
	// assertEquals(1, tabla3.getNumOfElems());
	//
	//
	// }

}
