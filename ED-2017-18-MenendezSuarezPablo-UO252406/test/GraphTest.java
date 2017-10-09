package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import graphs.Graph;

public class GraphTest {
	
	Graph<Integer> gE; //Grafo de enteros
	Graph<Double> gD; //Grafo de doubles
	Graph<String> gS; // Grafo de strings
	Graph<Character> gC; //Grafo de chars
	
	Graph<Character> gClase; //Grafo dado en clase

	@Before
	public void initialize() {
		gE = new Graph<Integer>(12);
		
		gE.addNode(2);
		gE.addNode(8);
		gE.addNode(69);
		gE.addNode(23);
		gE.addNode(1);
		gE.addNode(7);
		gE.addNode(77);
		gE.addNode(26);
		gE.addNode(16);
		gE.addNode(21);
		gE.addNode(0);
		gE.addNode(-67);
		
		gD = new Graph<Double>(12);
		
		gD.addNode(2.);
		gD.addNode(8.);
		gD.addNode(69.);
		gD.addNode(23.);
		gD.addNode(1.);
		gD.addNode(7.);
		gD.addNode(77.);
		gD.addNode(26.);
		gD.addNode(16.);
		gD.addNode(21.);
		gD.addNode(0.);
		gD.addNode(-67.);
		
		gS = new Graph<String>(12); 
		
		gS.addNode("Darth");
		gS.addNode("Vader");
		gS.addNode("SL8R");
		gS.addNode("STFU");
		gS.addNode("EUKZ");
		gS.addNode("LPR");
		gS.addNode("StPauli");
		gS.addNode("ACAB");
		gS.addNode("MW3");
		gS.addNode("LCM");
		gS.addNode("Mi5");
		gS.addNode("Che");
		
		gC = new Graph<Character>(12); 
		
		gC.addNode('S');
		gC.addNode('T');
		gC.addNode('P');
		gC.addNode('A');
		gC.addNode('U');
		gC.addNode('L');
		gC.addNode('I');
		gC.addNode('M');
		gC.addNode('Y');
		gC.addNode('C');
		gC.addNode('R');
		gC.addNode('Z');
		
		gClase = new Graph<Character>(5); 
		
		gClase.addNode('A');
		gClase.addNode('B');
		gClase.addNode('C');
		gClase.addNode('D');
		gClase.addNode('E');
	}

	/**
	 * Pruebas para el método addNodes
	 */
	@Test
	public <T> void testAddNodes() {
		
		//Borramos todo
		gE.removeAll();
		gD.removeAll();
		gS.removeAll();
		gC.removeAll();
		gClase.removeAll();
		
		
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
		
		
		//DOUBLES
		
		assertEquals(0, gD.getNumberOfNodes());
		
		assertEquals(0,gD.addNode(2.));
		assertEquals(0,gD.addNode(8.));
		assertEquals(0,gD.addNode(69.));
		assertEquals(0,gD.addNode(23.));
		assertEquals(0,gD.addNode(1.));
		assertEquals(0,gD.addNode(7.));
		assertEquals(0,gD.addNode(77.));
		assertEquals(0,gD.addNode(26.));
		assertEquals(0,gD.addNode(16.));
		assertEquals(0,gD.addNode(21.));
		assertEquals(0,gD.addNode(0.));
		assertEquals(0,gD.addNode(-67.));
		
		assertEquals(12, gD.getNumberOfNodes());
		
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

	/**
	 * Pruebas para el método existNode
	 */
	@Test
	public <T> void testExistNode() {
		
		//Borramos todo
		gE.removeAll();
		gD.removeAll();
		gS.removeAll();
		gC.removeAll();
		gClase.removeAll();
		
		//INTEGERS
		
		assertEquals(0, gE.getNumberOfNodes());
		
		assertEquals(0,gE.addNode(2));
		assertEquals(0,gE.addNode(8));
		assertEquals(0,gE.addNode(69));
		assertEquals(0,gE.addNode(23));
		assertEquals(0,gE.addNode(1));

		//Comprobar la existencia de nodos que existen
		assertTrue(gE.existNode(2));
		assertTrue(gE.existNode(8));
		assertTrue(gE.existNode(69));
		assertTrue(gE.existNode(23));
		assertTrue(gE.existNode(1));
		//Comprobar la existencia de nodos que no existen
		assertFalse(gE.existNode(0));
		assertFalse(gE.existNode(666));
		assertFalse(gE.existNode(77));
		assertFalse(gE.existNode(26));
		assertFalse(gE.existNode(16));
		//Comprobar un null
		assertFalse(gE.existNode(null));
		
		
		//DOUBLES
		assertEquals(0, gD.getNumberOfNodes());
		
		assertEquals(0,gD.addNode(2.));
		assertEquals(0,gD.addNode(8.));
		assertEquals(0,gD.addNode(69.));
		assertEquals(0,gD.addNode(23.));
		assertEquals(0,gD.addNode(1.));
		
		//Comprobar la existencia de nodos que existen
		assertTrue(gD.existNode(2.));
		assertTrue(gD.existNode(8.));
		assertTrue(gD.existNode(69.));
		assertTrue(gD.existNode(23.));
		assertTrue(gD.existNode(1.));
		//Comprobar la existencia de nodos que no existen
		assertFalse(gD.existNode(0.));
		assertFalse(gD.existNode(666.));
		assertFalse(gD.existNode(77.));
		assertFalse(gD.existNode(26.));
		assertFalse(gD.existNode(16.));
		//Comprobar un null
		assertFalse(gD.existNode(null));
		
		//STRINGS
		assertEquals(0, gS.getNumberOfNodes());
		
		assertEquals(0,gS.addNode("Darth"));
		assertEquals(0,gS.addNode("Vader"));
		assertEquals(0,gS.addNode("SL8R"));
		assertEquals(0,gS.addNode("STFU"));
		assertEquals(0,gS.addNode("EUKZ"));
	

		//Comprobar la existencia de nodos que existen
		assertTrue(gS.existNode("Darth"));
		assertTrue(gS.existNode("Vader"));
		assertTrue(gS.existNode("SL8R"));
		assertTrue(gS.existNode("STFU"));
		assertTrue(gS.existNode("EUKZ"));
	
		//Comprobar la existencia de nodos que no existen
		assertFalse(gS.existNode("SK8"));
		assertFalse(gS.existNode("OR"));
		assertFalse(gS.existNode("DIE"));
		assertFalse(gS.existNode("NEXT"));
		assertFalse(gS.existNode("SAPE"));

		//Comprobar un null
		assertFalse(gS.existNode(null));
		
		
		//CHARACTERS
		
		assertEquals(0, gC.getNumberOfNodes());
		
		assertEquals(0,gC.addNode('S'));
		assertEquals(0,gC.addNode('T'));
		assertEquals(0,gC.addNode('P'));
		assertEquals(0,gC.addNode('A'));
		assertEquals(0,gC.addNode('U'));
		
		//Comprobar la existencia de nodos que existen
		assertTrue(gC.existNode('S'));
		assertTrue(gC.existNode('T'));
		assertTrue(gC.existNode('P'));
		assertTrue(gC.existNode('A'));
		assertTrue(gC.existNode('U'));
	
		//Comprobar la existencia de nodos que no existen
		assertFalse(gC.existNode('E'));
		assertFalse(gC.existNode('L'));
		assertFalse(gC.existNode('C'));
		assertFalse(gC.existNode('I'));
		assertFalse(gC.existNode('N'));

		//Comprobar un null
		assertFalse(gC.existNode(null));
		
		
		//GRAFO DE CLASE
		
		assertEquals(0, gClase.getNumberOfNodes());
		
		assertEquals(0,gClase.addNode('A'));
		assertEquals(0,gClase.addNode('B'));
		assertEquals(0,gClase.addNode('C'));
		assertEquals(0,gClase.addNode('D'));
		assertEquals(0,gClase.addNode('E'));
		
		//Comprobar la existencia de nodos que existen
		assertTrue(gClase.existNode('A'));
		assertTrue(gClase.existNode('B'));
		assertTrue(gClase.existNode('C'));
		assertTrue(gClase.existNode('D'));
		assertTrue(gClase.existNode('E'));
	
		//Comprobar la existencia de nodos que no existen
		assertFalse(gC.existNode('M'));
		assertFalse(gC.existNode('L'));
		assertFalse(gC.existNode('Y'));
		assertFalse(gC.existNode('I'));
		assertFalse(gC.existNode('N'));
		
	}
	

	/*
	 * Pruebas para el método addEdge
	 */
	@Test
	public <T> void testAddEdge() {
		
		
		//INTEGERS
		
		//Añadir aristas entre nodos que existen
		assertEquals(0,gE.addEdge(2,8,3.0));
		assertEquals(0,gE.addEdge(1,7,5.0));
		assertEquals(0,gE.addEdge(8,2,7.0));
		assertEquals(0,gE.addEdge(-67,1,9.0));
		assertEquals(0,gE.addEdge(0,77,1.0));
		//Sobrescribir aristas
		assertEquals(-1,gE.addEdge(2,8,33.0));
		assertEquals(-1,gE.addEdge(1,7,555.0));
		assertEquals(-1,gE.addEdge(8,2,77.0));
		assertEquals(-1,gE.addEdge(-67,1,99.0));
		assertEquals(-1,gE.addEdge(0,77,11.0));
		//Añadir aristas con nodos origen que no existen
		assertEquals(-1,gE.addEdge(-1,8,3.0));
		assertEquals(-1,gE.addEdge(4,7,5.0));
		assertEquals(-1,gE.addEdge(5,2,7.0));
		assertEquals(-1,gE.addEdge(67,1,9.0));
		assertEquals(-1,gE.addEdge(17,77,1.0));
		//Añadir aristas con nodos destino que no existen
		assertEquals(-1,gE.addEdge(8,-1,3.0));
		assertEquals(-1,gE.addEdge(7,4,5.0));
		assertEquals(-1,gE.addEdge(2,5,7.0));
		assertEquals(-1,gE.addEdge(1,67,9.0));
		assertEquals(-1,gE.addEdge(77,17,1.0));
		//Añadir aristas entre nodos que no existen
		assertEquals(-1,gE.addEdge(888,-1,3.0));
		assertEquals(-1,gE.addEdge(777,4,5.0));
		assertEquals(-1,gE.addEdge(222,5,7.0));
		assertEquals(-1,gE.addEdge(111,67,9.0));
		assertEquals(-1,gE.addEdge(777,17,1.0));
		//Añadir aristas con peso negativo
		assertEquals(-1,gE.addEdge(2,8,-3.0));
		assertEquals(-1,gE.addEdge(1,7,-5.0));
		assertEquals(-1,gE.addEdge(8,2,-7.0));
		assertEquals(-1,gE.addEdge(-67,1,-9.0));
		assertEquals(-1,gE.addEdge(0,77,-1.0));
		//Añadir una arista con nodos null
		assertEquals(-1,gE.addEdge(null,8,-3.0));
		assertEquals(-1,gE.addEdge(1,null,-5.0));
		assertEquals(-1,gE.addEdge(null,null,-7.0));
		//Añadir una arista entre dos nodos iguales
		assertEquals(-1,gE.addEdge(2,2,-7.0));
		
		//DOUBLES
		
		//Añadir aristas entre nodos que existen
		assertEquals(0,gD.addEdge(2.,8.,3.0));
		assertEquals(0,gD.addEdge(1.,7.,5.0));
		assertEquals(0,gD.addEdge(8.,2.,7.0));
		assertEquals(0,gD.addEdge(-67.,1.,9.0));
		assertEquals(0,gD.addEdge(0.,77.,1.0));
		//Sobrescribir aristas
		assertEquals(-1,gD.addEdge(2.,8.,33.0));
		assertEquals(-1,gD.addEdge(1.,7.,555.0));
		assertEquals(-1,gD.addEdge(8.,2.,77.0));
		assertEquals(-1,gD.addEdge(-67.,1.,99.0));
		assertEquals(-1,gD.addEdge(0.,77.,11.0));
		//Añadir aristas con nodos origen que no existen
		assertEquals(-1,gD.addEdge(-1.,8.,3.0));
		assertEquals(-1,gD.addEdge(4.,7.,5.0));
		assertEquals(-1,gD.addEdge(5.,2.,7.0));
		assertEquals(-1,gD.addEdge(67.,1.,9.0));
		assertEquals(-1,gD.addEdge(17.,77.,1.0));
		//Añadir aristas con nodos destino que no existen
		assertEquals(-1,gD.addEdge(8.,-1.,3.0));
		assertEquals(-1,gD.addEdge(7.,4.,5.0));
		assertEquals(-1,gD.addEdge(2.,5.,7.0));
		assertEquals(-1,gD.addEdge(1.,67.,9.0));
		assertEquals(-1,gD.addEdge(77.,17.,1.0));
		//Añadir aristas entre nodos que no existen
		assertEquals(-1,gD.addEdge(888.,-1.,3.0));
		assertEquals(-1,gD.addEdge(777.,4.,5.0));
		assertEquals(-1,gD.addEdge(222.,5.,7.0));
		assertEquals(-1,gD.addEdge(111.,67.,9.0));
		assertEquals(-1,gD.addEdge(777.,17.,1.0));
		//Añadir aristas con peso negativo
		assertEquals(-1,gD.addEdge(2.,8.,-3.0));
		assertEquals(-1,gD.addEdge(1.,7.,-5.0));
		assertEquals(-1,gD.addEdge(8.,2.,-7.0));
		assertEquals(-1,gD.addEdge(-67.,1.,-9.0));
		assertEquals(-1,gD.addEdge(0.,77.,-1.0));
		//Añadir una arista con nodos null
		assertEquals(-1,gD.addEdge(null,8.,-3.0));
		assertEquals(-1,gD.addEdge(1.,null,-5.0));
		assertEquals(-1,gD.addEdge(null,null,-7.0));
		//Añadir una arista entre dos nodos iguales
		assertEquals(-1,gD.addEdge(2.,2.,-7.0));
		
		//STRINGS
		
		//Añadir aristas entre nodos que existen
		assertEquals(0,gS.addEdge("Darth","Vader",3.0));
		assertEquals(0,gS.addEdge("Che","Darth",3.0));
		assertEquals(0,gS.addEdge("Vader","Darth",3.0));
		assertEquals(0,gS.addEdge("Mi5","Vader",3.0));
		assertEquals(0,gS.addEdge("Darth","ACAB",3.0));
		//Sobrescribir aristas
		assertEquals(-1,gS.addEdge("Darth","Vader",3.0));
		assertEquals(-1,gS.addEdge("Che","Darth",3.0));
		assertEquals(-1,gS.addEdge("Vader","Darth",3.0));
		assertEquals(-1,gS.addEdge("Mi5","Vader",3.0));
		assertEquals(-1,gS.addEdge("Darth","ACAB",3.0));
		//Añadir aristas con nodos origen que no existen
		assertEquals(-1,gS.addEdge("Dath","Vader",3.0));
		assertEquals(-1,gS.addEdge("Ce","Darth",3.0));
		assertEquals(-1,gS.addEdge("Vaer","Darth",3.0));
		assertEquals(-1,gS.addEdge("M5","Vader",3.0));
		assertEquals(-1,gS.addEdge("Drth","ACAB",3.0));
		//Añadir aristas con nodos destino que no existen
		assertEquals(-1,gS.addEdge("Darth","Vder",3.0));
		assertEquals(-1,gS.addEdge("Che","Dh",3.0));
		assertEquals(-1,gS.addEdge("Vader","Drth",3.0));
		assertEquals(-1,gS.addEdge("Mi5","Vaer",3.0));
		assertEquals(-1,gS.addEdge("Darth","CAB",3.0));
		//Añadir aristas entre nodos que no existen
		assertEquals(-1,gS.addEdge("rth","Vder",3.0));
		assertEquals(-1,gS.addEdge("Ce","Dh",3.0));
		assertEquals(-1,gS.addEdge("Vaer","Drth",3.0));
		assertEquals(-1,gS.addEdge("5","Vaer",3.0));
		assertEquals(-1,gS.addEdge("Dah","CAB",3.0));
		//Añadir aristas con peso negativo
		assertEquals(-1,gS.addEdge("Darth","Vader",-3.0));
		assertEquals(-1,gS.addEdge("Che","Darth",-3.0));
		assertEquals(-1,gS.addEdge("Vader","Darth",-3.0));
		assertEquals(-1,gS.addEdge("Mi5","Vader",-3.0));
		assertEquals(-1,gS.addEdge("Darth","ACAB",-3.0));
		//Añadir una arista con nodos null
		assertEquals(-1,gS.addEdge(null,"Vader",3.0));
		assertEquals(-1,gS.addEdge("Che",null,3.0));
		assertEquals(-1,gS.addEdge(null,"Darth",3.0));
		//Añadir una arista entre dos nodos iguales
		assertEquals(-1,gS.addEdge("Che","Che",-7.0));
		
		

		
		
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
