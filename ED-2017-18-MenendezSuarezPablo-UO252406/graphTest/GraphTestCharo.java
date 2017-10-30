package graphTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import graphs.Graph;


public class GraphTestCharo {

	@Test
	public void test() {
		Graph<String> G=new Graph<String>(8);
		// Insertar nodos
		for (int i=0;i<8;i++){
			assertEquals(0,G.addNode("Nodo "+(char)('A'+i)));			
		}
		
		//Insertar un nodo que ya existe
		assertEquals(-1, G.addNode("Nodo A"));
		assertEquals(-1, G.addNode("Nodo D"));
		assertEquals(-1, G.addNode("Nodo H"));
		
		//Insertar un nodo que no existe pero no hay espacio mas mas nodos
		assertEquals(-1, G.addNode("Nodo J"));
		
		//Compruebo que el método existNode funciona correctamente
		assertTrue(G.existNode("Nodo A"));
		assertTrue(G.existNode("Nodo C"));
		assertTrue(G.existNode("Nodo H"));
		assertFalse(G.existNode("Nodo J"));
		
		//Añadir ejes
		assertEquals(0, G.addEdge("Nodo A", "Nodo C", 5));
		assertEquals(0, G.addEdge("Nodo B", "Nodo F", 6));
		assertEquals(0, G.addEdge("Nodo B", "Nodo G", 6));
		assertEquals(0, G.addEdge("Nodo C", "Nodo E", 6));
		assertEquals(0, G.addEdge("Nodo C", "Nodo G", 2));
		assertEquals(0, G.addEdge("Nodo D", "Nodo B", 3));
		assertEquals(0, G.addEdge("Nodo D", "Nodo F", 3));
		assertEquals(0, G.addEdge("Nodo E", "Nodo G", 2));
		assertEquals(0, G.addEdge("Nodo F", "Nodo B", 4));
		assertEquals(0, G.addEdge("Nodo F", "Nodo D", 7));
		assertEquals(0, G.addEdge("Nodo G", "Nodo C", 4));
		assertEquals(0, G.addEdge("Nodo H", "Nodo F", 6));
		
		//Añadir un eje ya existente
		assertEquals(-1, G.addEdge("Nodo H", "Nodo F", 6));
		assertEquals(-1, G.addEdge("Nodo C", "Nodo G", 2));
		
		//Añadir un eje entre nodos inexistentes
		assertEquals(-1, G.addEdge("Nodo C", "Nodo J", 2));
		assertEquals(-1, G.addEdge("Nodo J", "Nodo A", 2));
		assertEquals(-1, G.addEdge("Nodo K", "Nodo J", 2));
		
		
		
		//Compruebo que el método existEdge funciona correctamente
		assertTrue(G.existEdge("Nodo A", "Nodo C"));
		assertTrue(G.existEdge("Nodo C", "Nodo G"));
		assertFalse(G.existEdge("Nodo C", "Nodo A"));
		assertFalse(G.existEdge("Nodo G", "Nodo E"));
		assertFalse(G.existEdge("Nodo J", "Nodo E"));
		assertFalse(G.existEdge("Nodo E", "Nodo K"));
		assertFalse(G.existEdge("Nodo J", "Nodo K"));
		assertFalse(G.existEdge("Nodo A", "Nodo B"));
		
		
		//Comprueba que el método getEdge funciona correctamente
		assertEquals(6.0, G.getEdge("Nodo B", "Nodo G"), 1e-6);
		assertEquals(4.0, G.getEdge("Nodo F", "Nodo B"), 1e-6);
		assertEquals(-1, G.getEdge("Nodo G", "Nodo E"), 1e-6);
		assertEquals(-1, G.getEdge("Nodo J", "Nodo E"), 1e-6);
		assertEquals(-1, G.getEdge("Nodo G", "Nodo K"), 1e-6);
		assertEquals(-1, G.getEdge("Nodo J", "Nodo K"), 1e-6);
		assertEquals(-1, G.getEdge("Nodo A", "Nodo B"), 1e-6);
		
		System.out.println(G.toString());
		
		//Borrar ejes
		assertEquals(0, G.removeEdge("Nodo C", "Nodo G"));
		
		System.out.println("DESPUES DE BORRAR EL EJE DEL NODO C AL NODO G");
		System.out.println(G.toString());
		
		//Lo vuelvo a añadir
		assertEquals(0, G.addEdge("Nodo C", "Nodo G", 2));

		System.out.println("DESPUES DE VOLVER A AÑADIR EL EJE DEL NODO C AL NODO G");
		System.out.println(G.toString());
		
		//Borrar ejes que no existen
		assertEquals(-1, G.removeEdge("Nodo A", "NodoB"));
		assertEquals(-1, G.removeEdge("Nodo J", "NodoB"));
		assertEquals(-1, G.removeEdge("Nodo A", "NodoK"));
		assertEquals(-1, G.removeEdge("Nodo J", "NodoK"));
		
		//Borrar Nodo A: Borra el eje de A a C
		assertEquals(0, G.removeNode("Nodo A"));
		System.out.println("DESPUES DE BORRAR EL NODO A");
		System.out.println(G.toString());
		
		//Añado ejes para ver si borra bien
		assertEquals(0,G.addEdge("Nodo G","Nodo F",1));
		assertEquals(0,G.addEdge("Nodo F","Nodo G",2));
		//Borrar Nodo F: Borra el eje del Nodo F al Nodo B, del Nodo B al Nodo F, 
		//del Nodo F al Nodo D y del Nodo D al Nodo F
		assertEquals(0, G.removeNode("Nodo F"));
		System.out.println("DESPUES DE BORRAR EL NODO F");
		System.out.println(G.toString());
		
		assertFalse(G.existEdge("Nodo G", "Nodo G"));
	}

}
