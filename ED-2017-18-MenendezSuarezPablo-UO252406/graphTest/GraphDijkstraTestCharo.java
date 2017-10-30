package graphTest;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import graphs.Graph;



public class GraphDijkstraTestCharo {

	@Test
	public void test() {
		System.out.println("Pruebas evaluación Dijkstra");
		Graph<String> G=new Graph<String>(8);
		// Insertar nodos
		for (int i=0;i<8;i++){
			assertEquals(0,G.addNode("Nodo "+(char)('A'+i)));			
		}
		
		assertEquals(G.addEdge("Nodo A","Nodo B", 8),0);
		assertEquals(G.addEdge("Nodo A","Nodo C", 9),0);
		assertEquals(G.addEdge("Nodo A","Nodo D", 5),0);
		assertEquals(G.addEdge("Nodo A","Nodo E", 9),0);
		
		assertEquals(G.addEdge("Nodo B","Nodo A", 3),0);
		assertEquals(G.addEdge("Nodo B","Nodo G", 2),0);
		assertEquals(G.addEdge("Nodo C","Nodo A", 2),0);
		assertEquals(G.addEdge("Nodo C","Nodo G", 5),0);
		assertEquals(G.addEdge("Nodo D","Nodo B", 9),0);
		assertEquals(G.addEdge("Nodo D","Nodo H", 1),0);
		assertEquals(G.addEdge("Nodo E","Nodo C", 6),0);
		assertEquals(G.addEdge("Nodo E","Nodo G", 3),0);
		assertEquals(G.addEdge("Nodo F","Nodo B", 6),0);
		assertEquals(G.addEdge("Nodo G","Nodo C", 5),0);
		assertEquals(G.addEdge("Nodo G","Nodo F", 6),0);
		assertEquals(G.addEdge("Nodo G","Nodo H", 6),0);
		assertEquals(G.addEdge("Nodo H","Nodo G", 7),0);
		System.out.println(G.toString());
		
		// Dijkstra
		double w[] = G.dijkstra("Nodo A");
		System.out.print("Dijkstra - Nodo A ->  [");
		for (int i=0; i<w.length-1; i++) System.out.print(w[i]+",");
		System.out.println(w[w.length-1]+"]");
		assertEquals(w[0],Float.POSITIVE_INFINITY,0.0001);
		assertEquals(w[1],8.0,0.0001);
		assertEquals(w[2],9.0,0.0001);
		assertEquals(w[3],5.0,0.0001);
		assertEquals(w[4],9.0,0.0001);
		assertEquals(w[5],16.0,0.0001);
		assertEquals(w[6],10.0,0.0001);
		assertEquals(w[7],6.0,0.0001);
	}

}
