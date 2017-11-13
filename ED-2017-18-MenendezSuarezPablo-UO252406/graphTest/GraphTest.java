package graphTest;

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
	
	Graph<Integer> gDijkstra;//Grafo para Dijkstra
	Graph<Integer> gFloyd;//Grafo para Floyd

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
		
		
		
		gDijkstra = new Graph<Integer>(5);
		
		gDijkstra.addNode(0);
		gDijkstra.addNode(1);
		gDijkstra.addNode(2);
		gDijkstra.addNode(3);
		gDijkstra.addNode(4);
		
		gDijkstra.addEdge(0, 1,100);
		gDijkstra.addEdge(0, 4,400);
		gDijkstra.addEdge(0, 2,20);
		gDijkstra.addEdge(0, 3,3);
		gDijkstra.addEdge(1, 4,41);
		gDijkstra.addEdge(3, 1,31);
		gDijkstra.addEdge(2, 1,12);
		
		
		
		gFloyd = new Graph<Integer>(6);
		
		gFloyd.addNode(1);
		gFloyd.addNode(2);
		gFloyd.addNode(3);
		gFloyd.addNode(4);
		gFloyd.addNode(5);
		gFloyd.addNode(6);
		
		gFloyd.addEdge(1, 2,3);
		gFloyd.addEdge(1, 3,4);
		gFloyd.addEdge(1, 5,8);
		gFloyd.addEdge(2, 5,5);
		gFloyd.addEdge(3, 5,3);
		gFloyd.addEdge(5, 4,7);
		gFloyd.addEdge(5, 6,3);
		gFloyd.addEdge(6, 4,2);
		
		
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
		assertEquals(-1,gE.addEdge(2,2,7.0));
		
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
		assertEquals(-1,gD.addEdge(2.,2.,7.0));
		
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
		assertEquals(-1,gS.addEdge("Che","Che",7.0));
		
		
		//CHARACTERS
		
		//Añadir aristas entre nodos que existen
		assertEquals(0,gC.addEdge('T','S',3.0));
		assertEquals(0,gC.addEdge('S','T',3.0));
		assertEquals(0,gC.addEdge('P','A',3.0));
		assertEquals(0,gC.addEdge('A','U',3.0));
		assertEquals(0,gC.addEdge('L','I',3.0));
		//Sobrescribir aristas
		assertEquals(-1,gC.addEdge('T','S',3.0));
		assertEquals(-1,gC.addEdge('S','T',3.0));
		assertEquals(-1,gC.addEdge('P','A',3.0));
		assertEquals(-1,gC.addEdge('A','U',3.0));
		assertEquals(-1,gC.addEdge('L','I',3.0));
		//Añadir aristas con nodos origen que no existen
		assertEquals(-1,gC.addEdge('Q','S',3.0));
		assertEquals(-1,gC.addEdge('Ñ','T',3.0));
		assertEquals(-1,gC.addEdge('N','A',3.0));
		assertEquals(-1,gC.addEdge('V','U',3.0));
		assertEquals(-1,gC.addEdge('W','I',3.0));
		//Añadir aristas con nodos destino que no existen
		assertEquals(-1,gC.addEdge('T','Q',3.0));
		assertEquals(-1,gC.addEdge('S','Ñ',3.0));
		assertEquals(-1,gC.addEdge('P','N',3.0));
		assertEquals(-1,gC.addEdge('A','V',3.0));
		assertEquals(-1,gC.addEdge('L','W',3.0));
		//Añadir aristas entre nodos que no existen
		assertEquals(-1,gC.addEdge('W','Q',3.0));
		assertEquals(-1,gC.addEdge('V','Ñ',3.0));
		assertEquals(-1,gC.addEdge('K','N',3.0));
		assertEquals(-1,gC.addEdge('Ñ','R',3.0));
		assertEquals(-1,gC.addEdge('Q','W',3.0));
		//Añadir aristas con peso negativo
		assertEquals(-1,gC.addEdge('T','S',-3.0));
		assertEquals(-1,gC.addEdge('S','T',-3.0));
		assertEquals(-1,gC.addEdge('P','A',-3.0));
		assertEquals(-1,gC.addEdge('A','U',-3.0));
		assertEquals(-1,gC.addEdge('L','I',-3.0));
		//Añadir una arista con nodos null
		assertEquals(-1,gC.addEdge(null,'S',3.0));
		assertEquals(-1,gC.addEdge('S',null,3.0));
		assertEquals(-1,gC.addEdge(null,null,3.0));

		//Añadir una arista entre dos nodos iguales
		assertEquals(-1,gC.addEdge('S','S',7.0));

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

	
	/**
	 * Pruebas para el algortimo dijkstra
	 */
	@Test
	public <T> void testDijsktra() {

		// Ejemplo Dijkstra clase, empezando por el nodo 0

		assertArrayEquals(new double[] { Double.POSITIVE_INFINITY, 32.0, 20.0, 3.0, 73.0 }, gDijkstra.dijkstra(0),
				0.0001);

		// Ejemplo teoría Dijkstra empezando desde el nodo 1
		Graph<Integer> graph2 = new Graph<Integer>(6);

		graph2.addNode(1);
		graph2.addNode(2);
		graph2.addNode(3);
		graph2.addNode(4);
		graph2.addNode(5);
		graph2.addNode(6);

		graph2.addEdge(1, 2, 3);
		graph2.addEdge(1, 3, 4);
		graph2.addEdge(1, 5, 8);
		graph2.addEdge(2, 5, 5);
		graph2.addEdge(3, 5, 3);
		graph2.addEdge(5, 4, 7);
		graph2.addEdge(5, 6, 3);
		graph2.addEdge(6, 4, 2);

		assertArrayEquals(new double[] { Double.POSITIVE_INFINITY, 3.0, 4.0, 12.0, 7.0, 10.0 }, graph2.dijkstra(1),
				0.0001);

		// Ejemplo teoría de Dijkstra empezando desde el nodo 0
		Graph<Integer> graph3 = new Graph<Integer>(6);

		graph3.addNode(0);
		graph3.addNode(1);
		graph3.addNode(2);
		graph3.addNode(3);

		graph3.addEdge(0, 1, 4);
		graph3.addEdge(1, 2, 1);
		graph3.addEdge(0, 3, 1);
		graph3.addEdge(3, 1, 2);
		graph3.addEdge(3, 2, 4);

		assertArrayEquals(new double[] { Double.POSITIVE_INFINITY, 3.0, 4.0, 1.0 }, graph3.dijkstra(0), 0.0001);

		// Ejemplo de teoría de Dijkstra empezando desde el nodo 0

		Graph<Integer> graph4 = new Graph<Integer>(6);

		graph4.addNode(0);
		graph4.addNode(1);
		graph4.addNode(2);
		graph4.addNode(3);
		graph4.addNode(4);

		graph4.addEdge(0, 4, 10);
		graph4.addEdge(0, 1, 1);
		graph4.addEdge(0, 3, 3);
		graph4.addEdge(1, 2, 5);
		graph4.addEdge(2, 4, 1);
		graph4.addEdge(3, 2, 2);
		graph4.addEdge(3, 4, 6);

		assertArrayEquals(new double[] { Double.POSITIVE_INFINITY, 1.0, 5.0, 3.0, 6.0 }, graph4.dijkstra(0), 0.0001);

		// Test null
		Graph<Integer> graph5 = new Graph<Integer>(6);
		assertArrayEquals(null, graph5.dijkstra(null), 0.0001);

	}
	
	
	@Test
	public <T> void floyd() {
		
		//gFloyd
		assertEquals(0,gFloyd.floyd());
		assertArrayEquals(new double[][]{{0.0,3.0, 4.0, 12.0, 7.0,10.0},
		{Double.POSITIVE_INFINITY,0.0,Double.POSITIVE_INFINITY, 10.0, 5.0,8.0},
		{Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,0.0, 8.0, 3.0,6.0},
		{Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY, 0.0,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY},
		{Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY, 5.0,0.0,3.0},
		{Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY, 2.0,Double.POSITIVE_INFINITY,0.0} },gFloyd.getFloydA());
		assertArrayEquals(new Object[][] { { null, null, null, 6, 3, 5 },
		{ null, null, null, 6, null, 5 },{ null, null, null, 6, null, 5 }, 
		{ null, null, null, null, null, null },{ null, null, null, 6, null, null },
		{ null, null, null, null, null, null }},gFloyd.getFloydP());
		
		//System.out.println(gFloyd.toString());
		
		
			//Ejemplo floyd Prácticas
			Graph<Integer> graph = new Graph<Integer>(5);
			
			graph.addNode(0);
			graph.addNode(1);
			graph.addNode(2);
			graph.addNode(3);
			graph.addNode(4);
			
			graph.addEdge(0, 1,100);
			graph.addEdge(0, 4,400);
			graph.addEdge(0, 2,20);
			graph.addEdge(0, 3,3);
			graph.addEdge(1, 4,41);
			graph.addEdge(3, 1,31);
			graph.addEdge(2, 1,12);
			
			
			assertEquals(0,graph.floyd());
			assertArrayEquals(new double[][]{{0.0,32.0, 20.0, 3.0, 73.0},
			{Double.POSITIVE_INFINITY,0.0,Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 41.0},
			{Double.POSITIVE_INFINITY,12.0,0.0, Double.POSITIVE_INFINITY, 53.0},
			{Double.POSITIVE_INFINITY,31.0,Double.POSITIVE_INFINITY, 0.0,72.0},
			{Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY,0.0} },graph.getFloydA());
			assertArrayEquals(new Object[][] { { null, 2, null, null, 2},
			{ null, null, null, null, null},{ null, null, null, null, 1}, 
			{ null, null, null, null, 1},{ null, null, null, null, null}},graph.getFloydP());
			
	}
	
	
	/**
	 * Pruebas para el método minCostPath
	 */
	@Test
	public <T> void testMinCostPath() {

		assertEquals(3., gFloyd.minCostPath(1, 2), 0.1);
		assertEquals(5., gFloyd.minCostPath(2, 5), 0.1);
		assertEquals(12., gFloyd.minCostPath(1, 4), 0.1);
		assertEquals(5., gFloyd.minCostPath(2, 5), 0.1);
		assertEquals(3., gFloyd.minCostPath(5, 6), 0.1);

		// Cuando no hay camino
		assertEquals(-1, gFloyd.minCostPath(4, 1), 0.1);
		// Cuando no existe el nodo inicial
		assertEquals(-1, gFloyd.minCostPath(8, 1), 0.1);
		// Cuando no existe el nodo destino
		assertEquals(-1, gFloyd.minCostPath(1, 8), 0.1);
		// Cuando no existen ambos nodos
		assertEquals(-1, gFloyd.minCostPath(8, 8), 0.1);
		// Nodo inicial null
		assertEquals(-1, gFloyd.minCostPath(null, 1), 0.1);
		// Nodo destino null
		assertEquals(-1, gFloyd.minCostPath(1, null), 0.1);
		// Ambos nodos null null
		assertEquals(-1, gFloyd.minCostPath(null, null), 0.1);

	}
	
	
	/**
	 * Pruebas para el método path
	 */
	@Test
	public <T> void testPath() {

		// Mostrar el camino entre nodos cuando existe camino
		assertEquals("1	(4.0)	3	(3.0)	5	(3.0)	6	(2.0)	4", gFloyd.path(1, 4));
		assertEquals("1	(3.0)	2", gFloyd.path(1, 2));
		assertEquals("6	(2.0)	4", gFloyd.path(6, 4));
		assertEquals("1	(4.0)	3", gFloyd.path(1, 3));

		// Mostrar el camino entre nodos cuando n existe camino
		assertEquals("6(Infinito)5", gFloyd.path(6, 5));
		assertEquals("3(Infinito)2", gFloyd.path(3, 2));

		// Mostrar el camino entre dos nodos iguales
		assertEquals("1", gFloyd.path(1, 1));

		// Mostrar el camino entre un nodo inicial inexistente y un nodo destino
		// existente
		assertEquals(null, gFloyd.path(666, 1));
		// Mostrar el camino entre un nodo inicial existente y un nodo destino
		// inexistente
		assertEquals(null, gFloyd.path(1, 666));
		// Mostrar el camino entre nodos inexistentes
		assertEquals(null, gFloyd.path(666, 999));
		// Mostrar el camino entre un nodo inicial null y un nodo destino
		// existente
		assertEquals(null, gFloyd.path(null, 1));
		// Mostrar el camino entre un nodo inicial existente y un nodo destino
		// null
		assertEquals(null, gFloyd.path(1, null));
		// Mostrar el camino entre dos nodos null
		assertEquals(null, gFloyd.path(null, null));

		 System.out.println(gFloyd.path(1, 4));
		// System.out.println(gFloyd.path(1, 2));
		// System.out.println(gFloyd.path(1, 1));
		// System.out.println(gFloyd.path(6, 5));
		// System.out.println(gFloyd.path(6, 4));
		// System.out.println(gFloyd.path(1, 3));
		// System.out.println(gFloyd.path(3, 2));

	}
}
