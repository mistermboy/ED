package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import graphs.Graph;

public class GraphTest {
	
	Graph<Integer> gE; //Grafo de enteros
	Graph<String> gS; // Grafo de strings
	Graph<Character> gC; //Grafo de chars
	
	Graph<Character> gClase; //Grafo dado en clase

	@Before
	public void initialize() {
		gE = new Graph<Integer>(12); 
		gS = new Graph<String>(12); 
		gC = new Graph<Character>(12); 
		gClase = new Graph<Character>(5); 
	}

	/**
	 * Pruebas para el método addNodes
	 */
	@Test
	public <T> void testAddNodes() {
		
		//INTEGERS
		assertEquals(0, gE.getNumberOfNodes());
		
		assertEquals(0,gE.addNode(2));
		assertEquals(0,gE.addNode(8));
		assertEquals(0,gE.addNode(69));
		assertEquals(0,gE.addNode(23));
		assertEquals(0,gE.addNode(1));
		assertEquals(0,gE.addNode(7));
		assertEquals(0,gE.addNode(77));
		assertEquals(0,gE.addNode(26));
		assertEquals(0,gE.addNode(16));
		assertEquals(0,gE.addNode(21));
		assertEquals(0,gE.addNode(0));
		assertEquals(0,gE.addNode(-67));
		
		assertEquals(12, gE.getNumberOfNodes());
		
		//Borramos todo
		gE.removeAll();
		assertEquals(0, gE.getNumberOfNodes());
		
		//Añadir un nodo que no existe al principio
		assertEquals(0,gE.getNumberOfNodes());
		assertEquals(0,gE.addNode(2));
		assertEquals(1,gE.getNumberOfNodes());
		//Añadir un nodo que no existe al final
		assertEquals(0,gE.addNode(3));
		assertEquals(2,gE.getNumberOfNodes());
		//Añadir un nodo que ya existe
		assertEquals(-1,gE.addNode(3));
		assertEquals(2,gE.getNumberOfNodes());
		//Añadir un null
		assertEquals(-1,gE.addNode(null));
		//Añadir un nodo negativo
		assertEquals(0,gE.addNode(99));
		
		
		//STRINGS
		
		assertEquals(0, gS.getNumberOfNodes());
		
		assertEquals(0,gS.addNode("Darth"));
		assertEquals(0,gS.addNode("Vader"));
		assertEquals(0,gS.addNode("SL8R"));
		assertEquals(0,gS.addNode("STFU"));
		assertEquals(0,gS.addNode("EUKZ"));
		assertEquals(0,gS.addNode("LPR"));
		assertEquals(0,gS.addNode("StPauli"));
		assertEquals(0,gS.addNode("ACAB"));
		assertEquals(0,gS.addNode("MW3"));
		assertEquals(0,gS.addNode("LCM"));
		assertEquals(0,gS.addNode("Mi5"));
		assertEquals(0,gS.addNode("Che"));
		
		
		assertEquals(12, gS.getNumberOfNodes());
		
		
		//CHARACTERS
		
		assertEquals(0, gC.getNumberOfNodes());
		
		assertEquals(0,gC.addNode('S'));
		assertEquals(0,gC.addNode('T'));
		assertEquals(0,gC.addNode('P'));
		assertEquals(0,gC.addNode('A'));
		assertEquals(0,gC.addNode('U'));
		assertEquals(0,gC.addNode('L'));
		assertEquals(0,gC.addNode('I'));
		assertEquals(0,gC.addNode('M'));
		assertEquals(0,gC.addNode('Y'));
		assertEquals(0,gC.addNode('C'));
		assertEquals(0,gC.addNode('R'));
		assertEquals(0,gC.addNode('Z'));
	
	
		assertEquals(12, gC.getNumberOfNodes());
		
		//GRAFO DE CLASE
		
		assertEquals(0, gClase.getNumberOfNodes());
		
		assertEquals(0,gClase.addNode('A'));
		assertEquals(0,gClase.addNode('B'));
		assertEquals(0,gClase.addNode('C'));
		assertEquals(0,gClase.addNode('D'));
		assertEquals(0,gClase.addNode('E'));
		

		assertEquals(5, gClase.getNumberOfNodes());
		
		
	}

	/*
	 * Pruebas para el método existNode
	 */
	@Test
	public <T> void testExistNode() {
		Graph<String> graph = new Graph<String>(8);

		//Comprobar que existe un nodo que realmente existe
		graph.addNode("hola");
		assertTrue(graph.existNode("hola"));
		//Comprobar que existe un nodo que realmente no existe
		assertFalse(graph.existNode("adios"));
		//Comprobar un null
		assertFalse(graph.existNode(null));
		
	}
	

	/*
	 * Pruebas para el método addEdge
	 */
	@Test
	public <T> void testAddEdge() {
		Graph<Double> graph = new Graph<Double>(6);
		
		//Añadir una arista entre dos nodos que existen
		graph.addNode(5.0);
		graph.addNode(6.0);
		assertEquals(0,graph.addEdge(5.0, 6.0,3.0));
		//Añadir una arista entre dos nodos que no existen
		assertEquals(-1,graph.addEdge(4.0, 7.0,3.0));
		//Añadir una arista entre un primer nodo que existe y un segundo nodo que no existe
		assertEquals(-1,graph.addEdge(5.0, 7.0,3.0));
		//Añadir una arista entre un primer nodo que no existe y un segundo nodo que si existe
		assertEquals(-1,graph.addEdge(4.0, 6.0,3.0));
		//Añadir una arista con un peso < 0
		assertEquals(-1,graph.addEdge(5.0, 6.0,-5.0));
		//Sobrescribir una arista
		assertEquals(-1,graph.addEdge(5.0, 6.0,50.0));
		//Add null
		assertEquals(-1,graph.addEdge(null, 6.0,-5.0));
		assertEquals(-1,graph.addEdge(5.0, null,-5.0));
		assertEquals(-1,graph.addEdge(null, 6.0,-5.0));
		
	}
	

	/*
	 * Pruebas para el método existEdge
	 */
	@Test
	public <T> void testExistEdge() {
		Graph<Integer> graph = new Graph<Integer>(6);
		
		//Comprobar que existe una arista que realmente existe
		graph.addNode(0);
		graph.addNode(1);
		graph.addEdge(0, 1,3.0);
		assertTrue(graph.existEdge(0,1));
		//Comprobar que existe una arista que realmente no existe
		graph.addNode(2);
		graph.addNode(3);
		assertFalse(graph.existEdge(2,3));
		//Comprobar que existe una arista cuando se le pasan un primer nodo que no existe y un segundo nodo que si existe
		assertFalse(graph.existEdge(5,0));
		//Comprobar que existe una arista cuando se le pasan un primer nodo que si existe y un segundo nodo que no existe
		assertFalse(graph.existEdge(1,6));
		//Comprobar que existe una arista cuando se le pasan dos nodos que no existen
		assertFalse(graph.existEdge(8,6));
		//Comprobar null
		assertFalse(graph.existEdge(null,6));
		assertFalse(graph.existEdge(8,null));
		assertFalse(graph.existEdge(null,null));
		
		
		
	}
	

	/*
	 * Pruebas para el método removeNode
	 */
	@Test
	public <T> void testRemoveNode() {
		
		//Borrar un nodo del principio de la lista
		Graph<Integer> graph = new Graph<Integer>(6);
		
		graph.addNode(0);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		

		assertEquals(6,graph.getNumberOfNodes());
		assertEquals(0,graph.removeNode(0));		
		assertEquals(5,graph.getNumberOfNodes());
		
		//Borrar un nodo del medio de la lista
		graph = new Graph<Integer>(6);
		
		graph.addNode(0);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		
		assertEquals(6,graph.getNumberOfNodes());
		assertEquals(0,graph.removeNode(3));
		assertEquals(5,graph.getNumberOfNodes());
		
		//Borrar un nodo del final de la lista
		graph = new Graph<Integer>(6);
		
		graph.addNode(0);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		
		assertEquals(6,graph.getNumberOfNodes());
		assertEquals(0,graph.removeNode(5));
		assertEquals(5,graph.getNumberOfNodes());
		
		//Borrar un nodo que no exista
		graph = new Graph<Integer>(6);
		
		graph.addNode(0);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		
		assertEquals(6,graph.getNumberOfNodes());
		assertEquals(-1,graph.removeNode(26));
		assertEquals(6,graph.getNumberOfNodes());
		
		//Borrar un nodo en una lista vacía
		graph = new Graph<Integer>(6);
		
		assertEquals(0,graph.getNumberOfNodes());
		assertEquals(-1,graph.removeNode(0));
		assertEquals(0,graph.getNumberOfNodes());
		
		//Remove null
		assertEquals(-1,graph.removeNode(null));
	}
	
	/*
	 * Pruebas para el método getEdge
	 */
	@Test
	public <T> void testGetEdge() {
		Graph<Integer> graph = new Graph<Integer>(6);

		graph.addNode(0);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		
		graph.addEdge(0, 1,3.0);
		graph.addEdge(2, 3,5.0);
		graph.addEdge(4, 5,7.0);
		graph.addEdge(0, 5,1.0);
		
		//Devolver  el peso de una arista que exista conectada entre los dos primeros nodos
		assertEquals(3.0,graph.getEdge(0, 1),0.1);
		//Devolver el peso de una arista que exista conectada entre dos nodos cualquiera
		assertEquals(5.0,graph.getEdge(2, 3),0.1);
		//Devolver el peso de una arista que exista conectada entre los dos últimos nodos
		assertEquals(7.0,graph.getEdge(4, 5),0.1);
		//Devolver el peso de una arista que exista conectada entre el primer nodo y el último
		assertEquals(1.0,graph.getEdge(0, 5),0.1);
		//Devolver el peso de una arista que no exista
		assertEquals(-1,graph.getEdge(0, 3),0.1);
		//Devolver el peso de una arista entre un primer nodo que no existe y un segundo nodo que si existe
		assertEquals(-1,graph.getEdge(8, 3),0.1);
		//Devolver el peso de una arista entre un primer nodo que si existe y un segundo nodo que no existe
		assertEquals(-1,graph.getEdge(0, 7),0.1);
		//Devolver el peso de una arista entre dos nodos que no existen
		assertEquals(-1,graph.getEdge(6, 9),0.1);
		//Null
		assertEquals(-1,graph.getEdge(null, 9),0.1);
		assertEquals(-1,graph.getEdge(6, null),0.1);
		assertEquals(-1,graph.getEdge(null, 9),0.1);
		
		
	}
	

	/*
	 * Pruebas para el método removeEdge
	 */
	@Test
	public <T> void testRemoveEdge() {
		Graph<Integer> graph = new Graph<Integer>(6);
	
		graph.addNode(0);
		graph.addNode(1);
		graph.addNode(2);
		graph.addNode(3);
		graph.addNode(4);
		graph.addNode(5);
		
		//Borrar una arista que no existe
		assertEquals(0,graph.removeEdge(0,1),0.1);
		
		graph.addEdge(0, 1,3.0);
		graph.addEdge(2, 3,5.0);
		graph.addEdge(4, 5,7.0);
		graph.addEdge(0, 5,1.0);
		
		//Borrar una arista conectada entre los dos primeros nodos
		assertEquals(0,graph.removeEdge(0,1),0.1);
		//Borrar una arista conectada entre dos nodos cualquiera
		assertEquals(0,graph.removeEdge(3,4),0.1);
		//Borrar una arista conectada entre los dos últimos nodos
		assertEquals(0,graph.removeEdge(4,5),0.1);
		//Borrar una arista conectada entre el primer y el último nodo
		assertEquals(0,graph.removeEdge(0,5),0.1);
		//Borrar una arista entre un primer nodo que no existe y un segundo nodo que si existe
		assertEquals(-1,graph.removeEdge(8,1),0.1);
		//Borrar una arista entre un primer nodo que si existe y un segundo nodo que no existe
		assertEquals(-1,graph.removeEdge(0,7),0.1);
		//Borrar una arista entre dos nodos que no existen
		assertEquals(-1,graph.removeEdge(6,9),0.1);
		//Remove null
		assertEquals(-1,graph.removeEdge(null,9),0.1);
		assertEquals(-1,graph.removeEdge(6,null),0.1);
		assertEquals(-1,graph.removeEdge(null,null),0.1);

	}

	

	
}
