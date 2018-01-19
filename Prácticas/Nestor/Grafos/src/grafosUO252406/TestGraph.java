package grafosUO252406;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGraph {
	/*
	 * Pruebas para el método addNodes
	 */
	@Test
	public <T> void testAddNodes() {
		Graph<Integer> graph = new Graph<Integer>(6);

		//Añadir un nodo que no existe al principio
		assertEquals(0,graph.getNumberOfNodes());
		assertEquals(0,graph.addNode(2));
		assertEquals(1,graph.getNumberOfNodes());
		//Añadir un nodo que no existe al final
		assertEquals(0,graph.addNode(3));
		assertEquals(2,graph.getNumberOfNodes());
		//Añadir un nodo que ya existe
		assertEquals(-1,graph.addNode(3));
		assertEquals(2,graph.getNumberOfNodes());
		//Añadir un nodo que no existe
		assertEquals(-1,graph.addNode(null));
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
		assertEquals(0,graph.addEdge(5.0, 6.0,50.0));
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

	
	/**
	 * Pruebas Dijkstra
	 */
	@Test
	public <T> void testDijkstra() {

		//Ejemplo Dijkstra clase, empezando por el nodo 0
		
		Graph<Integer> graph = new Graph<Integer>(5);
		
//		graph.addNode(0);
//		graph.addNode(1);
//		graph.addNode(2);
//		graph.addNode(3);
//		graph.addNode(4);
//		
//		graph.addEdge(0, 1,100);
//		graph.addEdge(0, 4,400);
//		graph.addEdge(0, 2,20);
//		graph.addEdge(0, 3,3);
//		graph.addEdge(1, 4,41);
//		graph.addEdge(3, 1,31);
//		graph.addEdge(2, 1,12);
	
		assertArrayEquals(new double[]{0.0, 32.0, 20.0, 3.0, 73.0}, graph.dijkstra(0), 0.0001);

		//Ejemplo teoría Dijkstra empezando desde el nodo 1
		Graph<Integer> graph2 = new Graph<Integer>(6);
		
		graph2.addNode(1);
		graph2.addNode(2);
		graph2.addNode(3);
		graph2.addNode(4);
		graph2.addNode(5);
		graph2.addNode(6);
		
		graph2.addEdge(1, 2,3);
		graph2.addEdge(1, 3,4);
		graph2.addEdge(1, 5,8);
		graph2.addEdge(2, 5,5);
		graph2.addEdge(3, 5,3);
		graph2.addEdge(5, 4,7);
		graph2.addEdge(5, 6,3);
		graph2.addEdge(6, 4,2);
		
		assertArrayEquals(new double[]{0.0,3.0, 4.0, 12.0, 7.0, 10.0}, graph2.dijkstra(1), 0.0001);

	
		//Ejemplo teoría de Dijkstra empezando desde el nodo 0
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
		  
		  assertArrayEquals(new double[]{0.0,3.0, 4.0, 1.0}, graph3.dijkstra(0), 0.0001);
		 
	
		//Ejemplo de  teoría de Dijkstra empezando desde el nodo 0
		  
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
		  
		    assertArrayEquals(new double[]{0.0,1.0, 5.0, 3.0, 6.0}, graph4.dijkstra(0), 0.0001);
		  
		  
		    //Test null
		    Graph<Integer> graph5 = new Graph<Integer>(6);
		   assertArrayEquals(null, graph5.dijkstra(null), 0.0001);
	}
		   
			/**
			 * Pruebas Floyd
			 */
			@Test
			public <T> void testFloyd() {
			
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
				
				graph.floyd();
				

				assertArrayEquals(new double[][]{{0.0,32.0, 20.0, 3.0, 73.0},
						{Double.POSITIVE_INFINITY,0.0,Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 41.0},
						{Double.POSITIVE_INFINITY,12.0,0.0, Double.POSITIVE_INFINITY, 53.0},
						{Double.POSITIVE_INFINITY,31.0,Double.POSITIVE_INFINITY, 0.0,72.0},
						{Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY,0.0} },graph.floyd());
				
			
				//Ejemplo floyd teoría
				Graph<Integer> graph2 = new Graph<Integer>(6);
				
				graph2.addNode(1);
				graph2.addNode(2);
				graph2.addNode(3);
				graph2.addNode(4);
				graph2.addNode(5);
				graph2.addNode(6);
				
				graph2.addEdge(1, 2,3);
				graph2.addEdge(1, 3,4);
				graph2.addEdge(1, 5,8);
				graph2.addEdge(2, 5,5);
				graph2.addEdge(3, 5,3);
				graph2.addEdge(5, 4,7);
				graph2.addEdge(5, 6,3);
				graph2.addEdge(6, 4,2);
				
				
//				graph2.floyd();
				assertArrayEquals(new double[][]{{0.0,3.0, 4.0, 12.0, 7.0,10.0},
						{Double.POSITIVE_INFINITY,0.0,Double.POSITIVE_INFINITY, 10.0, 5.0,8.0},
						{Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,0.0, 8.0, 3.0,6.0},
						{Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY, 0.0,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY},
						{Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY, 5.0,0.0,3.0},
						{Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY, 2.0,Double.POSITIVE_INFINITY,0.0} },graph2.floyd());
				}
				
			
			/**
			 * Pruebas path
			 */
			@Test
			public <T> void testPath() {
				//Pruebas para el grafo de prácticas
				
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
							
				
				assertEquals(73,graph.path(0,4),0.1);

				
				graph = new Graph<Integer>(5);
				
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
				assertEquals(32,graph.path(0,1),0.1);
				

				graph = new Graph<Integer>(5);
				
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

				assertEquals(20,graph.path(0,2),0.1);
				
				graph = new Graph<Integer>(5);
				
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

				assertEquals(53,graph.path(2,4),0.1);
				
				graph = new Graph<Integer>(5);
				
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

				assertEquals(72,graph.path(3,4),0.1);
				
				//Pruebas para un grafo de teoría
				
				Graph<Integer> graph2 = new Graph<Integer>(6);
				
				graph2.addNode(1);
				graph2.addNode(2);
				graph2.addNode(3);
				graph2.addNode(4);
				graph2.addNode(5);
				graph2.addNode(6);
				
				graph2.addEdge(1, 2,3);
				graph2.addEdge(1, 3,4);
				graph2.addEdge(1, 5,8);
				graph2.addEdge(2, 5,5);
				graph2.addEdge(3, 5,3);
				graph2.addEdge(5, 4,7);
				graph2.addEdge(5, 6,3);
				graph2.addEdge(6, 4,2);
				
			
				assertEquals(12,graph2.path(1,4),0.1);
				assertEquals(3,graph2.path(1,2),0.1);
				assertEquals(4,graph2.path(1,3),0.1);
				assertEquals(3,graph2.path(3,5),0.1);
				assertEquals(3,graph2.path(5,6),0.1);
			}
			
			
//			/**
//			 * Pruebas getNumberOfReturnNodesWithinCost
//			 */
//			@Test
//			public <T> void testGetNumberOfReturnNodesWithinCost() {
//				Graph<Integer> graph = new Graph<Integer>(5);
//				
//				graph.addNode(0);
//				graph.addNode(1);
//				graph.addNode(2);
//				graph.addNode(3);
//				graph.addNode(4);
//				
//				graph.addEdge(0, 1,3);
//				graph.addEdge(1, 0,5);
//				graph.addEdge(1, 2,7);
//				graph.addEdge(1, 3,20);
//				graph.addEdge(3, 1,10);
//				graph.addEdge(2, 3,20);
//				graph.addEdge(3, 4,10);
//				graph.addEdge(4, 3,8);
//				graph.addEdge(4, 0,1);
//				graph.addEdge(0, 4,1);
//				
//			try{	
//			assertEquals(5, graph.getNumberOfReturnNodesWithinCost(0, 100));	
//			assertEquals(4, graph.getNumberOfReturnNodesWithinCost(0, 40));	
//			}catch(Exception e){
//				e.printStackTrace();
//			}
//			}
//
//
//			/**
//			 * Pruebas getNumberOfReturnNodesWithinCost
//			 */
//			@Test
//			public <T> void testIsStronglyConnected() {
//				Graph<Integer> graph = new Graph<Integer>(5);
//				
//				graph.addNode(1);
//				graph.addNode(2);
//				graph.addNode(3);
//				graph.addNode(4);
//				
//				graph.addEdge(1, 2,3);
//				graph.addEdge(2, 3,5);
//				graph.addEdge(3, 4,7);
//				graph.addEdge(4, 1,20);
//				
//				assertEquals(true,graph.isStronglyConnected(1));
//
//			}
			
//			/**
//			 * Pruebas sacarAristaDeMayorPeso
//			 */
//			@Test
//			public <T> void testSacarAristaDeMayorPeso() {
//				Graph<Integer> graph = new Graph<Integer>(5);
//				
//				graph.addNode(0);
//				graph.addNode(1);
//				graph.addNode(2);
//				graph.addNode(3);
//				graph.addNode(4);
//				
//				graph.addEdge(0, 1,100);
//				graph.addEdge(0, 4,400);
//				graph.addEdge(0, 2,20);
//				graph.addEdge(0, 3,3);
//				graph.addEdge(1, 4,41);
//				graph.addEdge(3, 1,31);
//				graph.addEdge(2, 1,12);
//				
//			assertEquals(20,graph.sacarAristaDeMayorPeso(0,1),0.1);
//			assertEquals(41,graph.sacarAristaDeMayorPeso(0,4),0.1);
//			
//			
//			Graph<Integer> graph2 = new Graph<Integer>(6);
//			
//			graph2.addNode(1);
//			graph2.addNode(2);
//			graph2.addNode(3);
//			graph2.addNode(4);
//			graph2.addNode(5);
//			graph2.addNode(6);
//			
//			graph2.addEdge(1, 2,3);
//			graph2.addEdge(1, 3,4);
//			graph2.addEdge(1, 5,8);
//			graph2.addEdge(2, 5,5);
//			graph2.addEdge(3, 5,3);
//			graph2.addEdge(5, 4,7);
//			graph2.addEdge(5, 6,3);
//			graph2.addEdge(6, 4,2);
//			
//			assertEquals(4,graph2.sacarAristaDeMayorPeso(1,5),0.1);
//			assertEquals(4,graph2.sacarAristaDeMayorPeso(1,6),0.1);
//			assertEquals(8,graph2.sacarAristaDeMayorPeso(1,4),0.1);
//			}
//				

			
//			/**
//			 * Pruebas excentricidad
//			 */
//			@Test
//			public <T> void testExcentricidad() {
//				Graph<Integer> graph = new Graph<Integer>(5);
//				
//				graph.addNode(0);
//				graph.addNode(1);
//				graph.addNode(2);
//				graph.addNode(3);
//				graph.addNode(4);
//				
//				graph.addEdge(0, 1,100);
//				graph.addEdge(0, 4,400);
//				graph.addEdge(0, 2,20);
//				graph.addEdge(0, 3,3);
//				graph.addEdge(1, 4,41);
//				graph.addEdge(3, 1,31);
//				graph.addEdge(2, 1,12);
//				
//			assertEquals(73,graph.excentricidad(0),0.1);
//			assertEquals(41,graph.excentricidad(1),0.1);
//			assertEquals(53,graph.excentricidad(2),0.1);
//			assertEquals(72,graph.excentricidad(3),0.1);
//			assertEquals(0,graph.excentricidad(4),0.1);
//				
//			
//
//			Graph<Integer> graph2 = new Graph<Integer>(6);
//			
//			graph2.addNode(1);
//			graph2.addNode(2);
//			graph2.addNode(3);
//			graph2.addNode(4);
//			graph2.addNode(5);
//			graph2.addNode(6);
//			
//			graph2.addEdge(1, 2,3);
//			graph2.addEdge(1, 3,4);
//			graph2.addEdge(1, 5,8);
//			graph2.addEdge(2, 5,5);
//			graph2.addEdge(3, 5,3);
//			graph2.addEdge(5, 4,7);
//			graph2.addEdge(5, 6,3);
//			graph2.addEdge(6, 4,2);
//			
//			
//			
//	
//			assertEquals(12,graph2.excentricidad(1),0.1);
//			assertEquals(10,graph2.excentricidad(2),0.1);
//			assertEquals(8,graph2.excentricidad(3),0.1);
//			assertEquals(0,graph2.excentricidad(4),0.1);
//			assertEquals(5,graph2.excentricidad(5),0.1);
//			assertEquals(2,graph2.excentricidad(6),0.1);
//			
//			}
//			
//			/**
//			 * Pruebas diametro
//			 */
//			@Test
//			public <T> void testDiametro() {
//				Graph<Integer> graph = new Graph<Integer>(5);
//				
//				graph.addNode(0);
//				graph.addNode(1);
//				graph.addNode(2);
//				graph.addNode(3);
//				graph.addNode(4);
//				
//				graph.addEdge(0, 1,100);
//				graph.addEdge(0, 4,400);
//				graph.addEdge(0, 2,20);
//				graph.addEdge(0, 3,3);
//				graph.addEdge(1, 4,41);
//				graph.addEdge(3, 1,31);
//				graph.addEdge(2, 1,12);
//				
//				assertEquals(73,graph.diametro(),0.1);
//
//				Graph<Integer> graph2 = new Graph<Integer>(6);
//				
//				graph2.addNode(1);
//				graph2.addNode(2);
//				graph2.addNode(3);
//				graph2.addNode(4);
//				graph2.addNode(5);
//				graph2.addNode(6);
//				
//				graph2.addEdge(1, 2,3);
//				graph2.addEdge(1, 3,4);
//				graph2.addEdge(1, 5,8);
//				graph2.addEdge(2, 5,5);
//				graph2.addEdge(3, 5,3);
//				graph2.addEdge(5, 4,7);
//				graph2.addEdge(5, 6,3);
//				graph2.addEdge(6, 4,2);
//				
//				assertEquals(12,graph2.diametro(),0.1);
//			}
//
//			
//			/**
//			 * Pruebas gradoNodo
//			 */
//			@Test
//			public <T> void testMingrado() {
//				Graph<Integer> graph = new Graph<Integer>(5);
//				
//				graph.addNode(0);
//				graph.addNode(1);
//				graph.addNode(2);
//				graph.addNode(3);
//				graph.addNode(4);
//				
//				graph.addEdge(0, 1,100);
//				graph.addEdge(0, 4,400);
//				graph.addEdge(0, 2,20);
//				graph.addEdge(0, 3,3);
//				graph.addEdge(1, 4,41);
//				graph.addEdge(3, 1,31);
//				graph.addEdge(2, 1,12);
//			
//				assertEquals(0,graph.gradoNodo(0));
//				assertEquals(3,graph.gradoNodo(1));
//				
//			}
//			
//
//			/**
//			 * Pruebas mingrado
//			 */
//			@Test
//			public <T> void testMingrado() {
//				Graph<Integer> graph = new Graph<Integer>(5);
//				
//				graph.addNode(0);
//				graph.addNode(1);
//				graph.addNode(2);
//				graph.addNode(3);
//				graph.addNode(4);
//				
//				graph.addEdge(0, 1,100);
//				graph.addEdge(0, 4,400);
//				graph.addEdge(0, 2,20);
//				graph.addEdge(0, 3,3);
//				graph.addEdge(1, 4,41);
//				graph.addEdge(3, 1,31);
//				graph.addEdge(2, 1,12);
//				
//				assertEquals(0,graph.minGradoNodo());
//				
//				
//				Graph<Integer> graph2 = new Graph<Integer>(6);
//				
//				graph2.addNode(1);
//				graph2.addNode(2);
//				graph2.addNode(3);
//				graph2.addNode(4);
//				graph2.addNode(5);
//				graph2.addNode(6);
//				
//				graph2.addEdge(1, 2,3);
//				graph2.addEdge(1, 3,4);
//				graph2.addEdge(1, 5,8);
//				graph2.addEdge(2, 5,5);
//				graph2.addEdge(3, 5,3);
//				graph2.addEdge(5, 4,7);
//				graph2.addEdge(5, 6,3);
//				graph2.addEdge(6, 4,2);
//				
//				assertEquals(0,graph2.minGradoNodo());
//				
//			}
//			
//			
//			
//			/**
//			 * Pruebas maxGrado
//			 */
//			@Test
//			public <T> void testMaxgrado() {
//				Graph<Integer> graph = new Graph<Integer>(5);
//				
//				graph.addNode(0);
//				graph.addNode(1);
//				graph.addNode(2);
//				graph.addNode(3);
//				graph.addNode(4);
//				
//				graph.addEdge(0, 1,100);
//				graph.addEdge(0, 4,400);
//				graph.addEdge(0, 2,20);
//				graph.addEdge(0, 3,3);
//				graph.addEdge(1, 4,41);
//				graph.addEdge(3, 1,31);
//				graph.addEdge(2, 1,12);
//				
//				assertEquals(3,graph.maxGradoNodo());
//				
//				
//				Graph<Integer> graph2 = new Graph<Integer>(6);
//				
//				graph2.addNode(1);
//				graph2.addNode(2);
//				graph2.addNode(3);
//				graph2.addNode(4);
//				graph2.addNode(5);
//				graph2.addNode(6);
//				
//				graph2.addEdge(1, 2,3);
//				graph2.addEdge(1, 3,4);
//				graph2.addEdge(1, 5,8);
//				graph2.addEdge(2, 5,5);
//				graph2.addEdge(3, 5,3);
//				graph2.addEdge(5, 4,7);
//				graph2.addEdge(5, 6,3);
//				graph2.addEdge(6, 4,2);
//				
//				assertEquals(3,graph2.maxGradoNodo());
//				
//			}
}
	


