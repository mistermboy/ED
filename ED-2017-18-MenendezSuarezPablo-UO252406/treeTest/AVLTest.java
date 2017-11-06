package treeTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import trees.AVLTree;

public class AVLTest {

	AVLTree<Integer> tree;

	AVLTree<String> sT;
	
	@Before
	public void setUp() {
		tree = new AVLTree<Integer>();
		sT= new  AVLTree<String>();
	}

	/**
	 * Pruebas para el método add
	 */
	@Test
	public void testAdd() {
		
		//Pruebas con enteros
//		 assertEquals(new Integer(3),tree.add(3).getInfo());
//		 assertEquals(new Integer(2),tree.add(2).getInfo());
//		 assertEquals(new Integer(1),tree.add(1).getInfo());
//		
//		 assertEquals(new Integer(6),tree.add(6).getInfo());
//		 assertEquals(new Integer(7),tree.add(7).getInfo());
//		 assertEquals(new Integer(8),tree.add(8).getInfo());
//		
//		 //Añadir null
//		 assertNull(tree.add(null));
//		 
//		 //Añadir repetido
//		 assertEquals(new Integer(6),tree.add(6).getInfo());
//		 assertEquals(new Integer(7),tree.add(7).getInfo());
//		 assertEquals(new Integer(8),tree.add(8).getInfo());
		
		 
		 //Pruebas con String
		 
//		 assertTrue(sT.add("A"));
//	     assertTrue(sT.add("D"));
//	     assertTrue(sT.add("C")); 
//	     
//	     assertTrue(sT.add("M"));
//	     assertTrue(sT.add("L"));
//	     assertTrue(sT.add("H")); 
//	     
//	     assertTrue(sT.add("X"));
//	     assertTrue(sT.add("Y"));
//	     assertTrue(sT.add("Z")); 
//	     
//	     //Añadir null
//		 assertFalse(sT.add(null));
//		 
//		 //Añadir repetido
//		 assertTrue(sT.add("X"));
//	     assertTrue(sT.add("Y"));
//	     assertTrue(sT.add("Z")); 
//	     
////		System.out.print(tree.toString());
	}
	

	/**
	 * Pruebas para el método remove
	 */
	@Test
	public void removeTest(){
		
//		//Pruebas con enteros
//		assertTrue(tree.add(10));
//		assertTrue(tree.add(8));
//		assertTrue(tree.add(7));
//		assertTrue(tree.add(23));
//		assertTrue(tree.add(5));
//		assertTrue(tree.add(9));
//		assertTrue(tree.add(3));
//		assertTrue(tree.add(2));
//		assertTrue(tree.add(1));
//		
//		
//	     //Borrar elementos que si existen
//		assertTrue(tree.remove(1));
//		assertTrue(tree.remove(5));
//		assertTrue(tree.remove(9));
//		
//		//Eliminar nodos que no existen
//		assertFalse(tree.remove(0));
//		assertFalse(tree.remove(-23));
//		assertFalse(tree.remove(45));
//		
//		//Eliminar null
//		assertFalse(tree.remove(null));
//		
//		//Eliminar repetido
//		assertTrue(tree.remove(23));
//		assertFalse(tree.remove(23));
//		
//		
//		//Pruebas con String
//		
//		 assertTrue(sT.add("A"));
//	     assertTrue(sT.add("D"));
//	     assertTrue(sT.add("C")); 
//	     
//	     assertTrue(sT.add("M"));
//	     assertTrue(sT.add("L"));
//	     assertTrue(sT.add("H")); 
//	     
//	     assertTrue(sT.add("X"));
//	     assertTrue(sT.add("Y"));
//	     assertTrue(sT.add("Z")); 
//	     
//	     //Borrar elementos que si existen
//	     assertTrue(sT.remove("D"));
//	     assertTrue(sT.remove("L"));
//	     assertTrue(sT.remove("Y"));
//		
//		//Eliminar nodos que no existen
//		assertFalse(sT.remove("STAR WARS"));
//		assertFalse(sT.remove("N"));
//		assertFalse(sT.remove("SOAD"));
//		
//		//Eliminar null
//		 assertFalse(sT.remove(null));
//		 
//		//Eliminar repetido
//			assertTrue(sT.remove("C"));
//			assertFalse(sT.remove("C"));
//		
////		System.out.print(tree.toString());
	}
		


}
