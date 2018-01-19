package trees.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import trees.AVLNode;
import trees.AVLTree;

public class AVLTest {

	AVLTree<Integer> tree;

	AVLTree<String> sT;
	
	@Before
	public void setUp() {
		tree = new AVLTree<Integer>();
	}

	/**
	 * Pruebas para el método add
	 */
	@Test
	public void testAdd() {
	
		
		
		
		assertEquals(new Integer(10),tree.add(10).getInfo());
		assertEquals(new Integer(10),tree.add(8).getInfo());
		assertEquals(new Integer(10),tree.add(11).getInfo());
		assertEquals(new Integer(10),tree.add(9).getInfo());
		
		
		assertTrue(tree.esAscendienteDirecto(8, 9));
		assertTrue(tree.esAscendienteDirecto(10, 11));
		assertTrue(tree.esAscendienteDirecto(10, 8));
		assertFalse(tree.esAscendienteDirecto(9, 8));
		assertFalse(tree.esAscendienteDirecto(null, 8));
		assertFalse(tree.esAscendienteDirecto(9, null));
		assertFalse(tree.esAscendienteDirecto(null,null));
		
		
		assertEquals(2,tree.nunAristas(10, 9));

	}
	
	
	@Test
	public void testEsAscendienteDirecto() {
		assertEquals(new Integer(10),tree.add(10).getInfo());
		assertEquals(new Integer(10),tree.add(5).getInfo());
		assertEquals(new Integer(10),tree.add(15).getInfo());
		assertEquals(new Integer(10),tree.add(11).getInfo());
		assertEquals(new Integer(10),tree.add(18).getInfo());
		assertEquals(new Integer(10),tree.add(2).getInfo());
	
		
		assertTrue(tree.esAscendienteDirecto(15, 11));
		assertTrue(tree.esAscendienteDirecto(15, 18));
		assertTrue(tree.esAscendienteDirecto(10, 15));
		assertTrue(tree.esAscendienteDirecto(10, 5));
		assertTrue(tree.esAscendienteDirecto(5, 2));
		assertFalse(tree.esAscendienteDirecto(9, 8));
		assertFalse(tree.esAscendienteDirecto(null, 8));
		assertFalse(tree.esAscendienteDirecto(9, null));
		assertFalse(tree.esAscendienteDirecto(null,null));
		
	}
	
	
	@Test
	public void testEsNunAristas() {
		assertEquals(new Integer(10),tree.add(10).getInfo());
		assertEquals(new Integer(10),tree.add(5).getInfo());
		assertEquals(new Integer(10),tree.add(15).getInfo());
		assertEquals(new Integer(10),tree.add(11).getInfo());
		assertEquals(new Integer(10),tree.add(18).getInfo());
		assertEquals(new Integer(10),tree.add(2).getInfo());
	
		
		assertEquals(2,tree.nunAristas(10, 18));
		assertEquals(2,tree.nunAristas(10, 11));
		assertEquals(1,tree.nunAristas(10, 15));
		assertEquals(2,tree.nunAristas(10, 2));
		assertEquals(1,tree.nunAristas(10, 5));
		
		assertEquals(0,tree.nunAristas(10, 10));
		
		
		assertEquals(0,tree.nunAristas(18, 10));
	}
	
	@Test
	public void testCamino() {
		assertEquals(new Integer(10),tree.add(10).getInfo());
		assertEquals(new Integer(10),tree.add(5).getInfo());
		assertEquals(new Integer(10),tree.add(15).getInfo());
		assertEquals(new Integer(10),tree.add(11).getInfo());
		assertEquals(new Integer(10),tree.add(18).getInfo());
		assertEquals(new Integer(10),tree.add(2).getInfo());
	
	
		assertEquals("10:FB=0	15:FB=0	18:FB=0	", tree.camino(10, 18));
		assertEquals("10:FB=0	15:FB=0	11:FB=0	", tree.camino(10, 11));
		assertEquals("10:FB=0	15:FB=0	", tree.camino(10, 15));
		assertEquals("10:FB=0	5:FB=-1	", tree.camino(10, 5));
		assertEquals("10:FB=0	5:FB=-1	2:FB=0	", tree.camino(10, 2));
		
		
		assertEquals("No existe camino", tree.camino(18, 2));
		
		System.out.println(tree.camino(10, 18));
		System.out.println(tree.camino(10, 11));
		System.out.println(tree.camino(10, 15));
		System.out.println(tree.camino(10, 5));
		System.out.println(tree.camino(10, 2));
	}
	
	

	/**
	 * Pruebas para el método remove
	 */
	@Test
	public void removeTest(){
		
		//Pruebas con enteros
		assertEquals(new Integer(10),tree.add(10).getInfo());
		assertEquals(new Integer(10),tree.add(8).getInfo());
		assertEquals(new Integer(8),tree.add(7).getInfo());
		assertEquals(new Integer(8),tree.add(23).getInfo());
		assertEquals(new Integer(8),tree.add(5).getInfo());
		assertEquals(new Integer(8),tree.add(9).getInfo());
		assertEquals(new Integer(8),tree.add(3).getInfo());
		assertEquals(new Integer(8),tree.add(2).getInfo());
		assertEquals(new Integer(8),tree.add(1).getInfo());
		
	     //Borrar elementos que si existen
		assertEquals(tree.getRaiz(),tree.removeNode(1));
		assertEquals(tree.getRaiz(),tree.removeNode(5));
		assertEquals(tree.getRaiz(),tree.removeNode(9));
		
		//Eliminar nodos que no existen
		assertEquals(null,tree.removeNode(0));
		assertEquals(null,tree.removeNode(-23));
		assertEquals(null,tree.removeNode(45));
		
		//Eliminar null
		assertEquals(null,tree.removeNode(null));
		
		//Eliminar repetido
		assertEquals(tree.getRaiz(),tree.removeNode(23));
		assertEquals(null,tree.removeNode(23));
	
		
	}
	

}
