package treeTest;

import static org.junit.Assert.*;

import org.junit.Test;

import trees.BSTree;

// Test de prueba si el m�todo removeNode devuelve
// un booleano
public class ArbolesBinariosBoolTestCharo{

	@Test
	public void test() {
		BSTree<Integer> b = new BSTree<Integer>();
		
		//Intenta borrar de un �rbol vac�o
		assertFalse(b.removeNode(50));
		assertNull(b.findNode(50));
		
		assertTrue(b.addNode(10));
		assertTrue(b.addNode(100));
		assertTrue(b.addNode(60));
		assertTrue(b.addNode(30));
		assertTrue(b.addNode(2));
		assertTrue(b.addNode(-43));
		assertTrue(b.addNode(70));
		assertTrue(b.addNode(90));
		assertTrue(b.addNode(23));
		assertTrue(b.addNode(43));
		assertTrue(b.addNode(65));
		assertTrue(b.addNode(13));
		assertTrue(b.addNode(230));
		assertTrue(b.addNode(49));
		assertTrue(b.addNode(7));
		assertTrue(b.addNode(40));
		assertTrue(b.addNode(50));
		assertTrue(b.addNode(20));
		assertTrue(b.addNode(15));
		assertTrue(b.addNode(3));
		
		
		//A�ade un elemento que ya existe
		assertFalse(b.addNode(3));
		
		//Borra un nodo que no existe
		assertFalse(b.removeNode(500));
		
		
		//Busca un nodo que no existe
		assertNull(b.findNode(500));
		
		//Recorridos
		assertEquals("-43\t2\t3\t7\t10\t13\t15\t20\t23\t30\t40\t43\t49\t50\t60\t65\t70\t90\t100\t230",b.inOrder());
		assertEquals("10\t2\t-43\t7\t3\t100\t60\t30\t23\t13\t20\t15\t43\t40\t49\t50\t70\t65\t90\t230",b.preOrder());
		assertEquals("-43\t3\t7\t2\t15\t20\t13\t23\t40\t50\t49\t43\t30\t65\t90\t70\t60\t230\t100\t10",b.postOrder());
		
		//Borra un nodo con un hijo: 7 tiene como hijo el 3
		assertTrue(b.removeNode(7));
		assertEquals("-43\t2\t3\t10\t13\t15\t20\t23\t30\t40\t43\t49\t50\t60\t65\t70\t90\t100\t230",b.inOrder());
				
		//Borra un nodo con un hijo: 20 tiene como hijo al 15
		assertTrue(b.removeNode(20));
		assertEquals("-43\t2\t3\t10\t13\t15\t23\t30\t40\t43\t49\t50\t60\t65\t70\t90\t100\t230",b.inOrder());
		
		//Borra un nodo con dos hijos: 2 tiene como hijos al -43 y 2
		//Busca el mayor del subarbol izquierdo (de los menores)
		assertTrue(b.removeNode(2));
		assertEquals("-43\t3\t10\t13\t15\t23\t30\t40\t43\t49\t50\t60\t65\t70\t90\t100\t230",b.inOrder());
	
		//Borra un nodo con dos sub�rboles: 100
		//Busca el mayor del subarbol izquierdo (de los menores)
		assertTrue(b.removeNode(100));
		assertEquals("-43\t3\t10\t13\t15\t23\t30\t40\t43\t49\t50\t60\t65\t70\t90\t230",b.inOrder());
		
		//Borra un nodo con dos sub�rboles: 60
		//Busca el mayor del subarbol izquierdo (de los menores)
		assertTrue(b.removeNode(60));
		assertEquals("-43\t3\t10\t13\t15\t23\t30\t40\t43\t49\t50\t65\t70\t90\t230",b.inOrder());

		//Borra una hoja: 40
		assertTrue(b.removeNode(40));
		assertEquals("-43\t3\t10\t13\t15\t23\t30\t43\t49\t50\t65\t70\t90\t230",b.inOrder());
		
		//Borra la raiz: 10
		assertTrue(b.removeNode(10));
		assertEquals("-43\t3\t13\t15\t23\t30\t43\t49\t50\t65\t70\t90\t230",b.inOrder());
		
		//Borra un nodo con dos sub�rboles: 50
		//Busca el mayor del subarbol izquierdo (de los menores)
		assertTrue(b.removeNode(50));
		assertEquals("-43\t3\t13\t15\t23\t30\t43\t49\t65\t70\t90\t230",b.inOrder());
	}

}
