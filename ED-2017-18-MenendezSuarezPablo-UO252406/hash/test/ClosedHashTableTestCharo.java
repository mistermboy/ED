package hash.test;

import static org.junit.Assert.*;

import org.junit.Test;

import hash.ClosedHashTable;


public class ClosedHashTableTestCharo {

	@Test
	public void testInt() {
		//Crea una tabla del tamaño 4 (numero no primo)
		ClosedHashTable<Integer> tabla = new ClosedHashTable<Integer>(4,2,0.16,0.5);
		//Muestra la tabla. Debera estar vacia y ser de tamaño 5
		assertEquals("[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[Tam:5 NElem:0]",tabla.toString());
		System.out.println(tabla.toString());
		//Inserta elementos
		assertTrue(tabla.add(8));
		assertTrue(tabla.add(10));
		tabla.toString();
		assertEquals("[10]-[_E_]-[_E_]-[8]-[_E_]-[Tam:5 NElem:2]",tabla.toString());
		System.out.println(tabla.toString());

		
		//Inserta y redispersión
		assertTrue(tabla.add(66));
		assertEquals("[66]-[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[8]-[_E_]-[10]-[Tam:11 NElem:3]",tabla.toString());
		System.out.println(tabla.toString());		
		
		//Sigue insertando elementos
		assertTrue(tabla.add(77));
		assertTrue(tabla.add(7));
		
		//Inserta y redispersión
		assertTrue(tabla.add(9));
		assertEquals("[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[7]-[77]-[8]-[9]-[10]-[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[66]-[_E_]-[_E_]-[Tam:23 NElem:6]",tabla.toString());
		System.out.println(tabla.toString());
		
		//Sigue insertando elementos
		assertTrue(tabla.add(88));
		
		//Borra un elemento que existe
		assertTrue(tabla.remove(8));
		assertEquals("[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[7]-[77]-[_D_]-[9]-[10]-[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[88]-[66]-[_E_]-[_E_]-[Tam:23 NElem:6]",tabla.toString());
		System.out.println(tabla.toString());
		
		//Sigue insertando elementos
		assertTrue(tabla.add(13));
		assertTrue(tabla.add(19));
		
		//Inserta elemetos que ya existen
		assertFalse(tabla.add(66));
		assertFalse(tabla.add(88));
		
		//Borra un elemento que no existe
		assertFalse(tabla.remove(2));
		
		//Borrar elementos
		assertTrue(tabla.remove(19));
		assertTrue(tabla.remove(7));
		assertTrue(tabla.remove(77));
		assertTrue(tabla.remove(9));
		
		//Borra y redispersión inversa
		assertTrue(tabla.remove(10));
		assertEquals("[88]-[66]-[13]-[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[Tam:11 NElem:3]",tabla.toString());
		System.out.println(tabla.toString());	
}
	
	@Test
	public void testString() {
		//Crea una tabla del tamaño 10 (numero no primo)
		ClosedHashTable<String> hashTable = new ClosedHashTable<String>(4,2,0.16,0.5);
		//Muestra la tabla. Debera estar vacia y ser de tamaño 11
		assertEquals("[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[Tam:5 NElem:0]",hashTable.toString());
		System.out.println(hashTable.toString());
		//Inserta elementos
		assertTrue(hashTable.add("Pedro")); //506
		assertTrue(hashTable.add("Marta")); //501
		assertEquals("[_E_]-[Pedro]-[Marta]-[_E_]-[_E_]-[Tam:5 NElem:2]",hashTable.toString());
		System.out.println(hashTable.toString());
		
		//Inserta y redispersión
		assertTrue(hashTable.add("Leo")); //288
		assertEquals("[Pedro]-[_E_]-[Leo]-[_E_]-[_E_]-[_E_]-[Marta]-[_E_]-[_E_]-[_E_]-[_E_]-[Tam:11 NElem:3]",hashTable.toString());
		System.out.println(hashTable.toString());		
		
		//Sigue insertando elementos
		assertTrue(hashTable.add("Lucia")); //494
		assertTrue(hashTable.add("Eva")); //284
		
		//Inserta y redispersión
		assertTrue(hashTable.add("Luis")); //413
		assertEquals("[Pedro]-[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[Eva]-[_E_]-[_E_]-[Lucia]-[Leo]-[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[Marta]-[_E_]-[_E_]-[_E_]-[Luis]-[Tam:23 NElem:6]",hashTable.toString());
		System.out.println(hashTable.toString());
		
		//Sigue insertando elementos
		assertTrue(hashTable.add("Jose")); //401 -->1		
		System.out.println(hashTable.toString());
		
		//Borra un elemento que existe
		assertTrue(hashTable.remove("Jose")); 
		System.out.println(hashTable.toString());
		
		//Sigue insertando elementos
		assertTrue(hashTable.add("Lia")); //278
		assertTrue(hashTable.add("Eli")); //282
		assertTrue(hashTable.add("aLi")); //278
		System.out.println(hashTable.toString());
		
		//Inserta elemetos que ya existen
		assertFalse(hashTable.add("Lia")); 
		assertFalse(hashTable.add("Marta"));
		System.out.println(hashTable.toString());
		
		//Borra un elemento que no existe
		assertFalse(hashTable.remove("Alejandro"));
		
		//Borrar elementos
		assertTrue(hashTable.remove("Eli"));
		assertTrue(hashTable.remove("Lia"));
		assertTrue(hashTable.remove("Marta"));
		assertTrue(hashTable.remove("Luis"));
		
		//Borra y redispersión inversa
		assertTrue(hashTable.remove("Eva"));
		assertEquals("[Pedro]-[_E_]-[_D_]-[aLi]-[_E_]-[_E_]-[_D_]-[_E_]-[_D_]-[_E_]-[_D_]-[Lucia]-[Leo]-[_E_]-[_E_]-[_E_]-[_E_]-[_E_]-[_D_]-[_E_]-[_E_]-[_E_]-[_D_]-[Tam:23 NElem:4]",hashTable.toString());
		System.out.println(hashTable.toString());
		
	}

}
