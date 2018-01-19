package trees.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import trees.BSTree;

public class BSTest {
	
	BSTree<Integer> aT; //Add tree
	BSTree<Integer> iT; //Integer tree
	
	@Before
	public void initialize() {
		
		aT = new BSTree<Integer>();
		
		
		iT = new BSTree<Integer>();
		
		assertTrue(iT.addNode(10));
		assertTrue(iT.addNode(5));
		assertTrue(iT.addNode(15));
		assertTrue(iT.addNode(3));
		assertTrue(iT.addNode(6));
		assertTrue(iT.addNode(11));
		assertTrue(iT.addNode(20));
		assertTrue(iT.addNode(12));
		
		assertTrue(iT.addNode(-666));
		
		
	}
	
	
	/**
	 * AddNode  test
	 */
	@Test
	public void testAddNode() {
		
		//Integers
		
		//Add valid nodes
		assertTrue(aT.addNode(10));
		assertTrue(aT.addNode(5));
		assertTrue(aT.addNode(15));
		assertTrue(aT.addNode(3));
		assertTrue(aT.addNode(6));
		assertTrue(aT.addNode(11));
		assertTrue(aT.addNode(20));
		assertTrue(aT.addNode(12));
		
		
		//Add negative nodes
		assertTrue(aT.addNode(-666));
		//Add an existing node
		assertFalse(aT.addNode(-666));
		//Add a null node
		assertFalse(aT.addNode(null));
		
		
		//Strings
		
		BSTree<String> stree = new BSTree<String>();
		
		stree.addNode("C");
		stree.addNode("A");
		stree.addNode("B");
		stree.addNode("D");
		stree.addNode("F");
		stree.addNode("L");
		stree.addNode("Z");
		stree.addNode("M");
		
		
	}
		
	/**
	 * FindNode test
	 */
	@Test
	public void testFindNode() {
	
		//Search valid nodes
		assertEquals((Integer) 6,iT.findNode(6).getInfo());
		assertEquals((Integer) 10,iT.findNode(10).getInfo());
		assertEquals((Integer) 5,iT.findNode(5).getInfo());
		assertEquals((Integer) 15,iT.findNode(15).getInfo());
		assertEquals((Integer) 3,iT.findNode(3).getInfo());
		assertEquals((Integer) 11,iT.findNode(11).getInfo());
		assertEquals((Integer) 12,iT.findNode(12).getInfo());
		assertEquals((Integer) 20,iT.findNode(20).getInfo());
		assertEquals((Integer) 6,iT.findNode(6).getInfo());
		
		
		//Search negative nodes
		assertEquals((Integer) (-666),iT.findNode(-666).getInfo());
		//Search a non-existent node
		assertEquals(null,iT.findNode(77));
		//Search a null node
		assertEquals(null,iT.findNode(null));
	}
	
	
	/**
	 * PreOrder, PostOrder, InOrder test
	 */
	@Test
	public void testOrders() {
		
		assertEquals("10	5	3	-666	6	15	11	12	20",iT.preOrder());
		assertEquals("-666	3	6	5	12	11	20	15	10",iT.postOrder());
		assertEquals("-666	3	5	6	10	11	12	15	20",iT.inOrder());
		
		
		System.out.println(iT.preOrder());
		System.out.println(iT.postOrder());
		System.out.println(iT.inOrder());
		
	}
	
	
	/**
	 * Pruebas para el método remove
	 */
	@Test
	public void testRemove() {
		BSTree<Integer> tree = new BSTree<Integer>();

		tree.addNode(10);
		tree.addNode(5);
		tree.addNode(3);
		tree.addNode(9);
		tree.addNode(7);
		tree.addNode(6);
		tree.addNode(8);

		tree.addNode(14);
		tree.addNode(12);
		tree.addNode(16);

		assertEquals(true, tree.removeNode(9));
		assertEquals(true, tree.removeNode(8));
		assertEquals(true, tree.removeNode(7));
		assertEquals(true, tree.removeNode(6));
		assertEquals(true, tree.removeNode(5));
		assertEquals(true, tree.removeNode(3));
		assertEquals(true, tree.removeNode(14));
		assertEquals(true, tree.removeNode(12));
		assertEquals(true, tree.removeNode(16));
		assertEquals(true, tree.removeNode(10));

		// Remove a null
		assertFalse(tree.removeNode(null));

		// Remove a non-existent node
		assertFalse(tree.removeNode(27));

	}
			
	
	
}
