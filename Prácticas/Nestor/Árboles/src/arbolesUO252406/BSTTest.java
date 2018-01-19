package arbolesUO252406;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BSTTest {

		 BSTree<Integer> tree;

		@Before
		public void setUp() {
			tree = new BSTree<Integer>();
		}

	@Test
	public void addTest() {
		assertEquals(true, tree.add(3));
		assertEquals(true, tree.add(2));
		assertEquals(true, tree.add(1));

		assertEquals(true, tree.add(6));
		assertEquals(true, tree.add(7));
		assertEquals(true, tree.add(8));

		// Insertar un null
		assertEquals(false, tree.add(null));

	//	System.out.println(tree.toString());

	}
		

		/**
		 * Pruebas para el método preOrder
		 */
		@Test
		public void testPreOrder(){
			BSTree<Integer> tree = new BSTree<Integer>();
			
			tree.add(6);
			tree.add(4);
			tree.add(3);
			
			tree.add(5);
			tree.add(12);
			tree.add(9);

			tree.add(8);
			tree.add(11);
			tree.add(15);


	//		System.out.println(tree.preOrder());
			
			
		}
		/**
		 * Pruebas para el método inOrder
		 */
		@Test
		public void testInOrder(){
			BSTree<Integer> tree = new BSTree<Integer>();
			
			tree.add(6);
			tree.add(4);
			tree.add(3);
			
			tree.add(5);
			tree.add(12);
			tree.add(9);

			tree.add(8);
			tree.add(11);
			tree.add(15);

//			System.out.println(tree.inOrder());
			
		
		
		}
		
		/**
		 * Pruebas para el método postOrder
		 */
		@Test
		public void testPostOrder(){
			BSTree<Integer> tree = new BSTree<Integer>();
			
			tree.add(6);
			tree.add(4);
			tree.add(3);
			
			tree.add(5);
			tree.add(12);
			tree.add(9);

			tree.add(8);
			tree.add(11);
			tree.add(15);

//			System.out.println(tree.postOrder());
			
			
		}
		
		/**
		 * Pruebas para el método remove
		 */
		@Test
		public void testRemove(){
			BSTree<Integer> tree = new BSTree<Integer>();
			
			tree.add(10);
			tree.add(5);
			tree.add(3);
			tree.add(9);
			tree.add(7);
			tree.add(6);
			tree.add(8);

			tree.add(14);
			tree.add(12);
			tree.add(16);
			
//			System.out.println(tree.toString());
		
			assertEquals(true,tree.remove(9));
			assertEquals(true,tree.remove(8));
			assertEquals(true,tree.remove(7));
			assertEquals(true,tree.remove(6));
			assertEquals(true,tree.remove(5));
			assertEquals(true,tree.remove(3));
			assertEquals(true,tree.remove(14));
			assertEquals(true,tree.remove(12));
			assertEquals(true,tree.remove(16));
			assertEquals(true,tree.remove(10));
			
			//Borrar null
			assertFalse(tree.remove(null));
			
			//Borrar un elemento que no exista
			assertFalse(tree.remove(27));
			

		}
			
			
			

			/**
			 * Pruebas para el método search
			 */
			@Test
			public void testSearch() {
				BSTree<Integer> tree = new BSTree<Integer>();
				
				tree.add(3);
				tree.add(2);
				tree.add(1);

				assertEquals((Object)1,tree.search(1));
				assertEquals((Object)3,tree.search(3));
				assertEquals((Object)2,tree.search(2));
				
				//Buscar un nodo que no exista
				assertEquals(null,tree.search(4));
				
				//Buscar un null
				assertEquals(null,tree.search(null));
				
			}
			
		
			/**
			 * Prueba add con String
			 */
			@Test
			public void testAddString(){
				BSTree<String> tree = new BSTree<String>();
				
				tree.add("C");
				tree.add("A");
				tree.add("B");
				tree.add("D");
				tree.add("F");
				tree.add("L");
				tree.add("Z");
				tree.add("M");
				
				
				System.out.println(tree.toString());
			}
	}

